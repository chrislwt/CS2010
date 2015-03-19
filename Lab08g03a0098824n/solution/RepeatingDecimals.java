import java.util.*;

public class RepeatingDecimals {
	private static String MESSAGE_OUTPUT = ("%1$s/%2$s has a cycle (%3$s) of length %4$s");
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		TreeMap<Integer, Integer> remainderMap = new TreeMap<Integer, Integer>();
		ArrayList<Integer> quotientList = new ArrayList<Integer>();
		int numerator, denominator;
		while(sc.hasNextLine()) {
			String userInput = sc.nextLine();
			
			if(userInput.isEmpty()) {
				throw new Error("Empty input.");
			}
			
			if(userInput.indexOf(" ") == -1) {
				throw new Error("Invalid input.");
			}
			
			try{
				numerator = Integer.parseInt(userInput.substring(0, userInput.indexOf(" ")));
				denominator = Integer.parseInt(userInput.substring(userInput.indexOf(" ")+1));

			} catch(NumberFormatException e){
				throw new Error("Invalid input.");
			}


			int quotient = numerator / denominator;
			int remainder = numerator % denominator;
			int index = 0;

			while (!remainderMap.containsKey(remainder)) {
				remainderMap.put(remainder, index);
				quotient = remainder * 10 / denominator;
				quotientList.add(quotient);
				remainder = (remainder * 10) % denominator;
				index++;
			}

			int cycleIndex = remainderMap.get(remainder);
			StringBuilder repeatingCycle = new StringBuilder();

			for (int i = cycleIndex; i < index; i++) {
				repeatingCycle.append(quotientList.get(i));
			}

			int cycleLength = index - cycleIndex;

			System.out.println("\n"+String.format(MESSAGE_OUTPUT,numerator,denominator,repeatingCycle,cycleLength));
			remainderMap.clear();
			quotientList.clear();
		}

		sc.close();
	}

}
