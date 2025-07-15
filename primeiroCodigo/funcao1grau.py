def funcao_linear():
    try:
        a = float(input("Coeficiente angular (a): "))
        b = float(input("Coeficiente linear (b): "))
        x = float(input("Valor de x: "))
        
        resultado = a * x + b
        print(f"f({x}) = {a}*{x} + {b} = {resultado}")
        
    except ValueError:
        print("Erro: Entrada inválida!")

funcao_linear()
