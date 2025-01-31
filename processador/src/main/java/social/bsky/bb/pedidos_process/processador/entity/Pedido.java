package social.bsky.bb.pedidos_process.processador.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import social.bsky.bb.pedidos_process.processador.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public record Pedido(@Id UUID id,
                     String cliente,
                     @OneToMany(mappedBy = "pedido")
                     List<ItemPedido> itens,
                     @Column(name = "valor_total")
                     Double valorTotal,
                     @Column(name = "enail_notification")
                     String emailNotificacao,
                     @Enumerated(EnumType.STRING)
                     Status status,
                     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dataHora) {

    public Pedido {
        id = UUID.randomUUID();
        status = Status.EM_PROCESSAMENTO;
        dataHora = LocalDateTime.now();
    }
}
