class FilaAtendimento:
    def __init__(self):
        self.fila = []
    
    def _validar_nome(self, nome):
        if not nome.replace(' ', '').isalpha():
            raise ValueError("O nome deve conter apenas letras e espaços.")
        if not nome.strip():
            raise ValueError("O nome não pode ser vazio.")
        return True
    
    def adicionar_cliente(self, cliente):
        try:
            self._validar_nome(cliente)
            self.fila.append(cliente)
            print(f"Cliente {cliente} adicionado à fila.")
        except ValueError as e:
            print(f"Erro ao adicionar cliente: {e}")
    
    def atender_cliente(self):
        if not self.fila:
            print("Não há clientes na fila para atender.")
            return None
        
        cliente_atendido = self.fila.pop(0)
        print(f"Atendendo cliente: {cliente_atendido}")
        return cliente_atendido
    
    def proximo_a_ser_atendido(self):
        if not self.fila:
            print("Não há clientes na fila.")
            return None
        
        proximo = self.fila[0]
        print(f"Próximo a ser atendido: {proximo}")
        return proximo
    
    def mostrar_fila(self):
        if not self.fila:
            print("A fila está vazia.")
            return
        
        print("\nFila de espera atual:")
        for i, cliente in enumerate(self.fila, 1):
            print(f"{i}. {cliente}")

if __name__ == "__main__":
    print("=== Sistema de Atendimento Bancário ===")
    fila = FilaAtendimento()
    
    clientes_testes = [
        "João Silva",
        "Maria Oliveira",
        "Carlos123",
        "Ana Costa",
        "12345",
        "   ",
        "Pedro-Almeida",
        "Luça Mendes"
    ]
    
    for cliente in clientes_testes:
        fila.adicionar_cliente(cliente)
    
    fila.mostrar_fila()
    
    fila.atender_cliente()
    fila.atender_cliente()
    
    fila.mostrar_fila()