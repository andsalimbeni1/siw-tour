package it.uniroma3.siw.tour.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.tour.model.Attrazione;
import it.uniroma3.siw.tour.repository.AttrazioneRepository;

@Service
@Transactional
public class AttrazioneService {
	
	@Autowired
	private AttrazioneRepository AttrazioneRepository;
	
	public Attrazione saveAttrazione(Attrazione Attrazione) {
		return AttrazioneRepository.save(Attrazione);
	}
	
	public void deleteAttrazioneById(Long id) {
		AttrazioneRepository.deleteById(id);
	}
	
	public Attrazione attrazioneById(Long id) {
		Optional<Attrazione> optional = AttrazioneRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean alreadyExists(Attrazione Attrazione) {
		List<Attrazione> list = this.AttrazioneRepository.findByNome(Attrazione.getNome());
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	} 
	
	public List<Attrazione> getAllAttrazioni(){
		return(List<Attrazione>) AttrazioneRepository.findAll();
	}
}
