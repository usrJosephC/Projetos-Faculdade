class No:
    def __init__(self, valor):
        self.valor = valor
        self.filhos = []

class ArvoreNaria:
    def __init__(self, raiz=None):
        self.raiz = raiz
    
    def percurso_pre_ordem(self, no=None):
        if no is None:
            no = self.raiz
        if no is None:
            return
        
        print(no.valor)

        for filho in no.filhos:
            self.percurso_pre_ordem(filho)

    def somar_valores(no):
        if no is None:
            return 0
        
        soma = no.valor
        for filho in no.filhos:
            soma += ArvoreNaria.somar_valores(filho)
        return soma
    
    def contar_nos(no):
        if no is None:
            return 0
        total = 1 # Conta o nó atual
        for filho in no.filhos:
            total += ArvoreNaria.contar_nos(filho)
        return total
    
    def altura(no):
        if no is None or not no.filhos:
            return 0
        altura_filhos = [ArvoreNaria.altura(filho) for filho in no.filhos]
        return 1 + max(altura_filhos)

# Criando os nós
raiz = No(10)
filho1 = No(2)
filho2 = No(3)
filho3 = No(4)
filho4 = No(5)
filho5 = No(6)

# Conectando os nós
raiz.filhos.append(filho1)
raiz.filhos.append(filho2)
filho1.filhos.append(filho3)
filho1.filhos.append(filho4)
filho2.filhos.append(filho5)

# Criando a árvore
arvore = ArvoreNaria(raiz)

# Testando
print("Percurso em pré-ordem:")
arvore.percurso_pre_ordem()

print("\nSoma dos valores na árvore:")
print(ArvoreNaria.somar_valores(arvore.raiz))

print("\nContagem de nós na árvore:")
print(ArvoreNaria.contar_nos(arvore.raiz))

print("\nAltura da árvore:")
print(ArvoreNaria.altura(arvore.raiz))
