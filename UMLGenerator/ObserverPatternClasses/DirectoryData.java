package ObserverPatternClasses;

import java.nio.file.Path;

public class DirectoryData implements IDData {
	public String Name;
	public Path file;
	public DirectoryData(String name,Path file){
		this.file = file;
		this.Name = name;
	}
	public Path getFile(){
		return this.file;
	}
	public String getName(){
		return this.Name;
	}

}
