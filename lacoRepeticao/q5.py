def calcular_media_turma():
    while True:
        try:
            num_alunos = int(input("Digite a quantidade de alunos na turma: "))
            if num_alunos <= 0:
                print("Por favor, digite um número positivo.")
            else:
                break
        except ValueError:
            print("Por favor, digite um número inteiro.")
    
    soma_notas = 0
    
    print("\nInsira as notas dos alunos:")
    for i in range(num_alunos):
        while True:
            try:
                nota = float(input(f"Nota do aluno {i+1}: "))
                if nota < 0 or nota > 10:
                    print("Por favor, digite uma nota entre 0 e 10.")
                else:
                    soma_notas += nota
                    break
            except ValueError:
                print("Por favor, digite um número.")
    
    media_turma = soma_notas / num_alunos
    print(f"\nMédia da turma: {media_turma:.2f}")

calcular_media_turma()