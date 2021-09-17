package br.com.gustavolemillion.controller;


import br.com.gustavolemillion.dao.CachorroDAO;
import br.com.gustavolemillion.dao.ClienteDAO;
import br.com.gustavolemillion.dao.ReservaDAO;
import br.com.gustavolemillion.entity.Cachorro;
import br.com.gustavolemillion.entity.Cliente;
import br.com.gustavolemillion.entity.Reserva;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ControllerEfetuarReserva {


    public static void menuListaReserva(Reserva reserva){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Id:"+reserva.getIdReserva()+" | idCachorro: "+ reserva.getIdCachorro()+" | idCliente: "+reserva.getIdCliente()+
                " | Data Reserva: "+format.format(reserva.getDataReserva())+" | Pago reserva?: "+ reserva.getPagoReserva()+
                " | Pago Integral?: "+reserva.getPagoIntegral()+" | Entregue?: "+reserva.getEntrega()+
                " | Valor reserva: R$"+reserva.getValorReserva()+" | Valor Integral: "+reserva.getValorIntegral()+" | Forma entrega: " +
                reserva.getFormaEntrega()+" | Forma Pagamento: "+reserva.getFormaPagamento()+"\n");
    }

    public static void menuEfetuaReserva(){
        Scanner scanner = new Scanner(System.in);
        CachorroDAO cachorroDAO = new CachorroDAO();
        List<Cachorro> listaCachorro = cachorroDAO.retornaFilhotes();
        for(Cachorro cachorro: listaCachorro){
            ControllerCadastroCachorro.menuListaCachorros(cachorro);
        }


        System.out.println("Informe o Id do Cachorro:");
        int idCachorro = scanner.nextInt();

        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaCliente = clienteDAO.retornaCliente();
        for(Cliente cliente: listaCliente){
            ControllerCadastroCliente.menuListaCliente(cliente);
        }

        System.out.println("Informe o id do Cliente");
        int idCliente = scanner.nextInt();

        Date dataReserva = new Date(System.currentTimeMillis());

        String pagoReserva = "s";
        String pagoIntegral = "n";
        String entregue = "n";

        System.out.println("Qual o valor da Reserva?");
        Double valorReserva = scanner.nextDouble();

        System.out.println("Qual o valor integral do cachorro?");
        Double valoIntegral = scanner.nextDouble();

        System.out.println("Qual a forma de entrega: Retirar no local - Transportadora");
        String formaEntregue = scanner.nextLine();

        System.out.println("Qual a forma pagamento? Pix - Débito - Crédito - Boleto");
        String formaPagamento = scanner.nextLine();

        Reserva reserva = new Reserva(idCachorro, idCliente, dataReserva,pagoReserva,pagoIntegral, entregue,valorReserva, valoIntegral, formaEntregue, formaPagamento );
        ReservaDAO reservaDAO = new ReservaDAO();
        reservaDAO.criaReserva(reserva);

    }

    public static void menuUpdateReserva(Reserva novaReserva) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        CachorroDAO cachorroDAO = new CachorroDAO();
        List<Cachorro> listaCachorro = cachorroDAO.retornaFilhotes();
        for(Cachorro cachorro: listaCachorro){
            ControllerCadastroCachorro.menuListaCachorros(cachorro);
        }


        System.out.println("Informe o Id do Cachorro:");
        int idCachorro = scanner.nextInt();
        novaReserva.setIdCachorro(idCachorro);


        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaCliente = clienteDAO.retornaCliente();
        for(Cliente cliente: listaCliente){
            ControllerCadastroCliente.menuListaCliente(cliente);
        }


        System.out.println("Informe o id do Cliente");
        int idCliente = scanner.nextInt();
        novaReserva.setIdReserva(idCliente);

        Date dataReserva = new Date(System.currentTimeMillis());
        novaReserva.setDataReserva(dataReserva);


        System.out.println("Cliente pagou o valor integral?");
        String pagoIntegral = scanner.nextLine();
        novaReserva.setPagoIntegral(pagoIntegral);

        System.out.println("O cachorro foi entregue ao cliente?");
        String entregue = scanner.nextLine();
        novaReserva.setEntrega(entregue);

        System.out.println("Qual o valor da Reserva?");
        Double valorReserva = scanner.nextDouble();
        novaReserva.setValorReserva(valorReserva);

        System.out.println("Qual o valor integral do cachorro?");
        Double valoIntegral = scanner.nextDouble();
        novaReserva.setValorIntegral(valoIntegral);

        System.out.println("Qual a forma de entrega: Retirar no local - Transportadora");
        String formaEntregue = scanner.nextLine();
        novaReserva.setFormaEntrega(formaEntregue);

        System.out.println("Qual a forma pagamento? Pix - Débito - Crédito - Boleto");
        String formaPagamento = scanner.nextLine();
        novaReserva.setFormaPagamento(formaPagamento);


        ReservaDAO reservaDAO = new ReservaDAO();
        reservaDAO.editaReserva(novaReserva.getIdReserva(), novaReserva);

    }

    public static  void menuDeletaReserva(Reserva reserva) throws SQLException{
        ReservaDAO reservaDAO = new ReservaDAO();
        Scanner scanner = new Scanner(System.in);
        int escolha;
        System.out.println("Tem certeza que deseja excluir a reserva (1- Sim 2- Não): ");
        escolha = scanner.nextInt();

        switch (escolha){
            case 1:
                reservaDAO.deletaReserva(reserva);


                break;
            case 2:
                System.out.println("Operação cancelada!");
                break;

        }
    }

    public static void funcionalidadeEditarReserva(List<Reserva> listaReserva) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID da reserva que deseja editar: ");
        int id = scanner.nextInt();
        for(Reserva reserva: listaReserva){
            if(reserva.getIdReserva() == id){
                ControllerEfetuarReserva.menuUpdateReserva(reserva);
            }
        }
    }

    public static void funcionalidadeDeletarReserva(List<Reserva> listaReserva) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID da reserva que deseja editar: ");
        int id = scanner.nextInt();
        for(Reserva reserva: listaReserva){
            if(reserva.getIdReserva() == id){
                ControllerEfetuarReserva.menuDeletaReserva(reserva);
            }
        }
    }


}
