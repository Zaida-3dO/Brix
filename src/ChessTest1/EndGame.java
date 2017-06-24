/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessTest1;

/**
 *
 * @author Opsi
 */
public class EndGame {

    public boolean checkmove(char[][][] piece,int x,int y, int x1,int y1){
        char temp1,temp;
        boolean enpasan=false,checkmate=false;
        
        if(piece[y][x][0]=='k'&&x==4){
            if(x1==2){
                if(piece[y][1][0]==' '&&piece[y][2][0]==' '&&piece[y][3][0]==' '){
                piece[y][3][0]=piece[y][0][0];
                piece[y][3][1]=piece[y][0][1];
                piece[y][0][0]=' ';
                piece[y][0][1]=' ';
                checkmate=true;
                }
            }else if(x1==6){
                if(piece[y][5][0]==' '&&piece[y][6][0]==' '){ 
                piece[y][5][0]=piece[y][7][0];
                piece[y][5][1]=piece[y][7][1];
                piece[y][7][0]=' ';
                piece[y][7][1]=' ';
                checkmate=true;
                }
            }
        }
        if(piece[y1][x1][1]=='e'){
            enpasan=true;
            if(piece[y][x][1]=='b'){
                temp1=piece[y1+1][x1][1];
                temp = piece[y1+1][x1][0];
                piece[y1+1][x1][1]=' ';
                piece[y1+1][x1][0]=' ';
            }else{
                temp1=piece[y1-1][x1][1];
                temp = piece[y1-1][x1][0];
                piece[y1-1][x1][1]=' ';
                piece[y1-1][x1][0]=' ';
            }   
        }else{
            temp1=piece[y1][x1][1];
            temp = piece[y1][x1][0];
        }
        piece[y1][x1][1]=piece[y][x][1];
        piece[y1][x1][0]=piece[y][x][0];
        piece[y][x][1]=' ';
        piece[y][x][0]=' ';
        
        
         boolean ret=check(piece);
         
         
        if(piece[y1][x1][0]=='k'&&x==4&&checkmate==true){
            if(x1==2){
                piece[y][0][0]=piece[y][3][0];
                piece[y][0][1]=piece[y][3][1];
                piece[y][3][0]=' ';
                piece[y][3][1]=' ';
            }else if(x1==6){
                piece[y][7][0]=piece[y][5][0];
                piece[y][7][1]=piece[y][5][1];
                piece[y][5][0]=' ';
                piece[y][5][1]=' ';
            }
        }
        if(enpasan==true){
            if(piece[y1][x1][1]=='b'){
                piece[y1+1][x1][1]=temp1;
                piece[y1+1][x1][0]=temp;
            }else{
                piece[y1-1][x1][1]=temp1;
                piece[y1-1][x1][0]=temp;
            }   
             piece[y][x][1]=piece[y1][x1][1];
             piece[y][x][0]=piece[y1][x1][0];
             piece[y1][x1][1]='e';
             piece[y1][x1][0]=' ';
        }else{
        piece[y][x][1]=piece[y1][x1][1];
        piece[y][x][0]=piece[y1][x1][0];
        piece[y1][x1][1]=temp1;
        piece[y1][x1][0]=temp;
        }
        return ret;
    }
    public boolean check(char[][][] board){
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                if (board[y][x][0]=='k'&&board[y][x][1]==board[0][8][1]){
                int x1,y1;
                char colo=board[0][8][1];
                char coli;
                if (colo=='w'){coli='b';}else{coli='w';}
                //check from pawn
             
                    if(board[0][8][1]=='w'){
                        if(y!=7){
                        if((x!=7&&(board[y+1][x+1][0]=='p'&&board[y+1][x+1][1]=='b'))||(x!=0&&(board[y+1][x-1][0]=='p'&&board[y+1][x-1][1]=='b'))){
                            return true;
                        }}
                    }else if(board[0][8][1]=='b'){
                        if(y!=0){
                        if((x!=7&&(board[y-1][x+1][0]=='p'&&board[y-1][x+1][1]=='w'))||(x!=0&&(board[y-1][x-1][0]=='p'&&board[y-1][x-1][1]=='w'))){
                            return true;
                        }}
                    }
                
                //check from night
                if ((y+1<8)&&(x+2<8)){
                if (board[y+1][x+2][0]=='n'&&board[y+1][x+2][1]==coli){
                    return true;
                }}
                if ((y+1<8)&&(x-2>=0)){
                if(board[y+1][x-2][0]=='n'&&board[y+1][x-2][1]==coli){
                    return true;
                }}
                if ((y-1>=0)&&(x+2<8)){
                if(board[y-1][x+2][0]=='n'&&board[y-1][x+2][1]==coli){
                    return true;
                }}
                if ((y-1>=0)&&(x-2>=0)){
                if(board[y-1][x-2][0]=='n'&&board[y-1][x-2][1]==coli){
                    return true;
                }}
                if ((y+2<8)&&(x+1<8)){
                if(board[y+2][x+1][0]=='n'&&board[y+2][x+1][1]==coli){
                    return true;
                }}
                if ((y+2<8)&&(x-1>=0)){
                if(board[y+2][x-1][0]=='n'&&board[y+2][x-1][1]==coli){
                    return true;
                }}
                if ((y-2>=0)&&(x+1<8)){
                if(board[y-2][x+1][0]=='n'&&board[y-2][x+1][1]==coli){
                    return true;
                }}
                if ((y-2>=0)&&(x-1>=0)){
                if(board[y-2][x-1][0]=='n'&&board[y-2][x-1][1]==coli){
                    return true;
                }}
                    
                
                //check from king
                for(int inc=-1;(inc<2&&y+inc>=0&&y+inc<8);inc++){
                    for(int inc2=-1;(inc2<2&&x+inc2>=0&&x+inc2<8);inc2++){
                        if (board[y+inc][x+inc2][0]=='k'&&board[y+inc][x+inc2][1]==coli){
                            return true;
                        }
                    }    
                }
                //check rook and quuen
                for(int diff=1;y+diff<8;diff++){
                    if (board[y+diff][x][0]!=' '){
                        if((board[y+diff][x][0]=='r'||board[y+diff][x][0]=='q')&&board[y+diff][x][1]==coli){
                            return true;
                        }else{
                            break;
                        }
                        
                    }
                }
                for(int diff=1;y-diff>=0;diff++){
                    if (board[y-diff][x][0]!=' '){
                         if((board[y-diff][x][0]=='r'||board[y-diff][x][0]=='q')&&board[y-diff][x][1]==coli){
                            return true;
                        }else{
                            break;
                        }
                    }
                }
                for(int diff=1;x+diff<8;diff++){
                    if (board[y][x+diff][0]!=' '){
                         if((board[y][x+diff][0]=='r'||board[y][x+diff][0]=='q')&&board[y][x+diff][1]==coli){
                            return true;
                        }else{
                            break;
                        }
                    }
                }
               for(int diff=1;x-diff>=0;diff++){
                    if (board[y][x-diff][0]!=' '){
                        if((board[y][x-diff][0]=='r'||board[y][x-diff][0]=='q')&&board[y][x-diff][1]==coli){
                            return true;
                        }else{
                            break;
                        }
                    }
                }
               //check by bishop n queen
                for(int inc=1;(x+inc<8)&&(y+inc<8);inc++){
                     if (board[y+inc][x+inc][0]!=' '){
                         if((board[y+inc][x+inc][0]=='b'||board[y+inc][x+inc][0]=='q')&&board[y+inc][x+inc][1]==coli){
                            return true;
                        }else{
                            break;
                        }
                     }
                 }
                for(int inc=1;(x-inc>=0)&&(y+inc<8);inc++){
                     if (board[y+inc][x-inc][0]!=' '){
                         if((board[y+inc][x-inc][0]=='b'||board[y+inc][x-inc][0]=='q')&&board[y+inc][x-inc][1]==coli){
                            return true;
                        }else{
                            break;
                        }
                     }
                 }
                for(int inc=1;(x+inc<8)&&(y-inc>=0);inc++){
                     if (board[y-inc][x+inc][0]!=' '){
                         if((board[y-inc][x+inc][0]=='b'||board[y-inc][x+inc][0]=='q')&&board[y-inc][x+inc][1]==coli){
                            return true;
                        }else{
                            break;
                        }
                     }
                 }
                 for(int inc=1;(x-inc>=0)&&(y-inc>=0);inc++){
                     if (board[y-inc][x-inc][0]!=' '){
                         if((board[y-inc][x-inc][0]=='b'||board[y-inc][x-inc][0]=='q')&&board[y-inc][x-inc][1]==coli){
                            return true;
                        }else{
                            break;
                        }
                     }
                 }
                 
             
         
            }  
        }
        }
        
        
        return false;
    }
    public String mate(char board[][][]){
        CanMove canmove = new CanMove();
        char colo=board[0][8][1];
        for(int x=0;x<8;x++){
        for (int y=1;y<8;y++){
            if(board[y][x][1]==colo){
                for(int x1=0;x1<8;x1++){
                for (int y1=1;y1<8;y1++){
                    
                    char p=board[y][x][0];
                    switch(p){
                        case 'p':
                            if(canmove.pawn(x, y, x1, y1, board)){
                                if (checkmove(board, x, y, x1, y1)==false){
                                    return "false";
                                }
                            }
                             break; 
                        case 'b':
                            if(canmove.bishop(x, y, x1, y1, board)){
                                 if (checkmove(board, x, y, x1, y1)==false){
                                    return "false";
                                }
                            }
                             break; 
                        case 'r':
                            if(canmove.rook(x, y, x1, y1, board)){
                                 if (checkmove(board, x, y, x1, y1)==false){
                                     return "false";
                                }
                            }
                             break; 
                        case 'n':
                            if(canmove.knight(x, y, x1, y1, board)){
                                 if (checkmove(board, x, y, x1, y1)==false){
                                     return "false";
                                }
                            }
                             break; 
                        case 'k':
                            if(canmove.king(x, y, x1, y1, board)){
                                 if (checkmove(board, x, y, x1, y1)==false){
                                    return "false";
                                }
                            }
                             break; 
                        case 'q':
                            if(canmove.queen(x, y, x1, y1, board)){
                                 if (checkmove(board, x, y, x1, y1)==false){
                                     return "false";
                                }
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
        if(check(board)){
            //System.out.println("Check mate");
            return "check";
        }else{
            //System.out.println("Stale mate");
            return "stale";
        }
    }
}
