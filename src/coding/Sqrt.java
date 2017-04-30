package coding;

/**
 * 
 * @author berrytchaks
 *
 *	Write a program that print the square root of a number. Suppose you doesn't have the function sqrt.
 */
public class Sqrt {

	public int sqrt(int x){
		int res = 0;
		int squareRoot = 0;
		if (x == 0)
			return 0;
		if (x == 1)
			return 1;
		for (int i =0; i <= x/2; i++){
			res = i *i;
			squareRoot = i;
			if (res == x || res > x){
				if (res > x){
					squareRoot--;
				}
				break;
			}
		}
		return squareRoot;
	}
	
	public static void main(String[] args) {
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.sqrt(64));
	}
}
