package com;

/**
 * <p>
 * </p>
 * <p> Date: 2014/12/20 Time: 12:58 </p>
 */
public class Pair<First,Second> {

    private First first;

    private Second second;

    private Pair() {

    }

    public static <First, Second> Pair create(final First key, final Second value) {
        Pair pair = new Pair();
        pair.first = key;
        pair.second = value;
        return pair;
    }

    public First getFirst() {
        return first;
    }

    public Second getSecond() {
        return second;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }

        Pair pair = (Pair) o;

        if (!first.equals(pair.first)) {
            return false;
        }
        if (!second.equals(pair.second)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }
}
