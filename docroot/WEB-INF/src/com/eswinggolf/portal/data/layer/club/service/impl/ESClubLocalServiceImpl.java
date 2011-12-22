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


import com.eswinggolf.portal.data.layer.club.NoSuchESClubException;
import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.service.base.ESClubLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;

/**
 * The implementation of the e s club local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.eswinggolf.portal.data.layer.club.service.ESClubLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil} to access the e s club local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author evangelistalc
 * @see com.eswinggolf.portal.data.layer.club.service.base.ESClubLocalServiceBaseImpl
 * @see com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil
 */
public class ESClubLocalServiceImpl extends ESClubLocalServiceBaseImpl {
	/**
     * Adds a new product to the database.
     *
     * @param clubName
     * @param clubDesc
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public ESClub addClub(ESClub newClub)
        throws SystemException, PortalException {
    	
        ESClub club =
            esClubPersistence.create(
                counterLocalService.increment(ESClub.class.getName()));
        
        
        	club.setCompanyId(newClub.getCompanyId());
        	club.setGroupId(newClub.getGroupId());
        	club.setUserId(newClub.getUserId());
        	club.setClubName(newClub.getClubName());
        	club.setClubDesc(newClub.getClubDesc());
        	club.setLaunchAngle(newClub.getLaunchAngle());
        	club.setLoft(newClub.getLoft());
        	club.setNomSpeed(newClub.getNomSpeed());
        	club.setNomSr(newClub.getNomSr());
        	club.setCoR(newClub.getCoR());
        	club.setWeight(newClub.getWeight());
        	club.setModel(newClub.getModel());
        	club.setActive(newClub.getActive());
        	club.setCreateDate(newClub.getCreateDate());
        	club.setModifiedDate(newClub.getModifiedDate());
        	
        	//resourceLocalService.addResources(
            //        newClub.getCompanyId(), newClub.getGroupId(),
            //        ESClub.class.getName(), false);
        	//System.out.println("Add resources to the table...");
        	
        return esClubPersistence.update(club, false);
    }

    /**
     * Retrieves all of the clubs from the database.
     *
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public List<ESClub> getAllClubs(long groupId)
        throws SystemException {

        List<ESClub> clubs =
            esClubPersistence.findByGroupId(groupId);
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
    public void deleteClub(long clubId)
        throws NoSuchESClubException, SystemException, PortalException {

        ESClub club = esClubPersistence.findByPrimaryKey(clubId);
        deleteESClub(club);
    }

    /**
     * Removes the specified club from the database.
     *
     * @param club
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public void deleteClub(ESClub club)
        throws SystemException {

        try {
			resourceLocalService.deleteResource(
			    club.getCompanyId(), ESClub.class.getName(),
			    ResourceConstants.SCOPE_INDIVIDUAL, club.getPrimaryKey());
		} catch (PortalException e) {
			throw new SystemException(e);
		}
        esClubPersistence.remove(club);
    }
}