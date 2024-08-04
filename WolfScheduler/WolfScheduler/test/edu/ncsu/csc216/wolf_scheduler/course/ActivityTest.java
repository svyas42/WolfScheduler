package edu.ncsu.csc216.wolf_scheduler.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the activity abstract class
 * @author Sachi Vyas
 */
class ActivityTest {
	/**
	 * Checking the conflict for two courses that should not throw an exception
	 */
	@Test
	public void testCheckConflict() {
	    Activity a1 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "MW", 1330, 1445);
	    Activity a2 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "TH", 1330, 1445);
	    
	    assertDoesNotThrow(() -> a1.checkConflict(a2));
	    assertDoesNotThrow(() -> a2.checkConflict(a1));
	}
	/**
	 * Checking the conflict for two courses that should throw an exceptions
	 */
	@Test
	public void testCheckConflictWithConflict() {
	    Activity a1 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "MW", 1330, 1445);
	    Activity a2 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "M", 1330, 1445);
		
	    Exception e1 = assertThrows(ConflictException.class, () -> a1.checkConflict(a2));
	    assertEquals("Schedule conflict.", e1.getMessage());
		
	    Exception e2 = assertThrows(ConflictException.class, () -> a2.checkConflict(a1));
	    assertEquals("Schedule conflict.", e2.getMessage());
	    
//	    Activity a3 = new Event("Event 1", "MTWHF", 1330, 1445, "");
//	    Activity a4 = new Event("Event 2", "THF", 1200, 1300, "");
		
//	    Exception e3 = assertThrows(ConflictException.class, () -> a3.checkConflict(a4));
//	    assertEquals("Schedule conflict.", e1.getMessage());
		
//	    Activity a3 = new Event("Event 3", "MTWHF", 1330, 1445, "");
//	    Activity a4 = new Event("Event 4", "THF", 1200, 1300, "");
	    
	    
	}

}
