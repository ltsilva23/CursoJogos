package br.com.mariojp.game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class NaveSingleton extends Sprite {
	private int dx;
	private int dy;
	
	public static int life = 3;

	private int alcance;
	
    private ArrayList<Missil> missiles;
    
	private Resolucao resolucao = new Resolucao();

    private static NaveSingleton InstanciaUnica = new NaveSingleton(40, 60, Resolucao.getB_WIDTH());

    
	public NaveSingleton(int x, int y, int alcance) {
		super(x, y);
		this.alcance = alcance;
		initNave();
	}

	public static NaveSingleton getInstanciaUnica() {
		return InstanciaUnica;
	}
	
	private void initNave() {
		missiles = new ArrayList<Missil>(); 
		carregarImagem("/imagens/nave.png"); 
		getImageDimensions();
	}

	public void move() {
		x += dx;
		y += dy;
	}


	public Image getImage() {
		return image;
	}

	public void keyPressed(KeyEvent e) { 
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			atira(); 
			Som.audio.play(); //Instancia da classe som (Se a nave atirar sairá o som de tiro)
		}
		if (key == KeyEvent.VK_LEFT){ 
			dx= -1;
		}if(key==KeyEvent.VK_RIGHT){
			dx = 1;
		}if(key==KeyEvent.VK_UP){
			dy= -1;
		}if(key==KeyEvent.VK_DOWN){
			dy= 1;
		}
	}
	
	private void atira() {
		missiles.add(new Missil(x + width, y + height / 2, alcance ));		
	}

	public void keyReleased(KeyEvent e) { 
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT){ 
			dx =0;
		}if(key==KeyEvent.VK_RIGHT){
			dx =0;
		}if(key==KeyEvent.VK_UP){
			dy=0;
		}if(key==KeyEvent.VK_DOWN){
			dy=0;
		}
	}

	public ArrayList<Missil> getMissiles() {
		return missiles;
	}
}
