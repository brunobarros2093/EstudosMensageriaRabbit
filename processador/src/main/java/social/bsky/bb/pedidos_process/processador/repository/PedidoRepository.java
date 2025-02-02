package social.bsky.bb.pedidos_process.processador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import social.bsky.bb.pedidos_process.processador.entity.Pedido;

import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
