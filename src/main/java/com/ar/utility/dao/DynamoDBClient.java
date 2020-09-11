package com.ar.utility.dao;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.amazonaws.auth.PropertiesFileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

@Repository
public class DynamoDBClient {
	
	private static PropertiesFileCredentialsProvider getAWSCredentialsProvider() {
		return new PropertiesFileCredentialsProvider(System.getenv("APP_CONFIG")+File.separator+"awscredentials.properties");
	}

	@Bean
	private DynamoDB getDynamoDBClient() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
		new AwsClientBuilder.EndpointConfiguration("http://localhost:9001", "us-west-2")).withCredentials(getAWSCredentialsProvider())
		.build();
		DynamoDB dynamoDB = new DynamoDB(client);
        return dynamoDB;
     }
}
