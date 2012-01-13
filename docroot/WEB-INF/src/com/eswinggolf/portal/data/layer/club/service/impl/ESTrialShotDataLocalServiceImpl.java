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

package com.eswinggolf.portal.data.layer.club.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.eswinggolf.club.profile.portlet.ActionUtil;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
import com.eswinggolf.portal.data.layer.club.model.ESTrialShotData;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.base.ESTrialShotDataLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the e s trial shot data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalServiceUtil} to access the e s trial shot data local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author evangelistalc
 * @see com.eswinggolf.portal.data.layer.club.service.base.ESTrialShotDataLocalServiceBaseImpl
 * @see com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalServiceUtil
 */
public class ESTrialShotDataLocalServiceImpl
	extends ESTrialShotDataLocalServiceBaseImpl {
	
	/**
     * Gets all Player shot data out of the database.
     *
     * @return
     * @throws SystemException
     */
    public List<ESTrialShotData> getAllPlayerShotData(long playerId)
        throws SystemException {

        List<ESTrialShotData> trialShot =
            esTrialShotDataPersistence.findByG_TrialShotData(playerId);
        return trialShot;
    }
    
    /**
     * Gets all Player shot data out of the database.
     *
     * @return
     * @throws SystemException
     */
    public List<ESTrialShotData> getAllClubShotByPlayer(long playerId, long clubId)
        throws SystemException {

        List<ESTrialShotData> trialShot =
            esTrialShotDataPersistence.findByG_ClubTrialShotData(playerId, clubId);
        return trialShot;
    }
    
    
    
    /**
     * Gets all Player shot data by date out of the database.
     *
     * @return
     * @throws SystemException
     */
    public List<ESTrialShotData> getClubShotDataByDate(long playerId, Date begin, Date end)
        throws SystemException {

        List<ESTrialShotData> trialShot =
            esTrialShotDataPersistence.findByG_TrialShotDataByDate(playerId, begin);
            
        return trialShot;
    }
    
    public void deleteTrialShotData(long playerId)
    throws SystemException {


	List<ESTrialShotData> list = ESTrialShotDataLocalServiceUtil.getAllPlayerShotData(playerId);
    
	Iterator<ESTrialShotData> iter = list.iterator();
	
	while (iter.hasNext()){
		
		ESTrialShotData trialShot = (ESTrialShotData) iter.next();		
		
		ESTrialShotDataLocalServiceUtil.deleteESTrialShotData(trialShot);	
		
		}

    }
    
    public void transferTrialDataToShotData(long playerId)
    throws SystemException {


	List<ESTrialShotData> list = ESTrialShotDataLocalServiceUtil.getAllPlayerShotData(playerId);
    
	Iterator<ESTrialShotData> iter = list.iterator();
	
	while (iter.hasNext()){
		
		ESPlayerShotData shotData = ActionUtil.convertShotData((ESTrialShotData) iter.next());		
		
		ESPlayerShotDataLocalServiceUtil.addESPlayerShotData(shotData);
		
		}

    }
}