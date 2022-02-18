

import java.util.PriorityQueue;

public class Student implements Comparable<Student>  {
	private int id;
	public int duration;
	private String name;
	private double rating;
	public PriorityQueue<House> suitableHouses;
	
	public Student(int id, int duration,String name, double rating) {
		this.id=id;
		this.duration=duration;
		this.name=name;
		this.rating=rating;
		
	}
	public int compareTo(Student other) {
		return this.id-other.id;
	}
	
	
	public int getId() {
		return id;
	}

	public double getRating() {
		return rating;
	}
	public String getName() {
		return name;
	}
}
