package com.ghub.utils.jafw.filewatcher.core;

import java.io.File;
import java.net.URI;

import com.ghub.utils.jafw.filewatcher.event.FileWatcherListener;
import com.ghub.utils.jafw.filewatcher.exception.FileWatcherExecutorServiceException;
import com.ghub.utils.jafw.filewatcher.filter.FileFilter;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *          The abstract class is a service that watcher multiple Watcher
 *          directories.
 * 
 * 
 */
public abstract class AbstractFileWatcherService {

    protected FileWatcherExecutor executorService = null;
    protected Thread thread = null;

    public AbstractFileWatcherService() {
    }

    public AbstractFileWatcherService(FileWatcherExecutor executorService) {
	this.executorService = executorService;
    }

    /**
     * @param watcher
     */
    public abstract void addFileWatcher(AbstractFileWatcher watcher);

    /**
     * @param file
     * @param listener
     */
    public abstract void addFileWatcher(File file, FileWatcherListener listener);

    /**
     * @param filePath
     * @param listener
     */
    public abstract void addFileWatcher(URI filePath,
	    FileWatcherListener listener);

    /**
     * @param file
     * @param listener
     * @param fileListadapter
     */
    public abstract void addFileWatcher(File file,
	    FileWatcherListener listener,
	    AbstractFileListAdapter fileListadapter);

    /**
     * @param filePath
     * @param listener
     * @param fileListadapter
     * @param fileFilter
     */
    public abstract void addFileWatcher(URI filePath,
	    FileWatcherListener listener,
	    AbstractFileListAdapter fileListadapter, FileFilter fileFilter);

    /**
     * @param file
     * @param listener
     * @param fileListadapter
     * @param fileFilter
     */
    public abstract void addFileWatcher(File file,
	    FileWatcherListener listener,
	    AbstractFileListAdapter fileListadapter, FileFilter fileFilter);

    /**
     * @param filePath
     * @param listener
     * @param fileListadapter
     */
    public abstract void addFileWatcher(URI filePath,
	    FileWatcherListener listener,
	    AbstractFileListAdapter fileListadapter);

    /**
     * @throws FileWatcherExecutorServiceException
     */
    public abstract void startAll() throws FileWatcherExecutorServiceException;

    /**
	 * 
	 */
    public abstract void stopAll();

}
