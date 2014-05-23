package com.codepoetics.fizzbuzz.monoidal;

public interface Monoid<T> {
    T zero();
    T product(T a, T b);
}
