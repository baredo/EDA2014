
import java.util.Hashtable;
import java.util.List;

public class GestorFiguras {
	Hashtable<String,Figura> hashtable;
	
	
	/**
	 * Crea un gestor de figuras vacia
	 */
	public GestorFiguras(){
		hashtable = new Hashtable<String,Figura>();
	}
	
	/**
	 * Anade una nueva figura
	 * @param figura
	 */
	public void guardar(Figura figura){
		while(existe(figura.getNombre())){
			figura.setNombre(figura.getNombre()+"1");
			System.out.println("Ya existia "+figura.getNombre()+". Se ha renombrado por "+figura.getNombre()+"1");
		}
			hashtable.put(figura.getNombre(), figura);	
	}
	
	/**
	 * Devuelve la figura que tiene el nombre 'nombre' y si no null
	 * @param nombre, el nombre de una figura
	 * @return la figura
	 */
	public Figura recuperar(String nombre){
		return hashtable.get(nombre);
	}
	
	/**
	 * Cambia la figura que tiene el mismo nombre que la figura dada
	 * @param figura, una figura 
	 */
	public void cambiar(Figura figura){
		hashtable.put(figura.getNombre(), figura);			
	}
	
	/**
	 * Verifica si existe o no una figura con el mismo nombre que el parametro 'nombre'
	 * @param nombre, el nombre de una figura
	 * @return devuelve True si existe y False, en caso contrario
	 */
	public boolean existe(String nombre){
		return hashtable.containsKey(nombre);
	}
	
	/**
	 * Devuelve una lista de figuras que tengan los mismos nombres que contiene el array 'nombres'
	 * @param nombres, una lista de nombres
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarLista(String [] nombres){
		//TODO
		return null;
	}

	/**
	 * Devuelve una lista de figuras que son iguales a la figura dada 
	 * @param figura, una figura
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarIguales(Figura figura){
		//TODO
		return null;
	}

	/**
	 * Devuelve una lista de figuras que son semejantes a la figura dada 
	 * @param figura, una figura
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarSemejantes(Figura figura){
		//TODO
		return null;
	}

}
