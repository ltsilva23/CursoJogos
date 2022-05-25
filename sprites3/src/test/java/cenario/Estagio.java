package modelo.cenario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import modelo.controle.Joystick;
import modelo.player.Nave;
import modelo.tiro.Tiro;


public class Estagio extends JPanel implements ActionListener {

    private Nave nave;
    private Timer temporizador;
    private Tiro tiro;

    public Estagio() {
        nave = new Nave();
        temporizador = new Timer(3, this);
        temporizador.start();        
        addKeyListener(new Joystick(this.nave));
        setFocusable(true);
        setDoubleBuffered(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        nave.load(g);
        List<Tiro> tiros = nave.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            tiro = tiros.get(i);
            tiro.carregarTiro(tiro, g);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        nave.update();
        List<Tiro> tiros = nave.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            tiro = tiros.get(i);
            if (tiro.isVisible()) {
                tiro.atualizarTiro(tiro);
            } else {
                tiros.remove(i);
            }
        }
        repaint();
    }
    
}
