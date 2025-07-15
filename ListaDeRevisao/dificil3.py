import re

def contar_frequencia_palavras(texto):
    
    texto = re.sub(r'[^\w\s]', '', texto).lower()
    palavras = texto.split()
    
    frequencia = {}
    for palavra in palavras:
        if palavra in frequencia:
            frequencia[palavra] += 1
        else:
            frequencia[palavra] = 1
    return frequencia

texto_exemplo = "Este é um exemplo de texto. Este texto será usado para contar as palavras."
frequencia_palavras = contar_frequencia_palavras(texto_exemplo)
print("Frequência das palavras:", frequencia_palavras)
