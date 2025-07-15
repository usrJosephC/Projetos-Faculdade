#ESTRUTURA DE REPETIÇÃO FOR/WHILE
print("Bem vindo ao primeiro contato com Python")
'''
for variavel in range(20):
    print(variavel) #print(variavel+1) para imprimir de 1 a 5

contador = 0
while contador < 20:
    print(contador) #print(contador+1) para imprimir de 1 a 5
    contador += 
'''

for num in range(20):
    if num % 2 != 0:
        print(f"{num} é ímpar")
    elif num == 0:
        print(f"{num} é neutro")
    else:
        print(f"{num} é par")