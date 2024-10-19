package br.com.fiap.ecommerce.dtos;

import br.com.fiap.ecommerce.model.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class ProdutoRequestUpdateDto {
    private String nome;
    private int valor;

    private static final ModelMapper modelMapper = new ModelMapper();

    public Produto toModel(Long id) {
        Produto produto = modelMapper.map(this, Produto.class);
        produto.setId(id); // Presume que o Produto tem um método setId
        return produto;
    }
}
