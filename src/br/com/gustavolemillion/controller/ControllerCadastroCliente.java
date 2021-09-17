package br.com.gustavolemillion.controller;

import br.com.gustavolemillion.Console;
import br.com.gustavolemillion.Data;
import br.com.gustavolemillion.dao.ClienteDAO;
import br.com.gustavolemillion.entity.Cliente;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ControllerCadastroCliente {

    public static void menuListaCliente(Cliente cliente){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Id:"+cliente.getId()+" | Nome: "+ cliente.getNomePessoa()+" | CPF: "+cliente.getCpf()+
                " | RG: "+cliente.getRg()+" | Data Nascimento: "+ format.format(cliente.getDataNascimento())+
                " | CEP: "+cliente.getCep()+" | Rua: "+cliente.getRua()+
                " | Número endereço: "+cliente.getNumeroEndereco()+" | Bairro: "+cliente.getBairro()+" | Cidade: " +
                cliente.getCidade()+" | Estado: "+cliente.getEstado()+"\n");
    }

    public static void menuAdcionaCliente()throws SQLException{

        System.out.println("Informe o nome do cliente:");
        String nome = Console.leLinhaTexto();

        System.out.println("Informe o cpf:");
        String cpf  = Console.leLinhaTexto();

        System.out.println("Informe o RG");
        String rg  = Console.leLinhaTexto();

        Date dataNascimento = Data.pedirData();

        System.out.println("Informe o CEP:");
        String cep  = Console.leLinhaTexto();

        System.out.println("Informe o nome do Logradouro:");
        String logradouro  = Console.leLinhaTexto();

        System.out.println("Informe o número do endereço:");
        String numeroEndreco  = Console.leLinhaTexto();;

        System.out.println("Informe o bairro:");
        String bairro  = Console.leLinhaTexto();

        System.out.println("Informe a cidade:");
        String cidade  = Console.leLinhaTexto();

        System.out.println("Informe o Estado:");
        String estado  = Console.leLinhaTexto();


        Cliente cliente = new Cliente(nome,cpf, rg, dataNascimento, cep, logradouro, numeroEndreco, bairro, cidade, estado);
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.adcionaCliente(cliente);
    }

    public static void menuUpdateCliente(Cliente cliente)throws SQLException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();
        cliente.setNomePessoa(nome);

        System.out.println("Informe o cpf:");
        String cpf  = scanner.nextLine();
        cliente.setCpf(cpf);

        System.out.println("Informe o RG");
        String rg  = scanner.nextLine();
        cliente.setRg(rg);

        Date dataNascimento = Data.pedirData();
        cliente.setDataNascimento(dataNascimento);

        System.out.println("Informe o CEP:");
        String cep  = scanner.nextLine();
        cliente.setCep(cep);

        System.out.println("Informe o nome do Logradouro:");
        String logradouro  = scanner.nextLine();
        cliente.setRua(logradouro);

        System.out.println("Informe o número do endereço:");
        String numeroEndreco  = scanner.nextLine();
        cliente.setNumeroEndereco(numeroEndreco);

        System.out.println("Informe o bairro:");
        String bairro  = scanner.nextLine();
        cliente.setBairro(bairro);

        System.out.println("Informe a cidade:");
        String cidade  = scanner.nextLine();
        cliente.setCidade(cidade);

        System.out.println("Informe o Estado:");
        String estado  = scanner.nextLine();
        cliente.setEstado(estado);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.editaCliente(cliente.getId(), cliente);
    }

    public static void menuDeletaCliente(Cliente cliente) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        System.out.println("Tem certeza que deseja excluir o cliente (1- Sim 2- Não): "+cliente.getNomePessoa());
        escolha = scanner.nextInt();

        switch (escolha){
            case 1:
                clienteDAO.deleteReservaCliente(cliente);
                clienteDAO.deleteTelefone(cliente);
                clienteDAO.deletaCliente(cliente);

                break;
            case 2:
                System.out.println("Operação cancelada!");
                break;

        }
    }

    public static void funcionalidadeEditarCliente(List<Cliente> listaCliente) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do cliente que deseja editar: ");
        int id = scanner.nextInt();
        for(Cliente cliente: listaCliente){
            if(cliente.getId() == id){
                ControllerCadastroCliente.menuUpdateCliente(cliente);
            }
        }
    }

    public static void funcionalidadeDeletarCliente(List<Cliente> listaCliente) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do cliente que deseja editar: ");
        int id = scanner.nextInt();
        for(Cliente cliente: listaCliente){
            if(cliente.getId() == id){
                ControllerCadastroCliente.menuDeletaCliente(cliente);
            }
        }
    }



}


