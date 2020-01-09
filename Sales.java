import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sales {
	public ExemptItems ex;
	String file;
	
	public static boolean typeCheck(String file)
	//checks filename after '.' to ensure file type is .txt
	{
		int i = file.lastIndexOf('.');
		if (i >= 0) 
		{ 
			return(file.substring(i+1).contentEquals("txt"));
		}
		
		return false;
	}
	
	
	public void run(String arg) throws Exception {
		
		
		File file = new File(System.getProperty("user.dir") + '\\' + arg); 
		
		if(!typeCheck(arg))
		{
			System.out.println(arg+" is not a text file");
			System.exit(0);
		}
		else if(!file.exists()) {
		    System.out.println(arg + " cant be found");
		    System.exit(0);
		} 

		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 
		double total = 0.0; 
		double taxes = 0.0;
		
		while ((st = br.readLine()) != null) {
			//input is split and later processed in Purchase
			String order[] =st.split(" ");
			Purchase pur = new Purchase(order, ex);
			
			total += pur.getTotal();
			taxes += pur.getTaxes();
			
			pur.print();
			
		}
		
		total+= taxes;
		System.out.println("Sales Taxes: " + String.format( "%.2f", taxes ));
		System.out.println("Total: " + String.format( "%.2f", total )+'\n');
		br.close();
	}
	
	
	Sales() throws Exception {
		this.ex = new ExemptItems();
	}

}
