package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FileMoverTest {

	@Test
	public void test() {
		Path path = Paths.get("C:\\нд╪Ч");
		FileMover.move(path);
		EmptyDirectoryCleaner.clean(path);
	}

}
