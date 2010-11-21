package com.ghub.utils.jafw.filewatcher.core;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

import com.ghub.utils.jafw.filewatcher.event.FileEvent;
import com.ghub.utils.jafw.filewatcher.event.FileEventType;
import com.ghub.utils.jafw.filewatcher.event.FileWatcherListener;
import com.ghub.utils.jafw.filewatcher.exception.EventNotThrowable;
import com.ghub.utils.jafw.filewatcher.filter.FileFilter;

/**
 * @author github.com/shaaf
 * 
 * Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 * Watches a single java.io.File
 * 
 * 
 */

public abstract class AbstractFileWatcher implements Runnable{

	protected boolean shouldStop = false;
	
	private File file = null; 
	private ArrayList<FileWatcherListener> listeners = new ArrayList<FileWatcherListener>();
	private AbstractFileListAdapter fileListAdapter = null;
	private FileFilter fileFilter = null;
	
	
	/**
	 * @param file
	 * @param fileListAdapter
	 * @param fileFilter
	 */
	public AbstractFileWatcher(File file, AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
		this(file, fileListAdapter);
		this.fileFilter = fileFilter;
	}
	
	/**
	 * @param filePath
	 * @param fileListAdapter
	 * @param fileFilter
	 */
	public AbstractFileWatcher(URI filePath, AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
		this(filePath, fileListAdapter);
		this.fileFilter = fileFilter;
	}
	
	/**
	 * @param file
	 * @param fileListAdapter
	 */
	public AbstractFileWatcher(File file, AbstractFileListAdapter fileListAdapter) {
		setWatchFile(file);
		this.fileListAdapter = fileListAdapter;
		init();
	}
	
	/**
	 * @param filePath
	 * @param fileListAdapter
	 */
	public AbstractFileWatcher(URI filePath, AbstractFileListAdapter fileListAdapter) {
		setWatchFile(file);
		this.fileListAdapter = fileListAdapter;
		init();
	}

	
	/**
	 * Initliazes the fileListAdapter and is invoked at the time of construction.
	 */
	protected void init(){
		File[] temp = file.listFiles();
		for(int i=0; i<temp.length;i++){
				fileListAdapter.add(temp[i],temp[i].lastModified());
			}
	}
	/**
	 * Shaaf 
	 * TODO: If file is a directory need a recursive a function.
	 * */
	/**
	 * This method does not have a recursive implementation for sub directories
	 * @param inProcessFiles
	 */
	protected void compare(File[] inProcessFiles){
		HashMap<File, Long> tempFileMap = new HashMap<File, Long>();
		for(int i=0; i<inProcessFiles.length;i++){
			FileEventType fileEventType = fileListAdapter.compareToMasterFile(inProcessFiles[i]);
			try{
				if(FileEventType.UnChanged != fileEventType)
					throwEvent(inProcessFiles[i], fileEventType);
			}
			catch(EventNotThrowable e){}
			
			tempFileMap.put(inProcessFiles[i], inProcessFiles[i].lastModified());
		}
		this.fileListAdapter.setMap(tempFileMap);
	}
	
	/**
	 * Set a watch file.
	 * @param file
	 */
	protected void setWatchFile(File file) {
		if(file == null)
			throw new IllegalArgumentException("Expected a non null URI");
		this.file = file;
	}
	
	/**
	 * set a watch file from URI.
	 * @param filePath
	 */
	protected void setWatchFile(URI filePath) {
		if(filePath == null)
			throw new IllegalArgumentException("Expected a non null URI");
		this.file = new File(filePath);
	}
	
	/**
	 * This method throws an event to all subscribers. Importantly this is not asynchronous from this point.
	 * @param file
	 * @param fileEventType
	 * @throws EventNotThrowable
	 */
	protected synchronized void throwEvent(File file,
			FileEventType fileEventType) throws EventNotThrowable {
		FileEvent event = EventFactory.createEvent(getFile(), file, fileEventType);
		if (event != null) {
			for (FileWatcherListener listener : listeners) {
				if (event.getEventType() == FileEventType.Created)
					listener.onFileCreated(event);
				if (event.getEventType() == FileEventType.Modified)
					listener.onFileModified(event);
				if(event.getEventType() == FileEventType.Removed)
					listener.onFileRemoved(event);
			}
		}
	}
	
	/**
	 * Stop the the watch thread.
	 */
	public void sendStopSignal(){
		shouldStop = true;
	}
	
	/**
	 * Add a new listener.
	 * @param listener
	 */
	protected void addListener(FileWatcherListener listener){
		listeners.add(listener);
	}
	
	/**
	 * Get the list of current listeners
	 * @return
	 */
	protected ArrayList<FileWatcherListener> getListeners() {
		return listeners;
	}

	/**
	 * Set a fileListAdapter.
	 * @param fileListAdapter
	 */
	protected void setFileListAdapter(AbstractFileListAdapter fileListAdapter){
		this.fileListAdapter = fileListAdapter;
	}
	
	/**
	 * @return AbstractFileListAdapter
	 */
	protected AbstractFileListAdapter getFileListAdapter(){
		return this.fileListAdapter;
	}
	
	/**
	 * @return FileFilter
	 */
	protected FileFilter getFileFilter() {
		return fileFilter;
	}

	/**
	 * @param fileFilter
	 */
	protected void setFileFilter(FileFilter fileFilter) {
		this.fileFilter = fileFilter;
	}
	/**
	 * @return
	 */
	protected File getFile() {
		return file;
	}
	
	
}
