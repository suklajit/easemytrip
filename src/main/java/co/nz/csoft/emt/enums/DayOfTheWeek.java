package co.nz.csoft.emt.enums;

public enum DayOfTheWeek {
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);
		private int dayOfTheWeek;
		DayOfTheWeek(int dayOfTheWeek)
		{
			this.dayOfTheWeek=dayOfTheWeek;
		}
	    public int getValue()
	    { 
	    	return dayOfTheWeek;
	    }
}