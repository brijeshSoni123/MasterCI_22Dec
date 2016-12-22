package com.capgemini.model;

public class Account {

	private double accountNumber;
	private int amount ;
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", amount=" + amount
				+ "]";
	}
	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountNumber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + amount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountNumber) != Double.doubleToLongBits(other.accountNumber))
			return false;
		if (amount != other.amount)
			return false;
		return true;
	}

	

}
