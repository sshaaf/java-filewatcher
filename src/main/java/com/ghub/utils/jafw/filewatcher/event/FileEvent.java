package com.ghub.utils.jafw.filewatcher.event;

import java.io.File;

/**
 * @author github.com/shaaf
 * 
 * Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 * The essentials for a FileEvent
 * 
 * 
 */

public interface FileEvent {

	/**
	 * @return
	 */
	public FileType getFileType();
	
	/**
	 * @param file
	 */
	public void setFile(File file);
	
	/**
	 * @param watcherFile
	 */
	public void setWatcherFile(File watcherFile);
	
	/**
	 * @return
	 */
	public FileEventType getEventType();
	
	/**
	 * @return
	 */
	public File getFile();
	
	/**
	 * @return
	 */
	public File getWatcherFile();
}
