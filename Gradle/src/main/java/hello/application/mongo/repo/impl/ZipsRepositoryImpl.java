/**
 * 
 */
package hello.application.mongo.repo.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import hello.application.beans.Zips;
import hello.application.mongo.repo.ZipsRepository;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

/**
 * @author a.olivier
 *
 */
public class ZipsRepositoryImpl {

	
	public List<Zips> findByState(String state) {
		// TODO Auto-generated method stub
		return null;
	}

		public Zips test() throws UnknownHostException {
		MongoOperations mongOps = new MongoTemplate(new MongoClient(), "test");
		System.out.println(mongOps.getCollectionNames());
		
		return mongOps.findOne(new Query(where("city").is("ARAB")), Zips.class);
	}

	

}
