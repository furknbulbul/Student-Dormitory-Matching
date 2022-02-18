

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class School {
	public ArrayList<Student> studentQueue;//waiting students list sorted by id
	public ArrayList<Student> nonAllocatedStudents;//student list of who are not allocated to a house
	public ArrayList<House> emptyHousesList;//empty house list  
	public ArrayList<House> fullHousesList;////list of house with students 
	
	
	public School() {
		studentQueue= new ArrayList<Student>();
		nonAllocatedStudents= new ArrayList<Student>();
		emptyHousesList= new ArrayList<House>();
		fullHousesList= new ArrayList<House>();
		
	}
	//allocates the houses to students for one semester
	public void allocation() {
		if(studentQueue.isEmpty()||emptyHousesList.isEmpty()) {
			return;
		}
		
		Iterator<House> itrEmptyHouse=emptyHousesList.iterator();
		Iterator<Student> itrStudentQueue=studentQueue.iterator();
		
		while(itrStudentQueue.hasNext()){
			Student student = itrStudentQueue.next();
			while(itrEmptyHouse.hasNext()){
				House h=itrEmptyHouse.next();
				if(h.getRating()>=student.getRating()) {
					
					itrStudentQueue.remove();
					h.duration=student.duration;
					fullHousesList.add(h);
					itrEmptyHouse.remove();
					
					break;
				}
				
				
			}
			itrEmptyHouse=emptyHousesList.iterator();
			
		}
		
	}


	//passes one semester 
	public void passASemester() {
		Iterator<Student> itrS=studentQueue.iterator();
		while (itrS.hasNext()) {
			Student s=itrS.next();
			s.duration--;
			if(s.duration==0) {
				itrS.remove();
				nonAllocatedStudents.add(s);
			}	
		}
		
		Iterator<House> itrFullHouse=fullHousesList.iterator();
		while(itrFullHouse.hasNext()) {
			House h=itrFullHouse.next();
			h.duration--;
			if(h.duration==0) {
				emptyHousesList.add(h);
				itrFullHouse.remove();
				
			}
		}
	
		Collections.sort(this.emptyHousesList);
		Collections.sort(this.studentQueue);
	}
	
	
	
}
