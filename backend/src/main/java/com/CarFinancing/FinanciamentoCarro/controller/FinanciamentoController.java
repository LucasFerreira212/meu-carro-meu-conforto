package com.CarFinancing.FinanciamentoCarro.controller;

import com.CarFinancing.FinanciamentoCarro.entities.Financiamento;
import com.CarFinancing.FinanciamentoCarro.service.FinanciamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/financiamentos")
public class FinanciamentoController {

    private final FinanciamentoService financiamentoService;

    public FinanciamentoController(FinanciamentoService usuarioService) {
        this.financiamentoService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Financiamento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(financiamentoService.buscarPorId(id));
    }

    @GetMapping("/analisados")
    public ResponseEntity<List<Financiamento>> listarAnalisados() {
        List<Financiamento> analisados = financiamentoService.listarFinanciamentosAnalisados();
        return ResponseEntity.ok(analisados);
    }

    @GetMapping("/solicitados")
    public ResponseEntity<List<Financiamento>> listarSolicitados() {
        List<Financiamento> solicitados = financiamentoService.listarFinanciamentosSolicitados();
        return ResponseEntity.ok(solicitados);
    }

    @GetMapping("/aprovados")
    public ResponseEntity<List<Financiamento>> listarAprovados() {
        List<Financiamento> aprovados = financiamentoService.listarFinanciamentosAprovados();
        return ResponseEntity.ok(aprovados);
    }

    @GetMapping("/recusados")
    public ResponseEntity<List<Financiamento>> listarRecusados() {
        List<Financiamento> recusados = financiamentoService.listarFinanciamentosRecusados();
        return ResponseEntity.ok(recusados);
    }
}
