package lab5b;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class DaoProfessorTest extends TestCase {

	private ProfessorDao profDaoTeste = new ProfessorDao();
    private Professor profTest = new Professor(1, "123456", "Adm", "dd/mm/aaaa");

    @Test
    public void testSave() {

    	profDaoTeste.save(profTest);

        int resultadoEsperado = 1;
        int resultado = profDaoTeste.getAll().size();

        assertEquals(resultadoEsperado, resultado);

    }

    @Test
    public void testUpdate() {

    	profDaoTeste.save(profTest);
    	profDaoTeste.update(new Professor(1, "123456", "Contabeis", "dd/mm/aaaa"));

        boolean resultadoEsperado = true;
        boolean resultado = profTest.getFormacao().contains("Contabeis");

        assertEquals(resultadoEsperado, resultado);

    }

    @Test
    public void testeGetAll(){

        int resultadoEsperado = 0;
        int resultado = profDaoTeste.getAll().size();

        assertEquals(resultadoEsperado, resultado);

    }

    @Test
    public void testDelete() {

    	profDaoTeste.save(profTest);
    	profDaoTeste.delete(profTest);
    	profDaoTeste.getAll();

        int resultadoEsperado = 0;
        int resultado = profDaoTeste.getAll().size();

        assertEquals(resultadoEsperado, resultado);

    }
}