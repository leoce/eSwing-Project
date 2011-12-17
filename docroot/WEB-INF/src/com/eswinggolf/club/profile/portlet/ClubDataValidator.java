/**
 * 
 */
package com.eswinggolf.club.profile.portlet;

import java.util.List;



import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author evangelistalc
 *
 */
public class ClubDataValidator {
	
	/**
     * Validates a Product object
     *
     * @param product
     * @param errors
     * @return boolean
     */
    public static boolean validateClub(ESClub requestClub, List errors) {

        boolean valid = true;
        
        if (Validator.isNull(requestClub.getClubName())) {
            errors.add("club-name-required");
            valid = false;
        }
        
        if (Validator.isNull(requestClub.getClubDesc())) {
            errors.add("club-specs-value-required");
            valid = false;
        }
        
        
        if (Validator.isNull(requestClub.getNomSr())) {
            errors.add("nominal-spin-rate-required");
            valid = false;
        }
        
        if (Validator.isNull(requestClub.getNomSpeed())) {
            errors.add("nominal-speed-required");
            valid = false;
        }
        
        if (Validator.isNull(requestClub.getLoft())) {
            errors.add("club-loft-required");
            valid = false;
        }
        
        if (Validator.isNull(requestClub.getWeight())) {
            errors.add("club-weight-required");
            valid = false;
        }
        
        if (Validator.isNull(requestClub.getCoR())) {
            errors.add("club-cor-required");
            valid = false;
        }
        
        
        return valid;
    }
    
    /**
     * Validates a Product object
     *
     * @param product
     * @param errors
     * @return boolean
     */
    public static boolean validatePlayerClub(ESPlayerClub playerClub, List errors) {

        boolean valid = true;
        
        if (Validator.isNull(playerClub.getLoft())) {
            errors.add("loft-value-required");
            valid = false;
        }

        if (Validator.isNull(playerClub.getModel())) {
            errors.add("club-model-required");
            valid = false;
        }


         
        return valid;
    }

}
