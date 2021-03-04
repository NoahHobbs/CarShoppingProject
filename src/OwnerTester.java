

import java.util.List;

import controller.ListDetailsHelper;
import controller.OwnerHelper;
import model.ListDetails;
import model.Owner;

public class OwnerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Owner cameron = new Owner("Cameron");
		OwnerHelper oh = new OwnerHelper();
		oh.insertOwners(cameron);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails cameronList = new ListDetails("Cameron's List", cameron);
		ldh.insertNewListDetails(cameronList);
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}

}
