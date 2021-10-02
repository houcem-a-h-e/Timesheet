package tn.esprit.spring.ContratsTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTest {
	
	@Autowired
	IEmployeService es;
	
	@Test
	public void getAllTest() {
		assertNotNull(es.getAllEmployes());
	}
	
}
