package com.project.agenda.Exception;

public class DuplicateBusinessRule extends RuntimeException{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateBusinessRule(String message) {
		super(String.format(message));
 	}
}
