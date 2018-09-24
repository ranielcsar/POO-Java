/*
# Jogo feito por:
#
# Raniel César (ranoob)
#
# Pode usar o código a vontade, mas não
# tire os créditos. :D
#
#
*/

package tableSnake;


import java.awt.Color;
import java.awt.GradientPaint;

public class Propriedades {
    
    static final int COL = 40;
    static final int ROW = 20;
    static final int PIXELS = 30;
    
    static final int initX = COL / 2;
    static final int initY = ROW / 2;
    
    static final int LARGURA = COL * PIXELS;
    static final int ALTURA = ROW * PIXELS;

    static Color BG = Color.decode("#38203e"); 
    static Color FOOD = Color.decode("#e16e81");
    static Color SNAKE = Color.decode("#16f1b4");
    static Color HEAD = Color.decode("#e5ef9f");
    static Color SCORE = Color.decode("#efd19f");
}