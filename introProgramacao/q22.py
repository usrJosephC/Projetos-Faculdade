def contagem_dias_evento():
    dias = int(input("Digite a quantidade de dias até o evento: "))
    for i in range(dias, -1, -1):
        print(f"Faltam {i} dias.")

contagem_dias_evento()