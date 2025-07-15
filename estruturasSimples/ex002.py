#ESTRUTURA DE DEFINIÇÃO DE FUNÇÕES

'''
def somar(a, b):
    return a + b

#chamar a função somar
x = somar(10, 20)
print(f"A soma de 10 + 20 é igual a {x}")
'''

def IMC(peso, altura):
    imc = peso / (altura ** 2)
    
    if imc < 18.5:
        return print(f"Seu IMC é {imc:.2f}, você está abaixo do peso.")
    elif imc >= 18.5 and imc < 24.9:
        return print(f"Seu IMC é {imc:.2f}, você está com o peso normal.")
    elif imc >= 25 and imc < 29.9:
        return print(f"Seu IMC é {imc:.2f}, você está com sobrepeso.")
    elif imc >= 30 and imc < 34.9:
        return print(f"Seu IMC é {imc:.2f}, você está com obesidade grau 1.")
    elif imc >= 35 and imc < 39.9:
        return print(f"Seu IMC é {imc:.2f}, você está com obesidade grau 2.")
    else:
        return print(f"Seu IMC é {imc:.2f}, você está com obesidade grau 3.")
    
peso = float(input("Digite seu peso: "))
altura = float(input("Digite sua altura: "))
IMC(peso, altura)