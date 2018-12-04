package LinkedList;
import java.io.*;
import java.util.ArrayList;
/**
 * @author AnnStAcc2
 *	023567902
 *	This Labs.java file is the class template file for Labs objects. It contains 2 parameters
 *	a Lab array : labs, and an int : numberOfLabs. It has methods for creating labs and putting
 *	them in an array, adding devices to the labs, done through reading a file containing the name
 *	and valueTag for the device. 
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Exceptions.DateFormatException;
import Exceptions.RentPeriodException;
public class LLLabs {

    public LLLab[] labsArray;        // a collection of labs of type array
    public int numberOfLabs;  // number of labs in collection

    /**
     * 
     * @param numberOfLabs - sets class variable of same name and creates a new 'Lab' array with 
     * that many objects
     */
    public LLLabs(int numberOfLabs) {
        this.numberOfLabs = numberOfLabs;
        labsArray = new LLLab[numberOfLabs];
    }

    /** this method calls the 'buildLabFromFile method which add devices from a
     * file to the Array of devices in the Lab.
     * @param labName - the name of the lab to add the devices to its inventory.
     * 	param is also passed to the 'buildLabFromFile method. 
     * @param labFileName - the name of the file to be read containing the devices.
     * 	param is also passed to the 'buildLabFromFile method.  
     * @return Lab object - the same Lab obect that is returned to it from the 
     * 'buildLabFromFile method
     */
    public LLLab addDevicesToLab(String labName, String labFileName) throws DateFormatException {

        LLLab lab = buildLabFromFile(labName, labFileName);
       // System.out.println("Lab = " + labName + "]\n\n ");
        return lab;
    }

    /** method returns Lab object. it receives two parameter, the labName and a fileName.
     * 
     * @param labName	the name of the lab passed to constructor. 
     * 	param received from the 'addDevicesToLab' method
     * @param fileName	the name of the filename to read the devices from.
     * 	param received from the 'addDevicesToLab' method
     * @return	newly created Lab object with devices added to inventory
     * 	returned to the calling method 'addDevicesToLab' method
     * 
     * this method opens a file and reads in its contents of devices that will be added
     * to the inventory of devices in the lab
     */
    public LLLab buildLabFromFile(String labName, String fileName) throws DateFormatException {

        LLLab lab = new LLLab(labName);
        String s;

 //       try (BufferedReader br = new BufferedReader(new FileReader("./Root/" + fileName))) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((s = br.readLine()) != null) {
               // read string and int and pass the device name and value tag
               //	as parameters in the constructor
               int apost = s.indexOf(",");
               String name = s.substring(0, apost);
               String value = s.substring(apost+1);
               int val = Integer.parseInt(value);
               System.out.println(name +", " + value);
               LLMobileDevice md = new LLMobileDevice(name, val);
               md.setLab(lab);
            	lab.devices.insertAtBeginning(md);            	
            }
          // System.out.println(lab);           	 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       // System.out.println(lab);
        return lab;
    }

    /**  
     * 
     * @param md = MobileDevice object
     * @return Lab where mobile device searched is available in that particular lab
     */
    public LLLab isThereDeviceInLabs(LLMobileDevice md) {
    	LLLab temp = new LLLab("temp");
    	List<LLLab> inLabs = new ArrayList<LLLab>();
    	List<LLLab> available = new ArrayList<LLLab>();
    //	md.setLab(temp);
    	boolean inLab = false;
    	boolean rented = false;
    	System.out.println("Labs device: " + md.deviceName());
    	for(LLLab lab : labsArray)	{
    		/** call to method in Labs.java returns boolean */
    		inLab = lab.isThereDevice(md);
    		if(inLab) {
    			temp = lab;
    			inLabs.add(lab);
    			if( ! (md.isRented(lab)) ) { 
    				available.add(lab);
    			}
    			else
    				System.out.println(md);
    		}
    		else {
    			temp = null;
    		//	rented = md.isRented(lab);
    		}
   	    }
 		if(inLabs.isEmpty()) {
 			System.out.println("\nDevice: " + md.deviceName() + " is not in any labs");
 		}
 		else {
 			System.out.println("\nThe device: " + md.deviceName() + " is in Lab(s): \t");
 			for(Iterator<LLLab> it = inLabs.iterator(); it.hasNext(); ) {
 				LLLab lab = it.next();
 				System.out.println(lab.labName);
 			}
 		}
 		if(available.isEmpty()) {
 			System.out.println("\nDevice: " + md.deviceName() + " is not available for rent in any labs");
 		}
 		else {
 			System.out.println("\nThe device: " + md.deviceName() + " is available for rent in Lab(s): \t");
 			for(Iterator<LLLab> it = available.iterator(); it.hasNext(); ) {
 				LLLab lab = it.next();
 				System.out.println(lab.labName);
 			}
 		}
    	return temp;
    }

    /** @return boolean
     * 	method call isRented method in MobileDevice.java, that method also returns 
     * 	a boolean to this method. this method receives a mobile device object as a parameter
     */
    public boolean isDeviceRented(LLMobileDevice md) {
    	boolean rented = false;
    	for(LLLab lab : labsArray) {
    		if(lab.isThereDevice(md)) {
    			rented = md.isRented(lab);
    			if(	rented) {
    				System.out.println("Device " + md.deviceName() + " has been rented from " + lab);
    				//System.out.println(md);
    			}
    			else
    				System.out.println("Device " + md.deviceName() + " has not been rented");
    		}
    	}
    	return rented;
    }
    
    /**
     * @return Lab
     * method searches all labs for the device wanted and returns the lab where the
     * device is found or null if device was not found in any labs 
     * @throws DateFormatException 
     * @throws RentPeriodException 
    */
    public LLLab rentDeviceAvailable(LLMobileDevice md, String requestDate, String dueDate) 
    		throws DateFormatException, RentPeriodException {
        LLLab foundLab = null;
        boolean rentable;
        boolean rentDevice;
        int index;
        for(LLLab lab : labsArray) {System.out.println(lab.labName);
        	rentable = lab.rentRequest(md, requestDate, dueDate);
        	if(rentable) {
        		rentDevice = md.rentDevice(requestDate, dueDate, lab);
        		if(rentDevice) {
        			foundLab = lab;
        			int indx = foundLab.indexElement(md);
        			System.out.print("index of device " + indx);
        			foundLab.devices.set(indx, md);
        		}
        	}
        }
        return foundLab;
    }
    
    /** @return int
     * 	method calls the findMaxValueTag() method in Labs.java which calculates the maxValueTag
     * 	of each lab and returns it to the calling method.
     */
    public int findMaxTag() {
    	int maxTag = 0;
    	System.out.println("MaxValueTag");
    	for(LLLab l : labsArray) {
    		maxTag = l.findMaximumValueTag();
    		System.out.println("    " + l.labName + " : " + maxTag);
    	}
    	return maxTag;
    }
    
    // public 'Object' overrides
    @Override
    public String toString() {
    	String s = "";
    	for(LLLab lab : labsArray)
    		s += lab.toString();
    	return s;
    }
    @Override
    public int hashCode() {
    	Integer i = this.numberOfLabs;
    	int result = i != null ? i.hashCode() : 0;
    	result = 88 * result + (labsArray != null ? labsArray.hashCode() : 0);
    	return result;
    }
    @Override
    public boolean equals(Object o) {
    	if(this == o) return true;
    	if( !(o instanceof LLLab)) return false;
    	
    	LLLabs labs = (LLLabs)o;
    	
    	if(this.numberOfLabs != labs.numberOfLabs) return false;
    	if(this.labsArray != labs.labsArray) return false;
    	
    	return true;
    }
}

