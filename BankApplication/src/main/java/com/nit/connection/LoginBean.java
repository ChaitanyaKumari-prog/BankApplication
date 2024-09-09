package com.nit.connection;

public class LoginBean {
  private long accountNumber;
  private String accountHolderName;
  private double balance;
public long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}
public String getAccountHolderName() {
	return accountHolderName;
}
public void setAccountHolderName(String accountHolderName) {
	this.accountHolderName = accountHolderName;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "LoginBean [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", balance="
			+ balance + "]";
}
  
}
