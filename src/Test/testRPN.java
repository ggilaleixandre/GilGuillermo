package Test;
import junit.framework.TestCase;
import org.junit.Test;
import calculadora.RPN;



public class testRPN extends TestCase{

	@Test
	public void testRPN() {

		RPN calc = new RPN("4 4 +");
		assertEquals(8.000000D, calc.resultado());
		calc = new RPN("4 4 4 + +");
		assertEquals(12.000000D, calc.resultado());
		calc = new RPN("4 4 -");
		assertEquals(0.000000D, calc.resultado());
		calc = new RPN("4 4 4 - -");
		assertEquals(4.000000D, calc.resultado());
		calc = new RPN("4 4 *");
		assertEquals(16.000000D, calc.resultado());
		calc = new RPN("4 4 4 * *");
		assertEquals(64.000000D, calc.resultado());
		calc = new RPN("4 4 /");
		assertEquals(1.000000D, calc.resultado());
		calc = new RPN("4 4 4 / /");
		assertEquals(4.000000D, calc.resultado());
		calc = new RPN("4 4 %");
		assertEquals(0.000000D, calc.resultado());
		calc = new RPN("4 4 ^");
		assertEquals(256,000000, calc.resultado());
	}



}

