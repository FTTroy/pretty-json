package com.github.fttroy.prettyJson.service;

import com.github.fttroy.prettyJson.enums.Reason;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

public class PhraseServiceTest {

    @InjectMocks
    private PhraseService service;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void generatePhraseTest() throws IOException, InvalidFormatException {
        Assertions.assertNotNull(service.generatePhrase(Reason.LOVE));
    }
}
