import random

def jogo_numero_secreto():
    numero_secreto = random.randint(1, 100)
    tentativas = 0
    while True:
        chute = int(input("Tente adivinhar o número (entre 1 e 100): "))
        tentativas += 1
        if chute < numero_secreto:
            print("Maior...")
        elif chute > numero_secreto:
            print("Menor...")
        else:
            print(f"Parabéns! Você acertou em {tentativas} tentativas.")
            break

jogo_numero_secreto()