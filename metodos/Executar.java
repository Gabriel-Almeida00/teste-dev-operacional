package metodos;

import entidades.*;
import metodos.cliente.ComprasEfetuadas;
import metodos.cliente.RealizarCompra;
import metodos.empresa.MeusProdutos;
import metodos.empresa.VendasEfetuadas;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Executar {


        public static void executar(List<Usuario> usuarios, List<Cliente> clientes, List<Empresa> empresas,
                List<Produto> produtos, List<Produto> carrinho, List<Venda> vendas) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Entre com seu usuário e senha:");
            System.out.print("Usuário: ");
            String username = sc.next();
            System.out.print("Senha: ");
            String senha = sc.next();


            List<Usuario> usuariosSearch = usuarios.stream().filter(x -> x.getUsername().equals(username))
                    .collect(Collectors.toList());
            if (usuariosSearch.size() > 0) {
                Usuario usuarioLogado = usuariosSearch.get(0);
                if ((usuarioLogado.getSenha().equals(senha))) {

                    System.out.println("Escolha uma opção para iniciar");
                    if (usuarioLogado.IsEmpresa()) {
                        System.out.println("1 - Listar vendas");
                        System.out.println("2 - Ver produtos");
                        System.out.println("0 - Deslogar");
                        Integer escolha = sc.nextInt();

                        switch (escolha) {
                            case 1: {
                                VendasEfetuadas.vendasEfetuadas(usuarioLogado, vendas);
                                executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                            }
                            case 2: {
                                MeusProdutos.meusProdutos(usuarioLogado, produtos);
                                executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                            }
                            case 0: {
                                executar(usuarios, clientes, empresas, produtos, carrinho, vendas);

                            }
                        }

                    } else {
                        System.out.println("1 - Relizar Compras");
                        System.out.println("2 - Ver Compras");
                        System.out.println("0 - Deslogar");
                        Integer escolha = sc.nextInt();

                        switch (escolha) {
                            case 1: {
                                RealizarCompra.realizarCompra(empresas,produtos,carrinho,clientes,vendas,usuarioLogado);
                                executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                            }
                            case 2: {
                                ComprasEfetuadas.comprasEfetuadas(vendas, usuarioLogado);
                                executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                            }
                            case 0: {
                                executar(usuarios, clientes, empresas, produtos, carrinho, vendas);

                            }

                        }
                    }

                } else
                    System.out.println("Senha incorreta");
            } else {
                System.out.println("Usuário não encontrado");
            }
        }
    }
