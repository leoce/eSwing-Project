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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the e s shot data sharing local service. This utility wraps {@link com.eswinggolf.portal.data.layer.club.service.impl.ESShotDataSharingLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.eswinggolf.portal.data.layer.club.service.impl.ESShotDataSharingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author evangelistalc
 * @see ESShotDataSharingLocalService
 * @see com.eswinggolf.portal.data.layer.club.service.base.ESShotDataSharingLocalServiceBaseImpl
 * @see com.eswinggolf.portal.data.layer.club.service.impl.ESShotDataSharingLocalServiceImpl
 * @generated
 */
public class ESShotDataSharingLocalServiceUtil {
	/**
	* Adds the e s shot data sharing to the database. Also notifies the appropriate model listeners.
	*
	* @param esShotDataSharing the e s shot data sharing to add
	* @return the e s shot data sharing that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing addESShotDataSharing(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESShotDataSharing(esShotDataSharing);
	}

	/**
	* Creates a new e s shot data sharing with the primary key. Does not add the e s shot data sharing to the database.
	*
	* @param shotDataSharingId the primary key for the new e s shot data sharing
	* @return the new e s shot data sharing
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing createESShotDataSharing(
		long shotDataSharingId) {
		return getService().createESShotDataSharing(shotDataSharingId);
	}

	/**
	* Deletes the e s shot data sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shotDataSharingId the primary key of the e s shot data sharing to delete
	* @throws PortalException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteESShotDataSharing(long shotDataSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteESShotDataSharing(shotDataSharingId);
	}

	/**
	* Deletes the e s shot data sharing from the database. Also notifies the appropriate model listeners.
	*
	* @param esShotDataSharing the e s shot data sharing to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteESShotDataSharing(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteESShotDataSharing(esShotDataSharing);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the e s shot data sharing with the primary key.
	*
	* @param shotDataSharingId the primary key of the e s shot data sharing to get
	* @return the e s shot data sharing
	* @throws PortalException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing getESShotDataSharing(
		long shotDataSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESShotDataSharing(shotDataSharingId);
	}

	/**
	* Gets a range of all the e s shot data sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s shot data sharings to return
	* @param end the upper bound of the range of e s shot data sharings to return (not inclusive)
	* @return the range of e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> getESShotDataSharings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESShotDataSharings(start, end);
	}

	/**
	* Gets the number of e s shot data sharings.
	*
	* @return the number of e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int getESShotDataSharingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESShotDataSharingsCount();
	}

	/**
	* Updates the e s shot data sharing in the database. Also notifies the appropriate model listeners.
	*
	* @param esShotDataSharing the e s shot data sharing to update
	* @return the e s shot data sharing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing updateESShotDataSharing(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESShotDataSharing(esShotDataSharing);
	}

	/**
	* Updates the e s shot data sharing in the database. Also notifies the appropriate model listeners.
	*
	* @param esShotDataSharing the e s shot data sharing to update
	* @param merge whether to merge the e s shot data sharing with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e s shot data sharing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing updateESShotDataSharing(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESShotDataSharing(esShotDataSharing, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESShotDataSharingLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ESShotDataSharingLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ESShotDataSharingLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ESShotDataSharingLocalService service) {
		_service = service;
	}

	private static ESShotDataSharingLocalService _service;
}