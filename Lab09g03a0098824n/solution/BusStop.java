public class BusStop {

	private String roadName = null;
	private String qualifier = null;
	private int stopNum = 0;
	private String stopGPS = null;
	private String busServices = null;

	public BusStop(){
		roadName = null;
		qualifier = null;
		stopNum = 0;
		stopGPS = null;
		busServices = null;
	}

	public BusStop(String roadName, String qualifier, int stopNum, String stopGPS, String busServices) {
		this.roadName = roadName;
		this.qualifier = qualifier;
		this.stopNum = stopNum;
		this.stopGPS = stopGPS;
		this.busServices = busServices;
	}

	public String getRoadName(){
		return roadName;
	}

	public void setRoadName(String roadName){
		this.roadName = roadName;
	}

	public String getQualifier(){
		return qualifier;
	}

	public void setQualifier(String qualifier){
		this.qualifier = qualifier;
	}

	public int getStopNum(){
		return stopNum;
	}

	public void setStopNum(int stopNum){
		this.stopNum = stopNum;
	}

	public String getStopGPS(){
		return stopGPS;
	}

	public void setStopGPS(String stopGPS){
		this.stopGPS = stopGPS;
	}

	public String getbusServices(){
		return busServices;
	}

	public void setbusServices(String busServices){
		this.busServices = busServices;
	}
}
