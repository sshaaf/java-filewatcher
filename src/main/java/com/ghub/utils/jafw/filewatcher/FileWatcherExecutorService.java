package com.ghub.utils.jafw.filewatcher;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcher;
import com.ghub.utils.jafw.filewatcher.core.FileWatcherExecutor;


public class FileWatcherExecutorService implements FileWatcherExecutor{

	private ArrayList<AbstractFileWatcher> watcherList = null;
	private ExecutorService service = null;
	
	public FileWatcherExecutorService() {
		watcherList = new ArrayList<AbstractFileWatcher>();
	}
	
	public FileWatcherExecutorService(ArrayList<AbstractFileWatcher> watcherList) {
		this.watcherList = watcherList;
	}
	
	public void addFileWatcher(AbstractFileWatcher fileWatcher){
		watcherList.add(fileWatcher);
	}
	
	public void run() {
		service = Executors.newFixedThreadPool(watcherList.size());
		for(AbstractFileWatcher watcher: watcherList)
			service.execute(watcher);
	}
	
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
