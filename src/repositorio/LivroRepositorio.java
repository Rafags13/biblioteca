package repositorio;

import dominio.Livro;
import fakedb.LivroFakeDB;

public class LivroRepositorio extends BaseRepositorio<Livro> {

  private LivroFakeDB database;

  public LivroRepositorio() {
    this.database = new LivroFakeDB();
    this.dados = this.database.getTabela();
  }

  @Override
  public Livro Read(int chave) {
    for (Livro livro : dados) {
      if (livro.getCodigo() == chave)
        return livro;
    }

    return null;
  }

  @Override
  public Livro Edit(Livro instancia) {
    Livro livroEncontrado = this.Read(instancia.getCodigo());

    if (livroEncontrado == null)
      return null;

    livroEncontrado.setTitulo(instancia.getTitulo());
    livroEncontrado.setAutor(instancia.getAutor());
    livroEncontrado.setAnoPublicacao(instancia.getAnoPublicacao());
    livroEncontrado.setIsbn(instancia.getIsbn());

    return livroEncontrado;
  }

  @Override
  public Livro Add(Livro instancia) {
    Livro ultimoLivro = this.dados.get(this.dados.size() - 1);
    int proximaChave = ultimoLivro.getCodigo() + 1;

    instancia.setCodigo(proximaChave);

    this.dados.add(instancia);

    return instancia;
  }

  @Override
  public Livro Delete(int chave) {
    Livro livroParaRemover = this.Read(chave);

    if (livroParaRemover == null)
      return null;

    this.dados.remove(livroParaRemover);
    return livroParaRemover;
  }
  
}
