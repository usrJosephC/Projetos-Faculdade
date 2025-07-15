def registrar_convidados():
    convidados = []
    
    print("Digite os nomes dos convidados (ou 'FIM' para finalizar):")
    
    while True:
        nome = input("Nome do convidado: ")
        
        if nome.upper() == "FIM":
            break
        
        convidados.append(nome)
    
    if convidados:
        print("\nLista de convidados:")
        for i, convidado in enumerate(convidados, start=1):
            print(f"{i}. {convidado}")
    else:
        print("\nNenhum convidado registrado.")

registrar_convidados()