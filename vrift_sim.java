
public class vrift_sim {
	//03/30/20 update, added proper floor progression up to an infinite number of floors
	//corrected eclipse capture progress
	//updated TA_AR to match true value more closely (more data was collected)
	
	//next planned update: add Ultimate Umbra mode, date TBD (more data needed)
	
	//starting values 1/40/5
	private static int SPEED = 10;
	private static int SIPHON = 25;
	private static double TA_AR = .15;
	//CF toggle
	private static int CF = 0;
	//Super Siphon toggle 1/2
	private static int SS = 2;
	//String stepping toggle 1/2
	private static int S_STEP = 1;
	
	public static void main(String[] args) {
		// assumes GSC whole time & standard mode (not UU)
		// cr estimated with tsd/cwb/rupc +25p +16l auras
		int step = 0;
		int floor = 1;
		int sync = 80;
		int hunt_num = 0;
		int floor_steps = 0;
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
					step += SPEED + CF;
					floor_steps += SPEED + CF;
					floor++;
				}
				else if(Math.random() < TA_AR)
				{
					step += (SPEED + CF) * 2 * S_STEP;
					floor_steps += (SPEED + CF) * 2 * S_STEP;
				}
				else
				{
					step += SPEED + CF;
					floor_steps += SPEED + CF;
				}
				//updating floors
				if(floor < 8)
				{
					floor_steps = step - 140;
					//reached next floor (1-7 only)
					if(step > floor * 20)
					{
						floor++;
						//cr drops from ~95-88.35(f1-7)
						catch_rate -= (0.01 - 0.0001 * floor);
					}
				}
				else if(floor % 8 != 0)
				{
					if(TA_AR > 0.08)
						TA_AR -= 0.0025;
					int TE_level = floor / 8;
					if(floor_steps >= 20 + TE_level * 10)
					{
						floor++;
						floor_steps = floor_steps % (20 + TE_level * 10);
					}
				}
				
			}
			hunt_num++;
			sync--;
			System.out.println("Hunt: " + hunt_num + " Floor: " + floor
					+ " Steps: " + step + " " + " Sync remaining: " + sync);
			
		}
		
	}

}
