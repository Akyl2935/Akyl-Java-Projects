package com.battleship.key;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class  Player {
    private final List<Ship> ships = new ArrayList<>();

    public Player(int boardSize) {
        placeShips(boardSize);
    }

    public List<Ship> getShips() {
        return ships;
    }

    private int random(int boardSize, int boatSize) {
        int random = ThreadLocalRandom.current().nextInt(boardSize);
        while (random + boatSize > boardSize) {
            --random;
        }
        return random;
    }

    private List<Coord> getAllCoordinates(Coord start, Coord end) {
        List<Coord> coordinates = new ArrayList<>();

        if (start.getX() == end.getX()) {
            int min = Math.min(start.getY(), end.getY());
            int max = Math.max(start.getY(), end.getY());

            for (int y = min; y < max; ++y) {
                coordinates.add(new Coord(start.getX(), y));
            }

        } else {
            int min = Math.min(start.getX(), end.getX());
            int max = Math.max(start.getX(), end.getX());

            for (int x = min; x < max; ++x) {
                coordinates.add(new Coord(x, start.getY()));
            }
        }
        return coordinates;
    }

    private boolean isInUse(Coord coord) {
        for (Ship ship : ships) {
            if (ship.inUse(coord)) {
                return true;
            }
        }

        return false;
    }

    private void placeShips(int boardSize) {
        for (int size : Ship.getSizes()) {
            boolean vert = ThreadLocalRandom.current().nextBoolean();
            List<Coord> coordinates;

            main:
            while (true) {
                int startX = random(boardSize, size);
                int startY = random(boardSize, size);
                Coord start = new Coord(startX, startY);

                int endX = vert ? startX : startX + size;
                int endY = vert ? startY + size : startY;
                Coord end = new Coord(endX, endY);

                coordinates = getAllCoordinates(start, end);

                for (Coord coord : coordinates) {
                    if (isInUse(coord)) {
                        continue main;
                    }
                }

                break;
            }

            ships.add(new Ship(coordinates));
        }
    }


}

