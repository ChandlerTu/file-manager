package com.chandlertu.file.manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.stereotype.Service;

@CommonsLog
@Service
public class DirectoryPropertiesService {

  private String lineSeparator = System.getProperty("line.separator");

  private void addSubdirectoryProperties(Path entry, DirectoryProperties directoryProperties) {
    directoryProperties.getSubdirectoryProperties()
        .add(getDirectoryProperties(entry, directoryProperties.getLevel() + 1));
  }

  private void countFiles(Path entry, DirectoryProperties directoryProperties) {
    String extension = getFileExtension(entry);
    Map<String, Long> map = directoryProperties.getFileCounts();
    Long count = map.get(extension);
    if (count == null) {
      count = 0L;
    }
    map.put(extension, count + 1);
  }

  private DirectoryProperties getDirectoryProperties(Path path, int level) {
    DirectoryProperties directoryProperties = new DirectoryProperties();
    directoryProperties.setName(path.getFileName().toString());
    directoryProperties.setLevel(level);

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

  private String getString(DirectoryProperties directoryProperties) {
    StringBuilder sb = new StringBuilder();

    String tab = getTab(directoryProperties.getLevel());
    sb.append(tab);
    sb.append(directoryProperties.getName());
    sb.append(lineSeparator);

    List<DirectoryProperties> list = directoryProperties.getSubdirectoryProperties();
    list.forEach(p -> {
      sb.append(getString(p));
    });

    Map<String, Long> fileCounts = directoryProperties.getFileCounts();
    fileCounts.forEach((k, v) -> {
      sb.append(tab);
      sb.append("\t");
      sb.append(k);
      sb.append(" ");
      sb.append(v);
      sb.append(lineSeparator);
    });

    return sb.toString();
  }

  private String getTab(int level) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < level; i++) {
      sb.append("\t");
    }
    return sb.toString();
  }

  public String getDirectoryPropertiesString(Path path) {
    return lineSeparator + getString(getDirectoryProperties(path, 0));
  }

  private String getFileExtension(Path path) {
    String fileName = path.getFileName().toString();
    int index = fileName.lastIndexOf('.');
    return index > 0 ? fileName.substring(index) : "";
  }

}
