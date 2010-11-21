package com.ghub.utils.jafw.filewatcher.core;

import java.io.File;

import com.ghub.utils.jafw.filewatcher.event.FileAddedEvent;
import com.ghub.utils.jafw.filewatcher.event.FileEvent;
import com.ghub.utils.jafw.filewatcher.event.FileEventType;
import com.ghub.utils.jafw.filewatcher.event.FileRemovedEvent;
import com.ghub.utils.jafw.filewatcher.event.FileUpdatedEvent;
import com.ghub.utils.jafw.filewatcher.exception.EventNotThrowable;

/**
 * @author github.com/shaaf
 * 
 * Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 * Creates an event for the watcher to throw
 * 
 * 
 */
public class EventFactory{
	
	/**
	 * @param fileEventType
	 * @return FileEvent
	 * @throws EventNotThrowable
	 */
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
	
	/**
	 * @param file
	 * @param fileEventType
	 * @return
	 * @throws EventNotThrowable
	 */
	public static FileEvent createEvent(File file, FileEventType fileEventType) throws EventNotThrowable {
		FileEvent event = create(fileEventType);
		if(fileEventType != FileEventType.Removed){
			event.setFile(file);
		}
		return event;
	}

	/**
	 * @param watcherFile
	 * @param file
	 * @param fileEventType
	 * @return
	 * @throws EventNotThrowable
	 */
	public static FileEvent createEvent(File watcherFile, File file, FileEventType fileEventType) throws EventNotThrowable {
		FileEvent event = create(fileEventType);
		if(fileEventType != FileEventType.Removed){
			event.setFile(file);
			event.setWatcherFile(watcherFile);
			
		}
		return event;	
	}
	
	/**
	 * @param fileEventType
	 * @return
	 * @throws EventNotThrowable
	 */
	public static FileEvent createEvent(FileEventType fileEventType) throws EventNotThrowable {
		return create(fileEventType);
	}
	
}
