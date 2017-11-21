package org.vc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vc.bo.Account;
import org.vc.exception.InsufficentBalance;
import org.vc.exception.InvalidAccount;
/**
 * This class is designed for demo purpose. So mentioned all things in one file
 * @author Vikas Choudhary
 *
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {
	private static Map<Integer, Integer> bankAccount = new HashMap<Integer, Integer>();

	@RequestMapping(value="/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> getBalance(@PathVariable Integer accountId) throws InvalidAccount{
		if(null== bankAccount.get(accountId))
			throw new InvalidAccount("Invalid account");
		return new ResponseEntity<String>("Your current Balance is "+bankAccount.get(accountId), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> openAccount(@RequestBody Account account){
		bankAccount.put(account.getNumber(), account.getAmount()); 
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
		
	}
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> withdrawAccount(@RequestBody Account account) throws InvalidAccount, InsufficentBalance{
		if(null== bankAccount.get(account.getNumber()))
			throw new InvalidAccount("Invalid account");
		if(account.getAmount()>bankAccount.get(account.getNumber()))
			throw new InsufficentBalance("Low balance");
		Integer bal = bankAccount.get(account.getNumber()) - account.getAmount();
		bankAccount.put(account.getNumber(), bal); 
		return new ResponseEntity<String>("Account Debited successfully !! current balance is "+bal, HttpStatus.OK);
		
	}
	
		
}
