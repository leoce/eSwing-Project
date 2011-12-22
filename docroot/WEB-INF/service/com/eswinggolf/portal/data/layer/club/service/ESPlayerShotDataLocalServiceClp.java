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

package com.eswinggolf.portal.data.layer.club.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author evangelistalc
 */
public class ESPlayerShotDataLocalServiceClp
	implements ESPlayerShotDataLocalService {
	public ESPlayerShotDataLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData addESPlayerShotData(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData esPlayerShotData)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addESPlayerShotDataMethodKey0,
				esPlayerShotData);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData)ClpSerializer.translateOutput(returnObj);
	}

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData createESPlayerShotData(
		long shotDataId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createESPlayerShotDataMethodKey1,
				shotDataId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteESPlayerShotData(long shotDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteESPlayerShotDataMethodKey2,
				shotDataId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteESPlayerShotData(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData esPlayerShotData)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteESPlayerShotDataMethodKey3,
				esPlayerShotData);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				dynamicQuery, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				dynamicQuery, start, end, orderByComparator);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData getESPlayerShotData(
		long shotDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getESPlayerShotDataMethodKey8,
				shotDataId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> getESPlayerShotDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getESPlayerShotDatasMethodKey9,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData>)ClpSerializer.translateOutput(returnObj);
	}

	public int getESPlayerShotDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getESPlayerShotDatasCountMethodKey10);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData updateESPlayerShotData(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData esPlayerShotData)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateESPlayerShotDataMethodKey11,
				esPlayerShotData);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData)ClpSerializer.translateOutput(returnObj);
	}

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData updateESPlayerShotData(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData esPlayerShotData,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateESPlayerShotDataMethodKey12,
				esPlayerShotData, merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData)ClpSerializer.translateOutput(returnObj);
	}

	public void addESPlayerShotData(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addESPlayerShotDataMethodKey13,
				playerId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteESTrialShotData(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteESTrialShotDataMethodKey14,
				playerId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> getAllPlayerShotData(
		long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllPlayerShotDataMethodKey15,
				playerId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> getAllClubShotByPlayer(
		long playerId, long clubId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllClubShotByPlayerMethodKey16,
				playerId, clubId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> getClubShotDataByDate(
		long playerId, java.util.Date created)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getClubShotDataByDateMethodKey17,
				playerId, created);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> getClubShotDataByScopeDate(
		long playerId, java.util.Date begin, java.util.Date end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getClubShotDataByScopeDateMethodKey18,
				playerId, begin, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addESPlayerShotDataMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
			"addESPlayerShotData",
			com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData.class);
	private MethodKey _createESPlayerShotDataMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
			"createESPlayerShotData", long.class);
	private MethodKey _deleteESPlayerShotDataMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteESPlayerShotData", long.class);
	private MethodKey _deleteESPlayerShotDataMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteESPlayerShotData",
			com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData.class);
	private MethodKey _dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery", com.liferay.portal.kernel.dao.orm.DynamicQuery.class);
	private MethodKey _dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class, int.class,
			int.class);
	private MethodKey _dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class, int.class,
			int.class, com.liferay.portal.kernel.util.OrderByComparator.class);
	private MethodKey _dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQueryCount",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class);
	private MethodKey _getESPlayerShotDataMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
			"getESPlayerShotData", long.class);
	private MethodKey _getESPlayerShotDatasMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
			"getESPlayerShotDatas", int.class, int.class);
	private MethodKey _getESPlayerShotDatasCountMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
			"getESPlayerShotDatasCount");
	private MethodKey _updateESPlayerShotDataMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
			"updateESPlayerShotData",
			com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData.class);
	private MethodKey _updateESPlayerShotDataMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
			"updateESPlayerShotData",
			com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData.class,
			boolean.class);
	private MethodKey _addESPlayerShotDataMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
			"addESPlayerShotData", long.class);
	private MethodKey _deleteESTrialShotDataMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteESTrialShotData", long.class);
	private MethodKey _getAllPlayerShotDataMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
			"getAllPlayerShotData", long.class);
	private MethodKey _getAllClubShotByPlayerMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
			"getAllClubShotByPlayer", long.class, long.class);
	private MethodKey _getClubShotDataByDateMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
			"getClubShotDataByDate", long.class, java.util.Date.class);
	private MethodKey _getClubShotDataByScopeDateMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
			"getClubShotDataByScopeDate", long.class, java.util.Date.class,
			java.util.Date.class);
}