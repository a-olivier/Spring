package hello.application.web;

import hello.application.beans.Zips;
import hello.application.mongo.repo.ZipsRepository;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Gradle/zips")
public class ZipController {
	
	@Autowired
	private ZipsRepository repository; 

	@RequestMapping("/")
	public Zips mainResponse(){
		return new Zips();
	}
	
	@RequestMapping("/state/{state}")
	public List<Zips> getFromStateName(@PathVariable String state){		
		return repository.findByState(state);
	}
	
	@RequestMapping("/all")
	public List<Zips> getAllStates(){
		List<Zips> allZip =  repository.findAll();
		
		for (Iterator iterator = allZip.iterator(); iterator.hasNext();) {
			Zips zips = (Zips) iterator.next();
			System.out.println(zips);
		}
		
		return allZip;
	}
	
	@RequestMapping("/test/{state}")
	public List<Zips> test(@PathVariable String state) throws UnknownHostException{
		
		List<Zips> findFirst100ByState = repository.findFirst100ByStateOrderByCityAsc(state);
		
		for (Zips zips : findFirst100ByState) {
			System.out.println(zips);
		}
		
		return findFirst100ByState;
		
	}
	
}
