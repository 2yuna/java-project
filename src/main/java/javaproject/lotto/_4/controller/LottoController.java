package javaproject.lotto._4.controller;

import javaproject.lotto._4.model.Lotto;
import javaproject.lotto._4.model.Ticket;
import javaproject.lotto._4.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lottos")
public class LottoController {

    private final LottoService lottoService;

    @PostMapping
    public ResponseEntity buy(@RequestBody Ticket ticket) {
        List<Lotto> lottos = lottoService.buy(ticket);
        System.out.println(lottos);
        return ResponseEntity.ok(lottos);
    }
}