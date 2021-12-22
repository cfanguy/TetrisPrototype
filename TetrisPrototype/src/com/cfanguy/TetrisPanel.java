package com.cfanguy;

public class TetrisPanel extends javax.swing.JPanel implements Mover {
    private final int TANK_X = 0;
    private final int TANK_Y = 0;
    private final int TANK_WIDTH = 300;
    private final int TANK_HEIGHT = 450;
    private final int INTERVAL = 100;
    private SmartRectangle _tank;
    private SquarePiece _squarePiece;
    private ZPiece _zPiece;
    private SPiece _sPiece;
    private TPiece _tPiece;
    private LPiece _lPiece;
    private BackLPiece _backLPiece;
    private MoveTimer _timer;
    private int _pieceChooser;

    public TetrisPanel() {
        super();
        _squarePiece = new SquarePiece(java.awt.Color.RED, _tank);
        _squarePiece.setLocation(140, -20);
        _zPiece = new ZPiece(java.awt.Color.BLACK, _tank);
        _zPiece.setLocation(120, -30);
        _sPiece = new SPiece(java.awt.Color.GREEN, _tank);
        _sPiece.setLocation(170, -30);
        _tPiece = new TPiece(java.awt.Color.ORANGE, _tank);
        _tPiece.setLocation(80, -20);
        _lPiece = new LPiece(java.awt.Color.MAGENTA, _tank);
        _lPiece.setLocation(210, -20);
        _backLPiece = new BackLPiece(java.awt.Color.YELLOW, _tank);
        _backLPiece.setLocation(250, -20);
        _tank = new SmartRectangle(java.awt.Color.blue);
        _timer = new MoveTimer(INTERVAL, this);
        this.setBackground(java.awt.Color.white);
        _tank.setBorderColor(java.awt.Color.black);
        _tank.setLocation(TANK_X, TANK_Y);
        _tank.setSize(TANK_WIDTH, TANK_HEIGHT);
        _timer.start();
        _pieceChooser=0;
    }


    public void move() {
            if (_pieceChooser == 0) {
                _squarePiece.move();
                this.repaint();
                if(_squarePiece.getY()>429){
                    _pieceChooser = _pieceChooser+1;
                }
            } else if (_pieceChooser == 1) {
                _zPiece.move();
                this.repaint();
                if(_zPiece.getY()>419){
                    _pieceChooser = _pieceChooser+1;
                }
            } else if (_pieceChooser == 2) {
                _sPiece.move();
                this.repaint();
                if(_sPiece.getY()>419){
                    _pieceChooser = _pieceChooser+1;
                }
            } else if (_pieceChooser == 3) {
                _tPiece.move();
                this.repaint();
                if(_tPiece.getY()>429){
                    _pieceChooser = _pieceChooser+1;
                }
            } else if (_pieceChooser == 4) {
                _lPiece.move();
                this.repaint();
                if(_lPiece.getY()>419){
                    _pieceChooser = _pieceChooser+1;
                }
            } else if (_pieceChooser == 5) {
                _backLPiece.move();
                this.repaint();
                if(_backLPiece.getY()>419){
                    _pieceChooser = _pieceChooser+1;
                }
            }
        }
    public void paintComponent(java.awt.Graphics aBrush) {
        super.paintComponent(aBrush);
        java.awt.Graphics2D betterBrush =
                (java.awt.Graphics2D) aBrush;
          _tank.fill(betterBrush);
          _tank.draw(betterBrush);
          _squarePiece.fill(betterBrush);
          _zPiece.fill(betterBrush);
          _sPiece.fill(betterBrush);
          _tPiece.fill(betterBrush);
          _lPiece.fill(betterBrush);
          _backLPiece.fill(betterBrush);
        }
    }
