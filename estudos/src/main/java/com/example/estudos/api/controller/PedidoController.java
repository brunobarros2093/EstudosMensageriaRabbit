package com.example.estudos.api.controller;

import com.example.estudos.api.entity.Pedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Tag(name = "Pedidos", description = "Recurso para criar um novo Pedido")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Operation(summary = "Cria um novo pedido", description = "Contém operação de Criar Novo Pedido",
    responses = @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))))
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        log.info("Criando pedido: {}" + pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

    }
}
