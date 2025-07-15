def calculo_fatorial():
    num = int(input("Digite um número para calcular o fatorial: "))
    fatorial = 1
    for i in range(1, num + 1):
        fatorial *= i
    print(f"{num}! = {fatorial}")

calculo_fatorial()