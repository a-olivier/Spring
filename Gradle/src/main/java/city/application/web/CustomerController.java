package city.application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import city.application.beans.Customer;
import city.application.mongo.repo.CustomerRepository;

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
