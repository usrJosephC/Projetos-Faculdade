def verificacao_triangulo():
    lado1 = float(input("Digite o primeiro lado: "))
    lado2 = float(input("Digite o segundo lado: "))
    lado3 = float(input("Digite o terceiro lado: "))

    if lado1 + lado2 > lado3 and lado1 + lado3 > lado2 and lado2 + lado3 > lado1:
        if lado1 == lado2 == lado3:
            print("O triângulo é equilátero.")
        elif lado1 == lado2 or lado1 == lado3 or lado2 == lado3:
            print("O triângulo é isósceles.")
        else:
            print("O triângulo é escaleno.")
    else:
        print("Os lados não formam um triângulo.")

verificacao_triangulo()
