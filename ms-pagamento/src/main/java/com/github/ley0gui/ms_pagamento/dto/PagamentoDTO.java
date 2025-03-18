package com.github.ley0gui.ms_pagamento.dto;

import com.github.ley0gui.ms_pagamento.entity.Pagamento;
import com.github.ley0gui.ms_pagamento.entity.Status;
import com.github.ley0gui.ms_pagamento.repository.PagamentoRepository;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class PagamentoDTO {

    private Long id;
    @NotNull(message = "Campo obrigatório")@NotNull(message = "Campo obrigatório")
    @Positive(message = "O valor do pagamento deve ser um número positivo")
    private BigDecimal valor;
    @Size(max = 100, message = "Nome deve ter até 100 caracteres")
    private String nome;
    @Size(max = 19, message = "Número do cartão deve ter no máximo 19 caracteres")
    private String numeroDoCartao;
    @Size(max = 5, min = 5, message = "Validade até 5 caracteres")
    private String validade;
    @Size(min=3, max=3, message = "CVV tem q ter 3 caracteres")
    private String codigoDeSeguanca;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @NotNull(message = "Campo obrigatório")
    private Long pedidoId;
    @NotNull(message = "Campo obrigatório")
    private Long formaDePagamentoId;

    public PagamentoDTO(Pagamento entity){
        id = entity.getId();
        valor = entity.getValor();
        nome = entity.getNome();
        numeroDoCartao = entity.getNumeroDoCartao();
        validade = entity.getValidade();
        codigoDeSeguanca = entity.getCodigoDeSeguranca();
        status = entity.getStatus();
        pedidoId = entity.getPedidoId();
        formaDePagamentoId = entity.getFormaDePagamento();
    }

}
