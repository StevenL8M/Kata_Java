package fr.lm.kata.common;

import java.util.Date;

public class Operation {
	private OperationType operationType;
	private Date operationDate;
	private long amount;
	private long balance;
	
	public Operation(OperationType operationType, Date operationDate, long amount, long balance) {
		super();
		this.operationType = operationType;
		this.operationDate = operationDate;
		this.amount = amount;
		this.balance = balance;
	}
	
	public OperationType getOperationType() {
		return operationType;
	}
	
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	
	public Date getOperationDate() {
		return operationDate;
	}
	
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	
	public long getAmount() {
		return amount;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getBalance() {
		return balance;
	}
	
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
		
}
