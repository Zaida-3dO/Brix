/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessTest1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Opsi
 */
public class Game {

    static Brix brix = new Brix();
    static Chess chess = new Chess();
    static JMenuBar menuBar = new JMenuBar();
    static Gui panel;
    static JFrame jungle = new JFrame();

    public static void main(String[] args) {
        double moveno = 1;
        String move = "";
        boolean gameon = true;
        EndGame endgame = new EndGame();
        String type = "std";
        String opp = "w";
        switch (type) {
            case "std":
            case "3do":
                initstd();
                break;
            case "960":
                init960();
                break;
            case "m2":
                initm2();
                break;
            default:
                break;
        }

        panel = new Gui(chess.piece);
        fillmenu();
        jungle.setJMenuBar(menuBar);
        jungle.add(panel);
        jungle.setSize(500, 548);
        jungle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jungle.setVisible(true);
        /*    while(gameon){
            
            if("b".equals(opp)){
          //  System.out.printf("%d.",(int)moveno);
            brix.engine(chess.piece,2,2);
            chess.makeMove(brix.best);
           // System.out.println(brix.best);
         //   Gui panel = new Gui(chess.piece);
            panel.refill();
            //jungle.add(panel);
            jungle.revalidate();
            jungle.repaint();
          //   System.exit(0);
            moveno+=0.5;
            opp="";
            }
     //     System.out.println("=="+brix.record(chess.piece));
     //   System.exit(0);
      //      Gui panel = new Gui(chess.piece);
            panel.refill();
    //        jungle.add(panel);
            jungle.revalidate();
            jungle.repaint();
            if (moveno%1==0){
        //        System.out.printf("%d.",(int)moveno);
            }else{
        //        System.out.printf("%d...",(int)moveno);
            }
           /* if (type.equals("3do")){
                move=scan.next();
            }else if(type.equals("std")){
                String strd=scan.next();
                if(chck(strd)){
                    move=standrd(strd);
                }else{
                    System.out.println("err1");
                    continue;
                }
            }*/
 /*      try{
            if(chess.canMake(move)){
                chess.makeMove(move);
            }else{
                System.out.println("err");
                continue;
            }
              }catch(IndexOutOfBoundsException e){
                     System.out.println("err");
                  continue;
              }*/
 /*    String mate=endgame.mate(chess.piece);
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
           //  System.out.println("=="+brix.record(chess.piece));
          //   System.exit(0);
            moveno+=0.5;
            brix.engine(chess.piece,2,2);
            chess.makeMove(brix.best);
         //   System.out.println(brix.best);
        //    printboard(chess.piece);
          //  panel = new Gui(chess.piece);
      //      panel.refill();
      //      jungle.add(panel);
            jungle.revalidate();
            jungle.repaint();
            moveno+=0.5;
         //   System.out.println("=="+brix.record(chess.piece));
         //   chess.piece[0][8][1]=switcht(chess.piece[0][8][1]);
           
            mate=endgame.mate(chess.piece);
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
            
        }*/

    }

