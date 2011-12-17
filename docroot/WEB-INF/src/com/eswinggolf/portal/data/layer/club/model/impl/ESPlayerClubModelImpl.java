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

package com.eswinggolf.portal.data.layer.club.model.impl;

import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClubModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the ESPlayerClub service. Represents a row in the &quot;es_ESPlayerClub&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.eswinggolf.portal.data.layer.club.model.ESPlayerClubModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESPlayerClubImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a e s player club model instance should use the {@link com.eswinggolf.portal.data.layer.club.model.ESPlayerClub} interface instead.
 * </p>
 *
 * @author evangelistalc
 * @see ESPlayerClubImpl
 * @see com.eswinggolf.portal.data.layer.club.model.ESPlayerClub
 * @see com.eswinggolf.portal.data.layer.club.model.ESPlayerClubModel
 * @generated
 */
public class ESPlayerClubModelImpl extends BaseModelImpl<ESPlayerClub>
	implements ESPlayerClubModel {
	public static final String TABLE_NAME = "es_ESPlayerClub";
	public static final Object[][] TABLE_COLUMNS = {
			{ "playerClubId", new Integer(Types.BIGINT) },
			{ "clubId", new Integer(Types.BIGINT) },
			{ "playerId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "userId", new Integer(Types.BIGINT) },
			{ "clubDesc", new Integer(Types.VARCHAR) },
			{ "loft", new Integer(Types.INTEGER) },
			{ "nomSr", new Integer(Types.INTEGER) },
			{ "nomSpeed", new Integer(Types.INTEGER) },
			{ "coR", new Integer(Types.DOUBLE) },
			{ "weight", new Integer(Types.INTEGER) },
			{ "model", new Integer(Types.VARCHAR) },
			{ "active_", new Integer(Types.BOOLEAN) },
			{ "createDate", new Integer(Types.TIMESTAMP) },
			{ "modifiedDate", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table es_ESPlayerClub (playerClubId LONG not null primary key,clubId LONG,playerId LONG,companyId LONG,groupId LONG,userId LONG,clubDesc VARCHAR(75) null,loft INTEGER,nomSr INTEGER,nomSpeed INTEGER,coR DOUBLE,weight INTEGER,model VARCHAR(75) null,active_ BOOLEAN,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table es_ESPlayerClub";
	public static final String ORDER_BY_JPQL = " ORDER BY esPlayerClub.clubId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY es_ESPlayerClub.clubId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.eswinggolf.portal.data.layer.club.model.ESPlayerClub"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.eswinggolf.portal.data.layer.club.model.ESPlayerClub"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.eswinggolf.portal.data.layer.club.model.ESPlayerClub"));

	public ESPlayerClubModelImpl() {
	}

	public long getPrimaryKey() {
		return _playerClubId;
	}

	public void setPrimaryKey(long pk) {
		setPlayerClubId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_playerClubId);
	}

	public long getPlayerClubId() {
		return _playerClubId;
	}

	public void setPlayerClubId(long playerClubId) {
		_playerClubId = playerClubId;
	}

	public long getClubId() {
		return _clubId;
	}

	public void setClubId(long clubId) {
		_clubId = clubId;
	}

	public long getPlayerId() {
		return _playerId;
	}

	public void setPlayerId(long playerId) {
		_playerId = playerId;
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

	public String getClubDesc() {
		if (_clubDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _clubDesc;
		}
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
		if (_model == null) {
			return StringPool.BLANK;
		}
		else {
			return _model;
		}
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

	public ESPlayerClub toEscapedModel() {
		if (isEscapedModel()) {
			return (ESPlayerClub)this;
		}
		else {
			return (ESPlayerClub)Proxy.newProxyInstance(ESPlayerClub.class.getClassLoader(),
				new Class[] { ESPlayerClub.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					ESPlayerClub.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		ESPlayerClubImpl esPlayerClubImpl = new ESPlayerClubImpl();

		esPlayerClubImpl.setPlayerClubId(getPlayerClubId());

		esPlayerClubImpl.setClubId(getClubId());

		esPlayerClubImpl.setPlayerId(getPlayerId());

		esPlayerClubImpl.setCompanyId(getCompanyId());

		esPlayerClubImpl.setGroupId(getGroupId());

		esPlayerClubImpl.setUserId(getUserId());

		esPlayerClubImpl.setClubDesc(getClubDesc());

		esPlayerClubImpl.setLoft(getLoft());

		esPlayerClubImpl.setNomSr(getNomSr());

		esPlayerClubImpl.setNomSpeed(getNomSpeed());

		esPlayerClubImpl.setCoR(getCoR());

		esPlayerClubImpl.setWeight(getWeight());

		esPlayerClubImpl.setModel(getModel());

		esPlayerClubImpl.setActive(getActive());

		esPlayerClubImpl.setCreateDate(getCreateDate());

		esPlayerClubImpl.setModifiedDate(getModifiedDate());

		return esPlayerClubImpl;
	}

	public int compareTo(ESPlayerClub esPlayerClub) {
		int value = 0;

		if (getClubId() < esPlayerClub.getClubId()) {
			value = -1;
		}
		else if (getClubId() > esPlayerClub.getClubId()) {
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

		ESPlayerClub esPlayerClub = null;

		try {
			esPlayerClub = (ESPlayerClub)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = esPlayerClub.getPrimaryKey();

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

		sb.append("{playerClubId=");
		sb.append(getPlayerClubId());
		sb.append(", clubId=");
		sb.append(getClubId());
		sb.append(", playerId=");
		sb.append(getPlayerId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", clubDesc=");
		sb.append(getClubDesc());
		sb.append(", loft=");
		sb.append(getLoft());
		sb.append(", nomSr=");
		sb.append(getNomSr());
		sb.append(", nomSpeed=");
		sb.append(getNomSpeed());
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
		sb.append("com.eswinggolf.portal.data.layer.club.model.ESPlayerClub");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>playerClubId</column-name><column-value><![CDATA[");
		sb.append(getPlayerClubId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clubId</column-name><column-value><![CDATA[");
		sb.append(getClubId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>playerId</column-name><column-value><![CDATA[");
		sb.append(getPlayerId());
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

	private long _playerClubId;
	private long _clubId;
	private long _playerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _clubDesc;
	private int _loft;
	private int _nomSr;
	private int _nomSpeed;
	private double _coR;
	private int _weight;
	private String _model;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
	private transient ExpandoBridge _expandoBridge;
}