package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import program.Convert;


class ConvertTest {
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {

    }
    
	@Test
	public void testNegative2sComp() {
		char data[] = {'1', '0', '1', '0', '0'};
		assertEquals(-12, Convert.convert2sCompToDecimal(data));
	}
	
	@Test
	public void testPositive2sComp() {
		char data[] = {'0', '0', '1', '0', '0'};
		assertEquals(4, Convert.convert2sCompToDecimal(data));
	}
	
	@Test
	public void testPositiveDecimal() {
		int num = 12;
		assertArrayEquals(new char[]{'1', '1', '0', '0'}, Convert.convertDecimalTo2sComp(num));
	}

}
