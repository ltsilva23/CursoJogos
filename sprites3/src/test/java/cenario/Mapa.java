package modelo.cenario;

import javax.swing.JFrame;

/**
 *
 * @author wolner
 */
public class Mapa extends JFrame {

    public Mapa() {
        add(new Estagio());
        setTitle("No Space Invaders - Fighting alone * TADS Edition * Created by Wolner");
        setSize(1024, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);        
    }
    
}
