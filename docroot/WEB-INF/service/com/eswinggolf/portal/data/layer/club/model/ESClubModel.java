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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESClub service. Represents a row in the &quot;es_ESClub&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.eswinggolf.portal.data.layer.club.model.impl.ESClubModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a e s club model instance should use the {@link ESClub} interface instead.
 * </p>
 *
 * @author evangelistalc
 * @see ESClub
 * @see com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl
 * @see com.eswinggolf.portal.data.layer.club.model.impl.ESClubModelImpl
 * @generated
 */
public interface ESClubModel extends BaseModel<ESClub> {
	/**
	 * Gets the primary key of this e s club.
	 *
	 * @return the primary key of this e s club
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s club
	 *
	 * @param pk the primary key of this e s club
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the club id of this e s club.
	 *
	 * @return the club id of this e s club
	 */
	public long getClubId();

	/**
	 * Sets the club id of this e s club.
	 *
	 * @param clubId the club id of this e s club
	 */
	public void setClubId(long clubId);

	/**
	 * Gets the company id of this e s club.
	 *
	 * @return the company id of this e s club
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this e s club.
	 *
	 * @param companyId the company id of this e s club
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the group id of this e s club.
	 *
	 * @return the group id of this e s club
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this e s club.
	 *
	 * @param groupId the group id of this e s club
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the user id of this e s club.
	 *
	 * @return the user id of this e s club
	 */
	public long getUserId();

	/**
	 * Sets the user id of this e s club.
	 *
	 * @param userId the user id of this e s club
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this e s club.
	 *
	 * @return the user uuid of this e s club
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s club.
	 *
	 * @param userUuid the user uuid of this e s club
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the club name of this e s club.
	 *
	 * @return the club name of this e s club
	 */
	@AutoEscape
	public String getClubName();

	/**
	 * Sets the club name of this e s club.
	 *
	 * @param clubName the club name of this e s club
	 */
	public void setClubName(String clubName);

	/**
	 * Gets the club desc of this e s club.
	 *
	 * @return the club desc of this e s club
	 */
	@AutoEscape
	public String getClubDesc();

	/**
	 * Sets the club desc of this e s club.
	 *
	 * @param clubDesc the club desc of this e s club
	 */
	public void setClubDesc(String clubDesc);

	/**
	 * Gets the loft of this e s club.
	 *
	 * @return the loft of this e s club
	 */
	public int getLoft();

	/**
	 * Sets the loft of this e s club.
	 *
	 * @param loft the loft of this e s club
	 */
	public void setLoft(int loft);

	/**
	 * Gets the nom sr of this e s club.
	 *
	 * @return the nom sr of this e s club
	 */
	public int getNomSr();

	/**
	 * Sets the nom sr of this e s club.
	 *
	 * @param nomSr the nom sr of this e s club
	 */
	public void setNomSr(int nomSr);

	/**
	 * Gets the nom speed of this e s club.
	 *
	 * @return the nom speed of this e s club
	 */
	public int getNomSpeed();

	/**
	 * Sets the nom speed of this e s club.
	 *
	 * @param nomSpeed the nom speed of this e s club
	 */
	public void setNomSpeed(int nomSpeed);

	/**
	 * Gets the launch angle of this e s club.
	 *
	 * @return the launch angle of this e s club
	 */
	public int getLaunchAngle();

	/**
	 * Sets the launch angle of this e s club.
	 *
	 * @param launchAngle the launch angle of this e s club
	 */
	public void setLaunchAngle(int launchAngle);

	/**
	 * Gets the co r of this e s club.
	 *
	 * @return the co r of this e s club
	 */
	public double getCoR();

	/**
	 * Sets the co r of this e s club.
	 *
	 * @param coR the co r of this e s club
	 */
	public void setCoR(double coR);

	/**
	 * Gets the weight of this e s club.
	 *
	 * @return the weight of this e s club
	 */
	public int getWeight();

	/**
	 * Sets the weight of this e s club.
	 *
	 * @param weight the weight of this e s club
	 */
	public void setWeight(int weight);

	/**
	 * Gets the model of this e s club.
	 *
	 * @return the model of this e s club
	 */
	@AutoEscape
	public String getModel();

	/**
	 * Sets the model of this e s club.
	 *
	 * @param model the model of this e s club
	 */
	public void setModel(String model);

	/**
	 * Gets the active of this e s club.
	 *
	 * @return the active of this e s club
	 */
	public boolean getActive();

	/**
	 * Determines if this e s club is active.
	 *
	 * @return <code>true</code> if this e s club is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this {$entity.humanName} is active.
	 *
	 * @param active the active of this e s club
	 */
	public void setActive(boolean active);

	/**
	 * Gets the create date of this e s club.
	 *
	 * @return the create date of this e s club
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s club.
	 *
	 * @param createDate the create date of this e s club
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this e s club.
	 *
	 * @return the modified date of this e s club
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s club.
	 *
	 * @param modifiedDate the modified date of this e s club
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets a copy of this e s club as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public ESClub toEscapedModel();

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

	public int compareTo(ESClub esClub);

	public int hashCode();

	public String toString();

	public String toXmlString();
}