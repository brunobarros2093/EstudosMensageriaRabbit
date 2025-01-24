package social.bsky.bb.notificacao_service.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import social.bsky.bb.notificacao_service.entity.Pedido;

@Component
public class PedidoListener {
    private final Logger log = LoggerFactory.getLogger(PedidoListener.class);

    @RabbitListener(queues = "pedidos.v1.pedido-criado-gerar-notificacao")
    public void sendNotification(Pedido pedido) {
        log.info("Pedido notificado: " + pedido);

    }
}
