//package com.sqav.tattow.spring.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.sqav.tattow.support.PropertyManager;
//
//@Configuration
//public class MongoConfig {
//
//	@Autowired
//	private PropertyManager propertyManager;
//	
//	@Bean
//	protected MongoTemplate mongoTemplate() throws Exception {
//		return new MongoTemplate(mongo(), propertyManager.getEnvironmentProperty("mongo.db.name"));
//	}
//	
//	public Mongo mongo() throws Exception {
//		return new MongoClient(new MongoClientURI(propertyManager.getEnvironmentProperty("mongo.db.uri")));
//	}
//
//}
