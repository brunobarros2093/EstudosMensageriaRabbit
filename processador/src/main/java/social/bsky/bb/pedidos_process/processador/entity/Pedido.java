package social.bsky.bb.pedidos_process.processador.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import social.bsky.bb.pedidos_process.processador.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    UUID id;
    private String cliente;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;
    @Column(name = "valor_total")
    private Double valorTotal;
    @Column(name = "enail_notification")
    private String emailNotificacao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora;

}
