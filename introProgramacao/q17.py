def tabuada():
    num = int(input("Digite um número: "))
    for i in range(1, 11):
        print(f"{num} × {i} = {num * i}")

tabuada()