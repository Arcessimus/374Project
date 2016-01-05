package ObserverPatternClasses;

import java.io.IOException;
import java.nio.file.Path;

public interface IAppLauncher {
	public String string();
	public Process process(Path p) throws IOException;

}
