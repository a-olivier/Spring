package city.application.web;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import city.application.beans.Zips;
import city.application.mongo.repo.ZipsRepository;

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
		System.out.println("state all : " + state);
		return repository.findByState(state);
	}
	
	
	@RequestMapping("/states/all")
	public Set<String> getAllStates(){		
		
		List<Zips> findDistinctAllState = repository.findAll();
		
		Set<String> setState = new HashSet<String>();
		for (Zips zips : findDistinctAllState) {
			setState.add(zips.getState());
		}
		
		for (String uniQ : setState) {
			System.out.println(" :: " + uniQ);
		}
	return setState;
	}
	
	@RequestMapping("/all")
	public List<Zips> getAllZips(){
		List<Zips> allZip =  repository.findAll();
		
		for (Iterator iterator = allZip.iterator(); iterator.hasNext();) {
			Zips zips = (Zips) iterator.next();
			System.out.println(zips);
		}
		
		return allZip;
	}
	
	@RequestMapping("/all/{state}")
	public List<Zips> test(@PathVariable String state) throws UnknownHostException{
		
		List<Zips> findFirst100ByState = repository.findFirst100ByStateOrderByCityAsc(state);
		
		for (Zips zips : findFirst100ByState) {
			System.out.println(zips);
		}
		
		return findFirst100ByState;
		
	}
	
	@RequestMapping("/test")
	public void testMe(){
		List<Zips> findDistinctAllState = repository.findAll();
		
		Set<String> setState = new HashSet<String>();
		for (Zips zips : findDistinctAllState) {
			setState.add(zips.getState());
		}
		
		for (String uniQ : setState) {
			System.out.println(uniQ);
		}
		
	}
	
	private void displayListe(List<Object> input){
		
	}
	
}
