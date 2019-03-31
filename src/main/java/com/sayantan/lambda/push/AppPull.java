package com.sayantan.lambda.push;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class AppPull implements RequestHandler<SQSEvent, Void> {

	@Override
	public Void handleRequest(SQSEvent event, Context context) {
		
        System.out.println();
        for(SQSMessage msg : event.getRecords()){
            System.out.println(msg.getBody());
        }
		
		return null;

	}

}