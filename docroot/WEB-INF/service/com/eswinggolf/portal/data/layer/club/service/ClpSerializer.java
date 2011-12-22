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

import com.eswinggolf.portal.data.layer.club.model.ESClubClp;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClubClp;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotDataClp;
import com.eswinggolf.portal.data.layer.club.model.ESShotDataSharingClp;
import com.eswinggolf.portal.data.layer.club.model.ESTrialShotDataClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "ClubProfile-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ESClubClp.class.getName())) {
			ESClubClp oldCplModel = (ESClubClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setClubId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getClubId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setClubName",
							new Class[] { String.class });

					String value4 = oldCplModel.getClubName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setClubDesc",
							new Class[] { String.class });

					String value5 = oldCplModel.getClubDesc();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setLoft",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getLoft());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setNomSr",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getNomSr());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setNomSpeed",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getNomSpeed());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setLaunchAngle",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getLaunchAngle());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setCoR",
							new Class[] { Double.TYPE });

					Double value10 = new Double(oldCplModel.getCoR());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setWeight",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getWeight());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setModel",
							new Class[] { String.class });

					String value12 = oldCplModel.getModel();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value13 = new Boolean(oldCplModel.getActive());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getCreateDate();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getModifiedDate();

					method15.invoke(newModel, value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ESPlayerClubClp.class.getName())) {
			ESPlayerClubClp oldCplModel = (ESPlayerClubClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerClubImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setPlayerClubId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getPlayerClubId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setClubId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getClubId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPlayerId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getPlayerId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getCompanyId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getGroupId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getUserId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setClubDesc",
							new Class[] { String.class });

					String value6 = oldCplModel.getClubDesc();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setLoft",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getLoft());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setNomSr",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getNomSr());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setNomSpeed",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getNomSpeed());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setCoR",
							new Class[] { Double.TYPE });

					Double value10 = new Double(oldCplModel.getCoR());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setWeight",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getWeight());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setModel",
							new Class[] { String.class });

					String value12 = oldCplModel.getModel();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value13 = new Boolean(oldCplModel.getActive());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getCreateDate();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getModifiedDate();

					method15.invoke(newModel, value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ESPlayerShotDataClp.class.getName())) {
			ESPlayerShotDataClp oldCplModel = (ESPlayerShotDataClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setShotDataId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getShotDataId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPlayerId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getPlayerId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPlayerClubId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getPlayerClubId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setProductSerialNo",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getProductSerialNo());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getCompanyId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getGroupId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setLaunchMonitor",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getLaunchMonitor());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setSimulate",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getSimulate());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getActive());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setClubLoft",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getClubLoft());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setClubSpeed",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getClubSpeed());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setFaceAngle",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getFaceAngle());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setSwingPath",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getSwingPath());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setSpinAxisAngle",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getSpinAxisAngle());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setLaunchAngle",
							new Class[] { Integer.TYPE });

					Integer value14 = new Integer(oldCplModel.getLaunchAngle());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setBallSpeed",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getBallSpeed());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setBallSpinRate",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getBallSpinRate());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setBallAngleOfAttack",
							new Class[] { Double.TYPE });

					Double value17 = new Double(oldCplModel.getBallAngleOfAttack());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setBallCompression",
							new Class[] { Double.TYPE });

					Double value18 = new Double(oldCplModel.getBallCompression());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setStepTimeIncrement",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getStepTimeIncrement());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setWindSpeed",
							new Class[] { Integer.TYPE });

					Integer value20 = new Integer(oldCplModel.getWindSpeed());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setWindDirection",
							new Class[] { Integer.TYPE });

					Integer value21 = new Integer(oldCplModel.getWindDirection());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setAmbientTemp",
							new Class[] { Integer.TYPE });

					Integer value22 = new Integer(oldCplModel.getAmbientTemp());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setBarPressureAlt",
							new Class[] { Integer.TYPE });

					Integer value23 = new Integer(oldCplModel.getBarPressureAlt());

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setRelativeHumid",
							new Class[] { Integer.TYPE });

					Integer value24 = new Integer(oldCplModel.getRelativeHumid());

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setFairwayFirmness",
							new Class[] { Double.TYPE });

					Double value25 = new Double(oldCplModel.getFairwayFirmness());

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value26 = oldCplModel.getCreateDate();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value27 = oldCplModel.getModifiedDate();

					method27.invoke(newModel, value27);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ESShotDataSharingClp.class.getName())) {
			ESShotDataSharingClp oldCplModel = (ESShotDataSharingClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.eswinggolf.portal.data.layer.club.model.impl.ESShotDataSharingImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setShotDataSharingId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getShotDataSharingId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setShotDataId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getShotDataId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPlayerId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getPlayerId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getCompanyId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getGroupId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getActive());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getCreateDate();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setModifyDate",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getModifyDate();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ESTrialShotDataClp.class.getName())) {
			ESTrialShotDataClp oldCplModel = (ESTrialShotDataClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.eswinggolf.portal.data.layer.club.model.impl.ESTrialShotDataImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setShotDataId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getShotDataId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPlayerId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getPlayerId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPlayerClubId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getPlayerClubId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setProductSerialNo",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getProductSerialNo());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getCompanyId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getGroupId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setLaunchMonitor",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getLaunchMonitor());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setSimulate",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getSimulate());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getActive());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setClubLoft",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getClubLoft());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setClubSpeed",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getClubSpeed());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setFaceAngle",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getFaceAngle());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setSwingPath",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getSwingPath());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setSpinAxisAngle",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getSpinAxisAngle());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setLaunchAngle",
							new Class[] { Integer.TYPE });

					Integer value14 = new Integer(oldCplModel.getLaunchAngle());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setBallSpeed",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getBallSpeed());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setBallSpinRate",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getBallSpinRate());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setBallAngleOfAttack",
							new Class[] { Double.TYPE });

					Double value17 = new Double(oldCplModel.getBallAngleOfAttack());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setBallCompression",
							new Class[] { Double.TYPE });

					Double value18 = new Double(oldCplModel.getBallCompression());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setStepTimeIncrement",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getStepTimeIncrement());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setWindSpeed",
							new Class[] { Integer.TYPE });

					Integer value20 = new Integer(oldCplModel.getWindSpeed());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setWindDirection",
							new Class[] { Integer.TYPE });

					Integer value21 = new Integer(oldCplModel.getWindDirection());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setAmbientTemp",
							new Class[] { Integer.TYPE });

					Integer value22 = new Integer(oldCplModel.getAmbientTemp());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setBarPressureAlt",
							new Class[] { Integer.TYPE });

					Integer value23 = new Integer(oldCplModel.getBarPressureAlt());

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setRelativeHumid",
							new Class[] { Integer.TYPE });

					Integer value24 = new Integer(oldCplModel.getRelativeHumid());

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setFairwayFirmness",
							new Class[] { Double.TYPE });

					Double value25 = new Double(oldCplModel.getFairwayFirmness());

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value26 = oldCplModel.getCreateDate();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value27 = oldCplModel.getModifiedDate();

					method27.invoke(newModel, value27);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ESClubClp newModel = new ESClubClp();

					Method method0 = oldModelClass.getMethod("getClubId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setClubId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2);

					Method method3 = oldModelClass.getMethod("getUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setUserId(value3);

					Method method4 = oldModelClass.getMethod("getClubName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setClubName(value4);

					Method method5 = oldModelClass.getMethod("getClubDesc");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setClubDesc(value5);

					Method method6 = oldModelClass.getMethod("getLoft");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setLoft(value6);

					Method method7 = oldModelClass.getMethod("getNomSr");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setNomSr(value7);

					Method method8 = oldModelClass.getMethod("getNomSpeed");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setNomSpeed(value8);

					Method method9 = oldModelClass.getMethod("getLaunchAngle");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setLaunchAngle(value9);

					Method method10 = oldModelClass.getMethod("getCoR");

					Double value10 = (Double)method10.invoke(oldModel,
							(Object[])null);

					newModel.setCoR(value10);

					Method method11 = oldModelClass.getMethod("getWeight");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setWeight(value11);

					Method method12 = oldModelClass.getMethod("getModel");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setModel(value12);

					Method method13 = oldModelClass.getMethod("getActive");

					Boolean value13 = (Boolean)method13.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value13);

					Method method14 = oldModelClass.getMethod("getCreateDate");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setCreateDate(value14);

					Method method15 = oldModelClass.getMethod("getModifiedDate");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setModifiedDate(value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerClubImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ESPlayerClubClp newModel = new ESPlayerClubClp();

					Method method0 = oldModelClass.getMethod("getPlayerClubId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setPlayerClubId(value0);

					Method method1 = oldModelClass.getMethod("getClubId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setClubId(value1);

					Method method2 = oldModelClass.getMethod("getPlayerId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setPlayerId(value2);

					Method method3 = oldModelClass.getMethod("getCompanyId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value3);

					Method method4 = oldModelClass.getMethod("getGroupId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value4);

					Method method5 = oldModelClass.getMethod("getUserId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setUserId(value5);

					Method method6 = oldModelClass.getMethod("getClubDesc");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setClubDesc(value6);

					Method method7 = oldModelClass.getMethod("getLoft");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setLoft(value7);

					Method method8 = oldModelClass.getMethod("getNomSr");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setNomSr(value8);

					Method method9 = oldModelClass.getMethod("getNomSpeed");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setNomSpeed(value9);

					Method method10 = oldModelClass.getMethod("getCoR");

					Double value10 = (Double)method10.invoke(oldModel,
							(Object[])null);

					newModel.setCoR(value10);

					Method method11 = oldModelClass.getMethod("getWeight");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setWeight(value11);

					Method method12 = oldModelClass.getMethod("getModel");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setModel(value12);

					Method method13 = oldModelClass.getMethod("getActive");

					Boolean value13 = (Boolean)method13.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value13);

					Method method14 = oldModelClass.getMethod("getCreateDate");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setCreateDate(value14);

					Method method15 = oldModelClass.getMethod("getModifiedDate");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setModifiedDate(value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ESPlayerShotDataClp newModel = new ESPlayerShotDataClp();

					Method method0 = oldModelClass.getMethod("getShotDataId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setShotDataId(value0);

					Method method1 = oldModelClass.getMethod("getPlayerId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setPlayerId(value1);

					Method method2 = oldModelClass.getMethod("getPlayerClubId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setPlayerClubId(value2);

					Method method3 = oldModelClass.getMethod(
							"getProductSerialNo");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setProductSerialNo(value3);

					Method method4 = oldModelClass.getMethod("getCompanyId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value4);

					Method method5 = oldModelClass.getMethod("getGroupId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value5);

					Method method6 = oldModelClass.getMethod("getLaunchMonitor");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setLaunchMonitor(value6);

					Method method7 = oldModelClass.getMethod("getSimulate");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setSimulate(value7);

					Method method8 = oldModelClass.getMethod("getActive");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value8);

					Method method9 = oldModelClass.getMethod("getClubLoft");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setClubLoft(value9);

					Method method10 = oldModelClass.getMethod("getClubSpeed");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setClubSpeed(value10);

					Method method11 = oldModelClass.getMethod("getFaceAngle");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setFaceAngle(value11);

					Method method12 = oldModelClass.getMethod("getSwingPath");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setSwingPath(value12);

					Method method13 = oldModelClass.getMethod(
							"getSpinAxisAngle");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setSpinAxisAngle(value13);

					Method method14 = oldModelClass.getMethod("getLaunchAngle");

					Integer value14 = (Integer)method14.invoke(oldModel,
							(Object[])null);

					newModel.setLaunchAngle(value14);

					Method method15 = oldModelClass.getMethod("getBallSpeed");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setBallSpeed(value15);

					Method method16 = oldModelClass.getMethod("getBallSpinRate");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setBallSpinRate(value16);

					Method method17 = oldModelClass.getMethod(
							"getBallAngleOfAttack");

					Double value17 = (Double)method17.invoke(oldModel,
							(Object[])null);

					newModel.setBallAngleOfAttack(value17);

					Method method18 = oldModelClass.getMethod(
							"getBallCompression");

					Double value18 = (Double)method18.invoke(oldModel,
							(Object[])null);

					newModel.setBallCompression(value18);

					Method method19 = oldModelClass.getMethod(
							"getStepTimeIncrement");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setStepTimeIncrement(value19);

					Method method20 = oldModelClass.getMethod("getWindSpeed");

					Integer value20 = (Integer)method20.invoke(oldModel,
							(Object[])null);

					newModel.setWindSpeed(value20);

					Method method21 = oldModelClass.getMethod(
							"getWindDirection");

					Integer value21 = (Integer)method21.invoke(oldModel,
							(Object[])null);

					newModel.setWindDirection(value21);

					Method method22 = oldModelClass.getMethod("getAmbientTemp");

					Integer value22 = (Integer)method22.invoke(oldModel,
							(Object[])null);

					newModel.setAmbientTemp(value22);

					Method method23 = oldModelClass.getMethod(
							"getBarPressureAlt");

					Integer value23 = (Integer)method23.invoke(oldModel,
							(Object[])null);

					newModel.setBarPressureAlt(value23);

					Method method24 = oldModelClass.getMethod(
							"getRelativeHumid");

					Integer value24 = (Integer)method24.invoke(oldModel,
							(Object[])null);

					newModel.setRelativeHumid(value24);

					Method method25 = oldModelClass.getMethod(
							"getFairwayFirmness");

					Double value25 = (Double)method25.invoke(oldModel,
							(Object[])null);

					newModel.setFairwayFirmness(value25);

					Method method26 = oldModelClass.getMethod("getCreateDate");

					Date value26 = (Date)method26.invoke(oldModel,
							(Object[])null);

					newModel.setCreateDate(value26);

					Method method27 = oldModelClass.getMethod("getModifiedDate");

					Date value27 = (Date)method27.invoke(oldModel,
							(Object[])null);

					newModel.setModifiedDate(value27);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.eswinggolf.portal.data.layer.club.model.impl.ESShotDataSharingImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ESShotDataSharingClp newModel = new ESShotDataSharingClp();

					Method method0 = oldModelClass.getMethod(
							"getShotDataSharingId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setShotDataSharingId(value0);

					Method method1 = oldModelClass.getMethod("getShotDataId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setShotDataId(value1);

					Method method2 = oldModelClass.getMethod("getPlayerId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setPlayerId(value2);

					Method method3 = oldModelClass.getMethod("getUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setUserId(value3);

					Method method4 = oldModelClass.getMethod("getCompanyId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value4);

					Method method5 = oldModelClass.getMethod("getGroupId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value5);

					Method method6 = oldModelClass.getMethod("getActive");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value6);

					Method method7 = oldModelClass.getMethod("getCreateDate");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value7);

					Method method8 = oldModelClass.getMethod("getModifyDate");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setModifyDate(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.eswinggolf.portal.data.layer.club.model.impl.ESTrialShotDataImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ESTrialShotDataClp newModel = new ESTrialShotDataClp();

					Method method0 = oldModelClass.getMethod("getShotDataId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setShotDataId(value0);

					Method method1 = oldModelClass.getMethod("getPlayerId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setPlayerId(value1);

					Method method2 = oldModelClass.getMethod("getPlayerClubId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setPlayerClubId(value2);

					Method method3 = oldModelClass.getMethod(
							"getProductSerialNo");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setProductSerialNo(value3);

					Method method4 = oldModelClass.getMethod("getCompanyId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value4);

					Method method5 = oldModelClass.getMethod("getGroupId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value5);

					Method method6 = oldModelClass.getMethod("getLaunchMonitor");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setLaunchMonitor(value6);

					Method method7 = oldModelClass.getMethod("getSimulate");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setSimulate(value7);

					Method method8 = oldModelClass.getMethod("getActive");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value8);

					Method method9 = oldModelClass.getMethod("getClubLoft");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setClubLoft(value9);

					Method method10 = oldModelClass.getMethod("getClubSpeed");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setClubSpeed(value10);

					Method method11 = oldModelClass.getMethod("getFaceAngle");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setFaceAngle(value11);

					Method method12 = oldModelClass.getMethod("getSwingPath");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setSwingPath(value12);

					Method method13 = oldModelClass.getMethod(
							"getSpinAxisAngle");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setSpinAxisAngle(value13);

					Method method14 = oldModelClass.getMethod("getLaunchAngle");

					Integer value14 = (Integer)method14.invoke(oldModel,
							(Object[])null);

					newModel.setLaunchAngle(value14);

					Method method15 = oldModelClass.getMethod("getBallSpeed");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setBallSpeed(value15);

					Method method16 = oldModelClass.getMethod("getBallSpinRate");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setBallSpinRate(value16);

					Method method17 = oldModelClass.getMethod(
							"getBallAngleOfAttack");

					Double value17 = (Double)method17.invoke(oldModel,
							(Object[])null);

					newModel.setBallAngleOfAttack(value17);

					Method method18 = oldModelClass.getMethod(
							"getBallCompression");

					Double value18 = (Double)method18.invoke(oldModel,
							(Object[])null);

					newModel.setBallCompression(value18);

					Method method19 = oldModelClass.getMethod(
							"getStepTimeIncrement");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setStepTimeIncrement(value19);

					Method method20 = oldModelClass.getMethod("getWindSpeed");

					Integer value20 = (Integer)method20.invoke(oldModel,
							(Object[])null);

					newModel.setWindSpeed(value20);

					Method method21 = oldModelClass.getMethod(
							"getWindDirection");

					Integer value21 = (Integer)method21.invoke(oldModel,
							(Object[])null);

					newModel.setWindDirection(value21);

					Method method22 = oldModelClass.getMethod("getAmbientTemp");

					Integer value22 = (Integer)method22.invoke(oldModel,
							(Object[])null);

					newModel.setAmbientTemp(value22);

					Method method23 = oldModelClass.getMethod(
							"getBarPressureAlt");

					Integer value23 = (Integer)method23.invoke(oldModel,
							(Object[])null);

					newModel.setBarPressureAlt(value23);

					Method method24 = oldModelClass.getMethod(
							"getRelativeHumid");

					Integer value24 = (Integer)method24.invoke(oldModel,
							(Object[])null);

					newModel.setRelativeHumid(value24);

					Method method25 = oldModelClass.getMethod(
							"getFairwayFirmness");

					Double value25 = (Double)method25.invoke(oldModel,
							(Object[])null);

					newModel.setFairwayFirmness(value25);

					Method method26 = oldModelClass.getMethod("getCreateDate");

					Date value26 = (Date)method26.invoke(oldModel,
							(Object[])null);

					newModel.setCreateDate(value26);

					Method method27 = oldModelClass.getMethod("getModifiedDate");

					Date value27 = (Date)method27.invoke(oldModel,
							(Object[])null);

					newModel.setModifiedDate(value27);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}