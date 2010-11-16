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

public abstract class AbstractFileWatcher implements Runnable{

	protected boolean shouldStop = false;
	
	private File file = null; 
	private ArrayList<FileWatcherListener> listeners = new ArrayList<FileWatcherListener>();
	private AbstractFileListAdapter fileListAdapter = null;
	private FileFilter fileFilter = null;
	
	
	public AbstractFileWatcher(File file, AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
		this(file, fileListAdapter);
		this.fileFilter = fileFilter;
	}
	
	public AbstractFileWatcher(URI filePath, AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
		this(filePath, fileListAdapter);
		this.fileFilter = fileFilter;
	}
	
	public AbstractFileWatcher(File file, AbstractFileListAdapter fileListAdapter) {
		setWatchFile(file);
		this.fileListAdapter = fileListAdapter;
		init();
	}
	
	public AbstractFileWatcher(URI filePath, AbstractFileListAdapter fileListAdapter) {
		setWatchFile(file);
		this.fileListAdapter = fileListAdapter;
		init();
	}

	
	protected void init(){
		File[] temp = file.listFiles();
		for(int i=0; i<temp.length;i++){
				fileListAdapter.add(temp[i],temp[i].lastModified());
			}
	}
	/**
	 * SYSH: 
	 * TODO: Need to figure out where this method will belong.. :S
	 * TODO: If file is a directory need a recursive a function.
	 * */
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
	
	protected void setWatchFile(File file) {
		if(file == null)
			throw new IllegalArgumentException("Expected a non null URI");
		this.file = file;
	}
	
	protected void setWatchFile(URI filePath) {
		if(filePath == null)
			throw new IllegalArgumentException("Expected a non null URI");
		this.file = new File(filePath);
	}
	
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
	
	public void sendStopSignal(){
		shouldStop = true;
	}
	
	protected void addListener(FileWatcherListener listener){
		listeners.add(listener);
	}
	
	protected ArrayList<FileWatcherListener> getListeners() {
		return listeners;
	}

	protected void setFileListAdapter(AbstractFileListAdapter fileListAdapter){
		this.fileListAdapter = fileListAdapter;
	}
	
	protected AbstractFileListAdapter getFileListAdapter(){
		return this.fileListAdapter;
	}
	
	protected FileFilter getFileFilter() {
		return fileFilter;
	}

	protected void setFileFilter(FileFilter fileFilter) {
		this.fileFilter = fileFilter;
	}
	protected File getFile() {
		return file;
	}
	
	
}
