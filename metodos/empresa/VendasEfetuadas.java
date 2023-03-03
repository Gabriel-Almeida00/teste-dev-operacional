package metodos.empresa;

import entidades.Usuario;
import entidades.Venda;

import java.util.List;

public class VendasEfetuadas {

    public static void vendasEfetuadas(Usuario usuarioLogado, List<Venda> vendas){
        System.out.println();
        System.out.println("************************************************************");
        System.out.println("VENDAS EFETUADAS");
        vendas.stream().forEach(venda -> {
            if (venda.getEmpresa().getId().equals(usuarioLogado.getEmpresa().getId())) {
                System.out.println("************************************************************");
                System.out.println("Venda de código: " + venda.getCódigo() + " no CPF "
                        + venda.getCliente().getCpf() + ": ");
                venda.getItens().stream().forEach(x -> {
                    System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
                });
                System.out.println("Total Venda: R$" + venda.getValor());
                System.out.println("Total Taxa a ser paga: R$" + venda.getComissaoSistema());
                System.out.println("Total Líquido  para empresa "
                        + (venda.getValor() - venda.getComissaoSistema()));
                System.out.println("************************************************************");
            }
            System.out.println("Saldo Empresa: "  +  usuarioLogado.getEmpresa().getSaldo());
            System.out.println("************************************************************");
        });
    }
}
