package com.ar.utility.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.utility.dao.MetadataDao;
import com.ar.utility.model.MetaData;

@Service
public class MetaDataServiceImpl implements MetaDataService{
	
	@Autowired
	MetadataDao metadataDao;
	
	public List<String> listTables(){
		return metadataDao.listTables();
	}

	@Override
	public Map<String, String> tableAttributes(final String tableName) {
		return metadataDao.tableAttributes(tableName);
	}

	@Override
	public MetaData tableMetaData(final String tableName) {
		// TODO Auto-generated method stub
		return metadataDao.tableMetaData(tableName);
	}
	
	public List itemsList(final String tableName) {
		return metadataDao.itemsList(tableName);
	}
	

}
