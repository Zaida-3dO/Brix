/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessTest1;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
//import javax.swing.JPanel;
/**
 *
 * @author Opsi
 */
public class Gui extends JPanel {
    Brix brix=new Brix();
    boolean fillin=false;
    int frox;
    int froy;
    boolean alinmnt=true;
    boolean p1=true;
    boolean p2=true;
     Color backcol=Color.WHITE;
      Color backcol1=Color.BLACK;
    JButton[][] boardz=new JButton[8][8];
    char[][][] z = new char[8][9][2];
    Chess chess = new Chess();
     CanMove canmove = new CanMove();
     EndGame endgame = new EndGame();
     int prex=9,prey=9,prext=9,preyt=9;
    public Gui(char[][][] k){
        z=k;
        setLayout(new GridLayout(8,8));
          for(int a=7;a>=0;a--){          
            for(int b=0;b<8;b++){
                boardz[a][b]=new JButton();
                boardz[a][b].addActionListener(new Colo(a,b));
                 add(boardz[a][b]);
            }
          }
       colorin();
       refill();
        
    }
    public void colorin(){
         Color me= backcol;
        for(int a=7;a>=0;a--){          
            for(int b=0;b<8;b++){
                   
                      boardz[a][b].setBackground(me);
                     if(me==backcol){
                         me=backcol1;
                     }else{
                         me=backcol;
                     }
            }
             if(me==backcol){
                         me=backcol1;
                     }else if(me==backcol1){
                         me=backcol;
                     }
            
        }
    }
    public void refill(){
        ImageIcon bpawn = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\bluepawn.png");
        ImageIcon ypawn = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowpawn.png");
        ImageIcon brook = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\bluerook.png");
        ImageIcon yrook = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowrook.png");
        ImageIcon bbishop = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\bluebishop.png");
        ImageIcon ybishop = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowbishop.png");
        ImageIcon bknight = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\blueknight.png");
        ImageIcon yknight = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowknight.png");
        ImageIcon bqueen = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\bluequeen.png");
        ImageIcon yqueen = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowqueen.png");
        ImageIcon bking = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\blueking.png");
        ImageIcon yking = new ImageIcon("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowking.png");
        
     for(int a=7;a>=0;a--){          
            for(int b=0;b<8;b++){   
                 if((a==prex)&&(b==prey)){
                     if(boardz[a][b].getBackground()!=Color.PINK){
                          boardz[a][b].setBackground(Color.LIGHT_GRAY);}
             }
                    if((a==prext)&&(b==preyt)){
                           if(boardz[a][b].getBackground()!=Color.PINK){
                          boardz[a][b].setBackground(Color.GRAY);}
             }
                if(alinmnt==false){
                    a=7-a;
                    b=7-b;
                }
                
                    switch (z[a][b][0]){
                            case 'p':
                               if(z[a][b][1]=='b'){
                                   boardz[a][b].setIcon(bpawn);
                               }else{boardz[a][b].setIcon(ypawn);}
                               break;
                            case 'r':
                               if(z[a][b][1]=='b'){
                               boardz[a][b].setIcon(brook);
                               }else{boardz[a][b].setIcon(yrook);}
                               break;
                            case 'b':
                               if(z[a][b][1]=='b'){
                               boardz[a][b].setIcon(bbishop);
                               }else{boardz[a][b].setIcon(ybishop);}
                               break;
                            case 'n':
                               if(z[a][b][1]=='b'){
                               boardz[a][b].setIcon(bknight);
                               }else{boardz[a][b].setIcon(yknight);}
                               break;
                            case 'k':
                               if(z[a][b][1]=='b'){
                               boardz[a][b].setIcon(bking);
                               }else{boardz[a][b].setIcon(yking);}
                               break;
                            case 'q':
                               if(z[a][b][1]=='b'){
                              boardz[a][b].setIcon(bqueen);
                               }else{boardz[a][b].setIcon(yqueen);}
                               break;
                            case ' ':
                              boardz[a][b].setIcon(null);
                              break;
                            default:
                                break;
                    }
                    if(alinmnt==false){
                    a=7-a;
                    b=7-b;
                }
                }
            
            }
     revalidate();
    }
    public void flip(){
        removeAll();
         for(int a=7;a>=0;a--){          
            for(int b=0;b<8;b++){
                if(alinmnt){
                add(boardz[a][b]);
                }else{
                add(boardz[7-a][7-b]);
                }
            }
        }
    }
 /*   @Override
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
                               try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\bluepawn.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowpawn.png")); } catch (IOException e) {}}
                               break;
                            case 'r':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\bluerook.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowrook.png")); } catch (IOException e) {}}
                               break;
                            case 'b':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\bluebishop.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowbishop.png")); } catch (IOException e) {}}
                               break;
                            case 'n':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\blueknight.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowknight.png")); } catch (IOException e) {}}
                               break;
                            case 'k':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\blueking.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowking.png")); } catch (IOException e) {}}
                               break;
                            case 'q':
                               if(z[a][b][1]=='b'){
                               try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\bluequeen.png")); } catch (IOException e) {}}
                               else{try {image = ImageIO.read(new File("C:\\Users\\Opsi Jay\\Desktop\\ME\\chess ico\\yellowqueen.png")); } catch (IOException e) {}}
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
        
     }*/
     class Colo implements ActionListener { 
         int a,b;
         public Colo(int a, int b){
             this.a=a;
             this.b=b;
         }
         @Override 
         public void actionPerformed(ActionEvent e) {
             if(fillin){
                 char p=z[frox][froy][0];
                  colorin();
                  fillin=false;
                    if(z[frox][froy][1]==z[0][8][1]){
          switch (p) {
            case ' ':
                break;
            case 'p':
                if( canmove.pawn(froy, frox, b, a, z)){
                  
                       prex=frox;
                      prey=froy;
                     prext=a;
                        preyt=b;
                        
                    move(froy, frox, b, a);
                       if((z[0][8][1]=='w')&&(p1==false)){
                            play();
                        }else if((z[0][8][1]=='b')&&(p2==false)){
                            play();
                        }
                        }
                
                    break;
            case 'b':
                if( canmove.bishop(froy,frox,b,a, z)){
                       prex=frox;
                      prey=froy;
                     prext=a;
                        preyt=b;
                      move(froy, frox, b, a);
                       if((z[0][8][1]=='w')&&(p1==false)){
                            play();
                        }else if((z[0][8][1]=='b')&&(p2==false)){
                            play();
                        }
                }
                    break;
            case 'r':
                if( canmove.rook(froy,frox,b,a, z)){
                       prex=frox;
                      prey=froy;
                     prext=a;
                        preyt=b;
                      move(froy, frox, b, a);
                       if((z[0][8][1]=='w')&&(p1==false)){
                            play();
                        }else if((z[0][8][1]=='b')&&(p2==false)){
                            play();
                        }
                }
                    break;
            case 'n':
                if( canmove.knight(froy,frox,b,a, z)){
                       prex=frox;
                      prey=froy;
                     prext=a;
                        preyt=b;
                      move(froy, frox, b, a);
                       if((z[0][8][1]=='w')&&(p1==false)){
                            play();
                        }else if((z[0][8][1]=='b')&&(p2==false)){
                            play();
                        }
                }
                    break;
            case 'k':
                if( canmove.king(froy,frox,b,a, z)){ 
                       prex=frox;
                      prey=froy;
                     prext=a;
                        preyt=b;
                      move(froy, frox, b, a);
                       if((z[0][8][1]=='w')&&(p1==false)){
                            play();
                        }else if((z[0][8][1]=='b')&&(p2==false)){
                            play();
                        }
                }
                    break;
            case 'q':
                if( canmove.queen(froy,frox,b,a, z)){
                       prex=frox;
                      prey=froy;
                     prext=a;
                        preyt=b;
                      move(froy, frox, b, a);
                        if((z[0][8][1]=='w')&&(p1==false)){
                            play();
                        }else if((z[0][8][1]=='b')&&(p2==false)){
                            play();
                        }
                }
                    break;
            default:
                break;        
        }
                    }
             }else{
                  boardz[a][b].setBackground(Color.CYAN);
                    froy=b;
                    frox=a;
                    fillin=true;
              for(int i=0;i<8;i++){
                         for(int j=0;j<8;j++){
                                if (endgame.checkmove(z, b, a, j, i)){
                                }else{
                             char p=z[a][b][0];
                             if(z[a][b][1]==z[0][8][1]){
                                 switch (p) {
            case ' ':
                break;
            case 'p':
                if( canmove.pawn(b, a, j, i, z)){
                    boardz[i][j].setBackground(Color.PINK);
                    froy=b;
                    frox=a;
                    fillin=true;
                }
                    break;
            case 'b':
                if( canmove.bishop(b,a,j,i, z)){
                    boardz[i][j].setBackground(Color.PINK);       
                    froy=b;
                    frox=a;
                    fillin=true;
                       }
                    break;
            case 'r':
                if( canmove.rook(b,a,j,i, z)){
                    boardz[i][j].setBackground(Color.PINK);      
                    froy=b;
                    frox=a;
                    fillin=true;
                        }
                    break;
            case 'n':
                if( canmove.knight(b,a,j,i, z)){
                    boardz[i][j].setBackground(Color.PINK);          
                    froy=b;
                    frox=a;
                    fillin=true;
                    }
                    break;
            case 'k':
                if( canmove.king(b,a,j,i, z)){
                    boardz[i][j].setBackground(Color.PINK);         
                    froy=b;
                    frox=a;
                    fillin=true;
                     }
                    break;
            case 'q':
                if( canmove.queen(b,a,j,i, z)){
                    boardz[i][j].setBackground(Color.PINK);          
                    froy=b;
                    frox=a;
                    fillin=true;
                    }
                    break;
            default:
                break;        
        }
                             }
                        }
                         }
                    }
            
         }
               refill();
          repaint();
     }
     
     }
      public void play(){
          
          System.out.println();
            brix.engine(z,2,2);
            System.out.println();
            makeMove(brix.best);
            refill();
            repaint();
         //   z[0][8][1]=switcht(z[0][8][1]);
            if((z[0][8][1]=='w')&&(p1==false)){
                    play();
            }else if((z[0][8][1]=='b')&&(p2==false)){
                play();
            }
            
            
    }
          public static char switcht(char turn){
        if (turn=='w'){
            return 'b';
        }else{
            return'w';
        }
}
 
