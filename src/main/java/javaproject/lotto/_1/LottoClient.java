package javaproject.lotto._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoClient {

    public static final Random random = new Random();

    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = 5;

    public static void main(String[] args) throws IOException {
        System.out.print("로또를 몇장 구매하시겠습니까? (최대 5장 구매)\t");

        // Reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = br.readLine();

        // Validation
        if (inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int lottoTicketCount = Integer.parseInt(inputValue);
        if (lottoTicketCount < MIN_COUNT || lottoTicketCount > MAX_COUNT) {
            throw new IllegalArgumentException("1인 최대 5장까지만 구매 가능합니다.");
        }

        // Lotto Logic
        int lottoCount = 6;

        Set<Integer>[] lottoTickets = new Set[lottoTicketCount];
        for (int i = 0; i < lottoTickets.length; i++) {
            lottoTickets[i] = new HashSet<>();
            while (lottoTickets[i].size() < lottoCount) {
                int lottoNumber = random.nextInt(45) + 1;
                lottoTickets[i].add(lottoNumber);
            }
        }

        // Printer
        for (Set<Integer> lottoTicket : lottoTickets) {
            for (Integer lottoNumber : lottoTicket) {
                System.out.print(lottoNumber + "\t");
            }
            System.out.println();
        }
    }
}
