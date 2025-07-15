def validacao_entrada():
    while True:
        num = int(input("Digite um número entre 1 e 10: "))
        if 1 <= num <= 10:
            print(f"Você digitou: {num}")
            break
        else:
            print("Número inválido. Tente novamente.")

validacao_entrada()