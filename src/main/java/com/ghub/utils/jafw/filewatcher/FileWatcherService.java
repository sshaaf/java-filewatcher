package com.ghub.utils.jafw.filewatcher;

import java.io.File;
import java.net.URI;

import com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter;
import com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcher;
import com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService;
import com.ghub.utils.jafw.filewatcher.core.FileWatcherExecutor;
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
 *          This class is a service to manage multiple AbstractFileWatcher/s
 * 
 */

public class FileWatcherService extends AbstractFileWatcherService {

    private boolean isRunning = false;

    /**
     * Default parameter less constructor
     */
    public FileWatcherService() {
	super(new FileWatcherExecutorService());
    }

    /**
     * An FileWatcherExecutor can be provided here. This is handy when a custom
     * executor is written.
     * 
     * @param executorService
     */
    public FileWatcherService(FileWatcherExecutor executorService) {
	super(executorService);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#startAll
     * ()
     */
    @Override
    public synchronized void startAll()
	    throws FileWatcherExecutorServiceException {
	if (!isRunning) {
	    thread = new Thread(executorService);
	    thread.start();
	    isRunning = true;
	} else
	    throw new FileWatcherExecutorServiceException(
		    "An ExecutorService is already running on this instance.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#stopAll()
     */
    @Override
    public synchronized void stopAll() {
	executorService.shutdownAndAwaitTermination();
	thread.interrupt();
	isRunning = false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#
     * addFileWatcher(com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcher)
     */
    @Override
    public void addFileWatcher(AbstractFileWatcher fileWatcher) {
	executorService.addFileWatcher(fileWatcher);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#
     * addFileWathcer(java.io.File,
     * com.ghub.utils.jafw.filewatcher.event.FileWatcherListener)
     */
    @Override
    public void addFileWatcher(File file, FileWatcherListener listener) {
	FileWatcher fileWatcher = new FileWatcher(file);
	fileWatcher.addListener(listener);
	addFileWatcher(fileWatcher);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#
     * addFileWathcer(java.net.URI,
     * com.ghub.utils.jafw.filewatcher.event.FileWatcherListener)
     */
    @Override
    public void addFileWatcher(URI filePath, FileWatcherListener listener) {
	FileWatcher fileWatcher = new FileWatcher(filePath);
	fileWatcher.addListener(listener);
	addFileWatcher(fileWatcher);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#
     * addFileWathcer(java.io.File,
     * com.ghub.utils.jafw.filewatcher.event.FileWatcherListener,
     * com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter)
     */
    @Override
    public void addFileWatcher(File file, FileWatcherListener listener,
	    AbstractFileListAdapter fileListAdapter) {
	FileWatcher fileWatcher = new FileWatcher(file, fileListAdapter);
	fileWatcher.addListener(listener);
	addFileWatcher(fileWatcher);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#
     * addFileWathcer(java.net.URI,
     * com.ghub.utils.jafw.filewatcher.event.FileWatcherListener,
     * com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter)
     */
    @Override
    public void addFileWatcher(URI filePath, FileWatcherListener listener,
	    AbstractFileListAdapter fileListAdapter) {
	FileWatcher fileWatcher = new FileWatcher(filePath, fileListAdapter);
	fileWatcher.addListener(listener);
	addFileWatcher(fileWatcher);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#
     * addFileWathcer(java.net.URI,
     * com.ghub.utils.jafw.filewatcher.event.FileWatcherListener,
     * com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter,
     * com.ghub.utils.jafw.filewatcher.filter.FileFilter)
     */
    @Override
    public void addFileWatcher(URI filePath, FileWatcherListener listener,
	    AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
	FileWatcher fileWatcher = new FileWatcher(filePath, fileListAdapter,
		fileFilter);
	fileWatcher.addListener(listener);
	addFileWatcher(fileWatcher);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcherService#
     * addFileWathcer(java.io.File,
     * com.ghub.utils.jafw.filewatcher.event.FileWatcherListener,
     * com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter,
     * com.ghub.utils.jafw.filewatcher.filter.FileFilter)
     */
    @Override
    public void addFileWatcher(File file, FileWatcherListener listener,
	    AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
	FileWatcher fileWatcher = new FileWatcher(file, fileListAdapter,
		fileFilter);
	fileWatcher.addListener(listener);
	addFileWatcher(fileWatcher);

    }

}
