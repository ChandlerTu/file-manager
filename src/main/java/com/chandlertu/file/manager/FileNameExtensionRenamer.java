package com.chandlertu.file.manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
			if (!fileNameExtensions.equals(lowerCase) || fileNameExtensions.equalsIgnoreCase(".jpeg")) {
				String s = path.toString();
				if (lowerCase.equals(".jpeg")) {
					lowerCase = ".jpg";
				}
				String targetPath = s.substring(0, s.length() - fileNameExtensions.length()) + lowerCase;
				File target = new File(targetPath);
				if (path.toFile().renameTo(target)) {
					System.out.println("source: " + path);
					System.out.println("target: " + targetPath);
				}
			}
		}
	}

	public static void main(String[] args) {
		Path path = Paths.get("D:\\source");
		rename(path);
		FileNameExtensionCounter.count(path);
	}

}
