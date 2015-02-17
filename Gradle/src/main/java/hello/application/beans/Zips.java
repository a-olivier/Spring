package hello.application.beans;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Zips {

	@Id
	private String id; 
	
	private String city; 
	private List<String> loc; 
	private int pop; 
	private String state;
	
	
	@Override
	public String toString() {
		return "[city=" + city + ", loc=" + loc + ", pop=" + pop
				+ ", state=" + state + "]";
	}

	public Zips(){}
	
	public Zips(String city, List<String> loc, int pop, String state) {
		this.city = city;
		this.loc = loc;
		this.pop = pop;
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getLoc() {
		return loc;
	}
	public void setLoc(List<String> loc) {
		this.loc = loc;
	}
	public int getPop() {
		return pop;
	}
	public void setPop(int pop) {
		this.pop = pop;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
