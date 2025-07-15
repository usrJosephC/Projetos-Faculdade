import time

def contagem_regressiva():
    for i in range(10, -1, -1):
        print(i)
        
        time.sleep(1)
    
    print("Feliz Ano Novo!")

contagem_regressiva()