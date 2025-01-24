package social.bsky.bb.notificacao_service.entity;

import java.util.UUID;

public record Produto(
        UUID id, String nome, double preco
) {
    public Produto {
        id = UUID.randomUUID();
    }
}
