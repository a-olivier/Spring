package hello.application.web;

import hello.application.beans.Customer;
import hello.application.mongo.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/{firstName}")
	public Customer findByFirstName(@PathVariable String firstName) {

		System.out.println("demandee : " + firstName);
		Customer customerFindByFirstName = repository
				.findByFirstName(firstName);
		if (customerFindByFirstName == null) {
			System.out.println("non trouve");
			return new Customer("", "");
		} else {
			return customerFindByFirstName;
		}

	}

}
