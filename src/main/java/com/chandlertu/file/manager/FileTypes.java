package com.chandlertu.file.manager;

public class FileTypes {

	public static final String FAVORITE = "favorite";
	public static final String VIDEO = "video";
	public static final String PICTURE = "picture";
	public static final String DOCUMENT = "document";
	public static final String MUSIC = "music";

	public static String getFileType(String fileNameExtension) {
		switch (fileNameExtension) {
		case FileNameExtensions.URL:
			return FAVORITE;
		case FileNameExtensions.MP4:
			return VIDEO;
		case FileNameExtensions.JPG:
		case FileNameExtensions.PNG:
			return PICTURE;
		case FileNameExtensions.FLAC:
		case FileNameExtensions.WAV:
		case FileNameExtensions.APE:
			return MUSIC;
		default:
			return DOCUMENT;
		}
	}

}
