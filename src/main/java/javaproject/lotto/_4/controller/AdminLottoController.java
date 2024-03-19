package javaproject.lotto._4.controller;

import javaproject.lotto._3.Lotto;
import javaproject.lotto._4.service.AdminLottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/lottos")
public class AdminLottoController {

    private final AdminLottoService adminLottoService;

    @GetMapping
    public ResponseEntity draw() {
        Lotto winning = adminLottoService.draw();
        return ResponseEntity.ok(winning);
    }
}