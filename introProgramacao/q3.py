def conversor_moeda():
    taxa_cambio = 5.50

    valor_reais = float(input("Digite o valor em reais: "))

    valor_dolares = valor_reais / taxa_cambio

    print(f"{valor_reais} reais equivalem a {valor_dolares:.2f} dólares")

conversor_moeda()
