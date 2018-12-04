package LinkedList;
import java.util.Iterator;
import java.util.Vector;
import Exceptions.DateFormatException;
/**
 * 	@author Dale Stewart
 * 	023567902
 * 
 * 	This LLLab.java file is the class template for the 'Lab' objects. The lab has a unique name and a 'Collection', 
 * in this case a 'Vector' of mobile devices that can be rented. It includes methods for adding a device to the
 * lab, enquiring as to whether a mobile device is present in a specific lab, making a rental reuest, as well as 
 * other Overridden methods of the Object class 'toString, equals, hashCode'.
 */


public class LLLab implements MaxTagValue {

	/**@param labName is unique name for the lab */
    String labName;
    /**@param devices is a Vector of MobileDevice objects */
    LinkedList<LLMobileDevice> devices = null;
    //Vector<MobileDevice> devices;

   
    /**@param labName = unique name of the lab */
    public LLLab(String labName) {
        this.labName = labName;
        devices = new LinkedList<LLMobileDevice>();
    }
    /**@throws NullPointerException if object is null
     * @param md = a mobile device
     */
    public void addDevice(LLMobileDevice md) {
    	try {
    		devices.insertAtBeginning(md);
    	} catch(NullPointerException npe) {
    		System.out.println("Error: " + npe);
    	}
    }

    /** @param md = a mobile device
     * @return boolean - true if device is in inventory */
    public boolean isThereDevice(LLMobileDevice md) {
        boolean found = false;
        devices.iterateList(md); 
/*        	if(mds.compareTo(md) == 0) {     	
        		found = true;
        		break;
        	}*/
        	
    	if(found) {
    		md.setLab(this);
    		System.out.println("Found device " + md.deviceName() + " in Lab: " + this.labName);
    	}
    	else {
    		System.out.println("device: " + md.deviceName() + " not found in Lab: " + this.labName);
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
    public boolean rentRequest(LLMobileDevice wanted, String requestDate, String dueDate) 
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
    	for(Iterator<LLMobileDevice> it = this.devices.iterator(); it.hasNext(); ) {
    		LLMobileDevice mdvs = it.next();
    		// if device is found in lab inventory
    		if(wanted.compareTo(mdvs) == 0) {
    			System.out.println("Found the device");
    			// if device is not rented return true
    			boolean r = mdvs.isRented(this);
    			if( ! (r) ) {		 	// default value is false
    				rent = true;
    			}
    		}
    	}
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
    public int indexElement(LLMobileDevice md) {
		int index = 0;
    	for(Iterator<LLMobileDevice> it = this.devices.iterator(); it.hasNext(); ) {
    		LLMobileDevice mdg = it.next();
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
        r += devices.toString();
        return r;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof LLLab)) return false;
        
        LLLab lab = (LLLab)o;
        
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
    
    public int compareTo(LLLab l) {
    	int lastCmp = this.labName.compareTo(l.labName);
    	return lastCmp;
    }
 
}