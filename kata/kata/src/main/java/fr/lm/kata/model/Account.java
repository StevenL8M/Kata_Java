package fr.lm.kata.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.lm.kata.common.Operation;
import fr.lm.kata.common.OperationType;

public class Account {
	private Client client;
	private Long amount;
	private List<Operation> operations = new ArrayList<Operation>();

	public Account() {
		
	}
	
	public Account(Client client, Long amount) {
		super();
		this.client = client;
		this.amount = amount;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void deposeMoney(long amount) {
		if(amount >= 0)  {
			this.amount += amount;
		}
		this.operations.add(new Operation(OperationType.DEPOSIT, new Date(), amount, this.amount));
	}
	
	public boolean withdrawMoney(long amount) {
		if(canAfford(amount)) {
			this.amount -= amount;
			this.operations.add(new Operation(OperationType.WITHDRAW, new Date(), amount, this.amount));
			return true;
		}
		else {
			this.operations.add(new Operation(OperationType.WITHDRAW, new Date(), amount, this.amount));
			return false;
		}
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
	
	private boolean canAfford(long amount) {
		return this.getAmount() - amount >= 0;
	}
}
