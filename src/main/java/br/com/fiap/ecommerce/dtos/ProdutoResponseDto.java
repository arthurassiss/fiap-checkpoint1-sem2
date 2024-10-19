package br.com.fiap.ecommerce.dtos;

import br.com.fiap.ecommerce.model.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class ProdutoResponseDto {
    private Long id;
    private String nome;
    private double valor;

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProdutoResponseDto toDto(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDto.class);
    }
}
