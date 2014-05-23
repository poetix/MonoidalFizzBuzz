package com.codepoetics.fizzbuzz.monoidal;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FizzBuzz implements Predicate<Integer> {
    Fizz(i -> i % 3 == 0),
    Buzz(i -> i % 5 == 0),
    Bang(i -> i % 7 == 0);

    private final Predicate<Integer> predicate;
    private FizzBuzz(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    @Override public boolean test(Integer i) { return predicate.test(i); }

    public static final ListMonoid<FizzBuzz> monoid = new ListMonoid<FizzBuzz>();

    public static final Interpreter<List<FizzBuzz>> interpreter = i -> Stream.of(FizzBuzz.values())
            .filter(fb -> fb.test(i))
            .map(Collections::<FizzBuzz>singletonList)
            .collect(Collectors.toList());

    public static final Representation<List<FizzBuzz>> representation = gs ->
            String.join("", gs.stream().map(FizzBuzz::name).collect(Collectors.toList()));
}
