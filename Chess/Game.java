/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author Opsi
 */
public class Game {
        static Brix brix=new Brix();
        static Chess chess = new Chess();
    public static void main(String[] args) {
        double moveno =1;
        String move;
        boolean gameon=true;
        EndGame endgame=new EndGame();
        Scanner scan = new Scanner(System.in);
        String type=scan.next();
        String opp = scan.next();
        if (type.equals("std")){
            initstd();
        }else if(type.equals("960")){
            init960();
        }else if(type.equals("m2")){
            initm2();
        }
         JFrame jungle = new JFrame();
      
      //  jungle.add(panel);
        jungle.setSize(500,600);
        jungle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jungle.setVisible(true);
        while(gameon){
            
            if("b".equals(opp)){
            System.out.printf("%d.",(int)moveno);
            brix.engine(chess.piece,2,2 );
            chess.makeMove(brix.best);
            System.out.println(brix.best);
            printboard(chess.piece);
            Gui panel = new Gui(chess.piece);
            jungle.add(panel);
            jungle.revalidate();
            jungle.repaint();
            
            moveno+=0.5;
            chess.piece[0][8][1]=switcht(chess.piece[0][8][1]);
            opp="";
            }
            Gui panel = new Gui(chess.piece);
            jungle.add(panel);
            jungle.revalidate();
            jungle.repaint();
            if (moveno%1==0){
                System.out.printf("%d.",(int)moveno);
            }else{
                System.out.printf("%d...",(int)moveno);
            }
            
              move=scan.next();
              try{
            if(chess.canMake(move)){
                chess.makeMove(move);
            }else{
                System.out.println("err");
                continue;
            }
              }catch(IndexOutOfBoundsException e){
                     System.out.println("err");
                  continue;
              }
            chess.piece[0][8][1]=switcht(chess.piece[0][8][1]);
            String mate=endgame.mate(chess.piece);
            //   printboard(chess.piece);
            if ("check".equals(mate)){
                if(chess.piece[0][8][1]=='b'){
                    System.out.print("Black ");
                }else{
                    System.out.print("White ");
                }
                System.out.print("has been checkmated");
                gameon=false;
                continue;
            }else if("stale".equals(mate)){
                System.out.println("It's a Stalemate");
                gameon=false;
                continue;
            }
         
            moveno+=0.5;
            brix.engine(chess.piece,2,2);
            chess.makeMove(brix.best);
            System.out.println(brix.best);
            printboard(chess.piece);
            panel = new Gui(chess.piece);
            jungle.add(panel);
            jungle.revalidate();
            jungle.repaint();
            moveno+=0.5;
            chess.piece[0][8][1]=switcht(chess.piece[0][8][1]);
            if ("check".equals(mate)){
                if(chess.piece[0][8][1]=='b'){
                    System.out.print("Black ");
                }else{
                    System.out.print("White ");
                }
                System.out.print("has been checkmated");
                gameon=false;
            }else if("stale".equals(mate)){
                System.out.println("It's a Stalemate");
                gameon=false;
            }
        }
    }
    public static char switcht(char turn){
        if (turn=='w'){
            return 'b';
        }else{
            return'w';
        }
}
    public static void printboard(char[][][] board){
         for (int i=7;i>=0;i--){
                for (int j=0;j<8;j++){
                    
                    switch (board[i][j][1]) {
                        case 'w':
                            System.out.print(Character.toUpperCase(board[i][j][0]));
                            break;
                        default:
                            System.out.print(board[i][j][0]);
                            break;
                    }
                    
                    System.out.print("   ");
                        
                }
                System.out.println();
            }
         
         
    }
     public static void initstd(){
        chess.piece[2][8][0]='t';
         chess.piece[2][8][1]='t';
        chess.piece[1][8][0]='t';
         chess.piece[1][8][1]='t';
         chess.piece[0][8][0]=43;
         chess.piece[0][8][1]='w';
        chess.piece[0][0][0]='r';
        chess.piece[0][0][1]='w';
        chess.piece[0][1][0]='n';
        chess.piece[0][1][1]='w';
        chess.piece[0][2][0]='b';
        chess.piece[0][2][1]='w';
        chess.piece[0][3][0]='q';
        chess.piece[0][3][1]='w';
        chess.piece[0][4][0]='k';
        chess.piece[0][4][1]='w';
        chess.piece[0][5][0]='b';
        chess.piece[0][5][1]='w';
        chess.piece[0][6][0]='n';
        chess.piece[0][6][1]='w';
        chess.piece[0][7][0]='r';
        chess.piece[0][7][1]='w';
        chess.piece[7][0][0]='r';
        chess.piece[7][0][1]='b';
        chess.piece[7][1][0]='n';
        chess.piece[7][1][1]='b';
        chess.piece[7][2][0]='b';
        chess.piece[7][2][1]='b';
        chess.piece[7][3][0]='q';
        chess.piece[7][3][1]='b';
        chess.piece[7][4][0]='k';
        chess.piece[7][4][1]='b';
        chess.piece[7][5][0]='b';
        chess.piece[7][5][1]='b';
        chess.piece[7][6][0]='n';
        chess.piece[7][6][1]='b';
        chess.piece[7][7][0]='r';
        chess.piece[7][7][1]='b';
        for(int i=0;i<8;i++){
            chess.piece[1][i][0]='p';
            chess.piece[1][i][1]='w';
            chess.piece[6][i][0]='p';
            chess.piece[6][i][1]='b';
        }
    }
    public static void init960(){
        
    }
     public static void initm2(){
           chess.piece[2][8][0]='f';
         chess.piece[2][8][1]='f';
        chess.piece[1][8][0]='f';
         chess.piece[1][8][1]='f';
         chess.piece[0][8][0]=43;
         chess.piece[0][8][1]='w';
        chess.piece[0][4][0]=' ';
            chess.piece[0][4][1]=' ';
            chess.piece[7][5][0]='r';
            chess.piece[7][5][1]='b';
            chess.piece[4][5][0]='k';
            chess.piece[4][5][1]='w';
            chess.piece[0][0][0]='k';
            chess.piece[0][0][1]='b';
    }

}
