package com.chandlertu.file.manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.stereotype.Service;

@CommonsLog
@Service
public class DirectoryService {

  public Directory list(Path path) {
    Directory directory = new Directory();
    directory.setName(path.getFileName().toString());
    try (Stream<Path> entries = Files.list(path)) {
      entries.forEach(entry -> {
        if (entry.toFile().isFile()) {
          directory.addFile(entry);
        } else {
          directory.addSubdirectory(list(entry));
        }
      });
    } catch (Exception e) {
      log.error("", e);
    }
    return directory;
  }

}
