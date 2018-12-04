/**
 * 	@author Dale Stewart
 * 	023567902
 * 
 * 	This Lab.java file is the class template for the 'Lab' objects. The lab has a unique name and a 'Collection', 
 * in this case a 'Vector' of mobile devices that can be rented. It includes methods for adding a device to the
 * lab, enquiring as to whether a mobile device is present in a specific lab, making a rental reuest, as well as 
 * other Overridden methods of the Object class 'toString, equals, hashCode'.
 */
import java.util.Iterator;
import java.util.Vector;

import Exceptions.DateFormatException;

public class Lab implements MaxTagValue {

	/**@param labName is unique name for the lab */
    String labName;
    /**@param devices is a Vector of MobileDevice objects */
    Vector<MobileDevice> devices;

   
    /**@param labName = unique name of the lab */
    public Lab(String labName) {
        this.labName = labName;
        devices = new Vector<MobileDevice>();
    }
    /**@throws NullPointerException if object is null
     * @param md = a mobile device
     */
    public void addDevice(MobileDevice md) {
    	try {
    		devices.addElement(md);
    	} catch(NullPointerException npe) {
    		System.out.println("Error: " + npe);
    	}
    }

    /** @param md = a mobile device
     * @return boolean - true if device is in inventory */
    public boolean isThereDevice(MobileDevice md) {
        boolean found = false;
        for(MobileDevice mds : devices) {
        	if(mds.compareTo(md) == 0) {     	
        		found = true;
        		break;
        	}
        	
        }
    	if(found) {
    		md.setLab(this);
    		System.out.println("Found device " + md.deviceName() + " in Lab: " + this.labName);
    	}
    	else {
    		System.out.println("Device: " + md.deviceName() + " not found in Lab: " + this.labName);
    	}
        return found;
    }

    /** 
     * 
     * @param wanted - the device that wants to be rented
     * @param requestDate - the date the device is to be rented
     * @param dueDate - the date the device must be returned
     * @return boolean - rent
     * @throws DateFormatException
     * 	this method validates the rental dates and if valid, checks for the wanted 
     * 	device in its inventory. if the device is found a call to the devices isRented method
     * is made to determine if the device isRented. the method returns true if the device can be rented
     * false if it cannot
     */
    public boolean rentRequest(MobileDevice wanted, String requestDate, String dueDate) 
    		throws DateFormatException {
    	// returned boolean
    	boolean rent = false;
    	// set device's lab to 'this'
    	wanted.setLab(this);
    	// check dates for validity    	
    	Helper.checkDate(requestDate);
    	Helper.checkDate(dueDate);
    	Helper.timeDifference(requestDate, dueDate);
    	
    	// iterate through the device vector searching for the wanted device
    	for(Iterator<MobileDevice> it = this.devices.iterator(); it.hasNext(); ) {
    		MobileDevice mdvs = it.next();
    		// if device is found in lab inventory
    		if(wanted.compareTo(mdvs) == 0) {
    			System.out.println("Found the device");
    			// if device is not rented return true
    			boolean r = mdvs.isRented(this);
    			System.out.println(r);
    			if( ! (r) ) {		 	// default value is false
    				rent = true;
    			}
    		}
    	}
    	System.out.println(rent);
    	if(rent)
    		System.out.println("Found it " + wanted.deviceName() + " in Lab: " + this.labName
    				+ " and its available to rent\n");
    	else
    		System.out.println("Couldnt find " + wanted.deviceName() + " in Lab: " + this.labName
    				+ " or it is rented\n");
    	return rent;  
    }
    
    /** @return int - index number of device in Vector
     * 
     */
    public int indexElement(MobileDevice md) {
		int index = 0;
    	for(Iterator<MobileDevice> it = this.devices.iterator(); it.hasNext(); ) {
    		MobileDevice mdg = it.next();
    		if(mdg.compareTo(md) == 0) {
    			index = this.devices.indexOf(mdg);
    		}
    	}
    //	System.out.println("indexElement " + index);
    	return index;
    		
    }
    /** interface method implementation
     * 
     * @return int : the maximum value tag from the devices in the inventory
    */
    public int findMaximumValueTag() {
    	Finder find = new Finder();
    	int[] input = new int[this.devices.size()]; 	
    	for(int i = 0; i < this.devices.size(); i++) {
    		input[i] = this.devices.elementAt(i).getValueTag();
    	}
    	int maxElement = find.findMaximumValueTag(input);
    	return maxElement;
    }

    // public 'Object' overrides
    @Override
    public String toString() {
        String r = "";
        r += "Lab: " + labName + "\n";
        r += "   Devices: \n";
        for(MobileDevice md : devices)        	
        	r += md.toString();
        r += "\n";
        return r;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Lab)) return false;
        
        Lab lab = (Lab)o;
        
        if(labName != lab.labName) return false;
        if(devices != lab.devices) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = labName != null ? labName.hashCode() : 0;
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        return result;
    }
    
    public int compareTo(Lab l) {
    	int lastCmp = this.labName.compareTo(l.labName);
    	return lastCmp;
    }
 
}