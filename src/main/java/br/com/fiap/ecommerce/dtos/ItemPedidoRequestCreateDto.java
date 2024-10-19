package br.com.fiap.ecommerce.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import br.com.fiap.ecommerce.model.ItemPedido;

@Data
@NoArgsConstructor
public class ItemPedidoRequestCreateDto {
    private Long id_pedido;
    private Long id_produto;
    private int quantidade;
    private double valor_total;

    private static final ModelMapper modelMapper = new ModelMapper();

    public ItemPedido toModel() {
        return modelMapper.map(this, ItemPedido.class);
    }
}
