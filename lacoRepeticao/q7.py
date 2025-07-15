import time

def contagem_regressiva_dias():
    while True:
        try:
            dias = int(input("Digite a quantidade de dias até o evento: "))
            if dias < 0:
                print("Por favor, digite um número não negativo.")
            else:
                break
        except ValueError:
            print("Por favor, digite um número.")
    
    print("\nIniciando a contagem regressiva...")
    for i in range(dias, -1, -1):
        if i > 0:
            print(f"Faltam {i} dias para o evento.")
        else:
            print("O evento é hoje! ")
        
        time.sleep(1)

contagem_regressiva_dias()