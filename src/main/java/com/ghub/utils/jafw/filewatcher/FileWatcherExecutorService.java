package com.ghub.utils.jafw.filewatcher;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcher;
import com.ghub.utils.jafw.filewatcher.core.FileWatcherExecutor;

/**
 * @author github.com/shaaf
 * 
 * Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *  This is the default implementation for a ExecutorService specific to AbstractFilewWatcher
 */
public class FileWatcherExecutorService implements FileWatcherExecutor{

	private ArrayList<AbstractFileWatcher> watcherList = null;
	private ExecutorService service = null;
	
	/**
	 * Parameter less constructor
	 */
	public FileWatcherExecutorService() {
		watcherList = new ArrayList<AbstractFileWatcher>();
	}
	
	/**
	 * A pre intialized list of AbstratFileWatchers can be provided during initialisation.
	 * @param watcherList
	 */
	public FileWatcherExecutorService(ArrayList<AbstractFileWatcher> watcherList) {
		this.watcherList = watcherList;
	}
	
	/* (non-Javadoc)
	 * @see com.ghub.utils.jafw.filewatcher.core.FileWatcherExecutor#addFileWatcher(com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcher)
	 */
	public void addFileWatcher(AbstractFileWatcher fileWatcher){
		watcherList.add(fileWatcher);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		service = Executors.newFixedThreadPool(watcherList.size());
		for(AbstractFileWatcher watcher: watcherList)
			service.execute(watcher);
	}
	
	/* (non-Javadoc)
	 * @see com.ghub.utils.jafw.filewatcher.core.FileWatcherExecutor#shutdownAndAwaitTermination()
	 */
	public void shutdownAndAwaitTermination() {
			for(AbstractFileWatcher watcher: watcherList)
				watcher.sendStopSignal();
			service.shutdown(); 
			try {
				if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
					service.shutdownNow(); // Cancel currently executing tasks
					if (!service.awaitTermination(60, TimeUnit.SECONDS))
						System.err.println("Pool did not terminate");
				}
			} catch (InterruptedException ie) {
				service.shutdownNow();
				Thread.currentThread().interrupt();
			}
	}
	
}
