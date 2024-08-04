package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Creating a course class to evaluate for valid courses 
 * @author Sachi Vyas
 */
public class Course extends Activity {
	/** Minimum length for course name */
	private static final int MIN_NAME_LENGTH = 5;
	/** Maximum length for course name */
	private static final int MAX_NAME_LENGTH = 8;
	/** Minimum letter count for course name */
	private static final int MIN_LETTER_COUNT = 1;
	/** Maximum letter count for course name */
	private static final int MAX_LETTER_COUNT = 4;
	/** Number of digits in course name */
	private static final int DIGIT_COUNT = 3;
	/** Length course section */
	private static final int SECTION_LENGTH = 3;
	/** Maximum course credits allowed */
	private static final int MAX_CREDITS = 5;
	/** Minimum course credits allowed */
	private static final int MIN_CREDITS = 1;
	/** Course's name. */
	private String name;
	/** Course's section. */
	private String section;
	/** Course's credit hours */
	private int credits;
	/** Course's instructor */
	private String instructorId;
	/**
	 * Constructs a Course object with values for all fields
	 * @param name the name of the course
	 * @param title the title of the course
	 * @param section the section of the course
	 * @param credits credit hours for the course
	 * @param instructorId instructor's unity Id
	 * @param meetingDays meeting days for Course as series of chars
	 * @param startTime start time for course
	 * @param endTime end time for course
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays,
			int startTime, int endTime) {
		super(title, meetingDays, startTime, endTime);
		setName(name);
	    //setTitle(title);
	    setSection(section);
	    setCredits(credits);
	    setInstructorId(instructorId);
	    //setMeetingDaysAndTime(meetingDays, startTime, endTime);
	    
	}
	/**
	 * Creates a Course with the given name, title, section, credits, instructorId, and meetingDays for 
	 * courses that are arranged.
	 * @param name name of Course
	 * @param title title of Course
	 * @param section section of Course
	 * @param credits credit hours for Course
	 * @param instructorId instructor's unity id
	 * @param meetingDays meeting days for Course as series of chars
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
		this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}
	/**
	 * Returns the Course's name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the Course's name.
	 * @param name the name to set
	 * @throws IllegalArgumentException if course name is null, empty string, does not contain space, or if character at index 0 is empty
	 * @throws IllegalArgumentException if course name less than minimum or greater than maximum length
	 */
	private void setName(String name) {
		if (name == null || "".equals(name) || !name.contains(" ") || name.charAt(0) == ' ') {
			throw new IllegalArgumentException("Invalid course name.");			
		}
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid course name.");
		}
		if(name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid course name.");
		}

		
		int letter = 0;
		int digit = 0;
		boolean flag = false;
		
		for (int i = 0; i < name.length(); ++i) {
			char charName = name.charAt(i);			
			if (!(flag)) {
				if (Character.isLetter(charName)) {
					letter++;
				}
				else if (Character.isWhitespace(charName)) {
					flag = true;
				}
				else {
					throw new IllegalArgumentException("Invalid course name.");
				}
			}
			else {
				if (Character.isDigit(charName)) {
				       digit++;
					}
					else {
						throw new IllegalArgumentException("Invalid course name.");
					}
			}
			
		}
		
		if (letter < MIN_LETTER_COUNT || letter > MAX_LETTER_COUNT) {
			throw new IllegalArgumentException("Invalid course name.");
		}
		if (digit != DIGIT_COUNT) {
			throw new IllegalArgumentException("Invalid course name.");
		}
		
