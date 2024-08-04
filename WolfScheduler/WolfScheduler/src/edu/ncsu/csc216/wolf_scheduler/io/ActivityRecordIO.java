package edu.ncsu.csc216.wolf_scheduler.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Activity;


/**
 * Writes out the activities to a file and throw IOException if the file to write to cannot be found
 * @author Sachi Vyas
 */
public class ActivityRecordIO {

	/**
	 * Writes the given list of Courses to 
	 * @param fileName file to write schedule of Courses to
	 * @param activities list of Courses to write
	 * @throws IOException if cannot write to file
	 */
	public static void writeActivityRecords(String fileName, ArrayList<Activity> activities) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(fileName));
    	
    	for (Activity a : activities) {
    		fileWriter.println(a.toString());
    	}
    	
    	fileWriter.close();
	    
	}

}
