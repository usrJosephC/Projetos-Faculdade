import timeit

def verificarIngrediente(ingrediente, ingredienteProcurado):
    for ingrediente in ingredientes:
        if ingrediente == ingredienteProcurado:
            print("O ingrediente {ingredienteProcurado} foi encontrado!")
            return True
        print("O ingrediente {ingredienteProcurado} não foi encontrado!")
        return False
ingredientes = ["Mandrágora", "Asfódelo", "Bílis de Tatu","Pó de Besouro", "Acônito", "Olho de Tritão"]

tempoExecucao = timeit.timeit(lambda: verificarIngrediente(ingredientes, "Olho de Tritão"), number=1)
print(f"Tempo de execução: {tempoExecucao:.6f} segundos")