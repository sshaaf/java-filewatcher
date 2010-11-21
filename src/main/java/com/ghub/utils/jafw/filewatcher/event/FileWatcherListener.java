package com.ghub.utils.jafw.filewatcher.event;

/**
 * @author github.com/shaaf
 * 
 * Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 * A listener when a FileEvent takes place.
 * 
 * 
 */

public interface FileWatcherListener {

	/**
	 * @param event
	 */
	public void onFileCreated(FileEvent event);
	
	/**
	 * @param event
	 */
	public void onFileModified(FileEvent event);
	
	/**
	 * @param event
	 */
	public void onFileRemoved(FileEvent event);
	
}
