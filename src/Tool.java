
public class Tool {

	private String toolType;
	private String brand;
	private String toolCode;
	public Tool(String toolType, String brand,String toolCode) {
		this.toolType = toolType;
		this.brand = brand;
		this.toolCode = toolCode;
	}
	
	public String getType() {
		return this.toolType;
	}
	public String getCode() {
		return this.toolCode;
	}
	public String getBrand() {
		return this.brand;
	}

}
