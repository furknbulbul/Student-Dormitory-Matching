

public class House implements Comparable<House>{
	private int id;
	public int duration;
	private double rating;
	
	
	public House(int id , int duration,double rating) {
		this.id=id;
		this.duration=duration;
		this.rating=rating;
		
	}
	public int compareTo(House other) {
		return this.id-other.id;
	}
	public int getId() {
		return id;
	}
	public double getRating() {
		return rating;
	}
	
	
	

}
