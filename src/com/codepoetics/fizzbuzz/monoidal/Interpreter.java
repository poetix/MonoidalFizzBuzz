package com.codepoetics.fizzbuzz.monoidal;

import java.util.List;

public interface Interpreter<T> {
    List<T> interpret(int i);
}
