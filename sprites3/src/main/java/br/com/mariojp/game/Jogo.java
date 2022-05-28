package br.com.mariojp.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jogo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private TimerCommand timer_command;
	private NaveSingleton nave;
	private BufferedImage Game_Background;// imagem de fundo
	private BufferedImage Game_life;// imagem de fundo


	private int score = 0;

	private ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();

	private Random random = new Random();
		
	private boolean endgame = false;
	
	private final int DELAY = 0;

	private final int B_WIDTH = Resolucao.getB_WIDTH();
	private final int B_HEIGHT = Resolucao.getB_HEIGHT();
		
	public Jogo() {
		initJogo();
	}

	private void initJogo() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		nave = NaveSingleton.getInstanciaUnica();
		
		timer_command = new TimerCommand(new Timer(DELAY, this));
		timer_command.execute();


		try {
			Game_Background = ImageIO.read(getClass().getResource("/imagens/background.png"));// buscando a imagem
			Game_life = ImageIO.read(getClass().getResource("/imagens/life.png"));// buscando a imagem
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	private void drawGameOver(Graphics g) {
		String msg = "GAME OVER";
		Font small = new Font("Arial", Font.BOLD, 25);
		FontMetrics fm = getFontMetrics(small);
		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2, B_HEIGHT / 2);
			
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!endgame) {
			desenhar(g);
		} else {
			
			drawGameOver(g);
			
		}
		Toolkit.getDefaultToolkit().sync();
	}

	private void desenhar(Graphics g) {
		g.drawImage(Game_Background, 0, 0, null);// inserindo a imagem de fundo
		g.drawImage(nave.getImage(), nave.getX(), nave.getY(), this);

		for (Missil m : nave.getMissiles()) {
			if (m.isVisible()) {
				g.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}
		}
		for (Inimigo i : inimigos) {
			if (i.isVisible()) {
				g.drawImage(i.getImage(), i.getX(), i.getY(), this);
			}
		}
		g.setColor(Color.WHITE);
		g.drawString("PONTOS : " + score, 5, 15);

		for (int j = 0; j < (int) NaveSingleton.life; j++) {
			g.drawImage(Game_life, 720 + (j * 16), 5, 30, 30, null);// definir Largura, altura, distancia, posição e
																	// tamanho da imagem life
		}

	}

	private void updateMissiles() {
		ArrayList<?> ms = nave.getMissiles();
		for (int i = 0; i < ms.size(); i++) {
			Missil m = (Missil) ms.get(i);
			if (m.isVisible()) {
				m.move();
			} else {
				ms.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		stopGame();
		updateNave();
		updateMissiles();
		updateInimigo();
		checkCollisions();
		repaint();
	}

	public void checkCollisions() {
		Rectangle r3 = nave.getBounds();
		for (Inimigo alien : inimigos) {
			Rectangle r2 = alien.getBounds();
			if (r3.intersects(r2)) {
				nave.setVisible(false);
				alien.setVisible(false);
				NaveSingleton.life --; // A cada colisão retirar uma vida.

			} else if (NaveSingleton.life < 0) {// Se a quantidade de vida chegar a 0 é informado Game Over
				endgame = true;

			}
		}

		ArrayList<Missil> ms = nave.getMissiles();
		for (Missil m : ms) {
			Rectangle r1 = m.getBounds();
			for (Inimigo alien : inimigos) {
				Rectangle r2 = alien.getBounds();
				if (r1.intersects(r2)) {
					m.setVisible(false);
					alien.setVisible(false);

					// Se a nave tiver entre 3 e 1 vida ganhara 50 pontos.,
					if (NaveSingleton.life >= 2 || NaveSingleton.life <= 3) {//
						score += 50;

					}

				}
			}

		}
	}

	private void updateInimigo() {
		while (inimigos.size() < 5) {
			inimigos.add(new Inimigo(B_WIDTH, random.nextInt(B_HEIGHT - 20) + 10));
		}

		for (int i = 0; i < inimigos.size(); i++) {
			Inimigo inimigo = inimigos.get(i);
			if (inimigo.isVisible()) {
				inimigo.move();
			} else {
				inimigos.remove(inimigo);
			}
		}

	}

	private void stopGame() {
		if (endgame) {
			timer_command.stop();
		}
	}

	private void updateNave() {
		nave.move();
	}

	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			nave.keyPressed(e);
		}
	}
}