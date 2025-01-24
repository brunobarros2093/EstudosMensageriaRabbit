package social.bsky.bb.pedidos_api.api.service;

import social.bsky.bb.pedidos_api.api.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class PedidoService {

    private final Logger log = LoggerFactory.getLogger(PedidoService.class);
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;


    public PedidoService(RabbitTemplate rabbitTemplate) {

        this.rabbitTemplate = rabbitTemplate;
    }

    public Pedido enfileirarPedido(Pedido pedido) {
        rabbitTemplate.convertAndSend(exchangeName, "", pedido);
        log.info("Pedido enfileirado com sucesso {}", pedido.toString());
        return pedido;
    }
}
