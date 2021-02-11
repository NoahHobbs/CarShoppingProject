package view;

import java.util.List;
import java.util.Scanner;

import controller.DetailsHelper;
import model.Details;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static DetailsHelper det = new DetailsHelper();
	

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the year the car was made: ");
		int year = in.nextInt();
		System.out.print("Enter the car model: ");
		String model = in.nextLine();
		System.out.print("Enter the car make: ");
		String make = in.nextLine();
		Details toAdd = new Details(year, make, model);
		det.insertItem(toAdd);

	}
	
	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the year to delete: ");
		int year = in.nextInt();
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
		System.out.print("Enter the make to delete: ");
		String make = in.nextLine();
		Details toDelete = new Details(year, model, make);
		//det.deleteItem(toDelete);

	}
	
	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Year");
		System.out.println("2 : Search by Make");
		System.out.println("3 : Search by Model");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Details> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the car year: ");
			int carYear = in.nextInt();
			foundItems = det.searchForCarByYear(carYear);
			
		} else if (searchBy == 2){
			System.out.print("Enter the car make: ");
			String carMake = in.nextLine();
			foundItems = det.searchForItemByItem(carMake);

		} else {
			System.out.print("Enter the car model: ");
			String carModel = in.nextLine();
			foundItems = det.searchForItemByItem(carModel);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Details d : foundItems) {
				System.out.println(d.getId() + " : " + d.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Details toEdit = det.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getYear() + " " + toEdit.getModel() + " " + toEdit.getMake());
			System.out.println("1 : Update Year");
			System.out.println("2 : Update Make");
			System.out.println("3 : Update Model");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Year: ");
				int newYear = in.nextInt();
				toEdit.setYear(newYear);
			} else if (update == 2) {
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			} else if (update == 3) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setMake(newModel);
			}

			det.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}
	
	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Details> allItems = det.showAllItems();
		for(Details singleItem : allItems) {
			System.out.println(singleItem.returnCarDetails());
		}
	}
	
	public static void runMenu() {
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
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				det.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
	}
}
