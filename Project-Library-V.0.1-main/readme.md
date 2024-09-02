# Avaliação 2ª Unidade - Laboratório de Programação

**Professor:** Izaac Alencar  
**Equipe:** Joseph Cavalcante, Leticya Beatryz, Mariana Melo, Matteus Guilherme

## Sistema de Biblioteca

### Instruções de Uso

O uso da IDE é opcional, mas recomendamos o uso do Visual Studio Code. Após abrir a pasta na IDE, siga os passos abaixo para executar o sistema:

1. **Abrir a Pasta do Projeto:**
   - Abra o Visual Studio Code.
   - Selecione "File" > "Open Folder..." e escolha a pasta raiz do projeto.

2. **Executar o Arquivo Main.java:**
   - Navegue até o arquivo `Main.java` localizado no caminho `demo/src/main/java/com/example/Main.java`.
   - No Visual Studio Code, clique com o botão direito do mouse no arquivo `Main.java` e selecione a opção "Run Java".

**Link para o projeto:** [[link](https://github.com/ttmatteus/Project-Library-V.0.1)]

### Funcionalidades

Sobre o uso do sistema:

- A pasta `biblioteca` contém as funções de controller e persistência (onde será feito o armazenamento de dados dos livros, membros e empréstimos).
- A pasta `model` contém os arquivos para modelo do sistema da Biblioteca, e sua estrutura também possui algumas implementações de persistência (mas de forma mais simples, apenas para formatação de String).
- A pasta `service` é onde os arquivos `.txt` da persistência serão armazenados.
- O `Main.java` é o arquivo contendo a view da arquitetura MVC, sendo a interface que o usuário precisa executar para acessar as funcionalidades do sistema.

### Justificativa

Usamos a linguagem de programação JAVA, com o Paradigma Orientado a Objeto (P.O.O.), e uma arquitetura MVC (Model – View – Controller). O uso dessa linguagem juntamente com o paradigma e arquitetura escolhidos se deu após análise conjunta sobre as funções e pré-requisitos que o sistema exigia. Encontramos classes que precisariam ser criadas, além do que precisaríamos de um controlador para as regras de serviço/negócio, e não se fazia necessário o uso de banco de dados.
