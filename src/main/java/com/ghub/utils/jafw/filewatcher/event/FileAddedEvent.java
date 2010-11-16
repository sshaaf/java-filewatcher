package com.ghub.utils.jafw.filewatcher.event;


public class FileAddedEvent extends AbstractFileEvent{

	@Override
	public FileEventType getEventType() {
		return FileEventType.Created;
	}

}
