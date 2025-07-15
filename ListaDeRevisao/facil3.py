def contarVogais(texto):
  vogais = "aeiouAEIOU"
  contador = 0
  for char in texto:
    if char in vogais:
      contador += 1
  return contador


string = input("Digite uma palavra: ")
numeroDeVogais = contarVogais(string)
print(f"A string '{string}' tem {numeroDeVogais} vogais.")
