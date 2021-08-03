package Rompecabezas;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;



public class Nodo implements Comparator<Nodo> {
	
	
	public int fn,gn,hn;
	public int[][] tablero= new int[3][3];
	private Timestamp time;
	
	private void tiemponuevo() {
		Date date= new java.util.Date();
		time = new Timestamp(date.getTime());
	}
	
	
	private int[][] clonar(int[][] tableroInicial) {
		 
		int[][] Nuevo = new int[3][3];
			for(int i = 0; i<3; i++)
			{
				for(int j = 0; j< 3; j++)
				{
					Nuevo[i][j] = tableroInicial[i][j];
				}
			}		
			return Nuevo;
	}

	
	
	
	public Nodo() {
		super();
		tiemponuevo();
	}
	
	public Nodo(int fn) {
		super();
		this.fn = fn;
		tiemponuevo();
	}
	
	public Nodo(Nodo x) {
		super();
		this.fn = x.fn;
		this.gn = x.gn;
		this.hn = x.hn;
		this.tablero = clonar(x.getTablero());
		tiemponuevo();
			}
	
		
	public Nodo(int fn, int gn, int hn, int[][] tab) {
		super();
		this.fn = fn;
		this.gn = gn;
		this.hn = hn;
		this.tablero = tab;
		tiemponuevo();
	}

	public int getFn() {
		return fn;
	}

	public void setFn(int fn) {
		this.fn = fn;
	}

	public int getGn() {
		return gn;
	}

	public void setGn(int gn) {
		this.gn = gn;
	}

	public int getHn() {
		return hn;
	}

	public void setHn(int hn) {
		this.hn = hn;
	}

	
	public int[][] getTablero() {
		return tablero;
	}

	
	public void setEstado(int[][] estado) {
		this.tablero = estado;
	}

	public double calcularFN(Nodo estadoMeta) {
		
		this.hn = calcularHN(estadoMeta);
		return this.fn = this.gn + this.hn;	
	}

	
	private int calcularHN(Nodo estadoMeta){
		int acum = 0;
		for(int i = 0; i<3; i++)
			{
				for(int j = 0; j<3; j++)
				{
					if(this.tablero[i][j]!=estadoMeta.getTablero()[i][j])
						acum++;
				}
			}
		return acum;
		
	}

	
	
	public void generarHijo(Nodo padre,mover piezas )
	{
		Juego j= new Juego();

		this.tablero[piezas.getFilaFinal()][piezas.getColumnaFinal()] = this.tablero[piezas.getFilaInicial()][piezas.getColumnaInicial()];
		this.tablero[piezas.getFilaInicial()][piezas.getColumnaInicial()]=0;
		
		this.gn++;
		j.imprimir(this.tablero);
		
	}
	
	
	
	@Override
	public String toString() {
		return "Estado [fn=" + fn + ", gn="+ gn + ", hn=" + hn + "]";
	}

  
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		if (!Arrays.deepEquals(tablero, other.tablero))
			return false;
		return true;
	}

	@Override
	public int compare(Nodo prueba1, Nodo prueba2) {
		
		
		//con los 2 sirve para dar la solucion 
		
		// aqui con este ejecuta y sale la respuesta solo que demora un poco  en la ejecucion
		
		/* TODO Auto-generated method stub
		if(prueba1.getFn()>prueba2.getFn())
		{
			return 1;
		}else
		   if (prueba1.getFn()<prueba2.getFn()){
			return -1;}
		
		return 0;*/
		
		
		
		// codigo probado del profesor con tiempo es casi lo mismo solo tiene mas condiciones si no se da la respuesta
		
		if(Double.isInfinite(prueba1.getFn())||Double.isInfinite(prueba2.getFn())){
			try {
				throw new Exception("Distancia a Estado meta es infinita o no calculada.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			if(prueba1.getFn()>prueba2.getFn())
			{
				return 1;
			}else if(prueba1.getFn()<prueba2.getFn()){
				return -1;
			}else{
				if(prueba1.time.compareTo(prueba2.time)<0)
				{
					return 1;
				}else{
					return -1;
				}
			}
		}
		return 0;
	}
	
	

	
}
