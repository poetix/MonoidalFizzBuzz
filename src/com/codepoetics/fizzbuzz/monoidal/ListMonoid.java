package com.codepoetics.fizzbuzz.monoidal;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListMonoid<T> implements Monoid<List<T>> {
    @Override
    public List<T> zero() {
        return new LinkedList<T>();
    }

    @Override
    public List<T> product(List<T> a, List<T> b) {
        return Stream.concat(a.stream(), b.stream()).collect(Collectors.<T>toList());
    }
}
