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
 * This class is a wrapper for {@link ESPlayerClub}.
 * </p>
 *
 * @author    evangelistalc
 * @see       ESPlayerClub
 * @generated
 */
public class ESPlayerClubWrapper implements ESPlayerClub {
	public ESPlayerClubWrapper(ESPlayerClub esPlayerClub) {
		_esPlayerClub = esPlayerClub;
	}

	public long getPrimaryKey() {
		return _esPlayerClub.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_esPlayerClub.setPrimaryKey(pk);
	}

	public long getPlayerClubId() {
		return _esPlayerClub.getPlayerClubId();
	}

	public void setPlayerClubId(long playerClubId) {
		_esPlayerClub.setPlayerClubId(playerClubId);
	}

	public long getClubId() {
		return _esPlayerClub.getClubId();
	}

	public void setClubId(long clubId) {
		_esPlayerClub.setClubId(clubId);
	}

	public long getPlayerId() {
		return _esPlayerClub.getPlayerId();
	}

	public void setPlayerId(long playerId) {
		_esPlayerClub.setPlayerId(playerId);
	}

	public long getCompanyId() {
		return _esPlayerClub.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_esPlayerClub.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _esPlayerClub.getGroupId();
	}

	public void setGroupId(long groupId) {
		_esPlayerClub.setGroupId(groupId);
	}

	public long getUserId() {
		return _esPlayerClub.getUserId();
	}

	public void setUserId(long userId) {
		_esPlayerClub.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClub.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_esPlayerClub.setUserUuid(userUuid);
	}

	public java.lang.String getClubDesc() {
		return _esPlayerClub.getClubDesc();
	}

	public void setClubDesc(java.lang.String clubDesc) {
		_esPlayerClub.setClubDesc(clubDesc);
	}

	public int getLoft() {
		return _esPlayerClub.getLoft();
	}

	public void setLoft(int loft) {
		_esPlayerClub.setLoft(loft);
	}

	public int getNomSr() {
		return _esPlayerClub.getNomSr();
	}

	public void setNomSr(int nomSr) {
		_esPlayerClub.setNomSr(nomSr);
	}

	public int getNomSpeed() {
		return _esPlayerClub.getNomSpeed();
	}

	public void setNomSpeed(int nomSpeed) {
		_esPlayerClub.setNomSpeed(nomSpeed);
	}

	public double getCoR() {
		return _esPlayerClub.getCoR();
	}

	public void setCoR(double coR) {
		_esPlayerClub.setCoR(coR);
	}

	public int getWeight() {
		return _esPlayerClub.getWeight();
	}

	public void setWeight(int weight) {
		_esPlayerClub.setWeight(weight);
	}

	public java.lang.String getModel() {
		return _esPlayerClub.getModel();
	}

	public void setModel(java.lang.String model) {
		_esPlayerClub.setModel(model);
	}

	public boolean getActive() {
		return _esPlayerClub.getActive();
	}

	public boolean isActive() {
		return _esPlayerClub.isActive();
	}

	public void setActive(boolean active) {
		_esPlayerClub.setActive(active);
	}

	public java.util.Date getCreateDate() {
		return _esPlayerClub.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_esPlayerClub.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _esPlayerClub.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_esPlayerClub.setModifiedDate(modifiedDate);
	}

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub toEscapedModel() {
		return _esPlayerClub.toEscapedModel();
	}

	public boolean isNew() {
		return _esPlayerClub.isNew();
	}

	public void setNew(boolean n) {
		_esPlayerClub.setNew(n);
	}

	public boolean isCachedModel() {
		return _esPlayerClub.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_esPlayerClub.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _esPlayerClub.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_esPlayerClub.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _esPlayerClub.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esPlayerClub.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esPlayerClub.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _esPlayerClub.clone();
	}

	public int compareTo(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub) {
		return _esPlayerClub.compareTo(esPlayerClub);
	}

	public int hashCode() {
		return _esPlayerClub.hashCode();
	}

	public java.lang.String toString() {
		return _esPlayerClub.toString();
	}

	public java.lang.String toXmlString() {
		return _esPlayerClub.toXmlString();
	}

	public ESPlayerClub getWrappedESPlayerClub() {
		return _esPlayerClub;
	}

	private ESPlayerClub _esPlayerClub;
}