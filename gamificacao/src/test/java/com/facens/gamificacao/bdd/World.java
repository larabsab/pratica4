package com.facens.gamificacao.bdd;

import com.facens.gamificacao.model.Student;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@ScenarioScope
public class World {
    public List<Student> students = new ArrayList<>();
}
