package dev.jefferson.estoquepreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jefferson.estoquepreco.service.RabbitMQService;
import dev.jefferson.rabbitmqclients.constants.RabbitMQConstants;
import dev.jefferson.rabbitmqclients.dto.PrecoDTO;

@RestController
@RequestMapping("/preco")
public class PrecoController {
	
	@Autowired
	private RabbitMQService service;

	
	@PutMapping
	private ResponseEntity<PrecoDTO> alterarPreco(@RequestBody PrecoDTO dto) {
		this.service.enviaMensagem(RabbitMQConstants.FILA_PRECO, dto);
		return new ResponseEntity<PrecoDTO>(HttpStatus.OK);
	}
}
