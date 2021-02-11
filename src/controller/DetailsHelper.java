package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Details;

public class DetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("carsShoppingProject");
	
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
	
	public void deleteItem(Details toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Details> typedQuery = em.createQuery("select det from Details det where det.year = :selectedYear and det.make = :selectedMake and det.model = :selectedModel", Details.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		Details result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<Details> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Details searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Details found = em.
		find(Details.class, idToEdit);
		em.close();
		return found;
	}

	public List<Details> searchForCarByYear(int carYear) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Details> typedQuery = em.createQuery("select det from Details det where det.year = :selectedYear", Details.class);
		typedQuery.setParameter("selectedYear", carYear);
		List<Details> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
