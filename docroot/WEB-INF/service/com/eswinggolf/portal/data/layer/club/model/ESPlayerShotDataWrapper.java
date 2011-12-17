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
 * This class is a wrapper for {@link ESPlayerShotData}.
 * </p>
 *
 * @author    evangelistalc
 * @see       ESPlayerShotData
 * @generated
 */
public class ESPlayerShotDataWrapper implements ESPlayerShotData {
	public ESPlayerShotDataWrapper(ESPlayerShotData esPlayerShotData) {
		_esPlayerShotData = esPlayerShotData;
	}

	public long getPrimaryKey() {
		return _esPlayerShotData.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_esPlayerShotData.setPrimaryKey(pk);
	}

	public long getShotDataId() {
		return _esPlayerShotData.getShotDataId();
	}

	public void setShotDataId(long shotDataId) {
		_esPlayerShotData.setShotDataId(shotDataId);
	}

	public long getPlayerId() {
		return _esPlayerShotData.getPlayerId();
	}

	public void setPlayerId(long playerId) {
		_esPlayerShotData.setPlayerId(playerId);
	}

	public long getPlayerClubId() {
		return _esPlayerShotData.getPlayerClubId();
	}

	public void setPlayerClubId(long playerClubId) {
		_esPlayerShotData.setPlayerClubId(playerClubId);
	}

	public int getProductSerialNo() {
		return _esPlayerShotData.getProductSerialNo();
	}

	public void setProductSerialNo(int productSerialNo) {
		_esPlayerShotData.setProductSerialNo(productSerialNo);
	}

	public boolean getLaunchMonitor() {
		return _esPlayerShotData.getLaunchMonitor();
	}

	public boolean isLaunchMonitor() {
		return _esPlayerShotData.isLaunchMonitor();
	}

	public void setLaunchMonitor(boolean launchMonitor) {
		_esPlayerShotData.setLaunchMonitor(launchMonitor);
	}

	public boolean getSimulate() {
		return _esPlayerShotData.getSimulate();
	}

	public boolean isSimulate() {
		return _esPlayerShotData.isSimulate();
	}

	public void setSimulate(boolean simulate) {
		_esPlayerShotData.setSimulate(simulate);
	}

	public boolean getActive() {
		return _esPlayerShotData.getActive();
	}

	public boolean isActive() {
		return _esPlayerShotData.isActive();
	}

	public void setActive(boolean active) {
		_esPlayerShotData.setActive(active);
	}

	public int getClubLoft() {
		return _esPlayerShotData.getClubLoft();
	}

	public void setClubLoft(int clubLoft) {
		_esPlayerShotData.setClubLoft(clubLoft);
	}

	public int getClubSpeed() {
		return _esPlayerShotData.getClubSpeed();
	}

	public void setClubSpeed(int clubSpeed) {
		_esPlayerShotData.setClubSpeed(clubSpeed);
	}

	public int getFaceAngle() {
		return _esPlayerShotData.getFaceAngle();
	}

	public void setFaceAngle(int faceAngle) {
		_esPlayerShotData.setFaceAngle(faceAngle);
	}

	public int getSwingPath() {
		return _esPlayerShotData.getSwingPath();
	}

	public void setSwingPath(int swingPath) {
		_esPlayerShotData.setSwingPath(swingPath);
	}

	public int getSpinAxisAngle() {
		return _esPlayerShotData.getSpinAxisAngle();
	}

	public void setSpinAxisAngle(int spinAxisAngle) {
		_esPlayerShotData.setSpinAxisAngle(spinAxisAngle);
	}

	public int getLaunchAngle() {
		return _esPlayerShotData.getLaunchAngle();
	}

	public void setLaunchAngle(int launchAngle) {
		_esPlayerShotData.setLaunchAngle(launchAngle);
	}

	public int getBallSpeed() {
		return _esPlayerShotData.getBallSpeed();
	}

	public void setBallSpeed(int ballSpeed) {
		_esPlayerShotData.setBallSpeed(ballSpeed);
	}

	public int getBallSpinRate() {
		return _esPlayerShotData.getBallSpinRate();
	}

	public void setBallSpinRate(int ballSpinRate) {
		_esPlayerShotData.setBallSpinRate(ballSpinRate);
	}

	public double getBallAngleOfAttack() {
		return _esPlayerShotData.getBallAngleOfAttack();
	}

	public void setBallAngleOfAttack(double ballAngleOfAttack) {
		_esPlayerShotData.setBallAngleOfAttack(ballAngleOfAttack);
	}

	public double getBallCompression() {
		return _esPlayerShotData.getBallCompression();
	}

	public void setBallCompression(double ballCompression) {
		_esPlayerShotData.setBallCompression(ballCompression);
	}

	public double getStepTimeIncrement() {
		return _esPlayerShotData.getStepTimeIncrement();
	}

	public void setStepTimeIncrement(double stepTimeIncrement) {
		_esPlayerShotData.setStepTimeIncrement(stepTimeIncrement);
	}

	public int getWindSpeed() {
		return _esPlayerShotData.getWindSpeed();
	}

	public void setWindSpeed(int windSpeed) {
		_esPlayerShotData.setWindSpeed(windSpeed);
	}

	public int getWindDirection() {
		return _esPlayerShotData.getWindDirection();
	}

	public void setWindDirection(int windDirection) {
		_esPlayerShotData.setWindDirection(windDirection);
	}

	public int getAmbientTemp() {
		return _esPlayerShotData.getAmbientTemp();
	}

	public void setAmbientTemp(int ambientTemp) {
		_esPlayerShotData.setAmbientTemp(ambientTemp);
	}

	public int getBarPressureAlt() {
		return _esPlayerShotData.getBarPressureAlt();
	}

	public void setBarPressureAlt(int barPressureAlt) {
		_esPlayerShotData.setBarPressureAlt(barPressureAlt);
	}

	public int getRelativeHumid() {
		return _esPlayerShotData.getRelativeHumid();
	}

	public void setRelativeHumid(int relativeHumid) {
		_esPlayerShotData.setRelativeHumid(relativeHumid);
	}

	public double getFairwayFirmness() {
		return _esPlayerShotData.getFairwayFirmness();
	}

	public void setFairwayFirmness(double fairwayFirmness) {
		_esPlayerShotData.setFairwayFirmness(fairwayFirmness);
	}

	public java.util.Date getCreateDate() {
		return _esPlayerShotData.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_esPlayerShotData.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _esPlayerShotData.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_esPlayerShotData.setModifiedDate(modifiedDate);
	}

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData toEscapedModel() {
		return _esPlayerShotData.toEscapedModel();
	}

	public boolean isNew() {
		return _esPlayerShotData.isNew();
	}

	public void setNew(boolean n) {
		_esPlayerShotData.setNew(n);
	}

	public boolean isCachedModel() {
		return _esPlayerShotData.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_esPlayerShotData.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _esPlayerShotData.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_esPlayerShotData.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _esPlayerShotData.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esPlayerShotData.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esPlayerShotData.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _esPlayerShotData.clone();
	}

	public int compareTo(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData esPlayerShotData) {
		return _esPlayerShotData.compareTo(esPlayerShotData);
	}

	public int hashCode() {
		return _esPlayerShotData.hashCode();
	}

	public java.lang.String toString() {
		return _esPlayerShotData.toString();
	}

	public java.lang.String toXmlString() {
		return _esPlayerShotData.toXmlString();
	}

	public ESPlayerShotData getWrappedESPlayerShotData() {
		return _esPlayerShotData;
	}

	private ESPlayerShotData _esPlayerShotData;
}