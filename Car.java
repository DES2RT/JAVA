//package car;

import java.io.Serializable;

public class Car implements Serializable {

	private String owner;
	private String model;
	private double km;
	private Integer registration;
	
	public Car(String m, String o, double k) {
		this.owner = o;
		this.model = m;
		this.km = k;
		this.registration = 0;
	}
	public String getOwner() {
		return this.owner;
	}
	public String getModel() {
		return this.model;
	}
	public double getK() {
		return this.km;
	}

	public Integer getReg() {
		return this.registration;
	}
	
	public String toString() {
		String string =
		String.format("Model: %x, Owner: %s, Mileage: %lf, Registration: %s", 
				this.getModel(), this.getOwner(), this.getK(), this.getReg());
		return string;
	}
	
	public void getRegistered(Integer plate) {
		this.registration = plate;
	}
	
}
