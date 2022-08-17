package cofeeshop.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cofeeshop.main.domain.Tray;
import cofeeshop.main.repository.TrayRepository;

@Service
public class TrayService {

	@Autowired
	private TrayRepository trayRepository;
	
	public Tray getTrayById(long trayId) {
		Optional<Tray> optionalTray = trayRepository.findById(trayId);
		return optionalTray.get();
	}
	
}
