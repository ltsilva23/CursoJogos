package modelo.tiro;

import interfaces.strategy.ComportamentoDisparo;
import java.awt.Graphics;
import modelo.player.Nave;

public class Tiro {

    private int x;
    private int y;
    private Nave nave;
    private boolean isVisible;
    private static final int ALTURA = 675;
    private static int VELOCIDADE = -2;
    
    //Interface do conjunto de classes de tiros usada no padrão Strategy
    private ComportamentoDisparo disparo;

    public Tiro(int x, int y, Nave nave) {
        this.x = x;
        this.y = y;
        this.nave = nave;
        isVisible = true;
    }

    public void carregarTiro(Tiro tiro, Graphics g) {
        disparo.load(tiro, g);
    }

    public void atualizarTiro(Tiro tiro) {
        disparo.update(tiro, nave);
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public static int getAltura() {
        return ALTURA;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setDisparo(ComportamentoDisparo disparo) {
        this.disparo = disparo;
    }
    
}
