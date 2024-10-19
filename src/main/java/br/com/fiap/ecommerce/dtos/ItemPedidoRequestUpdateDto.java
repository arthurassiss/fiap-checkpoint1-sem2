package br.com.fiap.ecommerce.dtos;

import br.com.fiap.ecommerce.model.ItemPedido;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class ItemPedidoRequestUpdateDto {
    private Long id;
    private Long id_pedido;
    private Long id_produto;
    private int quantidade;
    private double valor_total;

    private static final ModelMapper modelMapper = new ModelMapper();

    public ItemPedido toModel() {
        ItemPedido itemPedido = modelMapper.map(this, ItemPedido.class);
        itemPedido.setId(this.id); // Usa o id da própria classe
        return itemPedido;
    }
}
