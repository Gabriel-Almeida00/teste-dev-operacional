package metodos.cliente;

import entidades.Cliente;
import entidades.Empresa;
import entidades.Produto;
import entidades.Venda;

import java.util.List;

public class CriarVenda {

    public static Venda criarVenda(List<Produto> carrinho, Empresa empresa, Cliente cliente, List<Venda> vendas) {
        Double total = carrinho.stream().mapToDouble(Produto::getPreco).sum();
        Double comissaoSistema = total * empresa.getTaxa();
        int idVenda = vendas.isEmpty() ? 1 : vendas.get(vendas.size() - 1).getCódigo() + 1;
        Venda venda = new Venda(idVenda, carrinho.stream().toList(), total, comissaoSistema, empresa, cliente);
        empresa.setSaldo(empresa.getSaldo() + total - venda.getComissaoSistema());
        vendas.add(venda);
        return venda;
    }
}
