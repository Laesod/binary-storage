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

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GeneralAttributes {		
	@Column(name = "createdBy", length = 50, columnDefinition = "Varchar(50) default ''")
	private String createdBy;
	
	@Column(name = "lastModifiedBy", length = 50, columnDefinition = "Varchar(50) default ''")
	private String lastModifiedBy;	
	
	@Column(name = "isDeleted")
	private Boolean isDeleted;	
	
	@Column(name = "isArchived")
	private Boolean isArchived;	
	
	@Column(name = "sortingSequence", columnDefinition = "Integer default '0'")
	private Integer sortingSequence;	
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}	
	
	public Boolean getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Boolean isArchived) {
		this.isArchived = isArchived;
	}		
	
	public void setSortingSequence(Integer sortingSequence) {
		this.sortingSequence = sortingSequence;
	}
	
	public Integer getSortingSequence() {
		return sortingSequence;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}		
}