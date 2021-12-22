package com.cfanguy;

public class TPiece implements Mover {
    private final int Dimension = 10;
    private final int MOVE_LEN = 5;
    private int _changeY;
    private double _rotation;
    private SmartRectangle _top;
    private SmartRectangle _right;
    private SmartRectangle _left;
    private SmartRectangle _bottom;


    public TPiece(java.awt.Color aColor,
                SmartRectangle aRectangle){
        super();
        _changeY =  MOVE_LEN;
        _rotation = 0;
        _top = new SmartRectangle(aColor);
        _top.setSize(Dimension, Dimension);
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
        _top.setLocation(x, y);
        _right.setLocation(x + 10, y);
        _left.setLocation(x - 10, y);
        _bottom.setLocation(x, y + 10);

    }
public int getX () {
        return (int) _top.getX();
    }
    public int getY() {
        return (int) _top.getY();
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
        _top.fill(aBrush);
        _right.fill(aBrush);
        _left.fill(aBrush);
        _bottom.fill(aBrush);
        aBrush.rotate(-_rotation,
                  this.getCenterX(),this.getCenterY());
    }
    public void draw (java.awt.Graphics2D aBrush){
        aBrush.rotate(_rotation,
                  this.getCenterX(),this.getCenterY());
        _top.draw(aBrush);
        _right.draw(aBrush);
        _left.draw(aBrush);
        _bottom.draw(aBrush);
        aBrush.rotate(-_rotation,
                  this.getCenterX(),this.getCenterY());
    }
}
