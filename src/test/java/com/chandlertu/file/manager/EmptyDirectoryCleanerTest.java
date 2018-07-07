package com.chandlertu.file.manager;

import org.junit.Test;

public class EmptyDirectoryCleanerTest {

  @Test
  public void test() {
    EmptyDirectoryCleaner.clean(ParentPaths.FILES);
  }

}
