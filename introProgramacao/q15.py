def balanco_financeiro():
    receitas = float(input("Digite o valor das receitas: "))
    despesas = float(input("Digite o valor das despesas: "))

    if receitas > despesas:
        print("Lucro.")
    elif receitas < despesas:
        print("Prejuízo.")
    else:
        print("Equilibrado.")

balanco_financeiro()
