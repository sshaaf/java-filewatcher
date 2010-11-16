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


public class FileWatcherService extends AbstractFileWatcherService{

	private boolean isRunning = false;
	
	public FileWatcherService() {
		super(new FileWatcherExecutorService());
	}
	
	public FileWatcherService(FileWatcherExecutor executorService) {
		super(executorService);
	}

	@Override
	public synchronized void startAll() throws FileWatcherExecutorServiceException {
		if(!isRunning){
			thread = new Thread(executorService);
			thread.start();
			isRunning = true;
		}
		else
			throw new FileWatcherExecutorServiceException("An ExecutorService is already running on this instance.");
	}

	@Override
	public synchronized void stopAll() {
		executorService.shutdownAndAwaitTermination();
		thread.interrupt();
		isRunning = false;
	}

	@Override
	public void addFileWatcher(AbstractFileWatcher fileWatcher) {
		executorService.addFileWatcher(fileWatcher);
	}

	@Override
	public void addFileWathcer(File file, FileWatcherListener listener) {
		FileWatcher fileWatcher = new FileWatcher(file);
		fileWatcher.addListener(listener);
		addFileWatcher(fileWatcher);
	}

	@Override
	public void addFileWathcer(URI filePath, FileWatcherListener listener) {
		FileWatcher fileWatcher = new FileWatcher(filePath);
		fileWatcher.addListener(listener);
		addFileWatcher(fileWatcher);
	}
	
	@Override
	public void addFileWathcer(File file, FileWatcherListener listener,
			AbstractFileListAdapter fileListAdapter) {
		FileWatcher fileWatcher = new FileWatcher(file, fileListAdapter);
		fileWatcher.addListener(listener);
		addFileWatcher(fileWatcher);
		
	}

	@Override
	public void addFileWathcer(URI filePath, FileWatcherListener listener,
			AbstractFileListAdapter fileListAdapter) {
		FileWatcher fileWatcher = new FileWatcher(filePath, fileListAdapter);
		fileWatcher.addListener(listener);
		addFileWatcher(fileWatcher);
		
	}
	
	@Override
	public void addFileWathcer(URI filePath, FileWatcherListener listener,
			AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
		FileWatcher fileWatcher = new FileWatcher(filePath, fileListAdapter, fileFilter);
		fileWatcher.addListener(listener);
		addFileWatcher(fileWatcher);
		
	}

	@Override
	public void addFileWathcer(File file, FileWatcherListener listener,
			AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
		FileWatcher fileWatcher = new FileWatcher(file, fileListAdapter, fileFilter);
		fileWatcher.addListener(listener);
		addFileWatcher(fileWatcher);
		
	}

}
