package fakedb;

import java.util.ArrayList;

import dominio.Livro;

public class LivroFakeDB extends BaseFakeDB<Livro> {
  @Override
  protected void preencherDados() {
    this.tabela = new ArrayList<Livro>();

    this.tabela.add(new Livro(1, "Estado de exceção", "Giorgio Agamben", "978-8575590577", 2004));
    this.tabela.add(new Livro(2, "Como Ler Livros", "Mortimer Adler", "978-8588062894", 2010));
    this.tabela.add(new Livro(3, "Admirável mundo novo", "Aldous Huxley", "978-8525056009", 2014));
    this.tabela.add(new Livro(4, "O homem e seus símbolos", "Carl Jung", "978-8569809630", 2016));
    this.tabela.add(new Livro(5, "Fedro", "Platão", "978-8582850251", 2016));
  }

  public LivroFakeDB() {
    super();
  }
  
}
