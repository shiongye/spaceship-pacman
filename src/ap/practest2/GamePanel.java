//LIM SHIONG YE 0345270
//ITS66704

package ap.practest2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

   private Timer aTimer;
   private int gameStatus = 0; 
   private Lim lim;
   private Monster mons1, mons2, mons3, mons4;
   private int score = 0;

   public GamePanel() {
      aTimer = new Timer(50, this); 
      reset();   
      addKeyListener(this);
   }
   
   public int getGameStatus() {
        return gameStatus;
    }
    
   public void setGameStatus(int gs) {
        gameStatus = gs;
   }
   
   public void reset() {
      lim = new Lim(300, 500, 5);
      mons1 = new Monster(225, 100, 5);
      mons2 = new Monster(350, 100, 5);
      mons3 = new Monster(125, 150, 5);
      mons4 = new Monster(450, 150, 5);
      score = 0;
   }

   public void startTimer() {
      if (gameStatus == 0) {
         aTimer.start();
         gameStatus = 1;
      }
   }

   public void paint(Graphics g) {

      if (gameStatus == 1) {
         score++;
         if (lim.collideBorder()) {
            gameStatus = 2;
         }
         if (lim.collideMonster(mons1) | lim.collideMonster(mons2) | lim.collideMonster(mons3) | lim.collideMonster(mons4)) 
            gameStatus = 2;
         if (gameStatus != 2) {
            lim.updatePosition();
            
            mons1.hunting(lim);
            mons2.hunting(lim);
            mons3.hunting(lim);
            mons4.hunting(lim);
            
            mons1.updatePosition();
            mons2.updatePosition();
            mons3.updatePosition();
            mons4.updatePosition();
            
            mons1.handleBorderCollision();
            mons2.handleBorderCollision();
            mons3.handleBorderCollision();
            mons4.handleBorderCollision();
         }
      }
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, 600, 600);
      g.setColor(Color.BLUE);
      g.fillRect(0, 600, 600, 30);
      
      lim.drawItem(g);
      mons1.drawItem(g);
      mons2.drawItem(g);
      mons3.drawItem(g);
      mons4.drawItem(g);
      
      if (gameStatus == 0) {
         g.setColor(Color.WHITE);
         g.setFont(new Font("MONOSPACED", Font.PLAIN, 25));
         g.drawString("PRESS START TO BEGIN...", 140, 300);
      }
      
      if (gameStatus == 2) {
         g.setColor(Color.red);
         g.fillRect(0, 0, 600, 630);
         
         g.setColor(Color.YELLOW);
         g.setFont(new Font("DIALOG_INPUT",Font.BOLD, 49));
         g.drawString("G A M E O V E R", 120, 300);
         
         g.setColor(Color.BLACK);
         g.setFont(new Font("MONOSPACED",Font.BOLD, 39));
         g.drawString("SCORED " + score , 200, 350);
      }
      g.setColor(Color.WHITE);
      g.setFont(new Font("SERIF", Font.ITALIC, 19));
      g.drawString("S C O R E : " + score, 10, 620);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == aTimer) {
         repaint(0, 0, 600, 630);
         requestFocus();
      }
   }

   public void moveLeft() {
      lim.moveLeft();
   }

   public void moveRight() {
      lim.moveRight();
   }

   public void moveUp() {
      lim.moveUp();
   }

   public void moveDown() {
      lim.moveDown();
   }
   
   public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            lim.moveLeft();
        } else if (keyCode == 39) {
            lim.moveRight();
        } else if (keyCode == 38) {
            lim.moveUp();
        } else if (keyCode == 40) {
            lim.moveDown();
        }
    }
   
   public void keyReleased(KeyEvent e) {
   }
   
   public void keyTyped(KeyEvent e) {
   }


}