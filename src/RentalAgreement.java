import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RentalAgreement {

	private String toolCode;
	private String toolType;
	private String toolBrand;
	private int rentalDays;
	private Date checkOutDate;
	private Date dueDate;
	private double dailyRentalCharge;
	private int chargeDays;
	private double preDiscountCharge;
	private int discountPercent;
	private double discountAmount;
	private double finalCharge;
	
	public RentalAgreement(String toolCode, String toolType, String toolBrand, int rentalDays, Date checkOutDate, Date dueDate, double dailyRentalCharge, int chargeDays, int discountPercent) {
		this.toolCode = toolCode;
		this.toolType = toolType;
		this.toolBrand = toolBrand;
		this.rentalDays = rentalDays;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
		this.dailyRentalCharge = dailyRentalCharge;
		this.chargeDays = chargeDays;
		this.discountPercent = discountPercent;
		this.preDiscountCharge = this.dailyRentalCharge * chargeDays;
		this.discountAmount = Math.round(this.preDiscountCharge * this.discountPercent) / 100.0; //constant 100 is to convert to percent from whole number.
		this.finalCharge = (this.preDiscountCharge - this.discountAmount);
	}
	public String toString() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(); //set up currency formating. Country can be changed and all prints update.
		String pattern = "MM/dd/yy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); // set up date formating 
		return "Tool code: "+ this.toolCode +
				"\nTool type: " + this.toolType + 
				"\nTool brand: " + this.toolBrand +
				"\nRental days: " + this.rentalDays  +
				"\nCheck out date: " + simpleDateFormat.format(this.checkOutDate) + 
				"\nDue date: " + simpleDateFormat.format(this.dueDate) + 
				"\nDaily rental charge: " + currencyFormat.format(this.dailyRentalCharge) + 
				"\nCharge days: " + this.chargeDays +
				"\nPre-discount charge: " + this.discountPercent +"%"+
				"\nDiscount percent:  " +  currencyFormat.format(this.preDiscountCharge) +
				"\nDiscount amount:  " +  currencyFormat.format(this.discountAmount) +
				"\nFinal charge: " +  currencyFormat.format(this.finalCharge);
	}

	public void printAgreement() {
		System.out.println(this.toString());
	}
	
}
