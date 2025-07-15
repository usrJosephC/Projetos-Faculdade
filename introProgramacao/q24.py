def controle_estoque():
    estoque = 0
    while True:
        caixas = int(input("Digite a quantidade de caixas recebidas (número negativo para parar): "))
        if caixas < 0:
            break
        estoque += caixas
        print(f"Estoque atual: {estoque} caixas")

controle_estoque()