		this.name = name;
		
	}
	/**
	 * Returns the Course's section.
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	/**
	 * Sets the Course's section.
	 * @param section the section to set
	 * @throws IllegalArgumentException if section is null or not of section length
	 * @throws IllegalArgumentException if section number has a character/letter
	 */
	public void setSection(String section) {
		if (section == null || section.length() != SECTION_LENGTH) {
			throw new IllegalArgumentException("Invalid section.");
		}
//		if (section.length() != SECTION_LENGTH) {
//			throw new IllegalArgumentException("Invalid section.");
//		}
		
		//this.section = section;
		for (int i = 0; i < SECTION_LENGTH; i++) {
			char c = section.charAt(i);
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException("Invalid section.");
			}
		}
		this.section = section;
	}

	/**
	 * Returns the number of credits of the course.
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * Sets the number of credits of the course.
	 * @param credits the credits to set
	 * @throws IllegalArgumentException if credits is less than minimum credits allowed or greater than maximum credits allowed
	 */
	public void setCredits(int credits) {
		if (credits < MIN_CREDITS || credits > MAX_CREDITS) {
			throw new IllegalArgumentException("Invalid credits.");
		}
		
		this.credits = credits;
	}
	/**
	 * Returns the instructor ID of the course.
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}
	/**
	 * Sets the instructor ID of the course.
	 * @param instructorId the instructorId to set
	 * @throws IllegalArgumentException if the instructor Id is invalid
	 */
	public void setInstructorId(String instructorId) {
		if (instructorId == null || instructorId.length() == 0) {
			throw new IllegalArgumentException("Invalid instructor id.");
		}
		this.instructorId = instructorId;
	}
	/**
	 * Returns a comma separated value String of all Course fields.
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
	    if ("A".equals(meetingDays)) {
	        return name + "," + getTitle() + "," + section + "," + getCredits() + "," + instructorId + "," + getMeetingDays();
	    }
	    return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays() + "," + getStartTime() + "," + getEndTime(); 
	}
	/**
	 * Generates a hashCode for Course using all fields.
	 * @return hashCode for Course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + credits;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		return result;
	}
	/**
	 * Compares a given object to this object for equality on all fields
	 * @param obj the Object to compare
	 * @return true if the objects are the same on all fields
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}
	/**
	 * Sets the meeting days and times of course
	 * @param meetingDays the days on which the course meets
	 * @param startTime start time of course
	 * @param endTime end time of course
	 * @throws IllegalArgumentException for invalid meeting days
	 * @throws IllegalArgumentException if start and end times are not zero for arranged days
	 * @throws IllegalArgumentException if the meeting day is other than M,T,W,H,F,A
	 */
	@Override
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
		if (meetingDays == null || "".equals(meetingDays)) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
			
		if ("A".equals(meetingDays)) {
			if (startTime != 0 || endTime != 0) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			this.meetingDays = meetingDays;
			this.startTime = 0;
			this.endTime = 0;
		}
		
		else if (meetingDays.contains("M") || meetingDays.contains("T") || meetingDays.contains("W")
				|| meetingDays.contains("H") || meetingDays.contains("F")){
			int m = 0;
			int t = 0;
			int w = 0;
			int th = 0;
			int f = 0;
			for (int i = 0; i < meetingDays.length(); i++) {
				char a = meetingDays.charAt(i);
				if (a == 'M') {
					m++;
				}
				else if (a == 'T') {
					t++;
				}
				else if (a == 'W') {
					w++;
				}
				else if (a == 'H') {
					th++;
				}
				else if (a == 'F') {
					f++;
				}
				else {
					throw new IllegalArgumentException("Invalid meeting days and times.");
				}
		  }
			
			
		  if (m > 1) {
			  throw new IllegalArgumentException("Invalid meeting days and times.");
		  }
		  if (t > 1) {
			  throw new IllegalArgumentException("Invalid meeting days and times.");
		  }
		  if (w > 1) {
			  throw new IllegalArgumentException("Invalid meeting days and times.");
		  }
		  if (th > 1) {
			  throw new IllegalArgumentException("Invalid meeting days and times.");
		  }
		  if (f > 1) {
			  throw new IllegalArgumentException("Invalid meeting days and times.");
		  }
			
		  	int startHour = startTime / 100;
		  	int startMin = startTime % 100;
		  	int endHour = endTime / 100;
		  	int endMin = endTime % 100;
			
		  	if (endHour < 0 || endHour >= UPPER_HOUR) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			if (endMin < 0 || endMin >= UPPER_MINUTE) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			if (startHour < 0 || startHour >= UPPER_HOUR) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			if (startMin < 0 || startMin >= UPPER_MINUTE) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			if (startTime > endTime) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
		}
		else {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		super.setMeetingDaysAndTime(meetingDays, startTime, endTime);
	}
	/**
	 * Shorter array with the name, section, and title of the course
	 * @return arrayShort with the three variables
	 */
	@Override
	public String[] getShortDisplayArray() {
		String[] arrayShort = new String[4];
		arrayShort[0] = name;
		arrayShort[1] = section;
		arrayShort[2] = title;
		arrayShort[3] = getMeetingString();
		return arrayShort;
	}
	/**
	 * Long array with name, section, title, credits, instructorId, meetingString (end time, start time, days)
	 * @return arrayLong with the seven variables
	 */
	@Override
	public String[] getLongDisplayArray() {
		String[] arrayLong = new String[7];
		arrayLong[0] = name;
		arrayLong[1] = section;
		arrayLong[2] = title;
		arrayLong[3] = credits + "";
		arrayLong[4] = instructorId;
		arrayLong[5] = getMeetingString();
		arrayLong[6] = "";
		return arrayLong;
	}
	/**
	 * Checks if activity is an instance of course
	 * @param activity an instance of Activity
	 * @return true if activity is an instance of course, false otherwise
	 */
	@Override
	public boolean isDuplicate(Activity activity) {
		Course course;
		if (activity instanceof Course) {
			course = (Course) activity;
		}
		else {
			return false;
		}
		return course.getName().equals(this.getName());
	}
	
}
