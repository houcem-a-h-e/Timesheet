package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {
	
	@Autowired ContratRepository cr;
	@Override
	public List<Contrat> getAll() {
		// TODO Auto-generated method stub
		return(List<Contrat>) cr.findAll();
	}

}
