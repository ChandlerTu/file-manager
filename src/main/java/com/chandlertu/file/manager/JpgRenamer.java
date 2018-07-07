package com.chandlertu.file.manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class JpgRenamer {

  public static DateFormat destDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");

  public static Path parentPath = Paths.get("D:\\Files\\Pictures\\png2");

  public static File getDest(long destTime, File file) {
    String destTimeString = destDateFormat.format(new Date(destTime));
    String fileName = file.getName();
    String extension = fileName.substring(fileName.indexOf("."));
    String destName = destTimeString + "-" + file.length() + extension;
    return parentPath.resolve(destName).toFile();
  }

  public static long getDestTime(File file) {
    return file.lastModified();
  }

  public static long getDestTime(File file, String pattern) {
    long destTime;
    long fileNameTime = getFileNameTime(file.getName(), pattern);
    long lastModified = file.lastModified();
    if (fileNameTime < lastModified && fileNameTime != 0) {
      destTime = fileNameTime;
    } else {
      destTime = lastModified;
    }
    return destTime;
  }

  public static long getDestTime(File file, String time, String timePattern) {
    long destTime;

    long inputTime = getTime(time, timePattern);
    long lastModified = file.lastModified();
    if (inputTime < lastModified && inputTime != 0) {
      destTime = inputTime;
    } else {
      destTime = lastModified;
    }

    return destTime;
  }

  public static long getDestTime(File file, String pattern, String time, String timePattern) {
    long destTime = getDestTime(file, pattern);
    long inputTime = getTime(time, timePattern);
    if (inputTime < destTime && inputTime != 0) {
      destTime = inputTime;
    }
    return destTime;
  }

  public static long getFileNameTime(String fileName, String pattern) {
    String source = fileName.substring(0, pattern.length());
    return getTime(source, pattern);
  }

  public static long getTime(String source, String pattern) {
    long time = 0;
    DateFormat dateFormat = new SimpleDateFormat(pattern);
    try {
      time = dateFormat.parse(source).getTime();
    } catch (ParseException e) {
      log.error("", e);
    }
    return time;
  }

  public static void rename(File file, File dest) {
    File parent = dest.getParentFile();
    if (!parent.exists()) {
      parent.mkdirs();
    }

    if (file.renameTo(dest)) {
      System.out.println("file: " + file.getAbsolutePath());
      System.out.println("dest: " + dest.getAbsolutePath());
    } else {
      file.delete();
      System.err.println("file: " + file.getAbsolutePath());
    }
  }

  public static void rename(Path dir) {
    try (Stream<Path> paths = Files.walk(dir)) {
      paths.filter(path -> Files.isDirectory(path) == false)
          .forEach(path -> renameFile(path.toFile()));
    } catch (IOException e) {
      log.error("", e);
    }
  }

  public static void rename(Path dir, String pattern) {
    try (Stream<Path> paths = Files.walk(dir)) {
      paths.filter(path -> Files.isDirectory(path) == false)
          .forEach(path -> renameFile(path.toFile(), pattern));
    } catch (Exception e) {
      log.error("", e);
    }
  }

  public static void rename(Path dir, String time, String timePattern) {
    try (Stream<Path> paths = Files.walk(dir)) {
      paths.filter(path -> Files.isDirectory(path) == false)
          .forEach(path -> renameFile(path.toFile(), time, timePattern));
    } catch (IOException e) {
      log.error("", e);
    }
  }

  public static void rename(Path dir, String pattern, String time, String timePattern) {
    try (Stream<Path> paths = Files.walk(dir)) {
      paths.filter(path -> Files.isDirectory(path) == false)
          .forEach(path -> renameFile(path.toFile(), pattern, time, timePattern));
    } catch (IOException e) {
      log.error("", e);
    }
  }

  public static void renameFile(File file) {
    long destTime = getDestTime(file);
    rename(file, getDest(destTime, file));
  }

  public static void renameFile(File file, String pattern) {
    long destTime = getDestTime(file, pattern);
    rename(file, getDest(destTime, file));
  }

  public static void renameFile(File file, String time, String timePattern) {
    long destTime = getDestTime(file, time, timePattern);
    rename(file, getDest(destTime, file));
  }

  public static void renameFile(File file, String pattern, String time, String timePattern) {
    long destTime = getDestTime(file, pattern, time, timePattern);
    rename(file, getDest(destTime, file));
  }

}
