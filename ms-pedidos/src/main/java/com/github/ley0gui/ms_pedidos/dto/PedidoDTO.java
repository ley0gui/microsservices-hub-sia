package com.github.ley0gui.ms_pedidos.dto;


import com.github.ley0gui.ms_pedidos.entities.ItemDoPedido;
import com.github.ley0gui.ms_pedidos.entities.Pedido;
import com.github.ley0gui.ms_pedidos.entities.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PedidoDTO {
    private Long id;
    @NotEmpty(message = "Nome requerido")
    @Size(min = 3, max = 100, message = "O nome deve conter entre 3 e 100 caracteres")
    private String nome;
    @NotEmpty(message = "CPF requerido")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres - sem máscara")
    private String cpf;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Status status;
        private List<@Valid ItemdoPedidoDTO> itens = new ArrayList<>();

    public PedidoDTO(Pedido entity) {
        status = entity.getStatus();
        data = entity.getData();
        cpf = entity.getCpf();
        nome = entity.getNome();
        id = entity.getId();

        for(ItemDoPedido item : entity.getItens()){
            ItemdoPedidoDTO itemDTO = new ItemdoPedidoDTO(item);
            itens.add(itemDTO);
        }
    }


}
