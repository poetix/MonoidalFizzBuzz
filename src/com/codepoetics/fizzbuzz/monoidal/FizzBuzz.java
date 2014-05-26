package com.codepoetics.fizzbuzz.monoidal;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzz  {

    static final StringMonoid stringMonoid = new StringMonoid();

    private static String fizz(int n) { if(n % 3 == 0) return "Fizz"; else return stringMonoid.zero(); }

    private static String buzz(int n) {
        if(n % 5 == 0) return "Buzz"; else return stringMonoid.zero();
    }

    private static String bang(int n) {
        if(n % 5 != 0 && n % 3 != 0) return String.valueOf(n); else return stringMonoid.zero();
    }

    public static final Interpreter<String> interpreter = i -> Stream.of(fizz(i), buzz(i), bang(i));

    public static final Representation<String> representation = gs -> gs;
}
