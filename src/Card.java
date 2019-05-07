public class Card {

	private int value;
	private String colour;
	private boolean state;
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setState(boolean state)
	{
		this.state = state;
	}
	
	public void setKolor(String colour) {
		this.colour = colour;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public String getKolor()
	{
		return this.colour;
	}
	
	public boolean getLos()
	{
		return this.state;
	}
	
	Card(int value, String colour, boolean state)
	{
		this.value = value;
		this.colour = colour;
		this.state = state;
	}
	
}