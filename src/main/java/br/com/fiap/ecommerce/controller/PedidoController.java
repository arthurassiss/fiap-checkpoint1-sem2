package br.com.fiap.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.dtos.PedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.PedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.PedidoResponseDto;
import br.com.fiap.ecommerce.service.PedidoService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("pedidos")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> list() {
        List<PedidoResponseDto> dtos = pedidoService.list()
                                                .stream()
                                                .map(e -> new PedidoResponseDto().toDto(e))
                                                .toList();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> create(@RequestBody PedidoRequestCreateDto dto) {
        System.out.println("aqqweqweqweqweqewqq");
        System.out.println(dto);
        System.out.println(dto.getStatus());
        System.out.println(dto.toModel().getStatus());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    new PedidoResponseDto().toDto(
                        pedidoService.save(dto.toModel())
                    )
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!pedidoService.existsById(id)) {
            throw new RuntimeException("id inexistente");
        }

        pedidoService.delete(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<PedidoResponseDto> update(
        @PathVariable Long id,
        @RequestBody PedidoRequestUpdateDto dto
    ) {
        if (!pedidoService.existsById(id)) {
            throw new RuntimeException("Id inexiste");
        }
        return ResponseEntity
                .ok()
                .body(
                    new PedidoResponseDto()
                            .toDto(pedidoService.save(dto.toModel(id)))
                );
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(
                    pedidoService
                        .findById(id)
                        .map(e -> new PedidoResponseDto().toDto(e))
                        .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );   
    }

}
