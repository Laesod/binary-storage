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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="fileMetadata")
@NamedQuery(name = "FileMetadata.GetByCatalogAndGroup", query = "SELECT fmd FROM FileMetadata fmd WHERE fmd.catalogType = :catalogType AND fmd.catalogId = :catalogId AND fmd.groupId = :groupId")
public class FileMetadata {
	@Transient   
	protected Object[] jdoDetachedState;  

	@Id
	@Column(name = "guid", length = 50)
	private String guid;
	
	@Column(name = "fileMetadataSetGuid", length = 50, columnDefinition = "Varchar(50) default ''")
	private String fileMetadataSetGuid;		
	
	@Column(name = "originalFileName", length = 200, columnDefinition = "Varchar(200) default ''")
	private String originalFileName;
	
	@Column(name = "newFileName", length = 200, columnDefinition = "Varchar(200) default ''")
	private String newFileName;
	
	@Column(name = "fileExtention", length = 10, columnDefinition = "Varchar(10) default ''")
	private String fileExtention;
	
	@Column(name = "mediaType", length = 100, columnDefinition = "Varchar(100) default ''")
	private String mediaType;

	@Lob
	@Column(name = "descriptionEN", length = 500000)
	private String descriptionEN;
	
	@Lob
	@Column(name = "descriptionFR", length = 500000)
	private String descriptionFR;	
	
	@Column(name = "groupId", length = 50, columnDefinition = "Varchar(50) default ''")
	private String groupId;
	
	@Column(name = "catalogType", length = 50, columnDefinition = "Varchar(50) default ''")
	private String catalogType;
	
	@Column(name = "catalogId", length = 50, columnDefinition = "Varchar(50) default ''")
	private String catalogId;

	@Column(name = "size")
	private Long size;
	
	@Column(name = "fileStorageKey", length = 200, columnDefinition = "Varchar(200) default ''")
	private String fileStorageKey;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt")	 
	private Date createdAt;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastModifiedAt")	
	private Date lastModifiedAt;	
	
	@Embedded
	private FMGeneralAttributes generalAttributes;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fileMetadataSetGuid", insertable = false, updatable = false)
	private FileMetadataSet fileMetadataSet;		
	
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}	
	
	public String getFileMetadataSetGuid() {
		return fileMetadataSetGuid;
	}

	public void setFileMetadataSetGuid(String fileMetadataSetGuid) {
		this.fileMetadataSetGuid = fileMetadataSetGuid;
	}		

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public String getFileExtention() {
		return fileExtention;
	}

	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getDescriptionEN() {
		return descriptionEN;
	}

	public void setDescriptionEN(String descriptionEN) {
		this.descriptionEN = descriptionEN;
	}

	public String getDescriptionFR() {
		return descriptionFR;
	}

	public void setDescriptionFR(String descriptionFR) {
		this.descriptionFR = descriptionFR;
	}	
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(String catalogType) {
		this.catalogType = catalogType;
	}
	
	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getFileStorageKey() {
		return fileStorageKey;
	}

	public void setFileStorageKey(String fileStorageKey) {
		this.fileStorageKey = fileStorageKey;
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
	
	public FMGeneralAttributes getGeneralAttributes() {
		return generalAttributes;
	}

	public void setGeneralAttributes(FMGeneralAttributes generalAttributes) {
		this.generalAttributes = generalAttributes;
	}	
	
	public FileMetadataSet getFileMetadataSet() {
		return fileMetadataSet;
	}

	public void setFileMetadataSet(FileMetadataSet fileMetadataSet) {
		this.fileMetadataSet = fileMetadataSet;
	}	
}
