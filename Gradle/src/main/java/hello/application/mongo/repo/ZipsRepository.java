package hello.application.mongo.repo;

import hello.application.beans.Zips;

import java.net.UnknownHostException;
import java.util.List;


public interface ZipsRepository {

	public List<Zips> findByState(String state);
	
	public Zips test() throws UnknownHostException;
	
}
