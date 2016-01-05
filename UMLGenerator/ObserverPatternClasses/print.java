package ObserverPatternClasses;

public class print implements IDSubcriber{

	@Override
	public void handleDirectoryEvent(AbstractDWatcher watcher) {
		// TODO Auto-generated method stub
		System.out.println(watcher.getData().getFile().toString());
		
	}
	
}
