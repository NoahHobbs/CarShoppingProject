package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Details;

public class DetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("carShoppingProject");
	
	public void insertItem(Details det) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(det);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Details> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Details> allItems = em.createQuery("SELECT i FROM Details i").getResultList();
		return allItems;
	}
	
	public void updateItem(Details toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Details> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Details searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Details> searchForCarByYear(int carYear) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Details> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore", Details.class);
		typedQuery.setParameter("selectedYear", carYear);
		List<Details> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
