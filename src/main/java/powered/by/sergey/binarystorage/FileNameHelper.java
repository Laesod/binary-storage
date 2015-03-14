package powered.by.sergey.binarystorage;

import java.io.IOException;
import java.util.Properties;

/*
 * #%L
 * ProjectX2013_03_23_web
 * %%
 * Copyright (C) 2013 - 2015 Powered by Sergey
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


public class FileNameHelper {
	
	public String extractMediaType(String fileExtention) {		
		return getPropertyValue(fileExtention.toLowerCase());
	}
	
	private String getPropertyValue(String key) {
		Properties prop = new Properties();
		try {
		    prop.load(FileNameHelper.class.getClassLoader().getResourceAsStream("media-type.properties"));
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public String extractExtention(String fileName) {
		if (fileName == null) {
			return null;
		}
		int index = fileName.lastIndexOf(".");
		if (index == -1) {
			return null;
		}
		return fileName.substring(index, fileName.length()).toLowerCase();
	}

}
