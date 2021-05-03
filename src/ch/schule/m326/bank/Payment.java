package ch.schule.m326.bank;

public interface Payment {

	public boolean deposit(int date, long amount);
	public boolean withdraw(long amount);
}
