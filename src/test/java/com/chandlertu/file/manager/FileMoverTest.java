package com.chandlertu.file.manager;

import org.junit.Test;

public class FileMoverTest {

	@Test
	public void test() {
		FileMover.move(ParentPaths.FILES);
		EmptyDirectoryCleaner.clean(ParentPaths.FILES);
	}

}
