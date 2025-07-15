# 1. Saudação
def saudacao():
    nome = input("Digite seu nome: ")
    print(f"Olá, {nome}! Bem-vindo(a)!")

# 2. Soma de dois números
def soma():
    num1 = float(input("Digite o primeiro número: "))
    num2 = float(input("Digite o segundo número: "))
    resultado = num1 + num2
    print(f"A soma é: {resultado}")

# 3. Par ou Ímpar
def par_ou_impar():
    numero = int(input("Digite um número: "))
    if numero % 2 == 0:
        print("Par")
    else:
        print("Ímpar")

# 4. Fatorial
def fatorial():
    n = int(input("Digite um número inteiro positivo: "))
    if n < 0:
        print("Número inválido! Digite um valor positivo.")
    else:
        resultado = 1
        for i in range(1, n + 1):
            resultado *= i
        print(f"O fatorial de {n} é: {resultado}")

# 5. Contagem de vogais
def contar_vogais():
    texto = input("Digite uma palavra ou frase: ")
    vogais = "aeiouAEIOU"
    total = sum(1 for letra in texto if letra in vogais)
    print(f"Total de vogais: {total}")

# 6. Verificação de primo
def eh_primo():
    numero = int(input("Digite um número: "))
    if numero <= 1:
        print(False)
    else:
        primo = True
        for i in range(2, int(numero ** 0.5) + 1):
            if numero % i == 0:
                primo = False
                break
        print(primo)

# 7. Inversão de string
def inverter_string():
    texto = input("Digite uma palavra ou frase: ")
    invertido = texto[::-1]
    print(f"String invertida: {invertido}")

# 8. Média de uma lista
def media_lista():
    entrada = input("Digite números separados por vírgula (ex: 1, 2, 3): ")
    lista = [float(x.strip()) for x in entrada.split(",")]
    media = sum(lista) / len(lista)
    print(f"Média: {media:.2f}")

# 9. MDC
def mdc():
    a = int(input("Digite o primeiro número: "))
    b = int(input("Digite o segundo número: "))
    while b:
        a, b = b, a % b
    print(f"MDC: {a}")

# 10. Fibonacci
def fibonacci():
    n = int(input("Quantos termos da sequência de Fibonacci você quer? "))
    a, b = 0, 1
    sequencia = []
    for _ in range(n):
        sequencia.append(a)
        a, b = b, a + b
    print(f"Sequência: {sequencia}")

def menu():
    print("\nEscolha uma função para executar:")
    print("1 - Saudação")
    print("2 - Soma de dois números")
    print("3 - Par ou Ímpar")
    print("4 - Fatorial")
    print("5 - Contar vogais")
    print("6 - Verificar número primo")
    print("7 - Inverter string")
    print("8 - Média de uma lista")
    print("9 - MDC")
    print("10 - Sequência de Fibonacci")
    print("0 - Sair")

    opcao = input("Digite o número da função: ")
    
    if opcao == "1":
        saudacao()
    elif opcao == "2":
        soma()
    elif opcao == "3":
        par_ou_impar()
    elif opcao == "4":
        fatorial()
    elif opcao == "5":
        contar_vogais()
    elif opcao == "6":
        eh_primo()
    elif opcao == "7":
        inverter_string()
    elif opcao == "8":
        media_lista()
    elif opcao == "9":
        mdc()
    elif opcao == "10":
        fibonacci()
    elif opcao == "0":
        print("Saindo...")
        return
    else:
        print("Opção inválida! Tente novamente.")
    
    menu()

menu()