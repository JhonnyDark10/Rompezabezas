package Rompecabezas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;




public class Implementacion {
	
		public Nodo prueba(Nodo inicial,Nodo estadoMeta){
			
			Juego t=new Juego();
				
			// COMIENZO
			Nodo estActual = (Nodo) inicial;
			
			estActual.calcularFN(estadoMeta);
			
			Comparator<Nodo> comparador = new Nodo(3);
			PriorityQueue<Nodo> frontera = new PriorityQueue<Nodo>(comparador);
						
			ArrayList<Nodo> explorados = new ArrayList<Nodo>(); 
			
			frontera.add(estActual);
			int contador = 0;
			do{
					
	 			if(frontera.isEmpty()) System.out.println("No existe respuesta!! "); 
				else{
					estActual = frontera.poll();
					contador++;
					if (t.esMeta(estActual))
					{	
				
					System.out.println("Solucion encontrada luego de " + contador + " estados explorados.");
						return estActual; }

					explorados.add(estActual);			
					
					ArrayList<mover> opMovimientos = new mover().desplazamientos(estActual.getTablero(), 3);
					
					for(mover opc: opMovimientos){
						
						System.out.println(" ");
						
						Nodo siguiente=new Nodo(estActual);	
						siguiente.generarHijo(estActual,opc);
						siguiente.calcularFN(estadoMeta);
										
						if(!explorados.contains(siguiente) && !frontera.contains(siguiente))
						{
							frontera.offer(siguiente);
							System.out.println("\nEstado Generado : " + siguiente);
						}else{
							System.out.println("\nEstado Generado pero repetido: " + siguiente);
						}
					}
				}
			
			}while(true);
		}
}
