package ch.schule.m326.bank.junit;

import static org.junit.Assert.*;
import org.junit.Test;

import ch.schule.m326.bank.Account;

/**
 * 
 * @author luigicavuoti
 *
 */
public class AccountTests {
	/**
	 * Tested die Initialisierung eines Kontos.
	 */
	@Test
	public void testInit() {
		Account a = new Account("A-0001");

		assertEquals("A-0001", a.getId());// assertEquals= überprpft ob "A-0001" gleich ist wie bei Account a.
		assertEquals(0, a.getBalance());
	}

	/**
	 * Testet das Einzahlen auf ein Konto.
	 */
	@Test
	public void testDeposit() {
		Account a = new Account("B-2222");

		// CHF 1.-- einzahlen
		assertTrue(a.deposit(100000));
		// Saldo muss 1.-- sein
		assertEquals(100000, a.getBalance());

		// CHF 2.00 einzahlen
		assertTrue(a.deposit(200000));
		// Saldo muss 3.-- sein
		assertEquals(300000, a.getBalance());

		// Versuch, negativen Betrag einzuzahlen
		// darf nicht gehen. Saldo muss unverï¿½ndert
		// bleiben
		assertFalse(a.deposit(-50000));
		assertEquals(300000, a.getBalance());
	}

	/**
	 * Testet das Abheben von einem Konto.
	 */
	@Test
	public void testWithdraw() {
		Account a = new Account("C-300");

		// CHF 1.-- abheben
		assertTrue(a.withdraw(100000));
		// Saldo muss -1.-- sein
		assertEquals(-100000, a.getBalance());

		// CHF 2.00 abheben
		assertTrue(a.withdraw(200000));
		// Saldo muss -3.-- sein
		assertEquals(-300000, a.getBalance());

		// Versuch, negativen Betrag abzuheben
		// darf nicht gehen. Saldo muss unverï¿½ndert
		// bleiben
		assertFalse(a.withdraw(-50000));
		assertEquals(-300000, a.getBalance());
	}

}
