import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class ConvertToWords {

	@Test
	public void TestWithWholeNumbers() {
		String result = "Four Only";
		assertEquals(result, ConvertToString.convertToWords(4));
		
		String result2 = "Twenty One Only";
		assertEquals(result2, ConvertToString.convertToWords(21));
		
		String result3 = "Four Hundred and Twenty Six Only";
		assertEquals(result3, ConvertToString.convertToWords(426));
		
		String result4 = "Three Thousand Four Hundred and Thirty Five Only";
		assertEquals(result4, ConvertToString.convertToWords(3435));
		
		String result5 = "Eighty Nine Thousand Four Hundred and Twenty Only";
		assertEquals(result5, ConvertToString.convertToWords(89420));
		
		String result6 = "Four Lakh Eighty Four Thousand Four Hundred and Twenty One Only";
		assertEquals(result6, ConvertToString.convertToWords(484421));
	}
	
	@Test
	public void TestWithDecimalNumbers() {
		String result = "Four Hundred and Fifty Six 56/100 ONLY";
		assertEquals(result, ConvertToString.convertToWords(456.56));
		
		String result2 = "Sixty Two Thousand Four Hundred and Fifty Six 56/100 ONLY";
		assertEquals(result2, ConvertToString.convertToWords(62456.56));

		String result3 = "One Lakh Sixty Two Thousand Four Hundred and Fifty Six 56/100 ONLY";
		assertEquals(result3, ConvertToString.convertToWords(162456.56));
	}

}
