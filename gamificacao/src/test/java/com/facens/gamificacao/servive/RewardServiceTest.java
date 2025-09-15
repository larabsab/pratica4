package com.facens.gamificacao.servive;

import com.facens.gamificacao.model.Student;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class RewardServiceTest {

    @Test
    void dadoAlunoMaisAtivo_quandoMesTermina_entaoRecebeCursoExtra() {
        // Arrange
        Student lara = new Student(1, "Lara", 15, 2);
        Student joao = new Student(2, "Joao", 5, 1);
        List<Student> students = Arrays.asList(lara, joao);
        RewardService service = new RewardService();

        // Action
        service.processMonthEnd(students);

        assertEquals(3, lara.getAvailableCourses(), "Aluno mais ativo deve receber 1 curso extra");
    }

    @Test
    void dadoAlunoCom10Comentarios_masNaoMaisAtivo_quandoMesTermina_naoRecebeExtra() {
        // Arrange
        Student ana = new Student(1, "Ana", 10, 1);
        Student carlos = new Student(2, "Bruno", 20, 3); 
        List<Student> students = Arrays.asList(ana, carlos);
        RewardService service = new RewardService();

        // Action
        service.processMonthEnd(students);

        assertEquals(1, ana.getAvailableCourses(), "Aluno com 10 comentários mas não o mais ativo não deve receber curso extra");
    }
}
