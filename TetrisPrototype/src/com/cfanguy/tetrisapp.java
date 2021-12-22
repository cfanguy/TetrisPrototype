package com.cfanguy;

public class tetrisapp extends javax.swing.JFrame {
    public tetrisapp (String title) {
        super(title);
        this.setSize(300, 482);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(new TetrisPanel());
        this.setVisible(true);
    }

    public static void main (String [ ] args) {
        new tetrisapp ("Tetris");
    }
}
