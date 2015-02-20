/**
 * 
 */
package hello.application.mongo.repo.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import hello.application.beans.Zips;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

/**
 * @author a.olivier
 *
 */

public class ZipsRepositoryCriteria implements iZipsRepositoryCriteria {
	private MongoOperations mongoOps = null; 
	
	{
		try {
			mongoOps = new MongoTemplate(new MongoClient(), "test");
		} catch (UnknownHostException e) {
			System.err.println("pas de BD test");
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see hello.application.mongo.repo.impl.iZipsRepositoryCriteria#findByState(java.lang.String)
	 */
	@Override
	public List<Zips> findByState(String state) {
		mongoOps.find(new Query(where("state").is(state)) , Zips.class);
		return null;
	}

		/* (non-Javadoc)
		 * @see hello.application.mongo.repo.impl.iZipsRepositoryCriteria#test()
		 */
		@Override
		public Zips test() throws UnknownHostException {
		System.out.println(mongoOps.getCollectionNames());
		return mongoOps.findOne(new Query(where("city").is("ARAB")), Zips.class);
	}

//		@Override
//		public List<String> findDistinctAllState() {
//			List<String> distinctStates = mongoOps.getCollection(Zips.class).distinct("state");
//			distinctStates.stream().forEach(System.out::println);;
//			return distinctStates;
//		}

		@Override
		public List<Zips> findAll() {
			return mongoOps.findAll(Zips.class);
		}

		@Override
		public List<Zips> findFirst100ByStateOrderByCityAsc(String state) {
			new Query(where("state").is(state)).with(new Sort(Sort.Direction.DESC , "state")).limit(100);
			return null;
		}

	

}
