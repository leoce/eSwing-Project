/**
 * 
 */
package com.eswinggolf.player.shotdata.trajectory.model;

/**
 * @author evangelistalc
 *
 */
public class ShotData {
        
	// Environmental Parameters
			
	public final static double GRAVITY = 32.17d;      //squrefoot per sec
	public final static int R = 1718;                 // gas constant
	public final static double HUMIDITY = 50.0d;	   // humidity constant 
	
	//Wind Parameters
		            
	private double windSpeed; 
	private double windDirection;
		        
	// Course Parameters
		          
	private double slopeX = 0.0d;
	private double slopeZ = 0.0d;


	private double ka;                     //aerodynamic coefficient
	private double airDensity;				
	private double _temperature;           //getter & setter required to update air density in degrees farenheit;
	private double _altitude;              //getter & setter required to update air density

	//Ball mass
		
	final static double BALL_WEIGHT  = 1.62d;       // weight of ball in ounces
	final static double OUNCE_PER_POUND = 16;        //ounces per pound

	// Launch Monitor status
	
	private boolean launchMonitor;
	
	// Club Parameters

	private Long clubId;
	private String clubName; 
	private double clubWeight;
	private double clubSpeed;
	private double clubSpinRate; // for ball spin rate
	private double clubCor;
	private double clubLoft;
	private double clubFaceAngle;
	private double clubSwingPath;
		
	// Ball Parameters
    
	private double ballAOA;
	public final static double BALL_DIAMETER  = 1.68d;
	private double ballSpeed;  //Without LM 
	public final static double BALL_SPIN_FACTOR = 125d;
	private double ballBackSpin;  // refer to clubSpinRate
	private double ballSideSpin = BALL_SPIN_FACTOR * (clubSwingPath - clubFaceAngle);
	private double ballSpinAxisAngle = Math.atan(ballSideSpin/ballBackSpin);    
	private double ballCompression =1.0d;   // value may varies from Low, Normal, High, Limited Flight
	private double ballLaunchAngle;  //without LM club loft angle, with LM within shot data packet
 
	public final static double BALL_MASS = (BALL_WEIGHT/OUNCE_PER_POUND)/GRAVITY;
	public final static double BALL_RADIUS = (BALL_DIAMETER/2)/12;
	public final static double BALL_X_SECTION_AREA = Math.PI * (Math.pow(BALL_RADIUS, 2));
	public final static double BALL_SURFACE_AREA = (Math.PI * Math.pow((BALL_DIAMETER / 2),2)) / 144;    //ft^2 
	
	public final static double BALL_MOMENT_OF_INERTIA  = 0.4 * BALL_MASS * Math.pow((BALL_DIAMETER / 24),2);    //0.0000061688

	public ShotData(){
		init();
	}

	public ShotData(ShotData shot){
		init();
		this.clubWeight = shot.clubWeight;
		this.clubSpeed = shot.clubSpeed;
		this.clubSpinRate = shot.clubSpinRate;
		this.clubCor = shot.clubCor;
		this.clubLoft = shot.clubLoft;
		this.clubFaceAngle = shot.clubFaceAngle;
		this.clubSwingPath = shot.clubSwingPath;
		this.ballAOA = shot.ballAOA;
		this.ballSpeed = shot.ballSpeed;
		this.ballBackSpin = shot.ballBackSpin;
		this.ballLaunchAngle = shot.ballLaunchAngle;
		this.ka = shot.ka;
		this._altitude = shot._altitude;
		this.airDensity = shot.airDensity;
		this._temperature = shot._temperature;
		
	}
	
	public void init(){
		this.clubWeight = 0.0d;
		this.clubSpeed = 0.0d;
		this.clubSpinRate = 0.0d;
		this.clubCor = 0.0d;
		this.clubLoft = 0.0d;
		this.clubFaceAngle = 0.0d;
		this.clubSwingPath = 0.0d;
		this.ballAOA = 0.0d;
		this.ballSpeed = 0.0d;
		this.ballBackSpin = 0.0d;
		this.ballLaunchAngle = 0.0d;
		this.ka = 0.0d;
		this._altitude = 0.0d;
		this.airDensity = 0.0d;
		this._temperature = 0.0d;
	}
	public double getKa() {
		return this.ka;
	}
	
