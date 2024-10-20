package util;

import java.util.Scanner;

import dominio.Livro;

public class Util {
  public static void ClearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  
  public static void MostrarOpcoesMenu() {
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    System.out.println("Escolha uma opção: ");
    System.out.println("1- Listar todos os livros");
    System.out.println("2- Buscar um livro pelo código");
    System.out.println("3- Adicionar um novo livro");
    System.out.println("4- Atualizar as informações de um livro");
    System.out.println("5- Remover um livro pelo seu código");
    System.out.println("9- Sair");
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    System.out.print("> ");
  }

  public static Livro ObterInformacoes(Scanner scanner) {
    Livro livro = new Livro();
    System.out.print("Informe o Título: ");
    // Previne que o buffer não bugue.
    scanner.nextLine();
    livro.setTitulo(scanner.nextLine());

    System.out.print("Informe o Autor: ");
    livro.setAutor(scanner.nextLine());

    System.out.print("Informe o ISBN: ");
    livro.setIsbn(scanner.nextLine());

    System.out.print("Informe o Ano de Publicação: ");
    livro.setAnoPublicacao(scanner.nextInt());

    return livro;
  }
  
  public static void ConfirmarSaida(Scanner scanner) {
    System.out.println("Clique <ENTER> para continuar...");
    scanner.nextLine();
    scanner.nextLine();
  }
}
