/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
//import javax.swing.JPanel;
/**
 *
 * @author Opsi
 */
public class Gui extends JPanel {
    char[][][] z = new char[8][9][2];
    public Gui(char[][][] k){
    z=k;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage image = null;
        g.setColor(Color.BLACK);
        for(int a=7;a>=0;a--){          
            for(int b=0;b<8;b++){
                     g.fillRect(b*50, a*50,50 ,50);
                     if(g.getColor()==Color.WHITE){g.setColor(Color.BLACK);}else{g.setColor(Color.WHITE);}
            }
            if(g.getColor()==Color.WHITE){g.setColor(Color.BLACK);}else{g.setColor(Color.WHITE);}
        }
         for(int a=7;a>=0;a--){          
            for(int b=0;b<8;b++){            
                    switch (z[a][b][0]){
                            case 'p':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\bluepawn.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\yellowpawn.png")); } catch (IOException e) {}}
                               break;
                            case 'r':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\bluerook.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\yellowrook.png")); } catch (IOException e) {}}
                               break;
                            case 'b':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\bluebishop.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\yellowbishop.png")); } catch (IOException e) {}}
                               break;
                            case 'n':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\blueknight.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\yellowknight.png")); } catch (IOException e) {}}
                               break;
                            case 'k':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\blueking.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\yellowking.png")); } catch (IOException e) {}}
                               break;
                            case 'q':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\bluequeen.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\opsij\\Desktop\\chess ico\\yellowqueen.png")); } catch (IOException e) {}}
                               break;
                            case ' ':
                              image = null;
                              break;
                            default:
                                break;
                    }
                     g.drawImage(image, b*50, r(a)*50, this);
                }
            
            }
        
     }
    public int r(int a){
        switch (a) {
            case 7:
                return 0;
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            case 1:
                return 6;
            default:
                return 7;
        }
    }
 }

