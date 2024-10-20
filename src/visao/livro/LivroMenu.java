package visao.livro;

import dominio.Livro;
import servico.LivroServico;
import util.MensagensErroSistema;
import util.MensagensSucessoSistema;
import util.Util;
import visao.generico.BaseMenu;

public class LivroMenu extends BaseMenu {

  private LivroServico livroServico;

  public LivroMenu() {
    super();

    livroServico = new LivroServico();
  }

  @Override
  public void ExibirMenu() {
    int opcao = 0;

    while (opcao != 9) {
      Util.ClearConsole();
      Util.MostrarOpcoesMenu();
      opcao = this.scanner.nextInt();
      switch (opcao) {
        case 1:
          this.Listar();
          break;
        case 2:
          this.Localizar();
          break;
        case 3:
          this.Adicionar();
          break;
        case 4:
          this.Atualizar();
          break;
        case 5:
          this.Remover();
          break;
        case 9:
          System.out.println("Saindo do sistema Biblioteca, até logo!");
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }
    }
  }
  
  @Override
  public void Listar() {
    Util.ClearConsole();
    System.out.println("Imprimindo todos os livros: ");
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    var livros = this.livroServico.Navegar();

    livros.forEach(System.out::println);

    Util.ConfirmarSaida(this.scanner);
  }

  @Override
  public void Localizar() {
    Util.ClearConsole();
    System.out.print("Informe o código do livro que deseja buscar: ");
    int codigo = this.scanner.nextInt();
    
    var livroBuscado = this.livroServico.Ler(codigo);

    if (livroBuscado == null) {
      System.out.println(MensagensErroSistema.CODIGO_NAO_EXISTE);
      Util.ConfirmarSaida(this.scanner);
      return;
    }

    System.out.println(MensagensSucessoSistema.SUCESSO_AO_BUSCAR);
    System.out.println(livroBuscado);
    Util.ConfirmarSaida(this.scanner);
  }

  @Override
  public void Adicionar() {
    Util.ClearConsole();
    Livro livroParaAdicionar = Util.ObterInformacoes(this.scanner);

    var livroAdicionado = this.livroServico.Adicionar(livroParaAdicionar);

    if (livroAdicionado == null) {
      System.out.println(MensagensErroSistema.ERRO_AO_ADICIONAR);
      Util.ConfirmarSaida(this.scanner);
      return;
    }

    System.out.println(MensagensSucessoSistema.SUCESSO_AO_ADICIONAR);
    System.out.println(livroAdicionado);
    Util.ConfirmarSaida(this.scanner);
  }

  @Override
  public void Atualizar() {
    Util.ClearConsole();
    System.out.print("Informe o código: ");
    int codigo = this.scanner.nextInt();

    Livro livroParaAtualizar = this.livroServico.Ler(codigo);

    if (livroParaAtualizar == null) {
      System.out.println(MensagensErroSistema.CODIGO_NAO_EXISTE);
      Util.ConfirmarSaida(this.scanner);
      return;
    }

    Livro novasInformacoesDoLivro = Util.ObterInformacoes(this.scanner);
    livroParaAtualizar.setTitulo(novasInformacoesDoLivro.getTitulo());
    livroParaAtualizar.setAutor(novasInformacoesDoLivro.getAutor());
    livroParaAtualizar.setIsbn(novasInformacoesDoLivro.getIsbn());
    livroParaAtualizar.setAnoPublicacao(novasInformacoesDoLivro.getAnoPublicacao());

    Livro livroAtualizado = this.livroServico.Editar(livroParaAtualizar);

    if (livroAtualizado == null) {
      System.out.println(MensagensErroSistema.ERRO_AO_ATUALIZAR);
      Util.ConfirmarSaida(this.scanner);
      return;
    }
    
    System.out.println(MensagensSucessoSistema.SUCESSO_AO_ATUALIZAR);
    System.out.println(livroAtualizado);
    Util.ConfirmarSaida(this.scanner);
  }

  @Override
  public void Remover() {
    Util.ClearConsole();
    System.out.print("Digite o código: ");
    int codigo = this.scanner.nextInt();

    Livro livroParaRemover = this.livroServico.Ler(codigo);

    if (livroParaRemover == null) {
      System.out.println(MensagensErroSistema.CODIGO_NAO_EXISTE);
      Util.ConfirmarSaida(this.scanner);
      return;
    }

    Livro livroRemovido = this.livroServico.Remover(codigo);

    if (livroRemovido == null) {
      System.out.println(MensagensErroSistema.ERRO_AO_REMOVER);
      return;
    }

    System.out.println(MensagensSucessoSistema.SUCESSO_AO_REMOVER);
    System.out.println(livroParaRemover);
    Util.ConfirmarSaida(this.scanner);
  }
}
