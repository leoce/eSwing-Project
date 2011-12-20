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

import com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;
import com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerClubImpl;
import com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerClubModelImpl;

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
 * The persistence implementation for the e s player club service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ESPlayerClubUtil} to access the e s player club persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESPlayerClubPersistence
 * @see ESPlayerClubUtil
 * @generated
 */
public class ESPlayerClubPersistenceImpl extends BasePersistenceImpl<ESPlayerClub>
	implements ESPlayerClubPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ESPlayerClubImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_PLAYERCLUBGROUP = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPlayerClubGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PLAYERCLUBGROUP = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPlayerClubGroup", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PLAYERCLUBCOMPANY = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPlayerClubCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PLAYERCLUBCOMPANY = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPlayerClubCompany", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ALLCLUBS = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByAllClubs",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLCLUBS = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByAllClubs",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PLAYERCLUBS = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPlayerClubs",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PLAYERCLUBS = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPlayerClubs", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the e s player club in the entity cache if it is enabled.
	 *
	 * @param esPlayerClub the e s player club to cache
	 */
	public void cacheResult(ESPlayerClub esPlayerClub) {
		EntityCacheUtil.putResult(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubImpl.class, esPlayerClub.getPrimaryKey(), esPlayerClub);
	}

	/**
	 * Caches the e s player clubs in the entity cache if it is enabled.
	 *
	 * @param esPlayerClubs the e s player clubs to cache
	 */
	public void cacheResult(List<ESPlayerClub> esPlayerClubs) {
		for (ESPlayerClub esPlayerClub : esPlayerClubs) {
			if (EntityCacheUtil.getResult(
						ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
						ESPlayerClubImpl.class, esPlayerClub.getPrimaryKey(),
						this) == null) {
				cacheResult(esPlayerClub);
			}
		}
	}

	/**
	 * Clears the cache for all e s player clubs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ESPlayerClubImpl.class.getName());
		EntityCacheUtil.clearCache(ESPlayerClubImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the e s player club.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ESPlayerClub esPlayerClub) {
		EntityCacheUtil.removeResult(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubImpl.class, esPlayerClub.getPrimaryKey());
	}

	/**
	 * Creates a new e s player club with the primary key. Does not add the e s player club to the database.
	 *
	 * @param playerClubId the primary key for the new e s player club
	 * @return the new e s player club
	 */
	public ESPlayerClub create(long playerClubId) {
		ESPlayerClub esPlayerClub = new ESPlayerClubImpl();

		esPlayerClub.setNew(true);
		esPlayerClub.setPrimaryKey(playerClubId);

		return esPlayerClub;
	}

	/**
	 * Removes the e s player club with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s player club to remove
	 * @return the e s player club that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a e s player club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerClub remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the e s player club with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param playerClubId the primary key of the e s player club to remove
	 * @return the e s player club that was removed
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerClub remove(long playerClubId)
		throws NoSuchESPlayerClubException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESPlayerClub esPlayerClub = (ESPlayerClub)session.get(ESPlayerClubImpl.class,
					new Long(playerClubId));

			if (esPlayerClub == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + playerClubId);
				}

				throw new NoSuchESPlayerClubException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					playerClubId);
			}

			return remove(esPlayerClub);
		}
		catch (NoSuchESPlayerClubException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESPlayerClub removeImpl(ESPlayerClub esPlayerClub)
		throws SystemException {
		esPlayerClub = toUnwrappedModel(esPlayerClub);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, esPlayerClub);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubImpl.class, esPlayerClub.getPrimaryKey());

		return esPlayerClub;
	}

	public ESPlayerClub updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESPlayerClub esPlayerClub,
		boolean merge) throws SystemException {
		esPlayerClub = toUnwrappedModel(esPlayerClub);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, esPlayerClub, merge);

			esPlayerClub.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
			ESPlayerClubImpl.class, esPlayerClub.getPrimaryKey(), esPlayerClub);

		return esPlayerClub;
	}

	protected ESPlayerClub toUnwrappedModel(ESPlayerClub esPlayerClub) {
		if (esPlayerClub instanceof ESPlayerClubImpl) {
			return esPlayerClub;
		}

		ESPlayerClubImpl esPlayerClubImpl = new ESPlayerClubImpl();

		esPlayerClubImpl.setNew(esPlayerClub.isNew());
		esPlayerClubImpl.setPrimaryKey(esPlayerClub.getPrimaryKey());

		esPlayerClubImpl.setPlayerClubId(esPlayerClub.getPlayerClubId());
		esPlayerClubImpl.setClubId(esPlayerClub.getClubId());
		esPlayerClubImpl.setPlayerId(esPlayerClub.getPlayerId());
		esPlayerClubImpl.setCompanyId(esPlayerClub.getCompanyId());
		esPlayerClubImpl.setGroupId(esPlayerClub.getGroupId());
		esPlayerClubImpl.setUserId(esPlayerClub.getUserId());
		esPlayerClubImpl.setClubDesc(esPlayerClub.getClubDesc());
		esPlayerClubImpl.setLoft(esPlayerClub.getLoft());
		esPlayerClubImpl.setNomSr(esPlayerClub.getNomSr());
		esPlayerClubImpl.setNomSpeed(esPlayerClub.getNomSpeed());
		esPlayerClubImpl.setCoR(esPlayerClub.getCoR());
		esPlayerClubImpl.setWeight(esPlayerClub.getWeight());
		esPlayerClubImpl.setModel(esPlayerClub.getModel());
		esPlayerClubImpl.setActive(esPlayerClub.isActive());
		esPlayerClubImpl.setCreateDate(esPlayerClub.getCreateDate());
		esPlayerClubImpl.setModifiedDate(esPlayerClub.getModifiedDate());

		return esPlayerClubImpl;
	}

	/**
	 * Finds the e s player club with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s player club to find
	 * @return the e s player club
	 * @throws com.liferay.portal.NoSuchModelException if a e s player club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerClub findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s player club with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException} if it could not be found.
	 *
	 * @param playerClubId the primary key of the e s player club to find
	 * @return the e s player club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException if a e s player club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerClub findByPrimaryKey(long playerClubId)
		throws NoSuchESPlayerClubException, SystemException {
		ESPlayerClub esPlayerClub = fetchByPrimaryKey(playerClubId);

		if (esPlayerClub == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + playerClubId);
			}

			throw new NoSuchESPlayerClubException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				playerClubId);
		}

		return esPlayerClub;
	}

	/**
	 * Finds the e s player club with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s player club to find
	 * @return the e s player club, or <code>null</code> if a e s player club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerClub fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s player club with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param playerClubId the primary key of the e s player club to find
	 * @return the e s player club, or <code>null</code> if a e s player club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESPlayerClub fetchByPrimaryKey(long playerClubId)
		throws SystemException {
		ESPlayerClub esPlayerClub = (ESPlayerClub)EntityCacheUtil.getResult(ESPlayerClubModelImpl.ENTITY_CACHE_ENABLED,
				ESPlayerClubImpl.class, playerClubId, this);

		if (esPlayerClub == null) {
			Session session = null;

			try {
				session = openSession();

				esPlayerClub = (ESPlayerClub)session.get(ESPlayerClubImpl.class,
						new Long(playerClubId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (esPlayerClub != null) {
					cacheResult(esPlayerClub);
				}

				closeSession(session);
			}
		}

		return esPlayerClub;
	}

	/**
	 * Finds all the e s player clubs where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerClub> findByPlayerClubGroup(long groupId)
		throws SystemException {
		return findByPlayerClubGroup(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerClub> findByPlayerClubGroup(long groupId, int start,
		int end) throws SystemException {
		return findByPlayerClubGroup(groupId, start, end, null);
	}

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
	public List<ESPlayerClub> findByPlayerClubGroup(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerClub> list = (List<ESPlayerClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PLAYERCLUBGROUP,
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

			query.append(_SQL_SELECT_ESPLAYERCLUB_WHERE);

			query.append(_FINDER_COLUMN_PLAYERCLUBGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESPlayerClubModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ESPlayerClub>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_PLAYERCLUBGROUP,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PLAYERCLUBGROUP,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESPlayerClub findByPlayerClubGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		List<ESPlayerClub> list = findByPlayerClubGroup(groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerClub findByPlayerClubGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		int count = countByPlayerClubGroup(groupId);

		List<ESPlayerClub> list = findByPlayerClubGroup(groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerClub[] findByPlayerClubGroup_PrevAndNext(long playerClubId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		ESPlayerClub esPlayerClub = findByPrimaryKey(playerClubId);

		Session session = null;

		try {
			session = openSession();

			ESPlayerClub[] array = new ESPlayerClubImpl[3];

			array[0] = getByPlayerClubGroup_PrevAndNext(session, esPlayerClub,
					groupId, orderByComparator, true);

			array[1] = esPlayerClub;

			array[2] = getByPlayerClubGroup_PrevAndNext(session, esPlayerClub,
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

	protected ESPlayerClub getByPlayerClubGroup_PrevAndNext(Session session,
		ESPlayerClub esPlayerClub, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESPLAYERCLUB_WHERE);

		query.append(_FINDER_COLUMN_PLAYERCLUBGROUP_GROUPID_2);

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
			query.append(ESPlayerClubModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esPlayerClub);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESPlayerClub> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s player clubs where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerClub> findByPlayerClubCompany(long companyId)
		throws SystemException {
		return findByPlayerClubCompany(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerClub> findByPlayerClubCompany(long companyId,
		int start, int end) throws SystemException {
		return findByPlayerClubCompany(companyId, start, end, null);
	}

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
	public List<ESPlayerClub> findByPlayerClubCompany(long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerClub> list = (List<ESPlayerClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PLAYERCLUBCOMPANY,
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

			query.append(_SQL_SELECT_ESPLAYERCLUB_WHERE);

			query.append(_FINDER_COLUMN_PLAYERCLUBCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESPlayerClubModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<ESPlayerClub>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_PLAYERCLUBCOMPANY,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PLAYERCLUBCOMPANY,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESPlayerClub findByPlayerClubCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		List<ESPlayerClub> list = findByPlayerClubCompany(companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerClub findByPlayerClubCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		int count = countByPlayerClubCompany(companyId);

		List<ESPlayerClub> list = findByPlayerClubCompany(companyId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerClub[] findByPlayerClubCompany_PrevAndNext(
		long playerClubId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		ESPlayerClub esPlayerClub = findByPrimaryKey(playerClubId);

		Session session = null;

		try {
			session = openSession();

			ESPlayerClub[] array = new ESPlayerClubImpl[3];

			array[0] = getByPlayerClubCompany_PrevAndNext(session,
					esPlayerClub, companyId, orderByComparator, true);

			array[1] = esPlayerClub;

			array[2] = getByPlayerClubCompany_PrevAndNext(session,
					esPlayerClub, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESPlayerClub getByPlayerClubCompany_PrevAndNext(Session session,
		ESPlayerClub esPlayerClub, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESPLAYERCLUB_WHERE);

		query.append(_FINDER_COLUMN_PLAYERCLUBCOMPANY_COMPANYID_2);

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
			query.append(ESPlayerClubModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esPlayerClub);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESPlayerClub> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s player clubs where clubId = &#63; and active = &#63;.
	 *
	 * @param clubId the club id to search with
	 * @param active the active to search with
	 * @return the matching e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerClub> findByAllClubs(long clubId, boolean active)
		throws SystemException {
		return findByAllClubs(clubId, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerClub> findByAllClubs(long clubId, boolean active,
		int start, int end) throws SystemException {
		return findByAllClubs(clubId, active, start, end, null);
	}

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
	public List<ESPlayerClub> findByAllClubs(long clubId, boolean active,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				clubId, active,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerClub> list = (List<ESPlayerClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ALLCLUBS,
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

			query.append(_SQL_SELECT_ESPLAYERCLUB_WHERE);

			query.append(_FINDER_COLUMN_ALLCLUBS_CLUBID_2);

			query.append(_FINDER_COLUMN_ALLCLUBS_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESPlayerClubModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clubId);

				qPos.add(active);

				list = (List<ESPlayerClub>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_ALLCLUBS,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ALLCLUBS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESPlayerClub findByAllClubs_First(long clubId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		List<ESPlayerClub> list = findByAllClubs(clubId, active, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("clubId=");
			msg.append(clubId);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerClub findByAllClubs_Last(long clubId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		int count = countByAllClubs(clubId, active);

		List<ESPlayerClub> list = findByAllClubs(clubId, active, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("clubId=");
			msg.append(clubId);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerClub[] findByAllClubs_PrevAndNext(long playerClubId,
		long clubId, boolean active, OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		ESPlayerClub esPlayerClub = findByPrimaryKey(playerClubId);

		Session session = null;

		try {
			session = openSession();

			ESPlayerClub[] array = new ESPlayerClubImpl[3];

			array[0] = getByAllClubs_PrevAndNext(session, esPlayerClub, clubId,
					active, orderByComparator, true);

			array[1] = esPlayerClub;

			array[2] = getByAllClubs_PrevAndNext(session, esPlayerClub, clubId,
					active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESPlayerClub getByAllClubs_PrevAndNext(Session session,
		ESPlayerClub esPlayerClub, long clubId, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESPLAYERCLUB_WHERE);

		query.append(_FINDER_COLUMN_ALLCLUBS_CLUBID_2);

		query.append(_FINDER_COLUMN_ALLCLUBS_ACTIVE_2);

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
			query.append(ESPlayerClubModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clubId);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esPlayerClub);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESPlayerClub> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s player clubs where playerId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @return the matching e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerClub> findByPlayerClubs(long playerId)
		throws SystemException {
		return findByPlayerClubs(playerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerClub> findByPlayerClubs(long playerId, int start,
		int end) throws SystemException {
		return findByPlayerClubs(playerId, start, end, null);
	}

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
	public List<ESPlayerClub> findByPlayerClubs(long playerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				playerId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerClub> list = (List<ESPlayerClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PLAYERCLUBS,
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

			query.append(_SQL_SELECT_ESPLAYERCLUB_WHERE);

			query.append(_FINDER_COLUMN_PLAYERCLUBS_PLAYERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESPlayerClubModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(playerId);

				list = (List<ESPlayerClub>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_PLAYERCLUBS,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PLAYERCLUBS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ESPlayerClub findByPlayerClubs_First(long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		List<ESPlayerClub> list = findByPlayerClubs(playerId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerClub findByPlayerClubs_Last(long playerId,
		OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		int count = countByPlayerClubs(playerId);

		List<ESPlayerClub> list = findByPlayerClubs(playerId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("playerId=");
			msg.append(playerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESPlayerClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ESPlayerClub[] findByPlayerClubs_PrevAndNext(long playerClubId,
		long playerId, OrderByComparator orderByComparator)
		throws NoSuchESPlayerClubException, SystemException {
		ESPlayerClub esPlayerClub = findByPrimaryKey(playerClubId);

		Session session = null;

		try {
			session = openSession();

			ESPlayerClub[] array = new ESPlayerClubImpl[3];

			array[0] = getByPlayerClubs_PrevAndNext(session, esPlayerClub,
					playerId, orderByComparator, true);

			array[1] = esPlayerClub;

			array[2] = getByPlayerClubs_PrevAndNext(session, esPlayerClub,
					playerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESPlayerClub getByPlayerClubs_PrevAndNext(Session session,
		ESPlayerClub esPlayerClub, long playerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESPLAYERCLUB_WHERE);

		query.append(_FINDER_COLUMN_PLAYERCLUBS_PLAYERID_2);

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
			query.append(ESPlayerClubModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(playerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esPlayerClub);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESPlayerClub> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s player clubs.
	 *
	 * @return the e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESPlayerClub> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<ESPlayerClub> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<ESPlayerClub> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESPlayerClub> list = (List<ESPlayerClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESPLAYERCLUB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESPLAYERCLUB.concat(ESPlayerClubModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ESPlayerClub>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ESPlayerClub>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the e s player clubs where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPlayerClubGroup(long groupId) throws SystemException {
		for (ESPlayerClub esPlayerClub : findByPlayerClubGroup(groupId)) {
			remove(esPlayerClub);
		}
	}

	/**
	 * Removes all the e s player clubs where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPlayerClubCompany(long companyId)
		throws SystemException {
		for (ESPlayerClub esPlayerClub : findByPlayerClubCompany(companyId)) {
			remove(esPlayerClub);
		}
	}

	/**
	 * Removes all the e s player clubs where clubId = &#63; and active = &#63; from the database.
	 *
	 * @param clubId the club id to search with
	 * @param active the active to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAllClubs(long clubId, boolean active)
		throws SystemException {
		for (ESPlayerClub esPlayerClub : findByAllClubs(clubId, active)) {
			remove(esPlayerClub);
		}
	}

	/**
	 * Removes all the e s player clubs where playerId = &#63; from the database.
	 *
	 * @param playerId the player id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPlayerClubs(long playerId) throws SystemException {
		for (ESPlayerClub esPlayerClub : findByPlayerClubs(playerId)) {
			remove(esPlayerClub);
		}
	}

	/**
	 * Removes all the e s player clubs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ESPlayerClub esPlayerClub : findAll()) {
			remove(esPlayerClub);
		}
	}

	/**
	 * Counts all the e s player clubs where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPlayerClubGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PLAYERCLUBGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESPLAYERCLUB_WHERE);

			query.append(_FINDER_COLUMN_PLAYERCLUBGROUP_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PLAYERCLUBGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s player clubs where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPlayerClubCompany(long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PLAYERCLUBCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESPLAYERCLUB_WHERE);

			query.append(_FINDER_COLUMN_PLAYERCLUBCOMPANY_COMPANYID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PLAYERCLUBCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s player clubs where clubId = &#63; and active = &#63;.
	 *
	 * @param clubId the club id to search with
	 * @param active the active to search with
	 * @return the number of matching e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAllClubs(long clubId, boolean active)
		throws SystemException {
		Object[] finderArgs = new Object[] { clubId, active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALLCLUBS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESPLAYERCLUB_WHERE);

			query.append(_FINDER_COLUMN_ALLCLUBS_CLUBID_2);

			query.append(_FINDER_COLUMN_ALLCLUBS_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clubId);

				qPos.add(active);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALLCLUBS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s player clubs where playerId = &#63;.
	 *
	 * @param playerId the player id to search with
	 * @return the number of matching e s player clubs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPlayerClubs(long playerId) throws SystemException {
		Object[] finderArgs = new Object[] { playerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PLAYERCLUBS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESPLAYERCLUB_WHERE);

			query.append(_FINDER_COLUMN_PLAYERCLUBS_PLAYERID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PLAYERCLUBS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s player clubs.
	 *
	 * @return the number of e s player clubs
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

				Query q = session.createQuery(_SQL_COUNT_ESPLAYERCLUB);

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
	 * Initializes the e s player club persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.eswinggolf.portal.data.layer.club.model.ESPlayerClub")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESPlayerClub>> listenersList = new ArrayList<ModelListener<ESPlayerClub>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESPlayerClub>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESPlayerClubImpl.class.getName());
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
	private static final String _SQL_SELECT_ESPLAYERCLUB = "SELECT esPlayerClub FROM ESPlayerClub esPlayerClub";
	private static final String _SQL_SELECT_ESPLAYERCLUB_WHERE = "SELECT esPlayerClub FROM ESPlayerClub esPlayerClub WHERE ";
	private static final String _SQL_COUNT_ESPLAYERCLUB = "SELECT COUNT(esPlayerClub) FROM ESPlayerClub esPlayerClub";
	private static final String _SQL_COUNT_ESPLAYERCLUB_WHERE = "SELECT COUNT(esPlayerClub) FROM ESPlayerClub esPlayerClub WHERE ";
	private static final String _FINDER_COLUMN_PLAYERCLUBGROUP_GROUPID_2 = "esPlayerClub.groupId = ?";
	private static final String _FINDER_COLUMN_PLAYERCLUBCOMPANY_COMPANYID_2 = "esPlayerClub.companyId = ?";
	private static final String _FINDER_COLUMN_ALLCLUBS_CLUBID_2 = "esPlayerClub.clubId = ? AND ";
	private static final String _FINDER_COLUMN_ALLCLUBS_ACTIVE_2 = "esPlayerClub.active = ?";
	private static final String _FINDER_COLUMN_PLAYERCLUBS_PLAYERID_2 = "esPlayerClub.playerId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esPlayerClub.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESPlayerClub exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESPlayerClub exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ESPlayerClubPersistenceImpl.class);
}