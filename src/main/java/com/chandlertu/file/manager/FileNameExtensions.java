package com.chandlertu.file.manager;

import java.nio.file.Path;

public class FileNameExtensions {

	public static final String URL = ".url";

	public static final String MP4 = ".mp4";
	public static final String MOV = ".mov";

	public static final String JPG = ".jpg";
	public static final String PNG = ".png";
	public static final String GIF = ".gif";
	public static final String BMP = ".bmp";
	public static final String PSD = ".psd";

	public static final String FLAC = ".flac";
	public static final String WAV = ".wav";
	public static final String APE = ".ape";
	public static final String MP3 = ".mp3";

	public static String getFileNameExtension(Path path) {
		String s = path.getFileName().toString();
		int index = s.lastIndexOf(".");
		if (index > 0) {
			return s.substring(index);
		} else {
			return "";
		}
	}

}
