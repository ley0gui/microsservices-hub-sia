package com.github.ley0gui.ms_pedidos.dto;

import com.github.ley0gui.ms_pedidos.entities.ItemDoPedido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemdoPedidoDTO {


    private Long id;
    @NotNull(message = "Quantidade requerida")
    @Positive(message = "Quantidade deve ser um número positivo")
    private Integer quantidade;
    @NotEmpty(message = "Descrição requerida")
    private String descricao;
    @NotNull(message = "Valor Unitário requerido")
    @Positive(message = "Valor unitário deve ser um número positivo")
    private BigDecimal valorUnitario;

    public ItemdoPedidoDTO(ItemDoPedido entity) {
        id = entity.getId();
        quantidade = entity.getQuantidade();
        descricao = entity.getDescricao();
        valorUnitario = entity.getValorUnitario();
    }
}
