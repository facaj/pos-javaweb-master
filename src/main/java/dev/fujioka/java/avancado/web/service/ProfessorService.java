package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.CursoDTO;
import dev.fujioka.java.avancado.web.dto.ProfessorDTO;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private JmsTemplate jmsTemplate;
    public ProfessorDTO salvar(Professor professor){
        professor = professorRepository.save(professor);
        jmsTemplate.convertAndSend("nome_professor_queue",professor);
        return ProfessorDTO.builder()
                .nome(professor.getNome())
                .especialidade(professor.getEspecialidade()).build();
    }

    public List<Professor> listarProfessors(){
        return professorRepository.findAll();
    }

    public Professor consultarPorId(int id){
        return professorRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        professorRepository.deleteById(id);
    }

    public Professor alterar(Professor Professor){
        if(Objects.isNull(Professor.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return professorRepository.save(Professor);
    }

    public List<Professor> buscarProfessorLike(String nome){
        return professorRepository.buscarProfessorPorNomeLike(nome);
    }

    public List<Professor> buscarProfessorPorEspecialidadeLike(String especialidade){
        return professorRepository.buscarProfessorPorEspecialidadeLike(especialidade);
    }
}
