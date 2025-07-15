def multiplicacao_sucessiva():
    num1 = int(input("Digite o primeiro número: "))
    num2 = int(input("Digite o segundo número: "))
    resultado = 0
    for _ in range(abs(num2)):
        resultado += abs(num1)
    if (num1 < 0 and num2 < 0) or (num1 > 0 and num2 > 0):
        print(f"{num1} × {num2} = {resultado}")
    else:
        print(f"{num1} × {num2} = -{resultado}")

multiplicacao_sucessiva()