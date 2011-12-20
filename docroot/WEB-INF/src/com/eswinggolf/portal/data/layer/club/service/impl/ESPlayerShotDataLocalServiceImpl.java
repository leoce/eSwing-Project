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
import java.util.List;

import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
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

    public ESPlayerShotData addESPlayerShotData(ESPlayerShotData shot)
        throws SystemException {

        ESPlayerShotData shotData =
            esPlayerShotDataPersistence.create(
                counterLocalService.increment(ESPlayerShotData.class.getName()));

        
        //Your properties here

        try {
			resourceLocalService.addResources(
			    shotData.getPlayerClubId(), shotData.getPlayerId(),
			    ESPlayerShotData.class.getName(), false);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        

        return esPlayerShotDataPersistence.update(shotData, false);
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
    public List<ESPlayerShotData> getClubShotDataByDate(long playerId, Date myDate)
        throws SystemException {

        List<ESPlayerShotData> shotData =
            esPlayerShotDataPersistence.findByG_ShotDataByDate(playerId, myDate);
            
        return shotData;
    }
    
   
}