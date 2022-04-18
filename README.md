# bitmap-api
## Sobre o projeto
É uma API desenvolvida com Java e Spring Boot que recebe como entrada no seu endpoint um vetor de números inteiros onde cada elemento desse vetor representa uma cor RGB de uma imagem.

## Algoritmo do bitmap-api
O algoritmo da API ler cada pixel da imagem e conta a quantidade de vezes em que cada elemento do vetor aparece em cada pixel da imagem. Caso algum elemento não tenha sido encontrado na imagem é retorna zero para esse elemento.

## Collection do Postman para bitmap-api
Importar o link no Postman: https://www.getpostman.com/collections/37867239afac5ae5591e

## Tecnologias utilizadas
- Java 11
- Spring (boot, web, validation)
- Lombok

## Como executar bitmap-api
### Pré-requisitos
Java

### Clonar o projeto
```bash
git clone https://github.com/LuisPaulo1/bitmap-api.git
```
### Entrar na pasta do projeto bitmap-api
```bash
cd bitmap-api
```
### Executar um dos comandos
./mvnw spring-boot:run ou mvn spring-boot:run ou importar o projeto em uma IDE e executar

### Informações adicionais sobre bitmap-api
- A imagem utilizada nesta API está fixa na pasta resources do projeto

# Autor

Luis Paulo

https://www.linkedin.com/in/luis-paulo-souza-a54358134/
