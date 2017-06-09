package com.chandlertu.file.manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileNameExtensionRenamer {

	public static void rename(Path parent) {
		try (Stream<Path> paths = Files.walk(parent)) {
			paths.filter(path -> Files.isDirectory(path) == false).forEach(FileNameExtensionRenamer::renameFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void renameFile(Path path) {
		String fileNameExtensions = FileNameExtensions.getFileNameExtension(path);
		if (!fileNameExtensions.isEmpty()) {
			String lowerCase = fileNameExtensions.toLowerCase();
			if (!fileNameExtensions.equals(lowerCase)) {
				String s = path.toString();
				String targetPath = s.substring(0, s.length() - lowerCase.length()) + lowerCase;
				File target = new File(targetPath);
				if (path.toFile().renameTo(target)) {
					System.out.println("source: " + path);
					System.out.println("target: " + targetPath);
				}
			}
		}
	}

}
