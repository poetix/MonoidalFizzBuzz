package com.codepoetics.fizzbuzz.monoidal;

import java.util.stream.Stream;

public interface Interpreter<T> {
    Stream<T> interpret(int i);
}
