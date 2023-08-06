Esse é um exemplo de projeto bem básico que utiliza algumas ferramentas. Ele pode ser melhorado em diferentes aspectos e portanto não deve ser visto como um guia definitivo a ser seguido.

**Considere a seguinte descrição em alto nível da funcionalidade do código:**  
> Sistema de reservas de quartos de um hotel. Podendo adicionar e remover as reservas dos quartos, e ainda listar todas a reservar do Hotel

## **Instruções para execução**
```
'a n_quarto data_entrada data_saida' adiciona uma reserva no para o quarto informado
'r n_quarto data_entrada' remove uma reserva para o quarto informado
'p' imprimir informações do hotel  
```
**Atenção: o formato da data deve ser DD/MM/YYYY**

## **Ferramentas**

Esse projeto utiliza as seguintes linguagem, ferramentas e bibliotecas:

* Linguagem: [Java](https://docs.oracle.com/en/java/)
* Compilação: [Gradle](https://gradle.org/)
* Documentação: [Doxygen](https://doxygen.nl/)
* Testes Unitários: [JUnit 5](https://junit.org/junit5/)
* Cobertura: [JaCoCo](https://www.jacoco.org/jacoco/)


## **Execução**

```bash
gradle run
```

Arquivo de exemplo
```bash
gradle run < app/doc/input.txt
```

## **Execução Testes**

```bash
gradle test
```

Reporte do teste encontra-se em **app/build/reports/tests/test/index.html**

## **Relatório de Cobertura**

O relatório de cobertura encontra-se em **app/build/jacocoHtml/index.html** após executar os teste.

## **Build**

```bash
gradle build
```

## **Documentação**

Para gerar a documentação:

```bash
doxygen Doxyfile
```
Documentação encontra-se em **app/doc/doxygen/**

## **Remover arquivos auxiliares**
```bash
gradle clean
```