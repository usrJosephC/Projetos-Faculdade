class No:
  def __init__(self, valor):
    self.proximo = None

  def mostra_no(self):
    #método para exibir
    print(self.valor)

  class ListaEncadeadaExtremidadeDupla:
    def __init__(self):
      self.primeiro = None #referêncial inicial do nó
      self.ultimo = None #referência final do nó

    def __lista_vazia(self):
      #referência de lista vazia
      return self.primeiro == None
    
    def insere_inicio(self, valor):
      novo = No(valor)
      if self.__lista_vazia():
        self.ultimo = novo
        #o novo nó irá apontar ao nó atualmente (primeiro)
      novo.proximo = self.primeiro
      self.primeiro = novo

    def insere_final(self, valor):
      novo = No(valor)
      if self.__lista_vazia():
        self.primeiro = novo
      else:
        self.ultimo.proximo = novo
      self.ultimo = novo

    def excluir_inicio(self):
      #remover o (nó) do início da lista
      if self.__lista_vazia():
        print("A lista está vazia")
        return
      
      temp = self.primeiro
      if self.primeiro.proximo == None:
        #último elemento = "NONE"
        self.ultimo = None
      self.primeiro = self.primeiro.proximo
      return temp #retornar o nó removido
    
    def mostar(self):
      #exibir TODOS os nós da lista
      if self.__lista_vazia():
        print("A lista está vazia.")
        return
      atual = self.primeiro #começa com o primeiro nó
      while atual != None:
        atual.mostra_no()
        atual = atual.proximo