      public void move(int x,int y,int x1,int y1){
           if (endgame.checkmove(z, x, y, x1, y1)){
                System.out.println("Your under check");
            }else{
      if(z[y][x][0]=='p'){
        if  (z[y1][x1][1]=='e'){
            if (z[2][x1][1]=='e'){
                z[3][x1][1]=' ';
                z[3][x1][0]=' ';
                z[0][8][0]=0;
            }else if (z[5][x1][1]=='e'){
                z[4][x1][1]=' ';
                z[4][x1][0]=' ';
                z[0][8][0]=0;
            }
        }
      }
       if(z[y][x][0]=='k'){  
        if  (x==4){
            if(x1==2){
                 if(z[y][1][0]==' '&&z[y][2][0]==' '&&z[y][3][0]==' '){
                z[y][3][1]=z[y][0][1];
                z[y][3][0]=z[y][0][0];
                z[y][0][1]=' ';
                z[y][0][0]=' ';
                 }
            }else if (x1==6){
                 if(z[y][5][0]==' '&&z[y][6][0]==' '){ 
                z[y][5][1]=z[y][7][1];
                z[y][5][0]=z[y][7][0];
                z[y][7][1]=' ';
                z[y][7][0]=' ';
            }}
        }
      }
      
      //50 move rule
         if (z[y1][x1][0]!=' '){
             z[0][8][0]=0;
         }else if(z[y][x][0]=='p'){
             z[0][8][0]=0;
         }else{
             z[0][8][0]+=1;
         }
      //castleability
        if (z[y][x][0]=='r'){
            if (z[y][x][1]=='w'){
                if(x==0){
                    z[1][8][0]='f';
                }else if(x==7){
                    z[1][8][1]='f';
                }
            }else if (z[y][x][1]=='b'){
                if(x==0){
                    z[2][8][0]='f';
                }else if(x==7){
                    z[2][8][1]='f';
                }
            }
        }else if(z[y][x][0]=='k'){
            if (z[y][x][1]=='w'){
                z[1][8][0]='f';
                z[1][8][1]='f';
            }else if (z[y][x][1]=='b'){
                z[2][8][0]='f';
                z[2][8][1]='f';
            }
        }
      
         z[y1][x1][1]=z[y][x][1];
            z[y1][x1][0]=z[y][x][0];
            z[y][x][1]=' ';
            z[y][x][0]=' ';
            
            
        //en passant placement
        for(int rem=0;rem<8;rem++){
            if (z[2][rem][1]=='e'){
                z[2][rem][1]=' ';
            }else if (z[5][rem][1]=='e'){
                z[5][rem][1]=' ';
            }
        }
        if (z[y1][x1][0]=='p'){
                if((y==1)&&(y1==3)){    
                     z[y+1][x][1]='e';
                }else if((y==6)&&(y1==4)){
                    z[y-1][x][1]='e';
                }
        }
        //promote
        boolean cont=true;
        while(cont==true){
        cont=false;    
        for(int prom=0;prom<8;prom++){
            if(z[0][prom][0]=='p'||z[7][prom][0]=='p'){
                int they=0;
                if(z[0][prom][0]=='p'){they=0; }else if(z[7][prom][0]=='p'){they=7;}
                System.out.println(they);
                System.out.println("Enter the Piece you wanna promote to");
                Scanner scan = new Scanner(System.in);
                String promto = scan.next();
                System.out.println(promto);
                switch (promto){
                    case "r":
                        z[they][prom][0]='r';
                        cont=false;
                        break;
                    case "b":
                        z[they][prom][0]='b';
                        cont=false;
                        break;
                    case "n":
                        z[they][prom][0]='n';
                        cont=false;
                        break;
                    case "q":
                        z[they][prom][0]='q';
                        System.out.println("print"+they+" "+prom);
                        cont=false;
                        break;
                    default:
                        cont=true;
                        System.out.println("Enter a valid Piece");
                        break;
                }
            }
        }
        }
        if(z[0][8][1]=='b'){z[0][8][1]='w';}else{z[0][8][1]='b';}
        }
    }
       public void makeMove(String move){
            int y =move.charAt(1)-49;
            int x =letnum(move.charAt(0));
            int y1 =move.charAt(3)-49;
            int x1 =letnum(move.charAt(2));
            prex=y;
            prey=x;
            prext=y1;
            preyt=x1;
            move(x,y,x1,y1);
    }
          public int letnum(char i){
        switch (i) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            default:
                return 7;
        }
    }
 }
