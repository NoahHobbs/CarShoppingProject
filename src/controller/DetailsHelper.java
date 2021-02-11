package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Details;


public class DetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("carsShoppingProject");
	
	public void insertCar(Details det) {
		// This method inserts cars into my database
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(det);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Details> showAllCars(){
		// this method gets all items inside my database puts them in a list and then returns them
		EntityManager em = emfactory.createEntityManager();
		List<Details> allCars = em.createQuery("SELECT i FROM Details i").getResultList();
		return allCars;
	}
	
	public void updateItem(Details toEdit) {
		// this is used to update the item in the database 
		//most of the logic for this method is inside the StartProgram file
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(Details toDelete) {
		// this method actually removes the record from the database
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Details> typedQuery = em.createQuery("select det from Details det where det.year = :selectedYear and det.make = :selectedMake and det.model = :selectedModel", Details.class);
		//Substitute parameter with actual data from the toDelete item method
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

	public List<Details> searchForCarByMake(String carMake) {
		/* 
		 * This method searches for a car in the database my its make
		 * The reason the data type for the function is list is because many cars can have one make 
		 * So the method needs to be able to return all cars of that make
		 */
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Details> typedQuery = em.createQuery("select det from Details det where det.make = :selectedMake", Details.class);
		typedQuery.setParameter("selectedMake", carMake);
		List<Details> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public Details searchForCarById(int idToEdit) {
		// This method searches for a car by ID this is used even if one of the other search methods is called
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Details found = em.
		find(Details.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Details> searchForCarByModel(String carModel) {
		// Searches for the car by model (See searchForCarByMake for a more detailed explanation)
		// returns a list in case there is more than one result found
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Details> typedQuery = em.createQuery("select det from Details det where det.model = :selectedModel", Details.class);
		typedQuery.setParameter("selectedModel", carModel);
		List<Details> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Details> searchForCarByYear(int carYear) {
		// searches for the car by year return type is List
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Details> typedQuery = em.createQuery("select det from Details det where det.year = :selectedYear", Details.class);
		typedQuery.setParameter("selectedYear", carYear);
		List<Details> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		// This is to close connections so they do not stay running
		emfactory.close();
	}

	
}
