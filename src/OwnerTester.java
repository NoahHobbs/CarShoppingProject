

import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.OwnerHelper;
import model.Details;
import model.ListDetails;
import model.Owner;

public class OwnerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Owner susan = new Owner("Susan");
		OwnerHelper oh = new OwnerHelper();
		ListDetailsHelper ldh = new ListDetailsHelper();
		Details camery = new Details(2004, "Camery", "Toyota");
		Details mustang = new Details(2004, "Mustang", "Camery");
		List<Details> susansItems = new ArrayList<Details>();
		susansItems.add(camery);
		susansItems.add(mustang);
		ListDetails susansList = new ListDetails("Susan's List", susan);
		susansList.setListOfCars(susansItems);
		ldh.insertNewListDetails(susansList);
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}

}
