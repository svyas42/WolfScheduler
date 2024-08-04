package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Interface for the conflict class which checks if there is a conflict between activity or events in the schedule
 * @author Sachi Vyas
 */
public interface Conflict {
	/**
	 * Abstract method that has void return type and checks if an activity conflicts with anything in the schedule
	 * @param possibleConflictingActivity activity to check for conflict
	 * @throws ConflictException if there is a conflict in the schedule
	 */
	void checkConflict(Activity possibleConflictingActivity) throws ConflictException;
}
