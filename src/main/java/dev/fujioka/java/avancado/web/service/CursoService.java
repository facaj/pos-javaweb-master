package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.BolsistaDTO;
import dev.fujioka.java.avancado.web.dto.CursoDTO;
import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private JmsTemplate jmsTemplate;
    public CursoDTO salvar(Curso curso){
        curso = cursoRepository.save(curso);
        jmsTemplate.convertAndSend("nome_curso_queue",curso);
        return CursoDTO.builder()
                .nome(curso.getNome())
                .professor(curso.getProfessor()).build();
    }

    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    public Curso consultarPorId(int id){
        return cursoRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        cursoRepository.deleteById(id);
    }

    public Curso alterar(Curso Curso){
        if(Objects.isNull(Curso.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return cursoRepository.save(Curso);
    }

    public List<Curso> buscarCursoLike(String nome){
        return cursoRepository.buscarCursoPorNomeLike(nome);
    }

    public List<Curso> buscarCursoPorProfessorLike(String professor){
        return cursoRepository.buscarCursoPorProfessorLike(professor);
    }

    public List<Curso> buscarCursoPorDescricaoLike(String descricao){
        return cursoRepository.buscarCursoPorDescricaoLike(descricao);
    }
}
