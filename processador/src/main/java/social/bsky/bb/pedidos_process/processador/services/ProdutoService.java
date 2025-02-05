package social.bsky.bb.pedidos_process.processador.services;

import org.springframework.stereotype.Service;
import social.bsky.bb.pedidos_process.processador.entity.ItemPedido;
import social.bsky.bb.pedidos_process.processador.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public void save(List<ItemPedido> itens) {
        for (ItemPedido itemPedido : itens) {
            produtoRepository.save(itemPedido.getProduto());
        }
    }
}
