package com.ar.utility.dao;

import java.util.List;
import java.util.Map;

import com.ar.utility.model.MetaData;

public interface MetadataDao extends BaseDao{
	public List<String> listTables();
	public MetaData tableMetaData(final String tableName);
	public Map<String,String> tableAttributes(final String tableName);
	public List itemsList(String tableName);
}
