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


import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class BinaryStorageBOInBlobStoreGAEImpl implements BinaryStorageBO {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@Override
	public byte[] getFile(String id) {
	    BlobKey blobKey = new BlobKey(id);
		return readBlobFully(blobKey);
	}

	@Override
	public String saveFile(InputStream inputStream, HttpServletRequest req) {
	    
		Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
	    if (blobs.keySet().isEmpty()) { 
	    	throw new RuntimeException("No File found"); 
	    }

	    Iterator<String> names = blobs.keySet().iterator();
	    String blobName = names.next();
	    BlobKey blobKey = blobs.get(blobName);
	    /*	    BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
	    BlobInfo blobInfo = blobInfoFactory.loadBlobInfo(blobKey);

	    String contentType = blobInfo.getContentType();
	    long size = blobInfo.getSize();
	    Date creation = blobInfo.getCreation();
	    String fileName = blobInfo.getFilename();

	    String title = req.getParameter("title");
	    String description = req.getParameter("description");
	    boolean isShared = "public".equalsIgnoreCase(req.getParameter("share"));
*/	    
		return blobKey.getKeyString();
	}

	@Override
	public void deleteFile(String id) {
	}
	
	public static byte[] readBlobFully(BlobKey blobKey) {

		BlobstoreService blobstoreService = BlobstoreServiceFactory
				.getBlobstoreService();
		BlobInfo blobInfo = new BlobInfoFactory().loadBlobInfo(blobKey);

		if (blobInfo == null)
			return null;

		if (blobInfo.getSize() > Integer.MAX_VALUE)
			throw new RuntimeException(
					"This method can only process blobs up to "
							+ Integer.MAX_VALUE + " bytes");

		int blobSize = (int) blobInfo.getSize();
		int chunks = (int) Math
				.ceil(((double) blobSize / BlobstoreService.MAX_BLOB_FETCH_SIZE));
		int totalBytesRead = 0;
		int startPointer = 0;
		int endPointer;
		byte[] blobBytes = new byte[blobSize];

		for (int i = 0; i < chunks; i++) {

			endPointer = Math.min(blobSize - 1, startPointer
					+ BlobstoreService.MAX_BLOB_FETCH_SIZE - 1);

			byte[] bytes = blobstoreService.fetchData(blobKey, startPointer,
					endPointer);

			for (int j = 0; j < bytes.length; j++)
				blobBytes[j + totalBytesRead] = bytes[j];

			startPointer = endPointer + 1;
			totalBytesRead += bytes.length;
		}

		return blobBytes;
	}

	@Override
	public String createUploadUrl(String url) {
		if (!url.startsWith("/")) {
			url = "/" + url;
		}
		return blobstoreService.createUploadUrl(url);
	}

}
