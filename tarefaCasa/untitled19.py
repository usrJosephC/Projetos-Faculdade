def calcular_media(notas):
    """Recebe uma lista de notas e retorna a média aritmética.
    Se a lista estiver vazia, retorna 0 para evitar divisão por zero."""
    return sum(notas) / len(notas) if notas else 0

def cadastrar_alunos():
    """Permite cadastrar múltiplos alunos, com suas respectivas disciplinas e notas.
    Retorna uma lista com tuplas no formato: (nome_do_aluno, [(disciplina, nota), ...])"""
    
    alunos = []  # Lista principal que armazenará todos os alunos

    while True:
        nome = input("Nome do aluno (ou 'sair' para encerrar): ")
        if nome.lower() == 'sair':
            break  # Encerra o cadastro se o usuário digitar 'sair'

        disciplinas = []  # Lista temporária para armazenar as disciplinas e notas do aluno
        while True:
            disciplina = input("Nome da disciplina (ou 'pronto' para encerrar): ")
            if disciplina.lower() == 'pronto':
                break  # Encerra o cadastro de disciplinas para este aluno

            try:
                nota = float(input(f"Nota de {disciplina}: "))  # Converte a nota para número decimal
                disciplinas.append((disciplina, nota))  # Adiciona tupla (disciplina, nota)
            except ValueError:
                print("Nota inválida. Por favor, insira um número.")  # Validação de entrada

        alunos.append((nome, disciplinas))  # Adiciona o aluno com sua lista de disciplinas

    return alunos

def criar_dicionario_alunos(alunos):
    """Transforma a lista de alunos em um dicionário.
    Cada aluno será representado por um dicionário com suas disciplinas, notas e média."""
    
    alunos_dict = {
        nome: {
            'disciplinas': {disciplina: nota for disciplina, nota in disciplinas},  # Dict de matérias e notas
            'notas': [nota for _, nota in disciplinas],  # Lista de notas isoladas
            'media': calcular_media([nota for _, nota in disciplinas])  # Média das notas
        }
        for nome, disciplinas in alunos  # Itera sobre a lista de alunos
    }

    return alunos_dict

def exibir_alunos_por_media(alunos_dict, media_minima):
    """Filtra e mostra apenas os alunos com média maior ou igual à média mínima informada."""

    alunos_filtrados = [
        (nome, dados['media'])  # Lista de tuplas (nome, média)
        for nome, dados in alunos_dict.items()
        if dados['media'] >= media_minima
    ]

    if alunos_filtrados:
        print(f"\nAlunos com média acima de {media_minima}:")
        for nome, media in alunos_filtrados:
            print(f"- {nome}: {media:.2f}")
    else:
        print(f"\nNenhum aluno com média acima de {media_minima}.")

def ordenar_alunos_por_media(alunos_dict):
    """Ordena os alunos por média, do maior para o menor, e exibe o ranking."""

    alunos_ordenados = sorted(
        [(nome, dados['media']) for nome, dados in alunos_dict.items()],  # Lista de (nome, média)
        key=lambda x: x[1],  # Ordena pela média (índice 1 da tupla)
        reverse=True  # Ordem decrescente (maior para menor)
    )

    print("\nAlunos ordenados por média (maior para menor):")
    for i, (nome, media) in enumerate(alunos_ordenados, 1):  # Mostra com numeração
        print(f"{i}. {nome}: {media:.2f}")

    return alunos_ordenados

def main():
    # Para uso real: descomente a linha abaixo para permitir entrada manual
    # alunos = cadastrar_alunos()

    # Dados de teste: lista com tuplas de alunos e suas respectivas disciplinas/notas
    alunos = [
        ("João", [("Matemática", 8.5), ("Português", 7.0), ("Física", 9.0)]),
        ("Maria", [("Matemática", 9.5), ("Português", 8.5), ("Química", 10.0)]),
        ("Pedro", [("Matemática", 6.5), ("Português", 6.0), ("História", 7.0)]),
        ("Ana", [("Matemática", 8.0), ("Português", 9.0), ("Biologia", 8.5)]),
        ("Lucas", [("Matemática", 5.5), ("Português", 6.5), ("Geografia", 7.5)])
    ]

    # Converte a lista para dicionário, calculando a média de cada aluno
    alunos_dict = criar_dicionario_alunos(alunos)

    # Exibe a média de todos os alunos
    print("\nTodos os alunos e suas médias:")
    for nome, dados in alunos_dict.items():
        print(f"{nome}: {dados['media']:.2f}")

    # Define uma média mínima e exibe os aprovados
    media_minima = 7.5
    exibir_alunos_por_media(alunos_dict, media_minima)

    # Mostra os alunos ordenados por desempenho
    ordenar_alunos_por_media(alunos_dict)

# Ponto de entrada principal
if __name__ == "__main__":
    main()
