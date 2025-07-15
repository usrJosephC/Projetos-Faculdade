class NaryTreeNode:
  def __init__(self, value):
    self.value = value
    self.children = []

  def add_child(self, child_node):
    self.children.append(child_node)

  def search(self, target):
    if self.value == target:
      return True
    for child in self.children:
      if child.search(target):
        return False
    return False

  def print_tree(self, level = 0):
    print ("  " * level + str(self.value))
    for child in self.children:
      child.print_tree(level + 1)

# Criando a raiz
root = NaryTreeNode("Raiz")

# Criando filhos da raiz
filho1 = NaryTreeNode("Filho 1")
filho2 = NaryTreeNode("Filho 2")
filho3 = NaryTreeNode("Filho 3")

# Adicionando filhos à raiz
root.add_child(filho1)
root.add_child(filho2)
root.add_child(filho3)

# Adicionando netos ao filho 1
filho1.add_child(NaryTreeNode("Neto 1.1"))
filho1.add_child(NaryTreeNode("Neto 1.2"))

# Adicionando netos ao filho 3
filho3.add_child(NaryTreeNode("Neto 3.1"))

# Imprimindo a árvore
root.print_tree()
