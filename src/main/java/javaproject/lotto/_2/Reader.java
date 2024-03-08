package javaproject.lotto._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = 1000;

    public int buy() throws IOException {
        System.out.print("로또를 몇장 구매하시겠습니까? (최대 5장 구매)\t");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();

        validate(inputString);

        return Integer.parseInt(inputString);
    }

    private void validate(String inputString) {
        validateNullOrEmpty(inputString);
        validateRange(inputString);
    }

    private void validateNullOrEmpty(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String inputString) {
        int lottoTicketCount = Integer.parseInt(inputString);
        if (lottoTicketCount < MIN_COUNT || lottoTicketCount > MAX_COUNT) {
            throw new IllegalArgumentException("1인 최대 5장까지만 구매 가능합니다.");
        }
    }
}
