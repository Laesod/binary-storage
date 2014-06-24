package powered.by.sergey.binarystorage;

/*
 * #%L
 * ProjectX2013_03_23_JPA
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


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class FileStorage {
	@Transient   
	protected Object[] jdoDetachedState;  

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rowId;

	@Lob
	private byte[] file;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
