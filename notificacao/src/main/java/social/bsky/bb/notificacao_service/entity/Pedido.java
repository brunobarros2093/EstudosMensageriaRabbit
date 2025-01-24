package social.bsky.bb.notificacao_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import social.bsky.bb.notificacao_service.entity.enums.Status;

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
