package tn.esprit.spring.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeServiceImplTest {
	@Mock
	private EmployeRepository empRep;
	private EmployeServiceImpl empService;
	
	private static final Logger l = LogManager.getLogger(EmployeServiceImplTest.class);
	@BeforeEach
	void setup() {
	 
		empService=new EmployeServiceImpl(empRep);
		 
;
	}
 	@Test 
 	void testGetAllEmployes() {
 		Employe emp1=new Employe("rami", "joudi", "r@gmail.com", true, Role.INGENIEUR);
 		Employe emp2=new Employe("foulen", "joudi", "f@gmail.com", true, Role.ADMINISTRATEUR);
 		List<Employe> data= Arrays.asList(emp1,emp2);
 		given(empRep.findAll()).willReturn(data);
 		
 		//test
 		 
 		l.info("test..");	 
 		assertThat(empRep.findAll()).hasSize(2);
 		 
 		
 	        
 		 
 		 
		 
 	}
 	
 
	
 /*
	@Test
	void testAjouterEmploye() {
		Employe emp=new Employe("rami", "joudi", "r@gmail.com", true, Role.INGENIEUR);
		
	}

/*
	@Test
	@Disabled
	void testMettreAjourEmailByEmployeId() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testAffecterEmployeADepartement() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDesaffecterEmployeDuDepartement() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testAjouterContrat() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testAffecterContratAEmploye() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmployePrenomById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteEmployeById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteContratById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetNombreEmployeJPQL() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetAllEmployeNamesJPQL() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetAllEmployeByEntreprise() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testMettreAjourEmailByEmployeIdJPQL() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteAllContratJPQL() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetSalaireByEmployeIdJPQL() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetSalaireMoyenByDepartementId() {
		fail("Not yet implemented");
	}


	@Test
	@Disabled
	void testGetTimesheetsByMissionAndDate() {
		fail("Not yet implemented");
	}
*/
}
