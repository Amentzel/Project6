package proj6;


import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface{  
	public int orderTime;
	public DAY orderDay;
	public Customer cust;
	public ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	public int orderNum = generateOrder();
	
	public Order(int orderTime, DAY orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
	}
	
	public int generateOrder() {
		Random rand = new Random();
		int max = 9000;
		int min = 1000;
		return rand.nextInt((max - min) + 1) + min;
	}
	public int getOrderNo() {
		return orderNum;
	}
	public int getOrderTime() {
		return orderTime;
	}
	
	public Customer getCustomer() {
		Customer deep = new Customer(cust);
		return deep;
	}
	
	@Override
	public boolean isWeekend() {
		if (getDay() == DAY.SUNDAY || getDay() == DAY.SATURDAY) {
			return true;
		}
		return false;
	}
	@Override
	public Beverage getBeverage(int itemNo) {
		if (beverages.get(itemNo) != null) {
			return beverages.get(itemNo);
		}
		return null;
	}
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) { // coffee beverage
	Beverage newBev = new Coffee(bevName, size, extraShot, extraSyrup);
	beverages.add(newBev);
	}
	@Override
	public void addNewBeverage(String bevName, SIZE size) { // alcohol No weekend? 
		Beverage newBev = new Alcohol(bevName, size);
		beverages.add(newBev);
		
	}
	public void addNewBeverage(String bevName, SIZE size, boolean weekend) { // alcohol No weekend? 
		Beverage newBev = new Alcohol(bevName, size, weekend);
		beverages.add(newBev);
		
	}
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtien) {// smoothie
		Beverage newBev = new Smoothie(bevName, size, numOfFruits, addProtien);
		beverages.add(newBev);
	}
	@Override
	public double calcOrderTotal() {
		double total=0;
		for (int i = 0; i<beverages.size(); i++) {
			total += beverages.get(i).calcPrice();
//			if (beverages.get(i).getType() == TYPE.ALCOHOL) { //weekend calculation stuff 
//				Alcohol tempBev = (Alcohol) beverages.get(i);
//				if (tempBev.isWeekendDrink() && isWeekend()) {
//					total +=.6;
//				}
//			}
		}
		return total;
	}
	@Override
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		for (int i = 0; i<beverages.size(); i++) {
			if (beverages.get(i).getType() == type) {
				count++;
			}
		}
		return count;
	}
	public DAY getDay() {
		return orderDay;
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	public int compareTo(Order other) {
		int result = 0;
		if (getOrderNo() == other.getOrderNo()) {
			result = 0;
		}
		if (getOrderNo() < other.getOrderNo()) {
			result = -1;
		}
		if (getOrderNo() > other.getOrderNo()) {
			result = 1;
		}
		return result;
	}
	
	public String toString() {
		String message = "";
		message += "Order Number: " + getOrderNo() + "________\n" + "Time: " + getOrderTime() 
				+ " Customer Name: " + cust.getName()  + ". Customer Age: " + cust.getAge() + " \n";
		
		for (int i = 0; i<beverages.size(); i++) {
			message += "Beverage " + (i+1) + ": " + beverages.get(i).toString() + "\n";
		}
		
		return message;
	}
}
