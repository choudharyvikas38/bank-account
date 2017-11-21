package org.vc.bo;

import java.io.Serializable;

/**
 * 
 * @author Vikas Choudhary
 *
 */
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private int amount;
	public int getNumber() {
		return number;
	}
	public int getAmount() {
		return amount;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}