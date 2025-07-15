def parOuImpar(numero):
  if numero % 2 == 0:
    return "Par"
  else:
    return "Ímpar"

numero1 = int(input("Digite um número: "))
numero2 = int(input("Digite outro número: "))

resultado1 = parOuImpar(numero1)
resultado2 = parOuImpar(numero2)

print(f"{numero1} é {resultado1}")
print(f"{numero2} é {resultado2}")
