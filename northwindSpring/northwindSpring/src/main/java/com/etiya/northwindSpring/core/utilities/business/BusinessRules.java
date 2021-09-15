package com.etiya.northwindSpring.core.utilities.business;

import com.etiya.northwindSpring.core.utilities.results.Result;

public class BusinessRules {
	
	public static Result run (Result... logics)
	{
		for (Result  logic : logics)  {
			
			if(!logic.isSuccess() )
			{
				return logic;
			}
			
		}
		
		return null;
	}

}
