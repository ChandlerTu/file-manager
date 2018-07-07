package com.chandlertu.file.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectoryProperties {

  private Map<String, Long> fileCounts = new TreeMap<>();

  private int level;

  private String name;

  private List<DirectoryProperties> subdirectoryProperties = new ArrayList<>();

}
