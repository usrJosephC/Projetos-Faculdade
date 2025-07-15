def calculo_desconto():
    
    preco_original = 100.00

    
    desconto_percentual = float(input("Digite o percentual de desconto (%): "))

    
    desconto_valor = (desconto_percentual / 100) * preco_original

    
    preco_final = preco_original - desconto_valor

    
    print(f"O valor do desconto é: R${desconto_valor:.2f}")
    print(f"O preço final do produto é: R${preco_final:.2f}")

calculo_desconto()
