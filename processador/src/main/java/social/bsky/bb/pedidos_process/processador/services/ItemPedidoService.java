package social.bsky.bb.pedidos_process.processador.services;

import org.springframework.stereotype.Service;
import social.bsky.bb.pedidos_process.processador.entity.ItemPedido;
import social.bsky.bb.pedidos_process.processador.entity.Pedido;
import social.bsky.bb.pedidos_process.processador.repository.ItemPedidoRepository;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }


    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemPedidoRepository.saveAll(itens);
    }

    public void save(ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);
    }

    public void updatedPedidos(List<ItemPedido> itemPedidos, Pedido pedido) {
        itemPedidos.forEach(item -> {
            item.setPedido(pedido);
            save(item);
        });
    }

}
