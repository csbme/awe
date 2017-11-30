package com.csbme.awe.service;

/**
 * The type Converter service.
 */
public class ConverterService {
    /**
     * Seconds to nanoseconds int.
     *
     * @param seconds the seconds
     * @return the int
     */
    public static int secondsToNanoseconds(int seconds) {
        return seconds * 1000;
    }
}
