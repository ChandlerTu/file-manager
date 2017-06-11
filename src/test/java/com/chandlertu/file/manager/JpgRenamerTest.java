package com.chandlertu.file.manager;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class JpgRenamerTest {

	@Test
	public void testRename() {
		Path path = Paths.get("D:\\Files\\jpg\\’’∆¨\\–°¿Ÿ\\2016_06");
		JpgRenamer.rename(path, "2016_06", "yyyy_MM");
	}

}
