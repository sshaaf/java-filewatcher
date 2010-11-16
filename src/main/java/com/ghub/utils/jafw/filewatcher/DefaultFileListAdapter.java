package com.ghub.utils.jafw.filewatcher;

import java.io.File;
import java.util.HashMap;

import com.ghub.utils.jafw.filewatcher.core.AbstractFileListAdapter;
import com.ghub.utils.jafw.filewatcher.event.FileEventType;


public class DefaultFileListAdapter extends AbstractFileListAdapter{

	protected HashMap<File, Long> masterFileMap = null;

	public DefaultFileListAdapter() {
		this.masterFileMap = new HashMap<File, Long>();
	}
	
	@Override
	protected void add(File file) {
		masterFileMap.put(file, file.lastModified());
	}

	@Override
	protected void add(File file, Long lastModified) {
		masterFileMap.put(file, file.lastModified());
	}

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
	

	@Override
	protected long getLastModified(File file) {
		return masterFileMap.get(file);
	}

	@Override
	protected void setMap(HashMap<File, Long> masterFileMap) {
		this.masterFileMap = masterFileMap;
	}

}
