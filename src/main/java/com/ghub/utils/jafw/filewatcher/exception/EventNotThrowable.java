package com.ghub.utils.jafw.filewatcher.exception;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *          Thrown when a file has not changed. Internal this is not propagated
 *          to the Service.
 * 
 * 
 */

@SuppressWarnings("serial")
public class EventNotThrowable extends FileWatcherGenericException {

    /**
     * @param msg
     */
    public EventNotThrowable(String msg) {
	super(msg);
    }

    public EventNotThrowable() {
	super("Can not throw event, file is unchanged!");
    }
}
