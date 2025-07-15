def is_palindrome_input():

  frase = input("Digite uma frase: ")

  frase = frase.lower().replace(" ", "")

  if frase == frase[::-1]:
    print("É um palíndromo!")
  else:
    print("Não é um palíndromo.")

is_palindrome_input()
