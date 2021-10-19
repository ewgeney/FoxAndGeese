package com.example.foxandgeese.Chips;

import com.example.foxandgeese.Fields.Field;

public class Geese implements GameChip {
    private final Field position;

    public Geese(final Field ps) {
        position = ps;
    }

    @Override
    public Field position() {
        return position;
    }

}
