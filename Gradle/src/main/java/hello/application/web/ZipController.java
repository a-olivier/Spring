package hello.application.web;

import hello.application.beans.Zips;
import hello.application.mongo.repo.ZipsRepository;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zips")
public class ZipController {
	
	@Autowired
	private ZipsRepository repository; 

	@RequestMapping("/")
	public Zips mainResponse(){
		return new Zips();
	}
	
	@RequestMapping("/state/{state}")
	public List<Zips> getFromStateName(@PathVariable String state){
//		List<Zips> findAll = repository.findAll();
//		
//		System.out.println(findAll.get(32));
		
//		repository.save(new Zip("city",new ArrayList<String>(),0,"az"));
		
//		return repository.findByState(state);
		return null;
	}
	
	@RequestMapping("/test")
	public void test() throws UnknownHostException{
		System.out.println(repository.test());
		
	}
}
