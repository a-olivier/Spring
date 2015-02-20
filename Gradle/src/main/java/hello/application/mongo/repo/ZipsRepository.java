package hello.application.mongo.repo;

import hello.application.beans.Zips;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipsRepository extends MongoRepository<Zips, String> {

	public List<Zips> findByState(String state);
	public List<Zips> findFirst100ByStateOrderByCityAsc(String state);

//	
//	@Query(fields = "{'state' : 1 }")
//	public List<String> findAllState();
}
