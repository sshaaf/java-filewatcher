package com.ghub.utils.jafw.filewatcher.event;

import java.io.File;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *          The event is thrown when a file is removed.
 * 
 * 
 */

public class FileRemovedEvent extends AbstractFileEvent {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ghub.utils.jafw.filewatcher.event.AbstractFileEvent#getEventType()
     */
    @Override
    public FileEventType getEventType() {
	return FileEventType.Removed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.event.AbstractFileEvent#getFile()
     */
    @Override
    public File getFile() {
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ghub.utils.jafw.filewatcher.event.AbstractFileEvent#getFileType()
     */
    @Override
    public FileType getFileType() {
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ghub.utils.jafw.filewatcher.event.AbstractFileEvent#setFile(java.
     * io.File)
     */
    @Override
    public void setFile(File file) {
	throw new IllegalArgumentException(
		"I am not accepting files on a Delete event!");
    }

}
