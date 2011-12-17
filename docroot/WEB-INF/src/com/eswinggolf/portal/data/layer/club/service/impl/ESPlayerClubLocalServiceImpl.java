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

import java.util.List;


import com.eswinggolf.portal.data.layer.club.NoSuchESPlayerClubException;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;
import com.eswinggolf.portal.data.layer.club.service.base.ESPlayerClubLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;

/**
 * The implementation of the e s player club local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.eswinggolf.portal.data.layer.club.service.ESPlayerClubLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.eswinggolf.portal.data.layer.club.service.ESPlayerClubLocalServiceUtil} to access the e s player club local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author evangelistalc
 * @see com.eswinggolf.portal.data.layer.club.service.base.ESPlayerClubLocalServiceBaseImpl
 * @see com.eswinggolf.portal.data.layer.club.service.ESPlayerClubLocalServiceUtil
 */
public class ESPlayerClubLocalServiceImpl
	extends ESPlayerClubLocalServiceBaseImpl {
	
	/**
     * Adds a new product to the database.
     *
     * @param clubName
     * @param clubDesc
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public ESPlayerClub addPlayerClub(ESPlayerClub playerClub, long userId)
        throws SystemException, PortalException {

    	
        ESPlayerClub club =
            esPlayerClubPersistence.create(
                counterLocalService.increment(ESPlayerClub.class.getName()));
        
        	club.setClubId(playerClub.getClubId());
        	club.setUserId(playerClub.getUserId());
        	club.setCompanyId(playerClub.getCompanyId());
    		club.setGroupId(playerClub.getGroupId());	
        	club.setClubDesc(playerClub.getClubDesc());
        	club.setLoft(playerClub.getLoft());
        	club.setNomSpeed(playerClub.getNomSpeed());
        	club.setNomSr(playerClub.getNomSr());
        	club.setCoR(playerClub.getCoR());
        	club.setWeight(playerClub.getWeight());
        	club.setModel(playerClub.getModel());
        	club.setActive(playerClub.getActive());
        	club.setCreateDate(playerClub.getCreateDate());
        	club.setModifiedDate(playerClub.getModifiedDate());
        	
        	//resourceLocalService.addResources(
            //        playerClub.getCompanyId(), playerClub.getGroupId(), userId,
            //        ESPlayerClub.class.getName(), club.getPrimaryKey(), false,
            //        true, true);

        return esPlayerClubPersistence.update(club, false);
    }

    /**
     * Retrieves all of the clubs from the database.
     *
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public List<ESPlayerClub> getAllPlayerClubs(long groupId)
        throws SystemException {

        List<ESPlayerClub> clubs =
            esPlayerClubPersistence.findByPlayerClubGroup(groupId);
        return clubs;
    }

    /**
     * Removes the specified club from the database.
     *
     * @param clubId
     * @throws com.inkwell.internet.portlets.prodreg.sb.NoSuchProductException
     * @throws com.liferay.portal.kernel.exception.SystemException
     * @throws com.liferay.portal.kernel.exception.PortalException
     */
    public void deletePlayerClub(long clubId)
        throws NoSuchESPlayerClubException, SystemException, PortalException {

        ESPlayerClub club = esPlayerClubPersistence.findByPrimaryKey(clubId);
        deleteESPlayerClub(club);
    }

    /**
     * Removes the specified club from the database.
     *
     * @param club
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public void deletePlayerClub(ESPlayerClub club)
        throws SystemException {

        try {
			resourceLocalService.deleteResource(
			    club.getCompanyId(), ESPlayerClub.class.getName(),
			    ResourceConstants.SCOPE_INDIVIDUAL, club.getPrimaryKey());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        esPlayerClubPersistence.remove(club);
    }
}