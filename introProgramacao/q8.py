def classificacao_idade():
    idade = int(input("Digite sua idade: "))

    if idade <= 12:
        print("Você é uma criança.")
    elif idade <= 17:
        print("Você é um adolescente.")
    else:
        print("Você é um adulto.")

classificacao_idade()
