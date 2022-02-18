import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;



public class project1main {
	 
	public static void main(String[] args) throws IOException {
	        //long starttime =System.nanoTime(); 
		 
		 	//reading input
	        String fileName = args[0];
	        ArrayList<String> inputLines = new ArrayList<String>();
	        try (FileReader reader = new FileReader(fileName);
	             BufferedReader bufferedReader = new BufferedReader((reader))) {
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                inputLines.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        int maxDuration=0;
	        School school = new School();
	        	        	        
	        //read lines
	        for (String line : inputLines) {

	            String[] tokens = line.split(" ");
	            String type = tokens[0];
	           

	            //check if it is type student, add it to school
	            if (type.equals("s")) {

	                int idS = Integer.parseInt(tokens[1]);
	                String name = tokens[2];
	                int durationS = Integer.parseInt(tokens[3]);
	                if(durationS>maxDuration) {
	                	maxDuration=durationS;
	                }
	                double ratingS = Double.parseDouble(tokens[4]);
	                Student stu = new Student(idS, durationS, name, ratingS);
	                
	                
	                if(durationS==0) {
	                	school.nonAllocatedStudents.add(stu);
	                }
	                else if(durationS>0){
	                	school.studentQueue.add(stu);
	                	
	                }
	                
	            }
	            //check if it type house , add it to school
	            if (type.equals("h")) {
	                int idH = Integer.parseInt(tokens[1]);
	                int durationH = Integer.parseInt(tokens[2]);
	                double ratingH = Double.parseDouble(tokens[3]);

	                House house = new House(idH, durationH, ratingH);
	                if (house.duration > 0) {
	                    school.fullHousesList.add(house);
	                } else if (house.duration == 0) {
	                    school.emptyHousesList.add(house);
	                }
	           }
	       }
	       
	        Collections.sort(school.studentQueue);
	        Collections.sort(school.emptyHousesList);
	        
	        for(int i =0;i<maxDuration;i++) {
	        	school.allocation();
	        	school.passASemester();
	        }
	        Collections.sort(school.nonAllocatedStudents);
	        
	        //writing on a file
	        try {
	        	File outputFile=new File(args[1]);
	        	if(!outputFile.exists()) {
	        		outputFile.createNewFile();
	        	}
	        	PrintStream output = new PrintStream(args[1]);
	        	for(Student s: school.nonAllocatedStudents) {
		        	output.println(s.getName());
		        }
	        	output.close();
	            
	            
	        }
	        catch(Exception e) {
	            e.getStackTrace();
	        }
	        

	       
	        //System.out.println(System.nanoTime()-starttime);
	        
	        
	        
	        
	        
	        
	        
	 	}
	 
}