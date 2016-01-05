package ObserverPatternClasses;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.nio.file.StandardWatchEventKinds.*;

public class DWatcher implements AbstractDWatcher{
	private WatchService watcher;
	private List<Process> processes;
	private boolean bool;
	private Path dir;
	private List<IDSubcriber> observers;
	private IDData data;
	
	public DWatcher(Path dir) throws IOException{
		bool = true;
		this.dir = dir;
		this.processes = Collections.synchronizedList(new ArrayList<Process>());
		this.observers = Collections.synchronizedList(new ArrayList<IDSubcriber>());
		this.watcher = FileSystems.getDefault().newWatchService();
		dir.register(watcher,ENTRY_CREATE,ENTRY_DELETE,ENTRY_MODIFY);
	}
	
	/**
	 * Process all events for keys queued to the watcher
	 */
	public void run() {
		this.bool = false;
		while(!bool) {
			// Wait for key to be signalled
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException x) {
				return;
			}

			// Context for directory entry event is the file name of entry
			List<WatchEvent<?>> events = key.pollEvents();
			if(!events.isEmpty()) {
				@SuppressWarnings("unchecked")
				WatchEvent<Path> event = (WatchEvent<Path>)events.get(0);
				Path name = event.context();
				Path child = dir.resolve(name);

				// Call the handler method
				DirectoryData data = new DirectoryData(event.kind().name(),child);
				this.setData(data);
				
			}

			// Reset key and remove from set if directory no longer accessible
			if (!key.reset()) {
				break;
			}
		}

		// We gracefully stopped the service now, let's delete the temp file
		this.clearEverything();
	}

	@Override
	public void addSubscriber(IDSubcriber s) {
		// TODO Auto-generated method stub
		this.observers.add(s);
		
		
	}

	@Override
	public void remSubscriber(IDSubcriber s) {
		// TODO Auto-generated method stub
		this.observers.remove(s);
		
	}

	public void setData(IDData s) {
		// TODO Auto-generated method stub
		this.data = s;
		this.notifyObservers();
		
	}

	@Override
	public IDData getData() {
		// TODO Auto-generated method stub
		return this.data;
	}
	private void notifyObservers() {
		// TODO Auto-generated method stub
		synchronized(this.observers){
			for(IDSubcriber s:this.observers){
				s.handleDirectoryEvent(this);
			}
		}
		
	}

	@Override
	/**
	 * This method gracefully stops the WatchDir service.
	 * @throws IOException
	 */
	public void stopGracefully() throws IOException {
		this.bool = true;
		File file = new File(dir.toFile() + "/.temp");

		// Let's force the while loop in the run method to compe out of the blocking watcher.take() call here
		// You can also create a directory by calling file.mkdir()
		file.createNewFile();
	}

	@Override
	public void addProcess(Process p) {
		// TODO Auto-generated method stub
		
		this.processes.add(p);
	}


	/**
	 * This method is for internal use to delete the temporary file created by
	 * the {@link #clearEverything()} method. As well as to kill all of the newly
	 * created process.
	 */
	public void clearEverything() {
		File file = new File(dir.toFile() + "/.temp");
		file.delete();
		
		for(Process p: this.processes) {
			p.destroy();
		}
	}

	@Override
	/**
	 * Returns true if the launcher is running, otherwise false.
	 */
	public boolean isRunning() {
		return !bool;
	}
	

	@Override
	public int getApplicationsCount() {
		// TODO Auto-generated method stub
		return this.processes.size();
	}
}
