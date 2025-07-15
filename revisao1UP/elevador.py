class Elevador:
    def __init__(self):
        self.fila_espera = []
    
    def adicionar_passageiro(self, nome):
        self.fila_espera.append(nome)
        print(f"{nome} entrou na fila de espera.")
    
    def atender_passageiro(self):
        if not self.fila_espera:
            print("Não há passageiros na fila de espera.")
            return None
        passageiro = self.fila_espera.pop(0)
        print(f"Atendendo passageiro: {passageiro}")
        return passageiro
    
    def proximo_a_ser_atendido(self):
        if not self.fila_espera:
            print("Não há passageiros na fila de espera.")
            return None
        print(f"Próximo a ser atendido: {self.fila_espera[0]}")
        return self.fila_espera[0]
    
    def mostrar_fila(self):
        if not self.fila_espera:
            print("A fila de espera está vazia.")
            return
        print("Fila de espera do elevador:")
        for i, passageiro in enumerate(self.fila_espera, 1):
            print(f"{i}. {passageiro}")

elevador = Elevador()

elevador.adicionar_passageiro("João")
elevador.adicionar_passageiro("Maria")
elevador.adicionar_passageiro("Carlos")

elevador.mostrar_fila()

elevador.proximo_a_ser_atendido()

elevador.atender_passageiro()
elevador.atender_passageiro()

elevador.mostrar_fila()