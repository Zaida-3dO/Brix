/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessTest1;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Opsi
 */
public class Brix {
    Threading[][][][] R1 = new Threading[8][8][8][8];
    CanMove canmove = new CanMove();
    double[] hold=new double[2];
    char[][][][][] storer=new char[20][2][8][9][2];
    double[] min=new double[20];
    double[] mini=new double[20];
    double[] maxi=new double[20];
    double[] max=new double[20];
    String best;
    EndGame endgame=new EndGame();
    public double[] engine(char[][][] board,int n,int top){
        char turn=board[0][8][1];
        char turni;
        boolean[] made=new boolean[2];
        if (turn=='w'){turni='b';}else{turni='w';}
        mini[n]=-1000;
        maxi[n]=-1000;
        made[0]=false;
        Integer[] fyarr=new Integer[8];
        Integer[] fxarr=new Integer[8];
        Integer[] tyarr=new Integer[8];
        Integer[] txarr=new Integer[8];
        for(int i=0;i<8;i++){
            fyarr[i]=i;
            fxarr[i]=i;
            tyarr[i]=i;
            txarr[i]=i;
        }
          Collections.shuffle(Arrays.asList(txarr));
          Collections.shuffle(Arrays.asList(tyarr));
          Collections.shuffle(Arrays.asList(fxarr));
          Collections.shuffle(Arrays.asList(fyarr));
        mymove:
        for(int fy:fyarr){
        for(int fx:fxarr){
            if(board[fy][fx][1]==turn){
            for(int ty:tyarr){
            for(int tx:txarr){
        //alpha beta        if((mini[n]<mini[top])&&(n!=top)){   break mymove;     }  
                if(canMake(fx,fy,tx,ty, turn,board)){
                    
                    if (n==1000){
                       String tmane=fx+""+fy+""+tx+""+ty;
                      R1[fx][fy][tx][ty]=new Threading(tmane,board,n,top,fx,fy,tx,ty,made);
                        R1[fx][fy][tx][ty].start();
                    }else{  
                       made[0]=true;
                    for(int copx=0;copx<9;copx++){
                    for(int copy=0;copy<8;copy++){
                        storer[n][0][copy][copx][0]=(char)board[copy][copx][0];
                        storer[n][0][copy][copx][1]=(char)board[copy][copx][1];
                    }
                    }
                    //System.arraycopy(board, 0, storer[n][0],0, 8);
                    //storer[n][0]=board.clone();
                    move(fx, fy, tx, ty,board);
                    min[n]=10000;
                    max[n]=-10000;
                    made[1]=false;
                    if ("check".equals(endgame.mate(board))){
                        min[n]=70+n;
                        max[n]=70+n;
                    }
                    if ("stale".equals(endgame.mate(board))){
                        min[n]=0;
                        max[n]=0;
                    }
                     Integer[] fyparr=new Integer[8];
                     Integer[] fxparr=new Integer[8];
                    Integer[] typarr=new Integer[8];
                    Integer[] txparr=new Integer[8];
                    for(int i=0;i<8;i++){
                        fyparr[i]=i;
                         fxparr[i]=i;
                         typarr[i]=i;
                           txparr[i]=i;
                    }
                       Collections.shuffle(Arrays.asList(txparr));
                       Collections.shuffle(Arrays.asList(typarr));
                       Collections.shuffle(Arrays.asList(fxparr));
                       Collections.shuffle(Arrays.asList(fyparr));
                    opponentmove:
                    for(int fyp:fyparr){
                    for(int fxp:fxparr){
                        if(board[fyp][fxp][1]==turni){
                        for(int typ:typarr){
                        for(int txp:txparr){
                            if(canMake(fxp,fyp,txp,typ, turni ,board)){
                                made[1]=true;
                                for(int copx=0;copx<9;copx++){
                                for(int copy=0;copy<8;copy++){
                                    storer[n][1][copy][copx][0]=(char)board[copy][copx][0];
                                    storer[n][1][copy][copx][1]=(char)board[copy][copx][1];
                                }
                                }
                                move(fxp, fyp, txp, typ,board); 
                                double thescore=record(board);
                                if(n==1){
                                    hold[0]=thescore;
                                    hold[1]=thescore;
                                }else{
                                    hold=engine(board,n-1,top);
                                }
                                if(hold[0]<min[n]){
                                    min[n]=hold[0];
                                }
                                if(hold[1]>max[n]){
                                    max[n]=hold[1];
                                }
                                for(int copx=0;copx<9;copx++){
                                for(int copy=0;copy<8;copy++){
                                    board[copy][copx][0]=(char)storer[n][1][copy][copx][0];
                                    board[copy][copx][1]=(char)storer[n][1][copy][copx][1];
                                }
                                }  
                                if(hold[0]<mini[n]){
                                  break opponentmove;
                                }
                            }
                        }    
                        }
                        }
                    }
                    }
                    if(min[n]==10000&&made[1]==false){
                               System.out.printf("troll%d%d%d%d",fx,fy,tx,ty);
                                min[n]=record(board);
                                max[n]=record(board);
                     }
                 if(min[n]>mini[n]) {
                     
                     if(n==top){
                     best=numlet(fx)+(fy+1)+numlet(tx)+(ty+1);
                         System.out.print(best +" :");
                         System.out.println(min[n])        ;}
                     mini[n]=min[n];
                 }else if(min[n]==mini[n]){
                     if(max[n]>maxi[n]){
                         if(n==top){
                          best=numlet(fx)+(fy+1)+numlet(tx)+(ty+1);
                           //  System.out.print(best+" :");
                           //  System.out.println(min[n]);
                         }
                         maxi[n]=max[n];
                     }
                 }
                 for(int copx=0;copx<9;copx++){
                 for(int copy=0;copy<8;copy++){
                    board[copy][copx][0]=(char)storer[n][0][copy][copx][0];
                    board[copy][copx][1]=(char)storer[n][0][copy][copx][1];
                }
                }
      
                        
                        
         }
                  
              // alpha beta  if((mini[n]<mini[top])&&(n!=top)){ break mymove;}  
                 //System.arraycopy(storer[n][0], 0, board,0, 8);
                 //board=storer[n][0].clone();   
                }
            }    
            
            }
            }
        }
        }
         for(int fy=0;fy<8;fy++){
        for(int fx=0;fx<8;fx++){
            if(board[fy][fx][1]==turn){
            for(int ty=0;ty<8;ty++){
            for(int tx=0;tx<8;tx++){
                if(canMake(fx,fy,tx,ty, turn,board)){
                    if (n==1000){
                        try{
                            R1[fx][fy][tx][ty].join();
                            
                        }catch(Exception e){
                            System.out.println("Oh No!!!!");
                        }
                        while( R1[fx][fy][tx][ty].run){
                            System.out.print("");
                        }
                        if(R1[fx][fy][tx][ty].min[n]>mini[n]) {
                             best=R1[fx][fy][tx][ty].best;
                           mini[n]=R1[fx][fy][tx][ty].min[n];
                        }else if(R1[fx][fy][tx][ty].min[n]==mini[n]){
                            if(R1[fx][fy][tx][ty].max[n]>maxi[n]){
                                       best=R1[fx][fy][tx][ty].best;
                                       maxi[n]=R1[fx][fy][tx][ty].max[n];
                     }
                 }
                       
                      //  System.out.println(best);
                    }
                }
            }
            }
            }
        }
        }
        if(mini[n]==-1000&&made[0]==false){
            mini[n]=record(board);
            maxi[n]=record(board);
        }
        double[] ret=new double[2];
        ret[0]=mini[n];
        ret[1]=maxi[n];
        return ret;
    }
    
