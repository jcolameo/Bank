package ch.schule.m326.bank;

public class Booking {
	
	private long amount;
	private int date;
	
	
	public Booking(long amount, int date) {
		super();
		this.amount = amount;
		this.date = date;
	}
	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(long amount) {
		this.amount = amount;
	}
	/**
	 * @return the date
	 */
	public int getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(int date) {
		this.date = date;
	}
	
	
	

}
