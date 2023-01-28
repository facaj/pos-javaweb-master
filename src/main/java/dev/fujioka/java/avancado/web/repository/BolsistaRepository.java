package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.model.Bolsista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BolsistaRepository extends JpaRepository<Bolsista, Integer> {

    @Query("select a from Bolsista a order by a.nome ASC")
    public List<Bolsista> listarOrdernadoPorNome();
    public List<Bolsista> findAllByOrderByNomeAsc();

    @Query("select a from Bolsista a where a.nome like %:nome% ")
    public List<Bolsista> buscarBolsistaPorNomeLike(@Param("nome") String nome);
    public Bolsista findByMatricula(String matricula);

    public Bolsista findByMatriculaAndNome(String matricula, String nome);

}
