package com.capgemini.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNoException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountTest {

	@Mock
	AccountRepository accountRepository;

	AccountService accountService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}
String message;
int amount;
	/*
	 * create account 1. when the amount is less than 500, system should throw
	 * exception 2. when the valid info is passed account should be created
	 * successfully.
	 */

	@Test(expected = com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException()
			throws InsufficientInitialBalanceException {
		accountService.createAccount(101, 400);
	}

	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully()
			throws InsufficientInitialBalanceException {
		Account account = new Account();
		account.setAccountNumber(1011010101);
		account.setAmount(500);
		assertEquals(account, accountService.createAccount(1011010101, 500));
	}
	
	@Test
	public void whenTheValidInfoIsPassedAmountShouldBeWithdrawSuccessfully()
			throws InsufficientInitialBalanceException {
		try {
			amount = accountService.withdrawAmount(10, 1000);
		} catch (InvalidAccountNoException | InsufficientBalanceException e) {
			message = e.getMessage();
		}
		assertEquals(4000, amount);
	}
	
	
}
