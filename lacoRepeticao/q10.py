import random

def simular_corrida_bicicleta():
    distancia_percorrida = 0
    giros_de_pedal = 0
    
    print("Iniciando a corrida de bicicleta...")
    
    while distancia_percorrida < 100:
        distancia_giro = random.randint(1, 5)
        distancia_percorrida += distancia_giro
        giros_de_pedal += 1
        
        print(f"Giro {giros_de_pedal}: Percorreu {distancia_giro} metros. Total: {distancia_percorrida} metros")
        
    
    print(f"\nVocê completou a corrida em {giros_de_pedal} giros de pedal!")

    

simular_corrida_bicicleta()