package social.bsky.bb.pedidos_process.processador.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import social.bsky.bb.pedidos_process.processador.entity.ItemPedido;
import social.bsky.bb.pedidos_process.processador.entity.Pedido;
import social.bsky.bb.pedidos_process.processador.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    private final Logger log = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ItemPedidoService itemPedidoService;


    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ItemPedidoService itemPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoService = itemPedidoService;
        this.produtoService = produtoService;
    }

    public void save(Pedido pedido) {
        produtoService.save(pedido.getItens());
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItens());
        pedidoRepository.save(pedido);

        itemPedidoService.updatedPedidos(itemPedidos, pedido);

        log.info("Pedido salvo com sucesso");

    }


}
