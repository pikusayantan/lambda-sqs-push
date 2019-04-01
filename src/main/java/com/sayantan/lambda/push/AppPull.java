package com.sayantan.lambda.push;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;
import com.sayantan.lambda.push.exception.AccountAlreadyExistsException;

public class AppPull {

	public static Void handleRequest(SQSEvent event, Context context) throws AccountAlreadyExistsException{
		
        System.out.println("Starting sqs pull...........");
        for(SQSMessage msg : event.getRecords()){
        	String message = msg.getBody(); 
            System.out.println(message);
            if(message.contains("dlq")) {
            	System.out.println("exception will be thrown");
            	throw new AccountAlreadyExistsException("dlp found");
            }
        }
		
		return null;

	}

}