import java.util.*;

import Exceptions.DateFormatException;
import Exceptions.RentPeriodException;

/**
 * 
 * @author Dale Stewart
 * 023567902
 * 
 *	This MobileDevice.java file is the class template for a mobile device. The mobile device is the
 *	property of a lab within a campus. The mobile device can be rented from any lab and any lab can
 *	have more than one type of device. The class contains an inner class 'RentSettings' to help facilitate
 *	renting the mobile device.
 */

public class MobileDevice implements Comparable<MobileDevice> {
	/**@param the unique name of the device **/
    private String deviceName;  		
    /**@param the valueTag -100 to 100 */
    private int valueTag;    				
    /**@param the lab having the device in inventory */
    Lab lab;         							
    /**@param the rent settings of the device */
    RentSettings rentSettings;   						
    /**@param a hashMap of devices in a lab */
    Map<String, Integer> deviceMap;		
    
    public MobileDevice() {
    }

    /** 
     * 
     * @param deviceName - the unique name of the device
     * @param valueTag - the value tag of the device
     * @throws DateFormatException - dates are checked for proper formatting
     */
    public MobileDevice(String deviceName, int valueTag) throws DateFormatException {
        this.deviceName = deviceName;
        this.valueTag = valueTag;
        this.rentSettings = new RentSettings();
/*        deviceMap = new HashMap<String, Integer>();
        deviceMap.put(deviceName, valueTag);*/
    }
    
    // setters and getters ===================================================>
    /**
     * @param dn = deviceName
     */
    public void setDeviceName(String dn) {
    	this.deviceName = dn;
    }
    /**@return the deviceName for this object */
    public String getDeviceName() {
    	return this.deviceName;
    }
    /** @param vt = valueTag for this object */
    public void setValueTag(int vt) {
    	this.valueTag = vt;
    }
    /**@return valueTag for this object */
    public int getValueTag() {
    	return this.valueTag;
    }
    /**@param lab = lab where this device is found in it's inventory */
    public void setLab(Lab lab) {
        this.lab = lab;
    }
    /**@return the lab where this object is located in its inventory */
    public Lab getLab(){
    	return this.lab;
    }
    /**@param rs = rentSettings, an object of RentSettings type containing
     * the rental and due dates as well as the lab rented from */
    public void setRs(RentSettings rs) {
        this.rentSettings = rs;
    }
    /**@return the rent settings for this object */
    public RentSettings getRs() {
        return this.rentSettings;
    }
    /**@return the hashMap of devices for this lab */
    public Map<String, Integer> getDeviceMap() {
    	return this.deviceMap;
    }
//===============================================================================>
   
    // set the rent dates; if dates are not valid catch DateFormatException and return false,
    // if rentDate > dueDate catch RentPeriodException and return false
    // if one the exceptions occur there is no RentSettings object
    public boolean rentDevice(String rentDate, String dueDate, Lab lab) throws DateFormatException, RentPeriodException {
    	System.out.println("Renting device: " + this.deviceName() + " from Lab " + lab.labName);
    	boolean  returned = false;
		// create null RentSettings object
		RentSettings rents = null;
    	
    	// check dates for validity
        Helper.checkDate(rentDate);
        System.out.println("Rent Date is good");
        Helper.checkDate(dueDate);
        System.out.println("Due Date is good");
        
        // if the dates are valid
    	if(Helper.isValidDate(rentDate) && Helper.isValidDate(dueDate)) {

    		// check that the rentDate is not after the dueDate
    		long diff = Helper.timeDifference(rentDate, dueDate);
    		
    		// if the rentDate is after the dueDate throw RentPeriodException
    		if(diff < 0) {
    			try {
    				throw new RentPeriodException("Rent date is AFTER Due date");
    			} finally {
    				int check = 0;
    			}
    		}
    		// the rental dates and rental period are good
    		else {
    			// create a new RentSettings object set with the rental dates and the lab
    			// set the 'borrowed' state to 'true'
    			try {
    				rents = new RentSettings(rentDate, dueDate, lab);
    				System.out.println("Created new rentsetting");
    				this.rentSettings = rents;
    				//System.out.println(this.deviceName());
    				System.out.println(this);
    			} catch (DateFormatException dfe) {
    				new DateFormatException();
    			} catch (RentPeriodException rpe) {
    				new RentPeriodException();
    			}
    		}
    		System.out.println(deviceName + " has been rented from Lab: " + lab.labName);     		
    		//System.out.println(this.lab);
    		returned = true;
    	} 
    	return returned;
	}
    
    // method determines if a device is rented. it returns true if it is rented and false if it isnt
    public boolean isRented(Lab lab) {
    	boolean rented = false;
    	System.out.println(this);
    	this.setLab(lab);
    	if(this.rentSettings.getBorrowed()) {
    		System.out.println(this.deviceName() + " is not available for renting at this time");
    		System.out.println(this);
    		//System.out.println(lab);
    		rented = true;
    	}
    	else {
    		System.out.println(this.deviceName() + " is available for rent");
    		System.out.println(this);
    	}
    //	System.out.println("from isRented returning " + rented);
    	return rented;
    }
   
