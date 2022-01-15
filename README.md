# biblioteca-agil
## Design da solução

Inicialmente criei a classe Livro para representar a moldura de um livro, com todos os atributos que foram solicitados 
no enunciado do exercício. Além de criar os métodos isDisponivel e isIndisponivel, para devolver os livros disponíveis e indisponíveis.

A classe Aplicacao possui o método main e inicializa a Biblioteca.

A classe Biblioteca inicializa o RepositorioDeLivros em seu construtor e é reponsável por gerenciar e executar as opçoes escolhidas pelo usuário.

A interface RepositorioDeLivros define o contrato necessário para a criação de repositorios de livros mais específicos. 
Atualmente existem duas opções de repositório, uma que salva os livros em memória, fazendo que as alterações sejam perdidas toda vez que o programa reinicia, e a outra salva os livros em um arquivo localizado na pasta resources, fazendo que as mudanças na Biblioteca não sejam perdidas
caso o programa seja encerrado.
Por padrão, o repositório utilizado na biblioteca, é o RepositorioDeLivrosEmArquivo. Caso você deseje alterar, para utilizar a opção em memória, 
basta alterar a classe Biblioteca para utilizar o RepositorioDeLivrosEmMemoria.
A primeira vez que o programa é executado, é gerado o arquivo contendo os três livros obrigatórios, 
após essa criação o arquivo mantém todos os dados já existentes.

## Como executar

Para rodar a aplicacao você precisa importar ela na sua IDE e executar o método main, localizado na classe Aplicacao.java.