package com.battleship.key;


public class Coord {

    private boolean hit = false;
    private int y;
    private int x;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String toString(){
        return x + "," + y;
    }

}
