package dev.jefferson.consumerpreco.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import dev.jefferson.rabbitmqclients.constants.RabbitMQConstants;
import dev.jefferson.rabbitmqclients.dto.PrecoDTO;

@Component
public class PrecoConsumer {

	@RabbitListener(queues = RabbitMQConstants.FILA_PRECO)
	public void consumidor(PrecoDTO dto) {
		System.out.println(dto.getCodigoProduto());
		System.out.println(dto.getPreco());
		System.out.println("<--------------------------------- PREÇO");
	}
}
