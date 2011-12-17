package com.eswinggolf.player.shotdata.trajectory.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.eswinggolf.player.shotdata.trajectory.model.BallPointPhysics;

public class TrajectoryModel {
	
	
	final static double STEP_TIME_INCREMENT = 0.05d;
	final static int MAX_BALL_FLIGHT = 20;
	List<Point3D> plot = new ArrayList<Point3D>();       //a plot of the ball flight
	int maxHeight  = 0;
	
	private List<Point3D> points;
	
	private List<BallPointPhysics> loadPlot;
	
	public TrajectoryModel(){
		init();
	}
	
	public TrajectoryModel(ShotData shotData, boolean lmAttached){
		init();
		generatePlot(shotData,lmAttached);
	}
	
	private void init(){
		this.points = new ArrayList<Point3D>();
		this.loadPlot = new ArrayList<BallPointPhysics>();
	}
	private BallPointPhysics computeIBV(boolean launchmonitorconnected, ShotData shotData){

		BallPointPhysics ballVelocity = new BallPointPhysics();

	        if (!launchmonitorconnected) {    //calulate ball speed, spin rate, and launch angle

	            // ball speed calculation --------------------------------
	            double clubSpeed = shotData.getClubSpeed();
	            double clubWeight  = getGramsToSlugs(shotData.getClubWeight());
	            double clubCor = (1 + shotData.getClubCor()) / (1 + (ShotData.BALL_MASS / clubWeight));
	            double assumedIBV  = clubSpeed * shotData.getClubCor(); //clubCor * shotData.getBallCompression();

	            shotData.setBallSpeed(getMphToFtPerSecond(assumedIBV));

	            // ball spin calculation --------------------------------
	            shotData.setBallBackSpin(shotData.getClubSpinRate() * ShotData.BALL_SPIN_FACTOR);

	            //launch angle -----------------------------------------
	            shotData.setBallLaunchAngle(0.85 * shotData.getClubLoft());
	            shotData.setBallAOA(0.0d);
	        }

	        shotData.setBallSideSpin(-125 * (shotData.getClubFaceAngle() - shotData.getClubSwingPath()));
	        shotData.setBallSpinAxisAngle(Math.atan((shotData.getBallSideSpin() / shotData.getClubSpinRate())));

	        double launchAngleRadians = Math.toRadians(shotData.getBallLaunchAngle());
	        double swingPathRadians = Math.toRadians(shotData.getClubSwingPath());
	        double faceAngleRadians = Math.toRadians((0.85*shotData.getClubFaceAngle())-(0.15*shotData.getClubSwingPath()));
	        double windDirectionRadians = Math.toRadians(shotData.getWindDirection());
	        double windSpeedFps = getMphToFtPerSecond(shotData.getWindSpeed());

	        Velocity3D velocity = new Velocity3D();
	        
	        velocity.setVelocityX(shotData.getBallSpeed() * Math.cos(launchAngleRadians) 
	                 * Math.cos(faceAngleRadians) - windSpeedFps * Math.cos(windDirectionRadians));
	        velocity.setVelocityZ(shotData.getBallSpeed() * Math.sin(faceAngleRadians)
	                 - windSpeedFps * Math.sin(windDirectionRadians));
	        velocity.setVelocityY(shotData.getBallSpeed() * Math.sin(launchAngleRadians) * Math.cos(faceAngleRadians));
	        
	        ballVelocity.setVelocity3D(velocity);
	        
	        ballVelocity.setLift((-0.0839 * (Math.pow((shotData.getClubSpinRate()/60)/ballVelocity.getVelocity3D().getVelocityZt(),2)) 
	                         + 0.3529 * (shotData.getClubSpinRate()/60)/ ballVelocity.getVelocity3D().getVelocityZt() + 0.1148));
	        ballVelocity.setDrag((-0.024 * (Math.pow((shotData.getClubSpinRate()/60)/ballVelocity.getVelocity3D().getVelocityZt(),2)) 
	                         + 0.2251 * (shotData.getClubSpinRate()/60)/ ballVelocity.getVelocity3D().getVelocityZt() + 0.2094));
	        ballVelocity.setMomentumCoefficient(0.01 * shotData.getClubSpinRate() / 10000);
	        ballVelocity.setFlightAngle(launchAngleRadians);
	        shotData.setKa((shotData.getAirDensity() * ShotData.BALL_SURFACE_AREA)/ (2 * ShotData.BALL_MASS));
	       
	        double denominator = 4 * Math.PI * ShotData.BALL_MOMENT_OF_INERTIA;
	        double numerator = shotData.getAirDensity() * ShotData.GRAVITY * getInchesToFeet(ShotData.BALL_DIAMETER) 
	        				* ShotData.BALL_SURFACE_AREA * ballVelocity.getMomentumCoefficient() * 
	        				Math.pow(ballVelocity.getVelocity3D().getVelocityZt(), 2) * STEP_TIME_INCREMENT;
	        
	        ballVelocity.setSpinDecay(-(numerator/denominator));
	        ballVelocity.setSpinRate(shotData.getClubSpinRate());
	        
	        Displacement3D displacement = new Displacement3D();
		    
	        Point3D point = new Point3D();
	        
	        point.setPointX(0);
	        point.setPointY(0);
	        point.setPointZ(0);
	        
	        ballVelocity.setPoint3D(point);
	        
	        displacement.setDisplacementX(0);
	        displacement.setDisplacementY(0);
	        displacement.setDisplacementZ(0);
	       
	        ballVelocity.setDisplacement3D(displacement);
	        
	        return ballVelocity;
	    }


