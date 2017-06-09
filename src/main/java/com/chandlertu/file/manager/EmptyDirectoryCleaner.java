package com.chandlertu.file.manager;

import java.io.File;

public class EmptyDirectoryCleaner {

	public static void clean(File parent) {
		if (parent.isDirectory()) {
			File[] files = parent.listFiles();
			for (File file : files) {
				clean(file);
			}
			if (parent.delete()) {
				System.out.println("É¾³ý£º" + parent.getAbsolutePath());
			}
		}
	}

}
