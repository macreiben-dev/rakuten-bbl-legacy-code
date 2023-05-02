package com.arolla.legacy.testing.dummies;

public class Date {

    private final boolean _force;

    public Date(int i, int january, int i1) {
        _force = true;
    }

    public Date() {
        _force = false;
    }

    public long getTime() {
        if(_force) {
            // When the constructor is called with argument, we fake to 2000-01-01
            return 60904911600000L;
        }

        return 100;
    }
}
