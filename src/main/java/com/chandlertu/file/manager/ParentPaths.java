package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ParentPaths {

	public static final Path files = Paths.get("C:\\�ļ�");
	public static final Path favorites = files.resolve("�ղ�");
	public static final Path videos = files.resolve("��Ƶ");
	public static final Path pictures = files.resolve("ͼƬ");
	public static final Path documents = files.resolve("�ĵ�");
	public static final Path music = files.resolve("����");

	public static Path getParentPath(String fileType, String fileNameExtension) {
		switch (fileType) {
		case FileTypes.favorite:
			return favorites;
		case FileTypes.video:
			return videos;
		case FileTypes.picture:
			return pictures;
		case FileTypes.music:
			return music;
		default:
			return documents.resolve(fileNameExtension.substring(1));
		}
	}

}
