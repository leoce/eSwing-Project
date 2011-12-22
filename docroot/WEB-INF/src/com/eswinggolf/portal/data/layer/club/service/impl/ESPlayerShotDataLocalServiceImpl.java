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
import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
import com.eswinggolf.portal.data.layer.club.model.ESTrialShotData;
import com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataImpl;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.base.ESPlayerShotDataLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the e s player shot data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil} to access the e s player shot data local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author evangelistalc
 * @see com.eswinggolf.portal.data.layer.club.service.base.ESPlayerShotDataLocalServiceBaseImpl
 * @see com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil
 */
public class ESPlayerShotDataLocalServiceImpl
	extends ESPlayerShotDataLocalServiceBaseImpl {
	
	/**
     * Adds a newly created registration to the database.
     *
     * @param shot
     * @return
     * @throws SystemException
     */

    public void addESPlayerShotData(long playerId)
        throws SystemException {


    	List<ESTrialShotData> list = ESTrialShotDataLocalServiceUtil.getAllPlayerShotData(playerId);
        
    	Iterator<ESTrialShotData> iter = list.iterator();
    	
    	while (iter.hasNext()){
    		
    		ESTrialShotData trialShot = (ESTrialShotData) iter.next();
    		
    		ESPlayerShotData playerShot =
                esPlayerShotDataPersistence.create(
                    counterLocalService.increment(ESPlayerShotData.class.getName()));
    		
    			playerShot.setActive(trialShot.getActive());
    			playerShot.setAmbientTemp(trialShot.getAmbientTemp());
    			playerShot.setBallAngleOfAttack(trialShot.getBallAngleOfAttack());
    			playerShot.setBallCompression(trialShot.getBallCompression());
    			playerShot.setBallSpeed(trialShot.getBallSpeed());
    			playerShot.setBallSpinRate(trialShot.getBallSpinRate());
    			playerShot.setBarPressureAlt(trialShot.getBarPressureAlt());
    			playerShot.setClubLoft(trialShot.getClubLoft());
    			playerShot.setClubSpeed(trialShot.getClubSpeed());
    			playerShot.setCompanyId(trialShot.getCompanyId());
    			playerShot.setCreateDate(trialShot.getCreateDate());
    			playerShot.setFaceAngle(trialShot.getFaceAngle());
    			playerShot.setFairwayFirmness(trialShot.getFairwayFirmness());
    			playerShot.setGroupId(trialShot.getGroupId());
    			playerShot.setLaunchAngle(trialShot.getLaunchAngle());
    			playerShot.setLaunchMonitor(trialShot.getLaunchMonitor());
    			playerShot.setModifiedDate(trialShot.getModifiedDate());
    			playerShot.setPlayerClubId(trialShot.getPlayerClubId());
    			playerShot.setPlayerId(trialShot.getPlayerId());
    			playerShot.setProductSerialNo(trialShot.getProductSerialNo());
    			playerShot.setRelativeHumid(trialShot.getRelativeHumid());
    			playerShot.setSpinAxisAngle(trialShot.getSpinAxisAngle());
    			playerShot.setSwingPath(trialShot.getSwingPath());
    			playerShot.setWindDirection(trialShot.getWindDirection());
    			playerShot.setWindSpeed(trialShot.getWindSpeed());
    			
    			esPlayerShotDataPersistence.update(playerShot, false);
    			
    		
    	}
 
    }

    public void deleteESTrialShotData(long playerId)
    throws SystemException {


	List<ESTrialShotData> list = ESTrialShotDataLocalServiceUtil.getAllPlayerShotData(playerId);
    
	Iterator<ESTrialShotData> iter = list.iterator();
	
	while (iter.hasNext()){
		
		ESTrialShotData trialShot = (ESTrialShotData) iter.next();		
		
		ESTrialShotDataLocalServiceUtil.deleteESTrialShotData(trialShot);	
		
		}

    }

    /**
     * Gets all Player shot data out of the database.
     *
     * @return
     * @throws SystemException
     */
    public List<ESPlayerShotData> getAllPlayerShotData(long playerId)
        throws SystemException {

        List<ESPlayerShotData> shotData =
            esPlayerShotDataPersistence.findByG_PlayerShotData(playerId);
        return shotData;
    }
    
    /**
     * Gets all Player shot data out of the database.
     *
     * @return
     * @throws SystemException
     */
    public List<ESPlayerShotData> getAllClubShotByPlayer(long playerId, long clubId)
        throws SystemException {

        List<ESPlayerShotData> shotData =
            esPlayerShotDataPersistence.findByG_ClubShotData(playerId, clubId);
        return shotData;
    }
    
    
    
    /**
     * Gets all Player shot data by date out of the database.
     *
     * @return
     * @throws SystemException
     */
    public List<ESPlayerShotData> getClubShotDataByDate(long playerId, Date created)
        throws SystemException {

        List<ESPlayerShotData> shotData =
            esPlayerShotDataPersistence.findByG_ShotDataByDate(playerId, created);
            
        return shotData;
    }
    
    /**
     * Gets all Player shot data by date out of the database.
     *
     * @return
     * @throws SystemException
     */
    public List<ESPlayerShotData> getClubShotDataByScopeDate(long playerId, Date begin, Date end)
        throws SystemException {

        List<ESPlayerShotData> shotData =
            esPlayerShotDataPersistence.findByG_ShotDataByDate(playerId, begin);
            
        return shotData;
    }
}