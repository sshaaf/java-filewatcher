package com.ghub.utils.jafw.filewatcher.event;

/**
 * @author github.com/shaaf
 * 
 * Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 * The event is thrown when a file is added.
 * 
 * 
 */
public class FileAddedEvent extends AbstractFileEvent{

	/* (non-Javadoc)
	 * @see com.ghub.utils.jafw.filewatcher.event.AbstractFileEvent#getEventType()
	 */
	@Override
	public FileEventType getEventType() {
		return FileEventType.Created;
	}

}
