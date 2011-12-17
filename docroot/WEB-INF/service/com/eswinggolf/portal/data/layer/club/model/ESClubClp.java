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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author evangelistalc
 */
public class ESClubClp extends BaseModelImpl<ESClub> implements ESClub {
	public ESClubClp() {
	}

	public long getPrimaryKey() {
		return _clubId;
	}

	public void setPrimaryKey(long pk) {
		setClubId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_clubId);
	}

	public long getClubId() {
		return _clubId;
	}

	public void setClubId(long clubId) {
		_clubId = clubId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getClubName() {
		return _clubName;
	}

	public void setClubName(String clubName) {
		_clubName = clubName;
	}

	public String getClubDesc() {
		return _clubDesc;
	}

	public void setClubDesc(String clubDesc) {
		_clubDesc = clubDesc;
	}

	public int getLoft() {
		return _loft;
	}

	public void setLoft(int loft) {
		_loft = loft;
	}

	public int getNomSr() {
		return _nomSr;
	}

	public void setNomSr(int nomSr) {
		_nomSr = nomSr;
	}

	public int getNomSpeed() {
		return _nomSpeed;
	}

	public void setNomSpeed(int nomSpeed) {
		_nomSpeed = nomSpeed;
	}

	public int getLaunchAngle() {
		return _launchAngle;
	}

	public void setLaunchAngle(int launchAngle) {
		_launchAngle = launchAngle;
	}

	public double getCoR() {
		return _coR;
	}

	public void setCoR(double coR) {
		_coR = coR;
	}

	public int getWeight() {
		return _weight;
	}

	public void setWeight(int weight) {
		_weight = weight;
	}

	public String getModel() {
		return _model;
	}

	public void setModel(String model) {
		_model = model;
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

	public ESClub toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ESClub)Proxy.newProxyInstance(ESClub.class.getClassLoader(),
				new Class[] { ESClub.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ESClubClp clone = new ESClubClp();

		clone.setClubId(getClubId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setClubName(getClubName());
		clone.setClubDesc(getClubDesc());
		clone.setLoft(getLoft());
		clone.setNomSr(getNomSr());
		clone.setNomSpeed(getNomSpeed());
		clone.setLaunchAngle(getLaunchAngle());
		clone.setCoR(getCoR());
		clone.setWeight(getWeight());
		clone.setModel(getModel());
		clone.setActive(getActive());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(ESClub esClub) {
		int value = 0;

		value = getClubName().compareTo(esClub.getClubName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ESClubClp esClub = null;

		try {
			esClub = (ESClubClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = esClub.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{clubId=");
		sb.append(getClubId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", clubName=");
		sb.append(getClubName());
		sb.append(", clubDesc=");
		sb.append(getClubDesc());
		sb.append(", loft=");
		sb.append(getLoft());
		sb.append(", nomSr=");
		sb.append(getNomSr());
		sb.append(", nomSpeed=");
		sb.append(getNomSpeed());
		sb.append(", launchAngle=");
		sb.append(getLaunchAngle());
		sb.append(", coR=");
		sb.append(getCoR());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append(", model=");
		sb.append(getModel());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.eswinggolf.portal.data.layer.club.model.ESClub");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>clubId</column-name><column-value><![CDATA[");
		sb.append(getClubId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clubName</column-name><column-value><![CDATA[");
		sb.append(getClubName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clubDesc</column-name><column-value><![CDATA[");
		sb.append(getClubDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loft</column-name><column-value><![CDATA[");
		sb.append(getLoft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomSr</column-name><column-value><![CDATA[");
		sb.append(getNomSr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomSpeed</column-name><column-value><![CDATA[");
		sb.append(getNomSpeed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>launchAngle</column-name><column-value><![CDATA[");
		sb.append(getLaunchAngle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coR</column-name><column-value><![CDATA[");
		sb.append(getCoR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>model</column-name><column-value><![CDATA[");
		sb.append(getModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
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

	private long _clubId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _clubName;
	private String _clubDesc;
	private int _loft;
	private int _nomSr;
	private int _nomSpeed;
	private int _launchAngle;
	private double _coR;
	private int _weight;
	private String _model;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
}