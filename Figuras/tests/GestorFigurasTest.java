import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GestorFigurasTest {
	
	GestorFiguras gFiguras;
	Figura f1;
	@Before
	public void setUp() throws Exception {
		gFiguras = new GestorFiguras();
	}
	
	@Test
	public void testGuardar() {
		f1 = new Figura("D");
		gFiguras.guardar(f1);
	}
	
	@Test
	public void testRecuperar() {
		gFiguras.recuperar("a");
	}
	
	@Test
	public void testCambiar() {
		gFiguras.cambiar(new Figura("D"));
	}
	
	@Test
	public void testExiste() {
		gFiguras.existe("a");
	}
	
	@Test
	public void testRecuperarLista() {
		//gFiguras.recuperarLista();
	}


}
