package com.update;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

	public static File getJarPath() throws URISyntaxException {
		return new File(UpdateMain.class.getProtectionDomain().getCodeSource().getLocation().toURI());
	}
	
	public String checkBuildPath() throws IOException{
		File buildInfo = new File(UpdateMain._buildPath);
		float fileBuildNumber = 0;
		if(buildInfo.exists()){
			String build = checkBuildNumber(buildInfo.toPath());
			fileBuildNumber = Float.parseFloat(build);
			if(fileBuildNumber > UpdateMain._buildNumber){
				System.out.println("New version is available updateing...");
				updatingFile();
			}else{
				return null;
			}
		}else{
			System.err.println("missing build Info");
		}
		return null;
	}
	
	public String checkBuildNumber(Path buildInfo) throws IOException{
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(buildInfo, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	return line;
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return "0";
	}
	
	public void updatingFile(){
		
	}
}
