package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Creates an events and gets the needed information
 * @author Sachi Vyas
 */
public class Event extends Activity {
	/** Variable that keep the details of the event */
	private String eventDetails;
	/**
	 * Constructor for the event class
	 * @param title the title of the event
	 * @param meetingDays the meeting day of the event
	 * @param startTime start time of event
	 * @param endTime end time of event
	 * @param eventDetails information about the event
	 * @throws IllegalArgumentException if the event details are null
	 */
	public Event(String title, String meetingDays, int startTime, int endTime, String eventDetails) {
		super(title, meetingDays, startTime, endTime);
		setEventDetails(eventDetails);
	}
	/**
	 * Set's the details of the event
	 * @param eventDetails details/information about the event
	 * @throws IllegalArgumentException if event details are null
	 */
	public void setEventDetails(String eventDetails) {
		if (eventDetails == null) {
			throw new IllegalArgumentException("Invalid event details.");
		}
		this.eventDetails = eventDetails;
	}
	/**
	 * Gets the details of the event
	 * @return eventDetails with information about the event
	 */
	public String getEventDetails() {
		return eventDetails;
	}
	/**
	 * Creates a short array with title, meeting string, and event details
	 * @return arrayShort with all the information
	 */
	@Override
	public String[] getShortDisplayArray() {
		String[] arrayShort = new String[4];
		arrayShort[0] = "";
		arrayShort[1] = "";
		arrayShort[2] = title;
		arrayShort[3] = getMeetingString();
		return arrayShort;
	}
	/**
	 * Returns a long array with event information in detail
	 * @return arrayLong with all information
	 */
	@Override
	public String[] getLongDisplayArray() {
		String[] arrayLong = new String[7];
		arrayLong[0] = "";
		arrayLong[1] = "";
		arrayLong[2] = title;
		arrayLong[3] = "";
		arrayLong[4] = "";
		arrayLong[5] = getMeetingString();
		arrayLong[6] = eventDetails;
		return arrayLong;
	}
	/**
	 * To string method to separate out the information about the event with the help of comma
	 * @return string with all information about an event
	 */
	@Override
	public String toString() {
		
		return title + "," + getMeetingDays() + "," + getStartTime() + "," + getEndTime() + "," + getEventDetails();
	}
	/**
	 * Sets the meeting days and times of course
	 * @param meetingDays the days on which the course meets
	 * @param startTime start time of course
	 * @param endTime end time of course
	 * @throws IllegalArgumentException is the meeting day is arranged 'A'
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
			throw new IllegalArgumentException("Invalid meeting days and times.");		
		}
		
		else if (meetingDays.contains("M") || meetingDays.contains("T") || meetingDays.contains("W")
				|| meetingDays.contains("H") || meetingDays.contains("F") || meetingDays.contains("U") || 
				meetingDays.contains("S")){
			int m = 0;
			int t = 0;
			int w = 0;
			int th = 0;
			int f = 0;
			int u = 0;
			int s = 0;
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
				else if (a == 'U') {
					u++;
				}
				else if (a == 'S') {
					s++;
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
		  if (u > 1) {
			  throw new IllegalArgumentException("Invalid meeting days and times.");
		  }
		  if (s > 1) {
			  throw new IllegalArgumentException("Invalid meeting days and times.");
		  }
		}
		else {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		
		super.setMeetingDaysAndTime(meetingDays, startTime, endTime);
		this.meetingDays = meetingDays;
	}
	/**
	 * Checks if an activity/event is already present in the schedule
	 * @param activity the event is casted as an activity and then check based on title
	 * @return true if the event is a duplicate or false otherwise
	 */
	@Override
	public boolean isDuplicate(Activity activity) {
		Event e;
		if (activity instanceof Event) {
			e = (Event) activity;
		}
		else {
			return false;
		}
		return e.getTitle().equals(this.getTitle());
	}
}
