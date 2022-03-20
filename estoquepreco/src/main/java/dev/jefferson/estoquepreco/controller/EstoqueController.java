package dev.jefferson.estoquepreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jefferson.estoquepreco.connections.RabbitMQConstants;
import dev.jefferson.estoquepreco.dto.EstoqueDTO;
import dev.jefferson.estoquepreco.service.RabbitMQService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitMQService service;

	
	@PutMapping
	private ResponseEntity<EstoqueDTO> alterarEstoqueI(@RequestBody EstoqueDTO dto) {
		this.service.enviaMensagem(RabbitMQConstants.FILA_ESTOQUE, dto);
		return new ResponseEntity<EstoqueDTO>(HttpStatus.OK);
	}
}
