import math

def quadratica():
    try:
        a = float(input("Coeficiente a: "))
        b = float(input("Coeficiente b: "))
        c = float(input("Coeficiente c: "))
        
        delta = b**2 - 4*a*c
        
        if delta < 0:
            print("Não existem raízes reais")
        else:
            x1 = (-b + math.sqrt(delta)) / (2*a)
            x2 = (-b - math.sqrt(delta)) / (2*a)
            print(f"Raízes: x' = {x1:.2f}, x'' = {x2:.2f}")
            
    except ValueError:
        print("Erro: Valores inválidos!")
    except ZeroDivisionError:
        print("Erro: Coeficiente 'a' não pode ser zero!")

quadratica()
