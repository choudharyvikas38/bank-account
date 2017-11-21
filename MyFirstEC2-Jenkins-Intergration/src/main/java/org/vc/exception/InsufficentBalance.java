package org.vc.exception;
/**
 * 
 * @author Vikas Choudhary
 *
 */
public class InsufficentBalance extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InsufficentBalance(String msg){
		super(msg);
	}
}