    static void fillmenu() {
        JMenu game = new JMenu("Game");
        JMenu board = new JMenu("Board");
        JMenu play = new JMenu("Play");
        JMenuItem twop = new JMenuItem("2p");
        JMenu Training = new JMenu("Training");
        JMenu Extra = new JMenu("Extras");
        JMenu Brix = new JMenu("vs Brix");
        JMenu Ngame = new JMenu("New Game");
        JMenu Contgame = new JMenu("Use This Board");
        JMenuItem plawhtng = new JMenuItem("Play as White");
        plawhtng.addActionListener((ActionEvent e) -> {
            initstd();
            panel.p2 = false;
        });
        JMenuItem plabkng = new JMenuItem("Play as Black");
        plabkng.addActionListener((ActionEvent e) -> {
            initstd();
            panel.play();
            panel.p1 = false;
        });
        JMenuItem plawhtcg = new JMenuItem("Play as White");
        plawhtcg.addActionListener((ActionEvent e) -> {
            panel.p2 = false;
            panel.p1=true;
        });
        JMenuItem plabkcg = new JMenuItem("Play as Black");
        plabkcg.addActionListener((ActionEvent e) -> {
            panel.p1 = false;
             panel.p2=true;
        });
        Ngame.add(plawhtng);
        Ngame.add(plabkng);
        Contgame.add(plawhtcg);
        Contgame.add(plabkcg);
        JMenu colo = new JMenu("Color");
        JMenu piece = new JMenu("Pieces");
        JMenu black = new JMenu("Black");
        JMenu white = new JMenu("White");
        game.add(play);
        play.add(twop);
        play.add(Brix);
        JMenuItem nine60 = new JMenuItem("960");
        play.add(nine60);
        play.addSeparator();
        JMenuItem edit = new JMenuItem("Edit Board");
        play.add(edit);
        play.addSeparator();
        JMenuItem save = new JMenuItem("Save File to .PNG");
        JMenuItem load = new JMenuItem("Load File from .PNG");
        play.add(save);
        play.add(load);
        Brix.add(Ngame);
        Brix.add(Contgame);
        game.add(Training);
        JMenuItem Tname = new JMenuItem("Tile Naming");
        JMenuItem MKnight = new JMenuItem("Monster Night");
        JMenuItem MBish = new JMenuItem("Monster Bishop");
        Training.add(Tname);
        Training.add(MKnight);
        Training.add(MBish);
        game.add(Extra);
        JMenuItem Queens = new JMenuItem("8 Queens");
        JMenuItem KMoves = new JMenuItem("Knight Moves");
        JMenuItem PGame = new JMenuItem("Pawn Game");
        Extra.add(Queens);
        Extra.add(KMoves);
        Extra.add(PGame);

        board.add(colo);
        JMenuItem green = new JMenuItem("Green");
        green.addActionListener((ActionEvent e) -> {
            panel.backcol1 = Color.GREEN.darker().darker().darker();
            panel.backcol = Color.WHITE;    
            panel.colorin();
        });
        JMenuItem blacknwht = new JMenuItem("Black");
        blacknwht.addActionListener((ActionEvent e) -> {
            panel.backcol1 = Color.BLACK;
            panel.backcol = Color.WHITE;
            panel.colorin();
        });
        JMenuItem brown = new JMenuItem("Brown");
        brown.addActionListener((ActionEvent e) -> {
            panel.backcol1 = Color.orange;
            panel.backcol = Color.WHITE;
            panel.colorin();
        });
        colo.add(green);
        colo.add(blacknwht);
        colo.add(brown);

        board.add(piece);
        JMenuItem flip = new JMenuItem("Flip Board");
        flip.addActionListener((ActionEvent e) -> {
            if (panel.alinmnt) {
                panel.alinmnt = false;
            } else {
                panel.alinmnt = true;
            }
            panel.flip();
            panel.refill();
        });
        board.add(flip);
        piece.add(black);
        piece.add(white);
        JMenuItem bluep = new JMenuItem("Blue");
        JMenuItem yellowp = new JMenuItem("Yellow");
        black.add(bluep);
        black.add(yellowp);
        game.setMnemonic(KeyEvent.VK_A);
        board.setMnemonic(KeyEvent.VK_A);

        menuBar.add(game);
        menuBar.add(board);

    }

