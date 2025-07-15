import random

def simulador_corrida():
    distancia = 0
    passos = 0
    while distancia < 100:
        metros = random.randint(1, 5)
        distancia += metros
        passos += 1
        print(f"Passo {passos}: {metros} metros. Total: {distancia} metros")
    print(f"Corrida concluída em {passos} passos.")

simulador_corrida()