package com.cfanguy;

public class SquarePiece implements Mover {
    private final int Dimension = 20;
    private final int MOVE_LEN = 5;
    private int _changeY;
    private double _rotation;
    private SmartRectangle _ulpiece;


    public SquarePiece(java.awt.Color aColor,
                SmartRectangle aRectangle){
        super();
        _changeY =  MOVE_LEN; // fish swims vertically
        _rotation = 0;
        _ulpiece = new SmartRectangle(aColor);
        _ulpiece.setSize(Dimension, Dimension);
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
        _ulpiece.setLocation(x, y);
    }
public int getX () {
        return (int) _ulpiece.getX();
    }
    public int getY() {
        return (int) _ulpiece.getY();
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
        _ulpiece.fill(aBrush);

        aBrush.rotate(-_rotation,
                  this.getCenterX(),this.getCenterY());
    }
    public void draw (java.awt.Graphics2D aBrush){
        aBrush.rotate(_rotation,
                  this.getCenterX(),this.getCenterY());
        _ulpiece.draw(aBrush);
        aBrush.rotate(-_rotation,
                  this.getCenterX(),this.getCenterY());
    }
}
