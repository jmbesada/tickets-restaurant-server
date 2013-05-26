package com.qwi.josemi.ticketsRestaurant.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.qwi.josemi.ticketsRestaurant.domain.UserDocument;

@Repository
public class UserRepository {

	@Autowired MongoTemplate template;
	
	public UserDocument findByUsername(String username){
		Query query=Query.query(Criteria.where("username").is(username));
		UserDocument document=template.findOne(query, UserDocument.class);
		return document;
	}
	
	public List<UserDocument> findAllOrderByAccessNumber(){
		Query query=Query.query(new Criteria()).with(new Sort(Direction.DESC,"accessNumber"));
		List<UserDocument> documentList=template.find(query, UserDocument.class);
		return documentList;
	}
	
	public void save(UserDocument userDocument){
		template.save(userDocument);
	}
}
