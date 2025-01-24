package social.bsky.bb.pedidos_api.api.entity;

import social.bsky.bb.pedidos_api.api.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record Pedido(UUID id,
                     String cliente,
                     List<ItemPedido> itens,
                     Double valorTotal,
                     String emailNotificacao,
                     Status status,
                     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dataHora) {

    public Pedido {
        id = UUID.randomUUID();
        status = Status.EM_PROCESSAMENTO;
        dataHora = LocalDateTime.now();
    }
}
