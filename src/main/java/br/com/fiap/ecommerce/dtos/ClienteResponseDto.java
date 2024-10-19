package br.com.fiap.ecommerce.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import br.com.fiap.ecommerce.model.Cliente;

@Data
@NoArgsConstructor
public class ClienteResponseDto {
    private Long id;
    private String bairro;
    private String cep;
    private String complemento;
    private String logradouro;
    private String municipio;
    private String nome;
    private int numero;
    private String uf;
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ClienteResponseDto toDto(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseDto.class);
    }
}
