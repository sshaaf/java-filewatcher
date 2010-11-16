package com.ghub.utils.jafw.filewatcher;

import java.io.File;

import com.ghub.utils.jafw.filewatcher.filter.FileFilter;


public class DefaultFileFilter implements FileFilter{

	public boolean accept(File dir, String name) {
		return true;
	}

}
