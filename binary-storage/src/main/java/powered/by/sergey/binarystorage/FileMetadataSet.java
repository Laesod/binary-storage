package powered.by.sergey.binarystorage;

/*
 * #%L
 * ProjectX2013_03_23_JPA
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

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="FileMetadataSet")
@Table(name="fileMetadataSet")
public class FileMetadataSet {
	@Id
	@Column(name = "guid", length = 50)
	private String guid;	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt")	 
	private Date createdAt;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastModifiedAt")	
	private Date lastModifiedAt;		
	
	@Embedded
	private GeneralAttributes generalAttributes;
	
	@OneToMany(mappedBy="fileMetadataSet")
	private Collection<FileMetadata> fileMetadatas;
	
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}	
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}		
	
	public GeneralAttributes getGeneralAttributes() {
		return generalAttributes;
	}

	public void setGeneralAttributes(GeneralAttributes generalAttributes) {
		this.generalAttributes = generalAttributes;
	}
	
	public Collection<FileMetadata> getFileMetadatas() {
		return fileMetadatas;
	}	
	
	public void setFileMetadatas(Collection<FileMetadata> fileMetadatas) {
		this.fileMetadatas = fileMetadatas;
	}	
}
