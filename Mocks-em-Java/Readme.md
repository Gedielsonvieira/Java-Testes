# Mocks em Java: conhecendo o Mockito

## Testes com Mocks
> Mock é uma classe que simula o comportamento de outra classe.

As bibliotecas de Mock existem para para não termos que dedicar tanto trabalho escrevendo as classes Mock uma a uma, ao invés disso, a biblioteca usa algum recurso próprio, para criar essa classe dinamicamente e simula as dependências da classe que queremos testar.

### Vantagem de utilizar mocks ao escrever testes de unidade:
✅ <strong>Substituir dependências externas da classe</strong> - Mocks possuem o objetivo de simular comportamentos das dependências de uma classe, para que os testes de unidade não se tornem testes de integração.

## Iniciando com Mockito
### Maneiras de adicionar o Mockito à uma aplicação:
➡️ <strong>Baixando e adicionando seus jar’s na aplicação:</strong> Podemos baixar os jar’s do Mockito e adicioná-los ao build path da aplicação.

➡️ <strong>Declarando-o como dependência da aplicação:</strong> Utilizando o Maven, Gradle ou outra ferramenta de build/gestão de dependências.

> Uma forma para pedir ao Mockito para que crie um mock de uma determinada classe é:<br>
<strong>Mockito.mock(Classe.class)</strong>