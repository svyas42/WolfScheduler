package edu.ncsu.csc216.wolf_scheduler.course;
/**
 * Creating an abstract parent class activity
 * @author Sachi Vyas
 */
public abstract class Activity implements Conflict {

	/** Upper hour */
	protected static final int UPPER_HOUR = 24;
	/** Upper minute */
	protected static final int UPPER_MINUTE = 60;
	/** Course's title. */
	protected String title;
	/** Course's meeting days */
	protected String meetingDays;
	/** Course's starting time */
	protected int startTime;
	/** Course's ending time */
	protected int endTime;
	/**
	 * Constructor for abstract class activity
	 * @param title the title of the activity
	 * @param meetingDays the meeting days of activity
	 * @param startTime start time of activity
	 * @param endTime end time of activity
	 */
	public Activity(String title, String meetingDays, int startTime, int endTime) {
		super();
		setTitle(title);
		setMeetingDaysAndTime(meetingDays, startTime, endTime);
	}
	/**
	 * Checks if the given activity possible conflicts with another event in the schedule
	 * @param possibleConflictingActivity the activity passed in to check for conflicts
	 * @throws ConflictException if there is a conflict in the schedule
	 * @throws ConflictException if there if there is a conflict between times in the schedule
	 */
	@Override
	public void checkConflict(Activity possibleConflictingActivity) throws ConflictException {
		
		String a = possibleConflictingActivity.getMeetingDays();
		String b = this.getMeetingDays();
//		try {
			if (a.contains("M") && b.contains("M") || a.contains("T") && b.contains("T") ||
					a.contains("W") && b.contains("W") || a.contains("H") && b.contains("H") ||
					a.contains("F") && b.contains("F") || a.contains("S") && b.contains("S") ||
					a.contains("U") && b.contains("U")) {
				
				if (possibleConflictingActivity.getStartTime() >= this.getStartTime() && 
						possibleConflictingActivity.getStartTime() <= this.getEndTime()) {
					throw new ConflictException();
				}
				if (this.getStartTime() >= possibleConflictingActivity.getStartTime() && 
						this.getStartTime() <= possibleConflictingActivity.getEndTime()) {
					throw new ConflictException();
				}
				
//				
//				if (possibleConflictingActivity.getStartTime() >= this.getStartTime() && 
//						possibleConflictingActivity.getEndTime() >= this.getEndTime() &&
//						possibleConflictingActivity.getStartTime() <= this.getEndTime()) {
//					throw new ConflictException();
//				}
//				if (possibleConflictingActivity.getStartTime() <= this.getStartTime() && 
//						possibleConflictingActivity.getEndTime() >= this.getEndTime()) {
//					throw new ConflictException();
//				}
//				if(possibleConflictingActivity.getStartTime() <= this.getStartTime() && 
//						possibleConflictingActivity.getEndTime() >= this.getEndTime()) {
//					throw new ConflictException();
//				}
//				if(possibleConflictingActivity.getStartTime() <= this.getStartTime() && 
//						possibleConflictingActivity.getEndTime() <= this.getEndTime() && 
//						possibleConflictingActivity.getEndTime() >= this.getStartTime()) {
//					throw new ConflictException();
//				}
//				if(possibleConflictingActivity.getStartTime() >= this.getStartTime() && 
//						possibleConflictingActivity.getEndTime() <= this.getEndTime() && 
//						possibleConflictingActivity.getStartTime() <= this.getEndTime()) {
//					throw new ConflictException();
//				}
				
			}
//		} catch (ConflictException e) {
//			throw new ConflictException();
//		}
	}

	/**
	 * Returns the Course's title.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set's the Course's title.
	 * @param title the title to set
	 * @throws IllegalArgumentException if title is null or empty string
	 */
	public void setTitle(String title) {
		if (title == null || "".equals(title)) {
			throw new IllegalArgumentException("Invalid title.");
		}
		
		this.title = title;
	}

	/**
	 * Returns the meeting days of the course.
	 * @return the meetingDays
	 */
	public String getMeetingDays() {
		return meetingDays;
	}

	/**
	 * Returns the start time of the course.
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Returns the end time of the course.
	 * @return the endTime
	 */
	public int getEndTime() {
		return  endTime;
	}

