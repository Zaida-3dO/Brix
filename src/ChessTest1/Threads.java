/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessTest1;

/**
 *
 * @author OpsiJay
 */
class Threading extends Thread {

    boolean run = true;
    private Thread t;
    private String threadName;
    char turn;
    char turni;
    int fy, fx, tx, ty;
    int n;
    int top;
    Brix en = new Brix();
    char[][][] board = new char[8][9][2];
    boolean[] made = new boolean[2];
    double[] hold = new double[2];
    char[][][][][] storer = new char[20][2][8][9][2];
    double[] min = new double[20];
    double[] max = new double[20];
    String best;

    Threading(String name, char[][][] boardi, int ni, int topi, int x, int y, int x2, int y2, boolean[] madi) {
        threadName = name;
        for (int copx = 0; copx < 9; copx++) {
            for (int copy = 0; copy < 8; copy++) {
                board[copy][copx][0] = (char) boardi[copy][copx][0];
                board[copy][copx][1] = (char) boardi[copy][copx][1];
            }
        }
        for (int copx = 0; copx < madi.length; copx++) {
            made[copx] = (boolean) madi[copx];
        }
        n = ni;
        top = topi;
        fx = x;
        fy = y;
        tx = x2;
        ty = y2;
        turn = board[0][8][1];
        if (turn == 'w') {
            turni = 'b';
        } else {
            turni = 'w';
        }
        //   System.out.println("Creating " +  threadName );
    }

    public void run() {

        // System.out.println("Running " +  threadName );
        made[0] = true;
        for (int copx = 0; copx < 9; copx++) {
            for (int copy = 0; copy < 8; copy++) {
                storer[n][0][copy][copx][0] = (char) board[copy][copx][0];
                storer[n][0][copy][copx][1] = (char) board[copy][copx][1];
            }
        }
        //System.arraycopy(board, 0, storer[n][0],0, 8);
        //storer[n][0]=board.clone();
        en.move(fx, fy, tx, ty, board);
        min[n] = 10000;
        max[n] = -10000;
        made[1] = false;
        if ("check".equals(en.endgame.mate(board))) {
            min[n] = 70 + n;
            max[n] = 70 + n;
        }
        if ("stale".equals(en.endgame.mate(board))) {
            min[n] = 0;
            max[n] = 0;
        }
        opponentmove:
        for (int fyp = 0; fyp < 8; fyp++) {
            for (int fxp = 0; fxp < 8; fxp++) {
                if (board[fyp][fxp][1] == turni) {
                    for (int typ = 0; typ < 8; typ++) {
                        for (int txp = 0; txp < 8; txp++) {
                            if (en.canMake(fxp, fyp, txp, typ, turni, board)) {
                                made[1] = true;
                                for (int copx = 0; copx < 9; copx++) {
                                    for (int copy = 0; copy < 8; copy++) {
                                        storer[n][1][copy][copx][0] = (char) board[copy][copx][0];
                                        storer[n][1][copy][copx][1] = (char) board[copy][copx][1];
                                    }
                                }
                                en.move(fxp, fyp, txp, typ, board);
                                double thescore = en.record(board);
                                if (n == 1) {
                                    hold[0] = thescore;
                                    hold[1] = thescore;
                                } else {
                                    hold = en.engine(board, n - 1, top);
                                }
                                if (hold[0] < min[n]) {
                                    min[n] = hold[0];
                                }
                                if (hold[1] > max[n]) {
                                    max[n] = hold[1];
                                }
                                for (int copx = 0; copx < 9; copx++) {
                                    for (int copy = 0; copy < 8; copy++) {
                                        board[copy][copx][0] = (char) storer[n][1][copy][copx][0];
                                        board[copy][copx][1] = (char) storer[n][1][copy][copx][1];
                                    }
                                }
                                if (hold[0] < en.mini[n]) {
                                    break opponentmove;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (min[n] == 10000 && made[1] == false) {
            System.out.printf("troll%d%d%d%d", fx, fy, tx, ty);
            min[n] = en.record(board);
            max[n] = en.record(board);
        }
        if (min[n] > en.mini[n]) {

            if (n == top) {
                best = en.numlet(fx) + (fy + 1) + en.numlet(tx) + (ty + 1);
                System.out.print(best + " :");
                System.out.println(min[n]);
            }
            en.mini[n] = min[n];
        } else if (min[n] == en.mini[n]) {
            if (max[n] > en.maxi[n]) {
                if (n == top) {
                    best = en.numlet(fx) + (fy + 1) + en.numlet(tx) + (ty + 1);
                    System.out.print(best + " :");
                    System.out.println(min[n]);
                }
                en.maxi[n] = max[n];
            }
        }
        for (int copx = 0; copx < 9; copx++) {
            for (int copy = 0; copy < 8; copy++) {
                board[copy][copx][0] = (char) storer[n][0][copy][copx][0];
                board[copy][copx][1] = (char) storer[n][0][copy][copx][1];
            }
        }
        // System.out.println(best+"w/n");
        run = false;
        //    System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        //    System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

/*public class TestThread {

   public static void main(String args[]) {
      RunnableDemo R1 = new RunnableDemo( "Thread-1");
      R1.start();
      
      RunnableDemo R2 = new RunnableDemo( "Thread-2");
      R2.start();
   }   
}*/
