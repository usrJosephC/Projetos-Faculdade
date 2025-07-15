def somar_compras():
    total = 0  
    
    while True:
        preco = input("Digite o preço do produto (ou 0 para finalizar): ")
        
        try:
            preco = float(preco)
        except ValueError:
            print("Por favor, digite um número.")
            continue
        
        if preco == 0:
            break
        
        total += preco
        
        print(f"Total atual: R${total:.2f}")
    
    print(f"\nTotal final da compra: R${total:.2f}")

somar_compras()