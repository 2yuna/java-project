package javaproject.lotto._5.controller;

import javaproject.lotto._5.model.Lotto;
import javaproject.lotto._5.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/lottos")
public class AdminLottoController {

    private final LottoService lottoService;

    @GetMapping
    public ResponseEntity draw() {
        lottoService.draw();
        return ResponseEntity.ok().build();
    }
}