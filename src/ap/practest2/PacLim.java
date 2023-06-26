//LIM SHIONG YE 0345270
//ITS66704

package ap.practest2;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;


public class PacLim extends JFrame implements ActionListener {

   private final int SWIDTH = 900;
   private final int SHEIGHT = 700;
   private JButton btnStart, btnExit;
   private JButton btnLeft, btnRight, btnUp, btnDown;
   private GamePanel gameP = new GamePanel();

   public PacLim() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Pac Lim v1.0");
      setSize(SWIDTH, SHEIGHT);
      setLayout(null);
   }

   public void init() {
      gameP.setBounds(25, 25, 600, 630);
      add(gameP);
      btnLeft = new JButton("LEFT");
      btnLeft.setBounds(650, 400, 100, 25);
      btnLeft.addActionListener(this);
      add(btnLeft);
      
      btnRight = new JButton("RIGHT");
      btnRight.setBounds(750, 400, 100, 25);
      btnRight.addActionListener(this);
      add(btnRight);
      
      btnUp = new JButton("UP");
      btnUp.setBounds(700, 375, 100, 25);
      btnUp.addActionListener(this);
      add(btnUp);
      
      btnDown = new JButton("DOWN");
      btnDown.setBounds(700, 425, 100, 25);
      btnDown.addActionListener(this);
      add(btnDown);
      
      btnStart = new JButton("START");
      btnStart.setBounds(650, 500, 100, 25);
      btnStart.addActionListener(this);
      add(btnStart);
      
      btnExit = new JButton("EXIT");
      btnExit.setBounds(650, 625, 100, 25);
      btnExit.addActionListener(this);
      add(btnExit);
      
      setVisible(true); 
      
      File soundFile =  new File("src/lim.wav").getAbsoluteFile();
      try {
         AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
         Clip myClip = AudioSystem.getClip();
         myClip.open(ais);
         myClip.start();
      }
      catch(Exception e) {
         System.out.println(e);
      }
   }
   

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btnExit) {
          System.exit(0);
      } 
      else if (e.getSource() == btnStart) {
          if (gameP.getGameStatus() == 0) {
                gameP.startTimer();
                btnStart.setText("RESTART");
          }
          if (gameP.getGameStatus() == 2) {
              gameP.setGameStatus(0);
              gameP.reset();
              btnStart.setText("START");
          }
      }     
      else if (e.getSource() == btnLeft) {
          gameP.moveLeft();
      } 
      else if (e.getSource() == btnUp) {
          gameP.moveUp();
      } 
      else if (e.getSource() == btnRight) {
          gameP.moveRight();
      } 
      else if (e.getSource() == btnDown) {
          gameP.moveDown();
      }
      
   }   
   
   public static void main(String args[]) {
       PacLim pm = new PacLim();
       pm.init();
   }
}