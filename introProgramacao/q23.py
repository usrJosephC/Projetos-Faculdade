def registro_convidados():
    convidados = []
    while True:
        nome = input("Digite o nome do convidado (FIM para parar): ")
        if nome.upper() == "FIM":
            break
        convidados.append(nome)
    print("Convidados:", convidados)

registro_convidados()