package com.CarFinancing.FinanciamentoCarro.service;

import com.CarFinancing.FinanciamentoCarro.entities.Financiamento;
import com.CarFinancing.FinanciamentoCarro.entities.Usuario;
import com.CarFinancing.FinanciamentoCarro.enums.StatusFinanciamento;
import com.CarFinancing.FinanciamentoCarro.repository.FinanciamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanciamentoService {

    private final FinanciamentoRepository financiamentoRepository;

    public FinanciamentoService (FinanciamentoRepository financiamentoRepository) {
        this.financiamentoRepository = financiamentoRepository;
    }

    public Financiamento buscarPorId(Long id) {
        return financiamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Financiamento não encontrado"));
    }

    public List<Financiamento> listarFinanciamentosAnalisados() {
        return financiamentoRepository.findByStatus(StatusFinanciamento.ANALISADO);
    }

    public List<Financiamento> listarFinanciamentosSolicitados() {
        return financiamentoRepository.findByStatus(StatusFinanciamento.SOLICITADO);
    }

    public List<Financiamento> listarFinanciamentosAprovados() {
        return financiamentoRepository.findByStatus(StatusFinanciamento.APROVADO);
    }

    public List<Financiamento> listarFinanciamentosRecusados() {
        return financiamentoRepository.findByStatus(StatusFinanciamento.REPROVADO);
    }
}
