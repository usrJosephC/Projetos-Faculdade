def controlar_estoque():
    estoque = 0
    
    print("Digite a quantidade de caixas recebidas a cada dia (ou um número negativo para encerrar):")
    
    while True:
        while True:
            try:
                caixas = int(input("Quantidade de caixas recebidas hoje: "))
                break
            except ValueError:
                print("Por favor, digite um número.")
        
        if caixas < 0:
            break
        
        estoque += caixas
        print(f"Estoque atual: {estoque} caixas")
    
    print(f"\nTotal de caixas no estoque: {estoque} caixas")

controlar_estoque()