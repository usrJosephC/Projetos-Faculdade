#ESTRUTURA DE CONDIÇÃO IF/ELSE

print("Bem vindo ao primeiro contato com Python")

num1 = float(input("Digite o primeiro número: "))
num2 = float(input("Digite o primeiro número: "))

media = (num1 + num2) / 2

if media >= 0 and media < 5:
    print(f"Sua nota é {media}, você está reprovado!")
elif media >= 5 and media < 7:
    print(f"Sua nota é {media}, você está de recuperação!")
elif media >= 7 and media <= 10:
    print(f"Sua nota é {media}, você está aprovado!")
else:
    print("ERROR! Nota inválida!")