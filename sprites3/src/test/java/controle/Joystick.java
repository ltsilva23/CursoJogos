package modelo.controle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import modelo.player.Nave;

public class Joystick extends KeyAdapter {

    Nave nave;

    public Joystick(Nave nave) {
        this.nave = nave;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        nave.keyPressed((e));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        nave.keyRelease(e);
    }
    
}
