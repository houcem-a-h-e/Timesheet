package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTests {
	@Autowired
	ITimesheetService iTimesheetService;
	@Autowired
	IEmployeService es;
	@Autowired
	IEntrepriseService  ents;
	
	private static final Logger l = LogManager.getLogger(TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTests.class);

	//@Test
	public List<Mission> findAllMissionByEmployeJPQL(){
		List<Employe> employees= new ArrayList();
		Employe emp1= new Employe("aouissaoui", "Houcem", "houcem@gmail.com", false, Role.ADMINISTRATEUR);
		Employe emp2= new Employe("aouissaoui", "Wissem", "wissem@gmail.com", false, Role.CHEF_DEPARTEMENT);

Mission miss = new Mission("externe","informatique");	

		return null;
	}
	//@Test
	public void ajouterMission() {
		Mission mission= new Mission("externe","duréee de 3 mois");
		
		int miss=iTimesheetService.ajouterMission(mission);
		 assertThat(miss).isEqualTo(7);
		 
		
	}
	//@Test
	public void ajouterTimesheet() {
		Employe emp=new Employe("Issaoui", "Wissem","wissem@gmail.com",true,Role.ADMINISTRATEUR);
		es.ajouterEmploye(emp);
		iTimesheetService.ajouterTimesheet(5,emp.getId(),new Date(),new Date());
		
		assertTrue(iTimesheetService.getAllEmployeByMission(5).size()==3);
		assertTrue(emp.getEmail().equals("wissem@gmail.com"));
	}
	//@Test
	public void getAllEmployeByMission(){
		
		int x = iTimesheetService.getAllEmployeByMission(6).size();
		assertThat(x).isEqualTo(3);
	}
	@Test 
			public void TestValiderTimesheet() {
				/*Employe empl=new Employe("Aouissaoui", "Anis","anis@gmail.com",true,Role.CHEF_DEPARTEMENT);
				es.ajouterEmploye(empl);
				iTimesheetService.ajouterTimesheet(5, empl.getId(), new Date(), new Date());
				Entreprise entreprise = new Entreprise("esprit", "technologie");*/
		//Departement d = ents.getAllDepartementsNamesByEntreprise(1);
				Departement dept=ents.getDepartementById(1);
				/*ents.ajouterEntreprise(entreprise);
				entreprise.addDepartement(dept);*/
				
				Mission miss =dept.getMissions().get(5);
				iTimesheetService.validerTimesheet(5, 8, new Date(), new Date(),8);
				Employe validateur = es.getAllEmployes().get(8);
				if(validateur.getRole().equals(Role.CHEF_DEPARTEMENT)){
				assertEquals(dept.getId(),miss.getDepartement().getId());
				l.info("la timesheet a été validé par le chef de département en question");}
				else {l.info("Veuillez vérifier de plus");}
				
			}
	@Component
	@Aspect
	public class PerformanceAspect{
	@Around("execution(* tn.esprit.spring.*.*.*(..))")
	public Object testExecutionTime(MethodInvocationProceedingJoinPoint projp) throws Throwable {
		long start=System.currentTimeMillis();
		Object object=projp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		if (elapsedTime>3000) {
			l.info("Method execution time" + elapsedTime + "milliseconds");
return projp.getSignature();
		}  
		return null;
		
	}
	}
}
