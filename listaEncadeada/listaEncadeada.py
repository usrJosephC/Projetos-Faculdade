#Definir a classe NODE para representar cada nó
class Node:
  def __init__(self):
    self.data = data #valor do nó
    self.next = None #ponteriro para o próximo nó

#Definir a classe linkedList para lista encadeada
class LinkedList:
  def __init__(self):
    self.head = None #inicialmente a lista está vazia

  #Função para adicionar elementos no final da lista
  def append(self, data):
    new_node - Node(data) #criar um novo nó
    if self.head is None:
      self.head = new_node #se a lista está vazia, novo nó na cabeça
      return
    last - self.head
    while last.next:
      last = last.next #move até o final da lista
    last.next = new_node #adicionar o novo nó ao final

  #Função para remover um elemento específico
  def remove(self, data):
    current = self.head

    #Se o nó a ser removido for na cabeça(primária)
    if current is not None:
      if current.data == data:
        self.head = current.next #muda a cabeça para o próximo nó
        current = None #liberação de nó
        print(f"Elemento {data} removido (era o primeiro elemento)")
        return
      
      #Para qualquer outro nó
      prev = None
      while current is not None:
        if current.data == data:
          prev.next = current.next #desvincular o nó da lista
          current = None #liberação do nó
          print(f"Elemento {data} removido")
          return
        prev = current
        current = current.next
        print(f"Elemento {data} não encontrado na lista")

  #Função para remover todos os elementos dessa lista
  def remove_all(self):
    self.head = None #definindo a cabeça com NONE remove todos os nós
    print(f"Todos os elementos foram removidos da lista.")
  
  #Função para imprimir a lista
  def print_list(self):
    current = self.head
    if current is None:
      print("A lista está vazia.")
      return
    print("Lista encadeada: " end= " ")
    while current:
      print(current.data, end= " -> ")
      current = current.next
      print("None")