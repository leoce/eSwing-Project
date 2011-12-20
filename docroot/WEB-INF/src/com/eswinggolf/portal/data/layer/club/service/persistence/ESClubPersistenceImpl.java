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

import com.eswinggolf.portal.data.layer.club.NoSuchESClubException;
import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl;
import com.eswinggolf.portal.data.layer.club.model.impl.ESClubModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s club service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ESClubUtil} to access the e s club persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author evangelistalc
 * @see ESClubPersistence
 * @see ESClubUtil
 * @generated
 */
public class ESClubPersistenceImpl extends BasePersistenceImpl<ESClub>
	implements ESClubPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ESClubImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_CLUBNAME = new FinderPath(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByClubName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CLUBNAME = new FinderPath(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByClubName",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the e s club in the entity cache if it is enabled.
	 *
	 * @param esClub the e s club to cache
	 */
	public void cacheResult(ESClub esClub) {
		EntityCacheUtil.putResult(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubImpl.class, esClub.getPrimaryKey(), esClub);
	}

	/**
	 * Caches the e s clubs in the entity cache if it is enabled.
	 *
	 * @param esClubs the e s clubs to cache
	 */
	public void cacheResult(List<ESClub> esClubs) {
		for (ESClub esClub : esClubs) {
			if (EntityCacheUtil.getResult(
						ESClubModelImpl.ENTITY_CACHE_ENABLED, ESClubImpl.class,
						esClub.getPrimaryKey(), this) == null) {
				cacheResult(esClub);
			}
		}
	}

	/**
	 * Clears the cache for all e s clubs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ESClubImpl.class.getName());
		EntityCacheUtil.clearCache(ESClubImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the e s club.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ESClub esClub) {
		EntityCacheUtil.removeResult(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubImpl.class, esClub.getPrimaryKey());
	}

	/**
	 * Creates a new e s club with the primary key. Does not add the e s club to the database.
	 *
	 * @param clubId the primary key for the new e s club
	 * @return the new e s club
	 */
	public ESClub create(long clubId) {
		ESClub esClub = new ESClubImpl();

		esClub.setNew(true);
		esClub.setPrimaryKey(clubId);

		return esClub;
	}

	/**
	 * Removes the e s club with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s club to remove
	 * @return the e s club that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the e s club with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clubId the primary key of the e s club to remove
	 * @return the e s club that was removed
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub remove(long clubId)
		throws NoSuchESClubException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESClub esClub = (ESClub)session.get(ESClubImpl.class,
					new Long(clubId));

			if (esClub == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + clubId);
				}

				throw new NoSuchESClubException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					clubId);
			}

			return remove(esClub);
		}
		catch (NoSuchESClubException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESClub removeImpl(ESClub esClub) throws SystemException {
		esClub = toUnwrappedModel(esClub);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, esClub);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubImpl.class, esClub.getPrimaryKey());

		return esClub;
	}

	public ESClub updateImpl(
		com.eswinggolf.portal.data.layer.club.model.ESClub esClub, boolean merge)
		throws SystemException {
		esClub = toUnwrappedModel(esClub);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, esClub, merge);

			esClub.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ESClubModelImpl.ENTITY_CACHE_ENABLED,
			ESClubImpl.class, esClub.getPrimaryKey(), esClub);

		return esClub;
	}

	protected ESClub toUnwrappedModel(ESClub esClub) {
		if (esClub instanceof ESClubImpl) {
			return esClub;
		}

		ESClubImpl esClubImpl = new ESClubImpl();

		esClubImpl.setNew(esClub.isNew());
		esClubImpl.setPrimaryKey(esClub.getPrimaryKey());

		esClubImpl.setClubId(esClub.getClubId());
		esClubImpl.setCompanyId(esClub.getCompanyId());
		esClubImpl.setGroupId(esClub.getGroupId());
		esClubImpl.setUserId(esClub.getUserId());
		esClubImpl.setClubName(esClub.getClubName());
		esClubImpl.setClubDesc(esClub.getClubDesc());
		esClubImpl.setLoft(esClub.getLoft());
		esClubImpl.setNomSr(esClub.getNomSr());
		esClubImpl.setNomSpeed(esClub.getNomSpeed());
		esClubImpl.setLaunchAngle(esClub.getLaunchAngle());
		esClubImpl.setCoR(esClub.getCoR());
		esClubImpl.setWeight(esClub.getWeight());
		esClubImpl.setModel(esClub.getModel());
		esClubImpl.setActive(esClub.isActive());
		esClubImpl.setCreateDate(esClub.getCreateDate());
		esClubImpl.setModifiedDate(esClub.getModifiedDate());

		return esClubImpl;
	}

	/**
	 * Finds the e s club with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s club to find
	 * @return the e s club
	 * @throws com.liferay.portal.NoSuchModelException if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s club with the primary key or throws a {@link com.eswinggolf.portal.data.layer.club.NoSuchESClubException} if it could not be found.
	 *
	 * @param clubId the primary key of the e s club to find
	 * @return the e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub findByPrimaryKey(long clubId)
		throws NoSuchESClubException, SystemException {
		ESClub esClub = fetchByPrimaryKey(clubId);

		if (esClub == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + clubId);
			}

			throw new NoSuchESClubException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				clubId);
		}

		return esClub;
	}

	/**
	 * Finds the e s club with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s club to find
	 * @return the e s club, or <code>null</code> if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the e s club with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clubId the primary key of the e s club to find
	 * @return the e s club, or <code>null</code> if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub fetchByPrimaryKey(long clubId) throws SystemException {
		ESClub esClub = (ESClub)EntityCacheUtil.getResult(ESClubModelImpl.ENTITY_CACHE_ENABLED,
				ESClubImpl.class, clubId, this);

		if (esClub == null) {
			Session session = null;

			try {
				session = openSession();

				esClub = (ESClub)session.get(ESClubImpl.class, new Long(clubId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (esClub != null) {
					cacheResult(esClub);
				}

				closeSession(session);
			}
		}

		return esClub;
	}

	/**
	 * Finds all the e s clubs where groupId = &#63; and clubName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @return the matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByClubName(long groupId, String clubName)
		throws SystemException {
		return findByClubName(groupId, clubName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the e s clubs where groupId = &#63; and clubName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @return the range of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByClubName(long groupId, String clubName,
		int start, int end) throws SystemException {
		return findByClubName(groupId, clubName, start, end, null);
	}

	/**
	 * Finds an ordered range of all the e s clubs where groupId = &#63; and clubName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByClubName(long groupId, String clubName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, clubName,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESClub> list = (List<ESClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CLUBNAME,
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

			query.append(_SQL_SELECT_ESCLUB_WHERE);

			query.append(_FINDER_COLUMN_CLUBNAME_GROUPID_2);

			if (clubName == null) {
				query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_1);
			}
			else {
				if (clubName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESClubModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (clubName != null) {
					qPos.add(clubName);
				}

				list = (List<ESClub>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_CLUBNAME,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CLUBNAME,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first e s club in the ordered set where groupId = &#63; and clubName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub findByClubName_First(long groupId, String clubName,
		OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		List<ESClub> list = findByClubName(groupId, clubName, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", clubName=");
			msg.append(clubName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last e s club in the ordered set where groupId = &#63; and clubName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub findByClubName_Last(long groupId, String clubName,
		OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		int count = countByClubName(groupId, clubName);

		List<ESClub> list = findByClubName(groupId, clubName, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", clubName=");
			msg.append(clubName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the e s clubs before and after the current e s club in the ordered set where groupId = &#63; and clubName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param clubId the primary key of the current e s club
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub[] findByClubName_PrevAndNext(long clubId, long groupId,
		String clubName, OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		ESClub esClub = findByPrimaryKey(clubId);

		Session session = null;

		try {
			session = openSession();

			ESClub[] array = new ESClubImpl[3];

			array[0] = getByClubName_PrevAndNext(session, esClub, groupId,
					clubName, orderByComparator, true);

			array[1] = esClub;

			array[2] = getByClubName_PrevAndNext(session, esClub, groupId,
					clubName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESClub getByClubName_PrevAndNext(Session session, ESClub esClub,
		long groupId, String clubName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESCLUB_WHERE);

		query.append(_FINDER_COLUMN_CLUBNAME_GROUPID_2);

		if (clubName == null) {
			query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_1);
		}
		else {
			if (clubName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_2);
			}
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
			query.append(ESClubModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (clubName != null) {
			qPos.add(clubName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esClub);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESClub> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the e s clubs where groupId = &#63; and clubName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @return the matching e s clubs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> filterFindByClubName(long groupId, String clubName)
		throws SystemException {
		return filterFindByClubName(groupId, clubName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the e s clubs where groupId = &#63; and clubName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @return the range of matching e s clubs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> filterFindByClubName(long groupId, String clubName,
		int start, int end) throws SystemException {
		return filterFindByClubName(groupId, clubName, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the e s clubs where groupId = &#63; and clubName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching e s clubs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> filterFindByClubName(long groupId, String clubName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByClubName(groupId, clubName, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESCLUB_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESCLUB_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CLUBNAME_GROUPID_2);

		if (clubName == null) {
			query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_1);
		}
		else {
			if (clubName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESCLUB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ESClubModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESClubModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESClub.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESClubImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESClubImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (clubName != null) {
				qPos.add(clubName);
			}

			return (List<ESClub>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the e s clubs where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the e s clubs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @return the range of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the e s clubs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESClub> list = (List<ESClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
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

			query.append(_SQL_SELECT_ESCLUB_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESClubModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ESClub>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first e s club in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		List<ESClub> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last e s club in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		int count = countByGroupId(groupId);

		List<ESClub> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the e s clubs before and after the current e s club in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param clubId the primary key of the current e s club
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub[] findByGroupId_PrevAndNext(long clubId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		ESClub esClub = findByPrimaryKey(clubId);

		Session session = null;

		try {
			session = openSession();

			ESClub[] array = new ESClubImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esClub, groupId,
					orderByComparator, true);

			array[1] = esClub;

			array[2] = getByGroupId_PrevAndNext(session, esClub, groupId,
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

	protected ESClub getByGroupId_PrevAndNext(Session session, ESClub esClub,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESCLUB_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ESClubModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esClub);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESClub> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the e s clubs where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching e s clubs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the e s clubs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @return the range of matching e s clubs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the e s clubs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching e s clubs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESCLUB_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESCLUB_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESCLUB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ESClubModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESClubModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESClub.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESClubImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESClubImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ESClub>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the e s clubs where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the e s clubs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @return the range of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the e s clubs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESClub> list = (List<ESClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
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

			query.append(_SQL_SELECT_ESCLUB_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ESClubModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<ESClub>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first e s club in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		List<ESClub> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last e s club in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a matching e s club could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		int count = countByCompanyId(companyId);

		List<ESClub> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchESClubException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the e s clubs before and after the current e s club in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param clubId the primary key of the current e s club
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next e s club
	 * @throws com.eswinggolf.portal.data.layer.club.NoSuchESClubException if a e s club with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ESClub[] findByCompanyId_PrevAndNext(long clubId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchESClubException, SystemException {
		ESClub esClub = findByPrimaryKey(clubId);

		Session session = null;

		try {
			session = openSession();

			ESClub[] array = new ESClubImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, esClub, companyId,
					orderByComparator, true);

			array[1] = esClub;

			array[2] = getByCompanyId_PrevAndNext(session, esClub, companyId,
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

	protected ESClub getByCompanyId_PrevAndNext(Session session, ESClub esClub,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESCLUB_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(ESClubModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(esClub);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESClub> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the e s clubs.
	 *
	 * @return the e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the e s clubs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @return the range of e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the e s clubs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s clubs to return
	 * @param end the upper bound of the range of e s clubs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ESClub> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ESClub> list = (List<ESClub>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESCLUB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESCLUB.concat(ESClubModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ESClub>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ESClub>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the e s clubs where groupId = &#63; and clubName = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByClubName(long groupId, String clubName)
		throws SystemException {
		for (ESClub esClub : findByClubName(groupId, clubName)) {
			remove(esClub);
		}
	}

	/**
	 * Removes all the e s clubs where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESClub esClub : findByGroupId(groupId)) {
			remove(esClub);
		}
	}

	/**
	 * Removes all the e s clubs where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (ESClub esClub : findByCompanyId(companyId)) {
			remove(esClub);
		}
	}

	/**
	 * Removes all the e s clubs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ESClub esClub : findAll()) {
			remove(esClub);
		}
	}

	/**
	 * Counts all the e s clubs where groupId = &#63; and clubName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @return the number of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByClubName(long groupId, String clubName)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, clubName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CLUBNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESCLUB_WHERE);

			query.append(_FINDER_COLUMN_CLUBNAME_GROUPID_2);

			if (clubName == null) {
				query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_1);
			}
			else {
				if (clubName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (clubName != null) {
					qPos.add(clubName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLUBNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the e s clubs where groupId = &#63; and clubName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param clubName the club name to search with
	 * @return the number of matching e s clubs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByClubName(long groupId, String clubName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByClubName(groupId, clubName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_ESCLUB_WHERE);

		query.append(_FINDER_COLUMN_CLUBNAME_GROUPID_2);

		if (clubName == null) {
			query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_1);
		}
		else {
			if (clubName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_CLUBNAME_CLUBNAME_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESClub.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (clubName != null) {
				qPos.add(clubName);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the e s clubs where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESCLUB_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the e s clubs where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching e s clubs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ESCLUB_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESClub.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the e s clubs where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching e s clubs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESCLUB_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the e s clubs.
	 *
	 * @return the number of e s clubs
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

				Query q = session.createQuery(_SQL_COUNT_ESCLUB);

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
	 * Initializes the e s club persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.eswinggolf.portal.data.layer.club.model.ESClub")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESClub>> listenersList = new ArrayList<ModelListener<ESClub>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESClub>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESClubImpl.class.getName());
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
	private static final String _SQL_SELECT_ESCLUB = "SELECT esClub FROM ESClub esClub";
	private static final String _SQL_SELECT_ESCLUB_WHERE = "SELECT esClub FROM ESClub esClub WHERE ";
	private static final String _SQL_COUNT_ESCLUB = "SELECT COUNT(esClub) FROM ESClub esClub";
	private static final String _SQL_COUNT_ESCLUB_WHERE = "SELECT COUNT(esClub) FROM ESClub esClub WHERE ";
	private static final String _FINDER_COLUMN_CLUBNAME_GROUPID_2 = "esClub.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CLUBNAME_CLUBNAME_1 = "esClub.clubName IS NULL";
	private static final String _FINDER_COLUMN_CLUBNAME_CLUBNAME_2 = "esClub.clubName = ?";
	private static final String _FINDER_COLUMN_CLUBNAME_CLUBNAME_3 = "(esClub.clubName IS NULL OR esClub.clubName = ?)";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esClub.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "esClub.companyId = ?";
	private static final String _FILTER_SQL_SELECT_ESCLUB_WHERE = "SELECT DISTINCT {esClub.*} FROM es_ESClub esClub WHERE ";
	private static final String _FILTER_SQL_SELECT_ESCLUB_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {es_ESClub.*} FROM (SELECT DISTINCT esClub.clubId FROM es_ESClub esClub WHERE ";
	private static final String _FILTER_SQL_SELECT_ESCLUB_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN es_ESClub ON TEMP_TABLE.clubId = es_ESClub.clubId";
	private static final String _FILTER_SQL_COUNT_ESCLUB_WHERE = "SELECT COUNT(DISTINCT esClub.clubId) AS COUNT_VALUE FROM es_ESClub esClub WHERE ";
	private static final String _FILTER_COLUMN_PK = "esClub.clubId";
	private static final String _FILTER_COLUMN_USERID = "esClub.userId";
	private static final String _FILTER_ENTITY_ALIAS = "esClub";
	private static final String _FILTER_ENTITY_TABLE = "es_ESClub";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esClub.";
	private static final String _ORDER_BY_ENTITY_TABLE = "es_ESClub.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESClub exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESClub exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ESClubPersistenceImpl.class);
}