package tn.esprit.spring.services;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {
	public int ajouterContrat(Contrat contrat);
	public void deleteContratById(int contratId);
	public void deleteAllContratJPQL();

}
