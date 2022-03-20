package dev.jefferson.consumerestoque.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import dev.jefferson.rabbitmqclients.constants.RabbitMQConstants;
import dev.jefferson.rabbitmqclients.dto.EstoqueDTO;

@Component
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbitMQConstants.FILA_ESTOQUE)
	private void consumidor(EstoqueDTO dto) {
		System.out.println(dto.getCodigoProduto());
		System.out.println(dto.getQuantidade());
	}

}
