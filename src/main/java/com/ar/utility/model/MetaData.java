/**
 * 
 */
package com.ar.utility.model;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;

/**
 * @author AnilRamLaxmisetti
 * 
 * Table MetaData Model
 *
 */
public class MetaData {

	private String tableName;
	private String tableStatus;
	private ProvisionedThroughputDescription throughput;
	private Map<String,String> attributes;
	private long itemCount;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}
	public ProvisionedThroughputDescription getThroughput() {
		return throughput;
	}
	public void setThroughput(ProvisionedThroughputDescription throughput) {
		this.throughput = throughput;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public long getItemCount() {
		return itemCount;
	}
	public void setItemCount(long itemCount) {
		this.itemCount = itemCount;
	}
	public MetaData(String tableName, String tableStatus, ProvisionedThroughputDescription throughput,
			Map<String, String> attributes, long itemCount) {
		super();
		this.tableName = tableName;
		this.tableStatus = tableStatus;
		this.throughput = throughput;
		this.attributes = attributes;
		this.itemCount = itemCount;
	}
	
	
	
}
