package proj6;

public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double EXTRA_COST = .5;
	
	public Coffee(String bevName, SIZE size, boolean shot, boolean syrup) {
		super(bevName,TYPE.COFFEE, size);
		this.extraShot = shot;
		this.extraSyrup = syrup;
	}
	public boolean getExtraShot() {
		return extraShot;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	public void setShot(Boolean input) {
		extraShot = input;
	}
	public void setSyrup(Boolean input) {
		extraSyrup = input;
	}
	
	
	@Override
	public double calcPrice() {
		// TODO Auto-generated method stub
		double price = getBasePrice();
		if (extraShot) price += EXTRA_COST;
		if (extraSyrup) price += EXTRA_COST;
		price += addSizePrice();
		return price;
	}
	
	public String toString() {
		String extraShotMessage = "No", extraSyrupMessage = "No";
		if (extraShot) extraShotMessage = "Yes";
		if (extraSyrup) extraSyrupMessage = "Yes";
		return ("Beverage Name: " + getBevName() + ". Type: COFFEE. Size: " + getSize() + 
				"Extra Shot?: " + extraShotMessage + ". Extra Syrup?: " + extraSyrupMessage + 
				"Total Price: " + calcPrice());
	}
	
	public boolean equals(Coffee other) {
		return ((getBevName() == other.getBevName()) && (getSize() == other.getSize()) && (getExtraShot() == other.getExtraShot())
				&& (getExtraSyrup() == other.getExtraSyrup()));
	}
	
}
