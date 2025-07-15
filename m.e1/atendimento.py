from collections import deque

class SistemaAtendimento:
    def __init__(self):
        self.filaComum = deque()
        
        self.filaCritica = deque()
        
        self.filaPrioritaria = deque()
        
        self.contadorPacientes = 1
    
    def adicionarPaciente(self, tipo, nome, gravidade=None):
        paciente = {'id': self.contadorPacientes, 'nome': nome}
        self.contadorPacientes += 1
        
        if tipo == 'comum':
            self.filaComum.append(paciente)
            print(f"Paciente {nome} adicionado à fila comum.")
        elif tipo == 'critico':
            self.filaCritica.append(paciente)
            print(f"Paciente {nome} adicionado à fila crítica (será atendido prioritariamente).")
        elif tipo == 'prioritario':
            if gravidade == 'alta':
                self.filaPrioritaria.appendleft(paciente)
                print(f"Paciente {nome} adicionado ao início da fila prioritária (caso grave).")
            else:
                self.filaPrioritaria.append(paciente)
                print(f"Paciente {nome} adicionado ao final da fila prioritária (caso menos grave).")
        else:
            print("Tipo de paciente inválido!")
    
    def chamarProximoPaciente(self):
        if self.filaCritica:
            paciente = self.filaCritica.pop()
            print(f"Atendendo paciente CRÍTICO: {paciente['nome']} (ID: {paciente['id']})")
        elif self.filaPrioritaria:
            paciente = self.filaPrioritaria.popleft()
            print(f"Atendendo paciente PRIORITÁRIO: {paciente['nome']} (ID: {paciente['id']})")
        elif self.filaComum:
            paciente = self.filaComum.popleft()
            print(f"Atendendo paciente COMUM: {paciente['nome']} (ID: {paciente['id']})")
        else:
            print("Não há pacientes para atender.")
    
    def removerPaciente(self, pacienteID):
        for i, paciente in enumerate(self.filaComum):
            if paciente['id'] == pacienteID:
                pacienteRemovido = self.filaComum[i]
                del self.filaComum[i]
                print(f"Paciente {pacienteRemovido['nome']} (ID: {pacienteID}) removido da fila comum.")
                return
        
        for i, paciente in enumerate(self.filaCritica):
            if paciente['id'] == pacienteID:
                pacienteRemovido = self.filaCritica[i]
                del self.filaCritica[i]
                print(f"Paciente {pacienteRemovido['nome']} (ID: {pacienteID}) removido da fila crítica.")
                return
        
        for i, paciente in enumerate(self.filaPrioritaria):
            if paciente['id'] == pacienteID:
                pacienteRemovido = self.filaPrioritaria[i]
                del self.filaPrioritaria[i]
                print(f"Paciente {pacienteRemovido['nome']} (ID: {pacienteID}) removido da fila prioritária.")
                return
        
        print(f"Paciente com ID {pacienteID} não encontrado em nenhuma fila.")
    
    def mostrarFilas(self):
        print("\nEstado atual das filas:")
        
        print("\nFila Comum (ordem de atendimento):")
        if not self.filaComum:
            print("Vazia")
        for paciente in self.filaComum:
            print(f"ID: {paciente['id']}, Nome: {paciente['nome']}")
        
        print("\nFila Crítica (último a entrar é o primeiro a ser atendido):")
        if not self.filaCritica:
            print("Vazia")
        for paciente in reversed(self.filaCritica):
            print(f"ID: {paciente['id']}, Nome: {paciente['nome']}")
        
        print("\nFila Prioritária (podem entrar no início ou fim):")
        if not self.filaPrioritaria:
            print("Vazia")
        for paciente in self.filaPrioritaria:
            print(f"ID: {paciente['id']}, Nome: {paciente['nome']}")
        
        print()


def simularFluxo(sistema):
    sistema.adicionarPaciente('comum', 'João Silva')
    sistema.adicionarPaciente('comum', 'Maria Souza')
    sistema.adicionarPaciente('critico', 'Carlos Emergência')
    sistema.adicionarPaciente('prioritario', 'Dona Marta', 'alta')
    sistema.adicionarPaciente('prioritario', 'Seu José', 'baixa')
    sistema.adicionarPaciente('critico', 'Ana Urgente')
    sistema.adicionarPaciente('comum', 'Pedro Rocha')
    
    sistema.mostrarFilas()
    
    print("\n--- Iniciando atendimento ---")
    for _ in range(4):
        sistema.chamarProximoPaciente()
    
    sistema.mostrarFilas()
    
    sistema.removerPaciente(5)
    
    sistema.mostrarFilas()
    
    print("\n--- Continuando atendimento ---")
    for _ in range(3):
        sistema.chamarProximoPaciente()
    
    sistema.mostrarFilas()


if __name__ == "__main__":
    sistema = SistemaAtendimento()
    
    print("Bem-vindo ao Sistema de Gerenciamento de Atendimento Médico")
    print("Escolha uma opção:")
    print("1. Adicionar paciente")
    print("2. Chamar próximo paciente")
    print("3. Remover paciente")
    print("4. Mostrar filas")
    print("5. Simular fluxo automático")
    print("6. Sair")
    
    while True:
        opcao = input("\nOpção: ")
        
        if opcao == '1':
            tipo = input("Tipo (comum/critico/prioritario): ").lower()
            nome = input("Nome: ")
            if tipo == 'prioritario':
                gravidade = input("Gravidade (alta/baixa): ").lower()
                sistema.adicionarPaciente(tipo, nome, gravidade)
            else:
                sistema.adicionarPaciente(tipo, nome)
        
        elif opcao == '2':
            sistema.chamarProximoPaciente()
        
        elif opcao == '3':
            pacienteID = int(input("ID do paciente a remover: "))
            sistema.removerPaciente(pacienteID)
        
        elif opcao == '4':
            sistema.mostrarFilas()
        
        elif opcao == '5':
            simularFluxo(sistema)
        
        elif opcao == '6':
            print("Saindo do sistema...")
            break
        
        else:
            print("Opção inválida. Tente novamente.")