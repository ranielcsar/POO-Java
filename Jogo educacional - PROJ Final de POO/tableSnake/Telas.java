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
import java.awt.Font;
import java.awt.Graphics;

public class Telas {
   
   private int x;
   private Status status = Status.NAO_COMECOU;
   
   public Telas() {}   
   
   protected void desenhaTitulo(Graphics lapis)
   {
      x = 480;
      
      lapis.setFont(new Font("Pixeled", 0, 50));
      
      lapis.setColor(Propriedades.HEAD);
         lapis.drawString("Table", x, 120);
         
      lapis.setColor(Propriedades.SNAKE);
         lapis.drawString("Snake", x, 200);
         
      desenhaEnter(lapis);
   }
   
   public void desenhaInstrucoes(Graphics lapis)
   {
      desenhaTitulo(lapis);
      
      lapis.setColor(Color.WHITE);      
         lapis.setFont(new Font("Verdana", 0, 20));
         lapis.drawString("Use WASD ou SETAS para mover a cobra, ESPAÇO ou P para pausar e ESC para sair.", 180, 450);
         lapis.drawString("Você só perde quando bater em si mesmo ou o tamanho da cobra chegar ao menor possível.", 150, 500);
   }
   
   public void desenhaPausa(Graphics lapis)
   {
       lapis.setColor(Color.decode("#87788a"));
       lapis.setFont(new Font("Verdana", 0, 30));
         lapis.drawString("» JOGO PAUSADO «", 460, 300);
   }
   
   public void desenhaEnter(Graphics lapis)
   {
      lapis.setColor(Color.decode("#ef8c47"));
      lapis.setFont(new Font("Verdana", 0, 20));
         lapis.drawString("Aperte ENTER para começar...", 450, 550);
   }
   
   public void desenhaGameOver(Graphics lapis)
   {
      lapis.setColor(Color.WHITE);
      lapis.setFont(new Font("Pixeled", 1, 50));
        lapis.drawString("GAME OVER", (Propriedades.LARGURA / 3) - 9, Propriedades.ALTURA / 2);
      
      String texto = "APERTE ENTER PARA COMEÇAR NOVAMENTE!";
      
      lapis.setColor(Color.decode("#ef8c47"));
      lapis.setFont(new Font("Verdana", 1, 20));
        lapis.drawString(texto, (Propriedades.LARGURA / 3) - texto.length(), 330);
   }
   
   public void setStatus(Status novoStatus)
   {
       this.status = novoStatus;
   }
   
   public Status getStatus()
   {
       return this.status;
   }
   
}
