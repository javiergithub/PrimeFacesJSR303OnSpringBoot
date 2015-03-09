package de.beyondjava;

import de.beyondjava.dominio.modelo.Provincia;
import de.beyondjava.dominio.servicio.ServicioProvincia;
import de.beyondjava.dominio.servicio.impl.ServicioProvinciaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import de.beyondjava.main.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.*;
import org.springframework.test.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import de.beyondjava.dominio.dao.repository.ProvinciaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class ServicioProvinciaTest {

	@Autowired
	@Qualifier("provinciaRepository")
	ProvinciaRepository provinciaRepository;
	
	
	@Test
	public void findsFirstPageOfCities() {
//		Page<City> cities = this.repository.findAll(new PageRequest(0, 10));
//		assertThat(cities.getTotalElements(), is(greaterThan(20L)));
	}
	
}