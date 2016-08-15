/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;
import java.util.Scanner;
/**
 *
 * @author Opsi
 */
public class Chess {
    public char[][][] piece=new char[8][9][2]; 
    CanMove canmove = new CanMove();
    public Chess(){
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                for(int c=0;c<2;c++){
                    piece[a][b][c]=' ';
                }
            }
        }  
    }
   
    public void move(int x,int y,int x1,int y1){
      if(piece[y][x][0]=='p'){  
        if  (piece[y1][x1][1]=='e'){
            if (piece[2][x1][1]=='e'){
                piece[3][x1][1]=' ';
                piece[3][x1][0]=' ';
                piece[0][8][0]=0;
            }else if (piece[5][x1][1]=='e'){
                piece[4][x1][1]=' ';
                piece[4][x1][0]=' ';
                piece[0][8][0]=0;
            }
        }
      }
       if(piece[y][x][0]=='k'){  
        if  (x==4){
            if(x1==2){
                 if(piece[y][1][0]==' '&&piece[y][2][0]==' '&&piece[y][3][0]==' '){
                piece[y][3][1]=piece[y][0][1];
                piece[y][3][0]=piece[y][0][0];
                piece[y][0][1]=' ';
                piece[y][0][0]=' ';
                 }
            }else if (x1==6){
                 if(piece[y][5][0]==' '&&piece[y][6][0]==' '){ 
                piece[y][5][1]=piece[y][7][1];
                piece[y][5][0]=piece[y][7][0];
                piece[y][7][1]=' ';
                piece[y][7][0]=' ';
            }}
        }
      }
      
      //50 move rule
         if (piece[y1][x1][0]!=' '){
             piece[0][8][0]=0;
         }else if(piece[y][x][0]=='p'){
             piece[0][8][0]=0;
         }else{
             piece[0][8][0]+=1;
         }
      //castleability
        if (piece[y][x][0]=='r'){
            if (piece[y][x][1]=='w'){
                if(x==0){
                    piece[1][8][0]='f';
                }else if(x==7){
                    piece[1][8][1]='f';
                }
            }else if (piece[y][x][1]=='b'){
                if(x==0){
                    piece[2][8][0]='f';
                }else if(x==7){
                    piece[2][8][1]='f';
                }
            }
        }else if(piece[y][x][0]=='k'){
            if (piece[y][x][1]=='w'){
                piece[1][8][0]='f';
                piece[1][8][1]='f';
            }else if (piece[y][x][1]=='b'){
                piece[2][8][0]='f';
                piece[2][8][1]='f';
            }
        }
      
         piece[y1][x1][1]=piece[y][x][1];
            piece[y1][x1][0]=piece[y][x][0];
            piece[y][x][1]=' ';
            piece[y][x][0]=' ';
            
            
        //en passant placement
        for(int rem=0;rem<8;rem++){
            if (piece[2][rem][1]=='e'){
                piece[2][rem][1]=' ';
            }else if (piece[5][rem][1]=='e'){
                piece[5][rem][1]=' ';
            }
        }
        if (piece[y1][x1][0]=='p'){
                if((y==1)&&(y1==3)){    
                     piece[y+1][x][1]='e';
                }else if((y==6)&&(y1==4)){
                    piece[y-1][x][1]='e';
                }
        }
        //promote
        boolean cont=true;
        while(cont==true){
        cont=false;    
        for(int prom=0;prom<8;prom++){
            if(piece[0][prom][0]=='p'||piece[7][prom][0]=='p'){
                int they=0;
                if(piece[0][prom][0]=='p'){they=0; }else if(piece[7][prom][0]=='p'){they=7;}
                System.out.println("Enter the piece you wanna promote to");
                Scanner scan = new Scanner(System.in);
                String promto = scan.next();
                switch (promto){
                    case "r":
                        piece[they][prom][0]='r';
                        cont=false;
                        break;
                    case "b":
                        piece[they][prom][0]='b';
                        cont=false;
                        break;
                    case "n":
                        piece[they][prom][0]='n';
                        cont=false;
                        break;
                    case "q":
                        piece[they][prom][0]='q';
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
    }
    public boolean canMake(String move){
         EndGame endgame = new EndGame();
          int y =move.charAt(1)-49;
            int x =letnum(move.charAt(0));
            int y1 =move.charAt(3)-49;
            int x1 =letnum(move.charAt(2));
            char p =piece[y][x][0];
            char c =piece[y][x][1];
            char turn=piece[0][8][1];
            if (c!=turn){
                System.out.println("Not ur turn");
                return false;
            }
            if (endgame.checkmove(piece, x, y, x1, y1)){
                System.out.println("Your under check");
                return false;
            }
        switch (p) {
            case ' ':
                return false;
            case 'p':
                return canmove.pawn(x, y, x1, y1, piece);
            case 'b':
                return canmove.bishop(x, y, x1, y1, piece);
            case 'r':
                return canmove.rook(x, y, x1, y1, piece);
            case 'n':
                return canmove.knight(x, y, x1, y1, piece);
            case 'k':
                return canmove.king(x, y, x1, y1, piece);
            case 'q':
                return canmove.queen(x, y, x1, y1, piece);
            default:
                break;        
        }
         return true;
    }
     
    public void makeMove(String move){
            int y =move.charAt(1)-49;
            int x =letnum(move.charAt(0));
            int y1 =move.charAt(3)-49;
            int x1 =letnum(move.charAt(2));
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
