package com.ghub.utils.jafw.filewatcher.core;

import java.io.File;
import java.util.HashMap;

import com.ghub.utils.jafw.filewatcher.event.FileEventType;

public abstract class AbstractFileListAdapter {
	
	protected abstract long getLastModified(File file);
	protected abstract void setMap(HashMap<File, Long> masterFileMap);
	protected abstract FileEventType compareToMasterFile(File inProcessFile);
	protected abstract void add(File file);
	protected abstract void add(File file, Long lastModified);

}
