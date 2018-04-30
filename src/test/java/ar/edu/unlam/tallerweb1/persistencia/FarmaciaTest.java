package ar.edu.unlam.tallerweb1.persistencia;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

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
		
		assertThat(resultado).hasSize(2);
	}
	
	
}
