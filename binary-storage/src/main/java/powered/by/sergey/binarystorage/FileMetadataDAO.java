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


import java.util.List;

import javax.persistence.EntityManager;

public class FileMetadataDAO {

	public FileMetadata readFileByID(String id) {
		EntityManager em = PersistenceManager.createEntityManager();
		try {
			return em.find(FileMetadata.class, id);
		} finally {
			em.close();
		}
	}

	public void deleteFileByID(String id) {
		EntityManager em = PersistenceManager.createEntityManager();
		try {
			em.getTransaction().begin();

			FileMetadata fm = em.find(FileMetadata.class, id);
			em.remove(fm);
			
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}
  
	public void save(FileMetadata attachment) {
		EntityManager em = PersistenceManager.createEntityManager();
		try {
			em.getTransaction().begin();
			
			GeneralAttributes generalAttributes = new GeneralAttributes();
			generalAttributes.setIsDeleted(false);
			generalAttributes.setIsArchived(false);	
			attachment.setGeneralAttributes(generalAttributes);				
			
			em.persist(attachment);
			
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

	public List<FileMetadata> readByCatalogAndGroup(String catalogType, String catalogId, String groupId) {
		EntityManager em = PersistenceManager.createEntityManager();
		try {
			return em.createNamedQuery("FileMetadata.GetByCatalogAndGroup", FileMetadata.class)
				.setParameter("catalogType", catalogType)
				.setParameter("catalogId", catalogId)
				.setParameter("groupId", groupId)
				.getResultList();
		} finally {
			em.close();
		}
	}

}
