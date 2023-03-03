package metodos.empresa;

import entidades.Produto;
import entidades.Usuario;

import java.util.List;

public class MeusProdutos {

    public static void meusProdutos(Usuario usuarioLogado, List<Produto> produtos){
        System.out.println();
        System.out.println("************************************************************");
        System.out.println("MEUS PRODUTOS");
        produtos.stream().forEach(produto -> {
            if (produto.getEmpresa().getId().equals(usuarioLogado.getEmpresa().getId())) {
                System.out.println("************************************************************");
                System.out.println("Código: " + produto.getId());
                System.out.println("Produto: " + produto.getNome());
                System.out.println("Quantidade em estoque: " + produto.getQuantidade());
                System.out.println("Valor: R$" + produto.getPreco());
                System.out.println("************************************************************");
            }
        });
        System.out.println("Saldo Empresa: " + usuarioLogado.getEmpresa().getSaldo());
        System.out.println("************************************************************");
    }
}
