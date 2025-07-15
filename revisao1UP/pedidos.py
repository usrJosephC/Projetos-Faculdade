class Lanchonete:
    def __init__(self):
        self.fila_pedidos = []
    
    def adicionar_pedido(self, pedido):
        self.fila_pedidos.append(pedido)
        print(f"Pedido '{pedido}' adicionado à fila.")
    
    def atender_pedido(self):
        if not self.fila_pedidos:
            print("Não há pedidos para atender.")
            return None
        pedido = self.fila_pedidos.pop(0)
        print(f"Pedido '{pedido}' atendido.")
        return pedido
    
    def proximo_pedido(self):
        if not self.fila_pedidos:
            print("Não há pedidos na fila.")
            return None
        print(f"Próximo pedido a ser atendido: '{self.fila_pedidos[0]}'")
        return self.fila_pedidos[0]
    
    def mostrar_fila(self):
        if not self.fila_pedidos:
            print("A fila de pedidos está vazia.")
            return
        print("Fila de pedidos:")
        for i, pedido in enumerate(self.fila_pedidos, 1):
            print(f"{i}. {pedido}")

lanchonete = Lanchonete()

lanchonete.adicionar_pedido("X-Burger")
lanchonete.adicionar_pedido("Refrigerante")
lanchonete.adicionar_pedido("Batata Frita")

lanchonete.mostrar_fila()

lanchonete.proximo_pedido()

lanchonete.atender_pedido()
lanchonete.atender_pedido()

lanchonete.mostrar_fila()