package com.github.fttroy.prettyJson.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fttroy.prettyJson.enums.Reason;
import com.github.fttroy.prettyJson.model.Phrase;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import static com.github.fttroy.prettyJson.utils.Constants.JSON_EXTENSION;
import static com.github.fttroy.prettyJson.utils.ExcelUtils.createExcel;
import static com.github.fttroy.prettyJson.utils.RandomUtils.randomWord;

@Service
public class PhraseService {
    public String generatePhrase(Reason reason) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String fileName = reason.getValue().concat(JSON_EXTENSION);
        String jsonResource = new String(new ClassPathResource(fileName).getInputStream().readAllBytes());
        JsonNode node = mapper.readTree(jsonResource).get(randomWord(reason));
        String phrase = mapper.treeToValue(node, Phrase.class).buildPhrase();
        createExcel(phrase, reason);
        return phrase;
    }
}
