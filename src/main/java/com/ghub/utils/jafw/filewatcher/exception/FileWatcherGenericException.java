package com.ghub.utils.jafw.filewatcher.exception;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 * 
 * 
 */

@SuppressWarnings("serial")
public abstract class FileWatcherGenericException extends Exception {

    public FileWatcherGenericException(String msg) {
	super(msg);
    }

    public FileWatcherGenericException() {
    }

}
