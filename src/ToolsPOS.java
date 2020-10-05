
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;


public class ToolsPOS {
	private Hashtable<String, Tool> tools;
	private Hashtable<String, Type> types;
	public ToolsPOS() {
		// TODO Auto-generated constructor stub
		this.tools = new Hashtable<String, Tool>();
		this.loadTools(); // generate tool database
		this.types = new Hashtable<String, Type>();
		this.loadTypes(); //generate tool type database
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToolsPOS testPOS = new ToolsPOS();
		String pattern = "MM/dd/yy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			System.out.print(testPOS.checkout("JAKR", 5, simpleDateFormat.parse("09/03/15"), 101));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public RentalAgreement checkout(String toolCode,  int rentalDays, Date checkOutDate, int discountPercent){
		Tool tool = this.tools.get(toolCode);
		Type type = this.types.get(tool.getType());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(checkOutDate);
		int chargeDays = countChargeDays(type, calendar, rentalDays);
		System.out.println(checkOutDate);
		System.out.println(calendar.getTime());
		return new RentalAgreement(toolCode, tool.getType(), tool.getBrand(), rentalDays, checkOutDate, calendar.getTime(), type.dailyCharge, chargeDays, discountPercent);
	}
	
	public void loadTools() {
		//tool load could be updated to load from a file or database using a loop
		Tool tool = new Tool("Ladder", "Werner","LADW"); // replaceable with a loop based load in the future
		this.tools.put(tool.getCode(), tool);
		tool = new Tool("Chainsaw", "Stihl","CHNS");
		this.tools.put(tool.getCode(), tool);
		tool = new Tool("Jackhammer", "Ridgid","JAKR");
		this.tools.put(tool.getCode(), tool);
		tool = new Tool("Jackhammer", "DeWalt","JAKD");
		this.tools.put(tool.getCode(), tool);
	}
	
	public void loadTypes() { 
		Type type = new Type(1.99, true, true, false); // as with tool load this could be looped to read from file or database
		this.types.put("Ladder", type);
		type = new Type(1.49, true, false, true);
		this.types.put("Chainsaw", type);
		type = new Type(2.99, true, false, false);
		this.types.put("Jackhammer", type); // type key might be more robust as a enum
	}

	public int countChargeDays(Type toolType, Calendar calendar, int rentalDays) {
		int count = 0;
		boolean chargeDay = true;
		for (int day = 0; day<rentalDays; day++) {
			chargeDay=true;
			// add day first as billing starts day after rental.
		    calendar.add(Calendar.DAY_OF_YEAR, 1); 
		    if (!toolType.getHoliday()) { //if not charging on holidays see if day is holiday
		    	chargeDay=chargeDay&&(!this.isDateHoliday(calendar)); //if holiday set chargeDay false
		    }
		    if (!toolType.getWeekday()) { // if not charging for weekdays see if day is weekday
		    	chargeDay=chargeDay&&(this.isDateWeekend(calendar)); //if day weekday set chargeDay false
		    }
		    if (!toolType.getWeekend()) {
		    	chargeDay=chargeDay&&(!this.isDateWeekend(calendar));
		    }
		    if (chargeDay) {
		    	count++;
		    }
		}
		return count;
	}
	
	public boolean isDateHoliday(Calendar calendar) {
		if (calendar.get(Calendar.MONTH)== Calendar.JULY) {
			if (!this.isDateWeekend(calendar)) {
				if (calendar.get(Calendar.DAY_OF_MONTH) ==4) {
					return true;
				}
				if (calendar.get(Calendar.DAY_OF_MONTH) ==5 && calendar.get(Calendar.DAY_OF_WEEK)== Calendar.MONDAY) {
					return true;
				}
				if (calendar.get(Calendar.DAY_OF_MONTH) ==3 && calendar.get(Calendar.DAY_OF_WEEK)== Calendar.FRIDAY) {
					return true;
				}
			}
		}
		else if (calendar.get(Calendar.MONTH)== Calendar.SEPTEMBER && calendar.get(Calendar.DAY_OF_WEEK)== Calendar.MONDAY && calendar.get(Calendar.DAY_OF_MONTH) < 8 ) {
			return true;
		}
		return false;
	}
	
	public boolean isDateWeekend(Calendar calendar) {
		return (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
				calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
	}

}
