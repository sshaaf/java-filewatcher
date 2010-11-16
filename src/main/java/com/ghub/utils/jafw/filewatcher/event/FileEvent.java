package com.ghub.utils.jafw.filewatcher.event;

import java.io.File;

public interface FileEvent {

	public FileType getFileType();
	
	public void setFile(File file);
	
	public void setWatcherFile(File watcherFile);
	
	public FileEventType getEventType();
	
	public File getFile();
	
	public File getWatcherFile();
}
