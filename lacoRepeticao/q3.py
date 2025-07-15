def exibir_tabuada():
    while True:
        try:
            numero = int(input("Digite um número para ver sua tabuada: "))
            break
        except ValueError:
            print("Por favor, digite um número inteiro.")
    
    print(f"\nTabuada do {numero}:")
    for i in range(1, 11):
        print(f"{numero} x {i} = {numero * i}")

exibir_tabuada()