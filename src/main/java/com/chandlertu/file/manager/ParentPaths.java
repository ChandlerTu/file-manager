package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ParentPaths {

	public static final Path FILES = Paths.get("C:\\�ļ�");
	public static final Path FAVORITES = FILES.resolve("�ղ�");
	public static final Path VIDEOS = FILES.resolve("��Ƶ");
	public static final Path PICTURES = FILES.resolve("ͼƬ");
	public static final Path DOCUMENTS = FILES.resolve("�ĵ�");
	public static final Path MUSIC = FILES.resolve("����");

	public static Path getParentPath(String fileType, String fileNameExtension) {
		switch (fileType) {
		case FileTypes.FAVORITE:
			return FAVORITES;
		case FileTypes.VIDEO:
			return VIDEOS;
		case FileTypes.PICTURE:
			return PICTURES;
		case FileTypes.MUSIC:
			return MUSIC;
		default:
			return DOCUMENTS.resolve(fileNameExtension.substring(1));
		}
	}

}
