package com.github.ley0gui.ms_pagamento.repository;

import com.github.ley0gui.ms_pagamento.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
