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

import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s player shot data service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ESPlayerShotDataUtil} to access the e s player shot data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESPlayerShotDataPersistenceImpl
 * @see ESPlayerShotDataUtil
 * @generated
 */
public interface ESPlayerShotDataPersistence extends BasePersistence<ESPlayerShotData> {
	/**
	* Caches the e s player shot data in the entity cache if it is enabled.
	*
	* @param esPlayerShotData the e s player shot data to cache
	*/
	public void cacheResult(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData esPlayerShotData);

	/**
	* Caches the e s player shot datas in the entity cache if it is enabled.
	*
	* @param esPlayerShotDatas the e s player shot datas to cache
	*/
	public void cacheResult(
		java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> esPlayerShotDatas);

	/**
	* Creates a new e s player shot data with the primary key. Does not add the e s player shot data to the database.
	*
	* @param shotDataId the primary key for the new e s player shot data
	* @return the new e s player shot data
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData create(
		long shotDataId);

	/**
	* Removes the e s player shot data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shotDataId the primary key of the e s player shot data to remove
	* @return the e s player shot data that was removed
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData remove(
		long shotDataId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData esPlayerShotData,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player shot data with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException} if it could not be found.
	*
	* @param shotDataId the primary key of the e s player shot data to find
	* @return the e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByPrimaryKey(
		long shotDataId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player shot data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shotDataId the primary key of the e s player shot data to find
	* @return the e s player shot data, or <code>null</code> if a e s player shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData fetchByPrimaryKey(
		long shotDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player shot datas where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_PlayerShotData(
		long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s player shot datas where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @return the range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_PlayerShotData(
		long playerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s player shot datas where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_PlayerShotData(
		long playerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first e s player shot data in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_PlayerShotData_First(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last e s player shot data in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_PlayerShotData_Last(
		long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player shot datas before and after the current e s player shot data in the ordered set where playerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shotDataId the primary key of the current e s player shot data
	* @param playerId the player id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData[] findByG_PlayerShotData_PrevAndNext(
		long shotDataId, long playerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player shot datas where playerId = &#63; and playerClubId = &#63;.
	*
	* @param playerId the player id to search with
	* @param playerClubId the player club id to search with
	* @return the matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ClubShotData(
		long playerId, long playerClubId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s player shot datas where playerId = &#63; and playerClubId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param playerClubId the player club id to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @return the range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ClubShotData(
		long playerId, long playerClubId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s player shot datas where playerId = &#63; and playerClubId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param playerClubId the player club id to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ClubShotData(
		long playerId, long playerClubId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first e s player shot data in the ordered set where playerId = &#63; and playerClubId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param playerClubId the player club id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_ClubShotData_First(
		long playerId, long playerClubId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last e s player shot data in the ordered set where playerId = &#63; and playerClubId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param playerClubId the player club id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_ClubShotData_Last(
		long playerId, long playerClubId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player shot datas before and after the current e s player shot data in the ordered set where playerId = &#63; and playerClubId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shotDataId the primary key of the current e s player shot data
	* @param playerId the player id to search with
	* @param playerClubId the player club id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData[] findByG_ClubShotData_PrevAndNext(
		long shotDataId, long playerId, long playerClubId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player shot datas where playerId = &#63; and productSerialNo = &#63;.
	*
	* @param playerId the player id to search with
	* @param productSerialNo the product serial no to search with
	* @return the matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ProductSerialNo(
		long playerId, int productSerialNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s player shot datas where playerId = &#63; and productSerialNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param productSerialNo the product serial no to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @return the range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ProductSerialNo(
		long playerId, int productSerialNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s player shot datas where playerId = &#63; and productSerialNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param productSerialNo the product serial no to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ProductSerialNo(
		long playerId, int productSerialNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first e s player shot data in the ordered set where playerId = &#63; and productSerialNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param productSerialNo the product serial no to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_ProductSerialNo_First(
		long playerId, int productSerialNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last e s player shot data in the ordered set where playerId = &#63; and productSerialNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param productSerialNo the product serial no to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_ProductSerialNo_Last(
		long playerId, int productSerialNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player shot datas before and after the current e s player shot data in the ordered set where playerId = &#63; and productSerialNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shotDataId the primary key of the current e s player shot data
	* @param playerId the player id to search with
	* @param productSerialNo the product serial no to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData[] findByG_ProductSerialNo_PrevAndNext(
		long shotDataId, long playerId, int productSerialNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player shot datas where playerId = &#63; and active = &#63;.
	*
	* @param playerId the player id to search with
	* @param active the active to search with
	* @return the matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ActiveShotData(
		long playerId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s player shot datas where playerId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @return the range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ActiveShotData(
		long playerId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s player shot datas where playerId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ActiveShotData(
		long playerId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first e s player shot data in the ordered set where playerId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_ActiveShotData_First(
		long playerId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last e s player shot data in the ordered set where playerId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_ActiveShotData_Last(
		long playerId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player shot datas before and after the current e s player shot data in the ordered set where playerId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shotDataId the primary key of the current e s player shot data
	* @param playerId the player id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData[] findByG_ActiveShotData_PrevAndNext(
		long shotDataId, long playerId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player shot datas where playerId = &#63; and createDate = &#63;.
	*
	* @param playerId the player id to search with
	* @param createDate the create date to search with
	* @return the matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ShotDataByDate(
		long playerId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s player shot datas where playerId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param createDate the create date to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @return the range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ShotDataByDate(
		long playerId, java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s player shot datas where playerId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param createDate the create date to search with
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findByG_ShotDataByDate(
		long playerId, java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first e s player shot data in the ordered set where playerId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param createDate the create date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_ShotDataByDate_First(
		long playerId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last e s player shot data in the ordered set where playerId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param playerId the player id to search with
	* @param createDate the create date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a matching e s player shot data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData findByG_ShotDataByDate_Last(
		long playerId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the e s player shot datas before and after the current e s player shot data in the ordered set where playerId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shotDataId the primary key of the current e s player shot data
	* @param playerId the player id to search with
	* @param createDate the create date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next e s player shot data
	* @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData[] findByG_ShotDataByDate_PrevAndNext(
		long shotDataId, long playerId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the e s player shot datas.
	*
	* @return the e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the e s player shot datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @return the range of e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the e s player shot datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s player shot datas to return
	* @param end the upper bound of the range of e s player shot datas to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player shot datas where playerId = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_PlayerShotData(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player shot datas where playerId = &#63; and playerClubId = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @param playerClubId the player club id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_ClubShotData(long playerId, long playerClubId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player shot datas where playerId = &#63; and productSerialNo = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @param productSerialNo the product serial no to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_ProductSerialNo(long playerId, int productSerialNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player shot datas where playerId = &#63; and active = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_ActiveShotData(long playerId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player shot datas where playerId = &#63; and createDate = &#63; from the database.
	*
	* @param playerId the player id to search with
	* @param createDate the create date to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_ShotDataByDate(long playerId,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s player shot datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player shot datas where playerId = &#63;.
	*
	* @param playerId the player id to search with
	* @return the number of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_PlayerShotData(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player shot datas where playerId = &#63; and playerClubId = &#63;.
	*
	* @param playerId the player id to search with
	* @param playerClubId the player club id to search with
	* @return the number of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_ClubShotData(long playerId, long playerClubId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player shot datas where playerId = &#63; and productSerialNo = &#63;.
	*
	* @param playerId the player id to search with
	* @param productSerialNo the product serial no to search with
	* @return the number of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_ProductSerialNo(long playerId, int productSerialNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player shot datas where playerId = &#63; and active = &#63;.
	*
	* @param playerId the player id to search with
	* @param active the active to search with
	* @return the number of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_ActiveShotData(long playerId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player shot datas where playerId = &#63; and createDate = &#63;.
	*
	* @param playerId the player id to search with
	* @param createDate the create date to search with
	* @return the number of matching e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_ShotDataByDate(long playerId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the e s player shot datas.
	*
	* @return the number of e s player shot datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}