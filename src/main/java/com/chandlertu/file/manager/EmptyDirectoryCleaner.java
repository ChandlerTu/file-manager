package com.chandlertu.file.manager;

import java.io.File;
import java.nio.file.Path;

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

	public static void clean(Path parent) {
		clean(parent.toFile());
	}

}
