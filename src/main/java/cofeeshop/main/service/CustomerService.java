package cofeeshop.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cofeeshop.main.domain.Customer;
import cofeeshop.main.exception.ResourceNotFoundException;
import cofeeshop.main.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * public void setCustomerRepository(CustomerRepository customerRepository) {
	 * this.customerRepository = customerRepository; }
	 */

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
		return customer;
	}
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer updateCustomer(long customerId, Customer customerDetail) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		customer.setEmail(customerDetail.getEmail());
		customer.setLastName(customerDetail.getLastName());
		customer.setFirstName(customerDetail.getFirstName());
		final Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
	}
	
	public Map<String, Boolean> deleteCustomer(long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		customerRepository.delete(customer);
		Map<String, Boolean> responseMap = new HashMap<>();
		responseMap.put("deleted", Boolean.TRUE);
		return responseMap;
	}
	
}
