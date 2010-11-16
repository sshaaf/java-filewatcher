package com.ghub.utils.jafw.filewatcher.core;



public interface FileWatcherExecutor extends Runnable{

	public void addFileWatcher(AbstractFileWatcher fileWatcher);

	public void shutdownAndAwaitTermination();
	
}
