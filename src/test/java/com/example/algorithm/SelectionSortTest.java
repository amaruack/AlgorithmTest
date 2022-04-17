package com.example.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void selectionSort() {
        int[] ar = new int[] {4,5,2,1} ;
        SelectionSort.selectionSort(ar);

        assertArrayEquals(ar, new int[]{1,2,4,5});

    }
}