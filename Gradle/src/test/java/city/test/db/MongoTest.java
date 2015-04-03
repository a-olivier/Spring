package city.test.db;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.MongoTimeoutException;

public class MongoTest {

	MongoClient mongo = null;

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
		try {
			mongo = new MongoClient();
			// set timeout to 3 sec
			mongo.getMongoOptions().setConnectTimeout(3000);
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
		assertTrue(mongo.getDB("test").getCollectionNames().contains("zips"));
	}
}
