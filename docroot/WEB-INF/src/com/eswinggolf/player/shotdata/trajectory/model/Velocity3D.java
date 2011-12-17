/**
 * 
 */
package com.eswinggolf.player.shotdata.trajectory.model;

/**
 * @author evangelistalc
 *
 */
public class Velocity3D {
	
	//Velocity 3D properties;
    private  double velocityX;        // velocity in x direction
    private double  velocityY;        //velocity in y direction
    private double  velocityZ;        //velocity in z direction
	/**
	 * @return the velocityX
	 */
    
    public Velocity3D(){
    	init();
    }
    
    public Velocity3D(Velocity3D velocity){
    	init();
    	this.velocityX = velocity.velocityX;
    	this.velocityY = velocity.velocityY;
    	this.velocityZ = velocity.velocityZ;
    }
    
    public void init(){
    	this.velocityX = 0.0d;
    	this.velocityY = 0.0d;
    	this.velocityZ = 0.0d;
    }
	public double getVelocityX() {
		return velocityX;
	}
	/**
	 * @param velocityX the velocityX to set
	 */
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	/**
	 * @return the velocityY
	 */
	public double getVelocityY() {
		return velocityY;
	}
	/**
	 * @param velocityY the velocityY to set
	 */
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}
	/**
	 * @return the velocityZ
	 */
	public double getVelocityZ() {
		return velocityZ;
	}
	/**
	 * @param velocityZ the velocityZ to set
	 */
	public void setVelocityZ(double velocityZ) {
		this.velocityZ = velocityZ;
	}
	/**
	 * @return the velocityZt
	 */
	public double getVelocityZt() {
		return Math.sqrt(Math.pow(this.velocityX,2)+Math.pow(this.velocityY,2)+Math.pow(this.velocityZ,2));
	}
	
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.velocityX);
		sb.append("|");
		sb.append(this.velocityY);
		sb.append("|");
		sb.append(this.velocityZ);
		sb.append("|");
		sb.append(getVelocityZt());
		
		return sb.toString();
	}

}
