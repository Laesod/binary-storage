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

import javax.persistence.EntityManager;

public class FileStorageDAO {

	public FileStorage readFileByID(Long id) {
		EntityManager em = PersistenceManager.createEntityManager();
		try {
			return em.find(FileStorage.class, id);
		} finally {
			em.close();
		}
	}

	public void deleteFileByID(Long id) {
		EntityManager em = PersistenceManager.createEntityManager();
		try {
			em.getTransaction().begin();
			
			FileStorage fs = em.find(FileStorage.class, id);
			em.remove(fs);
			
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}
	
	public FileStorage create(byte[] file) {
		EntityManager em = PersistenceManager.createEntityManager();
		try {
			em.getTransaction().begin();
			
			FileStorage fs = new FileStorage(); 
			fs.setFile(file);
			fs.setTimeStamp(new Date());
			em.persist(fs);
			
			em.getTransaction().commit();
			
			return fs;
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

}
