
public class Type {

	public double dailyCharge;
	public boolean weekday;
	public boolean weekend;
	public boolean holiday;
	public Type(double dailyCharge, boolean weekday, boolean weekend, boolean holiday) {
		this.dailyCharge= dailyCharge;
		this.weekday = weekday;
		this.weekend = weekend;
		this.holiday = holiday;
	}
	public double getDailyCharge() {
		return this.dailyCharge;
	}
	
	public boolean getWeekday() {
		return this.weekday;
	}
	
	public boolean getWeekend() {
		return this.weekend;
	}
	
	public boolean getHoliday() {
		return this.holiday;
	}
}
