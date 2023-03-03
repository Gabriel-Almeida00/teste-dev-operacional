package metodos.cliente;

import entidades.Usuario;
import entidades.Venda;

import java.util.List;

public class ComprasEfetuadas {

    public static void comprasEfetuadas(List<Venda> vendas, Usuario usuarioLogado) {

        System.out.println();
        System.out.println("************************************************************");
        System.out.println("COMPRAS EFETUADAS");

        vendas.stream().forEach(venda -> {
            if (venda.getCliente().getUsername().equals(usuarioLogado.getUsername())) {
                System.out.println("************************************************************");
                System.out.println("Compra de código: " + venda.getCódigo() + " na empresa "
                        + venda.getEmpresa().getNome() + ": ");
                venda.getItens().stream().forEach(x -> {
                    System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
                });
                System.out.println("Total: R$" + venda.getValor());
                System.out.println("************************************************************");
            }

        });
    }
}
