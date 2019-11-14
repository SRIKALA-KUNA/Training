package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction  {


	private PasswordChecker passwordChecker;
	private AccountManager accountManager;

	public void register(Account account) {
		if (account.getName().length() <= 5){
			throw new WrongAccountNameException();
		}
		new RegisterAccountAction().checkPassword(account);
		new RegisterAccountAction().accountAddress(account);

	}

	public void checkPassword(Account account)
	{
		
		String password = account.getPassword();
		if (password.length() <= 8) {
			if (passwordChecker.validate(password) != OK) {
				throw new WrongPasswordException();
			}
		}
	}

	public void accountAddress(Account account)
	{
		List<Address> addresses = getAddress(account);
		newAccount(account, addresses);
	}

	public List<Address> getAddress(Account account) {
		account.setCreatedDate(new Date());
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(account.getHomeAddress());
		addresses.add(account.getWorkAddress());
		addresses.add(account.getAdditionalAddress());
		return addresses;
	}

	public void newAccount(Account account, List<Address> addresses) {
		account.setAddresses(addresses);
		accountManager.createNewAccount(account);
	}



	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public void setPasswordChecker(PasswordChecker passwordChecker) {

		this.passwordChecker = passwordChecker;
	}

}
