package cofeeshop.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cofeeshop.main.domain.Customer;
import cofeeshop.main.exception.ResourceNotFoundException;
import cofeeshop.main.service.CustomerService;

@RestController
public class CustomerController {
	
	private CustomerService customerSevice;
	
	@Autowired
	public void setCustomerSevice(CustomerService customerSevice) {
		this.customerSevice = customerSevice;
	}

	@RequestMapping(path ="/customer", method=RequestMethod.GET)
	public String testCustomer() {
		return "Customer";
	}
	
	@GetMapping("/customers-test")
	public List<Customer> getAllCustomers() {
		return customerSevice.getAllCustomers();
	}
	
	@RequestMapping(value="test", method=RequestMethod.GET)
	public String testController() {
		return "Success";
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerSevice.getCustomerById(customerId);
		return ResponseEntity.ok().body(customer);
	}

	@PostMapping("/customers")
	public Customer createCustomer(@Validated @RequestBody Customer customer) {
		return customerSevice.createCustomer(customer);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
			@Validated @RequestBody Customer customerDetail) throws ResourceNotFoundException {
		Customer updatedCustomer = customerSevice.updateCustomer(customerId, customerDetail);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		return customerSevice.deleteCustomer(customerId);
	}
	
}
