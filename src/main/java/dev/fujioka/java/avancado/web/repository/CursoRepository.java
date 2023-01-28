package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("select a from Curso a order by a.nome ASC")
    public List<Curso> listarOrdernadoPorNome();
    public List<Curso> findAllByOrderByNomeAsc();

    @Query("select a from Curso a where a.nome like %:nome% ")
    public List<Curso> buscarCursoPorNomeLike(@Param("nome") String nome);
    @Query("select a from Curso a where a.professor like %:professor% ")
    public List<Curso> buscarCursoPorProfessorLike(@Param("professor") String professor);

    @Query("select a from Curso a where a.descricao like %:descricao% ")
    public List<Curso> buscarCursoPorDescricaoLike(@Param("descricao") String descricao);
}
