# Definir a classe Node para representar cada nó
class Node:
    def __init__(self, data):
        self.data = data  # valor do nó
        self.next = None  # ponteiro para o próximo nó

# Definir a classe LinkedList para lista encadeada
class LinkedList:
    def __init__(self):
        self.head = None  # inicialmente a lista está vazia

    # Função para adicionar elementos no final da lista
    def append(self, data):
        new_node = Node(data)  # criar um novo nó
        if self.head is None:
            self.head = new_node  # se a lista está vazia, novo nó na cabeça
            return
        last = self.head
        while last.next:
            last = last.next  # move até o final da lista
        last.next = new_node  # adicionar o novo nó ao final

    # Função para remover um elemento específico
    def remove(self, data):
        current = self.head

        # Se o nó a ser removido for na cabeça(primário)
        if current is not None:
            if current.data == data:
                self.head = current.next  # muda a cabeça para o próximo nó
                current = None  # liberação de nó
                print(f"Elemento {data} removido (era o primeiro elemento)")
                return

        # Para qualquer outro nó
        prev = None
        while current is not None:
            if current.data == data:
                prev.next = current.next  # desvincular o nó da lista
                current = None  # liberação do nó
                print(f"Elemento {data} removido")
                return
            prev = current
            current = current.next
        print(f"Elemento {data} não encontrado na lista")

    # Função para remover todos os elementos dessa lista
    def remove_all(self):
        self.head = None  # definindo a cabeça com NONE remove todos os nós
        print("Todos os elementos foram removidos da lista.")

    # Função para imprimir a lista
    def print_list(self):
        current = self.head
        if current is None:
            print("A lista está vazia.")
            return
        print("Lista encadeada: ", end=" ")
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")

    # Método para ver o topo da lista (primeiro elemento)
    def ver_topo(self):
        if self.head is None:
            print("A lista está vazia.")
            return None
        return self.head.data


if __name__ == "__main__":
    lista = LinkedList()

    lista.append(10)
    lista.append(20)
    lista.append(30)
    lista.print_list()
    
    topo = lista.ver_topo()
    print(f"Topo da lista: {topo}")  
    lista.remove(20)
    lista.print_list()

    lista.remove(50)

    topo = lista.ver_topo()
    print(f"Topo da lista: {topo}")

    lista.remove_all()  
    lista.print_list()  

    topo = lista.ver_topo()
    print(f"Topo da lista: {topo}")