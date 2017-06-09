package com.chandlertu.file.manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileNameExtensionCounter {

	public static void count(Path parent) {
		try (Stream<Path> paths = Files.walk(parent)) {
			Map<String, Long> map = paths.filter(p -> Files.isDirectory(p) == false)
					.collect(Collectors.groupingBy(FileNameExtensions::getFileNameExtension, Collectors.counting()));
			List<Entry<String, Long>> list = new ArrayList<Entry<String, Long>>(map.entrySet());
			list.sort(Comparator.comparing(Entry::getValue));
			list.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
			System.out.println(list.size() + " ¸öÀ©Õ¹Ãû");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
