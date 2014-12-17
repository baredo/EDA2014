
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.math.*;

public class Figura {
	String nombre;
	LinkedList<Trazo> trazos;
	/**
	 * Crea una figura con los trazos indicados
	 * @param trazos, una secuencia de trazos
	 */
	public Figura(String trazos){
		this(trazos,"sin nombre");
	}
	
	/**
	 * Crea una figura con los trazos indicados y lo nombra con el nombre dado
	 * @param trazos, una secuencia de trazos 
	 * @param nombre, un nombre 
	 */
	public Figura(String trazos, String nombre){
		this.trazos = new LinkedList<Trazo>();
		for(int i=0; i<trazos.length(); i++){
			this.trazos.add(new Trazo(trazos.charAt(i)));
		}
	}
	
	/**
	 * Devuelve el nombre e la figura
	 * @return el nombre
	 */
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve una lista de trazos
	 * @return lista de trazos
	 */
	public List<Trazo> getTrazos(){
		return (List<Trazo>) trazos;
	}
	
	/**
	 * A�ade un trazo al final de los trazos de la figura
	 * @param c, letra que indica un trazo
	 */
	public void anadirTrazo(char c){
		this.trazos.add(new Trazo(c));
	}
	
	/**
	 * A�ade un trazo al inicio o al final de los trazos de la figura
	 * @param c, letra que indica un trazo
	 * @param alInicio, si True indica al inicio y False, al final
	 */
	public void anadirTrazo(char c, boolean alInicio){
		if(alInicio)this.trazos.addFirst(new Trazo(c));
		this.trazos.addLast(new Trazo(c));
	}
	
	/**
	 * Fusiona la figura 'f' al final de la figura actual
	 * @param f, una figura
	 */
	public void fusionar(Figura f){
		Iterator<Trazo> iterator = f.getTrazos().iterator();
		while(iterator.hasNext()){
			this.trazos.add(iterator.next());
		}
	}
	
	/**
	 * Inserta la figura 'f' despues del trazo en la posicion 'pos'.
	 * Pre: La figura 'f' debe ser una secuencia cerrada, es decir, debe terminar en el punto donde empieza. 
	 * Porque si no repercute en la anchura y altura.
	 * @param pos, posicion entre [1..longitud(figura)]
	 * @param f, una figura
	 */
	public void insertar(int pos, Figura f){
		Iterator<Trazo> iterator = f.getTrazos().iterator();
		int contador = 0;
		while(iterator.hasNext()){
			this.trazos.add(pos+contador, iterator.next());
			contador++;
		}
	}
	
	/**
	 * Elimina la secuencia de trazos desde la �ltima ocurrencia del trazo de tipo 'c'
	 * @param c, un tipo de trazo
	 */
	public void eliminarDesdeUltimoTrazo(char c){
		Iterator<Trazo> iterator = this.trazos.iterator();
		int contador = 0;
		int buffer = -1;
		while(iterator.hasNext()){
			if(iterator.next().getOrientacion() == c){
				buffer = contador;
			}
			contador++;
		}
		if(buffer == -1) return;
		for(int i=0; i<this.trazos.size()-buffer; i++){
			this.trazos.remove(buffer);
		}
	}
	
	/**
	 * Sustituye el primer trazo de tipo 'c' con los trazos dados en 'trazos'
	 * Pre: Loz trazos dados deben de formar una secuencia casi-cerrada-1, es decir, le falta un trazo para que sea cerrada y
	 * deber�a de seguir correctamente la secuencia con el siguinte trazo a 'c'. Porque si no repercute en la anchura y altura.
	 * @param c, un tipo de trazo
	 * @param trazos
	 */
	public void sustituir(char c, String trazos){
		Figura figura = new Figura(trazos);
		int pos = this.trazos.indexOf(c);
		this.trazos.remove(pos);
		insertar(pos, figura);
	}
	
