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

import com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
import com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataImpl;
import com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataModelImpl;

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
 * The persistence implementation for the e s player shot data service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ESPlayerShotDataUtil} to access the e s player shot data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESPlayerShotDataPersistence
 * @see ESPlayerShotDataUtil
 * @generated
 */
public class ESPlayerShotDataPersistenceImpl extends BasePersistenceImpl<ESPlayerShotData>
	implements ESPlayerShotDataPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ESPlayerShotDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_G_PLAYERSHOTDATA = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_PlayerShotData",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_PLAYERSHOTDATA = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_PlayerShotData",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_CLUBSHOTDATA = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_ClubShotData",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CLUBSHOTDATA = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_ClubShotData",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_PRODUCTSERIALNO = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_ProductSerialNo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_PRODUCTSERIALNO = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_ProductSerialNo",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_SHOTDATABYDATE = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_ShotDataByDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_SHOTDATABYDATE = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_ShotDataByDate",
			new String[] { Long.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the e s player shot data in the entity cache if it is enabled.
	 *
	 * @param esPlayerShotData the e s player shot data to cache
	 */
	public void cacheResult(ESPlayerShotData esPlayerShotData) {
		EntityCacheUtil.putResult(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataImpl.class, esPlayerShotData.getPrimaryKey(),
			esPlayerShotData);
	}

	/**
	 * Caches the e s player shot datas in the entity cache if it is enabled.
	 *
	 * @param esPlayerShotDatas the e s player shot datas to cache
	 */
	public void cacheResult(List<ESPlayerShotData> esPlayerShotDatas) {
		for (ESPlayerShotData esPlayerShotData : esPlayerShotDatas) {
			if (EntityCacheUtil.getResult(
						ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
						ESPlayerShotDataImpl.class,
						esPlayerShotData.getPrimaryKey(), this) == null) {
				cacheResult(esPlayerShotData);
			}
		}
	}

	/**
	 * Clears the cache for all e s player shot datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ESPlayerShotDataImpl.class.getName());
		EntityCacheUtil.clearCache(ESPlayerShotDataImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the e s player shot data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ESPlayerShotData esPlayerShotData) {
		EntityCacheUtil.removeResult(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataImpl.class, esPlayerShotData.getPrimaryKey());
	}

	/**
	 * Creates a new e s player shot data with the primary key. Does not add the e s player shot data to the database.
	 *
	 * @param shotDataId the primary key for the new e s player shot data
	 * @return the new e s player shot data
	 */
	public ESPlayerShotData create(long shotDataId) {
		ESPlayerShotData esPlayerShotData = new ESPlayerShotDataImpl();

		esPlayerShotData.setNew(true);
		esPlayerShotData.setPrimaryKey(shotDataId);

		return esPlayerShotData;
	}

	/**
	 * Removes the e s player shot data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s player shot data to remove
	 * @return the e s player shot data that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a e s player shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the e s player shot data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shotDataId the primary key of the e s player shot data to remove
	 * @return the e s player shot data that was removed
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData remove(long shotDataId)
		throws NoSuchESPlayerShotDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESPlayerShotData esPlayerShotData = (ESPlayerShotData)session.get(ESPlayerShotDataImpl.class,
					new Long(shotDataId));

			if (esPlayerShotData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + shotDataId);
				}

				throw new NoSuchESPlayerShotDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					shotDataId);
			}

			return remove(esPlayerShotData);
		}
		catch (NoSuchESPlayerShotDataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESPlayerShotData removeImpl(ESPlayerShotData esPlayerShotData)
		throws SystemException {
		esPlayerShotData = toUnwrappedModel(esPlayerShotData);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, esPlayerShotData);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataImpl.class, esPlayerShotData.getPrimaryKey());

		return esPlayerShotData;
	}

	public ESPlayerShotData updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData esPlayerShotData,
		boolean merge) throws SystemException {
		esPlayerShotData = toUnwrappedModel(esPlayerShotData);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, esPlayerShotData, merge);

			esPlayerShotData.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerShotDataImpl.class, esPlayerShotData.getPrimaryKey(),
			esPlayerShotData);

		return esPlayerShotData;
	}

	protected ESPlayerShotData toUnwrappedModel(
		ESPlayerShotData esPlayerShotData) {
		if (esPlayerShotData instanceof ESPlayerShotDataImpl) {
			return esPlayerShotData;
		}

		ESPlayerShotDataImpl esPlayerShotDataImpl = new ESPlayerShotDataImpl();

		esPlayerShotDataImpl.setNew(esPlayerShotData.isNew());
		esPlayerShotDataImpl.setPrimaryKey(esPlayerShotData.getPrimaryKey());

		esPlayerShotDataImpl.setShotDataId(esPlayerShotData.getShotDataId());
		esPlayerShotDataImpl.setPlayerId(esPlayerShotData.getPlayerId());
		esPlayerShotDataImpl.setPlayerClubId(esPlayerShotData.getPlayerClubId());
		esPlayerShotDataImpl.setProductSerialNo(esPlayerShotData.getProductSerialNo());
		esPlayerShotDataImpl.setLaunchMonitor(esPlayerShotData.isLaunchMonitor());
		esPlayerShotDataImpl.setSimulate(esPlayerShotData.isSimulate());
		esPlayerShotDataImpl.setActive(esPlayerShotData.isActive());
		esPlayerShotDataImpl.setClubLoft(esPlayerShotData.getClubLoft());
		esPlayerShotDataImpl.setClubSpeed(esPlayerShotData.getClubSpeed());
		esPlayerShotDataImpl.setFaceAngle(esPlayerShotData.getFaceAngle());
		esPlayerShotDataImpl.setSwingPath(esPlayerShotData.getSwingPath());
		esPlayerShotDataImpl.setSpinAxisAngle(esPlayerShotData.getSpinAxisAngle());
		esPlayerShotDataImpl.setLaunchAngle(esPlayerShotData.getLaunchAngle());
		esPlayerShotDataImpl.setBallSpeed(esPlayerShotData.getBallSpeed());
		esPlayerShotDataImpl.setBallSpinRate(esPlayerShotData.getBallSpinRate());
		esPlayerShotDataImpl.setBallAngleOfAttack(esPlayerShotData.getBallAngleOfAttack());
		esPlayerShotDataImpl.setBallCompression(esPlayerShotData.getBallCompression());
		esPlayerShotDataImpl.setStepTimeIncrement(esPlayerShotData.getStepTimeIncrement());
		esPlayerShotDataImpl.setWindSpeed(esPlayerShotData.getWindSpeed());
		esPlayerShotDataImpl.setWindDirection(esPlayerShotData.getWindDirection());
		esPlayerShotDataImpl.setAmbientTemp(esPlayerShotData.getAmbientTemp());
		esPlayerShotDataImpl.setBarPressureAlt(esPlayerShotData.getBarPressureAlt());
		esPlayerShotDataImpl.setRelativeHumid(esPlayerShotData.getRelativeHumid());
		esPlayerShotDataImpl.setFairwayFirmness(esPlayerShotData.getFairwayFirmness());
		esPlayerShotDataImpl.setCreateDate(esPlayerShotData.getCreateDate());
		esPlayerShotDataImpl.setModifiedDate(esPlayerShotData.getModifiedDate());

		return esPlayerShotDataImpl;
	}

	/**
	 * Finds the e s player shot data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s player shot data to find
	 * @return the e s player shot data
	 * @throws com.liferay.portal.NoSuchModelException if a e s player shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s player shot data with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException} if it could not be found.
	 *
	 * @param shotDataId the primary key of the e s player shot data to find
	 * @return the e s player shot data
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerShotDataException if a e s player shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData findByPrimaryKey(long shotDataId)
		throws NoSuchESPlayerShotDataException, SystemException {
		ESPlayerShotData esPlayerShotData = fetchByPrimaryKey(shotDataId);

		if (esPlayerShotData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + shotDataId);
			}

			throw new NoSuchESPlayerShotDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				shotDataId);
		}

		return esPlayerShotData;
	}

	/**
	 * Finds the e s player shot data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s player shot data to find
	 * @return the e s player shot data, or <code>null</code> if a e s player shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s player shot data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shotDataId the primary key of the e s player shot data to find
	 * @return the e s player shot data, or <code>null</code> if a e s player shot data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerShotData fetchByPrimaryKey(long shotDataId)
		throws SystemException {
		ESPlayerShotData esPlayerShotData = (ESPlayerShotData)EntityCacheUtil.getResult(ESPlayerShotDataModelImpl.ENTITY_CACHE_ENABLED,
				ESPlayerShotDataImpl.class, shotDataId, this);

		if (esPlayerShotData == null) {
			Session session = null;

			try {
				session = openSession();

				esPlayerShotData = (ESPlayerShotData)session.get(ESPlayerShotDataImpl.class,
						new Long(shotDataId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (esPlayerShotData != null) {
					cacheResult(esPlayerShotData);
				}

				closeSession(session);
			}
		}

		return esPlayerShotData;
	}

	/**
	 * Finds all the e s player shot datas where playerId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @return the matching e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerShotData> findByG_PlayerShotData(long playerId)
		throws SystemException {
		return findByG_PlayerShotData(playerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerShotData> findByG_PlayerShotData(long playerId,
		int start, int end) throws SystemException {
		return findByG_PlayerShotData(playerId, start, end, null);
	}

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
	public List<ESPlayerShotData> findByG_PlayerShotData(long playerId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerShotData> list = (List<ESPlayerShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_PLAYERSHOTDATA,
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

			query.append(_SQL_SELECT_ESPLAYERSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_PLAYERSHOTDATA_PLAYERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				list = (List<ESPlayerShotData>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_PLAYERSHOTDATA,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_PLAYERSHOTDATA,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESPlayerShotData findByG_PlayerShotData_First(long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		List<ESPlayerShotData> list = findByG_PlayerShotData(playerId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerShotData findByG_PlayerShotData_Last(long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		int count = countByG_PlayerShotData(playerId);

		List<ESPlayerShotData> list = findByG_PlayerShotData(playerId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerShotData[] findByG_PlayerShotData_PrevAndNext(
		long shotDataId, long playerId, OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		ESPlayerShotData esPlayerShotData = findByPrimaryKey(shotDataId);

		Session session = null;

		try {
			session = openSession();

			ESPlayerShotData[] array = new ESPlayerShotDataImpl[3];

			array[0] = getByG_PlayerShotData_PrevAndNext(session,
					esPlayerShotData, playerId, orderByComparator, true);

			array[1] = esPlayerShotData;

			array[2] = getByG_PlayerShotData_PrevAndNext(session,
					esPlayerShotData, playerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESPlayerShotData getByG_PlayerShotData_PrevAndNext(
		Session session, ESPlayerShotData esPlayerShotData, long playerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESPLAYERSHOTDATA_WHERE);

		query.append(_FINDER_COLUMN_G_PLAYERSHOTDATA_PLAYERID_2);

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
			query.append(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(playerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esPlayerShotData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESPlayerShotData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s player shot datas where playerId = &#63; and playerClubId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @return the matching e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerShotData> findByG_ClubShotData(long playerId,
		long playerClubId) throws SystemException {
		return findByG_ClubShotData(playerId, playerClubId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerShotData> findByG_ClubShotData(long playerId,
		long playerClubId, int start, int end) throws SystemException {
		return findByG_ClubShotData(playerId, playerClubId, start, end, null);
	}

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
	public List<ESPlayerShotData> findByG_ClubShotData(long playerId,
		long playerClubId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId, playerClubId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerShotData> list = (List<ESPlayerShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_CLUBSHOTDATA,
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

			query.append(_SQL_SELECT_ESPLAYERSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_CLUBSHOTDATA_PLAYERID_2);

			query.append(_FINDER_COLUMN_G_CLUBSHOTDATA_PLAYERCLUBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				qPos.add(playerClubId);

				list = (List<ESPlayerShotData>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_CLUBSHOTDATA,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_CLUBSHOTDATA,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESPlayerShotData findByG_ClubShotData_First(long playerId,
		long playerClubId, OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		List<ESPlayerShotData> list = findByG_ClubShotData(playerId,
				playerClubId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", playerClubId=");
			msg.append(playerClubId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerShotData findByG_ClubShotData_Last(long playerId,
		long playerClubId, OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		int count = countByG_ClubShotData(playerId, playerClubId);

		List<ESPlayerShotData> list = findByG_ClubShotData(playerId,
				playerClubId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", playerClubId=");
			msg.append(playerClubId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerShotData[] findByG_ClubShotData_PrevAndNext(
		long shotDataId, long playerId, long playerClubId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		ESPlayerShotData esPlayerShotData = findByPrimaryKey(shotDataId);

		Session session = null;

		try {
			session = openSession();

			ESPlayerShotData[] array = new ESPlayerShotDataImpl[3];

			array[0] = getByG_ClubShotData_PrevAndNext(session,
					esPlayerShotData, playerId, playerClubId,
					orderByComparator, true);

			array[1] = esPlayerShotData;

			array[2] = getByG_ClubShotData_PrevAndNext(session,
					esPlayerShotData, playerId, playerClubId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESPlayerShotData getByG_ClubShotData_PrevAndNext(
		Session session, ESPlayerShotData esPlayerShotData, long playerId,
		long playerClubId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESPLAYERSHOTDATA_WHERE);

		query.append(_FINDER_COLUMN_G_CLUBSHOTDATA_PLAYERID_2);

		query.append(_FINDER_COLUMN_G_CLUBSHOTDATA_PLAYERCLUBID_2);

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
			query.append(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(playerId);

		qPos.add(playerClubId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esPlayerShotData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESPlayerShotData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s player shot datas where playerId = &#63; and productSerialNo = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param productSerialNo the product serial no to search with
	 * @return the matching e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerShotData> findByG_ProductSerialNo(long playerId,
		int productSerialNo) throws SystemException {
		return findByG_ProductSerialNo(playerId, productSerialNo,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerShotData> findByG_ProductSerialNo(long playerId,
		int productSerialNo, int start, int end) throws SystemException {
		return findByG_ProductSerialNo(playerId, productSerialNo, start, end,
			null);
	}

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
	public List<ESPlayerShotData> findByG_ProductSerialNo(long playerId,
		int productSerialNo, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId, productSerialNo,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerShotData> list = (List<ESPlayerShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_PRODUCTSERIALNO,
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

			query.append(_SQL_SELECT_ESPLAYERSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_PRODUCTSERIALNO_PLAYERID_2);

			query.append(_FINDER_COLUMN_G_PRODUCTSERIALNO_PRODUCTSERIALNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				qPos.add(productSerialNo);

				list = (List<ESPlayerShotData>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_PRODUCTSERIALNO,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_PRODUCTSERIALNO,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESPlayerShotData findByG_ProductSerialNo_First(long playerId,
		int productSerialNo, OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		List<ESPlayerShotData> list = findByG_ProductSerialNo(playerId,
				productSerialNo, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", productSerialNo=");
			msg.append(productSerialNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerShotData findByG_ProductSerialNo_Last(long playerId,
		int productSerialNo, OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		int count = countByG_ProductSerialNo(playerId, productSerialNo);

		List<ESPlayerShotData> list = findByG_ProductSerialNo(playerId,
				productSerialNo, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", productSerialNo=");
			msg.append(productSerialNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerShotData[] findByG_ProductSerialNo_PrevAndNext(
		long shotDataId, long playerId, int productSerialNo,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		ESPlayerShotData esPlayerShotData = findByPrimaryKey(shotDataId);

		Session session = null;

		try {
			session = openSession();

			ESPlayerShotData[] array = new ESPlayerShotDataImpl[3];

			array[0] = getByG_ProductSerialNo_PrevAndNext(session,
					esPlayerShotData, playerId, productSerialNo,
					orderByComparator, true);

			array[1] = esPlayerShotData;

			array[2] = getByG_ProductSerialNo_PrevAndNext(session,
					esPlayerShotData, playerId, productSerialNo,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESPlayerShotData getByG_ProductSerialNo_PrevAndNext(
		Session session, ESPlayerShotData esPlayerShotData, long playerId,
		int productSerialNo, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESPLAYERSHOTDATA_WHERE);

		query.append(_FINDER_COLUMN_G_PRODUCTSERIALNO_PLAYERID_2);

		query.append(_FINDER_COLUMN_G_PRODUCTSERIALNO_PRODUCTSERIALNO_2);

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
			query.append(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(playerId);

		qPos.add(productSerialNo);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esPlayerShotData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESPlayerShotData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s player shot datas where playerId = &#63; and createDate = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @return the matching e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerShotData> findByG_ShotDataByDate(long playerId,
		Date createDate) throws SystemException {
		return findByG_ShotDataByDate(playerId, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerShotData> findByG_ShotDataByDate(long playerId,
		Date createDate, int start, int end) throws SystemException {
		return findByG_ShotDataByDate(playerId, createDate, start, end, null);
	}

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
	public List<ESPlayerShotData> findByG_ShotDataByDate(long playerId,
		Date createDate, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId, createDate,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerShotData> list = (List<ESPlayerShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_SHOTDATABYDATE,
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

			query.append(_SQL_SELECT_ESPLAYERSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_PLAYERID_2);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
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

				list = (List<ESPlayerShotData>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_SHOTDATABYDATE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_SHOTDATABYDATE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESPlayerShotData findByG_ShotDataByDate_First(long playerId,
		Date createDate, OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		List<ESPlayerShotData> list = findByG_ShotDataByDate(playerId,
				createDate, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", createDate=");
			msg.append(createDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerShotData findByG_ShotDataByDate_Last(long playerId,
		Date createDate, OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		int count = countByG_ShotDataByDate(playerId, createDate);

		List<ESPlayerShotData> list = findByG_ShotDataByDate(playerId,
				createDate, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(", createDate=");
			msg.append(createDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerShotDataException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerShotData[] findByG_ShotDataByDate_PrevAndNext(
		long shotDataId, long playerId, Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerShotDataException, SystemException {
		ESPlayerShotData esPlayerShotData = findByPrimaryKey(shotDataId);

		Session session = null;

		try {
			session = openSession();

			ESPlayerShotData[] array = new ESPlayerShotDataImpl[3];

			array[0] = getByG_ShotDataByDate_PrevAndNext(session,
					esPlayerShotData, playerId, createDate, orderByComparator,
					true);

			array[1] = esPlayerShotData;

			array[2] = getByG_ShotDataByDate_PrevAndNext(session,
					esPlayerShotData, playerId, createDate, orderByComparator,
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

	protected ESPlayerShotData getByG_ShotDataByDate_PrevAndNext(
		Session session, ESPlayerShotData esPlayerShotData, long playerId,
		Date createDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESPLAYERSHOTDATA_WHERE);

		query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_PLAYERID_2);

		if (createDate == null) {
			query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_CREATEDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_CREATEDATE_2);
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
			query.append(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByValues(esPlayerShotData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESPlayerShotData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s player shot datas.
	 *
	 * @return the e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerShotData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerShotData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<ESPlayerShotData> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerShotData> list = (List<ESPlayerShotData>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESPLAYERSHOTDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESPLAYERSHOTDATA.concat(ESPlayerShotDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ESPlayerShotData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ESPlayerShotData>)QueryUtil.list(q,
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
	 * Removes all the e s player shot datas where playerId = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_PlayerShotData(long playerId)
		throws SystemException {
		for (ESPlayerShotData esPlayerShotData : findByG_PlayerShotData(
				playerId)) {
			remove(esPlayerShotData);
		}
	}

	/**
	 * Removes all the e s player shot datas where playerId = &#63; and playerClubId = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_ClubShotData(long playerId, long playerClubId)
		throws SystemException {
		for (ESPlayerShotData esPlayerShotData : findByG_ClubShotData(
				playerId, playerClubId)) {
			remove(esPlayerShotData);
		}
	}

	/**
	 * Removes all the e s player shot datas where playerId = &#63; and productSerialNo = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @param productSerialNo the product serial no to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_ProductSerialNo(long playerId, int productSerialNo)
		throws SystemException {
		for (ESPlayerShotData esPlayerShotData : findByG_ProductSerialNo(
				playerId, productSerialNo)) {
			remove(esPlayerShotData);
		}
	}

	/**
	 * Removes all the e s player shot datas where playerId = &#63; and createDate = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_ShotDataByDate(long playerId, Date createDate)
		throws SystemException {
		for (ESPlayerShotData esPlayerShotData : findByG_ShotDataByDate(
				playerId, createDate)) {
			remove(esPlayerShotData);
		}
	}

	/**
	 * Removes all the e s player shot datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ESPlayerShotData esPlayerShotData : findAll()) {
			remove(esPlayerShotData);
		}
	}

	/**
	 * Counts all the e s player shot datas where playerId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @return the number of matching e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_PlayerShotData(long playerId) throws SystemException {
		Object[] finderArgs = new Object[] { playerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_PLAYERSHOTDATA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESPLAYERSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_PLAYERSHOTDATA_PLAYERID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_PLAYERSHOTDATA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s player shot datas where playerId = &#63; and playerClubId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param playerClubId the player club id to search with
	 * @return the number of matching e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_ClubShotData(long playerId, long playerClubId)
		throws SystemException {
		Object[] finderArgs = new Object[] { playerId, playerClubId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_CLUBSHOTDATA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESPLAYERSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_CLUBSHOTDATA_PLAYERID_2);

			query.append(_FINDER_COLUMN_G_CLUBSHOTDATA_PLAYERCLUBID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_CLUBSHOTDATA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s player shot datas where playerId = &#63; and productSerialNo = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param productSerialNo the product serial no to search with
	 * @return the number of matching e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_ProductSerialNo(long playerId, int productSerialNo)
		throws SystemException {
		Object[] finderArgs = new Object[] { playerId, productSerialNo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_PRODUCTSERIALNO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESPLAYERSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_PRODUCTSERIALNO_PLAYERID_2);

			query.append(_FINDER_COLUMN_G_PRODUCTSERIALNO_PRODUCTSERIALNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				qPos.add(productSerialNo);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_PRODUCTSERIALNO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s player shot datas where playerId = &#63; and createDate = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @param createDate the create date to search with
	 * @return the number of matching e s player shot datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_ShotDataByDate(long playerId, Date createDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { playerId, createDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_SHOTDATABYDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESPLAYERSHOTDATA_WHERE);

			query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_PLAYERID_2);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_SHOTDATABYDATE_CREATEDATE_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_SHOTDATABYDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s player shot datas.
	 *
	 * @return the number of e s player shot datas
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

				Query q = session.createQuery(_SQL_COUNT_ESPLAYERSHOTDATA);

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
	 * Initializes the e s player shot data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESPlayerShotData>> listenersList = new ArrayList<ModelListener<ESPlayerShotData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESPlayerShotData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESPlayerShotDataImpl.class.getName());
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
	private static final String _SQL_SELECT_ESPLAYERSHOTDATA = "SELECT esPlayerShotData FROM ESPlayerShotData esPlayerShotData";
	private static final String _SQL_SELECT_ESPLAYERSHOTDATA_WHERE = "SELECT esPlayerShotData FROM ESPlayerShotData esPlayerShotData WHERE ";
	private static final String _SQL_COUNT_ESPLAYERSHOTDATA = "SELECT COUNT(esPlayerShotData) FROM ESPlayerShotData esPlayerShotData";
	private static final String _SQL_COUNT_ESPLAYERSHOTDATA_WHERE = "SELECT COUNT(esPlayerShotData) FROM ESPlayerShotData esPlayerShotData WHERE ";
	private static final String _FINDER_COLUMN_G_PLAYERSHOTDATA_PLAYERID_2 = "esPlayerShotData.playerId = ?";
	private static final String _FINDER_COLUMN_G_CLUBSHOTDATA_PLAYERID_2 = "esPlayerShotData.playerId = ? AND ";
	private static final String _FINDER_COLUMN_G_CLUBSHOTDATA_PLAYERCLUBID_2 = "esPlayerShotData.playerClubId = ?";
	private static final String _FINDER_COLUMN_G_PRODUCTSERIALNO_PLAYERID_2 = "esPlayerShotData.playerId = ? AND ";
	private static final String _FINDER_COLUMN_G_PRODUCTSERIALNO_PRODUCTSERIALNO_2 =
		"esPlayerShotData.productSerialNo = ?";
	private static final String _FINDER_COLUMN_G_SHOTDATABYDATE_PLAYERID_2 = "esPlayerShotData.playerId = ? AND ";
	private static final String _FINDER_COLUMN_G_SHOTDATABYDATE_CREATEDATE_1 = "esPlayerShotData.createDate IS NULL";
	private static final String _FINDER_COLUMN_G_SHOTDATABYDATE_CREATEDATE_2 = "esPlayerShotData.createDate = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esPlayerShotData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESPlayerShotData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESPlayerShotData exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ESPlayerShotDataPersistenceImpl.class);
}