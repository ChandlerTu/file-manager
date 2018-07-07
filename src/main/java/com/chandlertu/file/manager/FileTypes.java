package com.chandlertu.file.manager;

public class FileTypes {

  public static final String DOCUMENT = "document";

  public static final String FAVORITE = "favorite";

  public static final String MUSIC = "music";

  public static final String PICTURE = "picture";

  public static final String VIDEO = "video";

  public static String getFileType(String fileNameExtension) {
    switch (fileNameExtension) {
      case FileNameExtensions.URL:
        return FAVORITE;
      case FileNameExtensions.MP4:
      case FileNameExtensions.MOV:
        return VIDEO;
      case FileNameExtensions.JPG:
      case FileNameExtensions.PNG:
      case FileNameExtensions.GIF:
      case FileNameExtensions.BMP:
      case FileNameExtensions.PSD:
        return PICTURE;
      case FileNameExtensions.FLAC:
      case FileNameExtensions.WAV:
      case FileNameExtensions.APE:
      case FileNameExtensions.MP3:
        return MUSIC;
      default:
        return DOCUMENT;
    }
  }

}