    /* public static void printboard(char[][][] board){
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
         
         
    }*/
    public static void initstd() {
        for (int a = 0; a < 8; a++) {
            for(int b = 0; b < 9; b++){
                for(int c = 0;c < 2;c++){
                    
                  chess.piece[a][b][c] = ' ';
                }
            }
        }
     //   chess.piece = new char[8][9][2];
        chess.piece[2][8][0] = 't';
        chess.piece[2][8][1] = 't';
        chess.piece[1][8][0] = 't';
        chess.piece[1][8][1] = 't';
        chess.piece[0][8][0] = 43;
        chess.piece[0][8][1] = 'w';
        chess.piece[0][0][0] = 'r';
        chess.piece[0][1][0] = 'n';
        chess.piece[0][2][0] = 'b';
        chess.piece[0][3][0] = 'q';
        chess.piece[0][4][0] = 'k';
        chess.piece[0][5][0] = 'b';
        chess.piece[0][6][0] = 'n';
        chess.piece[0][7][0] = 'r';
        chess.piece[7][0][0] = 'r';
        chess.piece[7][1][0] = 'n';
        chess.piece[7][2][0] = 'b';
        chess.piece[7][3][0] = 'q';
        chess.piece[7][4][0] = 'k';
        chess.piece[7][5][0] = 'b';
        chess.piece[7][6][0] = 'n';
        chess.piece[7][7][0] = 'r';
        for (int i = 0; i < 8; i++) {
            chess.piece[1][i][0] = 'p';
            chess.piece[1][i][1] = 'w';
            chess.piece[6][i][0] = 'p';
            chess.piece[6][i][1] = 'b';
            chess.piece[7][i][1] = 'b';
            chess.piece[0][i][1] = 'w';
        }
//        panel.prex=9;
 //       panel.prey=9;
  //      panel.prext=9;
   //     panel.preyt=9;
//        panel.refill();
        
        jungle.repaint();

    }

    public static void init960() {

    }

    public static void initm2() {
        chess.piece[2][8][0] = 'f';
        chess.piece[2][8][1] = 'f';
        chess.piece[1][8][0] = 'f';
        chess.piece[1][8][1] = 'f';
        chess.piece[0][8][0] = 43;
        chess.piece[0][8][1] = 'w';
        chess.piece[0][4][0] = ' ';
        chess.piece[0][4][1] = ' ';
        chess.piece[7][5][0] = 'r';
        chess.piece[7][5][1] = 'b';
        chess.piece[4][5][0] = 'k';
        chess.piece[4][5][1] = 'w';
        chess.piece[0][0][0] = 'k';
        chess.piece[0][0][1] = 'b';
    }