	    public void generatePlot(ShotData shotData, boolean lmAttached){
	    	
	    	BallPointPhysics currentV = (BallPointPhysics) computeIBV(lmAttached, shotData);
	    	
	        Velocity3D lastVelocity = new Velocity3D();
	        Velocity3D velocity = new Velocity3D();
	        
	        double windDirectionRadians = getAngleToRadians(shotData.getWindDirection());

	        double windSpeedFps = getMphToFtPerSecond(shotData.getWindSpeed());

	        int timeStep = 0;

	        Point3D currentLoc;
	        Point3D lastLoc = new Point3D();


	        double groundHeight = 0.0d;
	        boolean groundHit = false;
	   	
	        lastLoc.setPointX(0.0d);
	        lastLoc.setPointY(0.0d);
	        lastLoc.setPointZ(0.0d);
	        
	        
	        
	        lastVelocity.setVelocityX(currentV.getVelocity3D().getVelocityX());
	        lastVelocity.setVelocityY(currentV.getVelocity3D().getVelocityY());
	        lastVelocity.setVelocityZ(currentV.getVelocity3D().getVelocityZ());
		
	        currentLoc = lastLoc;

	        plot = new ArrayList<Point3D>();
	        
	        this.loadPlot.add(currentV);
	        this.points.add(currentV.getPoint3D());
	        
	        do {
	        	 	
	        	 	currentV = new BallPointPhysics(currentV);
	        	 	
	        		velocity = new Velocity3D(currentV.getVelocity3D());
	        		
	        		Point3D point = currentV.getPoint3D();
	        		
	        		//calculate succeeding ball velocities
	                velocity.setVelocityX(velocity.getVelocityX() - (shotData.getKa() * velocity.getVelocityZt() * currentV.getDrag() * velocity.getVelocityX() * STEP_TIME_INCREMENT) 
	                		- (shotData.getKa() * velocity.getVelocityZ() * currentV.getLift() * Math.sin(shotData.getBallSpinAxisAngle())) 
	                		- (shotData.getKa() * velocity.getVelocityY() * currentV.getLift() * Math.cos(shotData.getBallSpinAxisAngle())) * STEP_TIME_INCREMENT);
 
	                velocity.setVelocityZ(velocity.getVelocityZ() - (shotData.getKa() * velocity.getVelocityZt()) * 
	                		((currentV.getDrag() * velocity.getVelocityZ()) 
	                				+ (currentV.getLift() * lastVelocity.getVelocityX() * Math.sin(shotData.getBallSpinAxisAngle())))); 

	                velocity.setVelocityY(velocity.getVelocityY() - (ShotData.GRAVITY * STEP_TIME_INCREMENT) - 
	                		(shotData.getKa() * velocity.getVelocityZt() * (currentV.getDrag() * lastVelocity.getVelocityY() 
	                				- currentV.getLift() * lastVelocity.getVelocityX() * Math.cos(shotData.getBallSpinAxisAngle()))) * STEP_TIME_INCREMENT );

	                currentV.setVelocity3D(velocity);
	                //calculate new lift and drag and decay

	                currentV.setSpinRate(currentV.getSpinRate() + currentV.getSpinDecay());
	                currentV.setLift((-0.0839 * Math.pow((currentV.getSpinRate()/60)/velocity.getVelocityZt(),2)) + (0.3529 
	                		* ((currentV.getSpinRate()/60)/velocity.getVelocityZt())) + 0.1148);
	                currentV.setDrag((-0.024 * Math.pow((currentV.getSpinRate()/60)/velocity.getVelocityZt(),2))
	                                 + (0.2251 * ((currentV.getSpinRate()/60)/velocity.getVelocityZt())) + 0.2094);
	                currentV.setMomentumCoefficient((0.01 * currentV.getSpinRate()) / 10000);
	                currentV.setFlightAngle(Math.atan2(velocity.getVelocityY(),velocity.getVelocityX()));
	                
	                double rho = shotData.getAirDensity();
	    	        double gravity = ShotData.GRAVITY;
	    	        double surfaceArea = ShotData.BALL_SURFACE_AREA;

	    	        double bv2 = Math.pow(velocity.getVelocityZt(), 2);
	    	        double ballMOI = ShotData.BALL_MOMENT_OF_INERTIA;
	    	        double denominator = 4 * Math.PI * ballMOI;
	    	        double ballDiameter = getInchesToFeet(ShotData.BALL_DIAMETER/2) * 2;
	    	        
	    	        double numerator = rho * gravity * ballDiameter * surfaceArea * currentV.getMomentumCoefficient() * bv2 * STEP_TIME_INCREMENT;
	    	        
	    	        currentV.setSpinDecay(-(numerator/denominator));


	            //Calculate current displacement
		    
		       	currentLoc = new Point3D();

	            currentLoc.setPointZ(lastLoc.getPointZ() + (getFeetToYards(((velocity.getVelocityZ() + lastVelocity.getVelocityZ()) / 2)*STEP_TIME_INCREMENT)));
	            currentLoc.setPointX(currentLoc.getPointX() + lastLoc.getPointX() 
	            		+ getFeetToYards((velocity.getVelocityX() + lastVelocity.getVelocityX()) / 2 * STEP_TIME_INCREMENT));
	            currentLoc.setPointY(currentLoc.getPointY() + lastLoc.getPointY() 
	            		+ getFeetToYards((velocity.getVelocityY() + lastVelocity.getVelocityY()) / 2 * STEP_TIME_INCREMENT));
	           
	            this.points.add(currentLoc);
	            
	            currentV.setPoint3D(currentLoc);
	            // check to see if ground has been hit
	            groundHeight = (shotData.getSlopeX() * currentLoc.getPointX()) + (shotData.getSlopeZ() * currentLoc.getPointZ());

	            if (currentLoc.getPointY() <= groundHeight) {
	            	currentLoc.setPointY(0.0d);
	                groundHit = true;

	            } else {
	            	
	                plot.add(currentLoc);                           // add position to plot
	                
	                lastLoc = currentLoc;

	                lastVelocity.setVelocityX(velocity.getVelocityX());
	                lastVelocity.setVelocityY(velocity.getVelocityY());
	                lastVelocity.setVelocityZ(velocity.getVelocityZ());

	                if (currentLoc.getPointY() > maxHeight)
	                	maxHeight = (int) (currentLoc.getPointY());

	                timeStep += 1;
	            }

	            this.loadPlot.add(currentV);
	            
	        } while (!groundHit); 

	    }
	    
	    
	    
	   
		/**
		 * @return the points
		 */
		public List<Point3D> getPoints() {
			return points;
		}


