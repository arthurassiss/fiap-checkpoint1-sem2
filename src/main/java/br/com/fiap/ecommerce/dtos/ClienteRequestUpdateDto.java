package br.com.fiap.ecommerce.dtos;

import br.com.fiap.ecommerce.model.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class ClienteRequestUpdateDto {
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

    public Cliente toModel(Long id) {
        Cliente cliente = modelMapper.map(this, Cliente.class);
        cliente.setId(id); // Presume que o Cliente tem um método setId
        return cliente;
    }
}
