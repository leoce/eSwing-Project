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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the e s trial shot data local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ESTrialShotDataLocalServiceUtil} to access the e s trial shot data local service. Add custom service methods to {@link com.eswinggolf.portal.data.layer.club.service.impl.ESTrialShotDataLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author evangelistalc
 * @see ESTrialShotDataLocalServiceUtil
 * @see com.eswinggolf.portal.data.layer.club.service.base.ESTrialShotDataLocalServiceBaseImpl
 * @see com.eswinggolf.portal.data.layer.club.service.impl.ESTrialShotDataLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESTrialShotDataLocalService {
	/**
	* Adds the e s trial shot data to the database. Also notifies the appropriate model listeners.
	*
	* @param esTrialShotData the e s trial shot data to add
	* @return the e s trial shot data that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESTrialShotData addESTrialShotData(
		com.eswinggolf.portal.data.layer.club.model.ESTrialShotData esTrialShotData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s trial shot data with the primary key. Does not add the e s trial shot data to the database.
	*
	* @param shotDataId the primary key for the new e s trial shot data
	* @return the new e s trial shot data
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESTrialShotData createESTrialShotData(
		long shotDataId);

	/**
	* Deletes the e s trial shot data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shotDataId the primary key of the e s trial shot data to delete
	* @throws PortalException if a e s trial shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteESTrialShotData(long shotDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s trial shot data from the database. Also notifies the appropriate model listeners.
	*
	* @param esTrialShotData the e s trial shot data to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteESTrialShotData(
		com.eswinggolf.portal.data.layer.club.model.ESTrialShotData esTrialShotData)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the e s trial shot data with the primary key.
	*
	* @param shotDataId the primary key of the e s trial shot data to get
	* @return the e s trial shot data
	* @throws PortalException if a e s trial shot data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.eswinggolf.portal.data.layer.club.model.ESTrialShotData getESTrialShotData(
		long shotDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the e s trial shot datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e s trial shot datas to return
	* @param end the upper bound of the range of e s trial shot datas to return (not inclusive)
	* @return the range of e s trial shot datas
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESTrialShotData> getESTrialShotDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of e s trial shot datas.
	*
	* @return the number of e s trial shot datas
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESTrialShotDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s trial shot data in the database. Also notifies the appropriate model listeners.
	*
	* @param esTrialShotData the e s trial shot data to update
	* @return the e s trial shot data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESTrialShotData updateESTrialShotData(
		com.eswinggolf.portal.data.layer.club.model.ESTrialShotData esTrialShotData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s trial shot data in the database. Also notifies the appropriate model listeners.
	*
	* @param esTrialShotData the e s trial shot data to update
	* @param merge whether to merge the e s trial shot data with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e s trial shot data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.eswinggolf.portal.data.layer.club.model.ESTrialShotData updateESTrialShotData(
		com.eswinggolf.portal.data.layer.club.model.ESTrialShotData esTrialShotData,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all Player shot data out of the database.
	*
	* @return
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESTrialShotData> getAllPlayerShotData(
		long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all Player shot data out of the database.
	*
	* @return
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESTrialShotData> getAllClubShotByPlayer(
		long playerId, long clubId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all Player shot data by date out of the database.
	*
	* @return
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.eswinggolf.portal.data.layer.club.model.ESTrialShotData> getClubShotDataByDate(
		long playerId, java.util.Date begin, java.util.Date end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteTrialShotData(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void transferTrialDataToShotData(long playerId)
		throws com.liferay.portal.kernel.exception.SystemException;
}