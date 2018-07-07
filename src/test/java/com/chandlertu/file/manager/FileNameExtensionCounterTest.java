package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FileNameExtensionCounterTest {

  public void count(Path path) {
    System.out.println(path);
    FileNameExtensionCounter.count(path);
  }

  @Test
  public void test() {
    count(Paths.get("D:\\Files\\Archives"));
    count(Paths.get("D:\\Files\\Documents"));
    count(Paths.get("D:\\Files\\Music"));
    count(Paths.get("D:\\Files\\Pictures"));
    count(Paths.get("D:\\Files\\Videos"));
  }

}
