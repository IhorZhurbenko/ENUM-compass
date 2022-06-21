package com.epam.rd.autotasks;

import java.util.Calendar;
import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        if (degrees < 0) degrees += 360;
        switch (degrees % 360) {
            case 0:
                return Direction.N;
            case 45:
                return Direction.NE;
            case 90:
                return Direction.E;
            case 135:
                return Direction.SE;
            case 180:
                return Direction.S;
            case 225:
                return Direction.SW;
            case 270:
                return Direction.W;
            case 315:
                return Direction.NW;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        if (degrees < 0) degrees += 360;
        degrees %= 360;
        degrees += 23;
        degrees /= 45;
        if (degrees == 0) return Direction.N;
        if (degrees >= 1 && degrees < 90 / 45) return Direction.NE;
        if (degrees >= 90 / 45 && degrees < 135 / 45) return Direction.E;
        if (degrees >= 135 / 45 && degrees < 180 / 45) return Direction.SE;
        if (degrees >= 180 / 45 && degrees < 225 / 45) return Direction.S;
        if (degrees >= 225 / 45 && degrees < 270 / 45) return Direction.SW;
        if (degrees >= 270 / 45 && degrees < 315 / 45) return Direction.W;
        if (degrees >= 315 / 45) return Direction.NW;
        return null;
    }

    public Direction opposite() {
        return Direction.ofDegrees(degrees + 180);
    }

    public int differenceDegreesTo(Direction direction) {
        return Math.abs(degrees - direction.degrees);
    }
}
