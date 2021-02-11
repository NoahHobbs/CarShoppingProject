package model;

import
javax.persistence.Column;
import
javax.persistence.Entity;
import
javax.persistence.GeneratedValue;
import
javax.persistence.GenerationType;
import
javax.persistence.Id;
import
javax.persistence.Table;
@Entity
@Table(name="items")

public class Details {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="YEAR")
	private int year;
	@Column(name="MODEL")
	private String model;
	@Column(name="MAKE")
	private String make;
	
	public Details() {
		super();
	}
	
	public Details(int year, String model, String make) {
		super();
		this.year = year;
		this.model = model;
		this.make = make;
				
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

	public String returnCarDetails() {
		return year + ": " + model + ": " + make; 
	}
}
