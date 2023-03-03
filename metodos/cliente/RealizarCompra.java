package metodos.cliente;

import entidades.*;

import java.util.List;
import java.util.Scanner;

import static metodos.cliente.CriarVenda.criarVenda;


public class RealizarCompra {

    public static void realizarCompra(
            List<Empresa> empresas,
            List<Produto> produtos,
            List<Produto> carrinho,
            List<Cliente> clientes,
            List<Venda> vendas,
            Usuario usuarioLogado){


        Scanner sc = new Scanner(System.in);
        System.out.println("Para realizar uma compra, escolha a empresa onde deseja comprar: ");
        empresas.stream().forEach(x -> {
            System.out.println(x.getId() + " - " + x.getNome());
        });
        Integer escolhaEmpresa = sc.nextInt();
        Integer escolhaProduto = -1;
        do {
            System.out.println("Escolha os seus produtos: ");
            produtos.stream().forEach(x -> {
                if (x.getEmpresa().getId().equals(escolhaEmpresa)) {
                    System.out.println(x.getId() + " - " + x.getNome());
                }
            });
            System.out.println("0 - Finalizar compra");
            escolhaProduto = sc.nextInt();
            for (Produto produtoSearch : produtos) {
                if (produtoSearch.getId().equals(escolhaProduto))
                    carrinho.add(produtoSearch);
            }
        } while (escolhaProduto != 0);
        System.out.println("************************************************************");
        System.out.println("Resumo da compra: ");
        carrinho.stream().forEach(x -> {
            if (x.getEmpresa().getId().equals(escolhaEmpresa)) {
                System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
            }
        });
        Empresa empresaEscolhida = empresas.stream().filter(x -> x.getId().equals(escolhaEmpresa)).toList().get(0);
        Cliente clienteLogado = clientes.stream()
                .filter(x -> x.getUsername().equals(usuarioLogado.getUsername())).toList().get(0);
        Venda venda = criarVenda(carrinho, empresaEscolhida, clienteLogado, vendas);
        System.out.println("Total: R$" + venda.getValor());
        System.out.println("************************************************************");
        carrinho.clear();

    }
}
