# biblioteca-agil
## Design da solu��o

Inicialmente criei a classe Livro para representar a moldura de um livro, com todos os atributos que foram solicitados 
no enunciado do exerc�cio. Al�m de criar os m�todos isDisponivel e isIndisponivel, para devolver os livros dispon�veis e indispon�veis.

A classe Aplicacao possui o m�todo main e inicializa a Biblioteca.

A classe Biblioteca inicializa o RepositorioDeLivros em seu construtor e � repons�vel por gerenciar e executar as op�oes escolhidas pelo usu�rio.

A interface RepositorioDeLivros define o contrato necess�rio para a cria��o de repositorios de livros mais espec�ficos. 
Atualmente existem duas op��es de reposit�rio, uma que salva os livros em mem�ria, fazendo que as altera��es sejam perdidas toda vez que o programa reinicia, e a outra salva os livros em um arquivo localizado na pasta resources, fazendo que as mudan�as na Biblioteca n�o sejam perdidas
caso o programa seja encerrado.
Por padr�o, o reposit�rio utilizado na biblioteca, � o RepositorioDeLivrosEmArquivo. Caso voc� deseje alterar, para utilizar a op��o em mem�ria, 
basta alterar a classe Biblioteca para utilizar o RepositorioDeLivrosEmMemoria.
A primeira vez que o programa � executado, � gerado o arquivo contendo os tr�s livros obrigat�rios, 
ap�s essa cria��o o arquivo mant�m todos os dados j� existentes.

## Como executar

Para rodar a aplicacao voc� precisa importar ela na sua IDE e executar o m�todo main, localizado na classe Aplicacao.java.