    public static boolean chck(String move) {
        boolean enmov = false;
        if (move.equals("O-O-O") || move.equals("O-O")) {
            return true;
        }
        if (move.length() >= 2 && move.length() <= 5) {

            for (int i = 0; i < 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (move.endsWith(numlet(i) + j)) {
                        enmov = true;
                    }
                }
            }
            if (enmov == false) {
                return false;
            }
            if (move.length() > 2) {
                if (!(move.startsWith("Q") || move.startsWith("K") || move.startsWith("R") || move.startsWith("N") || move.startsWith("B"))) {
                    enmov = false;
                    for (int i = 0; i < 8; i++) {
                        if (move.startsWith(numlet(i))) {//||move.startsWith((i+1)+"")){
                            enmov = true;
                        }
                    }
                }
                if (enmov == false) {
                    return false;
                }
            }

            if (move.length() > 3) {
                enmov = false;
                for (int i = 0; i < 8; i++) {
                    if (move.charAt(1) == numlet(i).toCharArray()[0]) {
                        enmov = true;
                    }
                }
                for (int j = 1; j <= 8; j++) {
                    if ((int) move.charAt(1) == j + 48) {
                        enmov = true;
                    }
                }

                if (!(move.charAt(1) == 'x' || enmov)) {
                    return false;
                }
            }
            if (move.length() > 4) {
                enmov = false;
                for (int i = 0; i < 8; i++) {
                    if (move.charAt(1) == numlet(i).toCharArray()[0]) {
                        enmov = true;
                    }
                }
                for (int j = 1; j <= 8; j++) {
                    if (move.charAt(1) == j) {
                        enmov = true;
                    }
                }

                if (!(move.charAt(2) == 'x' && enmov)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static String standrd(String move) {
        String off = "", fr = "", to = "";
        if (move.equals("O-O-O")) {
            if (chess.piece[0][8][1] == 'w') {
                return "e1c1";
            } else if (chess.piece[0][8][1] == 'b') {
                return "e8c8";
            }
        } else if (move.equals("O-O")) {
            if (chess.piece[0][8][1] == 'w') {
                return "e1g1";
            } else if (chess.piece[0][8][1] == 'b') {
                return "e8g8";
            }
        }
        if (move.length() >= 2 && move.length() <= 5) {
            for (int i = 0; i < 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (move.endsWith(numlet(i) + j)) {
                        to = numlet(i) + j;
                        if (move.length() == 2) {
                            if (chess.piece[0][8][1] == 'w') {
                                if (chess.piece[j - 2][i][0] == 'p') {
                                    return numlet(i) + (j - 1) + numlet(i) + j;
                                } else {
                                    if (j == 4 && chess.piece[0][8][1] == 'w') {
                                        if (chess.piece[j - 3][i][0] == 'p') {
                                            return numlet(i) + (j - 2) + numlet(i) + j;
                                        }
                                    }
                                }
                            } else if (chess.piece[0][8][1] == 'b') {
                                if (chess.piece[j][i][0] == 'p') {
                                    return numlet(i) + (j + 1) + numlet(i) + j;
                                } else {
                                    if (j == 5 && chess.piece[0][8][1] == 'b') {
                                        if (chess.piece[j + 1][i][0] == 'p') {
                                            return numlet(i) + (j + 2) + numlet(i) + j;
                                        } else {
                                            return "errg";
                                        }
                                    }
                                }
                            }

                        }

                    }
                }
            }
        }
        if (move.length() == 3 || (move.length() == 4 && move.charAt(1) == 'x')) {
            if ((move.startsWith("Q") || move.startsWith("K") || move.startsWith("R") || move.startsWith("N") || move.startsWith("B"))) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (chess.piece[i][j][0] == move.toLowerCase().charAt(0) && chess.piece[i][j][1] == chess.piece[0][8][1]) {
                            if (chess.canMake(numlet(j) + (i + 1) + to)) {
                                return (numlet(j) + (i + 1) + to);
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                if (move.startsWith(numlet(i))) {
                    for (int j = 0; j < 8; j++) {
                        if (chess.piece[j][i][0] == 'p') {
                            if (chess.canMake(numlet(i) + (j + 1) + to)) {
                                return (numlet(i) + (j + 1) + to);
                            }
                        }
                    }
                }
            }
        }
        if ((move.length() == 4 && move.charAt(1) != 'x') || (move.length() == 5 && move.charAt(2) == 'x')) {
            if ((move.startsWith("Q") || move.startsWith("K") || move.startsWith("R") || move.startsWith("N") || move.startsWith("B"))) {
                for (int i = 0; i < 8; i++) {
                    if (move.charAt(1) == numlet(i).toCharArray()[0]) {
                        for (int k = 0; k < 8; k++) {
                            if (chess.piece[k][i][0] == move.toLowerCase().charAt(0) && chess.piece[k][i][1] == chess.piece[0][8][1]) {
                                if (chess.canMake(numlet(i) + (k + 1) + to)) {
                                    return (numlet(i) + (k + 1) + to);
                                }
                            }
                        }
                    }
                }
            }
            for (int j = 1; j <= 8; j++) {
                if ((int) move.charAt(1) == j + 48) {
                    for (int k = 0; k < 8; k++) {
                        if (chess.piece[j - 1][k][0] == move.toLowerCase().charAt(0) && chess.piece[j - 1][k][1] == chess.piece[0][8][1]) {
                            if (chess.canMake(numlet(k) + (j) + to)) {
                                return (numlet(k) + (j) + to);
                            }
                        }
                    }

                }
            }
        }

        return "err";

    }

    public static String numlet(int i) {
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
