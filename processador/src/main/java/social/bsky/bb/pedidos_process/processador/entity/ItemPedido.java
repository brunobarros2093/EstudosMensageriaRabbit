package social.bsky.bb.pedidos_process.processador.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="item_pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
    @Id
    private UUID id;
    private Integer quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne private Pedido pedido;

}
