#É vantajoso porque permite localizar, inserir e remover produtos de forma eficiente, em uma lista não ordenada, a busca é necessário percorrer todos os elementos até encontrar o produto desejado
class Produto:
    def __init__(self, codigo, nome, quantidade):
        self.codigo = codigo
        self.nome = nome
        self.quantidade = quantidade

class NoABB:
    def __init__(self, produto):
        self.produto = produto
        self.esquerda = None
        self.direita = None

class EstoqueABB:
    def __init__(self):
        self.raiz = None

    def inserir(self, produto):
        self.raiz = self._inserir(self.raiz, produto)

    def _inserir(self, no, produto):
        if no is None:
            return NoABB(produto)
        if produto.codigo < no.produto.codigo:
            no.esquerda = self._inserir(no.esquerda, produto)
        elif produto.codigo > no.produto.codigo:
            no.direita = self._inserir(no.direita, produto)
        else:
            no.produto.quantidade = produto.quantidade
        return no

    def buscar(self, codigo):
        return self._buscar(self.raiz, codigo)

    def _buscar(self, no, codigo):
        if no is None:
            return None
        if codigo == no.produto.codigo:
            return no.produto
        elif codigo < no.produto.codigo:
            return self._buscar(no.esquerda, codigo)
        else:
            return self._buscar(no.direita, codigo)

# Exemplo de uso:
estoque = EstoqueABB()
estoque.inserir(Produto(1001, "Mouse", 50))
estoque.inserir(Produto(1002, "Teclado", 30))
estoque.inserir(Produto(1003, "Monitor", 20))

produto = estoque.buscar(1002)
if produto:
    print(f"Produto: {produto.nome} \nQuantidade: {produto.quantidade}")
else:
    print("Produto não encontrado.")