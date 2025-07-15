def fibonacci(n):
    
    lista_fibonacci = []
    a, b = 0, 1
    for _ in range(n):
        lista_fibonacci.append(a)
        a, b = b, a + b
    return lista_fibonacci

numero_de_termos = 10
sequencia_fibonacci = fibonacci(numero_de_termos)
print(f"Os primeiros {numero_de_termos} números da sequência de Fibonacci: {sequencia_fibonacci}")
