package br.com.fiap.ecommerce.dtos;

import br.com.fiap.ecommerce.model.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class ProdutoRequestCreateDto {
    private String nome;
    private int valor;

    private static final ModelMapper modelMapper = new ModelMapper();

    public Produto toModel() {
        return modelMapper.map(this, Produto.class);
    }
}
