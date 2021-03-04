package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne
	@JoinColumn(name="OWNER_ID")
	private Owner owner;
	private List<Details> listOfCars;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, Owner owner, List<Details> listOfCars) {
		super();
		this.id = id;
		this.listName = listName;
		this.owner = owner;
		this.listOfCars = listOfCars;
		
	}
	
	public ListDetails(String listName, Owner owner, List<Details> listOfCars) {
		super();
		this.listName = listName;
		this.owner = owner;
		this.listOfCars = listOfCars;
		
	}
	
	public ListDetails(String listName, Owner owner) {
		super();
		this.listName = listName;
		this.owner = owner;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		listName = listName;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<Details> getListOfCars() {
		return listOfCars;
	}
	public void setListOfCars(List<Details> listOfCars) {
		listOfCars = listOfCars;
	}
	
	
	
	
}
