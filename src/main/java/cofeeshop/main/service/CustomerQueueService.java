package cofeeshop.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cofeeshop.main.domain.CustomerQueue;
import cofeeshop.main.domain.Tray;
import cofeeshop.main.repository.CustomerQueueRepository;

@Service
public class CustomerQueueService {

	@Autowired
	private CustomerQueueRepository queueRepository;
	
	
	public List<CustomerQueue> getAllTraysInQueue(){
		return queueRepository.findAll();
	}
	
	public List<Tray> getTraysByQueuId(long id){
		Optional<CustomerQueue> customerQueueOptional = queueRepository.findById(id);
		CustomerQueue customerQueue = customerQueueOptional.get();
		return customerQueue.getTrays();
	}
}
