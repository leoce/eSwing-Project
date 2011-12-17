/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.eswinggolf.portal.data.layer.club.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESPlayerShotData service. Represents a row in the &quot;es_ESPlayerShotData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a e s player shot data model instance should use the {@link ESPlayerShotData} interface instead.
 * </p>
 *
 * @author evangelistalc
 * @see ESPlayerShotData
 * @see com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataImpl
 * @see com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataModelImpl
 * @generated
 */
public interface ESPlayerShotDataModel extends BaseModel<ESPlayerShotData> {
	/**
	 * Gets the primary key of this e s player shot data.
	 *
	 * @return the primary key of this e s player shot data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s player shot data
	 *
	 * @param pk the primary key of this e s player shot data
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the shot data id of this e s player shot data.
	 *
	 * @return the shot data id of this e s player shot data
	 */
	public long getShotDataId();

	/**
	 * Sets the shot data id of this e s player shot data.
	 *
	 * @param shotDataId the shot data id of this e s player shot data
	 */
	public void setShotDataId(long shotDataId);

	/**
	 * Gets the player id of this e s player shot data.
	 *
	 * @return the player id of this e s player shot data
	 */
	public long getPlayerId();

	/**
	 * Sets the player id of this e s player shot data.
	 *
	 * @param playerId the player id of this e s player shot data
	 */
	public void setPlayerId(long playerId);

	/**
	 * Gets the player club id of this e s player shot data.
	 *
	 * @return the player club id of this e s player shot data
	 */
	public long getPlayerClubId();

	/**
	 * Sets the player club id of this e s player shot data.
	 *
	 * @param playerClubId the player club id of this e s player shot data
	 */
	public void setPlayerClubId(long playerClubId);

	/**
	 * Gets the product serial no of this e s player shot data.
	 *
	 * @return the product serial no of this e s player shot data
	 */
	public int getProductSerialNo();

	/**
	 * Sets the product serial no of this e s player shot data.
	 *
	 * @param productSerialNo the product serial no of this e s player shot data
	 */
	public void setProductSerialNo(int productSerialNo);

	/**
	 * Gets the launch monitor of this e s player shot data.
	 *
	 * @return the launch monitor of this e s player shot data
	 */
	public boolean getLaunchMonitor();

	/**
	 * Determines if this e s player shot data is launch monitor.
	 *
	 * @return <code>true</code> if this e s player shot data is launch monitor; <code>false</code> otherwise
	 */
	public boolean isLaunchMonitor();

	/**
	 * Sets whether this {$entity.humanName} is launch monitor.
	 *
	 * @param launchMonitor the launch monitor of this e s player shot data
	 */
	public void setLaunchMonitor(boolean launchMonitor);

	/**
	 * Gets the simulate of this e s player shot data.
	 *
	 * @return the simulate of this e s player shot data
	 */
	public boolean getSimulate();

	/**
	 * Determines if this e s player shot data is simulate.
	 *
	 * @return <code>true</code> if this e s player shot data is simulate; <code>false</code> otherwise
	 */
	public boolean isSimulate();

	/**
	 * Sets whether this {$entity.humanName} is simulate.
	 *
	 * @param simulate the simulate of this e s player shot data
	 */
	public void setSimulate(boolean simulate);

	/**
	 * Gets the active of this e s player shot data.
	 *
	 * @return the active of this e s player shot data
	 */
	public boolean getActive();

	/**
	 * Determines if this e s player shot data is active.
	 *
	 * @return <code>true</code> if this e s player shot data is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this {$entity.humanName} is active.
	 *
	 * @param active the active of this e s player shot data
	 */
	public void setActive(boolean active);

	/**
	 * Gets the club loft of this e s player shot data.
	 *
	 * @return the club loft of this e s player shot data
	 */
	public int getClubLoft();

	/**
	 * Sets the club loft of this e s player shot data.
	 *
	 * @param clubLoft the club loft of this e s player shot data
	 */
	public void setClubLoft(int clubLoft);

	/**
	 * Gets the club speed of this e s player shot data.
	 *
	 * @return the club speed of this e s player shot data
	 */
	public int getClubSpeed();

	/**
	 * Sets the club speed of this e s player shot data.
	 *
	 * @param clubSpeed the club speed of this e s player shot data
	 */
	public void setClubSpeed(int clubSpeed);

	/**
	 * Gets the face angle of this e s player shot data.
	 *
	 * @return the face angle of this e s player shot data
	 */
	public int getFaceAngle();

	/**
	 * Sets the face angle of this e s player shot data.
	 *
	 * @param faceAngle the face angle of this e s player shot data
	 */
	public void setFaceAngle(int faceAngle);

	/**
	 * Gets the swing path of this e s player shot data.
	 *
	 * @return the swing path of this e s player shot data
	 */
	public int getSwingPath();

	/**
	 * Sets the swing path of this e s player shot data.
	 *
	 * @param swingPath the swing path of this e s player shot data
	 */
	public void setSwingPath(int swingPath);

	/**
	 * Gets the spin axis angle of this e s player shot data.
	 *
	 * @return the spin axis angle of this e s player shot data
	 */
	public int getSpinAxisAngle();

