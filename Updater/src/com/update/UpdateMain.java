package com.update;

import java.io.IOException;


public class UpdateMain {
	public static float _buildNumber = 1;
	public static String _buildPath = "D:/Sankar/Updater/build_info.txt";
	public static String _updatePath = "D:/Sankar/Updater/";
	public static String _jarName = "Updater.jar";
	
	public UpdateMain(String path,String build,String jarName){
		this._buildPath = path+build;
		this._updatePath = path;
		this._jarName = path + jarName;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(_buildNumber);
		
		UpdateChecker update = new UpdateChecker();
		update.checkBuild();
	}
}
