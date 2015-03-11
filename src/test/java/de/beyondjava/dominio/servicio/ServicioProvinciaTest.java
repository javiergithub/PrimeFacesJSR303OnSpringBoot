package de.beyondjava.dominio.servicio;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.*;
import org.springframework.test.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.beyondjava.Main;
import de.beyondjava.dominio.modelo.Provincia;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class ServicioProvinciaTest {

	@Autowired
	ServicioProvincia servicioProvincia;
	
	
	@Test
	public void findsFirstPageOfCities() {
		Provincia provincia = new Provincia("Catamarca");
		servicioProvincia.guardar(provincia);
		Provincia provincia2 = null;
		provincia2 =servicioProvincia.findByNombreAllIgnoringCase("Catamarca");
		assertEquals(provincia, provincia2);
	}
	
}