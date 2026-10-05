# 🗺️ Algoritmo de Dijkstra em Java

Implementação do **algoritmo de Dijkstra**, que encontra o **caminho mais curto** entre duas cidades
num mapa com estradas e distâncias. Feito no curso de **Análise e Desenvolvimento de Sistemas (Unisul)**.

## 🧠 Como funciona

O mapa tem **6 cidades (0 a 5)**, guardado numa **matriz de adjacência**: `D[i][j]` é a distância
entre a cidade `i` e a `j`, e `0` quer dizer que não tem estrada entre elas.

```
        0     1     2     3     4     5
  0  [  0,  100,   15,    0,    0,    0 ]
  1  [100,    0,   40,  180,  200,    0 ]
  2  [ 15,   40,    0,   45,   90,    0 ]
  3  [  0,  180,   45,    0,    0,  101 ]
  4  [  0,  200,   90,    0,    0,  120 ]
  5  [  0,    0,    0,  101,  120,    0 ]
```

Passo a passo do algoritmo:

1. Começa na cidade de **origem** com distância 0. Todas as outras começam com "infinito" (10000).
2. **Expande** a cidade atual: para cada vizinha, calcula a distância passando por ela e guarda se for menor.
3. Marca a cidade atual como **expandida** e escolhe a próxima: a não expandida com **menor distância**.
4. Repete até chegar ao **destino**. O vetor `Ant` guarda de onde veio cada cidade, e é assim que o caminho é montado no final.

## 💡 Exemplo

Da cidade **0** até a **5**:

```
Caminho: 0 → 2 → 3 → 5
Distância total: 161  (15 + 45 + 101)
```

## ▶️ Como rodar

O código está em [`src/Dijkstra.java`](src/Dijkstra.java). Com Java 11 ou mais novo:

```bash
java src/Dijkstra.java
```

Abre uma janelinha pedindo a cidade de origem e a de destino (0 a 5) e mostra o caminho e a distância.

Também dá pra abrir a pasta como projeto no **NetBeans**.

---

Outros exercícios: [exercicios-java](https://github.com/MateusZanela08/exercicios-java)
