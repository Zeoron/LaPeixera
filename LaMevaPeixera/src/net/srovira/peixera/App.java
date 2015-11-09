package net.srovira.peixera;

import java.awt.Color;
import java.util.Random;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class App extends GraphicsProgram {
	private static final long serialVersionUID = -3496973863839908191L;
	private static final int [] POSSIBLESANGLES = {0,90,180,270};
	
	Random aleatori = new Random();
	Peixera lloc;

	public void run() {
		setSize(800, 600);
		setBackground(Color.LIGHT_GRAY);
		pause(100);
		
		lloc = new Peixera(getWidth(), getHeight());
		
		invocarPeixos();
		lloc.posicionarPeix();
		
		while (lloc.finalitza()) {
			lloc.mourePeixos();
			pause(100);
		}
	}
	
	public void invocarPeixos() {
		GImage pez;
		for (int i = 0; i<20;i++) {
			int anglePeix = POSSIBLESANGLES[aleatori.nextInt(POSSIBLESANGLES.length)];
			int sexePeix = aleatori.nextInt(2);
			String textPeix = "peix" + sexePeix + "" + anglePeix + ".png";
			pez = new GImage(textPeix);
			/*pez.scale(midaAleatoria());*/
			add(pez);
			Peix temp = new Peix(pez, anglePeix, sexePeix);
			lloc.crearPeixos(temp);
		}
	}
	
	
	/*public double midaAleatoria() {
		double result;
		double start = 1;
		double end = 1;
		double random = aleatori.nextDouble();
		result = start + (random * (start-end));
		return result;
		
		
	}*/

}
