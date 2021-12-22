package com.cfanguy;

public class BackLPiece implements Mover {
    private final int Dimension = 10;
    private final int MOVE_LEN = 5;
    private int _changeY;
    private double _rotation;
    private SmartRectangle _mid;
    private SmartRectangle _right;
    private SmartRectangle _left;
    private SmartRectangle _bottom;


    public BackLPiece(java.awt.Color aColor,
                SmartRectangle aRectangle){
        super();
        _changeY =  MOVE_LEN;
        _rotation = 0;
        _mid = new SmartRectangle(aColor);
        _mid.setSize(Dimension, Dimension);
        _right = new SmartRectangle(aColor);
        _right.setSize(Dimension, Dimension);
        _left = new SmartRectangle(aColor);
        _left.setSize(Dimension, Dimension);
        _bottom = new SmartRectangle(aColor);
        _bottom.setSize(Dimension, Dimension);
    }

    public void move() {
        int nextX = (int)this.getX();
        int nextY = (int)this.getY() + _changeY;
        this.setLocation(nextX, nextY);
        if(nextY == 430){
            _changeY = 0;
        }
    }
public void setLocation (int x, int y) {
    _mid.setLocation(x, y);
    _right.setLocation(x + 10, y);
    _left.setLocation(x - 10, y);
    _bottom.setLocation(x - 10, y + 10);


    }
public int getX () {
        return (int) _mid.getX();
    }
    public int getY() {
        return (int) _mid.getY();
    }
public void setRotation (double aNumberDegrees) {
        _rotation = aNumberDegrees;
    }
    public double getCenterX () {
        return this.getX() + Dimension;
    }
    public double getCenterY () {
           return this.getY() + Dimension;
    }

public void fill (java.awt.Graphics2D aBrush){
        aBrush.rotate(_rotation,
                  this.getCenterX(),this.getCenterY());
        _mid.fill(aBrush);
        _right.fill(aBrush);
        _left.fill(aBrush);
        _bottom.fill(aBrush);
        aBrush.rotate(-_rotation,
                  this.getCenterX(),this.getCenterY());
    }
    public void draw (java.awt.Graphics2D aBrush){
        aBrush.rotate(_rotation,
                  this.getCenterX(),this.getCenterY());
        _mid.draw(aBrush);
        _right.draw(aBrush);
        _left.draw(aBrush);
        _bottom.draw(aBrush);
        aBrush.rotate(-_rotation,
                  this.getCenterX(),this.getCenterY());
    }
}
