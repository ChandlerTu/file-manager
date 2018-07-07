package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Directory {

  private Map<String, Long> fileCount = new HashMap<>();

  private String name;

  private List<Directory> subdirectories = new ArrayList<>();

  public void addFile(Path path) {

  }
  
  

  public void addSubdirectory(Directory subdirectory) {
    subdirectories.add(subdirectory);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name);
    return sb.toString();
  }

}
