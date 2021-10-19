package com.example.foxandgeese.Chips;

import com.example.foxandgeese.Fields.Field;

public interface GameChip {
    Field position();

    default String icon() {
        return String.format(
                "%s.xml", getClass().getSimpleName().toLowerCase()
        );
    }
}
