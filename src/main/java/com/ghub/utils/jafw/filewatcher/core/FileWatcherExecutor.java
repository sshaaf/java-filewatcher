package com.ghub.utils.jafw.filewatcher.core;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *          The interface defines the methods mandatory for a file watcher
 *          executor to have.
 * 
 * 
 */

public interface FileWatcherExecutor extends Runnable {

    /**
     * @param fileWatcher
     */
    public void addFileWatcher(AbstractFileWatcher fileWatcher);

    /**
	 * 
	 */
    public void shutdownAndAwaitTermination();

}
