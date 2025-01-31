package social.bsky.bb.pedidos_process.processador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "produto")
public record Produto(
        @Id UUID id, String nome, double preco
) {
    public Produto {
        id = UUID.randomUUID();
    }
}