	public void setKa(double ka){
		this.ka = ka;
	}
	
	public double getAirDensity(){

	     double tc  = (5/9)*(_temperature-32); 						// temp centigrade
		 double tk  = tc + 273;                            			//temp kelvin
		 double bp = 29.92 - (_altitude/1000);            			//Pressure Altitude
		 double bpPsf = (bp * 14.6953)/29.92 * 144;      			// pressure in psf
		 double bpmb = bp/0.02953;                        			//press in millibars
		 double es = 6.11 * Math.pow(10,((7.5*tc)/(237.7 + tc))); 	//Saturation vapor pressure (mb)
		 double e  = (HUMIDITY/100)*es;                 			//Actual vapor pressure (mb)
		 double tv  = tk/(((1 -e)/bpmb) * 0.378);  					//Virtual temp (deg K)
		 double tr  = (_temperature + 460);      					//Convert Tv to deg R
		 
	return (bpPsf / (tr * R)) ;										//Air Density (lbs/ft^3)
	}
	

	/**
	 * @return the windSpeed
	 */
	public double getWindSpeed() {
		return windSpeed;
	}

	/**
	 * @param windSpeed the windSpeed to set
	 */
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	/**
	 * @return the windDirection
	 */
	public double getWindDirection() {
		return windDirection;
	}

	/**
	 * @param windDirection the windDirection to set
	 */
	public void setWindDirection(double windDirection) {
		this.windDirection = windDirection;
	}

	/**
	 * @return the slopeX
	 */
	public double getSlopeX() {
		return slopeX;
	}

	/**
	 * @param slopeX the slopeX to set
	 */
	public void setSlopeX(double slopeX) {
		this.slopeX = slopeX;
	}

	/**
	 * @return the slopeZ
	 */
	public double getSlopeZ() {
		return slopeZ;
	}

	/**
	 * @param slopeZ the slopeZ to set
	 */
	public void setSlopeZ(double slopeZ) {
		this.slopeZ = slopeZ;
	}

	/**
	 * @return the ka
	 */
	

	//Entry from the User
	/**
	 * @return the _temperature
	 */
	public double get_temperature() {
		return _temperature;
	}

	/**
	 * @param _temperature the _temperature to set
	 */
	public void set_temperature(double _temperature) {
		this._temperature = _temperature;
	}

	/**
	 * @return the _altitude
	 */
	public double get_altitude() {
		return _altitude;
	}

	/**
	 * @param _altitude the _altitude to set
	 */
	public void set_altitude(double _altitude) {
		this._altitude = _altitude;
	}
	
	
	//Club Parameters
	
	/**
	 * @return the launchMonitor
	 */
	public boolean isLaunchMonitor() {
		return launchMonitor;
	}

	/**
	 * @param launchMonitor the launchMonitor to set
	 */
	public void setLaunchMonitor(boolean launchMonitor) {
		this.launchMonitor = launchMonitor;
	}

	/**
	 * @return the clubId
	 */
	public Long getClubId() {
		return clubId;
	}

	/**
	 * @param clubId the clubId to set
	 */
	public void setClubId(Long clubId) {
		this.clubId = clubId;
	}

	/**
	 * @return the clubName
	 */
	public String getClubName() {
		return clubName;
	}

	/**
	 * @param clubName the clubName to set
	 */
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	/**
	 * @return the clubWeight
	 */
	public double getClubWeight() {
		return clubWeight;
	}

	/**
	 * @param clubWeight the clubWeight to set
	 */
	public void setClubWeight(double clubWeight) {
		this.clubWeight = clubWeight;
	}

	/**
	 * @return the clubSpeed
	 */
	public double getClubSpeed() {
		return clubSpeed;
	}

	/**
	 * @param clubSpeed the clubSpeed to set
	 */
	public void setClubSpeed(double clubSpeed) {
		this.clubSpeed = clubSpeed;
	}

	/**
	 * @return the clubSpinRate
	 */
	public double getClubSpinRate() {
		return clubSpinRate;
	}

	/**
	 * @param clubSpinRate the clubSpinRate to set
	 */
	public void setClubSpinRate(double clubSpinRate) {
		this.clubSpinRate = clubSpinRate;
	}

	/**
	 * @return the clubCor
	 */
	public double getClubCor() {
		return clubCor;
	}

