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

package com.eswinggolf.portal.data.layer.club.service.persistence;

import com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e s shot data sharing service. This utility wraps {@link ESShotDataSharingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESShotDataSharingPersistence
 * @see ESShotDataSharingPersistenceImpl
 * @generated
 */
public class ESShotDataSharingUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ESShotDataSharing esShotDataSharing) {
		getPersistence().clearCache(esShotDataSharing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ESShotDataSharing> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESShotDataSharing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESShotDataSharing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ESShotDataSharing remove(ESShotDataSharing esShotDataSharing)
		throws SystemException {
		return getPersistence().remove(esShotDataSharing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ESShotDataSharing update(
		ESShotDataSharing esShotDataSharing, boolean merge)
		throws SystemException {
		return getPersistence().update(esShotDataSharing, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ESShotDataSharing update(
		ESShotDataSharing esShotDataSharing, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esShotDataSharing, merge, serviceContext);
	}

	/**
	* Caches the e s shot data sharing in the entity cache if it is enabled.
	*
	* @param esShotDataSharing the e s shot data sharing to cache
	*/
	public static void cacheResult(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing) {
		getPersistence().cacheResult(esShotDataSharing);
	}

	/**
	* Caches the e s shot data sharings in the entity cache if it is enabled.
	*
	* @param esShotDataSharings the e s shot data sharings to cache
	*/
	public static void cacheResult(
		java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> esShotDataSharings) {
		getPersistence().cacheResult(esShotDataSharings);
	}

	/**
	* Creates a new e s shot data sharing with the primary key. Does not add the e s shot data sharing to the database.
	*
	* @param shotDataSharingId the primary key for the new e s shot data sharing
	* @return the new e s shot data sharing
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing create(
		long shotDataSharingId) {
		return getPersistence().create(shotDataSharingId);
	}

	/**
	* Removes the e s shot data sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shotDataSharingId the primary key of the e s shot data sharing to remove
	* @return the e s shot data sharing that was removed
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing remove(
		long shotDataSharingId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(shotDataSharingId);
	}

	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esShotDataSharing, merge);
	}

	/**
	* Finds the e s shot data sharing with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException} if it could not be found.
	*
	* @param shotDataSharingId the primary key of the e s shot data sharing to find
	* @return the e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByPrimaryKey(
		long shotDataSharingId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(shotDataSharingId);
	}

	/**
	* Finds the e s shot data sharing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shotDataSharingId the primary key of the e s shot data sharing to find
	* @return the e s shot data sharing, or <code>null</code> if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing fetchByPrimaryKey(
		long shotDataSharingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(shotDataSharingId);
	}

	/**
	* Finds all the e s shot data sharings where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByPlayerShared(
		long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlayerShared(playerId);
	}

	/**
	* Finds a range of all the e s shot data sharings where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param start the lower bound of the range of e s shot data sharings to return
	* @param end the upper bound of the range of e s shot data sharings to return (not inclusive)
	* @return the range of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByPlayerShared(
		long playerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlayerShared(playerId, start, end);
	}

	/**
	* Finds an ordered range of all the e s shot data sharings where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param start the lower bound of the range of e s shot data sharings to return
	* @param end the upper bound of the range of e s shot data sharings to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByPlayerShared(
		long playerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerShared(playerId, start, end, orderByComparator);
	}

	/**
	* Finds the first e s shot data sharing in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a matching e s shot data sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByPlayerShared_First(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerShared_First(playerId, orderByComparator);
	}

	/**
	* Finds the last e s shot data sharing in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a matching e s shot data sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByPlayerShared_Last(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerShared_Last(playerId, orderByComparator);
	}

	/**
	* Finds the e s shot data sharings before and after the current e s shot data sharing in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shotDataSharingId the primary key of the current e s shot data sharing
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing[] findByPlayerShared_PrevAndNext(
		long shotDataSharingId, long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerShared_PrevAndNext(shotDataSharingId, playerId,
			orderByComparator);
	}

	/**
	* Finds all the e s shot data sharings where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByGroupShared(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupShared(groupId);
	}

	/**
	* Finds a range of all the e s shot data sharings where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of e s shot data sharings to return
	* @param end the upper bound of the range of e s shot data sharings to return (not inclusive)
	* @return the range of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByGroupShared(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupShared(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the e s shot data sharings where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of e s shot data sharings to return
	* @param end the upper bound of the range of e s shot data sharings to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByGroupShared(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupShared(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first e s shot data sharing in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a matching e s shot data sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByGroupShared_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupShared_First(groupId, orderByComparator);
	}

	/**
	* Finds the last e s shot data sharing in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a matching e s shot data sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByGroupShared_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupShared_Last(groupId, orderByComparator);
	}

	/**
	* Finds the e s shot data sharings before and after the current e s shot data sharing in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shotDataSharingId the primary key of the current e s shot data sharing
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing[] findByGroupShared_PrevAndNext(
		long shotDataSharingId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupShared_PrevAndNext(shotDataSharingId, groupId,
			orderByComparator);
	}

	/**
	* Finds all the e s shot data sharings where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByCompanyShared(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyShared(companyId);
	}

	/**
	* Finds a range of all the e s shot data sharings where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of e s shot data sharings to return
	* @param end the upper bound of the range of e s shot data sharings to return (not inclusive)
	* @return the range of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByCompanyShared(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyShared(companyId, start, end);
	}

	/**
	* Finds an ordered range of all the e s shot data sharings where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of e s shot data sharings to return
	* @param end the upper bound of the range of e s shot data sharings to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByCompanyShared(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyShared(companyId, start, end, orderByComparator);
	}

	/**
	* Finds the first e s shot data sharing in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a matching e s shot data sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByCompanyShared_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyShared_First(companyId, orderByComparator);
	}

	/**
	* Finds the last e s shot data sharing in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a matching e s shot data sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByCompanyShared_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyShared_Last(companyId, orderByComparator);
	}

	/**
	* Finds the e s shot data sharings before and after the current e s shot data sharing in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shotDataSharingId the primary key of the current e s shot data sharing
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing[] findByCompanyShared_PrevAndNext(
		long shotDataSharingId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyShared_PrevAndNext(shotDataSharingId,
			companyId, orderByComparator);
	}

	/**
	* Finds all the e s shot data sharings.
	*
	* @return the e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the e s shot data sharings.
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
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the e s shot data sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s shot data sharings to return
	* @param end the upper bound of the range of e s shot data sharings to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s shot data sharings where playerId = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPlayerShared(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPlayerShared(playerId);
	}

	/**
	* Removes all the e s shot data sharings where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupShared(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupShared(groupId);
	}

	/**
	* Removes all the e s shot data sharings where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyShared(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyShared(companyId);
	}

	/**
	* Removes all the e s shot data sharings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the e s shot data sharings where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the number of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPlayerShared(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPlayerShared(playerId);
	}

	/**
	* Counts all the e s shot data sharings where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupShared(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupShared(groupId);
	}

	/**
	* Counts all the e s shot data sharings where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyShared(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyShared(companyId);
	}

	/**
	* Counts all the e s shot data sharings.
	*
	* @return the number of e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESShotDataSharingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESShotDataSharingPersistence)PortletBeanLocatorUtil.locate(com.eswinggolf.portal.data.layer.club.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ESShotDataSharingPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ESShotDataSharingPersistence persistence) {
		_persistence = persistence;
	}

	private static ESShotDataSharingPersistence _persistence;
}