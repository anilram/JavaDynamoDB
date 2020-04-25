package com.ar.utility.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.document.internal.IteratorSupport;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.ar.utility.model.MetaData;

@Repository
public class MetadataDaoImpl extends BaseDaoImpl implements MetadataDao{

	/*
	 * public static void main(String[] args) { new
	 * MetadataDaoImpl().itemsList("User"); }
	 */
	
	public List<String> listTables(){
		TableCollection<ListTablesResult> tables = dynamoDB.listTables();//max 100 tables
		Iterator<Table> iterator = tables.iterator();
		//Iterable<Table> iterable = () -> iterator;
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false).map(Table::getTableName).collect(Collectors.toList());
	}

	@Override
	public Map<String,String> tableAttributes(final String tableName) {
		 final TableDescription tableInfo = dynamoDB.getTable(tableName).describe();
		 Map<String,String> attributes = tableInfo.getAttributeDefinitions().stream().collect(Collectors.toMap(AttributeDefinition::getAttributeName, AttributeDefinition::getAttributeType));
		 return attributes;
	}

	@Override
	public MetaData tableMetaData(final String tableName) {
		 final TableDescription tableInfo = dynamoDB.getTable(tableName).describe();
		 Map<String,String> attributes = tableInfo.getAttributeDefinitions().stream().collect(Collectors.toMap(AttributeDefinition::getAttributeName, AttributeDefinition::getAttributeType));
		 final long itemCount = tableInfo.getItemCount();
		 final String tableStatus = tableInfo.getTableStatus();
		 final ProvisionedThroughputDescription provisionedThroughput = tableInfo.getProvisionedThroughput();
		 MetaData metaData = new MetaData(tableName, tableStatus, provisionedThroughput, attributes, itemCount);
		return metaData;
	}
	
	/*
	 * private static PropertiesFileCredentialsProvider getAWSCredentialsProvider()
	 * { return new
	 * PropertiesFileCredentialsProvider(System.getenv("AR_AGENT_HOME")+File.
	 * separator+"awscredentials.properties"); }
	 * 
	 * @Bean private DynamoDB getDynamoDBClient() { AmazonDynamoDB client =
	 * AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration( new
	 * AwsClientBuilder.EndpointConfiguration("http://localhost:9001",
	 * "us-west-2")).withCredentials(getAWSCredentialsProvider()) .build(); DynamoDB
	 * dynamoDB = new DynamoDB(client); return dynamoDB; }
	 */
	
	@Override
	public List itemsList(final String tableName) {
		 final Table table = dynamoDB.getTable(tableName);
		 final ItemCollection<ScanOutcome> scanIterator = table.scan();
		 final IteratorSupport<Item, ScanOutcome> iterator = scanIterator.iterator();
		 final HashMap<Integer,Map> hashMap = new HashMap<Integer,Map>();
		 iterator.forEachRemaining(x -> hashMap.put(x.hashCode(), x.asMap()));
		 return hashMap.values().parallelStream().collect(Collectors.toList());
	}
}
