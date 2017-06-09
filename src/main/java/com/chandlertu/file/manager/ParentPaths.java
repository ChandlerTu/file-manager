package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ParentPaths {

	public static final Path files = Paths.get("C:\\文件");
	public static final Path favorites = files.resolve("收藏");
	public static final Path videos = files.resolve("视频");
	public static final Path pictures = files.resolve("图片");
	public static final Path documents = files.resolve("文档");
	public static final Path music = files.resolve("音乐");

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
