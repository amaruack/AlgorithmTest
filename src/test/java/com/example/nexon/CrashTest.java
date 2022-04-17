package com.example.nexon;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CrashTest {

    @Test
    public void lastStoneWeight() {

        int result = Crash.lastStoneWeight(Arrays.asList(new Integer[]{1,4,2,3,5}));
        assertEquals(result, 1);
    }

    @Test
    public void lastStoneWeight2() {

        int result = Crash.lastStoneWeight(Arrays.asList(new Integer[]{1,4,2,3,5}));
        assertEquals(result, 2);
    }
}