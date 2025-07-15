class EditorTexto:
    def __init__(self):
        self.documento = []
        self.historico_undo = []
        self.historico_redo = []
    
    def adicionar_texto(self, texto):
        if texto.strip():
            self.documento.append(texto)
            self.historico_undo.append(('add', len(self.documento)-1))
            self.historico_redo.clear()
            self.mostrar_documento()
    
    def desfazer(self):
        if not self.historico_undo:
            print("Nada para desfazer.")
            return
        
        acao, pos = self.historico_undo.pop()
        
        if acao == 'add':
            texto = self.documento.pop(pos)
            self.historico_redo.append(('remove', texto, pos))
        elif acao == 'remove':
            self.documento.insert(pos, texto)
            self.historico_redo.append(('add', pos))
        
        self.mostrar_documento()
    
    def refazer(self):
        if not self.historico_redo:
            print("Nada para refazer.")
            return
        
        acao, *args = self.historico_redo.pop()
        
        if acao == 'add':
            pos = args[0]
            texto = self.documento[pos]
            self.historico_undo.append(('add', pos))
        elif acao == 'remove':
            texto, pos = args
            self.documento.insert(pos, texto)
            self.historico_undo.append(('remove', pos))
        
        self.mostrar_documento()
    
    def mostrar_documento(self):
        print("\n--- Documento Atual ---")
        if not self.documento:
            print("[Vazio]")
        else:
            for i, texto in enumerate(self.documento, 1):
                print(f"{i}. {texto}")
        print("-----------------------")

if __name__ == "__main__":
    editor = EditorTexto()
    
    print("=== Editor de Texto com Undo/Redo ===")
    print("Comandos disponíveis:")
    print("add <texto> - Adiciona texto")
    print("undo - Desfaz última ação")
    print("redo - Refaz ação desfeita")
    print("show - Mostra documento")
    print("exit - Sair do programa\n")
    
    while True:
        comando = input("> ").strip().lower()
        
        if comando.startswith("add "):
            texto = comando[4:].strip()
            editor.adicionar_texto(texto)
        elif comando == "undo":
            editor.desfazer()
        elif comando == "redo":
            editor.refazer()
        elif comando == "show":
            editor.mostrar_documento()
        elif comando == "exit":
            break
        else:
            print("Comando inválido. Tente novamente.")