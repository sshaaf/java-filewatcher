package com.ghub.utils.jafw.filewatcher.exception;

@SuppressWarnings("serial")
public class EventNotThrowable extends FileWatcherGenericException{

	public EventNotThrowable(String msg) {
		super(msg);
	}

	public EventNotThrowable() {
		super("Can not throw event, file is unchanged!");
	}
}
