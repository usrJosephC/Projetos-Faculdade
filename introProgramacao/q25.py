import random

def jogo_adivinhacao_limitado():
    numero_secreto = random.randint(1, 50)
    tentativas = 5
    while tentativas > 0:
        chute = int(input(f"Tente adivinhar o número (entre 1 e 50). Restam {tentativas} tentativas: "))
        tentativas -= 1
        if chute < numero_secreto:
            print("Maior...")
        elif chute > numero_secreto:
            print("Menor...")
        else:
            print("Parabéns! Você acertou.")
            return
    print(f"Game over! O número era {numero_secreto}.")

jogo_adivinhacao_limitado()