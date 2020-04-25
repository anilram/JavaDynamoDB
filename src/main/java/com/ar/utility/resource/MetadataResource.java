package com.ar.utility.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.utility.model.MetaData;
import com.ar.utility.service.MetaDataService;

@RestController
@RequestMapping(value = "/v1/tables")
public class MetadataResource {
	
	@Autowired
	MetaDataService service;
	
	@GetMapping(value = "")
	public List<String> listTables(){
		return service.listTables();
	}
	
	@GetMapping(value = "/{tableName}/attributes")
	public Map<String,String> listAttributes(@PathVariable(value = "tableName") String tableName){
		return service.tableAttributes(tableName);
	}
	
	@GetMapping(value = "/{tableName}/metadata")
	public MetaData tableMetaData(@PathVariable(value = "tableName") String tableName){
		return service.tableMetaData(tableName);
	}
	
	@GetMapping(value = "/{tableName}")
	public List itemsList(@PathVariable(value = "tableName") String tableName){
		return service.itemsList(tableName);
	}
	
	
	
}
