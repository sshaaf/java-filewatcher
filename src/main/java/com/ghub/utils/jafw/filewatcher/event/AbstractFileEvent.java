package com.ghub.utils.jafw.filewatcher.event;

import java.io.File;


public abstract class AbstractFileEvent implements FileEvent{

	private File file = null;
	private File watcherFile = null;
	
	public FileType getFileType() {
		if(file.isDirectory())
			return FileType.DIR;
		else
			return FileType.File;
	}


	public abstract FileEventType getEventType();
	

	public void setFile(File file) {
		this.file = file;
	}


	public void setWatcherFile(File watcherFile) {
		this.watcherFile = watcherFile;
	}
	

	public File getWatcherFile() {
		return watcherFile;
	}
	

	public File getFile() {
		return file;
	}
	
}
