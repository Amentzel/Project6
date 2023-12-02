package proj6;

public abstract class Beverage {
	private String bevName;
	private TYPE type;
	private SIZE size; 
	private final double BASE_PRICE = 2.00;
	private final double SIZE_PRICE = 1;
	
	
	public Beverage(String name, TYPE type, SIZE size) {
		this.type = type;
		this.size = size;
		this.bevName = name;
	}
	
	public SIZE getSize() {
		return size;
	}
	
	public TYPE getType() {
		return type;
	}
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public String getBevName() {
		return bevName;
	}
	
	public void setBevName(String input) {
		bevName = input;
	}
	public void setType(TYPE input) {
		type = input;
	}
	public void setSize(SIZE input) {
		size = input;
	}
	
	public double addSizePrice() {
		double bigger =0;
		switch (size) {
			case SMALL : { // default? 
				bigger = 0;
				break;
			}
			case MEDIUM : {
				bigger = 1;
				break;
			}
			case LARGE : {
				bigger = 2;
				break;
			}
		}
		return (SIZE_PRICE*bigger);
	}
	
	public String toString() {
		return ("Beverage Name: " + bevName + ". Size: " + size + ". Type: " + type);
	}
	public boolean equals(Beverage other) {
		return ((bevName == other.getBevName()) && (size == other.getSize()) && (type == other.getType()));
	}
	public abstract double calcPrice();
}
