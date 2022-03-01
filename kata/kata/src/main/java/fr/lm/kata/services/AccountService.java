package fr.lm.kata.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Component;

import fr.lm.kata.common.Operation;
import fr.lm.kata.model.Account;
import fr.lm.kata.model.Client;

@Component
public class AccountService {
	private static List<Account> accounts = new ArrayList<Account>();
	static {
		Client c1 = new Client((long) 1);
		Account a1 = new Account(c1, (long) 0);
		Client c2 = new Client((long) 2);
		Account a2 = new Account(c2, (long) 500);
		accounts.add(a1);
		accounts.add(a2);
	}
	
	public List<Account> getAllAccounts() {
		return accounts;
	}
	
	public Account getAccountByClientId(long id) {
		try {
			return accounts.stream().filter((account) -> account.getClient().getId() == id).findAny().get();
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}
	
	public void deposeMoney(long clientId, long amount) {
		Account found = getAccountByClientId(clientId);
		if(found != null) {
			found.deposeMoney(amount);
		}
	}
	
	public long getAmountFromAccount(long clientId) {
		return getAccountByClientId(clientId).getAmount();
	}
	
	public void withdrawMoney(long clientId, long amount) {
		getAccountByClientId(clientId).withdrawMoney(amount);
	}
	
	public List<Operation> getHistory(long clientId) {
		return getAccountByClientId(clientId).getOperations();
	}
}
