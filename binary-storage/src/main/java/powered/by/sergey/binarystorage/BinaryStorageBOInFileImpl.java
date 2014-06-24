package powered.by.sergey.binarystorage;

/*
 * #%L
 * ProjectX2013_03_23_web
 * %%
 * Copyright (C) 2013 - 2014 Powered by Sergey
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


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class BinaryStorageBOInFileImpl implements BinaryStorageBO {
	private final String filePath;

	BinaryStorageBOInFileImpl(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public byte[] getFile(String id) {
		File file = new File(filePath + id);
		return file2Bytes(file);
	}

	@Override
	public String saveFile(InputStream inputStream, HttpServletRequest req) {
		String fileName = UUID.randomUUID().toString().replace("-", "");
		String uploadedFileLocation = filePath + fileName;
		writeToFile(inputStream, uploadedFileLocation);	
		return fileName;
	}

	private byte[] file2Bytes(File file) {
		byte[] bFile = new byte[(int) file.length()];
		try {
            //convert file into array of bytes
			FileInputStream fileInputStream = new FileInputStream(file);
		    fileInputStream.read(bFile);
		    fileInputStream.close();
		    return bFile;
        } catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteFile(String id) {
		File file = new File(filePath + id);
		file.delete();
	}

	@Override
	public String createUploadUrl(String url) {
		return url;
	}

}
