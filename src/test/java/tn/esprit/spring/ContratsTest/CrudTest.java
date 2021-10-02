package tn.esprit.spring.ContratsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTest {
	
	@Autowired
	IContratService cs;
	@Autowired
	IEmployeService es;
	
	@Test(timeout = 2000)
	public void getAllTest() {
		assertNotNull(cs.getAll());
	}
	
	@Test(timeout = 2000)
	public void addandDeleteContratTest() {
		// TODO Auto-generated method stub
		Contrat c = new Contrat();
		c.setDateDebut(new Date());
		c.setSalaire(1000);
		c.setTypeContrat("CDI");
		long nombreDeContrats = cs.nombreDeContrats();
		int addedid = cs.ajouterContrat(c);
		assertEquals(nombreDeContrats + 1, cs.nombreDeContrats());
		cs.deleteContratById(addedid);
		assertEquals(nombreDeContrats, cs.nombreDeContrats());
	}
	
	@Test(timeout = 2000)
	public void affectEmplToContrat() {
		Contrat c = new Contrat();
		c.setDateDebut(new Date());
		c.setSalaire(100);
		c.setTypeContrat("CDD");
		int addedContrat = cs.ajouterContrat(c);
		List<Employe> allEmloyes = es.getAllEmployes();
		es.affecterContratAEmploye(addedContrat, allEmloyes.get(0).getId());
		assertEquals(allEmloyes.get(0).getId(), cs.getById(addedContrat).getEmploye().getId());
		cs.deleteContratById(addedContrat);
	}
	
}
