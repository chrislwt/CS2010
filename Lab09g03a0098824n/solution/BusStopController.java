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
			//for bus stop number that starts with 0, parsing as int will remove the 0 so there is a need to manually put back when printing
			if(tempStop.getStopNum() < 10000) {
				System.out.println(tempStop.getRoadName()+"-."+tempStop.getQualifier()+
						"(B0"+tempStop.getStopNum()+")("+gpsInDouble.get(0)+","+gpsInDouble.get(1)+","
						+gpsInDouble.get(2)+")["+tempStop.getbusServices()+"]");
			} else {
				System.out.println(tempStop.getRoadName()+"-."+tempStop.getQualifier()+
						"(B"+tempStop.getStopNum()+")("+gpsInDouble.get(0)+","+gpsInDouble.get(1)+","
						+gpsInDouble.get(2)+")["+tempStop.getbusServices()+"]");
			}

		}
	}

	public void getRoadName(int busStopNum) {
		if(busStopNum < 10000) {
			System.out.println("getRoadName 0"+ busStopNum);
		} else {
			System.out.println("getRoadName "+ busStopNum);
		}

		String roadName = busStopsMap.get(busStopNum).getRoadName();
		System.out.println(roadName);
	}

	public void getQualifier(int busStopNum) {
		if(busStopNum < 10000) {
			System.out.println("getQualifier 0"+ busStopNum);
		} else {
			System.out.println("getQualifier "+ busStopNum);
		}

		String qualifier = busStopsMap.get(busStopNum).getQualifier();
		System.out.println(qualifier);
	}

	public void getBusStop(int busStopNum) {
		if(busStopNum < 10000) {
			System.out.println("getBusStop 0"+ busStopNum);
		} else {
			System.out.println("getBusStop "+ busStopNum);
		}

		BusStop tempStop = busStopsMap.get(busStopNum);

		ArrayList<Double> gpsInDouble = new ArrayList<Double>();
		String[] gpsInString = tempStop.getStopGPS().split(" ");

		for(int i = 0; i < 3; i++){
			gpsInDouble.add(Double.parseDouble(gpsInString[i]));
		}

		if(tempStop.getStopNum() < 10000) {
			System.out.println(tempStop.getRoadName()+"-."+tempStop.getQualifier()+
					"(B0"+tempStop.getStopNum()+")("+gpsInDouble.get(0)+","+gpsInDouble.get(1)+","
					+gpsInDouble.get(2)+")["+tempStop.getbusServices()+"]");
		} else {
			System.out.println(tempStop.getRoadName()+"-."+tempStop.getQualifier()+
					"(B"+tempStop.getStopNum()+")("+gpsInDouble.get(0)+","+gpsInDouble.get(1)+","
					+gpsInDouble.get(2)+")["+tempStop.getbusServices()+"]");
		}
	}

	public void getGPS(int busStopNum) {
		if(busStopNum < 10000) {
			System.out.println("getGPS 0"+ busStopNum);
		} else {
			System.out.println("getGPS "+ busStopNum);
		}

		BusStop tempStop = busStopsMap.get(busStopNum);

		ArrayList<Double> gpsInDouble = new ArrayList<Double>();
		String[] gpsInString = tempStop.getStopGPS().split(" ");

		for(int i = 0; i < 3; i++){
			gpsInDouble.add(Double.parseDouble(gpsInString[i]));
		}

		System.out.println("("+gpsInDouble.get(0)+","+gpsInDouble.get(1)+","+gpsInDouble.get(2)+")");
	}

	public void getBusStopAtThisStation(int busStopNum) {
		if(busStopNum < 10000) {
			System.out.println("getBusStopAtThisStation 0"+ busStopNum);
		} else {
			System.out.println("getBusStopAtThisStation "+ busStopNum);
		}
		BusStop tempStop = busStopsMap.get(busStopNum);

		System.out.println("["+tempStop.getbusServices()+"]");
	}

	public void distance(int busStopNum1, int busStopNum2) {
		double distance = 0;
		if(busStopNum1 < 10000 && busStopNum2 < 10000) {
			System.out.println("distance 0"+ busStopNum1 + " 0" + busStopNum2);
		} else if(busStopNum1 < 10000) {
			System.out.println("distance 0"+ busStopNum1 + " " + busStopNum2);
		} else if(busStopNum2 < 10000) {
			System.out.println("distance "+ busStopNum1 + " 0" + busStopNum2);
		} else {
			System.out.println("distance "+ busStopNum1 + " " + busStopNum2);
		}

		BusStop tempStop1 = busStopsMap.get(busStopNum1);
		BusStop tempStop2 = busStopsMap.get(busStopNum2);
		ArrayList<Double> gpsInDouble = new ArrayList<Double>();
		String[] gpsInString1 = tempStop1.getStopGPS().split(" ");
		String[] gpsInString2 = tempStop2.getStopGPS().split(" ");

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
