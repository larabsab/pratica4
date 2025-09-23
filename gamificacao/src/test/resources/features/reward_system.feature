#language: pt
Funcionalidade: Sistema de Recompensa por Atividade no Fórum

  Cenário: Aluno mais ativo do mês recebe um curso extra
    Dado um aluno chamado "Lara" com 15 comentários e 2 cursos disponíveis
    E outro aluno chamado "Joao" com 5 comentários e 1 curso disponível
    Quando o mês termina e as recompensas são processadas
    Então "Lara" deve ter 3 cursos disponíveis
    E "Joao" deve ter 1 curso disponível

  Cenário: Aluno que não é o mais ativo não recebe curso extra
    Dado um aluno chamado "Ana" com 10 comentários e 1 curso disponível
    E outro aluno chamado "Carlos" com 20 comentários e 3 cursos disponíveis
    Quando o mês termina e as recompensas são processadas
    Então "Ana" deve ter 1 curso disponível
    E "Carlos" deve ter 4 cursos disponíveis