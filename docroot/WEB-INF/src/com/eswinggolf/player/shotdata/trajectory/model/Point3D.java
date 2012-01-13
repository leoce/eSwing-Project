/**
 * 
 */
package com.eswinggolf.player.shotdata.trajectory.model;

import java.io.Serializable;

/**
 * @author evangelistalc
 *
 */
public class Point3D implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Point 3d properties;
	private double pointX;				//x coordinate in yards from tee
	private double pointY;				//y coordinate in yards above/below tee
	private double pointZ;				// z coordinate in yards off target line
	/**
	 * @return the pointX
	 */
	public double getPointX() {
		return pointX;
	}
	/**
	 * @param pointX the pointX to set
	 */
	public void setPointX(double pointX) {
		this.pointX = pointX;
	}
	/**
	 * @return the pointY
	 */
	public double getPointY() {
		return pointY;
	}
	/**
	 * @param pointY the pointY to set
	 */
	public void setPointY(double pointY) {
		this.pointY = pointY;
	}
	/**
	 * @return the pointZ
	 */
	public double getPointZ() {
		return pointZ;
	}
	/**
	 * @param pointZ the pointZ to set
	 */
	public void setPointZ(double pointZ) {
		this.pointZ = pointZ;
	}
	
	public String toString(){

		StringBuffer sb = new StringBuffer();

		sb.append("{");
		sb.append("x:"+this.pointZ);
		sb.append(",");
		sb.append("y:"+this.pointX);
		sb.append(",");
		sb.append("z:"+this.pointY);
		sb.append("}");
		//sb.append("|");
		//sb.append(this.pointX);
		//sb.append("|");
		//sb.append(this.pointY);
		
		return sb.toString();
		}
}
