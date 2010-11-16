package com.ghub.utils.jafw.filewatcher.core;

import java.io.File;

import com.ghub.utils.jafw.filewatcher.event.FileAddedEvent;
import com.ghub.utils.jafw.filewatcher.event.FileEvent;
import com.ghub.utils.jafw.filewatcher.event.FileEventType;
import com.ghub.utils.jafw.filewatcher.event.FileRemovedEvent;
import com.ghub.utils.jafw.filewatcher.event.FileUpdatedEvent;
import com.ghub.utils.jafw.filewatcher.exception.EventNotThrowable;


public class EventFactory{
	
	private static FileEvent create(FileEventType fileEventType) throws EventNotThrowable{
		if(FileEventType.Created == fileEventType)
			return new FileAddedEvent();
		else if(FileEventType.Modified == fileEventType) 
			return new FileUpdatedEvent();
		else if(FileEventType.Removed == fileEventType) 
			return new FileRemovedEvent();
		else 
			throw new EventNotThrowable();
		
	}
	
	public static FileEvent createEvent(File file, FileEventType fileEventType) throws EventNotThrowable {
		FileEvent event = create(fileEventType);
		if(fileEventType != FileEventType.Removed){
			event.setFile(file);
		}
		return event;
	}

	public static FileEvent createEvent(File watcherFile, File file, FileEventType fileEventType) throws EventNotThrowable {
		FileEvent event = create(fileEventType);
		if(fileEventType != FileEventType.Removed){
			event.setFile(file);
			event.setWatcherFile(watcherFile);
			
		}
		return event;	
	}
	
	public static FileEvent createEvent(FileEventType fileEventType) throws EventNotThrowable {
		return create(fileEventType);
	}
	
}
