package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {

	public int ajouterMission(Mission mission);
	public void supprimerMission(int idMission);
	public List<Mission> getAllMission();
	public Mission getMissionById(int missionId);
}
