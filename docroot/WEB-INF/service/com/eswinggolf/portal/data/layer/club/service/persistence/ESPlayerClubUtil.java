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

import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e s player club service. This utility wraps {@link ESPlayerClubPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see ESPlayerClubPersistence
 * @see ESPlayerClubPersistenceImpl
 * @generated
 */
public class ESPlayerClubUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ESPlayerClub esPlayerClub) {
		getPersistence().clearCache(esPlayerClub);
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
	public static List<ESPlayerClub> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESPlayerClub> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESPlayerClub> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ESPlayerClub remove(ESPlayerClub esPlayerClub)
		throws SystemException {
		return getPersistence().remove(esPlayerClub);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ESPlayerClub update(ESPlayerClub esPlayerClub, boolean merge)
		throws SystemException {
		return getPersistence().update(esPlayerClub, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ESPlayerClub update(ESPlayerClub esPlayerClub, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esPlayerClub, merge, serviceContext);
	}

	/**
	* Caches the e s player club in the entity cache if it is enabled.
	*
	* @param esPlayerClub the e s player club to cache
	*/
	public static void cacheResult(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub) {
		getPersistence().cacheResult(esPlayerClub);
	}

	/**
	* Caches the e s player clubs in the entity cache if it is enabled.
	*
	* @param esPlayerClubs the e s player clubs to cache
	*/
	public static void cacheResult(
		java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> esPlayerClubs) {
		getPersistence().cacheResult(esPlayerClubs);
	}

	/**
	* Creates a new e s player club with the primary key. Does not add the e s player club to the database.
	*
	* @param playerClubId the primary key for the new e s player club
	* @return the new e s player club
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub create(
		long playerClubId) {
		return getPersistence().create(playerClubId);
	}

	/**
	* Removes the e s player club with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param playerClubId the primary key of the e s player club to remove
	* @return the e s player club that was removed
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub remove(
		long playerClubId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(playerClubId);
	}

	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esPlayerClub, merge);
	}

	/**
	* Finds the e s player club with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException} if it could not be found.
	*
	* @param playerClubId the primary key of the e s player club to find
	* @return the e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPrimaryKey(
		long playerClubId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(playerClubId);
	}

	/**
	* Finds the e s player club with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param playerClubId the primary key of the e s player club to find
	* @return the e s player club, or <code>null</code> if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub fetchByPrimaryKey(
		long playerClubId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(playerClubId);
	}

	/**
	* Finds all the e s player clubs where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlayerClubGroup(groupId);
	}

	/**
	* Finds a range of all the e s player clubs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @return the range of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlayerClubGroup(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the e s player clubs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first e s player club in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a matching e s player club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubGroup_First(groupId, orderByComparator);
	}

	/**
	* Finds the last e s player club in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a matching e s player club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubGroup_Last(groupId, orderByComparator);
	}

	/**
	* Finds the e s player clubs before and after the current e s player club in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerClubId the primary key of the current e s player club
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub[] findByPlayerClubGroup_PrevAndNext(
		long playerClubId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubGroup_PrevAndNext(playerClubId, groupId,
			orderByComparator);
	}

	/**
	* Finds all the e s player clubs where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlayerClubCompany(companyId);
	}

	/**
	* Finds a range of all the e s player clubs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @return the range of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlayerClubCompany(companyId, start, end);
	}

	/**
	* Finds an ordered range of all the e s player clubs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubCompany(companyId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first e s player club in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a matching e s player club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubCompany_First(companyId, orderByComparator);
	}

	/**
	* Finds the last e s player club in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a matching e s player club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubCompany_Last(companyId, orderByComparator);
	}

	/**
	* Finds the e s player clubs before and after the current e s player club in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerClubId the primary key of the current e s player club
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub[] findByPlayerClubCompany_PrevAndNext(
		long playerClubId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubCompany_PrevAndNext(playerClubId,
			companyId, orderByComparator);
	}

	/**
	* Finds all the e s player clubs where clubId = &#63; and active = &#63;.
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @return the matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByAllClubs(
		long clubId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllClubs(clubId, active);
	}

	/**
	* Finds a range of all the e s player clubs where clubId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @return the range of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByAllClubs(
		long clubId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllClubs(clubId, active, start, end);
	}

	/**
	* Finds an ordered range of all the e s player clubs where clubId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByAllClubs(
		long clubId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllClubs(clubId, active, start, end, orderByComparator);
	}

	/**
	* Finds the first e s player club in the ordered set where clubId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a matching e s player club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByAllClubs_First(
		long clubId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllClubs_First(clubId, active, orderByComparator);
	}

	/**
	* Finds the last e s player club in the ordered set where clubId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a matching e s player club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByAllClubs_Last(
		long clubId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllClubs_Last(clubId, active, orderByComparator);
	}

	/**
	* Finds the e s player clubs before and after the current e s player club in the ordered set where clubId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerClubId the primary key of the current e s player club
	* @param clubId the club id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub[] findByAllClubs_PrevAndNext(
		long playerClubId, long clubId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllClubs_PrevAndNext(playerClubId, clubId, active,
			orderByComparator);
	}

	/**
	* Finds all the e s player clubs where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubs(
		long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlayerClubs(playerId);
	}

	/**
	* Finds a range of all the e s player clubs where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @return the range of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubs(
		long playerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPlayerClubs(playerId, start, end);
	}

	/**
	* Finds an ordered range of all the e s player clubs where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubs(
		long playerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubs(playerId, start, end, orderByComparator);
	}

	/**
	* Finds the first e s player club in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a matching e s player club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubs_First(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubs_First(playerId, orderByComparator);
	}

	/**
	* Finds the last e s player club in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a matching e s player club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubs_Last(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubs_Last(playerId, orderByComparator);
	}

	/**
	* Finds the e s player clubs before and after the current e s player club in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerClubId the primary key of the current e s player club
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.eswinggolf.portal.data.layer.club.model.ESPlayerClub[] findByPlayerClubs_PrevAndNext(
		long playerClubId, long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPlayerClubs_PrevAndNext(playerClubId, playerId,
			orderByComparator);
	}

	/**
	* Finds all the e s player clubs.
	*
	* @return the e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the e s player clubs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @return the range of e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the e s player clubs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s player clubs to return
	* @param end the upper bound of the range of e s player clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s player clubs where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPlayerClubGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPlayerClubGroup(groupId);
	}

	/**
	* Removes all the e s player clubs where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPlayerClubCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPlayerClubCompany(companyId);
	}

	/**
	* Removes all the e s player clubs where clubId = &#63; and active = &#63; from the database.
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllClubs(long clubId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllClubs(clubId, active);
	}

	/**
	* Removes all the e s player clubs where playerId = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPlayerClubs(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPlayerClubs(playerId);
	}

	/**
	* Removes all the e s player clubs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the e s player clubs where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPlayerClubGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPlayerClubGroup(groupId);
	}

	/**
	* Counts all the e s player clubs where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPlayerClubCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPlayerClubCompany(companyId);
	}

	/**
	* Counts all the e s player clubs where clubId = &#63; and active = &#63;.
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @return the number of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllClubs(long clubId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllClubs(clubId, active);
	}

	/**
	* Counts all the e s player clubs where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the number of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPlayerClubs(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPlayerClubs(playerId);
	}

	/**
	* Counts all the e s player clubs.
	*
	* @return the number of e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESPlayerClubPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESPlayerClubPersistence)PortletBeanLocatorUtil.locate(com.eswinggolf.portal.data.layer.club.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ESPlayerClubPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ESPlayerClubPersistence persistence) {
		_persistence = persistence;
	}

	private static ESPlayerClubPersistence _persistence;
}