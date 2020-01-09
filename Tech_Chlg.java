
public class Tech_Chlg{
	
	public static void main(String args[]) throws Exception {
		if(args.length == 0)
	    {
			//if no arguments given then run the first 3 input examples
			Sales def = new Sales();
			String test[] = {"Input1.txt" , "Input2.txt" , "Input3.txt"};
			def.run(test[0]);
			def.run(test[1]);
			def.run(test[2]);
	    }
		else
		{
			Sales a = new Sales();
			a.run(args[0]);
		}
		
	}


}
