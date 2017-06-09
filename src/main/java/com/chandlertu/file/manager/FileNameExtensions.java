package com.chandlertu.file.manager;

import java.nio.file.Path;

public class FileNameExtensions {

	public static final String url = ".url";
	public static final String mp4 = ".mp4";
	public static final String jpg = ".jpg";
	public static final String png = ".png";
	public static final String flac = ".flac";
	public static final String wav = ".wav";
	public static final String ape = ".ape";

	public static String getFileNameExtension(Path path) {
		String s = path.toString();
		int index = s.lastIndexOf(".");
		if (index > 0) {
			return s.substring(index);
		} else {
			return "";
		}
	}

}
