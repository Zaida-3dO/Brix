/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;

/**
 *
 * @author Opsi
 */

public class CanMove {
    
    
    public boolean pawn(int x,int y,int x1,int y1,char[][][] board){
        if (board[y][x][1]=='w'){
            if(y1==y+1){ 
                if (x1==x){
                    if(board[y1][x1][0]==' '){
                        return true;
                    }
                }else if((x1==x+1)||(x1==x-1)){
                    if((board[y1][x1][1]=='b')||(board[y1][x1][1]=='e')){
                        return true;
                    }
                }
            }else if(y1==y+2){
                if (x1==x){
                    if (y==1){
                        if((board[y1][x1][0]==' ')&&(board[y1-1][x1][0]==' ')){
                            return true;
                        }
                    }
                }
            }
        }else{
            if(y1==y-1){ 
                if (x1==x){
                    if(board[y1][x1][0]==' '){
                        return true;
                    }
                }else if((x1==x+1)||(x1==x-1)){
                    if((board[y1][x1][1]=='w')||(board[y1][x1][1]=='e')){
                        return true;
                    }
                }
            }else if(y1==y-2){
                if (x1==x){
                    if (y==6){
                        if((board[y1][x1][0]==' ')&&(board[y1+1][x1][0]==' ')){
                            return true;
                        }
                    }
                }
            }
            
            
        }
        return false;
        
    }
    public boolean bishop(int x,int y,int x1,int y1,char[][][] board){
         if (board[y][x][1]==board[y1][x1][1]){
             return false;
         }
         if(!(((y1-y)==(x1-x))||((y1-y)==(x-x1))||((y-y1)==(x1-x))||((y-y1)==(x-x1)))){
             return false;
         }
         if (y1>y){
             if(x1>x){
                 for(int inc=1;(x+inc<x1)&&(y+inc<y1);inc++){
                     if (board[y+inc][x+inc][0]!=' '){
                         return false;
                     }
                 }
             }else if(x1<x){
                 for(int inc=1;(x-inc>x1)&&(y+inc<y1);inc++){
                     if (board[y+inc][x-inc][0]!=' '){
                         return false;
                     }
                 }
             }
         }else if (y1<y){
             if(x1>x){
                 for(int inc=1;(x+inc<x1)&&(y-inc>y1);inc++){
                     if (board[y-inc][x+inc][0]!=' '){
                         return false;
                     }
                 }
             }else if(x1<x){
                 for(int inc=1;(x-inc>x1)&&(y-inc>y1);inc++){
                     if (board[y-inc][x-inc][0]!=' '){
                         return false;
                     }
                 }
             }
         }
         return true;
     }
    public boolean rook(int x,int y,int x1,int y1,char[][][] board){
         if (board[y][x][1]==board[y1][x1][1]){
             return false;
         }
        if(x==x1){
            if(y1>y){
                for(int diff=1;y+diff<y1;diff++){
                    if (board[y+diff][x][0]!=' '){
                        return false;
                    }
                }
           }else if(y1<y){
               for(int diff=1;y-diff>y1;diff++){
                    if (board[y-diff][x][0]!=' '){
                        return false;
                    }
                }
           }
        }else if(y==y1){
            if(x1>x){
                for(int diff=1;x+diff<x1;diff++){
                    if (board[y][x+diff][0]!=' '){
                        return false;
                    }
                }
           }else if(x1<x){
               for(int diff=1;x-diff>x1;diff++){
                    if (board[y][x-diff][0]!=' '){
                        return false;
                    }
                }
           }
        }else{
            return false;
        }
        return true;
    }
    public boolean knight(int x,int y,int x1,int y1,char[][][] board){
        if (board[y][x][1]==board[y1][x1][1]){
             return false;
         }
        if ((y1==y+1)||(y1==y-1)){
            return (x1==x+2)||(x1==x-2);
        }else if((y1==y+2)||(y1==y-2)){
            return (x1==x+1)||(x1==x-1);
        }
        return false;
    }
    public boolean queen(int x,int y,int x1,int y1,char[][][] board){
        if (board[y][x][1]==board[y1][x1][1]){
             return false;
         }
      
         if((((y1-y)==(x1-x))||((y1-y)==(x-x1))||((y-y1)==(x1-x))||((y-y1)==(x-x1)))){
  
         
         if (y1>y){
             if(x1>x){
                 for(int inc=1;(x+inc<x1)&&(y+inc<y1);inc++){
                     if (board[y+inc][x+inc][0]!=' '){
                         return false;
                     }
                 }
             }else if(x1<x){
                 for(int inc=1;(x-inc>x1)&&(y+inc<y1);inc++){
                     if (board[y+inc][x-inc][0]!=' '){
                         return false;
                     }
                 }
             }
         }else if (y1<y){
             if(x1>x){
                 for(int inc=1;(x+inc<x1)&&(y-inc>y1);inc++){
                     if (board[y-inc][x+inc][0]!=' '){
                         return false;
                     }
                 }
             }else if(x1<x){
                 for(int inc=1;(x-inc>x1)&&(y-inc>y1);inc++){
                     if (board[y-inc][x-inc][0]!=' '){
                         return false;
                     }
                 }
             }
         }
         return true;
         }else if((x1==x)||(y1==y)){
        if(x==x1){
            if(y1>y){
                for(int diff=1;y+diff<y1;diff++){
                    if (board[y+diff][x][0]!=' '){
                        return false;
                    }
                }
           }else if(y1<y){
               for(int diff=1;y-diff>y1;diff++){
                    if (board[y-diff][x][0]!=' '){
                        return false;
                    }
                }
           }
        }else if(y==y1){
            if(x1>x){
                for(int diff=1;x+diff<x1;diff++){
                    if (board[y][x+diff][0]!=' '){
                        return false;
                    }
                }
           }else if(x1<x){
               for(int diff=1;x-diff>x1;diff++){
                    if (board[y][x-diff][0]!=' '){
                        return false;
                    }
                }
           }
        }else{
            return false;
        }
        return true;
         }
         return false;
    }
    public boolean king(int x,int y,int x1,int y1,char[][][] board){
         EndGame endgame = new EndGame();
         if (board[y][x][1]==board[y1][x1][1]){
             return false;
         }
         for(int inc=-1;inc<2;inc++){
            for(int inc2=-1;inc2<2;inc2++){
                if ((x+inc ==x1)&&(y+inc2==y1)){
                    return true;
                }
            }    
         }
         if (board[y][x][1]=='w'){
             if(y1==0&&x1==6&&board[1][8][1]=='t'&&board[0][5][0]==' '&&board[0][6][0]==' '&&endgame.check(board)==false&&endgame.checkmove(board, x, y, 5, y1)==false){
                 return true;
             }else if(y1==0&&x1==2&&board[1][8][0]=='t'&&board[0][3][0]==' '&&board[0][2][0]==' '&&board[0][1][0]==' '&&endgame.check(board)==false&&endgame.checkmove(board, x, y, 3, y1)==false){
                 return true;
             }    
         }else if (board[y][x][1]=='b'){
             if(y1==7&&x1==6&&board[2][8][1]=='t'&&board[7][5][0]==' '&&board[7][6][0]==' '&&endgame.check(board)==false&&endgame.checkmove(board, x, y, 5, y1)==false){
                 return true;
             }else if(y1==7&&x1==2&&board[2][8][0]=='t'&&board[7][3][0]==' '&&board[7][2][0]==' '&&board[7][1][0]==' '&&endgame.check(board)==false&&endgame.checkmove(board, x, y, 3, y1)==false){
                 return true;
             }    
         }
        return false;
    }
}
