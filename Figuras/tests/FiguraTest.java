import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FiguraTest {
	
	Figura f1;
	Figura f2;
	Figura f3;
	@Before
	public void setUp() throws Exception {
		f1 = new Figura("SSSBBBDDDBBBIII");
		f2 = new Figura("SB");
		f3 = new Figura("ID");
	}
	
	@Test
	public void testSetNombre(){
		f1.setNombre("a");
		assertTrue(f1.getNombre() == "a");
	}
	
	@Test
	public void testGetTrazos(){
		assertTrue((f2.getTrazos().get(0).getOrientacion() == 'S'));
		assertTrue((f2.getTrazos().get(1).getOrientacion() == 'B'));
	}
	
	@Test
	public void testAñadirTrazo(){
		assertFalse(f2.getTrazos().get(f2.getTrazos().size()-1).getOrientacion() == 'I');
		f2.anadirTrazo('I');
		assertTrue(f2.getTrazos().get(f2.getTrazos().size()-1).getOrientacion() == 'I');
	}
	
	@Test
	public void testAñadirTrazo2(){
		assertFalse(f2.getTrazos().get(f2.getTrazos().size()-1).getOrientacion() == 'I');
		f2.anadirTrazo('I',false);
		assertTrue(f2.getTrazos().get(f2.getTrazos().size()-1).getOrientacion() == 'I');
		
		assertFalse(f2.getTrazos().get(0).getOrientacion() == 'I');
		f2.anadirTrazo('I',true);
		assertTrue(f2.getTrazos().get(0).getOrientacion() == 'I');
	}
	
	@Test
	public void testFusionar(){
		f2.fusionar(f3);
		assertTrue((f2.getTrazos().get(0).getOrientacion() == 'S'));
		assertTrue((f2.getTrazos().get(1).getOrientacion() == 'B'));
		assertTrue((f2.getTrazos().get(2).getOrientacion() == 'I'));
		assertTrue((f2.getTrazos().get(3).getOrientacion() == 'D'));
	}
	
	@Test
	public void testAltura(){
		assertTrue((f1.altura() == 6));
	}
	
	@Test
	public void testAnchura(){
		assertTrue((f1.anchura() == 3));
	}
	
	@Test
	public void superficie(){
		assertTrue(f1.altura()*f1.anchura() == f1.superficie());
	}

}
