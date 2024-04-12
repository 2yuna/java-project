package javaproject.lotto._5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Ticket {

    public static final int MIN_TICKET = 1;
    public static final int MAX_TICKET = 1_000;

    private int count;

    public Ticket(int count) {
        validateZero(count);
        validateRange(count);

        this.count = count;
    }

    private void validateZero(int count) {
        if (count == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int count) {
        if (count < MIN_TICKET || count > MAX_TICKET) {
            throw new IllegalArgumentException();
        }
    }
}
