package javaproject.lotto._5.model;

import jakarta.persistence.*;
import javaproject.lotto._5.model.converter.IntegerArrayConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lotto {

    public static final int LOTTO_LENGTH = 6;
    public static final int PRICE = 1_000;

    public static final Random RANDOM = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = IntegerArrayConverter.class)
    private Set<Integer> numbers;

    private Lotto(Set<Integer> numbers) {
        validateLength(numbers);

        this.numbers = numbers;
    }

    public static Lotto create() {
        return new Lotto(logic());
    }

    private static Set<Integer> logic() {
        Set<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_LENGTH) {
            int lottoNumber = RANDOM.nextInt(45) + 1;
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private void validateLength(Set<Integer> numbers) {
        if (numbers.size() < LOTTO_LENGTH) {
            throw new IllegalStateException();
        }
    }

    public Set<Integer> toSet() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers + "";
    }

}
