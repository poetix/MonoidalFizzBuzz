package com.codepoetics.fizzbuzz.monoidal;

public interface Representation<T> {
    String represent(T value);
}
