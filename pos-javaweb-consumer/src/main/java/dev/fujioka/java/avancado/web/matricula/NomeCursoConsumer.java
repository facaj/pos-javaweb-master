package dev.fujioka.java.avancado.web.matricula;

import dev.fujioka.java.avancado.web.model.Curso;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NomeCursoConsumer {

    @JmsListener(destination = "nome_curso_queue")
    public void receiveMessage(Curso curso) {

        System.out.println("Mensagem da fila do curso:" + curso.getNome());
    }
}
