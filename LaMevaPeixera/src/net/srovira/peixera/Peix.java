package net.srovira.peixera;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Peix {
	GImage imatge;
	int velocitat = 5;
	int angle;
	int sexe;
	
	
	public Peix(GImage image, int angle, int sexe) {
		imatge = image;
		this.angle = angle;
		this.sexe = sexe;
	}
	
	public int getAmplada() {
		return (int) imatge.getWidth();
	}
	
	public int getAngle() {
		return angle;
	}
	
	public void setAngle(int newAngle) {
		angle = newAngle;
	}
	
	public void setImage(GImage newImatge) {
		imatge = newImatge;
	}
	
	public GRectangle espaiOcupa() {
		return imatge.getBounds();
	}
	
	
	public int getAltura() {
		return (int)imatge.getHeight();
	}
	
	public void movimentPeix() {
		imatge.movePolar(velocitat, angle);
	}
	
	
	public void posicionarPeix(int x, int y) {
		imatge.setLocation(x, y);
	}
}
