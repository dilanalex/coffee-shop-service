package cofeeshop.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cofeeshop.main.domain.Tray;
import cofeeshop.main.exception.ResourceNotFoundException;
import cofeeshop.main.service.TrayService;

@RestController
public class TrayController {
	
	private TrayService trayService;
	
	@Autowired
	public void setTrayService(TrayService trayService) {
		this.trayService = trayService;
	}

	@RequestMapping(path = "/tray/{id}", method = RequestMethod.GET)
	public Tray getQueueTrays(@PathVariable(value = "id") Long trayId) throws ResourceNotFoundException {
		return trayService.getTrayById(trayId);
	}

}
