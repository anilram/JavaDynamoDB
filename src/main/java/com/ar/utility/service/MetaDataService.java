package com.ar.utility.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ar.utility.model.MetaData;


public interface MetaDataService {
	public List<String> listTables();
	public Map<String,String> tableAttributes(final String tableName);
	public MetaData tableMetaData(final String tableName);
	public List itemsList(String tableName);
	
}
