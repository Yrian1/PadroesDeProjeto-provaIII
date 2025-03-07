O padrão principal para resolver o problema em relação a flexibilidade na mudança das regras de notificação foi o Chain of responsability, onde a classe Handler.java, define a abstração que os handlers da cadeia de responsabilidade irão obedecer. As demais classes do pacote br.edu.ifba.inf011.model.cor, com exceção do notificador.java são as concretudes, isto é, as regras a serem aplicadas sobre determinado evento. A classe notificador, condensa a cadeia de responsabilidade em um só objeto. Além disso o padrão strategy se faz presente dentro das proprias classes Handler's

"O Strategy é um padrão de projeto comportamental que permite que você defina uma família de algoritmos, coloque-os em classes separadas, e faça os objetos deles intercambiáveis." 
- https://refactoring.guru/pt-br/design-patterns/strategy

Done by: Yago Rian e Gabriel Andrade,
para a disciplina de padrões de projeto, turma do semestre de 2024.2, em nome do docente Frederico Barbosa.
