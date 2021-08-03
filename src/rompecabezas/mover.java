package Rompecabezas;

import java.util.ArrayList;

public class mover {
	
	public int filaInicial = -1;
	public int filaFinal = -1;
	public int columnaInicial = -1;
	public int columnaFinal = -1;
	
	public mover()
	{
		super();
	}
	
	public mover(int filaInicial, int columnaInicial,int filaFinal, int columnaFinal) {
		super();
		this.filaInicial = filaInicial;
		this.filaFinal = filaFinal;
		this.columnaInicial = columnaInicial;
		this.columnaFinal = columnaFinal;
	}


	public int getFilaInicial() {
		return filaInicial;
	}

	public void setFilaInicial(int filaInicial) {
		this.filaInicial = filaInicial;
	}

	public int getFilaFinal() {
		return filaFinal;
	}

	public void setFilaFinal(int filaFinal) {
		this.filaFinal = filaFinal;
	}

	public int getColumnaInicial() {
		return columnaInicial;
	}

	public void setColumnaInicial(int columnaInicial) {
		this.columnaInicial = columnaInicial;
	}

	public int getColumnaFinal() {
		return columnaFinal;
	}

	public void setColumnaFinal(int columnaFinal) {
		this.columnaFinal = columnaFinal;
	}
	

 
	public ArrayList<mover> desplazamientos(int[][] MatrizActual, int n){
		
		ArrayList<mover> desplaz= new ArrayList<mover>();
		mover mov;
			
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				if(MatrizActual[i][j]==0){
					if(!(i==0)){
						System.out.println("Abajo");
						
						mov= new mover(i-1,j,i,j);
						desplaz.add(mov);	
					}
					
					if(!(j==(n-1))){
						System.out.println("A la izquierda");
						mov= new mover(i,j+1,i,j);
						desplaz.add(mov);	
					}
					
					if(!(i==(n-1))){
						System.out.println("Arriba");
						
						mov= new mover(i+1,j,i,j);
						desplaz.add(mov);	
					}
					
					if(!(j==0)){
						System.out.println("A la derecha");
					
						mov= new mover(i,j-1,i,j);
						desplaz.add(mov);	
					}
					
					
				}
			}
				
		return desplaz;
		
	}
}
