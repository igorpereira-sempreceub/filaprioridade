import java.util.ArrayList;
import java.util.List;

public class FilaPrioridade {

	private List<Elemento> fila;

	/**
	 * Constrói uma fila.
	 */
	public FilaPrioridade() {
		this.fila = new ArrayList<Elemento>();
	}

	/**
	 * Retorna o tamanho da fila.
	 * 
	 * @return o tamanho da fila.
	 */
	public Integer getTamanho() {
		return this.fila.size();
	}

	/**
	 * Adiciona um elemento na fila de acordo com a sua prioridade. Quanto MENOR a
	 * prioridade do elemento, mais ele deve ser colocado no início da fila. Se a
	 * prioridade for igual, a preferência é do elemento mais antigo na fila.
	 * 
	 * @param elemento o elemento adicionado.
	 */
	public void entrarNaFila(Elemento elemento) {
		int pos = 0;
		
		if(getTamanho() != 0) {
			for (int i = getTamanho() - 1; i >= 0; i--) {				
				if (elemento.getPrioridade() >= this.fila.get(i).getPrioridade()) {
					pos = i + 1;
					break;
				}
			}
		}
		
		this.fila.add(pos, elemento);
	}

	/**
	 * Retira um elemento da fila.
	 * 
	 * @return o elemento retirado.
	 * @throws Exception exceção levantada caso a fila esteja vazia.
	 */
	public Elemento sairDaFila() throws Exception {		
		if(getTamanho() != 0) {
			return this.fila.remove(0);					
		} else {
			throw new Exception("Fila vazia");
		}
	}

	/**
	 * Retorna a posição do elemento na fila.
	 * 
	 * @param elemento o elemento.
	 * @return a posição do elemento na fila.
	 */
	public Integer getPosicaoNaFila(Elemento elemento) {
		return this.fila.indexOf(elemento);
	}

	/**
	 * Retorna o elemento da posição especificada.
	 * 
	 * @param posicao a posição especificada.
	 * @return o elemento da posição especificada.
	 * @throws IndexOutOfBoundsException exceção lançada caso a posição seja <
	 *                                   0 ou >= tamanho da fila.
	 */
	public Elemento getElementoDaPosicao(Integer posicao) throws IndexOutOfBoundsException {
		if(posicao < 0 || posicao >= getTamanho()) {
			throw new IndexOutOfBoundsException("Valores maiores ou iguais a zero.");
		}else {
			return this.fila.get(posicao);			
		}
	}
}