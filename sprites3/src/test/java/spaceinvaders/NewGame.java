/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import modelo.cenario.Mapa;


public class NewGame {
    
    public static void main(String[] args) {
        new Mapa();
    }
    
    /*
    O Padrão de Projeto utilizado para alternar os tipos de tiro da nave foi o
    Strategy. Utilizando o princípio de projeto "Identificar os apectos que 
    mudam na aplicação e separar dos que não mudam.", foi possível separar os
    tipos de tiros em um conjunto de classes com caracteristicas semelhantes.
    
    Este conjunto é acessível através da interface "ComportamentoDisparo", que
    é um atributo da classe "Tiro", onde é possível atribuir qualquer tipo de 
    tiro ("Fogo espacial" ou "Raio côsmico") através do método "setDisparo()"
    e intercambiá-los entre sí.
    
    Esta atribuição só é possível pois ambos os tiros implementam os métodos 
    "load(Tiro tiro, Graphics g)" e "update(Tiro tiro, Nave nave)" presentes 
    na interface. Isto nos leva a outro princípio de projeto "Programar para 
    uma interface, não para uma implementação."
    
    Nesta aplicação a atribuição dinâmica dos tipos de tiro ocorre na classe
    "Nave" que, ao receber o KeyEvent.VK_F3, define uma flag que irá determinar 
    qual dos dois tipos de tiro será atribuido via método "setDisparo()".
    
    De forma mais cimple, o padrão Strategy permite que o algoritmo varie 
    independente do cliente que o usa.    
    */
}
