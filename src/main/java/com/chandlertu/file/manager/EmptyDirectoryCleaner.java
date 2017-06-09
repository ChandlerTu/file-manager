package com.chandlertu.file.manager;

import java.io.File;

public class EmptyDirectoryCleaner {

	public static void clean(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File subFile : files) {
				clean(subFile);
			}
			if (file.delete()) {
				System.out.println("É¾³ý£º" + file.getAbsolutePath());
			}
		}
	}

}
