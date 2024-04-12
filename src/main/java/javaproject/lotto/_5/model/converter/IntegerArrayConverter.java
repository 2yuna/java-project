package javaproject.lotto._5.model.converter;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class IntegerArrayConverter implements AttributeConverter<Set<Integer>, String> {
    private static final String SPLIT_CHAR = ",";

    @Override
    public String convertToDatabaseColumn(Set<Integer> attribute) {
        return attribute.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SPLIT_CHAR));
    }

    @Override
    public Set<Integer> convertToEntityAttribute(String data) {
        return Arrays.stream(data.split(SPLIT_CHAR))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
