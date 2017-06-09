package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class EmptyDirectoryCleanerTest {

	@Test
	public void test() {
		Path path = Paths.get("C:\\нд╪Ч");
		EmptyDirectoryCleaner.clean(path.toFile());
	}

}
