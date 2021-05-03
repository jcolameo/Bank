

package ch.schule.m326.bank;

import java.util.ArrayList;

/**
 * Konto.
 * @author  Roger H. J&ouml;rg
 * @version  1.0
 */
public class Account implements Payment
{
	private ArrayList<Booking> bookings;
	
	/**
	 * Die Kontonummer (kann auch Buchstaben und Sonderzeichen enthalten).
	 * @uml.property  name="id"
	 */
	private String id;

	/**
	 * Kontostand in Millirappen.
	 * @uml.property  name="balance"
	 */
	private long balance;

	/**
	 * Erzeugt ein neues Konto.
	 *
	 * @param id die Kontonummer
	 */
	public Account(String id)
	{
		this.id = id;
		this.balance = 0;
	}

	/**
	 * Gibt die Kontonummer zurï¿½ck.
	 * @return  die Kontonummer
	 * @uml.property  name="id"
	 */
	public String getId()
	{
		return id;
	}

	
	
	/**
	 * Gibt das Saldo zurück.
	 * @return  Saldo
	 * @uml.property  name="balance"
	 */
	public long getBalance()
	{
		return balance;
	}

	
	public void setBalance(long balance)
	{
		this.balance = balance;
	}
	/**
	 * Zahlt den gegebenen Betrag aufs Konto ein.
	 *
	 * @param amount der einzuzahlende Betrag
	 *
	 * @return boolean <code>true</code>, falls die
	 * Einzahlung erfolgreich war, andernfalls (z.B.
	 * bei negativem Betrag) <code>false</code>.
	 */
	public boolean deposit(int date, long amount)
	{
		if (amount < 0)
			return false;

	    balance += amount;
	    bookings.add(new Booking(amount, date));
		return true;
	}

	/**
	 * Hebt den gegebenen Betrag vom Konto ab.
	 *
	 * @param amount der abzuhebende Betrag
	 *
	 * @return boolean <code>true</code>, falls die
	 * Abhebung erfolgreich war, andernfalls (z.B.
	 * bei negativem Betrag) <code>false</code>.
	 */
	@Override
	public boolean withdraw(long amount)
	
	{
		if (amount < 0) {
			return false;
		}
	    balance -= amount;
		return true;
	}
 
	 
	
	
}
