package com.ghub.utils.jafw.filewatcher;

import java.io.File;

import com.ghub.utils.jafw.filewatcher.filter.FileFilter;

/**
 * @author github.com/shaaf
 * 
 *         Copyright (c) <2010>, <github.com/shaaf>
 * 
 * @version 1.0.0
 * 
 *          A default implementation of a file filter.
 * 
 * 
 */

public class DefaultFileFilter implements FileFilter {

    /*
     * (non-Javadoc)
     * 
     * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
     */
    public boolean accept(File dir, String name) {
	return true;
    }

}
