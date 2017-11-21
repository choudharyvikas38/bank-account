package org.vc.exception;
/**
 * 
 * @author Vikas Choudhary
 *
 */
public class InvalidAccount extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAccount(String msg){
		super(msg);
	}
}
