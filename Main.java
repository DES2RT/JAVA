import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Exceptions.DateFormatException;
import Exceptions.RentPeriodException;

public class Main {

    public static void main(String[] args) 
    		throws FileNotFoundException, DateFormatException, RentPeriodException {
    	
        /* TASK 1 - build labs from files - at least two labs */
        System.out.println("\n\n * TASK 1 * \nBuilding 3 Labs from 3 files \n");
        
		// create Labs
		Labs labs = new Labs(3);
        Lab newnham = new Lab("Newnham");
		Lab york = new Lab("York");
		Lab king = new Lab("King");
		
        // add devices to labs, devices are read from file and added to labs inventory
		newnham = labs.addDevicesToLab("Newnham", "NewnhamLab.txt");
		york = labs.addDevicesToLab("York", "YorkLab.txt");
		king = labs.addDevicesToLab("King", "KingLab.txt");
		
		// assign labs to the array
		labs.labsArray[0] = newnham;
		labs.labsArray[1] = york;
		labs.labsArray[2] = king;
		
		// print out the labs and their inventory
		System.out.println(labs);
		System.out.println("\nTASK 1 COMPLETE ==============================================>>>\n\n");	
/*		
        // TASK 2 - ask for a device that is not in any lab inventory 

        System.out.println("\n\n *" + " TASK 2 " + "*\nAsking for a device NOT found in any inventory ");
		MobileDevice unknown = new MobileDevice("Unknown", 0);
		Lab temp = new Lab("temp");
		temp = labs.isThereDeviceInLabs(unknown);
		System.out.println("\nTASK 2 COMPLETE ==============================================>>>\n\n");	
*/
         // TASK 3 - ask for a device that is in a lab inventory
           // - issue a rent request and print the device
           // - issue the same rent request and print the device
           // - return the device
           // - issue the rent request with new dates and print the device
         
        System.out.println("\n\n *" + " TASK 3 " + "*");
		// ask for a device that is in a labs inventory
		System.out.println("Ask for a device that is in a labs inventory =================================>>>");
		MobileDevice md = new MobileDevice("Android", 25);
		labs.isThereDeviceInLabs(md);
		System.out.print("\n\n");

		// issue a rent request and print the device object
		System.out.println("Issue a rent request and print the device object ============================>>>");
		//MobileDevice mdev = new MobileDevice("iPhone2", 65);
		Lab labby = new Lab("labby");
		System.out.println("Issue Rent Request " + md.deviceName());
		String requestDate = "07/01/2017";
		String dueDate = "07/14/2017";
		labby = labs.rentDeviceAvailable(md, requestDate, dueDate);
 		System.out.println(md.lab + "\n\n");
 		System.out.println(york);
 		System.out.println(king);

 		// issue the same rent request and print the device object
 		System.out.println("Issue the same rent request and print the device object =====================>>>");
 		MobileDevice md2 = new MobileDevice("Android", 25);
 		Lab lab2 = new Lab("temp");
 		md2.setLab(lab2);
 		System.out.println("Issue request for " + md2.deviceName());
 		lab2 = labs.rentDeviceAvailable(md2, requestDate, dueDate);
 		System.out.println(md2.lab);
 		System.out.println(york);
 		System.out.println(king);
 
 		// return the device
 		System.out.println("Returning the device and printing device object =============================>>>");
 		md.returnDevice(labby);
 		System.out.println(md.lab);
 		System.out.println(york);
 		System.out.println(king);
 		
 		// issue rent request again with new dates and print the device object
 		System.out.println("Issue rent request again with new dates and print the devicd object ===========>>");
 		labby = labs.rentDeviceAvailable(md, "12/25/2016", "12/31/2016");
 		System.out.println(md.lab);
 		System.out.println(york);
 		System.out.println(king);
 		
 		// issue rent request again with new dates and print the device object
 		System.out.println("Issue rent request again with new dates and print the devicd object ===========>>");
 		labby = labs.rentDeviceAvailable(md, "12/25/2016", "12/31/2016");
 		System.out.println(md.lab);
 		System.out.println(york);
 		System.out.println(king);
 		System.out.println("\nTASK 3 COMPLETE ==============================================>>>\n\n");	

        /*
 	
 	 	// TASK 4 - ask for the same device in all labs
 			// - look for the same device in all labs and return all the labs where the device is in the lab inventory
 			// - look for the same device in all labs and return all the labs where the device is available to be rented.
		System.out.println("Ask for device in all labs,\n\tPrint a list of Lab's with device in its inventory, and"
				+ "\n\t Print a list of Lab's with device available to rent ===================>>>");
		MobileDevice tempDevice = new MobileDevice("Blackberry10", 20);
		Lab lab = null;
		lab = labs.isThereDeviceInLabs(tempDevice);
		System.out.println("\nTASK 4 COMPLETE ==============================================>>>\n\n");	
        
		// TASK 5 - calculate maximum value tag for each lab 
 		System.out.println("\n\nCalculate the greatest value tag of all devices in a lab ====================>>>>>");
		int maxTag = labs.findMaxTag();		
		System.out.println("\nTASK 5 COMPLETE ==============================================>>>\n\n");	
   
		// TASK 6
		//  inquire about a device
		System.out.println("\n\nDo some inquiries about a device =====================================>>>");
		
		//	is it rented? object md2 created in task 3
		System.out.println("Is Device " + md2.deviceName() + " rented? ==========================>>");
		labs.isDeviceRented(md2);
		System.out.print("\n\n");

		// is it overdue?
		System.out.println("\nIs Device " + md2.deviceName() + "overdue? =========================>>>");
		md2.isDeviceOverdue();
		// could it be found in more than one lab?
		
		// when can it be rented?
		System.out.println("\nWhen will " + md.getDeviceName() + " be available to rent? ===================>>>");
		String available = "";
		available = md2.availableDate(lab);
		System.out.println("Next available rental date is " + available);
		System.out.println("\nTASK 6 COMPLETE ================================================>>>>>>");
*/
    }
}

