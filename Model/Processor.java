import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;


public class Processor {
	
	private static Triplet<Double, Double, Character> triplet;
	private static List<Double> numbers;
	private static List<Character> symbols;

	public Processor(){
		numbers = new ArrayList();
		symbols = new ArrayList();
	}


	public static double makeOperation(char symbol, double first, double second){
	
		double result = 0;
		switch(symbol){
			case '+': result = first+second;break;
			case '-': result = first-second;break;
			case 'x': result = first*second;break;
			case '÷': result = first/second;break;
			default: result =  -1;
		}
		return result;
	}

	private static void  matchor(String digit){
		
		Pattern nums = Pattern.compile("(\\d)(\\d)*");
		Pattern syms = Pattern.compile("\\D");
		Matcher nu = nums.matcher(digit);
		Matcher sy = syms.matcher(digit);
		//System.out.println("It finds="+m.find());
		//System.out.println("It matches="+m.groupCount());
		int matchQuantity = nu.groupCount();
		
		for(int i=0;i<matchQuantity;++i){
			numbers.add(
Double.valueOf(nu.group(i)));
			if(i != matchQuantity-1){
			String symb = sy.group(i);
			symbols.add(symb.charAt(0));
		}	
	}

		//triplet = new Triplet(Double.valueOf(m.group(0)),2.0,'c');
		//return triplet;
	
	}

	private static class Triplet<A, B, C> {
		private A first;
		private B second;
		private C third;
	
		public Triplet(A first, B second, C third){
			this.first = first;
			this.second = second;
			this.third = third;
		}


		public A getFirst(){return first;}
		public B getSecond(){return second;}
		public C getThird(){return third;}
	}
	
	public static void main(String[] args){
		matchor("1+3/4");
	}

}
