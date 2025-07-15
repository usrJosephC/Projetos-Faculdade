def operacoes_basicas():
    try:
        num1 = float(input("Digite o primeiro número: "))
        num2 = float(input("Digite o segundo número: "))
        
        resultados = {
            "Soma": num1 + num2,
            "Subtração": num1 - num2,
            "Multiplicação": num1 * num2,
            "Divisão": num1 / num2 if num2 != 0 else "Indefinido"
        }
        
        for operacao, valor in resultados.items():
            print(f"{operacao}: {valor}")
            
    except ValueError:
        print("Erro: Insira apenas números!")
    except ZeroDivisionError:
        print("Erro: Divisão por zero não permitida!")

operacoes_basicas()
