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

import com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException;
import com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing;
import com.eswinggolf.portal.data.layer.club.model.impl.ESShotDataSharingImpl;
import com.eswinggolf.portal.data.layer.club.model.impl.ESShotDataSharingModelImpl;

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
import java.util.List;

/**
 * The persistence implementation for the e s shot data sharing service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ESShotDataSharingUtil} to access the e s shot data sharing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESShotDataSharingPersistence
 * @see ESShotDataSharingUtil
 * @generated
 */
public class ESShotDataSharingPersistenceImpl extends BasePersistenceImpl<ESShotDataSharing>
	implements ESShotDataSharingPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ESShotDataSharingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_PLAYERSHARED = new FinderPath(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPlayerShared",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PLAYERSHARED = new FinderPath(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByPlayerShared",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPSHARED = new FinderPath(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByGroupShared",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPSHARED = new FinderPath(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByGroupShared",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYSHARED = new FinderPath(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCompanyShared",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYSHARED = new FinderPath(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCompanyShared",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the e s shot data sharing in the entity cache if it is enabled.
	 *
	 * @param esShotDataSharing the e s shot data sharing to cache
	 */
	public void cacheResult(ESShotDataSharing esShotDataSharing) {
		EntityCacheUtil.putResult(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingImpl.class, esShotDataSharing.getPrimaryKey(),
			esShotDataSharing);
	}

	/**
	 * Caches the e s shot data sharings in the entity cache if it is enabled.
	 *
	 * @param esShotDataSharings the e s shot data sharings to cache
	 */
	public void cacheResult(List<ESShotDataSharing> esShotDataSharings) {
		for (ESShotDataSharing esShotDataSharing : esShotDataSharings) {
			if (EntityCacheUtil.getResult(
						ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
						ESShotDataSharingImpl.class,
						esShotDataSharing.getPrimaryKey(), this) == null) {
				cacheResult(esShotDataSharing);
			}
		}
	}

	/**
	 * Clears the cache for all e s shot data sharings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ESShotDataSharingImpl.class.getName());
		EntityCacheUtil.clearCache(ESShotDataSharingImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the e s shot data sharing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ESShotDataSharing esShotDataSharing) {
		EntityCacheUtil.removeResult(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingImpl.class, esShotDataSharing.getPrimaryKey());
	}

	/**
	 * Creates a new e s shot data sharing with the primary key. Does not add the e s shot data sharing to the database.
	 *
	 * @param shotDataSharingId the primary key for the new e s shot data sharing
	 * @return the new e s shot data sharing
	 */
	public ESShotDataSharing create(long shotDataSharingId) {
		ESShotDataSharing esShotDataSharing = new ESShotDataSharingImpl();

		esShotDataSharing.setNew(true);
		esShotDataSharing.setPrimaryKey(shotDataSharingId);

		return esShotDataSharing;
	}

	/**
	 * Removes the e s shot data sharing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s shot data sharing to remove
	 * @return the e s shot data sharing that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a e s shot data sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESShotDataSharing remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the e s shot data sharing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shotDataSharingId the primary key of the e s shot data sharing to remove
	 * @return the e s shot data sharing that was removed
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESShotDataSharing remove(long shotDataSharingId)
		throws NoSuchESShotDataSharingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESShotDataSharing esShotDataSharing = (ESShotDataSharing)session.get(ESShotDataSharingImpl.class,
					new Long(shotDataSharingId));

			if (esShotDataSharing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						shotDataSharingId);
				}

				throw new NoSuchESShotDataSharingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					shotDataSharingId);
			}

			return remove(esShotDataSharing);
		}
		catch (NoSuchESShotDataSharingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESShotDataSharing removeImpl(ESShotDataSharing esShotDataSharing)
		throws SystemException {
		esShotDataSharing = toUnwrappedModel(esShotDataSharing);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, esShotDataSharing);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingImpl.class, esShotDataSharing.getPrimaryKey());

		return esShotDataSharing;
	}

	public ESShotDataSharing updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing esShotDataSharing,
		boolean merge) throws SystemException {
		esShotDataSharing = toUnwrappedModel(esShotDataSharing);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, esShotDataSharing, merge);

			esShotDataSharing.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
			ESShotDataSharingImpl.class, esShotDataSharing.getPrimaryKey(),
			esShotDataSharing);

		return esShotDataSharing;
	}

	protected ESShotDataSharing toUnwrappedModel(
		ESShotDataSharing esShotDataSharing) {
		if (esShotDataSharing instanceof ESShotDataSharingImpl) {
			return esShotDataSharing;
		}

		ESShotDataSharingImpl esShotDataSharingImpl = new ESShotDataSharingImpl();

		esShotDataSharingImpl.setNew(esShotDataSharing.isNew());
		esShotDataSharingImpl.setPrimaryKey(esShotDataSharing.getPrimaryKey());

		esShotDataSharingImpl.setShotDataSharingId(esShotDataSharing.getShotDataSharingId());
		esShotDataSharingImpl.setShotDataId(esShotDataSharing.getShotDataId());
		esShotDataSharingImpl.setPlayerId(esShotDataSharing.getPlayerId());
		esShotDataSharingImpl.setUserId(esShotDataSharing.getUserId());
		esShotDataSharingImpl.setCompanyId(esShotDataSharing.getCompanyId());
		esShotDataSharingImpl.setGroupId(esShotDataSharing.getGroupId());
		esShotDataSharingImpl.setActive(esShotDataSharing.isActive());
		esShotDataSharingImpl.setCreateDate(esShotDataSharing.getCreateDate());
		esShotDataSharingImpl.setModifyDate(esShotDataSharing.getModifyDate());

		return esShotDataSharingImpl;
	}

	/**
	 * Finds the e s shot data sharing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s shot data sharing to find
	 * @return the e s shot data sharing
	 * @throws com.liferay.portal.NoSuchModelException if a e s shot data sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESShotDataSharing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s shot data sharing with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException} if it could not be found.
	 *
	 * @param shotDataSharingId the primary key of the e s shot data sharing to find
	 * @return the e s shot data sharing
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESShotDataSharingException if a e s shot data sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESShotDataSharing findByPrimaryKey(long shotDataSharingId)
		throws NoSuchESShotDataSharingException, SystemException {
		ESShotDataSharing esShotDataSharing = fetchByPrimaryKey(shotDataSharingId);

		if (esShotDataSharing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + shotDataSharingId);
			}

			throw new NoSuchESShotDataSharingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				shotDataSharingId);
		}

		return esShotDataSharing;
	}

	/**
	 * Finds the e s shot data sharing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s shot data sharing to find
	 * @return the e s shot data sharing, or <code>null</code> if a e s shot data sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESShotDataSharing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s shot data sharing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shotDataSharingId the primary key of the e s shot data sharing to find
	 * @return the e s shot data sharing, or <code>null</code> if a e s shot data sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESShotDataSharing fetchByPrimaryKey(long shotDataSharingId)
		throws SystemException {
		ESShotDataSharing esShotDataSharing = (ESShotDataSharing)EntityCacheUtil.getResult(ESShotDataSharingModelImpl.ENTITY_CACHE_ENABLED,
				ESShotDataSharingImpl.class, shotDataSharingId, this);

		if (esShotDataSharing == null) {
			Session session = null;

			try {
				session = openSession();

				esShotDataSharing = (ESShotDataSharing)session.get(ESShotDataSharingImpl.class,
						new Long(shotDataSharingId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (esShotDataSharing != null) {
					cacheResult(esShotDataSharing);
				}

				closeSession(session);
			}
		}

		return esShotDataSharing;
	}

	/**
	 * Finds all the e s shot data sharings where playerId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @return the matching e s shot data sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESShotDataSharing> findByPlayerShared(long playerId)
		throws SystemException {
		return findByPlayerShared(playerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESShotDataSharing> findByPlayerShared(long playerId, int start,
		int end) throws SystemException {
		return findByPlayerShared(playerId, start, end, null);
	}

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
	public List<ESShotDataSharing> findByPlayerShared(long playerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESShotDataSharing> list = (List<ESShotDataSharing>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PLAYERSHARED,
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

			query.append(_SQL_SELECT_ESSHOTDATASHARING_WHERE);

			query.append(_FINDER_COLUMN_PLAYERSHARED_PLAYERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESShotDataSharingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				list = (List<ESShotDataSharing>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_PLAYERSHARED,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PLAYERSHARED,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESShotDataSharing findByPlayerShared_First(long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		List<ESShotDataSharing> list = findByPlayerShared(playerId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESShotDataSharingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESShotDataSharing findByPlayerShared_Last(long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		int count = countByPlayerShared(playerId);

		List<ESShotDataSharing> list = findByPlayerShared(playerId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESShotDataSharingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESShotDataSharing[] findByPlayerShared_PrevAndNext(
		long shotDataSharingId, long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		ESShotDataSharing esShotDataSharing = findByPrimaryKey(shotDataSharingId);

		Session session = null;

		try {
			session = openSession();

			ESShotDataSharing[] array = new ESShotDataSharingImpl[3];

			array[0] = getByPlayerShared_PrevAndNext(session,
					esShotDataSharing, playerId, orderByComparator, true);

			array[1] = esShotDataSharing;

			array[2] = getByPlayerShared_PrevAndNext(session,
					esShotDataSharing, playerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESShotDataSharing getByPlayerShared_PrevAndNext(Session session,
		ESShotDataSharing esShotDataSharing, long playerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESSHOTDATASHARING_WHERE);

		query.append(_FINDER_COLUMN_PLAYERSHARED_PLAYERID_2);

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
			query.append(ESShotDataSharingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(playerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esShotDataSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESShotDataSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s shot data sharings where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching e s shot data sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESShotDataSharing> findByGroupShared(long groupId)
		throws SystemException {
		return findByGroupShared(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	public List<ESShotDataSharing> findByGroupShared(long groupId, int start,
		int end) throws SystemException {
		return findByGroupShared(groupId, start, end, null);
	}

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
	public List<ESShotDataSharing> findByGroupShared(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESShotDataSharing> list = (List<ESShotDataSharing>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPSHARED,
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

			query.append(_SQL_SELECT_ESSHOTDATASHARING_WHERE);

			query.append(_FINDER_COLUMN_GROUPSHARED_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESShotDataSharingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ESShotDataSharing>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPSHARED,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPSHARED,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESShotDataSharing findByGroupShared_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		List<ESShotDataSharing> list = findByGroupShared(groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESShotDataSharingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESShotDataSharing findByGroupShared_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		int count = countByGroupShared(groupId);

		List<ESShotDataSharing> list = findByGroupShared(groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESShotDataSharingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESShotDataSharing[] findByGroupShared_PrevAndNext(
		long shotDataSharingId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		ESShotDataSharing esShotDataSharing = findByPrimaryKey(shotDataSharingId);

		Session session = null;

		try {
			session = openSession();

			ESShotDataSharing[] array = new ESShotDataSharingImpl[3];

			array[0] = getByGroupShared_PrevAndNext(session, esShotDataSharing,
					groupId, orderByComparator, true);

			array[1] = esShotDataSharing;

			array[2] = getByGroupShared_PrevAndNext(session, esShotDataSharing,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESShotDataSharing getByGroupShared_PrevAndNext(Session session,
		ESShotDataSharing esShotDataSharing, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESSHOTDATASHARING_WHERE);

		query.append(_FINDER_COLUMN_GROUPSHARED_GROUPID_2);

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
			query.append(ESShotDataSharingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esShotDataSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESShotDataSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s shot data sharings where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching e s shot data sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESShotDataSharing> findByCompanyShared(long companyId)
		throws SystemException {
		return findByCompanyShared(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESShotDataSharing> findByCompanyShared(long companyId,
		int start, int end) throws SystemException {
		return findByCompanyShared(companyId, start, end, null);
	}

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
	public List<ESShotDataSharing> findByCompanyShared(long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESShotDataSharing> list = (List<ESShotDataSharing>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYSHARED,
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

			query.append(_SQL_SELECT_ESSHOTDATASHARING_WHERE);

			query.append(_FINDER_COLUMN_COMPANYSHARED_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESShotDataSharingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<ESShotDataSharing>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_COMPANYSHARED,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYSHARED,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESShotDataSharing findByCompanyShared_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		List<ESShotDataSharing> list = findByCompanyShared(companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESShotDataSharingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESShotDataSharing findByCompanyShared_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		int count = countByCompanyShared(companyId);

		List<ESShotDataSharing> list = findByCompanyShared(companyId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESShotDataSharingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESShotDataSharing[] findByCompanyShared_PrevAndNext(
		long shotDataSharingId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchESShotDataSharingException, SystemException {
		ESShotDataSharing esShotDataSharing = findByPrimaryKey(shotDataSharingId);

		Session session = null;

		try {
			session = openSession();

			ESShotDataSharing[] array = new ESShotDataSharingImpl[3];

			array[0] = getByCompanyShared_PrevAndNext(session,
					esShotDataSharing, companyId, orderByComparator, true);

			array[1] = esShotDataSharing;

			array[2] = getByCompanyShared_PrevAndNext(session,
					esShotDataSharing, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESShotDataSharing getByCompanyShared_PrevAndNext(
		Session session, ESShotDataSharing esShotDataSharing, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESSHOTDATASHARING_WHERE);

		query.append(_FINDER_COLUMN_COMPANYSHARED_COMPANYID_2);

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
			query.append(ESShotDataSharingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esShotDataSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESShotDataSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s shot data sharings.
	 *
	 * @return the e s shot data sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESShotDataSharing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<ESShotDataSharing> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<ESShotDataSharing> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESShotDataSharing> list = (List<ESShotDataSharing>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESSHOTDATASHARING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESSHOTDATASHARING.concat(ESShotDataSharingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ESShotDataSharing>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ESShotDataSharing>)QueryUtil.list(q,
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
	 * Removes all the e s shot data sharings where playerId = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPlayerShared(long playerId) throws SystemException {
		for (ESShotDataSharing esShotDataSharing : findByPlayerShared(playerId)) {
			remove(esShotDataSharing);
		}
	}

	/**
	 * Removes all the e s shot data sharings where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupShared(long groupId) throws SystemException {
		for (ESShotDataSharing esShotDataSharing : findByGroupShared(groupId)) {
			remove(esShotDataSharing);
		}
	}

	/**
	 * Removes all the e s shot data sharings where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyShared(long companyId) throws SystemException {
		for (ESShotDataSharing esShotDataSharing : findByCompanyShared(
				companyId)) {
			remove(esShotDataSharing);
		}
	}

	/**
	 * Removes all the e s shot data sharings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ESShotDataSharing esShotDataSharing : findAll()) {
			remove(esShotDataSharing);
		}
	}

	/**
	 * Counts all the e s shot data sharings where playerId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @return the number of matching e s shot data sharings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPlayerShared(long playerId) throws SystemException {
		Object[] finderArgs = new Object[] { playerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PLAYERSHARED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESSHOTDATASHARING_WHERE);

			query.append(_FINDER_COLUMN_PLAYERSHARED_PLAYERID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PLAYERSHARED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s shot data sharings where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching e s shot data sharings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupShared(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPSHARED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESSHOTDATASHARING_WHERE);

			query.append(_FINDER_COLUMN_GROUPSHARED_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPSHARED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s shot data sharings where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching e s shot data sharings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyShared(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYSHARED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESSHOTDATASHARING_WHERE);

			query.append(_FINDER_COLUMN_COMPANYSHARED_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYSHARED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s shot data sharings.
	 *
	 * @return the number of e s shot data sharings
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

				Query q = session.createQuery(_SQL_COUNT_ESSHOTDATASHARING);

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
	 * Initializes the e s shot data sharing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.eswinggolf.portal.data.layer.club.model.ESShotDataSharing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESShotDataSharing>> listenersList = new ArrayList<ModelListener<ESShotDataSharing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESShotDataSharing>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESShotDataSharingImpl.class.getName());
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
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ESSHOTDATASHARING = "SELECT esShotDataSharing FROM ESShotDataSharing esShotDataSharing";
	private static final String _SQL_SELECT_ESSHOTDATASHARING_WHERE = "SELECT esShotDataSharing FROM ESShotDataSharing esShotDataSharing WHERE ";
	private static final String _SQL_COUNT_ESSHOTDATASHARING = "SELECT COUNT(esShotDataSharing) FROM ESShotDataSharing esShotDataSharing";
	private static final String _SQL_COUNT_ESSHOTDATASHARING_WHERE = "SELECT COUNT(esShotDataSharing) FROM ESShotDataSharing esShotDataSharing WHERE ";
	private static final String _FINDER_COLUMN_PLAYERSHARED_PLAYERID_2 = "esShotDataSharing.playerId = ?";
	private static final String _FINDER_COLUMN_GROUPSHARED_GROUPID_2 = "esShotDataSharing.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYSHARED_COMPANYID_2 = "esShotDataSharing.companyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esShotDataSharing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESShotDataSharing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESShotDataSharing exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ESShotDataSharingPersistenceImpl.class);
}