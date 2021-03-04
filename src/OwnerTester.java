

import java.util.List;

import controller.OwnerHelper;
import model.Owner;

public class OwnerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Owner greg = new Owner("Greg");
		OwnerHelper oh = new OwnerHelper();
		oh.insertOwners(greg);
		List<Owner> allOwners = oh.showAllOwners();
		for(Owner o: allOwners) {
			System.out.println(o.toString());
		}
	}

}
