/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javaapplication1.src.br.calebe.exemplos.ex01.Carrinho;
import javaapplication1.src.br.calebe.exemplos.ex01.CarrinhoVazioExpected;
import javaapplication1.src.br.calebe.exemplos.ex01.Produto;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 30850509
 */
public class CarrinhoTeste2 {
    
    
	private Carrinho carrinho;

	@Before
	public void criandoCarrinho() {
		carrinho = new Carrinho();
	}

	@Test(expected = CarrinhoVazioExpected.class)
	public void colocandoZeroProduto() throws CarrinhoVazioExpected {
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { null }, new Object[] { menor });
	}

	@Test
	public void colocandoUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
                
	}

	@Test
	public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
                Produto menor;
                
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
                menor = carrinho.menorProduto();
                assertArrayEquals(new Object[] { livro }, new Object[] { menor });
                assertArrayEquals(new Object[] { livro }, new Object[] { carrinho.ultimoProduto() });
                
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
                menor = carrinho.menorProduto();
                assertArrayEquals(new Object[] { livro }, new Object[] { menor });
                assertArrayEquals(new Object[] { deitel }, new Object[] { carrinho.ultimoProduto() });
                
                Produto caneta = new Produto("BIC",2.50);
                carrinho.add(caneta);
                menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { caneta }, new Object[] { menor });
                assertArrayEquals(new Object[] { caneta }, new Object[] { carrinho.ultimoProduto() });
	}

        @Test
        public void listarProdutos() throws CarrinhoVazioExpected
        {
                Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
                Produto caneta = new Produto("BIC",2.50);
                carrinho.add(caneta);
		Produto menor;
                menor = carrinho.menorProduto();
                assertArrayEquals(new Object[] { caneta }, new Object[] { menor });
                assertArrayEquals(new Object[] { livro, deitel, caneta }, carrinho.getProdutos().toArray());
        }
        
        @Test
        public void removerProduto()
        {
            Produto livro = new Produto("Java em 24 horas", 50.00);
            carrinho.removerProduto(livro);
            assertArrayEquals( new Object[] {  } , carrinho.getProdutos().toArray());
            
            carrinho.add(livro);
            
            Produto deitel = new Produto("Javal: Como programar", 150.00);
            carrinho.add(deitel);
            
            carrinho.removerProduto(livro);
            
            assertArrayEquals(new Object[] { deitel }, carrinho.getProdutos().toArray());            
        }
        
        @Test
        public void calcularTotal()
        {   
            assertEquals(0, carrinho.getTotal(), 0);
            
            Produto livro = new Produto("Java em 24 horas", 50.00);
            carrinho.add(livro);
            
            assertEquals(50.00, carrinho.getTotal(), 0);
            
            Produto deitel = new Produto("Java: Como programar", 150.00);
            carrinho.add(deitel);
            
            assertEquals(200.00, carrinho.getTotal(), 0);
            
            Produto BIC = new Produto("Caneta esferografica", 2.50);
            carrinho.add(BIC);
            
            assertEquals(202.50, carrinho.getTotal(), 0);
            
        }
        
	@Test
	public void identidadeDeProdutos() throws CarrinhoVazioExpected {
		Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
		Produto copia = new Produto("Java em 24 horas", 50.00);
		original = carrinho.menorProduto();
		assertArrayEquals(new Object[] { original }, new Object[] { copia });
	}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
