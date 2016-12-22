package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNoException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	@Override
	public Account createAccount(double accountNumber, int amount)
			throws InsufficientInitialBalanceException {

		if (amount < 500) {
			throw new InsufficientInitialBalanceException("Insufficient Balance");
		}
		Account account = new Account();

		account.setAccountNumber(accountNumber);
		account.setAmount(amount);

		if (accountRepository.save(account)) {
			return account;
		}

		return null;
	}
	

	@Override
	public int showBalance(double accountNumber) throws InvalidAccountNoException {
		if (!(accountNumber >0 && accountNumber < 99999)) {
			throw new InvalidAccountNoException("Invalid accountNumber");
		}
		Account account = searchAccount(accountNumber);
		return account.getAmount();
	}

	@Override
	public int withdrawAmount(double accountNumber, int amount)
			throws InvalidAccountNoException, InsufficientBalanceException {
		if (!(accountNumber >0 && accountNumber < 99999)) {
			throw new InvalidAccountNoException("Invalid accountNumber");
		}
		Account account = searchAccount(accountNumber);
		if(amount > account.getAmount()){
			throw new InsufficientBalanceException("Invalid accountNumber");
		}
		account.setAmount(account.getAmount()-amount);
		return account.getAmount();
	}

	@Override
	public int depositeAmount(double accountNumber, int amount)
			throws InvalidAccountNoException, InsufficientBalanceException {
		if (!(accountNumber >0 && accountNumber < 99999)) {
			throw new InvalidAccountNoException("Invalid accountNumber");
		}
		Account account = searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
	}

	@Override
	public int fundtransfer(double sender, double receiver, int amount)
			throws InvalidAccountNoException, InsufficientBalanceException {
		if (!(sender >0 && sender < 99999)) {
			throw new InvalidAccountNoException("Invalid sender accountNumber");
		}
		if (!(receiver >0 && receiver < 99999)) {
			throw new InvalidAccountNoException("Invalid receiver accountNumber");
		}
		Account senderAccount = searchAccount(sender);
		if(amount > senderAccount.getAmount()){
			throw new InsufficientBalanceException("Invalid accountNumber");
		}
		Account ReceiverAccount = searchAccount(receiver);
		senderAccount.setAmount(senderAccount.getAmount()-amount);
		ReceiverAccount.setAmount(ReceiverAccount.getAmount()-amount);
		return senderAccount.getAmount();
	}

	@Override
	public Account searchAccount(double accountNumber) throws InvalidAccountNoException {
		if (!(accountNumber >0 && accountNumber < 99999)) {
			throw new InvalidAccountNoException("Invalid accountNumber");
		}
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(6000);
		return account;
	}

}
