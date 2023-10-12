package com.battleship.key;

import java.util.List;


public class Ship {
    private final List<Coord> coordinates;

    //All possible ship sizes

    public static int[] getSizes() {
        return new int[]{5, 4, 3, 3, 2};
    }

    public Ship(List<Coord> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coord> getCoordinates() {
        return coordinates;
    }

    public int getSize() {
        return coordinates.size();
    }

    public int getIndex(Coord coord) {
        for (int a = 0; a < coordinates.size(); ++a) {
            Coord target = coordinates.get(a);

            if (coord.getX() == target.getX() && coord.getY() == target.getY()) {
                return a;
            }
        }
        return -1;

    }

    public boolean inUse(Coord coord) {
        return getIndex(coord) != -1;
    }

    public boolean[] didHit(Coord coord) {
        int index = getIndex(coord);
        if (index == -1) {
            return new boolean[]{false, false};
        }

        coordinates.get(index).setHit(true);

        boolean sank = true;

        for (Coord c : coordinates) {
            if (!c.isHit()) {
                sank = false;
                break;
            }
        }
        return new boolean[]{true, sank};
    }
}
