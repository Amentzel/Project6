  package proj6;

public class Alcohol extends Beverage {
	public boolean weekendDrink;
	public final double WEEKEND_COST = .6;

	public Alcohol(String name, SIZE size, boolean weekend ) { 
		super(name, TYPE.ALCOHOL, size);
		this.weekendDrink = weekend;
	}
	
	public Alcohol(String name, SIZE size) {  
		super(name, TYPE.ALCOHOL, size);
		this.weekendDrink = false;
	}
	
	
	public boolean isWeekendDrink() {
		return weekendDrink;
	}
	
	
	@Override
	public double calcPrice() {
		double price = getBasePrice();
		price += addSizePrice();
		if (weekendDrink 
				//&& Order.isWeekend()
				) {
			price+= WEEKEND_COST;
		}
		
		return price;
	}
	
	public String toString() {
		String weekendMessage = "No";
		if (weekendDrink) {
			weekendMessage = "Yes";
		}
		
		return ("Beverage Name: " + getBevName() + ". Type: COFFEE. Size: " + getSize() + 
				". Weekend?: " + weekendMessage + 
				". Total Cost: " + calcPrice());
	}
	
	public boolean equals(Alcohol other) {
		return ((getBevName() == other.getBevName()) && (getSize() == other.getSize()) && (isWeekendDrink() == other.isWeekendDrink())  ); 
	}

}
