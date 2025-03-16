package com.github.fttroy.prettyJson.utils;

import com.github.fttroy.prettyJson.enums.Reason;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.random.RandomGenerator;

import static com.github.fttroy.prettyJson.utils.Constants.*;

public class RandomUtils {

    public static int randomFrom(int size) {
        return RandomGenerator.getDefault().nextInt(size);
    }

    public static String randomWord(Reason reason) throws IOException {
        List<String> words = Files.readAllLines(Path.of(new ClassPathResource(TXT_ROOT.concat(reason.getValue()).concat(WORDS_SUFFIX).concat(TXT_EXTENSION)).getURI()));
        return words.get(randomFrom(words.size()));
    }
}
