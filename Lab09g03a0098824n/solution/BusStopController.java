import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BusStopController {
	static Map<Integer, BusStop> busStopsMap = new TreeMap<Integer, BusStop>();

	public BusStopController(Map<Integer, BusStop> busStopsMap){
		BusStopController.busStopsMap = busStopsMap;
	}

	public void printAllStops(){
		for(Map.Entry<Integer, BusStop> entry: busStopsMap.entrySet()) {
			BusStop tempStop = entry.getValue();

			ArrayList<Double> gpsInDouble = new ArrayList<Double>();
			String[] gpsInString = tempStop.getStopGPS().split(" ");

			for(int i = 0; i < 3; i++){
				gpsInDouble.add(Double.parseDouble(gpsInString[i]));
			}

			tempStop.setbusServices(tempStop.getbusServices().replace(" ", ", "));
			System.out.println(tempStop.getRoadName()+"-."+tempStop.getQualifier()+
					"(B"+tempStop.getStopNum()+")("+gpsInDouble.get(0)+","+gpsInDouble.get(1)+","
					+gpsInDouble.get(2)+")["+tempStop.getbusServices()+"]");
		}
	}

	public void getRoadName(int busStopNum) {
		String busStopNumInString = busStopsMap.get(busStopNum).getStopNum();
		System.out.println("getRoadName "+ busStopNumInString);
		String roadName = busStopsMap.get(busStopNum).getRoadName();
		System.out.println(roadName);
	}

	public void getQualifier(int busStopNum) {
		String busStopNumInString = busStopsMap.get(busStopNum).getStopNum();
		String qualifier = busStopsMap.get(busStopNum).getQualifier();
		System.out.println("getQualifier "+ busStopNumInString);
		System.out.println(qualifier);
	}

	public void getBusStop(int busStopNum) {
		String busStopNumInString = busStopsMap.get(busStopNum).getStopNum();
		BusStop tempStop = busStopsMap.get(busStopNum);
		System.out.println("getBusStop "+ busStopNumInString);
		ArrayList<Double> gpsInDouble = new ArrayList<Double>();
		String[] gpsInString = tempStop.getStopGPS().split(" ");

		for(int i = 0; i < 3; i++){
			gpsInDouble.add(Double.parseDouble(gpsInString[i]));
		}

		System.out.println(tempStop.getRoadName()+"-."+tempStop.getQualifier()+
				"(B"+tempStop.getStopNum()+")("+gpsInDouble.get(0)+","+gpsInDouble.get(1)+","
				+gpsInDouble.get(2)+")["+tempStop.getbusServices()+"]");
	}

	public void getGPS(int busStopNum) {
		String busStopNumInString = busStopsMap.get(busStopNum).getStopNum();
		System.out.println("getGPS "+ busStopNumInString);
		String[] gpsInString = busStopsMap.get(busStopNum).getStopGPS().split(" ");
		ArrayList<Double> gpsInDouble = new ArrayList<Double>();

		for(int i = 0; i < 3; i++){
			gpsInDouble.add(Double.parseDouble(gpsInString[i]));
		}

		System.out.println("("+gpsInDouble.get(0)+","+gpsInDouble.get(1)+","+gpsInDouble.get(2)+")");
	}

	public void getBusStopAtThisStation(int busStopNum) {
		String busStopNumInString = busStopsMap.get(busStopNum).getStopNum();
		System.out.println("getBusStopAtThisStation "+ busStopNumInString);
		System.out.println("["+busStopsMap.get(busStopNum).getbusServices()+"]");
	}

	public void distance(int busStopNum1, int busStopNum2) {
		double distance = 0;
		String busStopNumInString1 = busStopsMap.get(busStopNum1).getStopNum();
		String busStopNumInString2 = busStopsMap.get(busStopNum2).getStopNum();
		System.out.println("distance "+ busStopNumInString1 + " " + busStopNumInString2);

		ArrayList<Double> gpsInDouble = new ArrayList<Double>();
		String[] gpsInString1 = busStopsMap.get(busStopNum1).getStopGPS().split(" ");
		String[] gpsInString2 = busStopsMap.get(busStopNum2).getStopGPS().split(" ");

		for(int i = 0; i < 3; i++){
			gpsInDouble.add(Double.parseDouble(gpsInString1[i]));
			gpsInDouble.add(Double.parseDouble(gpsInString2[i]));
		}

		for(int i = 0; i < gpsInDouble.size();) {
			distance = distance + Math.pow(gpsInDouble.get(i) - gpsInDouble.get(i+1),2);
			i += 2;
		}
		DecimalFormat df = new DecimalFormat("#.##");
		distance = Math.sqrt(distance);
		System.out.println(df.format(distance));
	}
}
