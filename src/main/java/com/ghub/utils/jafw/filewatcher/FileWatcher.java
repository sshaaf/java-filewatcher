package com.ghub.utils.jafw.filewatcher;

import java.io.File;
import java.net.URI;

import com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter;
import com.ghub.utils.jafw.filewatcher.core.AbstractFileWatcher;
import com.ghub.utils.jafw.filewatcher.event.FileWatcherListener;
import com.ghub.utils.jafw.filewatcher.filter.FileFilter;


public class FileWatcher extends AbstractFileWatcher{


	public FileWatcher(File file) {
		super(file, new DefaultFileListAdapter());
		setFileFilter(new DefaultFileFilter());
	}
	
	public FileWatcher(URI filePath) {
		super(filePath, new DefaultFileListAdapter());
		setFileFilter(new DefaultFileFilter());
	}
	
	public FileWatcher(File file, AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
		super(file,fileListAdapter);
		setFileFilter(fileFilter);
	}
	
	public FileWatcher(URI filePath, AbstractFileListAdapter fileListAdapter, FileFilter fileFilter) {
		super(filePath, fileListAdapter);
		setFileFilter(fileFilter);
	}
	
	public FileWatcher(File file, AbstractFileListAdapter fileListAdapter) {
		super(file, fileListAdapter);	
		setFileFilter(new DefaultFileFilter());
	}
	
	public FileWatcher(URI filePath, AbstractFileListAdapter fileListAdapter) {
		super(filePath, fileListAdapter);
		setFileFilter(new DefaultFileFilter());
	}
	
	public void addListener(FileWatcherListener listener){
		super.addListener(listener);
	}
	
	public void run() {	
		while(!shouldStop){
			if(getFile().isDirectory()){
				File file = new File(getFile().getAbsolutePath());
				if(getFileFilter() != null)
					compare(file.listFiles(getFileFilter()));
				else
					compare(file.listFiles());
			}
		}
		
	}
	
}
