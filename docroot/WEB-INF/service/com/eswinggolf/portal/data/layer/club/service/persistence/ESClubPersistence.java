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

import com.eswinggolf.portal.data.layer.club.model.ESClub;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s club service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ESClubUtil} to access the e s club persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESClubPersistenceImpl
 * @see ESClubUtil
 * @generated
 */
public interface ESClubPersistence extends BasePersistence<ESClub> {
	/**
	* Caches the e s club in the entity cache if it is enabled.
	*
	* @param esClub the e s club to cache
	*/
	public void cacheResult(
		com.eswinggolf.portal.data.layer.club.model.ESClub esClub);

	/**
	* Caches the e s clubs in the entity cache if it is enabled.
	*
	* @param esClubs the e s clubs to cache
	*/
	public void cacheResult(
		java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> esClubs);

	/**
	* Creates a new e s club with the primary key. Does not add the e s club to the database.
	*
	* @param clubId the primary key for the new e s club
	* @return the new e s club
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub create(
		long clubId);

	/**
	* Removes the e s club with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clubId the primary key of the e s club to remove
	* @return the e s club that was removed
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub remove(
		long clubId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.eswinggolf.portal.data.layer.club.model.ESClub updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESClub esClub, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s club with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESClubException} if it could not be found.
	*
	* @param clubId the primary key of the e s club to find
	* @return the e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub findByPrimaryKey(
		long clubId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s club with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clubId the primary key of the e s club to find
	* @return the e s club, or <code>null</code> if a e s club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub fetchByPrimaryKey(
		long clubId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s clubs where groupId = &#63; and clubName = &#63;.
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @return the matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByClubName(
		long groupId, java.lang.String clubName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s clubs where groupId = &#63; and clubName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @return the range of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByClubName(
		long groupId, java.lang.String clubName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s clubs where groupId = &#63; and clubName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByClubName(
		long groupId, java.lang.String clubName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first e s club in the ordered set where groupId = &#63; and clubName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub findByClubName_First(
		long groupId, java.lang.String clubName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last e s club in the ordered set where groupId = &#63; and clubName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub findByClubName_Last(
		long groupId, java.lang.String clubName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s clubs before and after the current e s club in the ordered set where groupId = &#63; and clubName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clubId the primary key of the current e s club
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub[] findByClubName_PrevAndNext(
		long clubId, long groupId, java.lang.String clubName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the e s clubs where groupId = &#63; and clubName = &#63;.
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @return the matching e s clubs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> filterFindByClubName(
		long groupId, java.lang.String clubName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the e s clubs where groupId = &#63; and clubName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @return the range of matching e s clubs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> filterFindByClubName(
		long groupId, java.lang.String clubName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the e s clubs where groupId = &#63; and clubName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s clubs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> filterFindByClubName(
		long groupId, java.lang.String clubName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s clubs where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s clubs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @return the range of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s clubs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first e s club in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last e s club in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s clubs before and after the current e s club in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clubId the primary key of the current e s club
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub[] findByGroupId_PrevAndNext(
		long clubId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the e s clubs where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching e s clubs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the e s clubs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @return the range of matching e s clubs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the e s clubs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s clubs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s clubs where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s clubs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @return the range of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s clubs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first e s club in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last e s club in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s clubs before and after the current e s club in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clubId the primary key of the current e s club
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESClub[] findByCompanyId_PrevAndNext(
		long clubId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s clubs.
	*
	* @return the e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s clubs.
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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s clubs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s clubs to return
	* @param end the upper bound of the range of e s clubs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESClub> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s clubs where groupId = &#63; and clubName = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClubName(long groupId, java.lang.String clubName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s clubs where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s clubs where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s clubs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s clubs where groupId = &#63; and clubName = &#63;.
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @return the number of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countByClubName(long groupId, java.lang.String clubName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the e s clubs where groupId = &#63; and clubName = &#63;.
	*
	* @param groupId the group id to search with
	* @param clubName the club name to search with
	* @return the number of matching e s clubs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByClubName(long groupId, java.lang.String clubName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s clubs where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the e s clubs where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching e s clubs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s clubs where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s clubs.
	*
	* @return the number of e s clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}