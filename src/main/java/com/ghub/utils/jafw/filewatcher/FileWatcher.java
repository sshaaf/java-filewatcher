package com.ghub.utils.jafw.filewatcher;

import java.io.File;
import java.net.URI;

import com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter;
import com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcher;
import com.ghub.utils.jafw.filewatcher.event.FileWatcherListener;
import com.ghub.utils.jafw.filewatcher.filter.FileFilter;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *          The class is the default implementation for a filewatcher on a
 *          single File object.
 * 
 */
public class FileWatcher extends AbstractFileWatcher {

    /**
     * @param file
     */
    public FileWatcher(File file) {
	super(file, new DefaultFileListAdapter());
	setFileFilter(new DefaultFileFilter());
    }

    /**
     * @param filePath
     */
    public FileWatcher(URI filePath) {
	super(filePath, new DefaultFileListAdapter());
	setFileFilter(new DefaultFileFilter());
    }

    /**
     * accepts a File path, you can add your own FileListAdapter here e.g.
     * database? and a FileFilter for files that should be filtered when
     * processing the watch.
     * 
     * @param file
     * @param fileListAdapter
     * @param fileFilter
     */
    public FileWatcher(File file, AbstractFileListAdapter fileListAdapter,
	    FileFilter fileFilter) {
	super(file, fileListAdapter);
	setFileFilter(fileFilter);
    }

    /**
     * accepts a URI file path, you can add your own FileListAdapter here e.g.
     * database? and a FileFilter for files that should be filtered when
     * processing the watch.
     * 
     * @param filePath
     * @param fileListAdapter
     * @param fileFilter
     */
    public FileWatcher(URI filePath, AbstractFileListAdapter fileListAdapter,
	    FileFilter fileFilter) {
	super(filePath, fileListAdapter);
	setFileFilter(fileFilter);
    }

    /**
     * accepts a File, you can add your own FileListAdapter here e.g. database?
     * 
     * @param file
     * @param fileListAdapter
     */
    public FileWatcher(File file, AbstractFileListAdapter fileListAdapter) {
	super(file, fileListAdapter);
	setFileFilter(new DefaultFileFilter());
    }

    /**
     * accepts a URI file path, you can add your own FileListAdapter here e.g.
     * database?
     * 
     * @param filePath
     * @param fileListAdapter
     */
    public FileWatcher(URI filePath, AbstractFileListAdapter fileListAdapter) {
	super(filePath, fileListAdapter);
	setFileFilter(new DefaultFileFilter());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcher#addListener(
     * com.ghub.utils.jafw.filewatcher.event.FileWatcherListener)
     */
    public void addListener(FileWatcherListener listener) {
	super.addListener(listener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {
	while (!shouldStop) {
	    compare(getFile());
	}

    }

}
