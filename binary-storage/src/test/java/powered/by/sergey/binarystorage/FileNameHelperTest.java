package powered.by.sergey.binarystorage;

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


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import powered.by.sergey.binarystorage.FileNameHelper;

public class FileNameHelperTest {
	@Test 
	public void extractExtention() {
		FileNameHelper fnh = new FileNameHelper();
		// positive
		assertThat(fnh.extractExtention("Marusya.jpg"), is(".jpg"));
		assertThat(fnh.extractExtention("Vasya.pdf"), is(".pdf"));
		// negative
		assertThat(fnh.extractExtention("Vasya"), is(nullValue()));
		assertThat(fnh.extractExtention("jpg"), is(nullValue()));
		assertThat(fnh.extractExtention("pdf"), is(nullValue()));
		// antisocial
		assertThat(fnh.extractExtention("Marusya.pdf.jpg"), is(".jpg"));
		assertThat(fnh.extractExtention("Vasya.jpj.pdf"), is(".pdf"));
		assertThat(fnh.extractExtention(""), is(nullValue()));
		assertThat(fnh.extractExtention("Marusya."), is("."));

	}
	@Test
	public void extractMediaType() {
		FileNameHelper fnh = new FileNameHelper();
		// positive
		assertThat(fnh.extractMediaType(".jpg"), is("image/jpeg"));
		assertThat(fnh.extractMediaType(".pdf"), is("application/pdf"));
		assertThat(fnh.extractMediaType(".png"), is("image/jpeg"));		
		// negative
		assertThat(fnh.extractMediaType(".docx"), is(nullValue()));
		// antisocial
		assertThat(fnh.extractMediaType(""), is(nullValue()));
		assertThat(fnh.extractMediaType("."), is(nullValue()));
	}
}
