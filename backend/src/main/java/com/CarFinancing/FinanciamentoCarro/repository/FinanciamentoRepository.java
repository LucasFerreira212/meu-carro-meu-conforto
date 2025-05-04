package com.CarFinancing.FinanciamentoCarro.repository;

import com.CarFinancing.FinanciamentoCarro.entities.Financiamento;
import com.CarFinancing.FinanciamentoCarro.enums.StatusFinanciamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FinanciamentoRepository extends JpaRepository<Financiamento, Long> {
    @Override
    @NonNull
    Optional<Financiamento> findById(@NonNull Long id);
    List<Financiamento> findByStatus(StatusFinanciamento status);
}
