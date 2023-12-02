package proj6;

public class Smoothie extends Beverage {
	private boolean addProtein; 
	private int fruit; 
	private final double COST_OF_FRUIT = .5;
	private final double COST_OF_PROTEIN = 1.5;
	
	public Smoothie(String name, SIZE size, int fruit, boolean protein) {
		super(name, TYPE.SMOOTHIE, size);
		this.addProtein = protein;
		this.fruit = fruit;
	}
	public boolean getProtein() {
		return addProtein;
	}
	public int getFruit() {
		return fruit;
	}
	public void setProtein(Boolean input) {
		addProtein = input;
	}
	public void setFruit(int input) {
		fruit = input;
	}
	
	
	public String toString() {
		String proteinMessage = "No";
		if (addProtein) {
			proteinMessage = "Yes";
		}
		
		return ("Beverage Name: " + getBevName() + ". Type: COFFEE. Size: " + getSize() + 
				". Protein Powder?: " + proteinMessage + ". Number of Fruits: " + fruit + 
				". Total Cost: " + calcPrice());
	}

	@Override
	public double calcPrice() {
		double price = getBasePrice();
		if (addProtein) price += COST_OF_PROTEIN;
		price += fruit*COST_OF_FRUIT;
		price += addSizePrice();
		return price;
	}
	
	public boolean equals(Smoothie other) {
		return ((getBevName() == other.getBevName()) && (getSize() == other.getSize()) 
				&& (getFruit() == other.getFruit()) && (getProtein() == other.getProtein()));
	}

}
