package ObserverPatternClasses;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Display {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Path dir = Paths.get("./input_output");
		Map<String, IAppLauncher> map = new HashMap<String, IAppLauncher>();
		map.put("txt", new Text());
		map.put("html", new HTMLLauncher());
		map.put("htm", new HTMLLauncher());
		AppLauncher launcher = new AppLauncher(map);
		DWatcher watcher = new DWatcher(dir);
		watcher.addSubscriber(launcher);

		IDSubcriber sub = new print();
		watcher.addSubscriber(sub);

		Thread t = new Thread(watcher);
		t.start();

		System.out.format("Launcher started watching %s ...%nPress the return key to stop ...", dir);

		// Wait for an input
		System.in.read();
		t.join();
		watcher.stopGracefully();

		System.out.println("Directory watching stopped ...");
	}

}