		/**
		 * @param points the points to set
		 */
		public void setPoints(List<Point3D> points) {
			this.points = points;
		}


		/**
		 * @return the loadPlot
		 */
		public List<BallPointPhysics> getLoadPlot() {
			return loadPlot;
		}


		/**
		 * @param loadPlot the loadPlot to set
		 */
		public void setLoadPlot(List<BallPointPhysics> loadPlot) {
			this.loadPlot = loadPlot;
		}


		private double getMphToFtPerSecond(double speedInMPH){
	        return (speedInMPH * 5280)/3600;
	    }

	    private double getAngleToRadians(double angle){
	        return (angle * Math.PI) / 180.0d;
	    }

	    private double getGramsToSlugs(double grams) {
	        return grams * 0.0000685217659;
	    }

	    private double getInchesToFeet(double inches) {
	        return inches / 12;
	    }

	    private double getFeetToYards(double feet) {
	        return feet / 3;
	    }
	    
	    public static void main(String[] argv){
	    	
	    	ShotData shot = new ShotData();
	    	Point3D point = new Point3D();
	    	Velocity3D velocity = new Velocity3D();
	    	Displacement3D displacement = new Displacement3D();
	    	BallPointPhysics ballPoint = new BallPointPhysics();
	    	
	    	velocity.setVelocityX(0);
	    	velocity.setVelocityY(0);
	    	velocity.setVelocityZ(0);
	    	
	    	point.setPointX(0);
	    	point.setPointY(0);
	    	point.setPointZ(0);
	    	
	    	displacement.setDisplacementX(0);
	    	displacement.setDisplacementY(0);
	    	displacement.setDisplacementZ(0);
	    	
	    	ballPoint.setDisplacement3D(displacement);
	    	ballPoint.setVelocity3D(velocity);
	    	ballPoint.setPoint3D(point);
	    	
	    	shot.set_altitude(0);
	    	shot.set_temperature(59);
	    	
	    	shot.setClubSpeed(92.00d);
	    	shot.setClubWeight(200.0d);
	    	shot.setClubCor(1.145);
	    	
	    	shot.setClubSpinRate(5500.0d);
	    	shot.setClubLoft(31.0d);
	    	shot.setClubFaceAngle(-2.0d);
	    	shot.setClubSwingPath(0.0d);
	    	shot.setBallBackSpin(4000);
	    	shot.setBallLaunchAngle(26d);
	    	shot.setWindDirection(0.0d);
	    	shot.setWindSpeed(0.0d);
	    	shot.setBallSpeed(150d);
	    	shot.setBallAOA(20.0d);
	    	TrajectoryModel simulate = new TrajectoryModel(shot,false);
	    	
	    	
	    	
	    	//clubSpeed = getMphToFtPerSecond(shotData.getClubSpeed());
            //clubWeight  = getGramsToSlugs(shotData.getClubWeight());
            //clubCor = (1 + shotData.getClubCor()) / ((1 + shotData.BALL_MASS) / clubWeight);
            //assumedIBV  = clubSpeed * clubCor * shotData.getBallCompression();
            
	    	System.out.println("Club Weight in Slugs --> "+simulate.getGramsToSlugs(shot.getClubWeight()));
	    	System.out.println("Ball Compression --> "+shot.getBallCompression());
	    	System.out.println("Club Speed --> "+simulate.getMphToFtPerSecond(shot.getClubSpeed()));
	    	System.out.println("Club Mass -->"+ simulate.getGramsToSlugs(shot.getClubWeight()));
	    	System.out.println("Ball Speed --> "+shot.getBallSpeed());
	    	System.out.println("Velocity X "+velocity.getVelocityX()+" Y "+velocity.getVelocityY()+" Z "+velocity.getVelocityZ());
	    	System.out.println("IBV "+velocity.getVelocityZt());
	    
	    	
	    	Iterator iter = simulate.points.listIterator();
	    	
	    	//System.out.print("Velocity X|"+"Velocity Y|"+"Velocity Z|"+"Velocity Zt|");
	    	System.out.println("Displacement X|"+"Displacement Y|"+"Displacement Z|");
	    	//System.out.print("Flight Angle|"+"Spin Rate|");
	    	//System.out.println("Co Lift|"+"Co Drag|"+"Co Momentum|"+"Spin Decay");
	    	while (iter.hasNext()){
	    		
	    		Point3D points = (Point3D) iter.next();
	    		
	    		System.out.println(points.toString());
	    		
	    	}
	    	
	    	
	    	
	    }
	
}

