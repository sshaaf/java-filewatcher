package com.ghub.utils.jafw.filewatcher;

import java.io.File;
import java.util.HashMap;

import com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter;
import com.ghub.utils.jafw.filewatcher.event.FileEventType;
/**
 * @author github.com/shaaf
 * 
 * Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *  A default file list adapter that keeps the file list in memory only. Thus a restart of the service means a complete re initialisation.
 * 
 */

public class DefaultFileListAdapter extends AbstractFileListAdapter{

	protected HashMap<File, Long> masterFileMap = null;

	/**
	 * Default parameterless constructor.
	 */
	public DefaultFileListAdapter() {
		this.masterFileMap = new HashMap<File, Long>();
	}
	
	/* (non-Javadoc)
	 * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter#add(java.io.File)
	 */
	@Override
	protected void add(File file) {
		masterFileMap.put(file, file.lastModified());
	}

	/* (non-Javadoc)
	 * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter#add(java.io.File, java.lang.Long)
	 */
	@Override
	protected void add(File file, Long lastModified) {
		masterFileMap.put(file, file.lastModified());
	}

	/* (non-Javadoc)
	 * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter#compareToMasterFile(java.io.File)
	 */
	@Override
	protected FileEventType compareToMasterFile(File inProcessFile){
		Long value = masterFileMap.get(inProcessFile);
		if(value != null){
			if(value < inProcessFile.lastModified())
				return FileEventType.Modified;
			else
				return FileEventType.UnChanged;
		}
		else
			return FileEventType.Created;
	}
	

	/* (non-Javadoc)
	 * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter#getLastModified(java.io.File)
	 */
	@Override
	protected long getLastModified(File file) {
		return masterFileMap.get(file);
	}

	/* (non-Javadoc)
	 * @see com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter#setMap(java.util.HashMap)
	 */
	@Override
	protected void setMap(HashMap<File, Long> masterFileMap) {
		this.masterFileMap = masterFileMap;
	}

}
