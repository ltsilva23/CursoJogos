/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.strategy;

import java.awt.Graphics;
import modelo.tiro.Tiro;
import modelo.player.Nave;


public interface ComportamentoDisparo {

    public void load(Tiro tiro, Graphics g);

    public void update(Tiro tiro, Nave nave);
    
}
