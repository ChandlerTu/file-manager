package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ParentPaths {

  public static final Path FILES = Paths.get("D:\\Files");

  public static final Path DOCUMENTS = FILES.resolve("Documents");

  public static final Path FAVORITES = FILES.resolve("Favorites");

  public static final Path MUSIC = FILES.resolve("Music");

  public static final Path PICTURES = FILES.resolve("Pictures");

  public static final Path VIDEOS = FILES.resolve("Videos");

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

  private ParentPaths() {
  }

}
