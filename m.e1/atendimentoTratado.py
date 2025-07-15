from collections import deque
import re

class SistemaAtendimento:
    def __init__(self):
        self.filaComum = deque()
        self.filaCritica = deque()
        self.filaPrioritaria = deque()
        self.contadorPacientes = 1
    
    def validar_nome(self, nome):
        """Valida se o nome contém apenas letras e espaços"""
        return bool(re.fullmatch(r'^[A-Za-zÀ-ÿ\s]+$', nome.strip()))
    
    def adicionarPaciente(self, tipo, nome, gravidade=None):
        try:
            if not nome or not isinstance(nome, str):
                raise ValueError("Nome do paciente inválido.")
            
            if not self.validar_nome(nome):
                raise ValueError("Nome deve conter apenas letras e espaços.")
            
            nome = nome.strip()
            nome = ' '.join([part.capitalize() for part in nome.split()])
            
            paciente = {'id': self.contadorPacientes, 'nome': nome}
            self.contadorPacientes += 1
            
            tipo = tipo.lower()
            if tipo == 'comum':
                self.filaComum.append(paciente)
                print(f"Paciente {nome} adicionado à fila comum.")
            elif tipo == 'critico':
                self.filaCritica.append(paciente)
                print(f"Paciente {nome} adicionado à fila crítica (será atendido prioritariamente).")
            elif tipo == 'prioritario':
                if gravidade:
                    gravidade = gravidade.lower()
                    if gravidade not in ('alta', 'baixa'):
                        raise ValueError("Gravidade deve ser 'alta' ou 'baixa'.")
                    
                    if gravidade == 'alta':
                        self.filaPrioritaria.appendleft(paciente)
                        print(f"Paciente {nome} adicionado ao início da fila prioritária (caso grave).")
                    else:
                        self.filaPrioritaria.append(paciente)
                        print(f"Paciente {nome} adicionado ao final da fila prioritária (caso menos grave).")
                else:
                    raise ValueError("Pacientes prioritários devem ter gravidade especificada.")
            else:
                raise ValueError("Tipo de paciente inválido. Use 'comum', 'critico' ou 'prioritario'.")
        except ValueError as e:
            print(f"Erro ao adicionar paciente: {str(e)}")
            self.contadorPacientes -= 1
    
    def chamarProximoPaciente(self):
        try:
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
        except IndexError:
            print("Erro: Tentativa de atender fila vazia.")
        except Exception as e:
            print(f"Erro inesperado ao chamar paciente: {str(e)}")
    
    def removerPaciente(self, pacienteID):
        try:
            if not isinstance(pacienteID, int) and not pacienteID.isdigit():
                raise ValueError("ID do paciente deve ser um número inteiro.")
            
            pacienteID = int(pacienteID)
            encontrado = False
            
            for i, paciente in enumerate(self.filaComum):
                if paciente['id'] == pacienteID:
                    pacienteRemovido = self.filaComum[i]
                    del self.filaComum[i]
                    print(f"Paciente {pacienteRemovido['nome']} (ID: {pacienteID}) removido da fila comum.")
                    encontrado = True
                    break
            
            if not encontrado:
                for i, paciente in enumerate(self.filaCritica):
                    if paciente['id'] == pacienteID:
                        pacienteRemovido = self.filaCritica[i]
                        del self.filaCritica[i]
                        print(f"Paciente {pacienteRemovido['nome']} (ID: {pacienteID}) removido da fila crítica.")
                        encontrado = True
                        break
            
            if not encontrado:
                for i, paciente in enumerate(self.filaPrioritaria):
                    if paciente['id'] == pacienteID:
                        pacienteRemovido = self.filaPrioritaria[i]
                        del self.filaPrioritaria[i]
                        print(f"Paciente {pacienteRemovido['nome']} (ID: {pacienteID}) removido da fila prioritária.")
                        encontrado = True
                        break
            
            if not encontrado:
                print(f"Paciente com ID {pacienteID} não encontrado em nenhuma fila.")
        except Exception as e:
            print(f"Erro ao remover paciente: {str(e)}")
    
    def mostrarFilas(self):
        try:
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
        except Exception as e:
            print(f"Erro ao mostrar filas: {str(e)}")


def simularFluxo(sistema):
    try:
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
    except Exception as e:
        print(f"Erro durante simulação: {str(e)}")


def menu_principal():
    sistema = SistemaAtendimento()
    
    print("Bem-vindo ao Sistema de Gerenciamento de Atendimento Médico")
    
    while True:
        try:
            print("\nEscolha uma opção:")
            print("1. Adicionar paciente")
            print("2. Chamar próximo paciente")
            print("3. Remover paciente")
            print("4. Mostrar filas")
            print("5. Simular fluxo automático")
            print("6. Sair")
            
            opcao = input("\nOpção: ").strip()
            
            if opcao == '1':
                tipo = input("Tipo (comum/critico/prioritario): ").lower().strip()
                
                while True:
                    nome = input("Nome (apenas letras): ").strip()
                    if sistema.validar_nome(nome):
                        break
                    print("Erro: Nome deve conter apenas letras e espaços. Tente novamente.")
                
                if tipo == 'prioritario':
                    gravidade = input("Gravidade (alta/baixa): ").lower().strip()
                    sistema.adicionarPaciente(tipo, nome, gravidade)
                else:
                    sistema.adicionarPaciente(tipo, nome)
            
            elif opcao == '2':
                sistema.chamarProximoPaciente()
            
            elif opcao == '3':
                pacienteID = input("ID do paciente a remover: ").strip()
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
        
        except KeyboardInterrupt:
            print("\nOperação interrompida pelo usuário. Continuando...")
        except Exception as e:
            print(f"Erro inesperado: {str(e)}")


if __name__ == "__main__":
    menu_principal()