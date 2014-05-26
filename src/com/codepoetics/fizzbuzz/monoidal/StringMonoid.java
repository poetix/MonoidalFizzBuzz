package com.codepoetics.fizzbuzz.monoidal;

public final class StringMonoid implements Monoid<String> {

    @Override
    public String zero() {
        return "";
    }

    @Override
    public String product(final String a, final String b) {
        return a + b;
    }
}
