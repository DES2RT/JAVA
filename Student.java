package course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author written by: Dale Stewart
 * 023567902
 * June 20 2016
 * */


public abstract class Student implements Calculable, Cloneable, Runnable {
	/** student first name */
	String givenName;
	/** student surname */
	String surName;
	/** student id number */
	int id;
	/** student address */
	public Address address;
    public List<Course> courses = new ArrayList<Course>();
	
	/** Address class forms address object for student */
	public static class Address implements Cloneable {
		int number;
		String street;
		String city;
		String province;
		String postcode;
		
		// Address class methods
		/** no argument constructor set values to null */
		Address() {
			this.number = 0;
			this.street = null;
			this.city = null;
			this.province = null;
			this.postcode = null;
		}		
		
		/** 5 argument constructor sets values to those passed in */
		Address(int no, String st, String c, String p, String pc) {
			number = no;
			street = st;
			city = c;
			province = p;
			postcode = pc;
		}

        /** @return street number*/
        public int getStreetNumber() {
            return number;
        }

        /**set street number 
         * @param name: Address street number */
        public void setStreetNumber(int streetNumber) {
        	number = streetNumber;
        }
        /** @return street name */
        public String getStreetName() {
        	return street;
        }
        
        /** set street number
         * @param name: Address street name */
        public void setStreetName(String name) {
        	street = name;
        }
        
        /** @return city name*/
        public String getCity() {
            return city;
        }
        /**set city name 
         * @param name: city */
        public void setCity(String city) {
            this.city = city;
        }
        
        /** @return province name*/
        public String getProvince() {
            return province;
        }
        
        /** set province name 
         * @param name: province */
        public void setProvince(String prov) {
            province = prov;
        }
        
        /**  @return Postal Code*/
        public String getPostCode() {
            return postcode;
        }
        
        /** set postal code  
         * @param name: postal code */
        public void setPostCode(String pc) {
            postcode = pc;;
        }

        /** @return Address as a string */
		@Override
		public String toString() {
			return "" + number + " " + street + "\n " + city + ", " + province + ", " + postcode;
		}		
		
		/** @return boolean dependent on objects being equal */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			return true;
		}		
		
		/** @return a duplicate 'clone' of the current object */
		@Override
		protected Object clone() throws CloneNotSupportedException {
		  return super.clone();
		}
	}	// end Address class
	
	// Student class methods
	Student() {
		this.givenName = null;
		this.surName = null;
		this.id = 0;
		this.address = null;
		this.courses = null;
	}
	
	// 5 argument constructor sets values to those passed in */
	Student(String gn, String sn,  int id, List<Course> c, Address addy) {
		givenName = gn;
		surName = sn;
		this.id = id;
		courses = c;
		address = addy;
	}
	
	/** @return price of books for a course */
	public double BooksPrice(List<Course> semesterCourses) {
		double total = 0.00;
        for (Course course : semesterCourses ) {
            total += course.getBookPrice(); // getting total cost of books in each course
        }
		return total;
	}

    /* public getters and setters */
    /** @return student given name */
    public String getGivenName() {
        return givenName;
    }

    /**set student name
     * @param name: student given name */
    public void setGivenName(String name) {
        givenName = name;
    }
    
    /** @return student surname */
    public String getSurname() {
        return surName;
    }

    /**set student surname  
     * @param name: surName*/
    public void setSurname(String name) {
        surName = name;
    }
    
    /** @return student ID */
    public int getId() {
        return id;
    }

    /**set student ID 
     * @param name: Student ID */
    public void setId(int id) {
        this.id = id;
    }

    /** @return List of courses taken by the student in one semester*/
    public List<Course> getCourses() {
        return courses;
    }

    /** @return Student's address*/
    public Address getAddress() {
        return address;
    }

    /**sets student's address 
     * @param name: Address */
    public void setAddress(Address Address) {
        address = Address;
    }

    /** sets List of Courses taken by a student in one semester 
     * @param name: courses */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /** @return Student object as a string */
	@Override
	public String toString() {
		System.out.println("Hello, my name is " + givenName + " " + surName + ". My student id is " + id + ". \n"
				+ "My address is: " + address + ". \nI'm enrolled in courses: " + courses.toString());

		return "";
	}	
	
	/** @return boolean true/false dependent on whether objects are the same */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}	
	
	/** @returns a duplicate 'clone' of the current object */
	  @Override
	  protected Object clone() throws CloneNotSupportedException {
	    return super.clone();
	  }
}	// end Student class
