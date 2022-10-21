package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

        @RunWith(SpringRunner.class)
        @DataJpaTest
        //@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) DIZENDO AO SPRING PARA NAO SUBSTITUIR AS CONFIG DO DB, CASO FOSSE ULTILIZAR UM BANCO Q NAO SEJA EM MEMORIA
@ActiveProfiles("test")
public class    CursoRepositoryTest extends TestCase {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private TestEntityManager em;

//    @Test
//    public void deveriaCarregarCursoPorBuscaDeNome() {
//
//
//        String nomeCurso = "HTML 5";
//        Curso curso = repository.findByNome(nomeCurso);
//
//        Assert.assertNotNull(curso);
//        Assert.assertEquals(nomeCurso, curso.getNome());
//
//
//    }

    @Test
    public void naodDveriaCarregarCursoCOmNomeNaoCadastrado() {

        String nomeCurso = "JPA";

        Curso html5 = new Curso();
        html5.setNome(nomeCurso);
        html5.setCategoria("Programacao");
        em.persist(html5);

        Curso curso = repository.findByNome(nomeCurso);

        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso, curso.getNome());

//        Curso curso = repository.findByNome(nomeCurso);
//        Assert.assertNull(curso);
    }

}