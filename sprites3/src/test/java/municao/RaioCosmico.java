package modelo.municao;

import java.awt.Color;
import java.awt.Graphics;
import modelo.player.Nave;
import modelo.tiro.Tiro;
import interfaces.strategy.ComportamentoDisparo;

public class RaioCosmico implements ComportamentoDisparo {

    @Override
    public void load(Tiro tiro, Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(tiro.getX() - 2, tiro.getY() + 1, 6, 15);
    }

    @Override
    public void update(Tiro tiro, Nave nave) {
        int tiroY = tiro.getY();
        tiroY += tiro.getVELOCIDADE();
        tiro.setY(tiroY);
        if (tiro.getY() > tiro.getAltura()) {
            tiro.setVisible(false);
        }
    }
    
}
