package model;

/**
 * Class defining the elements of a wood type
 */

/**
 * 
 * @author Ishwarya Mullai Selvapandian
 *
 */
public class WoodItem {

	
	String name,address,date,type;

	double quantity,priceOfEachItem,totalPrice,maxDeliverytime;

	/**
	 * Default constructor
	 */
	public WoodItem() {
		this.name = "Empty";
		this.address = "Empty";
		this.date = "Empty";
		this.type = "Empty";
		this.quantity = 0.0;
		this.priceOfEachItem = 0.0;

		this.totalPrice = 0.0;
		this.maxDeliverytime = 0.0;
	}


/**
 * Constructor of a WoodItem element with parameters
 * @param name:name of the customer
 * @param address:address of the customer 
 * @param date:purchased date
 * @param type:type of wood
 * @param quantity
 * @param priceOfEachItem:price per Board Foot
 * @param totalPrice
 * @param maxDeliverytime: Estimated delivery time
 */
	public WoodItem(String name, String address, String date, String type,
			double quantity, double priceOfEachItem, double totalPrice,
			double maxDeliverytime) {
		this.name = name;
		this.address = address;
		this.date = date;
		this.type = type;
		this.quantity = quantity;
		this.priceOfEachItem = priceOfEachItem;

		this.totalPrice = totalPrice;
		this.maxDeliverytime = maxDeliverytime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPriceOfEachItem() {
		return priceOfEachItem;
	}

	public void setPriceOfEachItem(double priceOfEachItem) {
		this.priceOfEachItem = priceOfEachItem;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getMaxDeliverytime() {
		return maxDeliverytime;
	}

	public void setMaxDeliverytime(double maxDeliverytime) {
		this.maxDeliverytime = maxDeliverytime;
	}

	@Override
	public String toString() {

		String result = "TotalPrice: " + totalPrice + "\n";
		result += "Estimated Delivery Time: " + maxDeliverytime+"\n"+"\n";

		return result;
	}

}