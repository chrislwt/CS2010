import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TestBusStop {

	static Scanner sc = new Scanner(System.in);
	static Map<Integer, BusStop> busStopsMap = new TreeMap<Integer, BusStop>();
	static ArrayList<String> operationList = new ArrayList<String>();

	/**Pre: The program will keep prompting for commands until user enter "quit" then the output will print out
	 * 
	 */
	public static void main(String[] args) {
		int numOfBusStops = Integer.parseInt(sc.nextLine());
		int busStopsMapKey = 0;
		for(int i = 0; i < numOfBusStops; i++){
			BusStop tempStop = new BusStop();
			tempStop.setRoadName(sc.nextLine());
			tempStop.setQualifier(sc.nextLine());
			tempStop.setStopNum(sc.nextLine());
			tempStop.setStopGPS(sc.nextLine());
			tempStop.setbusServices(sc.nextLine());
			busStopsMapKey = Integer.parseInt(tempStop.getStopNum());
			busStopsMap.put(busStopsMapKey, tempStop);
		}

		//for commands
		while(true){
			String userInput = sc.nextLine();
			if(!userInput.equals("quit")){
				operationList.add(userInput);
			} else {
				System.out.println("");
				break;
			}
		}

		BusStopController bs = new BusStopController(busStopsMap);
		bs.printAllStops();


		for(int i = 0; i < operationList.size(); i++) {
			String operation = operationList.get(i).substring(0, operationList.get(i).indexOf(" "));
			int busStopNum = 0, busStopNum1 = 0, busStopNum2 = 0;

			if(operation.equals("distance")){
				String busStopNumInString = operationList.get(i).substring(operationList.get(i).indexOf(" ")+1);
				busStopNum1 = Integer.parseInt(busStopNumInString.substring(0, busStopNumInString.indexOf(" ")));
				busStopNum2 = Integer.parseInt(busStopNumInString.substring(busStopNumInString.indexOf(" ")+1));
			} else {
				busStopNum = Integer.parseInt(operationList.get(i).substring(operationList.get(i).indexOf(" ")+1));
			}
			switch(operation){
			case "getRoadName":
				bs.getRoadName(busStopNum);
				break;
			case "getQualifier":
				bs.getQualifier(busStopNum);
				break;
			case "getBusStop":
				bs.getBusStop(busStopNum);
			case "getGPS":
				bs.getGPS(busStopNum);
				break;
			case "getBusStopAtThisStation":
				bs.getBusStopAtThisStation(busStopNum);
				break;
			case "distance":
				bs.distance(busStopNum1, busStopNum2);
				break;
			default: 
				throw new Error("Invalid command!");
			}
		}
	}
}
