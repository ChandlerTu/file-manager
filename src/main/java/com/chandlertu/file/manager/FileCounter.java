package com.chandlertu.file.manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCounter {

  public static void count(Path parent) {
    try (Stream<Path> paths = Files.walk(parent)) {
      Map<Boolean, Long> map =
          paths.collect(Collectors.partitioningBy(Files::isDirectory, Collectors.counting()));
      long fileSize = map.get(false);
      long directorySize = map.get(true) - 1;
      System.out.println(fileSize + " ���ļ���" + directorySize + " ���ļ���");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
