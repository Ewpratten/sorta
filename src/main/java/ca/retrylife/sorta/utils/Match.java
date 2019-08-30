package ca.retrylife.sorta.utils;

public class Match<T, TO> {
    T question;

    public Match(T question) {
        this.question = question;
    }

    // public boolean in(TO set) {
    //     for (T val : set) {
    //         if (val == question) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }
}