package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.AlunoDTO;
import dev.fujioka.java.avancado.web.dto.BolsistaDTO;
import dev.fujioka.java.avancado.web.model.Bolsista;
import dev.fujioka.java.avancado.web.repository.BolsistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BolsistaService {

    @Autowired
    private BolsistaRepository bolsistaRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public BolsistaDTO salvar(Bolsista bolsista){
        bolsista = bolsistaRepository.save(bolsista);
        jmsTemplate.convertAndSend("nome_bolsista_queue",bolsista);
        return BolsistaDTO.builder()
                .nome(bolsista.getNome())
                .matricula(bolsista.getMatricula()).build();
    }

    public List<Bolsista> listarBolsistas(){
        return bolsistaRepository.findAll();
    }

    public Bolsista consultarPorId(int id){
        return bolsistaRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        bolsistaRepository.deleteById(id);
    }

    public Bolsista alterar(Bolsista bolsista){
        if(Objects.isNull(bolsista.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return bolsistaRepository.save(bolsista);
    }

    public List<Bolsista> buscarBolsistaLike(String nome){
        return bolsistaRepository.buscarBolsistaPorNomeLike(nome);
    }


}
