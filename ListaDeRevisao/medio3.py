def ordenarListaCrescente(lista):
  
  if not isinstance(lista, list):
    print("Erro: A entrada deve ser uma lista.")
    return []

  for elemento in lista:
    if not isinstance(elemento, (int, float)):
      print("Erro: A lista deve conter apenas números.")
      return None

  n = len(lista)
  novaLista = lista[:]

  for i in range(n):
    for j in range(0, n - i - 1):
      if novaLista[j] > novaLista[j + 1]:
        novaLista[j], novaLista[j + 1] = novaLista[j + 1], novaLista[j]

  return novaLista

lista1 = [5, 2, 8, 1, 9, 4]
listaOrdenada1 = ordenarListaCrescente(lista1)
print(f"Lista original: {lista1}")
print(f"Lista ordenada: {listaOrdenada1}")

lista2 = [3.14, 1.618, 2.718]
listaOrdenada2 = ordenarListaCrescente(lista2)
print(f"Lista original: {lista2}")
print(f"Lista ordenada: {listaOrdenada2}")

listaErro1 = "isso não é uma lista"
listaOrdenadaErro1 = ordenarListaCrescente(listaErro1)
print(f"Lista original: {listaErro1}")
print(f"Lista ordenada: {listaOrdenadaErro1}")

listaErro2 = [1, 2, "a", 4]
listaOrdenadaErro2 = ordenarListaCrescente(listaErro2)
print(f"Lista original: {listaErro2}")
print(f"Lista ordenada: {listaOrdenadaErro2}")