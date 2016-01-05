package ObserverPatternClasses;

import java.io.IOException;

public  interface AbstractDWatcher extends Runnable{
	public  void addSubscriber(IDSubcriber s);
	public void remSubscriber(IDSubcriber s);
	public void setData(IDData s);
	public IDData getData();
	public void run();
	public void stopGracefully() throws IOException;
	public void addProcess(Process p);
	public void clearEverything();
	public boolean isRunning();
	public int getApplicationsCount();
	
}
