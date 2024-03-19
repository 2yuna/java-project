package javaproject.lotto._4.service;

import javaproject.lotto._3.Lotto;
import org.springframework.stereotype.Service;

@Service
public class AdminLottoService {

    public Lotto draw() {
        return Lotto.create();
    }
}