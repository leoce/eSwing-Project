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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author evangelistalc
 */
public class ESPlayerShotDataClp extends BaseModelImpl<ESPlayerShotData>
	implements ESPlayerShotData {
	public ESPlayerShotDataClp() {
	}

	public long getPrimaryKey() {
		return _shotDataId;
	}

	public void setPrimaryKey(long pk) {
		setShotDataId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_shotDataId);
	}

	public long getShotDataId() {
		return _shotDataId;
	}

	public void setShotDataId(long shotDataId) {
		_shotDataId = shotDataId;
	}

	public long getPlayerId() {
		return _playerId;
	}

	public void setPlayerId(long playerId) {
		_playerId = playerId;
	}

	public long getPlayerClubId() {
		return _playerClubId;
	}

	public void setPlayerClubId(long playerClubId) {
		_playerClubId = playerClubId;
	}

	public int getProductSerialNo() {
		return _productSerialNo;
	}

	public void setProductSerialNo(int productSerialNo) {
		_productSerialNo = productSerialNo;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public boolean getLaunchMonitor() {
		return _launchMonitor;
	}

	public boolean isLaunchMonitor() {
		return _launchMonitor;
	}

	public void setLaunchMonitor(boolean launchMonitor) {
		_launchMonitor = launchMonitor;
	}

	public boolean getSimulate() {
		return _simulate;
	}

	public boolean isSimulate() {
		return _simulate;
	}

	public void setSimulate(boolean simulate) {
		_simulate = simulate;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public int getClubLoft() {
		return _clubLoft;
	}

	public void setClubLoft(int clubLoft) {
		_clubLoft = clubLoft;
	}

	public int getClubSpeed() {
		return _clubSpeed;
	}

	public void setClubSpeed(int clubSpeed) {
		_clubSpeed = clubSpeed;
	}

	public int getFaceAngle() {
		return _faceAngle;
	}

	public void setFaceAngle(int faceAngle) {
		_faceAngle = faceAngle;
	}

	public int getSwingPath() {
		return _swingPath;
	}

	public void setSwingPath(int swingPath) {
		_swingPath = swingPath;
	}

	public int getSpinAxisAngle() {
		return _spinAxisAngle;
	}

	public void setSpinAxisAngle(int spinAxisAngle) {
		_spinAxisAngle = spinAxisAngle;
	}

	public int getLaunchAngle() {
		return _launchAngle;
	}

	public void setLaunchAngle(int launchAngle) {
		_launchAngle = launchAngle;
	}

	public int getBallSpeed() {
		return _ballSpeed;
	}

	public void setBallSpeed(int ballSpeed) {
		_ballSpeed = ballSpeed;
	}

	public int getBallSpinRate() {
		return _ballSpinRate;
	}

	public void setBallSpinRate(int ballSpinRate) {
		_ballSpinRate = ballSpinRate;
	}

	public double getBallAngleOfAttack() {
		return _ballAngleOfAttack;
	}

	public void setBallAngleOfAttack(double ballAngleOfAttack) {
		_ballAngleOfAttack = ballAngleOfAttack;
	}

	public double getBallCompression() {
		return _ballCompression;
	}

	public void setBallCompression(double ballCompression) {
		_ballCompression = ballCompression;
	}

	public double getStepTimeIncrement() {
		return _stepTimeIncrement;
	}

	public void setStepTimeIncrement(double stepTimeIncrement) {
		_stepTimeIncrement = stepTimeIncrement;
	}

	public int getWindSpeed() {
		return _windSpeed;
	}

	public void setWindSpeed(int windSpeed) {
		_windSpeed = windSpeed;
	}

	public int getWindDirection() {
		return _windDirection;
	}

	public void setWindDirection(int windDirection) {
		_windDirection = windDirection;
	}

	public int getAmbientTemp() {
		return _ambientTemp;
	}

	public void setAmbientTemp(int ambientTemp) {
		_ambientTemp = ambientTemp;
	}

	public int getBarPressureAlt() {
		return _barPressureAlt;
	}

	public void setBarPressureAlt(int barPressureAlt) {
		_barPressureAlt = barPressureAlt;
	}

	public int getRelativeHumid() {
		return _relativeHumid;
	}

	public void setRelativeHumid(int relativeHumid) {
		_relativeHumid = relativeHumid;
	}

	public double getFairwayFirmness() {
		return _fairwayFirmness;
	}

	public void setFairwayFirmness(double fairwayFirmness) {
		_fairwayFirmness = fairwayFirmness;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public ESPlayerShotData toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ESPlayerShotData)Proxy.newProxyInstance(ESPlayerShotData.class.getClassLoader(),
				new Class[] { ESPlayerShotData.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ESPlayerShotDataClp clone = new ESPlayerShotDataClp();

		clone.setShotDataId(getShotDataId());
		clone.setPlayerId(getPlayerId());
		clone.setPlayerClubId(getPlayerClubId());
		clone.setProductSerialNo(getProductSerialNo());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setLaunchMonitor(getLaunchMonitor());
		clone.setSimulate(getSimulate());
		clone.setActive(getActive());
		clone.setClubLoft(getClubLoft());
		clone.setClubSpeed(getClubSpeed());
		clone.setFaceAngle(getFaceAngle());
		clone.setSwingPath(getSwingPath());
		clone.setSpinAxisAngle(getSpinAxisAngle());
		clone.setLaunchAngle(getLaunchAngle());
		clone.setBallSpeed(getBallSpeed());
		clone.setBallSpinRate(getBallSpinRate());
		clone.setBallAngleOfAttack(getBallAngleOfAttack());
		clone.setBallCompression(getBallCompression());
		clone.setStepTimeIncrement(getStepTimeIncrement());
		clone.setWindSpeed(getWindSpeed());
		clone.setWindDirection(getWindDirection());
		clone.setAmbientTemp(getAmbientTemp());
		clone.setBarPressureAlt(getBarPressureAlt());
		clone.setRelativeHumid(getRelativeHumid());
		clone.setFairwayFirmness(getFairwayFirmness());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(ESPlayerShotData esPlayerShotData) {
		int value = 0;

		if (getPlayerId() < esPlayerShotData.getPlayerId()) {
			value = -1;
		}
		else if (getPlayerId() > esPlayerShotData.getPlayerId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(),
				esPlayerShotData.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ESPlayerShotDataClp esPlayerShotData = null;

		try {
			esPlayerShotData = (ESPlayerShotDataClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = esPlayerShotData.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{shotDataId=");
		sb.append(getShotDataId());
		sb.append(", playerId=");
		sb.append(getPlayerId());
		sb.append(", playerClubId=");
		sb.append(getPlayerClubId());
		sb.append(", productSerialNo=");
		sb.append(getProductSerialNo());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", launchMonitor=");
		sb.append(getLaunchMonitor());
		sb.append(", simulate=");
		sb.append(getSimulate());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", clubLoft=");
		sb.append(getClubLoft());
		sb.append(", clubSpeed=");
		sb.append(getClubSpeed());
		sb.append(", faceAngle=");
		sb.append(getFaceAngle());
		sb.append(", swingPath=");
		sb.append(getSwingPath());
		sb.append(", spinAxisAngle=");
		sb.append(getSpinAxisAngle());
		sb.append(", launchAngle=");
		sb.append(getLaunchAngle());
		sb.append(", ballSpeed=");
		sb.append(getBallSpeed());
		sb.append(", ballSpinRate=");
		sb.append(getBallSpinRate());
		sb.append(", ballAngleOfAttack=");
		sb.append(getBallAngleOfAttack());
		sb.append(", ballCompression=");
		sb.append(getBallCompression());
		sb.append(", stepTimeIncrement=");
		sb.append(getStepTimeIncrement());
		sb.append(", windSpeed=");
		sb.append(getWindSpeed());
		sb.append(", windDirection=");
		sb.append(getWindDirection());
		sb.append(", ambientTemp=");
		sb.append(getAmbientTemp());
		sb.append(", barPressureAlt=");
		sb.append(getBarPressureAlt());
		sb.append(", relativeHumid=");
		sb.append(getRelativeHumid());
		sb.append(", fairwayFirmness=");
		sb.append(getFairwayFirmness());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append(
			"com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>shotDataId</column-name><column-value><![CDATA[");
		sb.append(getShotDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>playerId</column-name><column-value><![CDATA[");
		sb.append(getPlayerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>playerClubId</column-name><column-value><![CDATA[");
		sb.append(getPlayerClubId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productSerialNo</column-name><column-value><![CDATA[");
		sb.append(getProductSerialNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>launchMonitor</column-name><column-value><![CDATA[");
		sb.append(getLaunchMonitor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulate</column-name><column-value><![CDATA[");
		sb.append(getSimulate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clubLoft</column-name><column-value><![CDATA[");
		sb.append(getClubLoft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clubSpeed</column-name><column-value><![CDATA[");
		sb.append(getClubSpeed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>faceAngle</column-name><column-value><![CDATA[");
		sb.append(getFaceAngle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>swingPath</column-name><column-value><![CDATA[");
		sb.append(getSwingPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spinAxisAngle</column-name><column-value><![CDATA[");
		sb.append(getSpinAxisAngle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>launchAngle</column-name><column-value><![CDATA[");
		sb.append(getLaunchAngle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ballSpeed</column-name><column-value><![CDATA[");
		sb.append(getBallSpeed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ballSpinRate</column-name><column-value><![CDATA[");
		sb.append(getBallSpinRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ballAngleOfAttack</column-name><column-value><![CDATA[");
		sb.append(getBallAngleOfAttack());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ballCompression</column-name><column-value><![CDATA[");
		sb.append(getBallCompression());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stepTimeIncrement</column-name><column-value><![CDATA[");
		sb.append(getStepTimeIncrement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>windSpeed</column-name><column-value><![CDATA[");
		sb.append(getWindSpeed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>windDirection</column-name><column-value><![CDATA[");
		sb.append(getWindDirection());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ambientTemp</column-name><column-value><![CDATA[");
		sb.append(getAmbientTemp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>barPressureAlt</column-name><column-value><![CDATA[");
		sb.append(getBarPressureAlt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relativeHumid</column-name><column-value><![CDATA[");
		sb.append(getRelativeHumid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fairwayFirmness</column-name><column-value><![CDATA[");
		sb.append(getFairwayFirmness());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _shotDataId;
	private long _playerId;
	private long _playerClubId;
	private int _productSerialNo;
	private long _companyId;
	private long _groupId;
	private boolean _launchMonitor;
	private boolean _simulate;
	private boolean _active;
	private int _clubLoft;
	private int _clubSpeed;
	private int _faceAngle;
	private int _swingPath;
	private int _spinAxisAngle;
	private int _launchAngle;
	private int _ballSpeed;
	private int _ballSpinRate;
	private double _ballAngleOfAttack;
	private double _ballCompression;
	private double _stepTimeIncrement;
	private int _windSpeed;
	private int _windDirection;
	private int _ambientTemp;
	private int _barPressureAlt;
	private int _relativeHumid;
	private double _fairwayFirmness;
	private Date _createDate;
	private Date _modifiedDate;
}