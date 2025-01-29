package social.bsky.bb.notificacao_service.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import social.bsky.bb.notificacao_service.entity.Pedido;
import social.bsky.bb.notificacao_service.service.EmailService;

@Component
public class PedidoListener {

    private EmailService emailService;
    private final Logger log = LoggerFactory.getLogger(PedidoListener.class);

    public PedidoListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado-gerar-notificacao")
    public void sendNotification(Pedido pedido) {
        log.info("Pedido notificado: " + pedido);
        emailService.sendEmail(pedido);
    }
}
