package social.bsky.bb.pedidos_api.api.entity;

import java.util.UUID;

public record Produto(
        UUID id, String nome, double preco
) {
    public Produto {
        id = UUID.randomUUID();
    }
}
