package com.chandlertu.file.manager;

import org.junit.Test;

public class FileNameExtensionRenamerTest {

	@Test
	public void test() {
		FileNameExtensionRenamer.rename(ParentPaths.FILES);
		FileNameExtensionCounter.count(ParentPaths.FILES);
	}

}
