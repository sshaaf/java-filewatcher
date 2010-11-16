package com.ghub.utils.jafw.filewatcher.event;

import java.io.File;

public class FileRemovedEvent extends AbstractFileEvent{

	@Override
	public FileEventType getEventType() {
		return FileEventType.Removed;
	}

	@Override
	public File getFile() {
		return null;
	}

	@Override
	public FileType getFileType() {
		return null;
	}

	@Override
	public void setFile(File file) {
		throw new IllegalArgumentException("I am not accepting files on a Delete event!");
	}

}
