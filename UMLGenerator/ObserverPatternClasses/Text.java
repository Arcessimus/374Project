package ObserverPatternClasses;

import java.io.IOException;
import java.nio.file.Path;

public class Text implements IAppLauncher {
	public String com = "notepad";
	
	@Override
	public String string() {
		// TODO Auto-generated method stub
		return this.com;
	}
	@Override
	public Process process(Path p) throws IOException {
		// TODO Auto-generated method stub
		return new ProcessBuilder(com,p.toString()).start();
	}
}
