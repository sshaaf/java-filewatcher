package com.ghub.utils.jafw.filewatcher.core;

import java.io.File;
import java.net.URI;

import com.ghub.utils.jafw.filewatcher.event.FileWatcherListener;
import com.ghub.utils.jafw.filewatcher.exception.FileWatcherExecutorServiceException;
import com.ghub.utils.jafw.filewatcher.filter.FileFilter;


public abstract class AbstractFileWatcherService{

	protected FileWatcherExecutor executorService = null;
	protected Thread thread = null;
	
	public AbstractFileWatcherService(){
	}
	
	public AbstractFileWatcherService(FileWatcherExecutor executorService) {
		this.executorService = executorService;
	}
	
	public abstract void addFileWatcher(AbstractFileWatcher watcher);
	public abstract void addFileWathcer(File file, FileWatcherListener listener);
	public abstract void addFileWathcer(URI filePath, FileWatcherListener listener);
	public abstract void addFileWathcer(File file, FileWatcherListener listener, AbstractFileListAdapter fileListadapter);
	public abstract void addFileWathcer(URI filePath, FileWatcherListener listener, AbstractFileListAdapter fileListadapter, FileFilter fileFilter);
	public abstract void addFileWathcer(File file, FileWatcherListener listener, AbstractFileListAdapter fileListadapter, FileFilter fileFilter);
	public abstract void addFileWathcer(URI filePath, FileWatcherListener listener, AbstractFileListAdapter fileListadapter);
	public abstract void startAll() throws FileWatcherExecutorServiceException;
	public abstract void stopAll();
	
}
