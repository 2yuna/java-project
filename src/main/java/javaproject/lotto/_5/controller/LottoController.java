package javaproject.lotto._5.controller;

import javaproject.lotto._5.model.Lotto;
import javaproject.lotto._5.model.Ticket;
import javaproject.lotto._5.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lottos")
public class LottoController {

    private final LottoService lottoService;

    @PostMapping
    public ResponseEntity buy(@RequestBody Ticket ticket) {
        lottoService.buy(ticket);
        return ResponseEntity.ok().build();
    }
}