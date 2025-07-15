from collections import deque

class GerenciamentoBanco:
    def __init__(self):
        self.filaClientes = deque()

    def adicionarClienteComum(self, nome):
        if not self._validarNome(nome):
            print("Erro: Nome deve conter apenas letras e espaços.")
            return
        nomeFormatado = self._formatarNome(nome)
        self.filaClientes.append(nomeFormatado)
        print(f"Cliente comum {nomeFormatado} adicionado ao final da fila.")

    def adicionarClientePrioritario(self, nome):
        if not self._validarNome(nome):
            print("Erro: Nome deve conter apenas letras e espaços.")
            return
        nomeFormatado = self._formatarNome(nome)
        self.filaClientes.appendleft(nomeFormatado)
        print(f"Cliente prioritário {nomeFormatado} adicionado ao início da fila.")

    def atenderCliente(self):
        if not self.filaClientes:
            print("Não há clientes para atender.")
            return
        clienteAtendido = self.filaClientes.popleft()
        print(f"Atendendo cliente: {clienteAtendido}")

    def exibirFila(self):
        if not self.filaClientes:
            print("Fila vazia.")
            return
        print("\nFila de atendimento:")
        for i, cliente in enumerate(self.filaClientes, 1):
            print(f"{i}. {cliente}")

    def _validarNome(self, nome):
        import re
        return bool(re.fullmatch(r'^[A-Za-zÀ-ÿ\s]+$', nome.strip()))

    def _formatarNome(self, nome):
        nome = nome.strip()
        return ' '.join([part.capitalize() for part in nome.split()])

def menuBanco():
    banco = GerenciamentoBanco()
    while True:
        try:
            print("\n1. Adicionar cliente comum")
            print("2. Adicionar cliente prioritário")
            print("3. Atender próximo cliente")
            print("4. Exibir fila")
            print("5. Sair")
            opcao = input("\nOpção: ").strip()

            if opcao == '1':
                nome = input("Nome do cliente comum: ").strip()
                banco.adicionarClienteComum(nome)
            elif opcao == '2':
                nome = input("Nome do cliente prioritário: ").strip()
                banco.adicionarClientePrioritario(nome)
            elif opcao == '3':
                banco.atenderCliente()
            elif opcao == '4':
                banco.exibirFila()
            elif opcao == '5':
                print("Encerrando sistema...")
                break
            else:
                print("Opção inválida. Tente novamente.")
        except Exception as e:
            print(f"Erro: {str(e)}")

if __name__ == "__main__":
    menuBanco()