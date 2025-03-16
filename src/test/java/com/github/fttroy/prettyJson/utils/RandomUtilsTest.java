package com.github.fttroy.prettyJson.utils;

import com.github.fttroy.prettyJson.enums.Reason;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RandomUtilsTest {

    @Test
    public void randomWordTest() throws IOException {
        String word = RandomUtils.randomWord(Reason.LOVE);
        System.out.println(word);
        Assertions.assertNotNull(word);
    }
}