    public boolean canMake(int x,int y,int x1,int y1,char turn,char[][][] piece){
         EndGame endgames = new EndGame();
           
            char p =piece[y][x][0];
            char c =piece[y][x][1];
            if (c!=turn){
                System.out.println("Not ur turn");
                return false;
            }
            if (endgames.checkmove(piece, x, y, x1, y1)){
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
     public void move(int x,int y,int x1,int y1,char[][][] piece){
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
                piece[y][3][1]=piece[y][0][1];
                piece[y][3][0]=piece[y][0][0];
                piece[y][0][1]=' ';
                piece[y][0][0]=' ';
                
            }else if (x1==6){
                piece[y][5][1]=piece[y][7][1];
                piece[y][5][0]=piece[y][7][0];
                piece[y][7][1]=' ';
                piece[y][7][0]=' ';
            }
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
        if(piece[0][8][1]=='w'){piece[0][8][1]='b';}else{piece[0][8][1]='w';}
         //promote 
        for(int prom=0;prom<8;prom++){
            if(piece[0][prom][0]=='p'){
                piece[0][prom][0]='q';
            }else if (piece[7][prom][0]=='p'){
                piece[7][prom][0]='q';
            }
        }
    }
     
     public double record(char[][][]board){
         char c =board[0][8][1];
         double score=0;
        // BigDecimal score = new BigDecimal("0");
         for(int x=0;x<8;x++){
             for(int y=0;y<8;y++){
                 char d=board[y][x][1];
                 switch (board[y][x][0]) {
                     case 'p':
                         score+=score(1.0,c,d);
                         break;
                     case 'r':
                         score+=score(5.0,c,d);
                         break;
                     case 'b':
                         score+=score(3.001,c,d);
                         break;
                     case 'n':
                         score+=score(3.0,c,d);
                         break;
                     case 'q':
                         score+=score(8.99,c,d);
                         break;
                     case 'k':
                         score+=score(100000.0,c,d);
                         break;
                     default:
                         break;
                 }
                // pawn
                        if(y!=7){
                        if((x!=7)&&(board[y+1][x+1][0]=='p'&&board[y+1][x+1][1]=='b')){
                            if(board[y][x][1]!='b'){   
                                if(board[y][x][0]!='p'){
                                     score+=score(0.05,c,'b');
                                    if(board[y][x][1]=='w'){
                                        score+=score(0.7,c,'b');
                                    }
                                }
                                
                            }
                        }
                if((x!=0)&&(board[y+1][x-1][0]=='p'&&board[y+1][x-1][1]=='b')){
                            if(board[y][x][1]!='b'){   
                                if(board[y][x][0]!='p'){
                                     score+=score(0.05,c,'b');
                                    if(board[y][x][1]=='w'){
                                        score+=score(0.7,c,'b');
                                    }
                                }
                                
                            }
                        }
                }
                        if(y!=0){
                        if((x!=7)&&(board[y-1][x+1][0]=='p'&&board[y-1][x+1][1]=='w')){
                            if(board[y][x][1]!='w'){   
                                if(board[y][x][0]!='p'){
                                     score+=score(0.05,c,'w');
                                    if(board[y][x][1]=='b'){
                                        score+=score(0.7,c,'w');
                                    }
                                }
                                
                            }
                        }
                         if((x!=0)&&(board[y-1][x-1][0]=='p'&&board[y-1][x-1][1]=='w')){
                            if(board[y][x][1]!='w'){   
                                if(board[y][x][0]!='p'){
                                     score+=score(0.05,c,'w');
                                    if(board[y][x][1]=='b'){
                                        score+=score(0.7,c,'w');
                                    }
                                }
                                
                            }
                        }}
                        
                //    }
              
                //check from night
                if ((y+1<8)&&(x+2<8)){
                if (board[y+1][x+2][0]=='n'){
                     if(board[y][x][1]!=board[y+1][x+2][1]){   
                        score+=score(0.05,c,board[y+1][x+2][1]);
                        if(board[y][x][1]!=' '&&board[y][x][0]!='p'&&board[y][x][0]!='n'&&board[y][x][0]!='b'){
                            score+=score(0.7,c,board[y+1][x+2][1]);
                        }
                     }
                     if(y==0||y==7){
                        score+=score(-0.02,c,board[y+1][x+2][1]);
                    }
                    if(x==0||x==7){
                        score+=score(-0.02,c,board[y+1][x+2][1]);
                    }
                }}
                if ((y+1<8)&&(x-2>=0)){
                if(board[y+1][x-2][0]=='n'){
                    if(board[y][x][1]!=board[y+1][x-2][1]){   
                        score+=score(0.05,c,board[y+1][x-2][1]);
                        if(board[y][x][1]!=' '&&(board[y][x][0]!='p'&&board[y][x][0]!='n'&&board[y][x][0]!='b')){
                            score+=score(0.7,c,board[y+1][x-2][1]);
                        }
                     }
                    if(y==0||y==7){
                        score+=score(-0.02,c,board[y+1][x-2][1]);
                    }
                    if(x==0||x==7){
                        score+=score(-0.02,c,board[y+1][x-2][1]);
                    }
                }}
                if ((y-1>=0)&&(x+2<8)){
                if(board[y-1][x+2][0]=='n'){
                    if(board[y][x][1]!=board[y-1][x+2][1]){   
                        score+=score(0.05,c,board[y-1][x+2][1]);
                        if(board[y][x][1]!=' '&&(board[y][x][0]!='p'&&board[y][x][0]!='n'&&board[y][x][0]!='b')){
                          score+=score(0.7,c,board[y-1][x+2][1]);
                        }
                     }
                           if(y==0||y==7){
                        score+=score(-0.02,c,board[y-1][x+2][1]);
                    }
                    if(x==0||x==7){
                        score+=score(-0.02,c,board[y-1][x+2][1]);
                    }
                }}
                if ((y-1>=0)&&(x-2>=0)){
                if(board[y-1][x-2][0]=='n'){
                    if(board[y][x][1]!=board[y-1][x-2][1]){   
                        score+=score(0.05,c,board[y-1][x-2][1]);
                        if(board[y][x][1]!=' '&&(board[y][x][0]!='p'&&board[y][x][0]!='n'&&board[y][x][0]!='b')){
                            score+=score(0.7,c,board[y-1][x-2][1]);
                        }
                     }
                        if(y==0||y==7){
                        score+=score(-0.02,c,board[y-1][x-2][1]);
                    }
                    if(x==0||x==7){
                        score+=score(-0.02,c,board[y-1][x-2][1]);
                    }
                }}
                if ((y+2<8)&&(x+1<8)){
                if(board[y+2][x+1][0]=='n'){
                    if(board[y][x][1]!=board[y+2][x+1][1]){   
                        score+=score(0.05,c,board[y+2][x+1][1]);
                        if(board[y][x][1]!=' '&&(board[y][x][0]!='p'&&board[y][x][0]!='n'&&board[y][x][0]!='b')){
                            score+=score(0.7,c,board[y+2][x+1][1]);
                        }
                     }
                     if(y==0||y==7){
                        score+=score(-0.02,c,board[y+2][x+1][1]);
                    }
                    if(x==0||x==7){
                        score+=score(-0.02,c,board[y+2][x+1][1]);
                    }
                }}
                if ((y+2<8)&&(x-1>=0)){
                if(board[y+2][x-1][0]=='n'){
                    if(board[y][x][1]!=board[y+2][x-1][1]){   
                        score+=score(0.05,c,board[y+2][x-1][1]);
                        if(board[y][x][1]!=' '&&(board[y][x][0]!='p'&&board[y][x][0]!='n'&&board[y][x][0]!='b')){
                            score+=score(0.7,c,board[y+2][x-1][1]);
                        }
                     }
                     if(y==0||y==7){
                        score+=score(-0.02,c,board[y+2][x-1][1]);
                    }
                    if(x==0||x==7){
                        score+=score(-0.02,c,board[y+2][x-1][1]);
                    }
                }}
                if ((y-2>=0)&&(x+1<8)){
                if(board[y-2][x+1][0]=='n'){
                    if(board[y][x][1]!=board[y-2][x+1][1]){   
                        score+=score(0.05,c,board[y-2][x+1][1]);
                        if(board[y][x][1]!=' '&&(board[y][x][0]!='p'&&board[y][x][0]!='n'&&board[y][x][0]!='b')){
                            score+=score(0.7,c,board[y-2][x+1][1]);
                        }
                     }
                     if(y==0||y==7){
                        score+=score(-0.02,c,board[y-2][x+1][1]);
                    }
                    if(x==0||x==7){
                        score+=score(-0.02,c,board[y-2][x+1][1]);
                    }
                }}
                if ((y-2>=0)&&(x-1>=0)){
                if(board[y-2][x-1][0]=='n'){
                    if(board[y][x][1]!=board[y-2][x-1][1]){   
                        score+=score(0.05,c,board[y-2][x-1][1]);
                        if(board[y][x][1]!=' '&&(board[y][x][0]!='p'&&board[y][x][0]!='n'&&board[y][x][0]!='b')){
                            score+=score(0.7,c,board[y-2][x-1][1]);
                        }
                     }
                    if(y==0||y==7){
                        score+=score(-0.02,c,board[y-2][x-1][1]);
                    }
                    if(x==0||x==7){
                        score+=score(-0.02,c,board[y-2][x-1][1]);
                    }
                }}
               if(board[y][x][0]=='n'&&(y==7||y==0)){
                  //  System.out.println(y+""+x+board[y][x][1]+score+"+"+score(-0.2,c,board[y][x][1]));
                    score-=score(0.2,c,board[y][x][1]);
                //        System.out.println(y+""+x+board[y][x][1]+score);
                }
              if(board[y][x][0]=='n'&&(x==7||x==0)){
              //    System.out.println(y+""+x+board[y][x][1]);
                  score-=score(0.2,c,board[y][x][1]);
            //      System.out.println(score);
              }
              
                
              //check from king
          //    if(board[][][])
       /*         for(int inc=-1;(inc<2&&y+inc>=0&&y+inc<8);inc++){
                    for(int inc2=-1;(inc2<2&&x+inc2>=0&&x+inc2<8);inc2++){
                        if (board[y+inc][x+inc2][0]=='k'&&board[y+inc][x+inc2][1]==c){
                            score+=score(0.8,c,c);
                        }
                    }    
                }*/
        /*       //check rook and quuen
                for(int diff=1;y+diff<8;diff++){
                    if (board[y+diff][x][0]!=' '){
                        if((board[y+diff][x][0]=='r'||board[y+diff][x][0]=='q')&&board[y+diff][x][1]==c){
                            score+=score(0.05,c,c);
                        }else{
                            break;
                        }
                        
                    }
                }
                for(int diff=1;y-diff>=0;diff++){
                    if (board[y-diff][x][0]!=' '){
                         if((board[y-diff][x][0]=='r'||board[y-diff][x][0]=='q')&&board[y-diff][x][1]==c){
                            score+=score(0.05,c,c);
                        }else{
                            break;
                        }
                    }
                }
                for(int diff=1;x+diff<8;diff++){
                    if (board[y][x+diff][0]!=' '){
                         if((board[y][x+diff][0]=='r'||board[y][x+diff][0]=='q')&&board[y][x+diff][1]==c){
                            score+=score(0.05,c,c);
                        }else{
                            break;
                        }
                    }
                }
               for(int diff=1;x-diff>=0;diff++){
                    if (board[y][x-diff][0]!=' '){
                        if((board[y][x-diff][0]=='r'||board[y][x-diff][0]=='q')&&board[y][x-diff][1]==c){
                            score+=score(0.05,c,c);
                        }else{
                            break;
                        }
                    }
                }
               //check by bishop n queen
                for(int inc=1;(x+inc<8)&&(y+inc<8);inc++){
                     if (board[y+inc][x+inc][0]!=' '){
                         if((board[y+inc][x+inc][0]=='b'||board[y+inc][x+inc][0]=='q')&&board[y+inc][x+inc][1]==c){
                            score+=score(0.05,c,c);
                        }else{
                            break;
                        }
                     }
                 }
                for(int inc=1;(x-inc>=0)&&(y+inc<8);inc++){
                     if (board[y+inc][x-inc][0]!=' '){
                         if((board[y+inc][x-inc][0]=='b'||board[y+inc][x-inc][0]=='q')&&board[y+inc][x-inc][1]==c){
                            score+=score(0.05,c,c);
                        }else{
                            break;
                        }
                     }
                 }
                for(int inc=1;(x+inc<8)&&(y-inc>=0);inc++){
                     if (board[y-inc][x+inc][0]!=' '){
                         if((board[y-inc][x+inc][0]=='b'||board[y-inc][x+inc][0]=='q')&&board[y-inc][x+inc][1]==c){
                            score+=score(0.05,c,c);
                        }else{
                            break;
                        }
                     }
                 }
                 for(int inc=1;(x-inc>=0)&&(y-inc>=0);inc++){
                     if (board[y-inc][x-inc][0]!=' '){
                         if((board[y-inc][x-inc][0]=='b'||board[y-inc][x-inc][0]=='q')&&board[y-inc][x-inc][1]==c){
                            score+=score(0.05,c,c);
                        }else{
                            break;
                        }
                     }
                 }
                 
             
         */
            }  
        
        }

         
         if ("check".equals(endgame.mate(board))){
             score=score(-70.0,c,c);
         }
         if ("stale".equals(endgame.mate(board))){
             score=0;
         }
         return score;
     }
     public double score(double i,char c,char d){
         if(c==d){
             return i;
         }else{
             return (i*-1);
         }
     }
     public String numlet(int i){
        switch (i) {
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            default:
                return "h";
        }
    }
}
