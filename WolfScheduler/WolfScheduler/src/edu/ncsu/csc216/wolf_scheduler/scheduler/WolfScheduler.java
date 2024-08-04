package edu.ncsu.csc216.wolf_scheduler.scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Activity;
import edu.ncsu.csc216.wolf_scheduler.course.ConflictException;
import edu.ncsu.csc216.wolf_scheduler.course.Course;
import edu.ncsu.csc216.wolf_scheduler.course.Event;
import edu.ncsu.csc216.wolf_scheduler.io.ActivityRecordIO;
import edu.ncsu.csc216.wolf_scheduler.io.CourseRecordIO;

/**
 * Adds and removes courses from students schedule based on availability in course catalog
 * @author Sachi Vyas
 */
public class WolfScheduler {
	/** Array list of courses in a student's schedule */
	public ArrayList<Activity> schedule;
	/** String to hold title of schedule */
	private String t;
	/** Array list to hold courses in the catalog */
	public ArrayList<Course> cc;
	/**
	 * Constructor for WolfScheduler
	 * @param fileName name of file to read
	 * @throws IllegalArgumentException if file to read in is not found
	 */
	public WolfScheduler(String fileName) {
		t = "My Schedule";
		schedule = new ArrayList<Activity>();
		
		try {
			cc = CourseRecordIO.readCourseRecords(fileName);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}
	}
	/**
	 * Makes an array with three variables given[name, section, title] if the course is present in catalog
	 * @return catalogArray that holds the name, section, and title of course
	 */
	public String[][] getCourseCatalog() {
		if (cc.size() == 0) {
			String[][] ec = new String[0][0];
			return ec;
		}
		else {
			String [][] catalogArray = new String[cc.size()][3];
	        for (int i = 0; i < cc.size(); i++) {
	            Course c = cc.get(i);
	            catalogArray[i] = c.getShortDisplayArray();
	        }
	        return catalogArray;
		}
	}
	/**
	 * Returns an array off schedules course with their name, section, and title
	 * @return arraySchedule with the name, section, title from the schedule or else returns empty schedule
	 */
	public String[][] getScheduledActivities() {
		if (schedule.size() == 0) {
			String[][] ec = new String[0][0];
			return ec;
		}
		else {
			String [][] arraySchedule = new String[schedule.size()][3];
	        for (int i = 0; i < arraySchedule.length; i++) {
	            //Course c = cc.get(i);
	            arraySchedule[i] = schedule.get(i).getShortDisplayArray();
	        }
	        return arraySchedule;
		}
	}
	/**
	 * Returns an array of scheduled courses with all the needed information
	 * @return arraySchedule an array of scheduled courses will all the details (time, section, name, etc.)
	 */
	public String[][] getFullScheduledActivities() {
		if (schedule.size() == 0) {
			String[][] ec = new String[0][0];
			return ec;
		}
		String [][] arraySchedule = new String[schedule.size()][7];
        for (int i = 0; i < arraySchedule.length; i++) {
            //Course c = cc.get(i);
            arraySchedule[i] = schedule.get(i).getLongDisplayArray();
        }
        return arraySchedule;
	}
	/**
	 * Get's the title of schedule
	 * @return t title of schedule
	 */
	public String getScheduleTitle() {
		return t;
	}
	/**
	 * Exports the schedule once made
	 * @param fileName the file name to write the schedule to
	 * @throws IllegalArgumentException if the file cannot be saved
	 */
	public void exportSchedule(String fileName) {
		try {
			ActivityRecordIO.writeActivityRecords(fileName, schedule);
		} catch (IOException e) {
			throw new IllegalArgumentException("The file cannot be saved.");
		}
		
	}
	/**
	 * Get's a course from the course catalog
	 * @param name name of the course
	 * @param section section of course
	 * @return the course from catalog with matching name and section, else return null
	 */
	public Course getCourseFromCatalog(String name, String section) {
		for (int i = 0; i < cc.size(); i++) {
			if (cc.get(i).getName().equals(name) && cc.get(i).getSection().equals(section)) {
				return cc.get(i);
			}	
		}
		return null;
	}
	/**
	 * Adds a course to schedule
	 * @param name of the course
	 * @param section section of course
	 * @return true if the course can be added, false otherwise
	 * @throws IllegalArgumentException if course to add is already in schedule
	 * @throws IllegalArgumentException if course cannot be added due to conflict
	 */
	public boolean addCourseToSchedule(String name, String section) {
		Course courseToAdd = getCourseFromCatalog(name, section);
		
		for (int i = 0; i < schedule.size(); i++) {
			if (courseToAdd.isDuplicate(schedule.get(i))) {
				throw new IllegalArgumentException("You are already enrolled in " + name);
			}
		}
//		for (int i = 0; i < cc.size(); i++) {
//			if (cc.get(i).getName().equals(name) && cc.get(i).getSection().equals(section)) {
//				schedule.add(cc.get(i));
//				return true;
//			}	
//		}
		try {
			for (int i = 0; i < schedule.size(); i++) {
				courseToAdd.checkConflict(schedule.get(i));
			}
			
		} catch (ConflictException e) {
			throw new IllegalArgumentException("The course cannot be added due to a conflict.");
		}
		
		if (getCourseFromCatalog(name, section) != null) {
			schedule.add(getCourseFromCatalog(name, section));
			return true;
		}
		return false;
	}
	/**
	 * Removes a course from schedule
	 * @param idx index from which to remove the activity from the schedule array
	 * @return true of the course can be removed, false otherwise
	 */
	public boolean removeActivityFromSchedule(int idx) {
		if (idx + 1 > schedule.size() || idx < 0) {
			return false;
		}
		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).equals(schedule.get(idx))) {
				schedule.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * Sets the schedule title
	 * @param title title of schedule
	 * @throws IllegalArgumentException if title is null
	 */
	public void setScheduleTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		t = title;
	}
	/**
	 * Resets the schedule i.e., removes all the courses from schedule
	 */
	public void resetSchedule() {
		ArrayList<Activity> emptySchedule = new ArrayList<Activity>();
		schedule = emptySchedule;
	}
	/**
	 * Adds an event to the schedule
	 * @param eventTitle title of event
	 * @param eventMeetingDays meeting time of event
	 * @param eventStartTime start time of event
	 * @param eventEndTime end time of event
	 * @param eventDetails details about the event
	 * @throws IllegalArgumentException if the event already exists in the schedule
	 */
	public void addEventToSchedule(String eventTitle, String eventMeetingDays, int eventStartTime, int eventEndTime,
			String eventDetails) {
		Event addEvent = new Event(eventTitle, eventMeetingDays, eventStartTime, eventEndTime, eventDetails);
		
		for (int i = 0; i < schedule.size(); i++) {
			if (addEvent.isDuplicate(schedule.get(i))) {
				throw new IllegalArgumentException("You have already created an event called " + eventTitle);
			}
		}
		try {
			for (int i = 0; i < schedule.size(); i++) {
				addEvent.checkConflict(schedule.get(i));
			}
		} catch (ConflictException e) {
			throw new IllegalArgumentException("The event cannot be added due to a conflict.");
		}
		
		schedule.add(addEvent);
	}

}
