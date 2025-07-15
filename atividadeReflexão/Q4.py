from collections import deque

class TerminalOnibus:
    def __init__(self):
        self.fila_onibus = deque()
    
    def adicionar_inicio(self, onibus):
        self.fila_onibus.appendleft(onibus)
        print(f"Ônibus {onibus} adicionado no início da fila.")
        self.mostrar_fila()
    
    def adicionar_final(self, onibus):
        self.fila_onibus.append(onibus)
        print(f"Ônibus {onibus} adicionado no final da fila.")
        self.mostrar_fila()
    
    def remover_inicio(self):
        if not self.fila_onibus:
            print("Fila de ônibus vazia. Nada para remover.")
            return None
        
        onibus = self.fila_onibus.popleft()
        print(f"Ônibus {onibus} removido do início da fila.")
        self.mostrar_fila()
        return onibus
    
    def remover_final(self):
        if not self.fila_onibus:
            print("Fila de ônibus vazia. Nada para remover.")
            return None
        
        onibus = self.fila_onibus.pop()
        print(f"Ônibus {onibus} removido do final da fila.")
        self.mostrar_fila()
        return onibus
    
    def mostrar_fila(self):
        if not self.fila_onibus:
            print("\nFila atual: [Vazia]")
        else:
            print("\nFila atual de ônibus:")
            print("INÍCIO <- ", end="")
            print(" - ".join(self.fila_onibus), end="")
            print(" <- FIM")
        print("---")


if __name__ == "__main__":
    terminal = TerminalOnibus()
    
    print("=== Sistema de Gerenciamento de Ônibus ===")
    print("Comandos disponíveis:")
    print("ai <ônibus> - Adiciona no início")
    print("af <ônibus> - Adiciona no final")
    print("ri - Remove do início")
    print("rf - Remove do final")
    print("show - Mostra fila")
    print("exit - Sair\n")
    
    while True:
        comando = input("> ").strip().lower()
        
        if comando.startswith("ai "):
            onibus = comando[3:].strip()
            terminal.adicionar_inicio(onibus)
        elif comando.startswith("af "):
            onibus = comando[3:].strip()
            terminal.adicionar_final(onibus)
        elif comando == "ri":
            terminal.remover_inicio()
        elif comando == "rf":
            terminal.remover_final()
        elif comando == "show":
            terminal.mostrar_fila()
        elif comando == "exit":
            break
        else:
            print("Comando inválido. Tente novamente.")