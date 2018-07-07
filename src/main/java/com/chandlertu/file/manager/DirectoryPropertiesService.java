package com.chandlertu.file.manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.stereotype.Service;

@CommonsLog
@Service
public class DirectoryPropertiesService {

  public void addSubdirectoryProperties(Path entry, DirectoryProperties directoryProperties) {
    directoryProperties.getSubdirectoryProperties().add(getDirectoryProperties(entry));
  }

  public void countFiles(Path entry, DirectoryProperties directoryProperties) {
    String extension = getFileExtension(entry);
    Map<String, Long> map = directoryProperties.getFileCounts();
    Long count = map.get(extension);
    if (count == null) {
      count = 0L;
    }
    map.put(extension, count + 1);
  }

  public DirectoryProperties getDirectoryProperties(Path path) {
    DirectoryProperties directoryProperties = new DirectoryProperties();
    directoryProperties.setName(path.getFileName().toString());
    try (Stream<Path> entries = Files.list(path)) {
      entries.forEach(entry -> {
        if (entry.toFile().isFile()) {
          countFiles(entry, directoryProperties);
        } else {
          addSubdirectoryProperties(entry, directoryProperties);
        }
      });
    } catch (Exception e) {
      log.error("", e);
    }
    return directoryProperties;
  }

  public String getDirectoryPropertiesString(Path path) {
    DirectoryProperties directoryProperties = getDirectoryProperties(path);
    StringBuilder sb = new StringBuilder();
    sb.append(directoryProperties.getName());
    return sb.toString();
  }

  public String getFileExtension(Path path) {
    String fileName = path.getFileName().toString();
    int index = fileName.lastIndexOf('.');
    return index > 0 ? fileName.substring(index) : "";
  }

}
