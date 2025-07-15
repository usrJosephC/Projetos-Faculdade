def simulacao_caixa_eletronico():
    valor = int(input("Digite o valor a ser sacado: "))
    cedulas = [100, 50, 20, 10, 5]
    for cedula in cedulas:
        quantidade = valor // cedula
        valor %= cedula
        if quantidade > 0:
            print(f"{quantidade} cédulas de R${cedula}")

simulacao_caixa_eletronico()