package com.chandlertu.file.manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@CommonsLog
@Service
public class FileManagerService {

  @Autowired
  private DirectoryService directoryService;

  public void dir(Path path) {
    Directory directory = directoryService.list(path);
    log.info(directory.toString());
  }

  public void countFileNameExtension(Path dir) {
    try (Stream<Path> paths = Files.walk(dir)) {
      Map<String, Long> map = paths.filter(p -> !p.toFile().isDirectory())
          .collect(Collectors.groupingBy(this::getFileNameExtension, Collectors.counting()));
      List<Entry<String, Long>> list = new ArrayList<>(map.entrySet());
      list.sort(Comparator.comparing(Entry::getValue));
      list.forEach(e -> log.info(e.getKey() + ": " + e.getValue()));
      log.info(list.size() + " 个扩展名");
    } catch (Exception e) {
      log.error("", e);
    }
  }

  public String getFileNameExtension(Path path) {
    String s = path.getFileName().toString();
    int index = s.lastIndexOf('.');
    if (index > 0) {
      return s.substring(index);
    } else {
      return "";
    }
  }

  public void moveFilePreview(Path path) {
    FileMover.move(path, true);
  }

}
