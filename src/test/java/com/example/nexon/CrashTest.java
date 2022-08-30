package com.example.nexon;


import com.example.yogiyo.Test04;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;

public class CrashTest {

    @Test
    public void lastStoneWeight() {

//        int result = Crash.lastStoneWeight(Arrays.asList(new Integer[]{1,4,2,3,5}));
//        assertEquals(result, 1);
    }

    @Test
    public void lastStoneWeight2() {
        System.out.println(new Integer(3).compareTo(new Integer(2)));
        System.out.println(new Integer(2).compareTo(new Integer(3)));
        assertThat(":").isEqualTo(is("test"));

        Throwable thrown = catchThrowable(() -> {

        });
        assertThat(thrown).isInstanceOf(Exception.class)
                .hasMessageContaining("boom");
    }
}