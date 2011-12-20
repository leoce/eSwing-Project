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

package com.eswinggolf.portal.data.layer.club.service.base;

import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
import com.eswinggolf.portal.data.layer.club.service.ESClubLocalService;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerClubLocalService;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalService;
import com.eswinggolf.portal.data.layer.club.service.ESShotDataSharingLocalService;
import com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalService;
import com.eswinggolf.portal.data.layer.club.service.persistence.ESClubPersistence;
import com.eswinggolf.portal.data.layer.club.service.persistence.ESPlayerClubPersistence;
import com.eswinggolf.portal.data.layer.club.service.persistence.ESPlayerShotDataPersistence;
import com.eswinggolf.portal.data.layer.club.service.persistence.ESShotDataSharingPersistence;
import com.eswinggolf.portal.data.layer.club.service.persistence.ESTrialShotDataPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the e s player shot data local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.eswinggolf.portal.data.layer.club.service.impl.ESPlayerShotDataLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil} to access the e s player shot data local service.
 * </p>
 *
 * @author evangelistalc
 * @see com.eswinggolf.portal.data.layer.club.service.impl.ESPlayerShotDataLocalServiceImpl
 * @see com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil
 * @generated
 */
public abstract class ESPlayerShotDataLocalServiceBaseImpl
	implements ESPlayerShotDataLocalService {
	/**
	 * Adds the e s player shot data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param esPlayerShotData the e s player shot data to add
	 * @return the e s player shot data that was added
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData addESPlayerShotData(
		ESPlayerShotData esPlayerShotData) throws SystemException {
		esPlayerShotData.setNew(true);

		return esPlayerShotDataPersistence.update(esPlayerShotData, false);
	}

	/**
	 * Creates a new e s player shot data with the primary key. Does not add the e s player shot data to the database.
	 *
	 * @param shotDataId the primary key for the new e s player shot data
	 * @return the new e s player shot data
	 */
	public ESPlayerShotData createESPlayerShotData(long shotDataId) {
		return esPlayerShotDataPersistence.create(shotDataId);
	}

	/**
	 * Deletes the e s player shot data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shotDataId the primary key of the e s player shot data to delete
	 * @throws PortalException if a e s player shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteESPlayerShotData(long shotDataId)
		throws PortalException, SystemException {
		esPlayerShotDataPersistence.remove(shotDataId);
	}

	/**
	 * Deletes the e s player shot data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esPlayerShotData the e s player shot data to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteESPlayerShotData(ESPlayerShotData esPlayerShotData)
		throws SystemException {
		esPlayerShotDataPersistence.remove(esPlayerShotData);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return esPlayerShotDataPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return esPlayerShotDataPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return esPlayerShotDataPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return esPlayerShotDataPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the e s player shot data with the primary key.
	 *
	 * @param shotDataId the primary key of the e s player shot data to get
	 * @return the e s player shot data
	 * @throws PortalException if a e s player shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData getESPlayerShotData(long shotDataId)
		throws PortalException, SystemException {
		return esPlayerShotDataPersistence.findByPrimaryKey(shotDataId);
	}

	/**
	 * Gets a range of all the e s player shot datas.
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
	public List<ESPlayerShotData> getESPlayerShotDatas(int start, int end)
		throws SystemException {
		return esPlayerShotDataPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of e s player shot datas.
	 *
	 * @return the number of e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int getESPlayerShotDatasCount() throws SystemException {
		return esPlayerShotDataPersistence.countAll();
	}

	/**
	 * Updates the e s player shot data in the database. Also notifies the appropriate model listeners.
	 *
	 * @param esPlayerShotData the e s player shot data to update
	 * @return the e s player shot data that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData updateESPlayerShotData(
		ESPlayerShotData esPlayerShotData) throws SystemException {
		esPlayerShotData.setNew(false);

		return esPlayerShotDataPersistence.update(esPlayerShotData, true);
	}

	/**
	 * Updates the e s player shot data in the database. Also notifies the appropriate model listeners.
	 *
	 * @param esPlayerShotData the e s player shot data to update
	 * @param merge whether to merge the e s player shot data with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the e s player shot data that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData updateESPlayerShotData(
		ESPlayerShotData esPlayerShotData, boolean merge)
		throws SystemException {
		esPlayerShotData.setNew(false);

		return esPlayerShotDataPersistence.update(esPlayerShotData, merge);
	}

	/**
	 * Gets the e s club local service.
	 *
	 * @return the e s club local service
	 */
	public ESClubLocalService getESClubLocalService() {
		return esClubLocalService;
	}

	/**
	 * Sets the e s club local service.
	 *
	 * @param esClubLocalService the e s club local service
	 */
	public void setESClubLocalService(ESClubLocalService esClubLocalService) {
		this.esClubLocalService = esClubLocalService;
	}

	/**
	 * Gets the e s club persistence.
	 *
	 * @return the e s club persistence
	 */
	public ESClubPersistence getESClubPersistence() {
		return esClubPersistence;
	}

	/**
	 * Sets the e s club persistence.
	 *
	 * @param esClubPersistence the e s club persistence
	 */
	public void setESClubPersistence(ESClubPersistence esClubPersistence) {
		this.esClubPersistence = esClubPersistence;
	}

	/**
	 * Gets the e s player club local service.
	 *
	 * @return the e s player club local service
	 */
	public ESPlayerClubLocalService getESPlayerClubLocalService() {
		return esPlayerClubLocalService;
	}

	/**
	 * Sets the e s player club local service.
	 *
	 * @param esPlayerClubLocalService the e s player club local service
	 */
	public void setESPlayerClubLocalService(
		ESPlayerClubLocalService esPlayerClubLocalService) {
		this.esPlayerClubLocalService = esPlayerClubLocalService;
	}

	/**
	 * Gets the e s player club persistence.
	 *
	 * @return the e s player club persistence
	 */
	public ESPlayerClubPersistence getESPlayerClubPersistence() {
		return esPlayerClubPersistence;
	}

	/**
	 * Sets the e s player club persistence.
	 *
	 * @param esPlayerClubPersistence the e s player club persistence
	 */
	public void setESPlayerClubPersistence(
		ESPlayerClubPersistence esPlayerClubPersistence) {
		this.esPlayerClubPersistence = esPlayerClubPersistence;
	}

	/**
	 * Gets the e s player shot data local service.
	 *
	 * @return the e s player shot data local service
	 */
	public ESPlayerShotDataLocalService getESPlayerShotDataLocalService() {
		return esPlayerShotDataLocalService;
	}

	/**
	 * Sets the e s player shot data local service.
	 *
	 * @param esPlayerShotDataLocalService the e s player shot data local service
	 */
	public void setESPlayerShotDataLocalService(
		ESPlayerShotDataLocalService esPlayerShotDataLocalService) {
		this.esPlayerShotDataLocalService = esPlayerShotDataLocalService;
	}

	/**
	 * Gets the e s player shot data persistence.
	 *
	 * @return the e s player shot data persistence
	 */
	public ESPlayerShotDataPersistence getESPlayerShotDataPersistence() {
		return esPlayerShotDataPersistence;
	}

	/**
	 * Sets the e s player shot data persistence.
	 *
	 * @param esPlayerShotDataPersistence the e s player shot data persistence
	 */
	public void setESPlayerShotDataPersistence(
		ESPlayerShotDataPersistence esPlayerShotDataPersistence) {
		this.esPlayerShotDataPersistence = esPlayerShotDataPersistence;
	}

	/**
	 * Gets the e s shot data sharing local service.
	 *
	 * @return the e s shot data sharing local service
	 */
	public ESShotDataSharingLocalService getESShotDataSharingLocalService() {
		return esShotDataSharingLocalService;
	}

	/**
	 * Sets the e s shot data sharing local service.
	 *
	 * @param esShotDataSharingLocalService the e s shot data sharing local service
	 */
	public void setESShotDataSharingLocalService(
		ESShotDataSharingLocalService esShotDataSharingLocalService) {
		this.esShotDataSharingLocalService = esShotDataSharingLocalService;
	}

	/**
	 * Gets the e s shot data sharing persistence.
	 *
	 * @return the e s shot data sharing persistence
	 */
	public ESShotDataSharingPersistence getESShotDataSharingPersistence() {
		return esShotDataSharingPersistence;
	}

	/**
	 * Sets the e s shot data sharing persistence.
	 *
	 * @param esShotDataSharingPersistence the e s shot data sharing persistence
	 */
	public void setESShotDataSharingPersistence(
		ESShotDataSharingPersistence esShotDataSharingPersistence) {
		this.esShotDataSharingPersistence = esShotDataSharingPersistence;
	}

	/**
	 * Gets the e s trial shot data local service.
	 *
	 * @return the e s trial shot data local service
	 */
	public ESTrialShotDataLocalService getESTrialShotDataLocalService() {
		return esTrialShotDataLocalService;
	}

	/**
	 * Sets the e s trial shot data local service.
	 *
	 * @param esTrialShotDataLocalService the e s trial shot data local service
	 */
	public void setESTrialShotDataLocalService(
		ESTrialShotDataLocalService esTrialShotDataLocalService) {
		this.esTrialShotDataLocalService = esTrialShotDataLocalService;
	}

	/**
	 * Gets the e s trial shot data persistence.
	 *
	 * @return the e s trial shot data persistence
	 */
	public ESTrialShotDataPersistence getESTrialShotDataPersistence() {
		return esTrialShotDataPersistence;
	}

	/**
	 * Sets the e s trial shot data persistence.
	 *
	 * @param esTrialShotDataPersistence the e s trial shot data persistence
	 */
	public void setESTrialShotDataPersistence(
		ESTrialShotDataPersistence esTrialShotDataPersistence) {
		this.esTrialShotDataPersistence = esTrialShotDataPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = esPlayerShotDataPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ESClubLocalService.class)
	protected ESClubLocalService esClubLocalService;
	@BeanReference(type = ESClubPersistence.class)
	protected ESClubPersistence esClubPersistence;
	@BeanReference(type = ESPlayerClubLocalService.class)
	protected ESPlayerClubLocalService esPlayerClubLocalService;
	@BeanReference(type = ESPlayerClubPersistence.class)
	protected ESPlayerClubPersistence esPlayerClubPersistence;
	@BeanReference(type = ESPlayerShotDataLocalService.class)
	protected ESPlayerShotDataLocalService esPlayerShotDataLocalService;
	@BeanReference(type = ESPlayerShotDataPersistence.class)
	protected ESPlayerShotDataPersistence esPlayerShotDataPersistence;
	@BeanReference(type = ESShotDataSharingLocalService.class)
	protected ESShotDataSharingLocalService esShotDataSharingLocalService;
	@BeanReference(type = ESShotDataSharingPersistence.class)
	protected ESShotDataSharingPersistence esShotDataSharingPersistence;
	@BeanReference(type = ESTrialShotDataLocalService.class)
	protected ESTrialShotDataLocalService esTrialShotDataLocalService;
	@BeanReference(type = ESTrialShotDataPersistence.class)
	protected ESTrialShotDataPersistence esTrialShotDataPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}