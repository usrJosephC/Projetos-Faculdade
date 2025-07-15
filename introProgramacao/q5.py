def calculo_gorjeta():
    valor_conta = float(input("Digite o valor da conta: "))

    gorjeta = (10 / 100) * valor_conta

    total_pagar = valor_conta + gorjeta

    print(f"O valor da gorjeta é: R${gorjeta:.2f}")
    print(f"O total a pagar é: R${total_pagar:.2f}")

calculo_gorjeta()
