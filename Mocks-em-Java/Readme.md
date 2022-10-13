# Mocks em Java: conhecendo o Mockito

## Testes com Mocks

> Mock é uma classe que simula o comportamento de outra classe.

As bibliotecas de Mock existem para para não termos que dedicar tanto trabalho escrevendo as classes Mock uma a uma, ao
invés disso, a biblioteca usa algum recurso próprio, para criar essa classe dinamicamente e simula as dependências da
classe que queremos testar.

### Vantagem de utilizar mocks ao escrever testes de unidade:

✅ <strong>Substituir dependências externas da classe</strong> - Mocks possuem o objetivo de simular comportamentos das
dependências de uma classe, para que os testes de unidade não se tornem testes de integração.

## Iniciando com Mockito

### Maneiras de adicionar o Mockito à uma aplicação:

➡️ <strong>Baixando e adicionando seus jar’s na aplicação:</strong> Podemos baixar os jar’s do Mockito e adicioná-los ao
build path da aplicação.

➡️ <strong>Declarando-o como dependência da aplicação:</strong> Utilizando o Maven, Gradle ou outra ferramenta de
build/gestão de dependências.

> Uma forma para pedir ao Mockito para que crie um mock de uma determinada classe é:<br>
<strong>Mockito.mock(Classe.class)</strong>

## Escrevendo testes com mockito

* @Mock - serve para indicar ao Mockito quais atributos são mocks

* MockitoAnnotetions.initMocks(this); -
  é para ler as anotações do mockito (@Mock é uma delas) e inicializar um mock, mas de qual classe? this, da própria
  classe de teste

## Boas práticas

✅ <strong>É considerada uma boa prática injetar as dependências sempre pelo construtor</strong> ao invés de injetar as
dependência pelo atributo. Isso porque o construtor já deixa óbvio quais as dependências daquela classe e, com ele,
conseguimos passar um Mock como parâmetro para os testes. Isso simplifica o processo.

## Lidando com exceptions

* Maneira de configurar um mock para lançar uma exception:
    * Mockito.when(mock.metodo()).<strong>thenThrow</strong>(Exception.class)

      <strong>O método thenThrow força o mock a lançar uma exception quando determinado método for chamado.</strong>

## Outras situações

* <strong>Existe um conceito no Mockito chamado Captor, para capturar um determinado objeto.</strong>
    * Sempre que tivermos um Mock que chama um método da classe que estamos testando e passa para ele um objeto que não
      temos no teste, ou seja, um objeto criado na classe a ser testada, utilizamos um Captor.


* <strong>Não é considerada uma boa prática fazer chamadas a métodos estáticos, do ponto de vista de testes automatizados,
  porque métodos estáticos dificultam a utilização de mocks, quando precisamos simular comportamentos.</strong>
  * O ideal é sempre substituirmos o método estático por alguma abstração, classe ou interface, que consigamos passar como parâmetro para classe sendo testada. Com isso, no teste passamos um Mock como parâmetro.