    // destroy the RentSettings object for this device
    public void returnDevice(Lab lab) throws RentPeriodException, DateFormatException {
    	MobileDevice temp = this;
    	for(Iterator<MobileDevice> it = lab.devices.iterator(); it.hasNext(); ) {
    		MobileDevice next = it.next();
    		if(this.compareTo(next) == 0) {
    			next.rentSettings = new RentSettings();
    		}
    	}
    	System.out.println(this.deviceName() + " has been returned to " + lab.labName);
    	System.out.println(this);
    }

    // return the date when this device is available
    public String availableDate(Lab lab) {
        String available = this.rentSettings.getDueDate();
        return available;
    }

    // returns true if the current date is greater than the due date
    public boolean isDeviceOverdue() throws DateFormatException {
    	String today = Helper.getCurrentDate();
    	String due = this.rentSettings.getDueDate();
    	System.out.println("Duedate " + due);
    	boolean good = Helper.isValidDate(due);
    	if(good) {
    		if(Helper.timeDifference(today, due) < 0) {
    			System.out.println("Device " + this + " is Overdue");
    			return true;
    		}
    		else 
    			System.out.println("Device " + this + " is NOT overdue yet");
    	}
        return false;
    }

    // public 'Object' class overrides
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if( !(o instanceof MobileDevice)) return false;
        
        MobileDevice md = (MobileDevice)o;
        
        if(this.deviceName != md.deviceName) return false;
        if(this.valueTag != md.valueTag) return false;
        if(this.lab != md.lab) return false;
        if(this.rentSettings != md.rentSettings) return false;
        
        return true;
    }
    @Override
    public int hashCode() {
        int result = deviceName != null ? deviceName.hashCode() : 0;
        result = 88 * result + valueTag;
        result += result;
        return result;
    }
    @Override
    public String toString() {
    	String s = "\t";
    	s += this.deviceName();
    	s = s.substring(0, s.length() -1);
    //	System.out.print(s + "\n");
    	s += " => ";
    	s += lab.labName + ")  ";
    	s += this.rentSettings.toString();
    //	s += "\t";
        return s;
    }
    @Override
    public int compareTo(MobileDevice md) {
    	Integer vt = this.valueTag;
    	int same = 1;
    	//System.out.println(this.deviceName()+ " : " + md.deviceName());
    	int firstCmp = vt.compareTo(md.getValueTag());
    	int lastCmp = this.deviceName.compareTo(md.getDeviceName());
    	if(firstCmp == 0 && lastCmp == 0) {
    		same = 0;
    	}
    	return same;
    }
    
    public String deviceName() {
        return "(" + deviceName + ", " + valueTag + ')';
    }

//====================================================================>>>>
    // inner class RentSettings
    private class RentSettings {

        private String rentDate;          // date when the item is requested
        private String dueDate;           // date when the item must be returned
        private boolean borrowed = false; // true if the item is rented

        //default ctr
        private RentSettings() throws DateFormatException {
        	this.rentDate = "";
        	this.dueDate = "";
        }

		// private ctr must throw DateFormatException and RentPeriodException
        private RentSettings(String rentDate, String dueDate, Lab lab) 
        		throws DateFormatException, RentPeriodException {
        	//System.out.println("in RS ctor: rd " + rentDate + " dd " + dueDate + " lab " + lab);

       		Helper.checkDate(rentDate);
        	Helper.checkDate(dueDate);
        	if(Helper.isValidDate(rentDate) && Helper.isValidDate(dueDate)) {
        		this.setBorrowed(true);
        		this.setDueDate(dueDate);
        		this.setRentDate(rentDate);
        		
        	}
        }

        // public 'Object' overrides
        @Override
        /** @return String */
        public String toString() {
            return "RentSettings" + "(" + this.rentDate + ", "  
            											+ this.dueDate + ", " + this.borrowed + ")\n";
        }
        @Override
        /** @return: int */
        public int hashCode() {
        	int val = this.dueDate.hashCode();
        	val = 88 * val + this.rentDate.hashCode();
        	val += val;
        	return val;
        }
        @Override 
        public boolean equals(Object o) {
        	if(this == o) return true;
        	if( !(o instanceof RentSettings)) return false;
        	
        	RentSettings rs = (RentSettings)o;
        	
        	if(this.rentDate != rs.rentDate) return false;
        	if(this.dueDate != rs.dueDate) return false;
        	if(this.borrowed != rs.borrowed) return false;
        	
        	return true;
        }
       
        public int compareTo(RentSettings rs) {
			int lastCmp = this.rentDate.compareTo(rs.rentDate);
			return (lastCmp != 0) ? lastCmp : this.dueDate.compareTo(rs.dueDate);
		}
        
        // public setters and getters
        public void setRentDate(String d) throws RentPeriodException {
        	if(Helper.isValidDate(d)) {
        		this.rentDate = d;
        	}        	
        	else {
        		throw new RentPeriodException();
        	}
        }
        public String getRentDate() {
        	return this.rentDate;
        }
        public void setDueDate(String d) {
        	if(Helper.isValidDate(d))
        		this.dueDate = d;
        }
        public String getDueDate() {
        	return this.dueDate;
        }
        public void setBorrowed(boolean b) {
        	this.borrowed = b;
        }
        public boolean getBorrowed(){
        	return this.borrowed;
        }
    }
}
