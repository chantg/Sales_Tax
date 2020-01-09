//JUnit 5
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class tester {

	@Test
	public void salesCheck() throws Exception{
		
		Sales tester = new Sales();
		//Faulty 
		Assertions.assertThrows(NumberFormatException.class,() -> tester.run("faulty.txt"));

		Assertions.assertAll(() -> tester.run("Input3.txt"));
		Assertions.assertAll(() -> tester.run("Input.txt"));
		
		
	}
	
	@Test
	public void PurchaseCheck() throws Exception{
		
		String wrongPrice[] = {"1","book", "at", "twelvefortynine"};
		String wrongnumber[] = {"ear","book", "at", "12.49"};
		String longOrder[] = {"64","mile","car","shaped","pool","extension","Jefferey's","Special","Edition","for", ".2"};
		String multipleOrder[] = {"3","CD", "for", "12.50"};
		String medical[] = {"1", "blood", "for", "12.00"};
		String imported[] = {"3","imported","CD", "for", "12.50"};
		Sales tester = new Sales();
		
		//create Purchase with wrong price and another with wrong quantity format, 
		//throws exception as to not add to receipt total
		Assertions.assertThrows(NumberFormatException.class,() -> new Purchase(wrongnumber,tester.ex));
		Assertions.assertThrows(NumberFormatException.class,() -> new Purchase(wrongPrice,tester.ex));
		
		//Order with multiple orders
		Assertions.assertAll(() -> new Purchase(multipleOrder,tester.ex));
		Purchase purchase = new Purchase(multipleOrder,tester.ex);
		assertEquals(3.75 , purchase.getTaxes());
		assertEquals("41.25" , String.format( "%.2f", purchase.getTotal()));
		
		//higher taxes due to import
		purchase = new Purchase(imported,tester.ex);
		assertEquals(5.65 , purchase.getTaxes());
		assertEquals("43.15" , String.format( "%.2f", purchase.getTotal()));
		
		//order with multiple word object, also has many objects for a small price
		Assertions.assertAll(() -> new Purchase(longOrder,tester.ex));
		purchase = new Purchase(longOrder,tester.ex);
		assertEquals(1.3 , purchase.getTaxes());
		assertEquals("14.10" , String.format( "%.2f", purchase.getTotal()));
		
		//medical tax exemption
		purchase = new Purchase(medical,tester.ex);
		assertEquals(0 , purchase.getTaxes());
		assertEquals("12.00" , String.format( "%.2f", purchase.getTotal()));
		

	}

}