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

/**
 * <p>
 * This class is a wrapper for {@link ESClub}.
 * </p>
 *
 * @author    evangelistalc
 * @see       ESClub
 * @generated
 */
public class ESClubWrapper implements ESClub {
	public ESClubWrapper(ESClub esClub) {
		_esClub = esClub;
	}

	public long getPrimaryKey() {
		return _esClub.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_esClub.setPrimaryKey(pk);
	}

	public long getClubId() {
		return _esClub.getClubId();
	}

	public void setClubId(long clubId) {
		_esClub.setClubId(clubId);
	}

	public long getCompanyId() {
		return _esClub.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_esClub.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _esClub.getGroupId();
	}

	public void setGroupId(long groupId) {
		_esClub.setGroupId(groupId);
	}

	public long getUserId() {
		return _esClub.getUserId();
	}

	public void setUserId(long userId) {
		_esClub.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esClub.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_esClub.setUserUuid(userUuid);
	}

	public java.lang.String getClubName() {
		return _esClub.getClubName();
	}

	public void setClubName(java.lang.String clubName) {
		_esClub.setClubName(clubName);
	}

	public java.lang.String getClubDesc() {
		return _esClub.getClubDesc();
	}

	public void setClubDesc(java.lang.String clubDesc) {
		_esClub.setClubDesc(clubDesc);
	}

	public int getLoft() {
		return _esClub.getLoft();
	}

	public void setLoft(int loft) {
		_esClub.setLoft(loft);
	}

	public int getNomSr() {
		return _esClub.getNomSr();
	}

	public void setNomSr(int nomSr) {
		_esClub.setNomSr(nomSr);
	}

	public int getNomSpeed() {
		return _esClub.getNomSpeed();
	}

	public void setNomSpeed(int nomSpeed) {
		_esClub.setNomSpeed(nomSpeed);
	}

	public int getLaunchAngle() {
		return _esClub.getLaunchAngle();
	}

	public void setLaunchAngle(int launchAngle) {
		_esClub.setLaunchAngle(launchAngle);
	}

	public double getCoR() {
		return _esClub.getCoR();
	}

	public void setCoR(double coR) {
		_esClub.setCoR(coR);
	}

	public int getWeight() {
		return _esClub.getWeight();
	}

	public void setWeight(int weight) {
		_esClub.setWeight(weight);
	}

	public java.lang.String getModel() {
		return _esClub.getModel();
	}

	public void setModel(java.lang.String model) {
		_esClub.setModel(model);
	}

	public boolean getActive() {
		return _esClub.getActive();
	}

	public boolean isActive() {
		return _esClub.isActive();
	}

	public void setActive(boolean active) {
		_esClub.setActive(active);
	}

	public java.util.Date getCreateDate() {
		return _esClub.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_esClub.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _esClub.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_esClub.setModifiedDate(modifiedDate);
	}

	public com.eswinggolf.portal.data.layer.club.model.ESClub toEscapedModel() {
		return _esClub.toEscapedModel();
	}

	public boolean isNew() {
		return _esClub.isNew();
	}

	public void setNew(boolean n) {
		_esClub.setNew(n);
	}

	public boolean isCachedModel() {
		return _esClub.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_esClub.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _esClub.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_esClub.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _esClub.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esClub.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esClub.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _esClub.clone();
	}

	public int compareTo(
		com.eswinggolf.portal.data.layer.club.model.ESClub esClub) {
		return _esClub.compareTo(esClub);
	}

	public int hashCode() {
		return _esClub.hashCode();
	}

	public java.lang.String toString() {
		return _esClub.toString();
	}

	public java.lang.String toXmlString() {
		return _esClub.toXmlString();
	}

	public ESClub getWrappedESClub() {
		return _esClub;
	}

	private ESClub _esClub;
}