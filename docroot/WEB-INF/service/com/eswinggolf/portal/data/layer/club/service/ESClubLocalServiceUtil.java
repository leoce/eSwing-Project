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
 * The utility for the e s club local service. This utility wraps {@link com.eswinggolf.portal.data.layer.club.service.impl.ESClubLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.eswinggolf.portal.data.layer.club.service.impl.ESClubLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author evangelistalc
 * @see ESClubLocalService
 * @see com.eswinggolf.portal.data.layer.club.service.base.ESClubLocalServiceBaseImpl
 * @see com.eswinggolf.portal.data.layer.club.service.impl.ESClubLocalServiceImpl
 * @generated
 */
public class ESClubLocalServiceUtil {
	/**
	* Adds the e s club to the database. Also notifies the appropriate model listeners.
	*
	* @param esClub the e s club to add
	* @return the e s club that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESClub addESClub(
		com.eswinggolf.portal.data.layer.club.model.ESClub esClub)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESClub(esClub);
	}

	/**
	* Creates a new e s club with the primary key. Does not add the e s club to the database.
	*
	* @param clubId the primary key for the new e s club
	* @return the new e s club
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESClub createESClub(
		long clubId) {
		return getService().createESClub(clubId);
	}

	/**
	* Deletes the e s club with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clubId the primary key of the e s club to delete
	* @throws PortalException if a e s club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteESClub(long clubId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteESClub(clubId);
	}

	/**
	* Deletes the e s club from the database. Also notifies the appropriate model listeners.
	*
	* @param esClub the e s club to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteESClub(
		com.eswinggolf.portal.data.layer.club.model.ESClub esClub)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteESClub(esClub);
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
	* Gets the e s club with the primary key.
	*
	* @param clubId the primary key of the e s club to get
	* @return the e s club
	* @throws PortalException if a e s club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESClub getESClub(
		long clubId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESClub(clubId);
	}

	/**
	* Gets a range of all the e s clubs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @return the range of e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> getESClubs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESClubs(start, end);
	}

	/**
	* Gets the number of e s clubs.
	*
	* @return the number of e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public static int getESClubsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESClubsCount();
	}

	/**
	* Updates the e s club in the database. Also notifies the appropriate model listeners.
	*
	* @param esClub the e s club to update
	* @return the e s club that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESClub updateESClub(
		com.eswinggolf.portal.data.layer.club.model.ESClub esClub)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESClub(esClub);
	}

	/**
	* Updates the e s club in the database. Also notifies the appropriate model listeners.
	*
	* @param esClub the e s club to update
	* @param merge whether to merge the e s club with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e s club that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESClub updateESClub(
		com.eswinggolf.portal.data.layer.club.model.ESClub esClub, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESClub(esClub, merge);
	}

	/**
	* Adds a new product to the database.
	*
	* @param clubName
	* @param clubDesc
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESClub addClub(
		com.eswinggolf.portal.data.layer.club.model.ESClub newClub)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addClub(newClub);
	}

	/**
	* Retrieves all of the clubs from the database.
	*
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> getAllClubs(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllClubs(groupId);
	}

	/**
	* Removes the specified club from the database.
	*
	* @param clubId
	* @throws com.inkwell.internet.portlets.prodreg.sb.NoSuchProductException
	* @throws com.liferay.portal.kernel.exception.SystemException
	* @throws com.liferay.portal.kernel.exception.PortalException
	*/
	public static void deleteClub(long clubId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteClub(clubId);
	}

	/**
	* Removes the specified club from the database.
	*
	* @param club
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static void deleteClub(
		com.eswinggolf.portal.data.layer.club.model.ESClub club)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteClub(club);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESClubLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ESClubLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ESClubLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ESClubLocalService service) {
		_service = service;
	}

	private static ESClubLocalService _service;
}