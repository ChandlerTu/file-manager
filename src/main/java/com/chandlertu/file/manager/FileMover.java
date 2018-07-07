package com.chandlertu.file.manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileMover {

  public static void move(Path path, boolean isPreview) {
    if (Files.isDirectory(path)) {
      try (Stream<Path> paths = Files.walk(path)) {
        paths.forEach(p -> moveFile(p, isPreview));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      moveFile(path, isPreview);
    }
  }

  private static void moveFile(Path path, boolean isPreview) {
    if (!Files.isDirectory(path)) {
      String fileNameExtension = FileNameExtensions.getFileNameExtension(path);
      String fileType = FileTypes.getFileType(fileNameExtension);
      Path parent = ParentPaths.getParentPath(fileType, fileNameExtension);
      if (!path.startsWith(parent)) {
        Path fileName = path.getFileName();
        Path target = parent.resolve(fileName);
        try {
          Files.createDirectories(parent);
          if (!isPreview) {
            Files.move(path, target);
          }
          System.out.println("source: " + path);
          System.out.println("target: " + target);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
