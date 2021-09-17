package br.com.gustavolemillion.view;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {

    public static void menuPrincipal() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------Acesso Canil Cão Feliz!------------");
        System.out.println("O que deseja fazer?"+
                "\n [1] Acessar Clientes" +
                "\n [2] Acessar Cachorros" +
                "\n [3] Acessar Reservas");
        int escolha = scanner.nextInt();

        switch (escolha){
            case 1:
                Menus.menuCrudCliente();
                break;
            case 2:
                Menus.menuCrudCachorro();
                break;
            case 3:
                Menus.menuCrudReserva();
                break;
        }

    }

}
