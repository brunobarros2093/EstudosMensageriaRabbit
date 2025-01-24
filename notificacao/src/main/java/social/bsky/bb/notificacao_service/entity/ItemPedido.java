package social.bsky.bb.notificacao_service.entity;


import java.util.UUID;

public record ItemPedido(UUID id, Integer quantidade, Produto produto) {
    public ItemPedido {
      id = UUID.randomUUID();
    }
}
