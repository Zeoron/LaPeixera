package net.srovira.peixera;

import java.awt.Color;
import java.util.Random;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class App extends GraphicsProgram {
	//VARIABLES NECESARIES PER EXECUTAR EL PROGRAMA
	private static final long serialVersionUID = -3496973863839908191L;
	private static final int [] POSSIBLESANGLES = {0,90,180,270};
	
	Random aleatori = new Random();
	Peixera lloc;

	//METODE PRINCIPAL D'EXECUCI� DEL PROGRAMA
	public void run() {
		setSize(800, 600);
		setBackground(Color.LIGHT_GRAY);
		pause(100);
		
		lloc = new Peixera(this, getWidth(), getHeight());
		
		invocarPeixos();
		pause(1000);
		lloc.posicionarPeix();
		pause(1000);
		
		while (lloc.finalitza()) {
			lloc.mourePeixos();
			pause(10);
		}
	}
	
	//METODE DE CREACI� DE PEIXOS
	public void invocarPeixos() {
		for (int i = 0; i<100;i++) {
			Peix temp = crearPeix();
			lloc.crearPeixos(temp);
		}
	}

	public Peix crearPeix() {
		GImage pez;
		int anglePeix = POSSIBLESANGLES[aleatori.nextInt(POSSIBLESANGLES.length)];
		int sexePeix = aleatori.nextInt(2);
		String textPeix = "peix" + sexePeix + "" + anglePeix + ".png";
		pez = new GImage(textPeix);
		add(pez);
		Peix temp = new Peix(pez, anglePeix, sexePeix);
		return temp;
	}
	
	//METODE PER VARIAR LA ESCALA DELS PEIXOS I OBTENIR DIFERENTS MIDES
	/*public double midaAleatoria() {
		double result;
		double start = 0.5;
		double end = 1;
		double random = aleatori.nextDouble();
		result = start + (random * (start-end));
		return result;
		
		
	}*/

}
