package op.Main;

import gurobi.GRBException;

import java.io.IOException;
import java.util.ArrayList;

import op.Graph.FinalNode;
import op.IO.DH;
import op.IO.Settings;
import op.Solver.AH;
import op.Solver.GM;

public class MainOPTW_pulse {

	public static void main(String[] args) throws GRBException {
		boolean repeat1= false;
		int first = 205;
		int last = 205;
		for (int i = first; i <= last; i++) {
			
	
			try {
				//String configFile = "data/ini/set_64_1_15.ini";
				
				//String configFile = "data/ini/cmt_101.ini";
				//String configFile = "data/ini/tp_1_5.ini";
				//String configFile = "data/ini/op33_075.ini";
				String configFile = "data/ini/Solomon_s/R"+ i + ".ini";
				//String configFile = "data/ini/Cordeau_s/pr"+ i + ".ini";
				System.out.print(configFile+"/");
				Settings setup = new Settings(configFile);
				DH data = new DH(setup);
				data.readInstance();
				
				GM gm = data.getGraph();
				long tnow = System.currentTimeMillis();
				AH ah = new AH(data);
			
				
				ah.runPulse(tnow);
				
				/*System.out.println();
				System.out.println("Pathscore  " +((FinalNode)GM.customers[data.sink]).PathCost);
				System.out.println("Path time  " +((FinalNode)GM.customers[data.sink]).PathTime);
				System.out.println("Path  " +((FinalNode)GM.customers[data.sink]).Path);
				ArrayList<Integer> pathh = ((FinalNode)GM.customers[data.sink]).Path;
				
				System.out.println("EXE time " + (System.currentTimeMillis() - tnow) / 1000.0);*/
			} catch (IOException e) {
				// catch (IOException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			if(i== last && !repeat1){
				System.out.println("_____________________________________________________________");
				i=first-1;
				repeat1 = true;
			}
		}
	}
}