package ar.edu.unlam.tallerweb1.persistencia;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;

public class FarmaciaTest extends SpringTest {
	@Test
	@Transactional
	@Rollback (true)
	public void testQueBuscaLasFarmaciasDeTurnoDiaMartes () {
		Farmacia farmacity = new Farmacia ("Farmacity", "Martes");
		getSession().save(farmacity);
		Farmacia farmaciaDelOeste = new Farmacia ("Farmacia del Oeste", "Jueves");
		getSession().save(farmaciaDelOeste);
		Farmacia farmaciaArieta = new Farmacia ("Farmacia Arieta", "Martes");
		getSession().save(farmaciaArieta);
		Farmacia farmaciaAzul = new Farmacia ("Farmacia Azul", "Viernes");
		getSession().save(farmaciaAzul);
		
		List<Farmacia> resultado = getSession().createCriteria(Farmacia.class)
				.add(Restrictions.eq("diaDeTurno", "Martes"))
				.list();
		
		for(Farmacia farmaciaPorTurno : resultado ){
			assertThat(farmaciaPorTurno.getDiaDeTurno()).isEqualTo("Martes");
		}
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaLasFarmaciasDeUnaCalle(){
		Direccion calleBasualdo = new Direccion();
		calleBasualdo.setCalle("Basualdo");
		getSession().save(calleBasualdo);
		
		Direccion calleArieta = new Direccion();
		calleArieta.setCalle("Arieta");
		getSession().save(calleArieta);
		
		Farmacia farmacity = new Farmacia ("Farmacity", "Martes");
		farmacity.setDireccion(calleBasualdo);
		getSession().save(farmacity);
		
		Farmacia farmaciaDelOeste = new Farmacia ("Farmacia del Oeste", "Jueves");
		farmaciaDelOeste.setDireccion(calleBasualdo);
		getSession().save(farmaciaDelOeste);
		
		Farmacia farmaciaArieta = new Farmacia ("Farmacia Arieta", "Martes");
		farmaciaArieta.setDireccion(calleArieta);
		getSession().save(farmaciaArieta);
		
		Farmacia farmaciaAzul = new Farmacia ("Farmacia Azul", "Viernes");
		farmaciaAzul.setDireccion(calleBasualdo);
		getSession().save(farmaciaAzul);
		
		List<Farmacia> resultado = getSession().createCriteria(Farmacia.class)
				.add(Restrictions.eq("direccion", calleBasualdo))
				.list();
		
		assertThat(resultado).hasSize(3);
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaLasFarmaciasDeUnBarrio(){
		Barrio villaLuro = new Barrio();
		villaLuro.setNombre("Villa Luro");
		getSession().save(villaLuro);
		
		Barrio avellaneda = new Barrio();
		avellaneda.setNombre("Avellaneda");
		getSession().save(avellaneda);
		
		Barrio caballito = new Barrio();
		caballito.setNombre("Caballito");
		getSession().save(caballito);
		
		Direccion calleBasualdo = new Direccion();
		calleBasualdo.setCalle("Basualdo");
		calleBasualdo.setBarrio(villaLuro);
		getSession().save(calleBasualdo);
		
		Direccion calleMitre = new Direccion();
		calleMitre.setCalle("Av. Mitre");
		calleMitre.setBarrio(avellaneda);
		getSession().save(calleMitre);
		
		Direccion donBosco = new Direccion();
		donBosco.setCalle("Don Bosco");
		donBosco.setBarrio(caballito);
		getSession().save(donBosco);
		
		Farmacia farmacity = new Farmacia ("Farmacity", "Martes");
		farmacity.setDireccion(calleBasualdo);
		getSession().save(farmacity);
		
		Farmacia farmaciaDelOeste = new Farmacia ("Farmacia del Oeste", "Jueves");
		farmaciaDelOeste.setDireccion(calleBasualdo);
		getSession().save(farmaciaDelOeste);
		
		Farmacia farmaciaMitre = new Farmacia ("Farmacia Mitre", "Martes");
		farmaciaMitre.setDireccion(calleMitre);
		getSession().save(farmaciaMitre);
		
		Farmacia farmaciaAzul = new Farmacia ("Farmacia Azul", "Viernes");
		farmaciaAzul.setDireccion(calleBasualdo);
		getSession().save(farmaciaAzul);
		
		List<Farmacia> resultado = getSession().createCriteria(Farmacia.class)
				.createAlias("direccion", "farmaDir")
				.add(Restrictions.eq("farmaDir.barrio", villaLuro))
				.list();
		
		for (Farmacia farmaciaPorBarrio : resultado){
			assertThat(farmaciaPorBarrio.getDireccion().getBarrio().getNombre()).isEqualTo("Villa Luro");
		}
		
	}
	
	
}
