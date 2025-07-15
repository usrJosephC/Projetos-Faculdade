def calculo_passagem_onibus():
    idade = int(input("Digite sua idade: "))

    if idade < 5 or idade > 65:
        print("Você não paga passagem.")
    else:
        print("O valor da passagem é: R$4,50")

calculo_passagem_onibus()
