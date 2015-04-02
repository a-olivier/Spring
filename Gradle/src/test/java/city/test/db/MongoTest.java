package city.test.db;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoTimeoutException;

import city.application.mongo.repo.ZipsRepository;

public class MongoTest {

	MongoClient mongo = null;

	@Before
	public void init() {
		try {
			mongo = new MongoClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@After
	public void end() {
		if (mongo != null) {
			mongo.close();
		}
	}

	@Test
	public void ping() {
		try {
			List<String> databaseNames = mongo.getDatabaseNames();
			assertTrue(databaseNames.contains("test"));
		} catch (MongoTimeoutException to) {
			fail("unreachable Mongo DB");
		}
	}

	@Test
	public void containsCollectionTest() {

	}
}
