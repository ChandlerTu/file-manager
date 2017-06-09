package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class FilenameExtensionsTest {

	@Test
	public void test() {
		Path path = Paths.get("C:\\ÎÄ¼þ\\Í¼Æ¬\\ÎÒ.txt");
		String fileNameExtension = FileNameExtensions.getFileNameExtension(path);
		Assert.assertEquals(".txt", fileNameExtension);
	}

}
