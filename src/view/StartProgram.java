package view;

import java.util.List;
import java.util.Scanner;

import controller.DetailsHelper;
import model.Details;

public class StartProgram {
	// class variable that I use to get user input 
	static Scanner in = new Scanner(System.in);
	// class variable that is an object of my DetailsHelper class so I can call methods from that class through this class
	static DetailsHelper det = new DetailsHelper();
	

	private static void addACar() {
		// this method adds a car to the database
		System.out.print("Enter the year the car was made: ");
		int year = in.nextInt();
		in.nextLine(); // this consumes the extra \n thrown by nextInt that was giving me a bug when having two nextLines after
		System.out.print("Enter the car model: ");
		String model = in.nextLine();
		System.out.print("Enter the car make: ");
		String make = in.nextLine();
		Details toAdd = new Details(year, make, model);
		det.insertCar(toAdd);

	}
	
	private static void deleteAnItem() {
		// this method will get the year, model and make of a car to delete 
		System.out.print("Enter the year to delete: ");
		int year = in.nextInt();
		in.nextLine(); // this consumes the extra \n thrown by nextInt that was giving me a bug when having two nextLines after
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
		System.out.print("Enter the make to delete: ");
		String make = in.nextLine();
		// saving the car that I want to delete as a new object
		Details toDelete = new Details(year, model, make);
		// passing the new object to my deleteItem method
		det.deleteItem(toDelete);

	}
	
	private static void editAnItem() {
		// TODO Auto-generated method stub
		// asking the user  how they want to search for the car they're trying to edit
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Year");
		System.out.println("2 : Search by Make");
		System.out.println("3 : Search by Model");
		//getting the user inputed answer from the console
		int searchBy = in.nextInt();
		in.nextLine(); // included to consume the extra \n because this was cause me issues else where so I'd rather be safe than sorry
		List<Details> foundItems;
		if (searchBy == 1) {
			//this part of the if-statement executes if the user entered search by year
			System.out.print("Enter the car year: ");
			//I won't need to grab the extra \n here because it won't cause any issues
			int carYear = in.nextInt();
			//calling my function from DetailsHelper that searches for a car based on its year
			foundItems = det.searchForCarByYear(carYear);
			
		} else if (searchBy == 2){
			// this part of the if-statement executes if the user entered search by make
			System.out.print("Enter the car make: ");
			String carMake = in.nextLine();
			System.out.println(carMake);
			//calling my function from DetailsHelper that searches for a car based on its make
			foundItems = det.searchForCarByMake(carMake);

		} else {
			// this part of the if-statement executes if the user entered search by model
			System.out.print("Enter the car model: ");
			String carModel = in.nextLine();
			System.out.println(carModel);
			//calling my function from DetailsHelper that searches for a car based on its model
			foundItems = det.searchForCarByModel(carModel);
		}

		if (!foundItems.isEmpty()) {
			// this if statement means if foundItems variable is not empty execute the body of the statement
			System.out.println("Found Results.");
			//for loop to get the id and convert to string in case there is more than one result found
			//such as if there happens to be multiple cars from 2020 it will print their id so you can select the one you are looking for
			for (Details d : foundItems) {
				System.out.println(d.getId() + " : " + d.toString());
			}
			// having the user choose which of the possible multiple returns they wish to edit
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			// again this line is included because I was getting a weird bug that put the inputs after on the same line and would break the program
			in.nextLine();
			//calling my method from DetailsHelper passing the id the user entered as a parameter
			Details toEdit = det.searchForCarById(idToEdit);
			// this next print statement shows the year, make and model of the car retrieved by id
			System.out.println("Retrieved " + toEdit.getYear() + " " + toEdit.getModel() + " " + toEdit.getMake());
			System.out.println("1 : Update Year");
			System.out.println("2 : Update Make");
			System.out.println("3 : Update Model");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				// update year
				System.out.print("New Year: ");
				int newYear = in.nextInt();
				toEdit.setYear(newYear);
			} else if (update == 2) {
				// update make
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			} else if (update == 3) {
				// update model
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			}

			det.updateItem(toEdit);

		} else {
			// this is called if the foundItems variable is empty
			System.out.println("---- No results found");
		}
	}
	
	private static void viewTheCars() {
		// This method shows all the cars currently in the database
		List<Details> allItems = det.showAllCars();
		for(Details singleItem : allItems) {
			System.out.println(singleItem.returnCarDetails());
		}
	}
	
	public static void main(String[] args) {
		runMenu();
	}
	
	public static void runMenu() {
		// this is the method which controls the program and is used as an interface for the user
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome car detail list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine(); // eating my \n

			if (selection == 1) {
				addACar();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheCars();
			} else {
				// calling my clean up method
				det.cleanUp();
				System.out.println("   See ya!   ");
				goAgain = false;
			}

		}
	}
}
