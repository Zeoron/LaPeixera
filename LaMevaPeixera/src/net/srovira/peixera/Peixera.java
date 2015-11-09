package net.srovira.peixera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GRectangle;

public class Peixera {
	List<Peix> peixos = new ArrayList<Peix>();
	Random aleatori = new Random();
	int angle = 360;
	int acaba = peixos.size();
	
	int altura;
	int amplada;
	
	GRectangle pantalla = new GRectangle(0 ,0 , amplada, altura);
	
	public Peixera (int x, int y) {
		amplada = x;
		altura = y;
	}
	
	
	
	public void crearPeixos(Peix pes) {
		peixos.add(pes);
	}
	public void posicionarPeix() {
		for (Peix p : peixos) {
			p.posicionarPeix(aleatori.nextInt(amplada-p.getAmplada()), 
					aleatori.nextInt(altura-p.getAltura()));
		}
	}
	public void mourePeixos() {
		
		
		
		for (Peix p : peixos) {
			p.movimentPeix();
			colisionaPeix(p);
			
		}
	}
	public boolean finalitza() {
		if (acaba==1) {
			return false;
		}
		return true;
	}
	
	
	public void colisionaPeix(Peix p) {
		//Part del programa que fa que els peixos rebotin
		/*if (p.espaiOcupa().getX()<=pantalla.getX()||
				p.espaiOcupa().getX()+p.getAmplada()>=(amplada)) {
			p.setAngle(180-p.getAngle());
		}
		if (p.espaiOcupa().getY()<=pantalla.getY()||
				p.espaiOcupa().getY()+p.getAltura()>=(altura)) {
			p.setAngle(p.getAngle()*-1);
		}*/
		if (p.espaiOcupa().getX()>amplada) {
			int temp1 = (int)p.espaiOcupa().getX()+1;
			int temp2 = temp1%amplada;
			int temp3 = temp2-p.getAmplada();
			p.posicionarPeix(temp3, (int)p.espaiOcupa().getY());
		}
		if (p.espaiOcupa().getX()<0-p.getAmplada()) {
			p.posicionarPeix(amplada, (int)p.espaiOcupa().getY());
		}
		if (p.espaiOcupa().getY()>altura) {
			int temp1 = (int)p.espaiOcupa().getY()+1;
			int temp2 = temp1%altura;
			int temp3 = temp2-p.getAltura();
			p.posicionarPeix((int)p.espaiOcupa().getX(), temp3);
		}
		if (p.espaiOcupa().getY()<0-p.getAltura()) {
			p.posicionarPeix((int)p.espaiOcupa().getX(), altura);
		}
	}
	
	
}
