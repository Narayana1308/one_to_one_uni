package one_to_one_uni_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Adharcard {
	@Id
	private int aid;
	private String name;
	private String address;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Adharcard [aid=" + aid + ", name=" + name + ", address=" + address + "]";
	}
	
	

}
