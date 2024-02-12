package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        long shotPattern = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;
        switch (shot.charAt(0)) {
            case 'A': break;
            case 'B': shotPattern >>>= 1; break;
            case 'C': shotPattern >>>= 2; break;
            case 'D': shotPattern >>>= 3; break;
            case 'E': shotPattern >>>= 4; break;
            case 'F': shotPattern >>>= 5; break;
            case 'G': shotPattern >>>= 6; break;
            case 'H': shotPattern >>>= 7; break;
        }
        shotPattern >>>= (8 * ( (int) shot.charAt(1) - 1));
        shots |= shotPattern;
        return ships == (ships | shotPattern);
    }

    public String state() {
        String shipsStr = Long.toBinaryString(ships);
        String shotsStr = Long.toBinaryString(shots);
        StringBuilder additionalZeros = new StringBuilder();

        if (shipsStr.length() < 64) {
            additionalZeros.append("0".repeat(64 - shipsStr.length()));
            shipsStr = additionalZeros.append(shipsStr).toString();
            additionalZeros.delete(0, additionalZeros.length());
        }
        if (shotsStr.length() < 64) {
            additionalZeros.append("0".repeat(64 - shotsStr.length()));
            shotsStr = additionalZeros.append(shotsStr).toString();
            additionalZeros.delete(0, additionalZeros.length());
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shotsStr.length(); i++) {
            if (i % 8 == 0) {
                result.append('\n');
            }
            if (shotsStr.charAt(i) == '0' && shipsStr.charAt(i) == '0') {
                result.append('.');
            } else if (shotsStr.charAt(i) == '1' && shipsStr.charAt(i) == '0') {
                result.append('×');
            } else if (shotsStr.charAt(i) == '0' && shipsStr.charAt(i) == '1') {
                result.append('☐');
            } else if (shotsStr.charAt(i) == '1' && shipsStr.charAt(i) == '1') {
                result.append('☒');
            }
        }

        return result.toString();
    }
}
