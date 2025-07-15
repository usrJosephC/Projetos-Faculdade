import timeit

def merge_sort(lista):
    if len(lista) <= 1:
        return lista
    meio = len(lista) // 2
    esquerda= merge_sort(lista[:meio])
    direita = merge_sort(lista[meio:])
    return mesclar(esquerda, direita)

def mesclar(esquerda, direita):
    resultado = []
    i = j = 0
    while i < len(esquerda) and j < len(direita):
      if esquerda[i] < direita[j]:
          resultado.append(esquerda[i])
          i += 1
      else:
          resultado.append(direita[j])
          j += 1
    resultado.extend(esquerda[i:])
    resultado.extend(direita[j:])
    return resultado

def buscaBinaria(ingredientes, ingredienteProcurado):
    inicio = 0
    fim = len(ingredientes) - 1
    while inicio <= fim:
        meio = (inicio + fim) // 2
        if ingredientes[meio] == ingredienteProcurado:
            print(f"O ingrediente {ingredienteProcurado} foi encontrado!")
            return True
        elif ingredientes[meio] < ingredienteProcurado:
            inicio = meio + 1
        else:
            fim = meio - 1
    print(f"O ingrediente {ingredienteProcurado} não foi encontrado!")
    return False

ingredientes = ["Mandrágora", "Asfódelo", "Sanguinária", "Salamandra", "Olho de cobra", "Bílis de Tatu","Pó de Besouro", "Acônito", "Olho de Tritão"]

ingredientesOrdenados = merge_sort(ingredientes)
print("Ingredientes ordenados:", ingredientesOrdenados)

tempoExecucao = timeit.timeit(lambda: buscaBinaria(ingredientesOrdenados, "Olho de Tritão"), number=1)
print(f"Tempo de execução: {tempoExecucao:.6f} segundos")