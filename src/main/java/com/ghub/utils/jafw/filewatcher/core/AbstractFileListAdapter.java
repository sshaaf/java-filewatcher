package com.ghub.utils.jafw.filewatcher.core;

import java.io.File;
import java.util.HashMap;

import com.ghub.utils.jafw.filewatcher.event.FileEventType;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *          The abstract class is an interface to hold the list of files in a
 *          watcher directory.
 * 
 * 
 */
public abstract class AbstractFileListAdapter {

    /**
     * Gets the file.lastModified() from java.io.File
     * 
     * @param file
     * @return long
     */
    protected abstract long getLastModified(File file);

    /**
     * Set a preinitialized map.
     * 
     * @param masterFileMap
     */
    protected abstract void setMap(HashMap<File, Long> masterFileMap);

    /**
     * Compare the File in parameter to the one in the Map. and makes a decision
     * if its created or modified. Delete is unimplemented at this time.
     * 
     * @param inProcessFile
     * @return
     */
    protected abstract FileEventType compareToMasterFile(File inProcessFile);

    /**
     * Add a file to the map.
     * 
     * @param file
     */
    protected abstract void add(File file);

    /**
     * Put a file in the map with the lastModified time. This will offcourse be
     * overwritten the first time an update operation is checked.
     * if(lastModified < inComing.lastModified())
     * 
     * @param file
     * @param lastModified
     */
    protected abstract void add(File file, Long lastModified);

}
