package com.update;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class UpdateChecker {
	public static File jarPath = null;
	
	FileReader fileReader = new FileReader();
	
	public void checkJarPath(){
		try {
			jarPath = FileReader.getJarPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void checkBuild() throws IOException {
		System.out.println("Checking for update");
		fileReader.checkBuildPath();
	}
}
