package fr.lm.kata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lm.kata.common.Operation;
import fr.lm.kata.services.AccountService;

@RestController
@RequestMapping(path = "account", consumes = MediaType.ALL_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("{clientId}/depose")
	public void Depose(@PathVariable long clientId ,@RequestBody long amount) {
		accountService.deposeMoney(clientId, amount);
	}
	
	@GetMapping("{clientId}/amount")
	public long getAmountFromAccount(@PathVariable long clientId) {
		return accountService.getAmountFromAccount(clientId);
	}
	
	@GetMapping("{clientId}/withdraw/{amount}")
	public void withdrawMoney(@PathVariable long clientId, @PathVariable long amount) {
		accountService.withdrawMoney(clientId, amount);
	}
	
	@GetMapping("{clientId}/history")
	public List<Operation> getHistory(@PathVariable long clientId) {
		return accountService.getHistory(clientId);
	}
}
