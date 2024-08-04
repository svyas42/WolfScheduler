package edu.ncsu.csc216.wolf_scheduler.course;


/**
 * Creating a conflict exception class that extends exception
 * @author Sachi Vyas 
 */
public class ConflictException extends Exception {
	/** ID used for serialization. */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor for the conflict exception without parameter
	 */
	public ConflictException() {
		this("Schedule conflict.");
	}
	/**
	 * Constructor for the conflict exception with the parameter as message
	 * @param message the message to throw when conflict exception occurs
	 */
	public ConflictException(String message) {
		super(message);
	}

}
