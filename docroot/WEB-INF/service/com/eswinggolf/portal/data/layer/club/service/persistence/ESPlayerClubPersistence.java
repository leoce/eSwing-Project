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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s player club service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ESPlayerClubUtil} to access the e s player club persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESPlayerClubPersistenceImpl
 * @see ESPlayerClubUtil
 * @generated
 */
public interface ESPlayerClubPersistence extends BasePersistence<ESPlayerClub> {
	/**
	* Caches the e s player club in the entity cache if it is enabled.
	*
	* @param esPlayerClub the e s player club to cache
	*/
	public void cacheResult(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub);

	/**
	* Caches the e s player clubs in the entity cache if it is enabled.
	*
	* @param esPlayerClubs the e s player clubs to cache
	*/
	public void cacheResult(
		java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> esPlayerClubs);

	/**
	* Creates a new e s player club with the primary key. Does not add the e s player club to the database.
	*
	* @param playerClubId the primary key for the new e s player club
	* @return the new e s player club
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub create(
		long playerClubId);

	/**
	* Removes the e s player club with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param playerClubId the primary key of the e s player club to remove
	* @return the e s player club that was removed
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub remove(
		long playerClubId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player club with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException} if it could not be found.
	*
	* @param playerClubId the primary key of the e s player club to find
	* @return the e s player club
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPrimaryKey(
		long playerClubId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player club with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param playerClubId the primary key of the e s player club to find
	* @return the e s player club, or <code>null</code> if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub fetchByPrimaryKey(
		long playerClubId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player clubs where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub[] findByPlayerClubGroup_PrevAndNext(
		long playerClubId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player clubs where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub[] findByPlayerClubCompany_PrevAndNext(
		long playerClubId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player clubs where clubId = &#63; and active = &#63;.
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @return the matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByAllClubs(
		long clubId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByAllClubs(
		long clubId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByAllClubs(
		long clubId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByAllClubs_First(
		long clubId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByAllClubs_Last(
		long clubId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub[] findByAllClubs_PrevAndNext(
		long playerClubId, long clubId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player clubs where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubs(
		long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubs(
		long playerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findByPlayerClubs(
		long playerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubs_First(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub findByPlayerClubs_Last(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub[] findByPlayerClubs_PrevAndNext(
		long playerClubId, long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player clubs.
	*
	* @return the e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player clubs where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPlayerClubGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player clubs where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPlayerClubCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player clubs where clubId = &#63; and active = &#63; from the database.
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllClubs(long clubId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player clubs where playerId = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPlayerClubs(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player clubs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player clubs where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPlayerClubGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player clubs where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPlayerClubCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player clubs where clubId = &#63; and active = &#63;.
	*
	* @param clubId the club id to search with
	* @param active the active to search with
	* @return the number of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllClubs(long clubId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player clubs where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the number of matching e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPlayerClubs(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player clubs.
	*
	* @return the number of e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}