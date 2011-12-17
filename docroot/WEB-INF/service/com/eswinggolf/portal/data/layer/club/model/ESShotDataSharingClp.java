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
public class ESShotDataSharingClp extends BaseModelImpl<ESShotDataSharing>
	implements ESShotDataSharing {
	public ESShotDataSharingClp() {
	}

	public long getPrimaryKey() {
		return _shotDataSharingId;
	}

	public void setPrimaryKey(long pk) {
		setShotDataSharingId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_shotDataSharingId);
	}

	public long getShotDataSharingId() {
		return _shotDataSharingId;
	}

	public void setShotDataSharingId(long shotDataSharingId) {
		_shotDataSharingId = shotDataSharingId;
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

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	public ESShotDataSharing toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ESShotDataSharing)Proxy.newProxyInstance(ESShotDataSharing.class.getClassLoader(),
				new Class[] { ESShotDataSharing.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ESShotDataSharingClp clone = new ESShotDataSharingClp();

		clone.setShotDataSharingId(getShotDataSharingId());
		clone.setShotDataId(getShotDataId());
		clone.setPlayerId(getPlayerId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setActive(getActive());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());

		return clone;
	}

	public int compareTo(ESShotDataSharing esShotDataSharing) {
		int value = 0;

		if (getGroupId() < esShotDataSharing.getGroupId()) {
			value = -1;
		}
		else if (getGroupId() > esShotDataSharing.getGroupId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ESShotDataSharingClp esShotDataSharing = null;

		try {
			esShotDataSharing = (ESShotDataSharingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = esShotDataSharing.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{shotDataSharingId=");
		sb.append(getShotDataSharingId());
		sb.append(", shotDataId=");
		sb.append(getShotDataId());
		sb.append(", playerId=");
		sb.append(getPlayerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>shotDataSharingId</column-name><column-value><![CDATA[");
		sb.append(getShotDataSharingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shotDataId</column-name><column-value><![CDATA[");
		sb.append(getShotDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>playerId</column-name><column-value><![CDATA[");
		sb.append(getPlayerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _shotDataSharingId;
	private long _shotDataId;
	private long _playerId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _groupId;
	private boolean _active;
	private Date _createDate;
	private Date _modifyDate;
}