	/**
	 * Sets the spin axis angle of this e s player shot data.
	 *
	 * @param spinAxisAngle the spin axis angle of this e s player shot data
	 */
	public void setSpinAxisAngle(int spinAxisAngle);

	/**
	 * Gets the launch angle of this e s player shot data.
	 *
	 * @return the launch angle of this e s player shot data
	 */
	public int getLaunchAngle();

	/**
	 * Sets the launch angle of this e s player shot data.
	 *
	 * @param launchAngle the launch angle of this e s player shot data
	 */
	public void setLaunchAngle(int launchAngle);

	/**
	 * Gets the ball speed of this e s player shot data.
	 *
	 * @return the ball speed of this e s player shot data
	 */
	public int getBallSpeed();

	/**
	 * Sets the ball speed of this e s player shot data.
	 *
	 * @param ballSpeed the ball speed of this e s player shot data
	 */
	public void setBallSpeed(int ballSpeed);

	/**
	 * Gets the ball spin rate of this e s player shot data.
	 *
	 * @return the ball spin rate of this e s player shot data
	 */
	public int getBallSpinRate();

	/**
	 * Sets the ball spin rate of this e s player shot data.
	 *
	 * @param ballSpinRate the ball spin rate of this e s player shot data
	 */
	public void setBallSpinRate(int ballSpinRate);

	/**
	 * Gets the ball angle of attack of this e s player shot data.
	 *
	 * @return the ball angle of attack of this e s player shot data
	 */
	public double getBallAngleOfAttack();

	/**
	 * Sets the ball angle of attack of this e s player shot data.
	 *
	 * @param ballAngleOfAttack the ball angle of attack of this e s player shot data
	 */
	public void setBallAngleOfAttack(double ballAngleOfAttack);

	/**
	 * Gets the ball compression of this e s player shot data.
	 *
	 * @return the ball compression of this e s player shot data
	 */
	public double getBallCompression();

	/**
	 * Sets the ball compression of this e s player shot data.
	 *
	 * @param ballCompression the ball compression of this e s player shot data
	 */
	public void setBallCompression(double ballCompression);

	/**
	 * Gets the step time increment of this e s player shot data.
	 *
	 * @return the step time increment of this e s player shot data
	 */
	public double getStepTimeIncrement();

	/**
	 * Sets the step time increment of this e s player shot data.
	 *
	 * @param stepTimeIncrement the step time increment of this e s player shot data
	 */
	public void setStepTimeIncrement(double stepTimeIncrement);

	/**
	 * Gets the wind speed of this e s player shot data.
	 *
	 * @return the wind speed of this e s player shot data
	 */
	public int getWindSpeed();

	/**
	 * Sets the wind speed of this e s player shot data.
	 *
	 * @param windSpeed the wind speed of this e s player shot data
	 */
	public void setWindSpeed(int windSpeed);

	/**
	 * Gets the wind direction of this e s player shot data.
	 *
	 * @return the wind direction of this e s player shot data
	 */
	public int getWindDirection();

	/**
	 * Sets the wind direction of this e s player shot data.
	 *
	 * @param windDirection the wind direction of this e s player shot data
	 */
	public void setWindDirection(int windDirection);

	/**
	 * Gets the ambient temp of this e s player shot data.
	 *
	 * @return the ambient temp of this e s player shot data
	 */
	public int getAmbientTemp();

	/**
	 * Sets the ambient temp of this e s player shot data.
	 *
	 * @param ambientTemp the ambient temp of this e s player shot data
	 */
	public void setAmbientTemp(int ambientTemp);

	/**
	 * Gets the bar pressure alt of this e s player shot data.
	 *
	 * @return the bar pressure alt of this e s player shot data
	 */
	public int getBarPressureAlt();

	/**
	 * Sets the bar pressure alt of this e s player shot data.
	 *
	 * @param barPressureAlt the bar pressure alt of this e s player shot data
	 */
	public void setBarPressureAlt(int barPressureAlt);

	/**
	 * Gets the relative humid of this e s player shot data.
	 *
	 * @return the relative humid of this e s player shot data
	 */
	public int getRelativeHumid();

	/**
	 * Sets the relative humid of this e s player shot data.
	 *
	 * @param relativeHumid the relative humid of this e s player shot data
	 */
	public void setRelativeHumid(int relativeHumid);

	/**
	 * Gets the fairway firmness of this e s player shot data.
	 *
	 * @return the fairway firmness of this e s player shot data
	 */
	public double getFairwayFirmness();

	/**
	 * Sets the fairway firmness of this e s player shot data.
	 *
	 * @param fairwayFirmness the fairway firmness of this e s player shot data
	 */
	public void setFairwayFirmness(double fairwayFirmness);

	/**
	 * Gets the create date of this e s player shot data.
	 *
	 * @return the create date of this e s player shot data
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s player shot data.
	 *
	 * @param createDate the create date of this e s player shot data
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this e s player shot data.
	 *
	 * @return the modified date of this e s player shot data
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s player shot data.
	 *
	 * @param modifiedDate the modified date of this e s player shot data
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets a copy of this e s player shot data as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public ESPlayerShotData toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ESPlayerShotData esPlayerShotData);

	public int hashCode();

	public String toString();

	public String toXmlString();
}