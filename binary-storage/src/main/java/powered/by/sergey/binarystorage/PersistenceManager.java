package powered.by.sergey.binarystorage;

/*
 * #%L
 * binary-storage
 * %%
 * Copyright (C) 2014 Powered by Sergey
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



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersistenceManager {
	
	public static final boolean DEBUG = true;
	private static final PersistenceManager singleton = new PersistenceManager();
	protected EntityManagerFactory emf;
	  
	public static PersistenceManager getInstance() {
		return singleton;
	}
	  
	private PersistenceManager() {
	}
	 
	public synchronized EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	 
	public synchronized void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	  
	public synchronized void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
			emf = null;
			if (DEBUG)
				System.out.println("n*** Persistence finished at " + new java.util.Date());
		}
	}

	public static EntityManager createEntityManager() {
		return PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
}
