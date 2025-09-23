package com.facens.gamificacao.bdd;

import com.facens.gamificacao.model.Student;
import com.facens.gamificacao.service.RewardService;
import io.cucumber.java.pt.*;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class RewardSteps { 

    @Autowired
    private World world;

    private RewardService service = new RewardService();

    @Dado("um aluno chamado {string} com {int} comentários e {int} cursos disponíveis")
    public void um_aluno_chamado_com_comentarios_e_cursos(String name, Integer comments, Integer courses) {
        world.students.add(new Student(world.students.size() + 1, name, comments, courses));
    }

    @Dado("outro aluno chamado {string} com {int} comentários e {int} curso disponível")
    public void outro_aluno_chamado_com_comentarios_e_curso(String name, Integer comments, Integer courses) {
        um_aluno_chamado_com_comentarios_e_cursos(name, comments, courses);
    }

    @Quando("o mês termina e as recompensas são processadas")
    public void o_mes_termina_e_as_recompensas_sao_processadas() {
        service.processMonthEnd(world.students);
    }

    @Então("{string} deve ter {int} cursos disponíveis")
    public void deve_ter_cursos_disponiveis(String studentName, Integer expectedCourses) {
        Student foundStudent = world.students.stream()
            .filter(s -> s.getName().equals(studentName))
            .findFirst()
            .orElse(null);

        assert foundStudent != null;
        assertEquals(expectedCourses, foundStudent.getAvailableCourses(), "A contagem de cursos para " + studentName + " está incorreta.");
    }
}