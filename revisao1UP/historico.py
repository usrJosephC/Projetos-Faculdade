class Navegador:
    def __init__(self):
        self.historico = []
        self.pagina_atual = None
    
    def visitar_pagina(self, url):
        if self.pagina_atual is not None:
            self.historico.append(self.pagina_atual)
        self.pagina_atual = url
        print(f"Visitando: {url}")
    
    def voltar(self):
        if not self.historico:
            print("Não há páginas anteriores no histórico.")
            return None
        pagina_anterior = self.historico.pop()
        print(f"Voltando de '{self.pagina_atual}' para '{pagina_anterior}'")
        self.pagina_atual = pagina_anterior
        return pagina_anterior
    
    def mostrar_historico(self):
        if not self.historico:
            print("Histórico vazio.")
            return
        print("Histórico de navegação (do mais recente para o mais antigo):")
        for i, pagina in enumerate(reversed(self.historico), 1):
            print(f"{i}. {pagina}")
        print(f"Página atual: {self.pagina_atual}")

navegador = Navegador()

navegador.visitar_pagina("www.google.com")
navegador.visitar_pagina("www.github.com")
navegador.visitar_pagina("www.python.org")

navegador.mostrar_historico()

navegador.voltar()
navegador.voltar()

navegador.mostrar_historico()