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


import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

public class BinaryStorageBOInTableImpl implements BinaryStorageBO {

	@Override
	public byte[] getFile(String id) {
		return new FileStorageDAO().readFileByID(Long.parseLong(id)).getFile();
	}

	@Override
	public String saveFile(InputStream inputStream, HttpServletRequest req) {
		try {
			byte[] bytes = IOUtils.toByteArray(inputStream);
			return new FileStorageDAO().create(bytes).getRowId().toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteFile(String id) {
		new FileStorageDAO().deleteFileByID(Long.parseLong(id));
	}

	@Override
	public String createUploadUrl(String url) {
		return url;
	}

}
