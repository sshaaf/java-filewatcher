package com.ghub.utils.jafw.filewatcher.event;

public class FileUpdatedEvent extends AbstractFileEvent{

	@Override
	public FileEventType getEventType() {
		return FileEventType.Modified;
	}

}
