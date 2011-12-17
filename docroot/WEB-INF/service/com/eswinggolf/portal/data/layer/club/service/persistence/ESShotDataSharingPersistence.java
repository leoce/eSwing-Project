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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s shot data sharing service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ESShotDataSharingUtil} to access the e s shot data sharing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESShotDataSharingPersistenceImpl
 * @see ESShotDataSharingUtil
 * @generated
 */
public interface ESShotDataSharingPersistence extends BasePersistence<ESShotDataSharing> {
	/**
	* Caches the e s shot data sharing in the entity cache if it is enabled.
	*
	* @param esShotDataSharing the e s shot data sharing to cache
	*/
	public void cacheResult(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing);

	/**
	* Caches the e s shot data sharings in the entity cache if it is enabled.
	*
	* @param esShotDataSharings the e s shot data sharings to cache
	*/
	public void cacheResult(
		java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> esShotDataSharings);

	/**
	* Creates a new e s shot data sharing with the primary key. Does not add the e s shot data sharing to the database.
	*
	* @param shotDataSharingId the primary key for the new e s shot data sharing
	* @return the new e s shot data sharing
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing create(
		long shotDataSharingId);

	/**
	* Removes the e s shot data sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shotDataSharingId the primary key of the e s shot data sharing to remove
	* @return the e s shot data sharing that was removed
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing remove(
		long shotDataSharingId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s shot data sharing with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException} if it could not be found.
	*
	* @param shotDataSharingId the primary key of the e s shot data sharing to find
	* @return the e s shot data sharing
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByPrimaryKey(
		long shotDataSharingId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s shot data sharing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shotDataSharingId the primary key of the e s shot data sharing to find
	* @return the e s shot data sharing, or <code>null</code> if a e s shot data sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing fetchByPrimaryKey(
		long shotDataSharingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s shot data sharings where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByPlayerShared(
		long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByPlayerShared(
		long playerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByPlayerShared(
		long playerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByPlayerShared_First(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByPlayerShared_Last(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing[] findByPlayerShared_PrevAndNext(
		long shotDataSharingId, long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s shot data sharings where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByGroupShared(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByGroupShared(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByGroupShared(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByGroupShared_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByGroupShared_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing[] findByGroupShared_PrevAndNext(
		long shotDataSharingId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s shot data sharings where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByCompanyShared(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByCompanyShared(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findByCompanyShared(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByCompanyShared_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing findByCompanyShared_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing[] findByCompanyShared_PrevAndNext(
		long shotDataSharingId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s shot data sharings.
	*
	* @return the e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s shot data sharings where playerId = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPlayerShared(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s shot data sharings where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupShared(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s shot data sharings where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyShared(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s shot data sharings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s shot data sharings where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the number of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByPlayerShared(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s shot data sharings where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupShared(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s shot data sharings where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyShared(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s shot data sharings.
	*
	* @return the number of e s shot data sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}