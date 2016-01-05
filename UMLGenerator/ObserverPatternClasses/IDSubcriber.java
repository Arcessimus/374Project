package ObserverPatternClasses;

public interface IDSubcriber {
	public void handleDirectoryEvent(AbstractDWatcher watcher);
}
