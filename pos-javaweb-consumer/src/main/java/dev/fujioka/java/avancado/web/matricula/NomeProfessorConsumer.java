package dev.fujioka.java.avancado.web.matricula;

import dev.fujioka.java.avancado.web.model.Professor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NomeProfessorConsumer {

    @JmsListener(destination = "nome_professor_queue")
    public void receiveMessage(Professor professor) {

        System.out.println("Mensagem da fila do professor:" + professor.getNome());
    }
}