	/**
	 * Gira la figura 90� a la derecha
	 */
	public void girarDerecha(){
		Iterator<Trazo> iterator = this.trazos.iterator();
		while(iterator.hasNext()){
			iterator.next().girarDerecha();
		}
	}
	
	/**
	 * Aplica una homotecia de factor 2 a la figura
	 */
	public void homotecia2(){
		Figura auxiliar = new Figura("");
		Iterator<Trazo> iterator = this.trazos.iterator();
		char buffer;
		while(iterator.hasNext()){
			buffer = iterator.next().getOrientacion();
			auxiliar.anadirTrazo(buffer);
			auxiliar.anadirTrazo(buffer);
		}
		
	}
	
	/**
	 * Devuelve la longitud de la figura, es decir, el numero de trazos que componen la figura
	 * @return longitud de la figura
	 */
	public int longitud(){
		return this.trazos.size();
	}
	
	/**
	 * Devuelve la altura de la figura
	 * @return altura de la figura
	 */
	public int altura(){
		Iterator<Trazo> iterator = this.trazos.iterator();
		char buffer;
		int contador = 0;
		int max = 0;
		int min = 0;
		int contadorAbsoluto=0;
		while(iterator.hasNext()){
			buffer = iterator.next().getOrientacion();
			if(buffer == 'S') contador++;
			else if(buffer == 'B') contador--;
			contadorAbsoluto = Math.abs(contador);
			if(contadorAbsoluto > max && contador > 0) max = contadorAbsoluto;
			if(contadorAbsoluto > min && contador < 0) min = contadorAbsoluto;
		}
		return max+min;
	}
	
	/**
	 * Devuelve la anchura de la figura
	 * @return anchura de la figura
	 */
	public int anchura(){
		Iterator<Trazo> iterator = this.trazos.iterator();
		char buffer;
		int contador = 0;
		int max = 0;
		int min = 0;
		int contadorAbsoluto=0;
		while(iterator.hasNext()){
			buffer = iterator.next().getOrientacion();
			if(buffer == 'D') contador++;
			else if(buffer == 'I') contador--;
			contadorAbsoluto = Math.abs(contador);
			if(contadorAbsoluto > max && contador > 0) max = contadorAbsoluto;
			if(contadorAbsoluto > min && contador < 0) min = contadorAbsoluto;
		}
		return max+min;
	}
	
	/**
	 * Calcula y devuelve la superficie de la figura
	 * @return superficie de la figura
	 */
	public int superficie(){
		return anchura()*altura();
	}

	/**
	 * Verifica si la figura actual y la fgura dada por parametro 'obj' son iguales
	 * @paramm obj, una figura
	 * @return True si son iguales y False, en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// NOTA: No se puede utilizar la comparacion entre Strings.
		return super.equals(obj);
	}

	/**
	 * Verifica si la figura actual y la figura 'f' son homoteticas. Es homotetica si las dos figuras tienen la misma orientaci�n 
	 * y aplicando una secuencia de homotecias del factor 2 a una de las figuras se obtiene la otra.
	 * @param f, una figura
	 * @return True si es homotetica y False, en caso contrario
	 */
	public boolean esHomotetica(Figura f){
		// TODO 
		// NOTA: No se puede utilizar la comparacion entre Strings.
		return false;
	}
	
	/**
	 * Verifica si la figura actual y la figura 'f' son semejantes. Es semejante si aplicando una secuencia de homotecias del 
	 * factor 2 y giros a la derecha a una de las figuras se obtiene la otra.
	 * @param f, una figura
	 * @return True si es semejante y False, en caso contrario
	 */
	public boolean esSemejante(Figura f){
		// TODO
		// NOTA: No se puede utilizar la comparacion entre Strings.
		return false;
	}
	
	/**
	 * Devuelve una copia exacta a la figura actual
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/** 
	 * Devuelve la representacion de una figura de trazos como una cadena de caracteres
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
