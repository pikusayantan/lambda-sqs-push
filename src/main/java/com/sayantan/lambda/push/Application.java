package com.sayantan.lambda.push;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sayantan.lambda.push.model.Input;

public class Application implements RequestHandler<Input, String> {

//	@Override
	public String handleRequest(Input input, Context context) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
		String queue_url = sqs.getQueueUrl("sayantan-queue").getQueueUrl();
		context.getLogger().log("Queue URL: " + queue_url);
		
		try {
			sqs.sendMessage(new SendMessageRequest(queue_url, mapper.writeValueAsString(input)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return input.getfName() + " - Hello World - " + input.getlName();

	}

}