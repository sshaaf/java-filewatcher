package com.ghub.utils.jafw.filewatcher.event;

import java.io.File;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *          The abstract for FileEvents.
 * 
 * 
 */

public abstract class AbstractFileEvent implements FileEvent {

    private File file = null;
    private File watcherFile = null;

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.event.FileEvent#getFileType()
     */
    public FileType getFileType() {
	if (file.isDirectory())
	    return FileType.DIR;
	else
	    return FileType.File;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.event.FileEvent#getEventType()
     */
    public abstract FileEventType getEventType();

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ghub.utils.jafw.filewatcher.event.FileEvent#setFile(java.io.File)
     */
    public void setFile(File file) {
	this.file = file;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ghub.utils.jafw.filewatcher.event.FileEvent#setWatcherFile(java.io
     * .File)
     */
    public void setWatcherFile(File watcherFile) {
	this.watcherFile = watcherFile;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.event.FileEvent#getWatcherFile()
     */
    public File getWatcherFile() {
	return watcherFile;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ghub.utils.jafw.filewatcher.event.FileEvent#getFile()
     */
    public File getFile() {
	return file;
    }

}
