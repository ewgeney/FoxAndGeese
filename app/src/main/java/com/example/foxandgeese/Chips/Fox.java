package com.example.foxandgeese.Chips;

import com.example.foxandgeese.Fields.Field;

public class Fox implements GameChip{
    private final Field position;

    public Fox(final Field ps) {
        position = ps;
    }

    @Override
    public Field position() {
        return position;
    }
}
