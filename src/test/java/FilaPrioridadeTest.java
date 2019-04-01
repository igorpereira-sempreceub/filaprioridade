
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilaPrioridadeTest {

	private FilaPrioridade fila;

	@Before
	public void setUp() {
		fila = new FilaPrioridade();
	}

	@Test
	public void constructorTest() {

		Assert.assertTrue(fila.getTamanho() == 0);

	}

	@Test
	public void getTamanhoTest() {
		Assert.assertTrue(fila.getTamanho() == 0);

		fila.entrarNaFila(new Elemento(1, 1));
		Assert.assertTrue(fila.getTamanho() == 1);

		fila.entrarNaFila(new Elemento(2, 2));
		Assert.assertTrue(fila.getTamanho() == 2);

		fila.entrarNaFila(new Elemento(3, 3));
		Assert.assertTrue(fila.getTamanho() == 3);

		fila.entrarNaFila(new Elemento(4, 4));
		Assert.assertTrue(fila.getTamanho() == 4);

	}

	@Test
	public void entrarNaFilaPrioridadeNormalTest() {

		Elemento elemento1 = new Elemento(1, 1);
		Elemento elemento2 = new Elemento(2, 2);
		Elemento elemento3 = new Elemento(3, 3);
		Elemento elemento4 = new Elemento(4, 4);

		fila.entrarNaFila(elemento1);
		fila.entrarNaFila(elemento2);
		fila.entrarNaFila(elemento3);
		fila.entrarNaFila(elemento4);

		Assert.assertTrue(fila.getTamanho() == 4);

		Assert.assertTrue(fila.getPosicaoNaFila(elemento1) == 0);
		Assert.assertTrue(fila.getPosicaoNaFila(elemento2) == 1);
		Assert.assertTrue(fila.getPosicaoNaFila(elemento3) == 2);
		Assert.assertTrue(fila.getPosicaoNaFila(elemento4) == 3);

	}
	
	@Test
	public void entrarNaFilaValidandoPrioridadeTest() {

		Elemento elemento1 = new Elemento(1, 4);
		Elemento elemento2 = new Elemento(2, 3);
		Elemento elemento3 = new Elemento(3, 2);
		Elemento elemento4 = new Elemento(4, 1);

		fila.entrarNaFila(elemento1);
		fila.entrarNaFila(elemento2);
		fila.entrarNaFila(elemento3);
		fila.entrarNaFila(elemento4);

		Assert.assertTrue(fila.getTamanho() == 4);

		Assert.assertTrue(fila.getPosicaoNaFila(elemento1) == 3);
		Assert.assertTrue(fila.getPosicaoNaFila(elemento2) == 2);
		Assert.assertTrue(fila.getPosicaoNaFila(elemento3) == 1);
		Assert.assertTrue(fila.getPosicaoNaFila(elemento4) == 0);

	}

	@Test
	public void sairDaFilaTest() throws Exception {
		Elemento elemento1 = new Elemento(1, 1);
		Elemento elemento2 = new Elemento(2, 2);
		Elemento elemento3 = new Elemento(3, 3);
		Elemento elemento4 = new Elemento(4, 4);

		fila.entrarNaFila(elemento1);
		fila.entrarNaFila(elemento2);
		fila.entrarNaFila(elemento3);
		fila.entrarNaFila(elemento4);

		Assert.assertTrue(fila.getTamanho() == 4);

		Elemento elementoPosicao = fila.getElementoDaPosicao(0);
		Elemento elemento = fila.sairDaFila();
		Assert.assertTrue(fila.getTamanho() == 3);
		Assert.assertEquals(elemento, elementoPosicao);

		elementoPosicao = fila.getElementoDaPosicao(0);
		elemento = fila.sairDaFila();
		Assert.assertTrue(fila.getTamanho() == 2);
		Assert.assertEquals(elemento, elementoPosicao);

		elementoPosicao = fila.getElementoDaPosicao(0);
		elemento = fila.sairDaFila();
		Assert.assertTrue(fila.getTamanho() == 1);
		Assert.assertEquals(elemento, elementoPosicao);

		elementoPosicao = fila.getElementoDaPosicao(0);
		elemento = fila.sairDaFila();
		Assert.assertTrue(fila.getTamanho() == 0);
		Assert.assertEquals(elemento, elementoPosicao);

	}

	@Test(expected = Exception.class)
	public void sairDaFilaExceptionTest() throws Exception {

		fila.sairDaFila();
	}

	@Test
	public void getPosicaoNaFilaTest() {
		Elemento elemento0 = new Elemento(0, 0);
		Elemento elemento1 = new Elemento(1, 1);
		Elemento elemento2 = new Elemento(2, 2);
		Elemento elemento3 = new Elemento(3, 3);
		Elemento elemento4 = new Elemento(4, 4);
		Elemento elemento5 = new Elemento(5, 5);

		fila.entrarNaFila(elemento1);
		fila.entrarNaFila(elemento2);
		fila.entrarNaFila(elemento3);
		fila.entrarNaFila(elemento4);

		Assert.assertTrue(fila.getTamanho() == 4);

		Integer posicao = fila.getPosicaoNaFila(elemento0);
		Assert.assertTrue(posicao == -1);

		posicao = fila.getPosicaoNaFila(elemento1);
		Assert.assertTrue(posicao == 0);

		posicao = fila.getPosicaoNaFila(elemento2);
		Assert.assertTrue(posicao == 1);

		posicao = fila.getPosicaoNaFila(elemento3);
		Assert.assertTrue(posicao == 2);

		posicao = fila.getPosicaoNaFila(elemento4);
		Assert.assertTrue(posicao == 3);

		posicao = fila.getPosicaoNaFila(elemento5);
		Assert.assertTrue(posicao == -1);

	}

	@Test
	public void getElementoDaPosicaoTest() {
		Elemento elemento1 = new Elemento(1, 4);
		Elemento elemento2 = new Elemento(2, 3);
		Elemento elemento3 = new Elemento(3, 2);
		Elemento elemento4 = new Elemento(4, 1);

		fila.entrarNaFila(elemento1);
		fila.entrarNaFila(elemento2);
		fila.entrarNaFila(elemento3);
		fila.entrarNaFila(elemento4);

		Assert.assertTrue(fila.getTamanho() == 4);

		Elemento elemento = fila.getElementoDaPosicao(0);
		Assert.assertTrue(elemento.equals(elemento4));

		elemento = fila.getElementoDaPosicao(1);
		Assert.assertTrue(elemento.equals(elemento3));

		elemento = fila.getElementoDaPosicao(2);
		Assert.assertTrue(elemento.equals(elemento2));

		elemento = fila.getElementoDaPosicao(3);
		Assert.assertTrue(elemento.equals(elemento1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getElementoDaPosicaoOutOfBoundsTest() {
		Elemento elemento1 = new Elemento(1, 1);
		Elemento elemento2 = new Elemento(2, 2);
		Elemento elemento3 = new Elemento(3, 3);
		Elemento elemento4 = new Elemento(4, 4);

		fila.entrarNaFila(elemento1);
		fila.entrarNaFila(elemento2);
		fila.entrarNaFila(elemento3);
		fila.entrarNaFila(elemento4);

		Assert.assertTrue(fila.getTamanho() == 4);

		fila.getElementoDaPosicao(4);
		fila.getElementoDaPosicao(-1);
	}
}
