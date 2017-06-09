package com.chandlertu.file.manager;

public class FileTypes {

	public static final String favorite = "favorite";
	public static final String video = "video";
	public static final String picture = "picture";
	public static final String document = "document";
	public static final String music = "music";

	public static String getFileType(String fileNameExtension) {
		switch (fileNameExtension) {
		case FileNameExtensions.url:
			return favorite;
		case FileNameExtensions.mp4:
			return video;
		case FileNameExtensions.jpg:
		case FileNameExtensions.png:
			return picture;
		case FileNameExtensions.flac:
		case FileNameExtensions.wav:
		case FileNameExtensions.ape:
			return music;
		default:
			return document;
		}
	}

}
