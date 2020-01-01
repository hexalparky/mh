
public class vrift_sim {
	
	
	//defaults 1/40/5
	private static int SPEED = 1;
	private static int SIPHON = 5;
	private static double TA_AR = .15;
	//CF toggle
	private static int CF = 0;
	//Super Siphon toggle 1/2
	private static int SS = 1;
	//String stepping toggle 1/2
	private static int S_STEP = 1;
	
	public static void main(String[] args) {
		// assumes GSC whole time & standard mode (not UU)
		// cr estimated with tsd/cwb/erpc +25p +16l auras
		int step = 0;
		int floor = 1;
		int sync = 40;
		int hunt_num = 0;
		double catch_rate = 0.95;
		while(sync > 0)
		{
			//if hunt successful
			if(Math.random() < catch_rate)
			{
				//eclipse encounter
				if(floor % 8 == 0)
				{
					sync += SIPHON * SS;
					step += 1 + CF;
					floor++;
				}
				else if(Math.random() < TA_AR)
					step += (SPEED + CF) * 2 * S_STEP;
				else
					step += SPEED + CF;
				//reached next floor (1-7 only)
				if(step > floor * 20)
				{
					floor++;
					//cr drops from ~95-75
					if(floor < 25)
						catch_rate -= (0.01 - 0.0001 * floor);
						
				}
			}
			hunt_num++;
			sync--;
			System.out.println("Hunt: " + hunt_num + " Floor: " + floor
					+ " Steps: " + step + " " + " Sync remaining: " + sync);
		}
		
	}

}
