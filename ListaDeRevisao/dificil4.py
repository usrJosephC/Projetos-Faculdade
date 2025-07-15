def merge_sort(lista):
    
    if len(lista) <= 1:
        return lista

    meio = len(lista) // 2
    lado_esquerdo = lista[:meio]
    lado_direito = lista[meio:]

    lado_esquerdo = merge_sort(lado_esquerdo)
    lado_direito = merge_sort(lado_direito)

    return merge(lado_esquerdo, lado_direito)

def merge(lado_esquerdo, lado_direito):
    
    resultado = []
    i, j = 0, 0
    while i < len(lado_esquerdo) and j < len(lado_direito):
        if lado_esquerdo[i] <= lado_direito[j]:
            resultado.append(lado_esquerdo[i])
            i += 1
        else:
            resultado.append(lado_direito[j])
            j += 1

    resultado += lado_esquerdo[i:]
    resultado += lado_direito[j:]
    return resultado

lista_para_ordenar = [38, 27, 43, 3, 9, 82, 10]
lista_ordenada = merge_sort(lista_para_ordenar)
print("Lista ordenada:", lista_ordenada)
