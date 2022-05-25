package modelo.municao;

import java.awt.Color;
import java.awt.Graphics;
import modelo.player.Nave;
import modelo.tiro.Tiro;
import interfaces.strategy.ComportamentoDisparo;

public class FogoEspacial implements ComportamentoDisparo {

    @Override
    public void load(Tiro tiro, Graphics g) {
        g.setColor(Color.red);
        g.fillRect(tiro.getX() - 2, tiro.getY() + 1, 4, 20);
        g.fillRect(tiro.getX() - 4, tiro.getY() + 5, 8, 10);
    }

    @Override
    public void update(Tiro tiro, Nave nave) {
        int tiroY = tiro.getY();
        int naveX = nave.getX() + 15;
        tiroY += tiro.getVELOCIDADE();
        tiro.setY(tiroY);
        tiro.setX(naveX);
        if (tiro.getY() > tiro.getAltura()) {
            tiro.setVisible(false);
        }
    }
    
}
