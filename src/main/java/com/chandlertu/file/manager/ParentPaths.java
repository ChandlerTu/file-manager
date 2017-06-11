package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ParentPaths {

	public static final Path FILES = Paths.get("D:\\Files");
	public static final Path FAVORITES = FILES.resolve("�ղ�");
	public static final Path VIDEOS = FILES.resolve("��Ƶ");
	public static final Path PICTURES = FILES.resolve("ͼƬ");
	public static final Path DOCUMENTS = FILES.resolve("�ĵ�");
	public static final Path MUSIC = FILES.resolve("����");

	public static Path getParentPath(String fileType, String fileNameExtension) {
		String s = fileNameExtension.substring(1);
		switch (fileType) {
		case FileTypes.FAVORITE:
			return FAVORITES.resolve(s);
		case FileTypes.VIDEO:
			return VIDEOS.resolve(s);
		case FileTypes.PICTURE:
			return PICTURES.resolve(s);
		case FileTypes.MUSIC:
			return MUSIC.resolve(s);
		default:
			return DOCUMENTS.resolve(s);
		}
	}

}
