package com.capgemini.repository;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.model.Account;

public interface AccountRepository {

	boolean save(Account account);

	Account searchAccount(int accountNumber);

}
