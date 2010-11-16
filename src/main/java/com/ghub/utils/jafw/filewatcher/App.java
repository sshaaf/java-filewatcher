package com.ghub.utils.jafw.filewatcher;

import java.io.File;

import com.ghub.utils.jafw.filewatcher.event.FileEvent;
import com.ghub.utils.jafw.filewatcher.event.FileWatcherListener;
import com.ghub.utils.jafw.filewatcher.exception.FileWatcherExecutorServiceException;


/**
 * Hello world!
 *
 */
public class App 
{
	private final static String testPath = "/root/TestDIR";
	
    public static void main( String[] args ) throws InterruptedException, FileWatcherExecutorServiceException
    {
        System.out.println( "Hello World!" );
//        FileWatcher watcher = new FileWatcher(new File(".bachrc"));
//        Thread t = new Thread(watcher);
//        t.start();
//        Thread.sleep(1000);
//        watcher.sendStopSignal();
       // t.currentThread().interrupt();
        
        FileWatcherService service = new FileWatcherService();
        service.addFileWathcer(new File(testPath), new TestListener());
//        service.addFileWathcer(new File("/root"), new TestListener());
        service.startAll();        
    }
}

class TestListener implements FileWatcherListener{

	public void onFileCreated(FileEvent event) {
		System.out.println("File has been created "+event.getFile());
	}

	public void onFileModified(FileEvent event) {
		System.out.println("File has been updated! "+event.getFile());
	}

	public void onFileRemoved(FileEvent event) {
		System.out.println("File has been removed! "+event.getFile());
	}
	
	
}
