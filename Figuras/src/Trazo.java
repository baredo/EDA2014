
/**
 * Representa un trazo echo a mano
 * @author Felipe Iba�ez
 *
 */
public class Trazo {
	/**
	 * Representa un tipo de trazo
	 * @author Felipe Iba�ez
	 *
	 */
	 enum Tipo { 
			D, B, I, S;//derecha,bajar,izquierda,subir

			/**
			 * Devuelve cual es el tipo de Trazo despu�s de girar 90� el trazo actual
			 * @return un tipo de trazo
			 */
			public Tipo girarDerecha(){
				int pos = (this.ordinal() + 1) % Tipo.values().length;
				return Tipo.values()[pos];
			}
			/**
			 * Devuelve la representacion de un tipo de Trazo como una cadena de caracteres
			 * @return una cadena de caracteres
			 */
			public String toString(){
				return name();
			}
		}

	private Tipo orientacion;
	
	public Trazo(char c){
		switch(c){
			case 'D': 
			case 'B': 
			case 'I': 
			case 'S': orientacion = Tipo.valueOf(new Character(c).toString());
					  break;
			default: 
				throw new IllegalArgumentException("el trazo debe ser D, B, I � S");
		}
	}
	
	public char getOrientacion(){
		return orientacion.name().charAt(0);
	}
	
	/**
	 * Gira a la derecha el trazo actual
	 */
	public void girarDerecha(){
		orientacion = orientacion.girarDerecha();
	}

	@Override
	/**
	 * Devuelve una copia exacta del trazo actual
	 */
	protected Object clone() throws CloneNotSupportedException {
		return new Trazo(orientacion.name().charAt(0));
	}

	@Override
	/**
	 * Varifica si el trazo actual y el dado por parametro son iguales
	 * @return True si son iguales, y False, en caso contrario
	 */
	public boolean equals(Object obj) {
		Trazo t = (Trazo) obj;
		return this.orientacion.equals(t.orientacion);
	}

	@Override
	/**
	 * Devuelve la representacion de un trazo como una cadena de caracteres
	 */
	public String toString() {
		return this.orientacion.toString();
	}
	
	
}
