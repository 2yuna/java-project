package javaproject.lotto;

import javaproject.lotto._1.LottoClient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

class TicketClientTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 6, 7})
    public void range(int val) throws IOException {
        LottoClient client = new LottoClient();
    }
}