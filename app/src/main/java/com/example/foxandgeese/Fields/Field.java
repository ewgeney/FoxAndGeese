package com.example.foxandgeese.Fields;

public enum Field {
    A3(0, 4), A4(0, 3), A5(0, 2),
    B3(1, 4), B4(1, 3), B5(1, 2),
    C1(2, 6), C2(2, 5), C3(2, 4), C4(2, 3), C5(2, 2), C6(2, 1), C7(2, 0),
    D1(3, 6), D2(3, 5), D3(3, 4), D4(3, 3), D5(3, 2), D6(3, 1), D7(3, 0),
    E1(4, 6), E2(4, 5), E3(4, 4), E4(4, 3), E5(4, 2), E6(4, 1), E7(4, 0),
    F3(5, 4), F4(5, 3), F5(5, 2),
    G3(6, 4), G4(6, 3), G5(6, 2);

    private final int x;
    private final int y;

    Field(int cx, int cy) {
        x = cx;
        y = cy;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
