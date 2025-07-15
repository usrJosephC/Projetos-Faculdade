def contar_passos():
    while True:
        try:
            total_passos = int(input("Digite a quantidade total de passos que deseja dar: "))
            if total_passos <= 0:
                print("Por favor, digite um número positivo.")
            else:
                break
        except ValueError:
            print("Por favor, digite um número inteiro.")
    
    print("\nIniciando a contagem de passos...")
    for i in range(1, total_passos + 1):
        print(f"Passo {i}")
        import time
        time.sleep(0.5)
    
    print("\nVocê alcançou o seu objetivo!")

contar_passos()