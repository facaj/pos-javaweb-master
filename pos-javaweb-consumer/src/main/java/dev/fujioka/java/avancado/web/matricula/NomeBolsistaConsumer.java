package dev.fujioka.java.avancado.web.matricula;

import dev.fujioka.java.avancado.web.model.Bolsista;
import dev.fujioka.java.avancado.web.model.Professor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NomeBolsistaConsumer {

    @JmsListener(destination = "nome_bolsista_queue")
    public void receiveMessage(Bolsista bolsista) {

        System.out.println("Mensagem da fila do bolsista:" + bolsista.getNome());
    }
}
