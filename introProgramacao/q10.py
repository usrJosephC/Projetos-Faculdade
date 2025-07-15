def dia_da_semana():
    dia = int(input("Digite um número de 1 a 7: "))

    dias = ["Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"]
    if 1 <= dia <= 7:
        print(f"O dia da semana é: {dias[dia - 1]}")
    else:
        print("Número inválido.")

dia_da_semana()
