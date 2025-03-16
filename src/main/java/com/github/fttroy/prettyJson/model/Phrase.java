package com.github.fttroy.prettyJson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.StringJoiner;

import static com.github.fttroy.prettyJson.utils.RandomUtils.randomFrom;

@Data
public class Phrase {
    @JsonProperty("start")
    private List<String> start;
    @JsonProperty("middle")
    private List<String> middle;
    @JsonProperty("end")
    private List<String> end;

    public String buildPhrase() {
        return new StringJoiner(" ")
                .add(start.get(randomFrom(start.size())))
                .add(middle.get(randomFrom(middle.size())))
                .add(end.get(randomFrom(end.size())))
                .toString();
    }
}
