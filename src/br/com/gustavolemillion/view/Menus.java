package br.com.gustavolemillion.view;

import br.com.gustavolemillion.controller.ControllerCadastroCachorro;
import br.com.gustavolemillion.controller.ControllerCadastroCliente;
import br.com.gustavolemillion.controller.ControllerEfetuarReserva;
import br.com.gustavolemillion.dao.CachorroDAO;
import br.com.gustavolemillion.dao.ClienteDAO;
import br.com.gustavolemillion.dao.ReservaDAO;
import br.com.gustavolemillion.entity.Cachorro;
import br.com.gustavolemillion.entity.Cliente;
import br.com.gustavolemillion.entity.Reserva;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menus {

    public static void menuCrudCachorro() throws SQLException {
        CachorroDAO cachorroDAO = new CachorroDAO();
        List<Cachorro> listaCachorro;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------Canil Cão Feliz!-----------");
        boolean repeat = false;
        do {
            System.out.println("O que deseja fazer:"+
                    "\n [1] Listar cachorros " +
                    "\n [2] Cadastrar novo cachorro"+
                    "\n [0] Voltar para o inicio");
            int escolha = scanner.nextInt();

            switch (escolha){
                case 0 :
                    MenuPrincipal.menuPrincipal();
                    break;
                case 1:
                    System.out.println("Você deseja listar"+
                            "\n [1] Filhotes " +
                            "\n [2] Matrizes"+
                            "\n [3] Padreadores" +
                            "\n [0] Voltar para o inicio");
                    int lista = scanner.nextInt();
                    switch (lista){
                        case 0:
                            MenuPrincipal.menuPrincipal();
                            break;
                        case 1:
                            listaCachorro = cachorroDAO.retornaFilhotes();
                            for (Cachorro cachorro: listaCachorro) {
                                ControllerCadastroCachorro.menuListaCachorros(cachorro);
                            }
                            System.out.println("Deseja"+
                                    "\n [1] Editar" +
                                    "\n [2] Deletar");
                            int editarDeletar = scanner.nextInt();
                            switch (editarDeletar){
                                case 1:
                                    ControllerCadastroCachorro.funcionalidadeEditarCachorro(listaCachorro);
                                    MenuPrincipal.menuPrincipal();
                                    break;
                                case 2:
                                    ControllerCadastroCachorro.funcionalidadeDeletarCachorro(listaCachorro);
                                    MenuPrincipal.menuPrincipal();
                                    break;
                            }
                            break;
                        case 2:
                            listaCachorro = cachorroDAO.retornaMatriz();
                            for (Cachorro cachorro: listaCachorro) {
                                ControllerCadastroCachorro.menuListaCachorros(cachorro);
                            }
                            System.out.println("Deseja"+
                                    "\n [1] Editar" +
                                    "\n [2] Deletar"+
                                    "\n [0] Votlar para o inicio");
                            int i = scanner.nextInt();
                            switch (i){
                                case 0:
                                    MenuPrincipal.menuPrincipal();
                                    break;
                                case 1:
                                    ControllerCadastroCachorro.funcionalidadeEditarCachorro(listaCachorro);
                                    MenuPrincipal.menuPrincipal();
                                    break;
                                case 2:
                                    ControllerCadastroCachorro.funcionalidadeDeletarCachorro(listaCachorro);
                                    MenuPrincipal.menuPrincipal();
                                    break;
                            }
                            break;
                        case 3:
                            listaCachorro = cachorroDAO.retornaPadreador();
                            for (Cachorro cachorro: listaCachorro) {
                                ControllerCadastroCachorro.menuListaCachorros(cachorro);
                            }
                            System.out.println("Deseja"+
                                    "\n [1] Editar" +
                                    "\n [2] Deletar"+
                                    "\n [0] Voltar pro inicio");
                            int j = scanner.nextInt();
                            switch (j){
                                case 0:
                                    MenuPrincipal.menuPrincipal();
                                    break;
                                case 1:
                                    ControllerCadastroCachorro.funcionalidadeEditarCachorro(listaCachorro);
                                    MenuPrincipal.menuPrincipal();
                                    break;
                                case 2:
                                    ControllerCadastroCachorro.funcionalidadeDeletarCachorro(listaCachorro);
                                    MenuPrincipal.menuPrincipal();
                                    break;
                            }
                            break;
                    }
                    repeat = false;
                    break;
                case 2:
                    ControllerCadastroCachorro.menuAdcionaCachorro();
                    MenuPrincipal.menuPrincipal();
                    repeat = false;
                    break;
                default:
                    repeat = true;
                    break;

            }

        }while (repeat);


    }

    public static void menuCrudCliente() throws SQLException{
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaCliente;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------Canil Cão Feliz!-----------");
        boolean repeat = false;
        do {
            System.out.println("O que deseja fazer:"+
                    "\n [1] Listar cliente " +
                    "\n [2] Cadastrar novo cliente"+
                    "\n [0] Voltar pro início");
            int escolha = scanner.nextInt();

            switch (escolha){
                case 0:
                    MenuPrincipal.menuPrincipal();
                    break;
                case 1:
                    listaCliente = clienteDAO.retornaCliente();
                    for (Cliente cliente: listaCliente) {
                        ControllerCadastroCliente.menuListaCliente(cliente);
                    }
                    System.out.println("Deseja"+
                            "\n [1] Editar" +
                            "\n [2] Deletar"+
                            "\n [0] Voltar pro início");
                    int editarDeletar = scanner.nextInt();
                    switch (editarDeletar){
                        case 0:
                            MenuPrincipal.menuPrincipal();
                            break;
                        case 1:
                            ControllerCadastroCliente.funcionalidadeEditarCliente(listaCliente);
                            MenuPrincipal.menuPrincipal();
                            break;
                        case 2:
                            ControllerCadastroCliente.funcionalidadeDeletarCliente(listaCliente);
                            MenuPrincipal.menuPrincipal();
                            break;
                    }

                    repeat = false;
                    break;
                case 2:
                    ControllerCadastroCliente.menuAdcionaCliente();
                    MenuPrincipal.menuPrincipal();
                    repeat = false;
                    break;
                default:
                    repeat = true;
                    break;

            }

        }while (repeat);
    }

    public static void menuCrudReserva() throws SQLException{
        ReservaDAO reservaDAO = new ReservaDAO();
        List<Reserva> listaReserva;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------Canil Cão Feliz!-----------");
        boolean repeat = false;
        do {
            System.out.println("O que deseja fazer?" +
                    "\n [1] Listar  reservas" +
                    "\n [2] Efetuar nova Reserva" +
                    "\n [0] Voltar para o inicio");
            int escolha = scanner.nextInt();

            switch (escolha){
                case 0:
                    MenuPrincipal.menuPrincipal();
                    break;
                case 1:
                    listaReserva = reservaDAO.retornaReserva();
                    for(Reserva reserva: listaReserva){
                        ControllerEfetuarReserva.menuListaReserva(reserva);
                    }
                    System.out.println("Deseja" +
                            "\n [1] Editar" +
                            "\n [2] Deletar");
                    int editarDeletar = scanner.nextInt();
                    switch (editarDeletar) {
                        case 1:
                            ControllerEfetuarReserva.funcionalidadeEditarReserva(listaReserva);
                            MenuPrincipal.menuPrincipal();
                            break;
                        case 2:
                            ControllerEfetuarReserva.funcionalidadeDeletarReserva(listaReserva);
                            MenuPrincipal.menuPrincipal();
                            break;
                    }
                    break;
                case 2:
                    ControllerEfetuarReserva.menuEfetuaReserva();
                    MenuPrincipal.menuPrincipal();
                    break;
            }

        }while (repeat);

    }



}
