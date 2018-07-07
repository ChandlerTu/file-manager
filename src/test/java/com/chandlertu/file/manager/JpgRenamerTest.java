package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class JpgRenamerTest {

  @Test
  public void testRename() {
    Path path = Paths.get("D:\\Files\\Pictures\\png下划线");
    JpgRenamer.rename(path, "yyyy-MM-dd_HH-mm-ss");
  }

  @Test
  public void testRename2() {
    Path path = Paths.get("D:\\Files\\Pictures\\png空格");
    JpgRenamer.rename(path, "yyyy-MM-dd HH-mm-ss");
  }

  @Test
  public void testRename3() {
    Path path = Paths.get("D:\\Files\\Pictures\\png1");
    JpgRenamer.rename(path);
  }

  @Test
  public void testRename4() {
    Path path = Paths.get("D:\\Files\\Videos\\mov_");
    JpgRenamer.rename(path, "2016_06", "yyyy_MM");
  }

}
