# Imersão Java 2

Repositório contendo os projetos realizados na 2a edição da Imersão Java da Alura.

## Cronograma
Aula 1 - Consumindo uma API de filmes com Java
Aula 2 - Gerando figurinhas para WhatsApp
Aula 3 - Ligando as pontas, refatoração e orientação a objetos
Aula 4 - Criando nossa própria API com Spring
Aula 5 - Publicando nossa API na Cloud



### Aula 1 -> imdb-api

Nessa aula foi utilizada a API pública do site IMDB com o endpoint `top250movies`.
<br>
Com o pacote `java.net.http` foram realizados:
1. A conexão com a API.
2. A extração dos dados com uma classe própria disponibilizada em aula.
3. A impressão em tela dos seguintes dados do sfilmes: título, imagem, pontuação.
4. Com o desafio proposto pelos mentores foi refatorada a pontuação de modo a possuir um melhor layout com cores e emojis.

#### Imagem do println do projeto da Aula 1
![Aula_1](https://github.com/pctmoraes/imersao-java-2/blob/main/imdb-api/img/aula_1.png)

### Aula 2 -> Gerando stickers

Nessa aula foi desenvolvida uma nova classe para gerar stickers (para whatsapp, telegram etc) a partir dos pôsters dos filmes recuperados via api da Aula 1.

#### Imagem do sticker da Aula 2 (Your Name)

![Aula_2](https://github.com/pctmoraes/imersao-java-2/blob/main/imdb-api/img/aula_2.png)