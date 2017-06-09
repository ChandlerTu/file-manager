package com.chandlertu.file.manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DirectoryCounter {

	public static void count(Path parent) {
		try (Stream<Path> paths = Files.walk(parent)) {
			long count = paths.filter(Files::isDirectory).count();
			System.out.println(count + " ¸öÎÄ¼þ¼Ð");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