	/**
	 * @param clubCor the clubCor to set
	 */
	public void setClubCor(double clubCor) {
		this.clubCor = clubCor;
	}

	/**
	 * @return the clubLoft
	 */
	public double getClubLoft() {
		return clubLoft;
	}

	/**
	 * @param clubLoft the clubLoft to set
	 */
	public void setClubLoft(double clubLoft) {
		this.clubLoft = clubLoft;
	}

	/**
	 * @return the clubFaceAngle
	 */
	public double getClubFaceAngle() {
		return clubFaceAngle;
	}

	/**
	 * @param d the clubFaceAngle to set
	 */
	public void setClubFaceAngle(double clubFaceAngle) {
		this.clubFaceAngle = clubFaceAngle;
	}

	/**
	 * @return the clubSwingPath
	 */
	public double getClubSwingPath() {
		return clubSwingPath;
	}

	/**
	 * @param clubSwingPath the clubSwingPath to set
	 */
	public void setClubSwingPath(double clubSwingPath) {
		this.clubSwingPath = clubSwingPath;
	}

	/**
	 * @return the ballAOA
	 */
	public double getBallAOA() {
		return ballAOA;
	}

	/**
	 * @param ballAOA the ballAOA to set
	 */
	public void setBallAOA(double ballAOA) {
		this.ballAOA = ballAOA;
	}

	/**
	 * @return the ballLaunchAngle
	 */
	public double getBallLaunchAngle() {
		return ballLaunchAngle;
	}

	/**
	 * @param ballLaunchAngle the ballLaunchAngle to set
	 */
	public void setBallLaunchAngle(double ballLaunchAngle) {
		this.ballLaunchAngle = ballLaunchAngle;
	}

	/**
	 * @return the ballCompression
	 */
	public double getBallCompression() {
		return ballCompression;
	}

	/**
	 * @param ballCompression the ballCompression to set
	 */
	public void setBallCompression(double ballCompression) {
		this.ballCompression = ballCompression;
	}

	/**
	 * @return the ballSpeed
	 */
	public double getBallSpeed() {
		return ballSpeed;
	}

	/**
	 * @param ballSpeed the ballSpeed to set
	 */
	public void setBallSpeed(double ballSpeed) {
		this.ballSpeed = ballSpeed;
	}

	/**
	 * @return the ballBackSpin
	 */
	public double getBallBackSpin() {
		return ballBackSpin;
	}

	/**
	 * @param ballBackSpin the ballBackSpin to set
	 */
	public void setBallBackSpin(double ballBackSpin) {
		this.ballBackSpin = ballBackSpin;
	}

	/**
	 * @return the ballSpinAxisAngle
	 */
	public double getBallSpinAxisAngle() {
		return ballSpinAxisAngle;
	}

	/**
	 * @param ballSpinAxisAngle the ballSpinAxisAngle to set
	 */
	public void setBallSpinAxisAngle(double ballSpinAxisAngle) {
		this.ballSpinAxisAngle = ballSpinAxisAngle;
	}


	/**
	 * @return the ballSideSpin
	 */
	public double getBallSideSpin() {
		return ballSideSpin;
	}

	/**
	 * @param ballSideSpin the ballSideSpin to set
	 */
	public void setBallSideSpin(double ballSideSpin) {
		this.ballSideSpin = ballSideSpin;
	}

	public static void main(String[] args) {
		
	ShotData shotData = new ShotData();
	
	shotData.set_altitude(0);
	shotData.set_temperature(59);
	
	shotData.setKa((shotData.getAirDensity()*shotData.BALL_SURFACE_AREA)/(2*shotData.BALL_MASS));
	System.out.println("Air Density --> "+shotData.getAirDensity());
	System.out.println("Ball Radius --> "+shotData.BALL_RADIUS);
	System.out.println("Ball X Section --> "+shotData.BALL_SURFACE_AREA);
	System.out.println("Ball Mass --> "+shotData.BALL_MASS);
	System.out.println("Gravity --> "+shotData.GRAVITY);
	System.out.println("Ball Mom of Intertia --> "+shotData.BALL_MOMENT_OF_INERTIA);
	System.out.println("Aero Constant --> "+shotData.getKa());
	}
	
	

}
