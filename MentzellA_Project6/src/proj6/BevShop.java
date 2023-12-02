package proj6;
import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	
	public ArrayList<Order> orders = new ArrayList<Order>();
	public int numAlcohol = 0;
	public final int MIN_AGE_FOR_ALCOHOL = 21;  //Minimum age for offering alcohol drink
	public final int MAX_ORDER_FOR_ALCOHOL= 3;   /*Maximum number of alcohol beverages	that can be ordered within an order  */
	public final int MIN_TIME= 8;				//earliest time for the order
	public final int MAX_TIME= 23;				//latest  time for the order
	public final int MAX_FRUIT = 5;				//Maximum number of fruits that this shop offers for SMOOTHIE beverage
	
	
	public int currentIndex = 0;
	
	
	public BevShop() {
	}
	public int getMaxNumFruits() {
		return MAX_FRUIT;
	}
	public int getNumOfAlcoholDrink() {
		return numAlcohol;
	}
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits > MAX_FRUIT);
	}
	
	
	
	@Override
	public boolean validTime(int time) {
		if (MIN_TIME < time && time < MAX_TIME) {
			return true;
		}
		return false;
	}

	@Override
	public boolean eligibleForMore() { // this thing is backwards why is it returning true when the customer is maxed out on alcoholic bevs
		return !(numAlcohol > MAX_ORDER_FOR_ALCOHOL);
	}

	@Override
	public boolean validAge(int age) {
		return (age >= MIN_AGE_FOR_ALCOHOL);
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Order newOrd = new Order(time, day, new Customer(customerName, customerAge));
		orders.add(newOrd);
		currentIndex = orders.size()-1;
		numAlcohol = 0;
		
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
		
		
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentIndex).addNewBeverage(bevName, size);
		numAlcohol = orders.get(currentIndex).findNumOfBeveType(TYPE.ALCOHOL);
		
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		orders.get(currentIndex).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i =0; i<orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo ){
				return i;
			}
		}
		return 0;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		for (Order o : orders) {
			if (o.getOrderNo() == orderNo) {
				return o.calcOrderTotal();
			}
		}
		
		return 0;
	}

	@Override
	public double totalMonthlySale() {
		double total= 0;
		for (Order o : orders) {
			total += o.calcOrderTotal();
		}
		return total;
	}

	@Override
	public void sortOrders() {
		
		for (int i =0 ; i<orders.size() -1 ; i ++) {
			int index = i;
			for (int j = i ; j<orders.size(); j++) {
				if (orders.get(j).getOrderNo() > orders.get(i).getOrderNo()) {
					index = j;
				}
			}
			Order lowerOrderNum = orders.get(index);
			orders.add(index, orders.get(i));
			orders.add(i,lowerOrderNum);
			
		}
		
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	public Order getCurrentOrder() {
		return getOrderAtIndex(currentIndex);
	}
	
	public String toString() {
		String message = "";
		for (Order o : orders) {
			message += o.toString();
			message += "\n" ; 
		}
		message += "Total Monthly Sales: " + totalMonthlySale();
		
		return message;
	}
}
 