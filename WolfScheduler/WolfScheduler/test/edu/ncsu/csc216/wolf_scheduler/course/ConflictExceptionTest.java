/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the conflict exception
 * @author Sachi Vyas
 */
class ConflictExceptionTest {
	/**
	 * Tests the conflict exception constructor without the string parameter
	 */
	@Test
	void testConflictException() {
		ConflictException ce = new ConflictException("Schedule conflict.");
	    assertEquals("Schedule conflict.", ce.getMessage());
	}
	/**
	 * Tests the conflict exception constructor with the string parameter
	 */
	@Test
	public void testConflictExceptionString() {
	    ConflictException ce = new ConflictException("Schedule conflict.");
	    assertEquals("Schedule conflict.", ce.getMessage());
	}

}
