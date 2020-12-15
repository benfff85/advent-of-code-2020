package com.adventofcode.day12;


import static com.adventofcode.day12.Constants.*;
import static java.lang.Math.abs;

public class Ship {

    private Integer xCoordinate = 0;
    private Integer yCoordinate = 0;
    private String direction = E;
    private final boolean isWaypointEnabled;
    private Integer xWaypointCoordinate = 10;
    private Integer yWaypointCoordinate = 1;

    public Ship(boolean isWaypointEnabled) {
        this.isWaypointEnabled = isWaypointEnabled;
    }

    public void process(Instruction instruction) {
        if (R.equals(instruction.getOrder()) || L.equals(instruction.getOrder()))
            turn(instruction.getOrder(), instruction.getValue());
        else if (F.equals(instruction.getOrder()))
            moveForward(instruction.getValue());
        else
            move(instruction.getOrder(), instruction.getValue());
    }

    private void moveForward(Integer distance) {
        if (isWaypointEnabled) {
            moveTowardsWaypoint(distance);
        } else {
            moveShip(direction, distance);
        }
    }

    private void moveTowardsWaypoint(Integer distance) {
        for (int i = 0; i < distance; i++) {
            xCoordinate += xWaypointCoordinate;
            yCoordinate += yWaypointCoordinate;
        }
    }

    private void move(String dir, Integer distance) {
        if (isWaypointEnabled) {
            moveWaypoint(dir, distance);
        } else {
            moveShip(dir, distance);
        }

    }

    private void moveWaypoint(String dir, Integer distance) {
        if (E.equals(dir))
            xWaypointCoordinate += distance;
        if (W.equals(dir))
            xWaypointCoordinate -= distance;
        if (N.equals(dir))
            yWaypointCoordinate += distance;
        if (S.equals(dir))
            yWaypointCoordinate -= distance;
    }

    private void moveShip(String dir, Integer distance) {
        if (E.equals(dir))
            xCoordinate += distance;
        if (W.equals(dir))
            xCoordinate -= distance;
        if (N.equals(dir))
            yCoordinate += distance;
        if (S.equals(dir))
            yCoordinate -= distance;
    }

    private void turn(String order, Integer degrees) {
        for (int i = 0; i < degrees / 90; i++) {
            if (R.equals(order)) {
                if (isWaypointEnabled) {
                    Integer tmp = yWaypointCoordinate;
                    yWaypointCoordinate = xWaypointCoordinate * -1;
                    xWaypointCoordinate = tmp;
                } else {
                    if (E.equals(direction))
                        direction = S;
                    else if (S.equals(direction))
                        direction = W;
                    else if (W.equals(direction))
                        direction = N;
                    else if (N.equals(direction))
                        direction = E;
                }
            }
            if (L.equals(order)) {
                if (isWaypointEnabled) {
                    Integer tmp = xWaypointCoordinate;
                    xWaypointCoordinate = yWaypointCoordinate * -1;
                    yWaypointCoordinate = tmp;
                } else {
                    if (E.equals(direction))
                        direction = N;
                    else if (N.equals(direction))
                        direction = W;
                    else if (W.equals(direction))
                        direction = S;
                    else if (S.equals(direction))
                        direction = E;
                }
            }
        }
    }

    public Integer getManhattanDistance() {
        return abs(xCoordinate) + abs(yCoordinate);
    }

}
