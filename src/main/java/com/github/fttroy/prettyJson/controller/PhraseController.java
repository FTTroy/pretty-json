package com.github.fttroy.prettyJson.controller;

import com.github.fttroy.prettyJson.enums.Reason;
import com.github.fttroy.prettyJson.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/phrase-controller")
public class PhraseController {

    @Autowired
    private PhraseService service;

    @GetMapping("/generate-phrase")
    public String generatePhrase(@RequestParam Reason reason) throws IOException {
        return service.generatePhrase(reason);
    }
}
