package com.ar.utility.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class BaseDaoImpl {

	@Autowired
	DynamoDB dynamoDB;

}
