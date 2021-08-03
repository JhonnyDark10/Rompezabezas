package Rompecabezas;

import java.util.ArrayList;
import Rompecabezas.Implementacion;
public class Juego {

		
		public static Nodo estadoInicial;
		public static Nodo estadoMeta;
		public static int n=3,f,c,hn;	
		
		public static void main(String[] args){
			
			 
			 
			ArrayList<Nodo> dis;
			
			Juego t=new Juego();
				
				
			estadoMeta=new Nodo(0,0,0,t.meta());	
			estadoInicial=new Nodo(0,0,0,t.llenarEstadoInicial());
			
			dis =new ArrayList<Nodo>();
				
				 
			System.out.println("Estado Meta");
			t.imprimir(estadoMeta.getTablero());
			
			System.out.println("Estado Inicial");
			t.imprimir(estadoInicial.getTablero());

			
			Implementacion p= new Implementacion();
			p.prueba(estadoInicial,estadoMeta);

			}

			
	public int[][] llenarEstadoInicial(){
			
			int matrizInicial[][] = new int[3][3];
			
			matrizInicial[0][0] = 7;
			matrizInicial[0][1] = 2;
			matrizInicial[0][2] = 4;
			matrizInicial[1][0] = 5;
			matrizInicial[1][1] = 0;
			matrizInicial[1][2] = 6;
			matrizInicial[2][0] = 8;
			matrizInicial[2][1] = 3;
			matrizInicial[2][2] = 1;
			
			return matrizInicial ;	
		}
		

		public int[][] meta(){		
            
			int meta[][] = new int[3][3];
			
			meta[0][0] = 0;
			meta[0][1] = 1;
			meta[0][2] = 2;
			meta[1][0] = 3;
			meta[1][1] = 4;
			meta[1][2] = 5;
			meta[2][0] = 6;
			meta[2][1] = 7;
			meta[2][2] = 8;
			
			return meta ;	
			
		}
		
		public void imprimir(int[][] m){		
			
			for(int j=0;j<3;j++)
			{	
				System.out.println(m[j][0] + " " + m[j][1]+ " " + m[j][2]);
			}	
	}

		public boolean esMeta(Nodo esMeta){
			if(esMeta.equals(estadoMeta)){
				return true;
			}else{
				return false;
			}

}}
