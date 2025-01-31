package social.bsky.bb.pedidos_process.processador.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="item_pedido")
public record ItemPedido(@Id UUID id, Integer quantidade, @ManyToOne Produto produto, @ManyToOne Pedido pedido) {

    public ItemPedido {
      id = UUID.randomUUID();
    }
}
