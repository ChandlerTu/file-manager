package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FileNameExtensionCounterTest {

	@Test
	public void test() {
		Path directory = Paths.get("C:\\�ļ�");
		FileNameExtensionCounter.count(directory);
	}

}
