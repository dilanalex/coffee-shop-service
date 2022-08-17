package cofeeshop.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cofeeshop.main.domain.Tray;
import cofeeshop.main.exception.ResourceNotFoundException;
import cofeeshop.main.service.CustomerQueueService;

@RestController
public class CustomerQueueController {

	private CustomerQueueService queueService;

	@Autowired
	public void setCustomerService(CustomerQueueService queueService) {
		this.queueService = queueService;
	}

	@RequestMapping(path = "/queue/{id}", method = RequestMethod.GET)
	public List<Tray> getQueueTrays(@PathVariable(value = "id") Long queueId) throws ResourceNotFoundException {
		List<Tray> trayList = queueService.getTraysByQueuId(queueId);
		return trayList;
	}

	
	 @RequestMapping(path ="/queue/{queueid}/{trayid}", method=RequestMethod.GET)
	 public String getTrayItems(@PathVariable(value = "queueid") Long queueId, @PathVariable(value = "queueid") Long trayId) { 
		 return "something"; 
	 }
	 
}
