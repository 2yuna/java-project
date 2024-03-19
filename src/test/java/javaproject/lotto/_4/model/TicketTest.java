package javaproject.lotto._4.model;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class TicketTest {

    @Test
    @DisplayName("0개의 티켓을 생성하면 예외가 발생한다.")
    void createTicketZero() {
        // given & when
        ThrowingCallable createTicket = () -> new Ticket(0);

        // then
        assertThatCode(createTicket).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1001, 1002, 1003 })
    @DisplayName("1000개를 초과하는 티켓을 생성하면 예외가 발생한다.")
    void createTicketTooMany(int ticketCount) {
        // given & when
        ThrowingCallable createTicket = () -> new Ticket(ticketCount);

        // then
        assertThatCode(createTicket).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~1000개 사이의 값으로 티켓을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = { 1, 100, 1000 })
    void createTicket(int ticketCount) {
        // given & when
        ThrowingCallable createTicket = () -> new Ticket(ticketCount);

        // then
        assertThatCode(createTicket).doesNotThrowAnyException();
    }
}