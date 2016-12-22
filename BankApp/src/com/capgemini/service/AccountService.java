package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNoException;
import com.capgemini.model.Account;

public interface AccountService {
	Account createAccount(double accountNumber, int amount)
			throws InsufficientInitialBalanceException;
	
	int showBalance(double accountNumber) throws InvalidAccountNoException;
	
	int withdrawAmount(double accountNumber, int amount)throws InvalidAccountNoException, InsufficientBalanceException;
	
	int depositeAmount(double accountNumber, int amount)throws InvalidAccountNoException, InsufficientBalanceException;
	
	int fundtransfer(double sender, double receiver, int amount) throws InvalidAccountNoException, InsufficientBalanceException;
	
	Account searchAccount(double accountNumber) throws InvalidAccountNoException; 
}

