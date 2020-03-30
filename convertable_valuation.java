import java.util.*;

public class convertable_valuation {
	
	//item values
	static final double SB = 1;
	static final double GOLD = 1/13500.0;
	static final double QPC = 9650/13500.0;
	static final double WT = 137700/13500.0;
	static final double FLAMIN_LEAF = 15.1;       //25.7sb per flamin hunting corky
	static final double DBC = 62000/13500.0;
	static final double SDBC = 133000/13500.0;
	static final double WF_MAT = 9;
	static final double MND = 300;
	static final double EMBER = 83;
	
	
	
	public static void main(String[] args) {
		// displays total value of a convertable in SB+, broken down to every possible item
		// enter as many convertables as desired, "stop" to end the program
		// values assigned are what they are worth to me
		// QCGT, LIGHTNING, RARE SLAYERS, COMMON EASY SLAYER, RARE RIFTSTALKER
		
		Scanner read = new Scanner(System.in);
		String convertable = read.next();
		do
		{
			switch(convertable)
			{
				case "qcgt":
					qcgtDisplay();
					break;
				case "lightning":
					lightningDisplay();
					break;
				case "common easy slayer":
					slayerDisplay("common easy");
					break;
				case "rare easy slayer":
					slayerDisplay("rare easy");
					break;
				case "rare medium slayer":
					slayerDisplay("rare medium");
					break;
				case "rare hard slayer":
					slayerDisplay("rare hard");
					break;
				case "rare elaborate slayer":
					slayerDisplay("rare elaborate");
					break;
				case "rare arduous slayer":
					slayerDisplay("rare arduous");
					break;
					
				default:
					System.out.println("This convertable is not yet supported");
			}
			
			convertable = read.next();
			
		} while(!convertable.equals("stop"));
		
	}
	
	private static void qcgtDisplay()
	{
		double total = 0;
		total += GOLD * 200000;
		System.out.println("Gold: " + GOLD * 200000);
		
		
	}
	
	private static void lightningDisplay()
	{
		
	}
	
	private static void slayerDisplay(String dif)
	{
		
	}

}
