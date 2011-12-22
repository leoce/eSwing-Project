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

import com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException;
import com.eswinggolf.portal.data.layer.club.model.ESTrialShotData;
import com.eswinggolf.portal.data.layer.club.model.impl.ESTrialShotDataImpl;
import com.eswinggolf.portal.data.layer.club.model.impl.ESTrialShotDataModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the e s trial shot data service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ESTrialShotDataUtil} to access the e s trial shot data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESTrialShotDataPersistence
 * @see ESTrialShotDataUtil
 * @generated
 */
public class ESTrialShotDataPersistenceImpl extends BasePersistenceImpl<ESTrialShotData>
	implements ESTrialShotDataPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ESTrialShotDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_G_TRIALSHOTDATA = new FinderPath(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_TrialShotData",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_TRIALSHOTDATA = new FinderPath(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_TrialShotData",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_CLUBTRIALSHOTDATA = new FinderPath(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_ClubTrialShotData",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CLUBTRIALSHOTDATA = new FinderPath(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_ClubTrialShotData",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_TRIALSHOTDATABYDATE = new FinderPath(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_TrialShotDataByDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_TRIALSHOTDATABYDATE = new FinderPath(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_TrialShotDataByDate",
			new String[] { Long.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the e s trial shot data in the entity cache if it is enabled.
	 *
	 * @param esTrialShotData the e s trial shot data to cache
	 */
	public void cacheResult(ESTrialShotData esTrialShotData) {
		EntityCacheUtil.putResult(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataImpl.class, esTrialShotData.getPrimaryKey(),
			esTrialShotData);
	}

	/**
	 * Caches the e s trial shot datas in the entity cache if it is enabled.
	 *
	 * @param esTrialShotDatas the e s trial shot datas to cache
	 */
	public void cacheResult(List<ESTrialShotData> esTrialShotDatas) {
		for (ESTrialShotData esTrialShotData : esTrialShotDatas) {
			if (EntityCacheUtil.getResult(
						ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
						ESTrialShotDataImpl.class,
						esTrialShotData.getPrimaryKey(), this) == null) {
				cacheResult(esTrialShotData);
			}
		}
	}

	/**
	 * Clears the cache for all e s trial shot datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ESTrialShotDataImpl.class.getName());
		EntityCacheUtil.clearCache(ESTrialShotDataImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the e s trial shot data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ESTrialShotData esTrialShotData) {
		EntityCacheUtil.removeResult(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataImpl.class, esTrialShotData.getPrimaryKey());
	}

	/**
	 * Creates a new e s trial shot data with the primary key. Does not add the e s trial shot data to the database.
	 *
	 * @param shotDataId the primary key for the new e s trial shot data
	 * @return the new e s trial shot data
	 */
	public ESTrialShotData create(long shotDataId) {
		ESTrialShotData esTrialShotData = new ESTrialShotDataImpl();

		esTrialShotData.setNew(true);
		esTrialShotData.setPrimaryKey(shotDataId);

		return esTrialShotData;
	}

	/**
	 * Removes the e s trial shot data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s trial shot data to remove
	 * @return the e s trial shot data that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the e s trial shot data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shotDataId the primary key of the e s trial shot data to remove
	 * @return the e s trial shot data that was removed
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData remove(long shotDataId)
		throws NoSuchESTrialShotDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESTrialShotData esTrialShotData = (ESTrialShotData)session.get(ESTrialShotDataImpl.class,
					new Long(shotDataId));

			if (esTrialShotData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + shotDataId);
				}

				throw new NoSuchESTrialShotDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					shotDataId);
			}

			return remove(esTrialShotData);
		}
		catch (NoSuchESTrialShotDataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESTrialShotData removeImpl(ESTrialShotData esTrialShotData)
		throws SystemException {
		esTrialShotData = toUnwrappedModel(esTrialShotData);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, esTrialShotData);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataImpl.class, esTrialShotData.getPrimaryKey());

		return esTrialShotData;
	}

	public ESTrialShotData updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESTrialShotData esTrialShotData,
		boolean merge) throws SystemException {
		esTrialShotData = toUnwrappedModel(esTrialShotData);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, esTrialShotData, merge);

			esTrialShotData.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESTrialShotDataImpl.class, esTrialShotData.getPrimaryKey(),
			esTrialShotData);

		return esTrialShotData;
	}

	protected ESTrialShotData toUnwrappedModel(ESTrialShotData esTrialShotData) {
		if (esTrialShotData instanceof ESTrialShotDataImpl) {
			return esTrialShotData;
		}

		ESTrialShotDataImpl esTrialShotDataImpl = new ESTrialShotDataImpl();

		esTrialShotDataImpl.setNew(esTrialShotData.isNew());
		esTrialShotDataImpl.setPrimaryKey(esTrialShotData.getPrimaryKey());

		esTrialShotDataImpl.setShotDataId(esTrialShotData.getShotDataId());
		esTrialShotDataImpl.setPlayerId(esTrialShotData.getPlayerId());
		esTrialShotDataImpl.setPlayerClubId(esTrialShotData.getPlayerClubId());
		esTrialShotDataImpl.setProductSerialNo(esTrialShotData.getProductSerialNo());
		esTrialShotDataImpl.setCompanyId(esTrialShotData.getCompanyId());
		esTrialShotDataImpl.setGroupId(esTrialShotData.getGroupId());
		esTrialShotDataImpl.setLaunchMonitor(esTrialShotData.isLaunchMonitor());
		esTrialShotDataImpl.setSimulate(esTrialShotData.isSimulate());
		esTrialShotDataImpl.setActive(esTrialShotData.isActive());
		esTrialShotDataImpl.setClubLoft(esTrialShotData.getClubLoft());
		esTrialShotDataImpl.setClubSpeed(esTrialShotData.getClubSpeed());
		esTrialShotDataImpl.setFaceAngle(esTrialShotData.getFaceAngle());
		esTrialShotDataImpl.setSwingPath(esTrialShotData.getSwingPath());
		esTrialShotDataImpl.setSpinAxisAngle(esTrialShotData.getSpinAxisAngle());
		esTrialShotDataImpl.setLaunchAngle(esTrialShotData.getLaunchAngle());
		esTrialShotDataImpl.setBallSpeed(esTrialShotData.getBallSpeed());
		esTrialShotDataImpl.setBallSpinRate(esTrialShotData.getBallSpinRate());
		esTrialShotDataImpl.setBallAngleOfAttack(esTrialShotData.getBallAngleOfAttack());
		esTrialShotDataImpl.setBallCompression(esTrialShotData.getBallCompression());
		esTrialShotDataImpl.setStepTimeIncrement(esTrialShotData.getStepTimeIncrement());
		esTrialShotDataImpl.setWindSpeed(esTrialShotData.getWindSpeed());
		esTrialShotDataImpl.setWindDirection(esTrialShotData.getWindDirection());
		esTrialShotDataImpl.setAmbientTemp(esTrialShotData.getAmbientTemp());
		esTrialShotDataImpl.setBarPressureAlt(esTrialShotData.getBarPressureAlt());
		esTrialShotDataImpl.setRelativeHumid(esTrialShotData.getRelativeHumid());
		esTrialShotDataImpl.setFairwayFirmness(esTrialShotData.getFairwayFirmness());
		esTrialShotDataImpl.setCreateDate(esTrialShotData.getCreateDate());
		esTrialShotDataImpl.setModifiedDate(esTrialShotData.getModifiedDate());

		return esTrialShotDataImpl;
	}

	/**
	 * Finds the e s trial shot data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s trial shot data to find
	 * @return the e s trial shot data
	 * @throws com.liferay.portal.NoSuchModelException if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s trial shot data with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException} if it could not be found.
	 *
	 * @param shotDataId the primary key of the e s trial shot data to find
	 * @return the e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData findByPrimaryKey(long shotDataId)
		throws NoSuchESTrialShotDataException, SystemException {
		ESTrialShotData esTrialShotData = fetchByPrimaryKey(shotDataId);

		if (esTrialShotData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + shotDataId);
			}

			throw new NoSuchESTrialShotDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				shotDataId);
		}

		return esTrialShotData;
	}

	/**
	 * Finds the e s trial shot data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s trial shot data to find
	 * @return the e s trial shot data, or <code>null</code> if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s trial shot data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shotDataId the primary key of the e s trial shot data to find
	 * @return the e s trial shot data, or <code>null</code> if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData fetchByPrimaryKey(long shotDataId)
		throws SystemException {
		ESTrialShotData esTrialShotData = (ESTrialShotData)EntityCacheUtil.getResult(ESTrialShotDataModelImpl.ENTITY_CACHE_ENABLED,
				ESTrialShotDataImpl.class, shotDataId, this);

		if (esTrialShotData == null) {
			Session session = null;

			try {
				session = openSession();

				esTrialShotData = (ESTrialShotData)session.get(ESTrialShotDataImpl.class,
						new Long(shotDataId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (esTrialShotData != null) {
					cacheResult(esTrialShotData);
				}

				closeSession(session);
			}
		}

		return esTrialShotData;
	}

	/**
	 * Finds all the e s trial shot datas where playerId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @return the matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_TrialShotData(long playerId)
		throws SystemException {
		return findByG_TrialShotData(playerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the e s trial shot datas where playerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param start the lower bound of the range of e s trial shot datas to return
	 * @param end the upper bound of the range of e s trial shot datas to return (not inclusive)
	 * @return the range of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_TrialShotData(long playerId,
		int start, int end) throws SystemException {
		return findByG_TrialShotData(playerId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the e s trial shot datas where playerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param start the lower bound of the range of e s trial shot datas to return
	 * @param end the upper bound of the range of e s trial shot datas to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_TrialShotData(long playerId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESTrialShotData> list = (List<ESTrialShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_TRIALSHOTDATA,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ESTRIALSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_TRIALSHOTDATA_PLAYERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESTrialShotDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				list = (List<ESTrialShotData>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_TRIALSHOTDATA,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_TRIALSHOTDATA,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first e s trial shot data in the ordered set where playerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a matching e s trial shot data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData findByG_TrialShotData_First(long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		List<ESTrialShotData> list = findByG_TrialShotData(playerId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESTrialShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last e s trial shot data in the ordered set where playerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a matching e s trial shot data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData findByG_TrialShotData_Last(long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		int count = countByG_TrialShotData(playerId);

		List<ESTrialShotData> list = findByG_TrialShotData(playerId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESTrialShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the e s trial shot datas before and after the current e s trial shot data in the ordered set where playerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shotDataId the primary key of the current e s trial shot data
	 * @param playerId the player id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData[] findByG_TrialShotData_PrevAndNext(
		long shotDataId, long playerId, OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		ESTrialShotData esTrialShotData = findByPrimaryKey(shotDataId);

		Session session = null;

		try {
			session = openSession();

			ESTrialShotData[] array = new ESTrialShotDataImpl[3];

			array[0] = getByG_TrialShotData_PrevAndNext(session,
					esTrialShotData, playerId, orderByComparator, true);

			array[1] = esTrialShotData;

			array[2] = getByG_TrialShotData_PrevAndNext(session,
					esTrialShotData, playerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESTrialShotData getByG_TrialShotData_PrevAndNext(
		Session session, ESTrialShotData esTrialShotData, long playerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESTRIALSHOTDATA_WHERE);

		query.append(_FINDER_COLUMN_G_TRIALSHOTDATA_PLAYERID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ESTrialShotDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(playerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esTrialShotData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESTrialShotData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s trial shot datas where playerId = &#63; and playerClubId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @return the matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_ClubTrialShotData(long playerId,
		long playerClubId) throws SystemException {
		return findByG_ClubTrialShotData(playerId, playerClubId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the e s trial shot datas where playerId = &#63; and playerClubId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @param start the lower bound of the range of e s trial shot datas to return
	 * @param end the upper bound of the range of e s trial shot datas to return (not inclusive)
	 * @return the range of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_ClubTrialShotData(long playerId,
		long playerClubId, int start, int end) throws SystemException {
		return findByG_ClubTrialShotData(playerId, playerClubId, start, end,
			null);
	}

	/**
	 * Finds an ordered range of all the e s trial shot datas where playerId = &#63; and playerClubId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @param start the lower bound of the range of e s trial shot datas to return
	 * @param end the upper bound of the range of e s trial shot datas to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_ClubTrialShotData(long playerId,
		long playerClubId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId, playerClubId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESTrialShotData> list = (List<ESTrialShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_CLUBTRIALSHOTDATA,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ESTRIALSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_CLUBTRIALSHOTDATA_PLAYERID_2);

			query.append(_FINDER_COLUMN_G_CLUBTRIALSHOTDATA_PLAYERCLUBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESTrialShotDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				qPos.add(playerClubId);

				list = (List<ESTrialShotData>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_CLUBTRIALSHOTDATA,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_CLUBTRIALSHOTDATA,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first e s trial shot data in the ordered set where playerId = &#63; and playerClubId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a matching e s trial shot data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData findByG_ClubTrialShotData_First(long playerId,
		long playerClubId, OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		List<ESTrialShotData> list = findByG_ClubTrialShotData(playerId,
				playerClubId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", playerClubId=");
			msg.append(playerClubId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESTrialShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last e s trial shot data in the ordered set where playerId = &#63; and playerClubId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a matching e s trial shot data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData findByG_ClubTrialShotData_Last(long playerId,
		long playerClubId, OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		int count = countByG_ClubTrialShotData(playerId, playerClubId);

		List<ESTrialShotData> list = findByG_ClubTrialShotData(playerId,
				playerClubId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", playerClubId=");
			msg.append(playerClubId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESTrialShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the e s trial shot datas before and after the current e s trial shot data in the ordered set where playerId = &#63; and playerClubId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shotDataId the primary key of the current e s trial shot data
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData[] findByG_ClubTrialShotData_PrevAndNext(
		long shotDataId, long playerId, long playerClubId,
		OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		ESTrialShotData esTrialShotData = findByPrimaryKey(shotDataId);

		Session session = null;

		try {
			session = openSession();

			ESTrialShotData[] array = new ESTrialShotDataImpl[3];

			array[0] = getByG_ClubTrialShotData_PrevAndNext(session,
					esTrialShotData, playerId, playerClubId, orderByComparator,
					true);

			array[1] = esTrialShotData;

			array[2] = getByG_ClubTrialShotData_PrevAndNext(session,
					esTrialShotData, playerId, playerClubId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESTrialShotData getByG_ClubTrialShotData_PrevAndNext(
		Session session, ESTrialShotData esTrialShotData, long playerId,
		long playerClubId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESTRIALSHOTDATA_WHERE);

		query.append(_FINDER_COLUMN_G_CLUBTRIALSHOTDATA_PLAYERID_2);

		query.append(_FINDER_COLUMN_G_CLUBTRIALSHOTDATA_PLAYERCLUBID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ESTrialShotDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(playerId);

		qPos.add(playerClubId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esTrialShotData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESTrialShotData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s trial shot datas where playerId = &#63; and createDate = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @return the matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_TrialShotDataByDate(long playerId,
		Date createDate) throws SystemException {
		return findByG_TrialShotDataByDate(playerId, createDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the e s trial shot datas where playerId = &#63; and createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @param start the lower bound of the range of e s trial shot datas to return
	 * @param end the upper bound of the range of e s trial shot datas to return (not inclusive)
	 * @return the range of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_TrialShotDataByDate(long playerId,
		Date createDate, int start, int end) throws SystemException {
		return findByG_TrialShotDataByDate(playerId, createDate, start, end,
			null);
	}

	/**
	 * Finds an ordered range of all the e s trial shot datas where playerId = &#63; and createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @param start the lower bound of the range of e s trial shot datas to return
	 * @param end the upper bound of the range of e s trial shot datas to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findByG_TrialShotDataByDate(long playerId,
		Date createDate, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId, createDate,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESTrialShotData> list = (List<ESTrialShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_TRIALSHOTDATABYDATE,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ESTRIALSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_PLAYERID_2);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESTrialShotDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				if (createDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				list = (List<ESTrialShotData>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_TRIALSHOTDATABYDATE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_TRIALSHOTDATABYDATE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first e s trial shot data in the ordered set where playerId = &#63; and createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a matching e s trial shot data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData findByG_TrialShotDataByDate_First(long playerId,
		Date createDate, OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		List<ESTrialShotData> list = findByG_TrialShotDataByDate(playerId,
				createDate, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", createDate=");
			msg.append(createDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESTrialShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last e s trial shot data in the ordered set where playerId = &#63; and createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a matching e s trial shot data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData findByG_TrialShotDataByDate_Last(long playerId,
		Date createDate, OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		int count = countByG_TrialShotDataByDate(playerId, createDate);

		List<ESTrialShotData> list = findByG_TrialShotDataByDate(playerId,
				createDate, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", createDate=");
			msg.append(createDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESTrialShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the e s trial shot datas before and after the current e s trial shot data in the ordered set where playerId = &#63; and createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shotDataId the primary key of the current e s trial shot data
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next e s trial shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESTrialShotDataException if a e s trial shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESTrialShotData[] findByG_TrialShotDataByDate_PrevAndNext(
		long shotDataId, long playerId, Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchESTrialShotDataException, SystemException {
		ESTrialShotData esTrialShotData = findByPrimaryKey(shotDataId);

		Session session = null;

		try {
			session = openSession();

			ESTrialShotData[] array = new ESTrialShotDataImpl[3];

			array[0] = getByG_TrialShotDataByDate_PrevAndNext(session,
					esTrialShotData, playerId, createDate, orderByComparator,
					true);

			array[1] = esTrialShotData;

			array[2] = getByG_TrialShotDataByDate_PrevAndNext(session,
					esTrialShotData, playerId, createDate, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESTrialShotData getByG_TrialShotDataByDate_PrevAndNext(
		Session session, ESTrialShotData esTrialShotData, long playerId,
		Date createDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESTRIALSHOTDATA_WHERE);

		query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_PLAYERID_2);

		if (createDate == null) {
			query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_CREATEDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_CREATEDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ESTrialShotDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(playerId);

		if (createDate != null) {
			qPos.add(CalendarUtil.getTimestamp(createDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esTrialShotData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESTrialShotData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s trial shot datas.
	 *
	 * @return the e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the e s trial shot datas.
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
	public List<ESTrialShotData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the e s trial shot datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s trial shot datas to return
	 * @param end the upper bound of the range of e s trial shot datas to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESTrialShotData> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESTrialShotData> list = (List<ESTrialShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESTRIALSHOTDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESTRIALSHOTDATA.concat(ESTrialShotDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ESTrialShotData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ESTrialShotData>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the e s trial shot datas where playerId = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_TrialShotData(long playerId)
		throws SystemException {
		for (ESTrialShotData esTrialShotData : findByG_TrialShotData(playerId)) {
			remove(esTrialShotData);
		}
	}

	/**
	 * Removes all the e s trial shot datas where playerId = &#63; and playerClubId = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_ClubTrialShotData(long playerId, long playerClubId)
		throws SystemException {
		for (ESTrialShotData esTrialShotData : findByG_ClubTrialShotData(
				playerId, playerClubId)) {
			remove(esTrialShotData);
		}
	}

	/**
	 * Removes all the e s trial shot datas where playerId = &#63; and createDate = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_TrialShotDataByDate(long playerId, Date createDate)
		throws SystemException {
		for (ESTrialShotData esTrialShotData : findByG_TrialShotDataByDate(
				playerId, createDate)) {
			remove(esTrialShotData);
		}
	}

	/**
	 * Removes all the e s trial shot datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ESTrialShotData esTrialShotData : findAll()) {
			remove(esTrialShotData);
		}
	}

	/**
	 * Counts all the e s trial shot datas where playerId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @return the number of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_TrialShotData(long playerId) throws SystemException {
		Object[] finderArgs = new Object[] { playerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_TRIALSHOTDATA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESTRIALSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_TRIALSHOTDATA_PLAYERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_TRIALSHOTDATA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s trial shot datas where playerId = &#63; and playerClubId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @return the number of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_ClubTrialShotData(long playerId, long playerClubId)
		throws SystemException {
		Object[] finderArgs = new Object[] { playerId, playerClubId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_CLUBTRIALSHOTDATA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESTRIALSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_CLUBTRIALSHOTDATA_PLAYERID_2);

			query.append(_FINDER_COLUMN_G_CLUBTRIALSHOTDATA_PLAYERCLUBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				qPos.add(playerClubId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_CLUBTRIALSHOTDATA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s trial shot datas where playerId = &#63; and createDate = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @return the number of matching e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_TrialShotDataByDate(long playerId, Date createDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { playerId, createDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_TRIALSHOTDATABYDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESTRIALSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_PLAYERID_2);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_TRIALSHOTDATABYDATE_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				if (createDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_TRIALSHOTDATABYDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s trial shot datas.
	 *
	 * @return the number of e s trial shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ESTRIALSHOTDATA);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the e s trial shot data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.eswinggolf.portal.data.layer.club.model.ESTrialShotData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESTrialShotData>> listenersList = new ArrayList<ModelListener<ESTrialShotData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESTrialShotData>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ESTrialShotDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = ESClubPersistence.class)
	protected ESClubPersistence esClubPersistence;
	@BeanReference(type = ESPlayerClubPersistence.class)
	protected ESPlayerClubPersistence esPlayerClubPersistence;
	@BeanReference(type = ESPlayerShotDataPersistence.class)
	protected ESPlayerShotDataPersistence esPlayerShotDataPersistence;
	@BeanReference(type = ESShotDataSharingPersistence.class)
	protected ESShotDataSharingPersistence esShotDataSharingPersistence;
	@BeanReference(type = ESTrialShotDataPersistence.class)
	protected ESTrialShotDataPersistence esTrialShotDataPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ESTRIALSHOTDATA = "SELECT esTrialShotData FROM ESTrialShotData esTrialShotData";
	private static final String _SQL_SELECT_ESTRIALSHOTDATA_WHERE = "SELECT esTrialShotData FROM ESTrialShotData esTrialShotData WHERE ";
	private static final String _SQL_COUNT_ESTRIALSHOTDATA = "SELECT COUNT(esTrialShotData) FROM ESTrialShotData esTrialShotData";
	private static final String _SQL_COUNT_ESTRIALSHOTDATA_WHERE = "SELECT COUNT(esTrialShotData) FROM ESTrialShotData esTrialShotData WHERE ";
	private static final String _FINDER_COLUMN_G_TRIALSHOTDATA_PLAYERID_2 = "esTrialShotData.playerId = ?";
	private static final String _FINDER_COLUMN_G_CLUBTRIALSHOTDATA_PLAYERID_2 = "esTrialShotData.playerId = ? AND ";
	private static final String _FINDER_COLUMN_G_CLUBTRIALSHOTDATA_PLAYERCLUBID_2 =
		"esTrialShotData.playerClubId = ?";
	private static final String _FINDER_COLUMN_G_TRIALSHOTDATABYDATE_PLAYERID_2 = "esTrialShotData.playerId = ? AND ";
	private static final String _FINDER_COLUMN_G_TRIALSHOTDATABYDATE_CREATEDATE_1 =
		"esTrialShotData.createDate IS NULL";
	private static final String _FINDER_COLUMN_G_TRIALSHOTDATABYDATE_CREATEDATE_2 =
		"esTrialShotData.createDate = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esTrialShotData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESTrialShotData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESTrialShotData exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ESTrialShotDataPersistenceImpl.class);
}