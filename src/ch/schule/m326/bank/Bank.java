package ch.schule.m326.bank;

import java.util.ArrayList;

public class Bank {

	/**
	 * @uml.property name="accounts"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true"
	 *                     aggregation="composite"
	 *                     inverse="bank:ch.schule.m326.bank.Account"
	 */
	private ArrayList<Account> accounts = new ArrayList<>();

	/**
	 * Getter of the property <tt>accounts</tt>
	 * 
	 * @return Returns the accounts.
	 * @uml.property name="accounts"
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	/**
	 * Setter of the property <tt>accounts</tt>
	 * 
	 * @param accounts The accounts to set.
	 * @uml.property name="accounts"
	 */
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * @param amount TODO
	 */
	public boolean createAccount(String id) {

		// 1. neues Konto erstellen
		Account account = new Account(id);
		// 2. in die Liste einfügen
		accounts.add(account);
		return true;
	}

	/**
		 */
	public boolean deposit(String id, long amount, int date) {
		// 1. Account suchen
		for (int i = 0; i < this.accounts.size(); i++) {
			Account a = accounts.get(i);
			if (a.getId().equals(id)) {
				// gefunden!
				// falls gefunden amount addieren
				a.deposit(date,amount);
				return true;
			} else
				return false;
		}

		return false;
	}

	/**
		 */
	public boolean withdraw(String id, long amount) {
		// 1. Account suchen
		for (int i = 0; i < this.accounts.size(); i++) {
			Account a = accounts.get(i);
			if (a.getId().equals(id)) {
				// gefunden!
				// falls gefunden amount addieren
				a.withdraw(amount);
				return true;
			} else
				return false;
		}

		return false;
	}

	/**
	 * lösccht das enteprechende Konto aus der Liste
	 */
	public boolean deleteAccount(String accountNumber) {

		// 1. Account suchen
		for (int i = 0; i < this.accounts.size(); i++) {
			Account a = accounts.get(i);
			if (a.getId().equals(accountNumber)) {
				// gefunden!
				// falls gefunden den account lšschen
				accounts.remove(a);
				return true;
			} else
				return false;
		}

		return false;
	}

	
	public Bank() {
		super();
	}

	public Bank(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * Gibt den Kontostand des Kontos mit der gegebenen Kontonummer zurück.
	 * 
	 * <p>
	 * Falls kein Konto mit der gesuchten Kontonummer existiert, gibt diese Methode
	 * 0 (zero) zurück.
	 * </p>
	 * 
	 * @param id die Kontonummer
	 * @return long der Kontostand des Kontos
	 */
	public long getBalance(String id) {
		for (int i = 0; i < accounts.size(); ++i) {
			Account a = (Account) accounts.get(i);

			if (a.getId().equals(id)) {
				return a.getBalance();
			}
		}

		return 0;
	}

}
