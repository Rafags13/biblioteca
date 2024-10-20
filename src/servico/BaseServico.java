package servico;

import java.util.ArrayList;

public abstract class BaseServico<TDominio> {
  public abstract ArrayList<TDominio> Navegar();
  public abstract TDominio Ler(int chave);
  public abstract TDominio Editar(TDominio entidade);
  public abstract TDominio Adicionar(TDominio entidade);
  public abstract TDominio Remover(int chave);
}