	/**
	 * Sets the meeting days and times of course
	 * @param meetingDays the days on which the course meets
	 * @param startTime start time of course
	 * @param endTime end time of course
	 * @throws IllegalArgumentException if start and end times are invalid
	 */
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
//		if (meetingDays == null || "".equals(meetingDays)) {
//			throw new IllegalArgumentException("Invalid meeting days and times.");
//		}
//			
//		if ("A".equals(meetingDays)) {
//			if (startTime != 0 || endTime != 0) {
//				throw new IllegalArgumentException("Invalid meeting days and times.");
//			}
//			this.meetingDays = meetingDays;
//			this.startTime = 0;
//			this.endTime = 0;
//		}
//		
//		else if (meetingDays.contains("M") || meetingDays.contains("T") || meetingDays.contains("W")
//				|| meetingDays.contains("H") || meetingDays.contains("F")){
//			int m = 0;
//			int t = 0;
//			int w = 0;
//			int th = 0;
//			int f = 0;
//			for (int i = 0; i < meetingDays.length(); i++) {
//				char a = meetingDays.charAt(i);
//				if (a == 'M') {
//					m++;
//				}
//				else if (a == 'T') {
//					t++;
//				}
//				else if (a == 'W') {
//					w++;
//				}
//				else if (a == 'H') {
//					th++;
//				}
//				else if (a == 'F') {
//					f++;
//				}
//				else {
//					throw new IllegalArgumentException("Invalid meeting days and times.");
//				}
//		  }
//			
//			
//		  if (m > 1) {
//			  throw new IllegalArgumentException("Invalid meeting days and times.");
//		  }
//		  if (t > 1) {
//			  throw new IllegalArgumentException("Invalid meeting days and times.");
//		  }
//		  if (w > 1) {
//			  throw new IllegalArgumentException("Invalid meeting days and times.");
//		  }
//		  if (th > 1) {
//			  throw new IllegalArgumentException("Invalid meeting days and times.");
//		  }
//		  if (f > 1) {
//			  throw new IllegalArgumentException("Invalid meeting days and times.");
//		  }
			
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
		
		
			this.meetingDays = meetingDays;
			this.startTime = startTime;
			this.endTime = endTime;
			convertToAM(startTime);
			convertToPM(endTime);
			
	}

	/**
	 * Converting time to PM by subtracting 1200
	 * @param time time to convert in pm
	 * @return pm time in PM
	 */
	private String convertToPM(int time) {
		int t = time;
		if (time > 1259) {
			t = time - 1200;
			//time -= 1200;
		}
		String pm = t + "";
		if (pm.length() == 3) {
			pm = pm.substring(0, 1) + ":" + pm.substring(1, pm.length());
		}
		else if (pm.length() == 4) {
			pm = pm.substring(0, 2) + ":" + pm.substring(2, pm.length());
		}
		return pm;	
	}

	/**
	 * Converting time to AM by adding 1200
	 * @param time time to convert in am
	 * @return am time in am
	 */
	private String convertToAM(int time) {
		int t = time;
		if (time < UPPER_HOUR) {
			t = time + 1200;
		}
		String am = t + "";
		
		if (am.length() == 3) {
			am = am.substring(0, 1) + ":" + am.substring(1, am.length());
		}
		else if (am.length() == 4) {
			am = am.substring(0, 2) + ":" + am.substring(2, am.length());
		}
		return am;
	}

	/**
	 * Format's the time string
	 * @return string of formatted time
	 */
	private String formatTime() {
		String start;
		String end;
		if (this.startTime < 1200) {
			start = convertToAM(startTime) + "AM";
		}
		else {
			start = convertToPM(startTime) + "PM";					
		}
		if (this.endTime < 1200) {
			end = convertToAM(endTime) + "AM";
		}
		else {
			end = convertToPM(endTime) + "PM";
		}
		return start + "-" + end;
	}

	/**
	 * Return string version of meeting information
	 * @return string with meeting information
	 */
	public String getMeetingString() {
		String a = "Arranged";
		if ("A".equals(meetingDays)) {
			return a;
		}
		return meetingDays + " " + formatTime();
	}
	/**
	 * Generates a hashCode for Course using all fields.
	 * @return hashCode for Course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (endTime != other.endTime)
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (startTime != other.startTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	/** 
	 * Creating an array of strings for display in the GUI 
	 * @return string with course generic course information
	 */
	public abstract String[] getShortDisplayArray();
	/** 
	 * Creating an array of strings for display in the GUI 
	 * @return string with detailed course information
	 */
	public abstract String[] getLongDisplayArray();
	/** Checks if two courses are duplicate if they have the same name 
	 * @param activity the activity to check if a duplicate is present
	 * @return boolean true if activity is duplicate or false otherwise
	 */
	public abstract boolean isDuplicate(Activity activity);

}