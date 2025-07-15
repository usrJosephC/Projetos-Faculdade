import random

def adivinhar_numero_secreto():
    numero_secreto = random.randint(1, 100)
    
    tentativas = 0
    
    print("Tente adivinhar um número entre 1 e 100.")
    
    while True:
        while True:
            try:
                palpite = int(input("Digite seu palpite: "))
                if palpite < 1 or palpite > 100:
                    print("Por favor, digite um número entre 1 e 100.")
                else:
                    break
            except ValueError:
                print("Por favor, digite um número.")
        
        tentativas += 1
        
        if palpite == numero_secreto:
            print(f"\nParabéns! Você acertou o número secreto em {tentativas} tentativas.")
            break
        elif palpite < numero_secreto:
            print("Seu palpite é menor que o número secreto. Tente novamente!")
        else:
            print("Seu palpite é maior que o número secreto. Tente novamente!")

adivinhar_numero_secreto()