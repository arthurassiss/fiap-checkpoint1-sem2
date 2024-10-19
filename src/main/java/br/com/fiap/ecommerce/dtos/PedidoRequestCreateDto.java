package br.com.fiap.ecommerce.dtos;

import java.time.LocalDateTime;
import br.com.fiap.ecommerce.model.Pedido;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class PedidoRequestCreateDto {
    private LocalDateTime data_pedido;
    private String forma_pagamento;
    private Long id_cliente;
    private String status;
    private double valor_total;

    private static final ModelMapper modelMapper = new ModelMapper();

    public Pedido toModel() {
        return modelMapper.map(this, Pedido.class);
    }
}
