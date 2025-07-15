def media_notas_turma():
    qtd_alunos = int(input("Digite a quantidade de alunos: "))
    total_notas = 0
    for i in range(qtd_alunos):
        nota = float(input(f"Digite a nota do aluno {i + 1}: "))
        total_notas += nota
    media = total_notas / qtd_alunos
    print(f"Média da turma: {media:.2f}")

media_notas_turma()