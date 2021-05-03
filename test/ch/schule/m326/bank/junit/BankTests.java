package ch.schule.m326.bank.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch.schule.m326.bank.Bank;

/**
 * 
 * @author luigicavuoti
 *
 */
public class BankTests {
	@Test
	public void testCreate() {
		Bank b = new Bank();

		assertTrue(b.createAccount("A-1000"));
		assertTrue(b.createAccount("A-1001"));
		assertFalse(b.createAccount("A-1000"));
	}

	@Test
	public void testDeposit() {
		Bank b = new Bank();
		b.createAccount("A-1000");
		b.createAccount("A-1001");

		assertTrue(b.deposit("A-1000", 100000));

	}

	@Test
	public void testWithdraw() {
		Bank b = new Bank();
		b.createAccount("A-1000");
		b.createAccount("A-1001");

		assertTrue(b.withdraw("A-1000", 100000));
		assertEquals(-100000, b.getBalance("A-1000"));
		assertEquals(0, b.getBalance("A-1001"));

		assertTrue(b.withdraw("A-1001", 200000));
		assertEquals(-100000, b.getBalance("A-1000"));
		assertEquals(-200000, b.getBalance("A-1001"));

		assertFalse(b.withdraw("A-1002", 200000));
		assertEquals(-100000, b.getBalance("A-1000"));
		assertEquals(-200000, b.getBalance("A-1001"));
	}

}
