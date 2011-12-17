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

/**
 * <p>
 * This class is a wrapper for {@link ESPlayerClubLocalService}.
 * </p>
 *
 * @author    evangelistalc
 * @see       ESPlayerClubLocalService
 * @generated
 */
public class ESPlayerClubLocalServiceWrapper implements ESPlayerClubLocalService {
	public ESPlayerClubLocalServiceWrapper(
		ESPlayerClubLocalService esPlayerClubLocalService) {
		_esPlayerClubLocalService = esPlayerClubLocalService;
	}

	/**
	* Adds the e s player club to the database. Also notifies the appropriate model listeners.
	*
	* @param esPlayerClub the e s player club to add
	* @return the e s player club that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub addESPlayerClub(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.addESPlayerClub(esPlayerClub);
	}

	/**
	* Creates a new e s player club with the primary key. Does not add the e s player club to the database.
	*
	* @param playerClubId the primary key for the new e s player club
	* @return the new e s player club
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub createESPlayerClub(
		long playerClubId) {
		return _esPlayerClubLocalService.createESPlayerClub(playerClubId);
	}

	/**
	* Deletes the e s player club with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param playerClubId the primary key of the e s player club to delete
	* @throws PortalException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteESPlayerClub(long playerClubId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esPlayerClubLocalService.deleteESPlayerClub(playerClubId);
	}

	/**
	* Deletes the e s player club from the database. Also notifies the appropriate model listeners.
	*
	* @param esPlayerClub the e s player club to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteESPlayerClub(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub)
		throws com.liferay.portal.kernel.exception.SystemException {
		_esPlayerClubLocalService.deleteESPlayerClub(esPlayerClub);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the e s player club with the primary key.
	*
	* @param playerClubId the primary key of the e s player club to get
	* @return the e s player club
	* @throws PortalException if a e s player club with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub getESPlayerClub(
		long playerClubId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.getESPlayerClub(playerClubId);
	}

	/**
	* Gets a range of all the e s player clubs.
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
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> getESPlayerClubs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.getESPlayerClubs(start, end);
	}

	/**
	* Gets the number of e s player clubs.
	*
	* @return the number of e s player clubs
	* @throws SystemException if a system exception occurred
	*/
	public int getESPlayerClubsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.getESPlayerClubsCount();
	}

	/**
	* Updates the e s player club in the database. Also notifies the appropriate model listeners.
	*
	* @param esPlayerClub the e s player club to update
	* @return the e s player club that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub updateESPlayerClub(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.updateESPlayerClub(esPlayerClub);
	}

	/**
	* Updates the e s player club in the database. Also notifies the appropriate model listeners.
	*
	* @param esPlayerClub the e s player club to update
	* @param merge whether to merge the e s player club with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e s player club that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub updateESPlayerClub(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.updateESPlayerClub(esPlayerClub, merge);
	}

	/**
	* Adds a new product to the database.
	*
	* @param clubName
	* @param clubDesc
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESPlayerClub addPlayerClub(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub playerClub,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.addPlayerClub(playerClub, userId);
	}

	/**
	* Retrieves all of the clubs from the database.
	*
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESPlayerClub> getAllPlayerClubs(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esPlayerClubLocalService.getAllPlayerClubs(groupId);
	}

	/**
	* Removes the specified club from the database.
	*
	* @param clubId
	* @throws com.inkwell.internet.portlets.prodreg.sb.NoSuchProductException
	* @throws com.liferay.portal.kernel.exception.SystemException
	* @throws com.liferay.portal.kernel.exception.PortalException
	*/
	public void deletePlayerClub(long clubId)
		throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esPlayerClubLocalService.deletePlayerClub(clubId);
	}

	/**
	* Removes the specified club from the database.
	*
	* @param club
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public void deletePlayerClub(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub club)
		throws com.liferay.portal.kernel.exception.SystemException {
		_esPlayerClubLocalService.deletePlayerClub(club);
	}

	public ESPlayerClubLocalService getWrappedESPlayerClubLocalService() {
		return _esPlayerClubLocalService;
	}

	private ESPlayerClubLocalService _esPlayerClubLocalService;
}