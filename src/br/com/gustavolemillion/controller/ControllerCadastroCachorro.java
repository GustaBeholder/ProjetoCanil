package br.com.gustavolemillion.controller;

import br.com.gustavolemillion.dao.CachorroDAO;
import br.com.gustavolemillion.entity.Cachorro;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public  class ControllerCadastroCachorro {

    public static void menuListaCachorros(Cachorro cachorro){

        System.out.println("Id:"+cachorro.getId()+" | Nome: "+ cachorro.getNome()+" | Nome matriz: "+cachorro.getNomeMae()+
                " | Nome padreador: "+cachorro.getNomePadreador()+" | Número pedigree: "+cachorro.getNumeroPedigree()+
                " | Número microchip: "+cachorro.getNumeroMicrochip()+" | Dono: "+cachorro.getDono()+
                " | Tipo: "+cachorro.getTipo()+" | Sexo: "+cachorro.getSexo()+"\n");
    }

    private static String retornaTipo(){
        Scanner scanner = new Scanner(System.in);
        String tipo = "filhote";
        boolean repeat = false;
        do {
            System.out.println("Informe o tipo do cachorro \n 1-filhote \n 2-mãe  \n 3-padreador");
            int escolha = scanner.nextInt();
            switch (escolha){
                case 1:
                    tipo = "filhote";
                    repeat = false;
                    break;
                case 2:
                    tipo = "mãe";
                    repeat = false;
                    break;
                case 3:
                    tipo = "padreador";
                    repeat = false;
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    repeat = true;
            }
        }while (repeat);
        return tipo;
    }

    public static void menuAdcionaCachorro(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do cachorro:");
        String nome = scanner.nextLine();

        System.out.println("Informe o nome da Matriz (mãe):");
        String nomeMatriz  = scanner.nextLine();

        System.out.println("Informe o nome do Padreador (pai):");
        String nomePadreador  = scanner.nextLine();

        System.out.println("Informe o número do Pedigree :");
        String numeroPedigree  = scanner.nextLine();

        System.out.println("Informe o número do michrochip :");
        String numeroMicrochip  = scanner.nextLine();

        System.out.println("Informe o nome do Dono :");
        String nomeDono  = scanner.nextLine();
        String tipo = retornaTipo();
        System.out.println("Informe o nome do sexo: (macho, femea):");
        String sexo  = scanner.nextLine();

        Cachorro cachorro = new Cachorro(nome,nomeMatriz, nomePadreador, numeroPedigree, numeroMicrochip, nomeDono, tipo, sexo);
        CachorroDAO cachorroDAO = new CachorroDAO();
        cachorroDAO.adicionaCachorro(cachorro);
    }

    public static void menuDeletaCacahorro(Cachorro cachorro) throws SQLException {
        CachorroDAO cachorroDAO = new CachorroDAO();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        System.out.println("Tem certeza que deseja excluir o cachorro (1- Sim 2- Não): "+cachorro.getNome());
        escolha = scanner.nextInt();

        switch (escolha){
            case 1:
                cachorroDAO.deletaCarteiraVacinacao(cachorro);
                cachorroDAO.deletaPrescricaoAlimentacao(cachorro);
                cachorroDAO.deletaPrescricaoTratamento(cachorro);
                cachorroDAO.deletaPrescricaoReserva(cachorro);
                cachorroDAO.deletaCachorro(cachorro);
                break;
            case 2:
                System.out.println("Operação cancelada!");
                break;

        }
    }

    public static void menuUpdateCachorro(Cachorro cachorro) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do cachorro:");
        String nome = scanner.nextLine();
        cachorro.setNome(nome);

        System.out.println("Informe o nome da Matriz (mãe):");
        String nomeMatriz  = scanner.nextLine();
        cachorro.setNomeMae(nomeMatriz);

        System.out.println("Informe o nome do Padreador (pai):");
        String nomePadreador  = scanner.nextLine();
        cachorro.setNomePadreador(nomePadreador);

        System.out.println("Informe o número do Pedigree :");
        String numeroPedigree  = scanner.nextLine();
        cachorro.setNumeroPedigree(numeroPedigree);

        System.out.println("Informe o número do michrochip :");
        String numeroMicrochip  = scanner.nextLine();
        cachorro.setNumeroMicrochip(numeroMicrochip);

        System.out.println("Informe o nome do Dono :");
        String nomeDono  = scanner.nextLine();
        cachorro.setDono(nomeDono);

        String tipo = retornaTipo();
        cachorro.setTipo(tipo);

        System.out.println("Informe o nome do sexo: (macho, femea):");
        String sexo  = scanner.nextLine();
        cachorro.setSexo(sexo);

        CachorroDAO cachorroDAO = new CachorroDAO();
        cachorroDAO.editaCachorro(cachorro.getId(), cachorro);

    }


    public static void funcionalidadeEditarCachorro(List<Cachorro> listaCachorro) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do cachorro que deseja editar: ");
        int id = scanner.nextInt();
        for(Cachorro cachorro: listaCachorro){
            if(cachorro.getId() == id){
                ControllerCadastroCachorro.menuUpdateCachorro(cachorro);
            }
        }
    }

    public static void funcionalidadeDeletarCachorro(List<Cachorro> listaCachorro) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do cachorro que deseja editar: ");
        int id = scanner.nextInt();
        for(Cachorro cachorro: listaCachorro){
            if(cachorro.getId() == id){
                ControllerCadastroCachorro.menuDeletaCacahorro(cachorro);
            }
        }
    }


}
