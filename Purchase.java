import java.util.ArrayList;
import java.util.Arrays;
//Purchase handles calculation of taxes as well as the check whether an item is tax exempt

public class Purchase{
	int number;
	double price;
	String object[];
	boolean imported;
	ArrayList<ArrayList<String>> exempt;
	
	//ensures a valid order was submitted valid orders looks like # of items,(optional) insured, object, ends with a double of the price
	
	@SuppressWarnings("unchecked")
	Purchase(String order[], ExemptItems ex) throws Exception{
		
		this.imported = order[1].toLowerCase().contentEquals("imported");

		this.object = Arrays.copyOfRange(order, 1, order.length-2);
				
		try {
			this.number = Integer.parseInt(order[0]);
			if(this.number < 0) {
				throw new NumberFormatException("Order "+ String.join(" ", this.object) +", amount was negative");
			}
		}
		catch( NumberFormatException e)
		{	throw e;	}
					
		try {
			//multiply the price of 1 item with how many items ordered
			this.price = Double.parseDouble(order[order.length-1]) * this.number;
			if(this.price < 0) {
				throw new NumberFormatException("Order "+ String.join(" ", this.object)+"Price was negative");
			}
		}
		catch( NumberFormatException e)
		{	throw e;	}
		this.exempt = (ArrayList<ArrayList<String>>) ex.exempt.clone();
	}
	
	boolean exempt() {
		for(int i = 0; i < this.object.length; ++i)
		{		
			//gets unicode value of the first letter I subtract 10 since the value for a is 10
			for(int j = 0; j < this.exempt.get(Character.getNumericValue(this.object[i].charAt(0))-10).size()
					;++j) {
				//If the current word is found among the exempt word return that it is exempt
				if(this.exempt.get(Character.getNumericValue(this.object[i].charAt(0))-10).get(j).contentEquals(this.object[i])) {
					return true;
				}
			}
		}
		return false;
	}
	
	double getTaxes() {

		double tax =0.0;
		double taxes = 0.0;
		if(this.imported)
		{
			tax = (.05 * getTotal());
			//below rounds the tax to the nearest .05
			taxes += Math.ceil(tax * 20.0)/20.0;

		}
		
		if(!exempt()) {
			//if not tax exempt
			tax = (.1 * getTotal());

			taxes += Math.ceil(tax * 20.0)/20.0;

		}
		this.price += taxes;
		//if it was an invalid input don't include it in the taxes charge
		return taxes;
	}
	
	public double getTotal(){
		return this.price;
	}
	
	//prints out the formatted individual item
	public void print() {
		System.out.println(this.number +  (imported ? " imported ": " ") +
				String.join(" ", this.object)+ ": "+ String.format( "%.2f", getTotal() ));
	}
}
