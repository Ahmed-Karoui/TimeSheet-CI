package tn.esprit.spring.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	
private static final Logger logger = LogManager.getLogger(EmployeServiceImpl.class);
	
	public EntrepriseServiceImplTest() {
		logger.info(" Test : Classe EntrepriseServiceImplTest ...");
	}
	
	@Autowired
	IEntrepriseService entrepriseServiceImpl ;
	@Autowired
	IEmployeService employeServiceImpl;
	
	@Test
	public void testAjouterEntreprise() {
		logger.info(" Le test de la methode Ajout Entreprise .... ");
		assertEquals(6, entrepriseServiceImpl.ajouterEntreprise(new Entreprise("TestBouhmid","Bouhmid")));
					
	}
	
	@Test
	public void testAjouterEmployeFailure() {
		logger.info(" Le test de la methode Ajout Entreprise.... ");
		assertNotEquals(2, entrepriseServiceImpl.ajouterEntreprise(new Entreprise("TestBouhmid","Bouhmid")));

}
	@Test
	public void testAjouterDepartement() {
		logger.info(" Le test de la methode Ajout Departement .... ");
		assertEquals(22, employeServiceImpl.ajouterDepartement(new Departement("Departement Informatique")));
	}
}
