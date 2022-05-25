/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.tiro.Tiro;
import modelo.municao.FogoEspacial;
import modelo.municao.RaioCosmico;

/**
 *
 * @author wolner
 */
public class Nave {

    private int x;
    private int y;
    private Tiro tiro;
    private int MoverNave;
    private List<Tiro> tiros;
    private boolean controleDisparo;

    public Nave() {
        this.x = 450;
        this.y = 680;
        this.controleDisparo = false;
        tiros = new ArrayList<Tiro>();
    }

    public void load(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x - 2, y + 1, 5, 15);
        g.fillRect(x + 10, y + 1, 5, 4);
        g.fillRect(x + 6, y + 4, 5, 4);
        g.fillRect(x + 2, y + 7, 5, 4);
        g.fillRect(x + 10, y + 10, 10, 8);
        g.fillRect(x + 13, y + 5, 4, 8);
        g.fillRect(x + 10, y - 10, 11, 4);
        g.fillRect(x + 13, y - 6, 5, 7);
        g.fillRect(x + 27, y + 1, 5, 15);
        g.fillRect(x + 15, y + 1, 5, 4);
        g.fillRect(x + 19, y + 4, 5, 4);
        g.fillRect(x + 23, y + 7, 5, 4);
    }

    public void update() {
        x += MoverNave;
    }

    public void keyPressed(KeyEvent tecla) {

        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_F3) {
            if (this.controleDisparo) {
                this.controleDisparo = false;
            } else {
                this.controleDisparo = true;
            }
        }

        if (codigo == KeyEvent.VK_SPACE) {

            this.tiro = new Tiro(this.x + 14, this.y - 35, this);

            if (controleDisparo) {
                tiro.setDisparo(new RaioCosmico());
            } else {
                tiro.setDisparo(new FogoEspacial());
            }

            this.tiros.add(tiro);
        }

        if (codigo == KeyEvent.VK_LEFT) {
            MoverNave = -3;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            MoverNave = 3;
        }

    }

    public void keyRelease(KeyEvent event) {

        int codigo = event.getKeyCode();

        if (codigo == KeyEvent.VK_LEFT) {
            MoverNave = 0;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            MoverNave = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

}
