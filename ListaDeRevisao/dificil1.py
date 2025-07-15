def encontrar_primos(inicio, fim):
    
    primos = []
    for numero in range(inicio, fim + 1):
        if numero > 1:
            for i in range(2, int(numero**0.5) + 1):
                if (numero % i) == 0:
                    break
            else:
                primos.append(numero)
    return primos

inicio_intervalo = 2
fim_intervalo = 50
lista_de_primos = encontrar_primos(inicio_intervalo, fim_intervalo)
print(f"Números primos entre {inicio_intervalo} e {fim_intervalo}: {lista_de_primos}")
