/**
 * 
 */
package com.eswinggolf.player.shotdata.trajectory.model;

import java.math.BigDecimal;

/**
 * @author evangelistalc
 *
 */
public class BallPointPhysics {

	private Point3D point3D;
	private Velocity3D velocity3D;
	private Displacement3D displacement3D;
	
    //Other properties;
    private int spinDecay;
    private int spinRate;
    private double lift;
    private double drag;
    private double momentumCoefficient;
    private double flightAngle;

    public BallPointPhysics(){
    	
    	init();
    }
    public BallPointPhysics(BallPointPhysics bpp){
    	init();
    	this.displacement3D = bpp.displacement3D;
    	this.velocity3D = bpp.velocity3D;
    	this.point3D = bpp.point3D;
    	this.lift = bpp.lift;
    	this.drag = bpp.drag;
    	this.momentumCoefficient = bpp.momentumCoefficient;
    	this.flightAngle = bpp.flightAngle;
    	this.spinDecay = bpp.spinDecay;
    	this.spinRate = bpp.spinRate;
    	
    }
	
    private void init(){
    	this.point3D = null;
    	this.velocity3D = null;
    	this.displacement3D = null;
    	this.lift = 0.0d;
    	this.drag = 0.0d;
    	this.momentumCoefficient = 0.0d;
    	this.spinDecay = 0;
    	this.spinRate = 0;
    }
    /**
	 * @return the point3D
	 */
	public Point3D getPoint3D() {
		return point3D;
	}

	/**
	 * @param point3d the point3D to set
	 */
	public void setPoint3D(Point3D point3d) {
		point3D = point3d;
	}

	/**
	 * @return the velocity3D
	 */
	public Velocity3D getVelocity3D() {
		return velocity3D;
	}

	/**
	 * @param velocity3d the velocity3D to set
	 */
	public void setVelocity3D(Velocity3D velocity3d) {
		velocity3D = velocity3d;
	}

	/**
	 * @return the displacement3D
	 */
	public Displacement3D getDisplacement3D() {
		return displacement3D;
	}

	/**
	 * @param displacement3d the displacement3D to set
	 */
	public void setDisplacement3D(Displacement3D displacement3d) {
		displacement3D = displacement3d;
	}

	//Other Accessors
	/**
	 * @return the spinDecay
	 */
	public int getSpinDecay() {
		return spinDecay;
	}

	/**
	 * @param spinDecay the spinDecay to set
	 */
	public void setSpinDecay(double spinDecay) {
		this.spinDecay = new Double(spinDecay).intValue();
	}

	/**
	 * @return the spinRate
	 */
	public int getSpinRate() {
		return spinRate;
	}

	/**
	 * @param spinRate the spinRate to set
	 */
	public void setSpinRate(double spinRate) {
		this.spinRate = new Double(spinRate).intValue();
	}

	/**
	 * @return the lift
	 */
	public double getLift() {
		return lift;
	}

	/**
	 * @param lift the lift to set
	 */
	public void setLift(double lift) {
		this.lift = lift;
	}

	/**
	 * @return the drag
	 */
	public double getDrag() {
		return drag;
	}

	/**
	 * @param drag the drag to set
	 */
	public void setDrag(double drag) {
		this.drag = drag;
	}

	/**
	 * @return the momentumCoefficient
	 */
	public double getMomentumCoefficient() {
		return momentumCoefficient;
	}

	/**
	 * @param momentumCoefficient the momentumCoefficient to set
	 */
	public void setMomentumCoefficient(double momentumCoefficient) {
		this.momentumCoefficient = momentumCoefficient;
	}

	/**
	 * @return the flightAngle
	 */
	public double getFlightAngle() {
		return flightAngle;
	}

	/**
	 * @param flightAngle the flightAngle to set
	 */
	public void setFlightAngle(double flightAngle) {
		this.flightAngle = flightAngle;
	}

	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.velocity3D.toString());
		sb.append("|");
		sb.append(this.point3D.toString());
		sb.append("|");
		sb.append(this.flightAngle);
		sb.append("|");
		sb.append(this.spinRate);
		sb.append("|");
		sb.append(this.lift);
		sb.append("|");
		sb.append(this.drag);
		sb.append("|");
		sb.append(this.momentumCoefficient);
		sb.append("|");
		sb.append(this.spinDecay);
		
		return sb.toString();
		
		
	}
}