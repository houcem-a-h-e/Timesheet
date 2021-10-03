package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {
	public List<Contrat> getAll();
	public Contrat getById(int id);
	public int ajouterContrat(Contrat contrat);
	public void deleteContratById(int contratId);
	public long nombreDeContrats();
	public Contrat findContratById(int id);
}
