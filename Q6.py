# melhora a eficiência porque permite inserir, remover e buscar chamados por prioridade enquanto em uma lista linear a busca pelo chamado mais urgente pode exigir percorrer todos os elementos. 
class Chamado:
    def __init__(self, prioridade, descricao):
        self.prioridade = prioridade
        self.descricao = descricao

class NoAVL:
    def __init__(self, chamado):
        self.chamado = chamado
        self.esquerda = None
        self.direita = None
        self.altura = 1

class AVLChamados:
    def __init__(self):
        self.raiz = None

    def inserir(self, chamado):
        self.raiz = self._inserir(self.raiz, chamado)

    def _inserir(self, no, chamado):
        if not no:
            return NoAVL(chamado)
        if chamado.prioridade < no.chamado.prioridade:
            no.esquerda = self._inserir(no.esquerda, chamado)
        else:
            no.direita = self._inserir(no.direita, chamado)

        no.altura = 1 + max(self._altura(no.esquerda), self._altura(no.direita))
        balance = self._get_balance(no)

        if balance < -1 and chamado.prioridade >= no.direita.chamado.prioridade:
            return self._rotacao_esquerda(no)
        
        if balance > 1 and chamado.prioridade < no.esquerda.chamado.prioridade:
            return self._rotacao_direita(no)
        
        if balance > 1 and chamado.prioridade >= no.esquerda.chamado.prioridade:
            no.esquerda = self._rotacao_esquerda(no.esquerda)
            return self._rotacao_direita(no)
        
        if balance < -1 and chamado.prioridade < no.direita.chamado.prioridade:
            no.direita = self._rotacao_direita(no.direita)
            return self._rotacao_esquerda(no)

        return no

    def _altura(self, no):
        return no.altura if no else 0

    def _get_balance(self, no):
        return self._altura(no.esquerda) - self._altura(no.direita) if no else 0

    def _rotacao_direita(self, y):
        x = y.esquerda
        T2 = x.direita
        x.direita = y
        y.esquerda = T2
        y.altura = 1 + max(self._altura(y.esquerda), self._altura(y.direita))
        x.altura = 1 + max(self._altura(x.esquerda), self._altura(x.direita))
        return x

    def _rotacao_esquerda(self, x):
        y = x.direita
        T2 = y.esquerda
        y.esquerda = x
        x.direita = T2
        x.altura = 1 + max(self._altura(x.esquerda), self._altura(x.direita))
        y.altura = 1 + max(self._altura(y.esquerda), self._altura(y.direita))
        return y

    def buscar_mais_urgente(self):
        atual = self.raiz
        while atual and atual.esquerda:
            atual = atual.esquerda
        return atual.chamado if atual else None

# Exemplo de uso:
avl = AVLChamados()
avl.inserir(Chamado(5, "Trocar senha"))
avl.inserir(Chamado(2, "Servidor fora do ar"))
avl.inserir(Chamado(8, "Atualizar software"))

mais_urgente = avl.buscar_mais_urgente()
if mais_urgente:
    print(f"Chamado mais urgente: Prioridade {mais_urgente.prioridade} - {mais_urgente.descricao}")
else:
    print("Nenhum chamado encontrado.")