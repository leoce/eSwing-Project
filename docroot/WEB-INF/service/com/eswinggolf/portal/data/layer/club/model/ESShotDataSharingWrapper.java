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
 * This class is a wrapper for {@link ESShotDataSharing}.
 * </p>
 *
 * @author    evangelistalc
 * @see       ESShotDataSharing
 * @generated
 */
public class ESShotDataSharingWrapper implements ESShotDataSharing {
	public ESShotDataSharingWrapper(ESShotDataSharing esShotDataSharing) {
		_esShotDataSharing = esShotDataSharing;
	}

	public long getPrimaryKey() {
		return _esShotDataSharing.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_esShotDataSharing.setPrimaryKey(pk);
	}

	public long getShotDataSharingId() {
		return _esShotDataSharing.getShotDataSharingId();
	}

	public void setShotDataSharingId(long shotDataSharingId) {
		_esShotDataSharing.setShotDataSharingId(shotDataSharingId);
	}

	public long getShotDataId() {
		return _esShotDataSharing.getShotDataId();
	}

	public void setShotDataId(long shotDataId) {
		_esShotDataSharing.setShotDataId(shotDataId);
	}

	public long getPlayerId() {
		return _esShotDataSharing.getPlayerId();
	}

	public void setPlayerId(long playerId) {
		_esShotDataSharing.setPlayerId(playerId);
	}

	public long getUserId() {
		return _esShotDataSharing.getUserId();
	}

	public void setUserId(long userId) {
		_esShotDataSharing.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esShotDataSharing.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_esShotDataSharing.setUserUuid(userUuid);
	}

	public long getCompanyId() {
		return _esShotDataSharing.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_esShotDataSharing.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _esShotDataSharing.getGroupId();
	}

	public void setGroupId(long groupId) {
		_esShotDataSharing.setGroupId(groupId);
	}

	public boolean getActive() {
		return _esShotDataSharing.getActive();
	}

	public boolean isActive() {
		return _esShotDataSharing.isActive();
	}

	public void setActive(boolean active) {
		_esShotDataSharing.setActive(active);
	}

	public java.util.Date getCreateDate() {
		return _esShotDataSharing.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_esShotDataSharing.setCreateDate(createDate);
	}

	public java.util.Date getModifyDate() {
		return _esShotDataSharing.getModifyDate();
	}

	public void setModifyDate(java.util.Date modifyDate) {
		_esShotDataSharing.setModifyDate(modifyDate);
	}

	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing toEscapedModel() {
		return _esShotDataSharing.toEscapedModel();
	}

	public boolean isNew() {
		return _esShotDataSharing.isNew();
	}

	public void setNew(boolean n) {
		_esShotDataSharing.setNew(n);
	}

	public boolean isCachedModel() {
		return _esShotDataSharing.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_esShotDataSharing.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _esShotDataSharing.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_esShotDataSharing.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _esShotDataSharing.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esShotDataSharing.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esShotDataSharing.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _esShotDataSharing.clone();
	}

	public int compareTo(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing) {
		return _esShotDataSharing.compareTo(esShotDataSharing);
	}

	public int hashCode() {
		return _esShotDataSharing.hashCode();
	}

	public java.lang.String toString() {
		return _esShotDataSharing.toString();
	}

	public java.lang.String toXmlString() {
		return _esShotDataSharing.toXmlString();
	}

	public ESShotDataSharing getWrappedESShotDataSharing() {
		return _esShotDataSharing;
	}

	private ESShotDataSharing _esShotDataSharing;
}