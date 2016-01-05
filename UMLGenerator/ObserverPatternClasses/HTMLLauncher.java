package ObserverPatternClasses;

import java.io.IOException;
import java.nio.file.Path;

public class HTMLLauncher implements IAppLauncher{
	private String com = "explorer";
	
	
	public String string() {
		// TODO Auto-generated method stub
		return this.com;
	}

	public Process process(Path p) throws IOException {
		// TODO Auto-generated method stub
	 return new ProcessBuilder(com,p.toString()).start();
	}
	
}
