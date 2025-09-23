# Projeto Gamificação para Plataforma EAD

## User Story

**COMO** uma aluna da plataforma,
**QUERO** que o sistema conte meus comentários no fórum,
**PARA** ganhar um curso extra no final do mês quando eu for a aluna mais ativa.

## BDD (Behavior-Driven Development) - Cenários de Aceite

### Funcionalidade: Recompensa para Aluno Mais Ativo no Fórum

#### Cenário 1: Aluno mais ativo recebe recompensa
**Dado que** um aluno deve receber um curso extra
**E** ele é o aluno com mais comentários no fósim
**Quando** o mês termina
**Então** o aluno deve receber um curso extra
**E** o curso deve ser adicionado à sua conta.

#### Cenário 2: Aluno que não é o mais ativo não recebe recompensa
**Dado que** um aluno fez 10 comentários no fórum no mês
**E** ele não é o aluno com mais comentários
**Quando** o mês termina
**Então** o aluno não deve receber um curso extra
**E** sua conta deve permanecer inalterada.
