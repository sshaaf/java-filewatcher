package com.ghub.utils.jafw.filewatcher.event;

public interface FileWatcherListener {

	public void onFileCreated(FileEvent event);
	
	public void onFileModified(FileEvent event);
	
	public void onFileRemoved(FileEvent event);
	
}
