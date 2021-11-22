package com.aidsystem.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
@Deprecated
public class UserInfo {
	private static int orgNum = 0;
	private static int donNum = 0;

	
	public void saveOrgInfo(int orgId) throws IOException {
		FileWriter fw = new FileWriter("user/orgId.ini", true);
//		fw.write(str);
		fw.close();
		orgNum++;
	}
	
	public void saveDonInfo(int donId) {
		donNum++;
	}
	
	public Set<Integer> getOrgInfo(){
		for (int i = 0; i < orgNum; i++) {
			
		}
		return null;
	}
	
	public Set<Integer> getDonInfo() {
		for (int i = 0; i < donNum; i++) {
			
		}
		return null;
	}



	

}
