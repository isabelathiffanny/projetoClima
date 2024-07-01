#### Autora

- **Nome:** Isabela Thiffanny **Matrícula:** UC22200977

---
#### Ambiente

- **Linguagem:** Java
- **Gerenciador de dependências:** Maven

---
# Descrição

O projeto consiste de 4 PROGRAMAS DIFERENTES que processam dados climáticos de 27 capitais brasileiras por meio de requisições HTTP da API open meteo (https://open-meteo.com/en/docs).

Durante a execução, são mostradas as temperaturas média, mínima e máxima de cada dia para cada uma das cidades.
Foram requisitadas as temperaturas de 15 dias, contadas a partir de "hoje" (Dia 01).

O que diferencia um programa do outro é a quantidade threads

**Objetivo:** comparar o desempenho entre os programas, calculando a média dos tempos de execução (depois de 10 rodadas).

### Programas

#### 1. ProjetoClima

O 1º programa contém uma única thread (main), que é responsável pela requisição de todas as 27 capitais brasileiras.

#### 2. ProjetoClima3

O 2º programa contém 3 threads, cada uma sendo responsável pela requisição de 9 capitais.

#### 3. ProjetoClima9

O 3º programa contém 9 threads, cada uma sendo responsável pela requisição de 3 capitais.

#### 4. ProjetoClima27

O 4º programa contém 27 threads, cada uma sendo responsável pela requisição de 1 capital.
