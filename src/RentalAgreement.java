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
		this.finalCharge = this.preDiscountCharge - this.discountAmount;
	}
	public String toString() {
		return this.toolCode + this.toolType + this.toolBrand + this.rentalDays  + this.checkOutDate+ this.dueDate + this.dailyRentalCharge + " " + this.chargeDays +" " + this.discountPercent +" " + this.preDiscountCharge +" " + this.discountAmount +" " + this.finalCharge;
	}

}
