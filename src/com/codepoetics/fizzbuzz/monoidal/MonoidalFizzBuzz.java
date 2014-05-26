package com.codepoetics.fizzbuzz.monoidal;

import java.util.function.Function;

public class MonoidalFizzBuzz<T, I extends Interpreter<T>, M extends Monoid<T>, R extends Representation<T>> implements Function<Integer, String> {

    private final I interpreter;
    private final M monoid;
    private final R representable;

    public MonoidalFizzBuzz(I interpreter, M monoid, R representable) {
        this.interpreter = interpreter;
        this.monoid = monoid;
        this.representable = representable;
    }

    @Override
    public String apply(Integer integer) {
        T product = interpreter.interpret(integer)
                               .reduce(monoid.zero(), monoid::product);
        return product.equals(monoid.zero()) ? integer.toString() : representable.represent(product);
    }

    public static void main(String[] argv) {
        Function<Integer, String> mfb = new MonoidalFizzBuzz<>(
                FizzBuzz.interpreter,
                FizzBuzz.stringMonoid,
                FizzBuzz.representation);

        for (int i=1; i<=100; i++) {
            System.out.println(mfb.apply(i));
        }
    }
}
