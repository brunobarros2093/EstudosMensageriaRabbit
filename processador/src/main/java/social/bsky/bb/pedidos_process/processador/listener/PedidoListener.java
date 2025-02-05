package social.bsky.bb.pedidos_process.processador.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import social.bsky.bb.pedidos_process.processador.entity.Pedido;
import social.bsky.bb.pedidos_process.processador.services.PedidoService;

@Component
public class PedidoListener {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final PedidoService pedidoService;

    public PedidoListener(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado-gerar-processamento")
    public void savePedido(Pedido pedido) {
        log.info("Pedido criado com sucesso {}", pedido);
        pedidoService.save(pedido);
    }
}
