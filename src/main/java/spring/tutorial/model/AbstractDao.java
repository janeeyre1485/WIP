package spring.tutorial.model;

import java.io.Serializable;

import org.hibernate.Criteria;

public class AbstractDao<PK extends Serializable, T> {

	public void persist(T entity){
		
	}
	
	 protected Criteria createEntityCriteria(){
	        return null;
	    }
	 
}
