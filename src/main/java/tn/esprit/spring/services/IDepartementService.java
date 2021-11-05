package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	public int ajouterDepartement(Departement departement ) ;
	public void supprimerDepartement(int departementId  ) ;
	public List<Departement> getAllDepartments();

}
