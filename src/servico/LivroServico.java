package servico;

import java.util.ArrayList;

import dominio.Livro;
import repositorio.LivroRepositorio;

public class LivroServico extends BaseServico<Livro> {

  private LivroRepositorio livroRepositorio;

  public LivroServico() {
    this.livroRepositorio = new LivroRepositorio();
  }

  @Override
  public ArrayList<Livro> Navegar() {
    return livroRepositorio.Browse();
  }

  @Override
  public Livro Ler(int chave) {
    return livroRepositorio.Read(chave);
  }

  @Override
  public Livro Editar(Livro entidade) {
    return livroRepositorio.Edit(entidade);
  }

  @Override
  public Livro Adicionar(Livro entidade) {
    return livroRepositorio.Add(entidade);
  }

  @Override
  public Livro Remover(int chave) {
    return livroRepositorio.Delete(chave);
  }
}
