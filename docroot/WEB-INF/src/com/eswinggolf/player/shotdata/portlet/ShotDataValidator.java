/**
 * 
 */
package com.eswinggolf.player.shotdata.portlet;

import java.util.List;


import com.eswinggolf.player.shotdata.trajectory.model.ShotData;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author evangelistalc
 *
 */
public class ShotDataValidator {
	
	/**
     * Validates a Product object
     *
     * @param product
     * @param errors
     * @return boolean
     */
    public static boolean validateShotData(ESPlayerShotData shotData, List errors) {

        boolean valid = true;
        
        if (Validator.isNull(shotData.getPlayerClubId())) {
            errors.add("club-required");
            valid = false;
        }

        if (Validator.isNull(shotData.getClubSpeed())) {
            errors.add("club-speed-value-required");
            valid = false;
        }

        if (Validator.isNull(shotData.getFaceAngle())) {
            errors.add("face-angle-required");
            valid = false;
        }

        if (Validator.isNull(shotData.getClubLoft())) {
            errors.add("club-loft-required");
            valid = false;
        } 
        
        if (Validator.isNull(shotData.getBallSpinRate())) {
            errors.add("ball-spin-rate-required");
            valid = false;
        } 
        
        if (Validator.isNull(shotData.getSwingPath())) {
            errors.add("club-swing-path-required");
            valid = false;
        } 
        
        if (Validator.isNull(shotData.getBallAngleOfAttack())) {
            errors.add("ball-angle-of-attack-required");
            valid = false;
        } 
        
        if (Validator.isNull(shotData.getWindDirection())) {
            errors.add("wind-direction-required");
            valid = false;
        } 
        
        if (Validator.isNull(shotData.getWindSpeed())) {
            errors.add("wind-speed-required");
            valid = false;
        }
        
        if (Validator.isNull(shotData.getAmbientTemp())) {
            errors.add("ambient-temp-required");
            valid = false;
        } 
        
        if (Validator.isNull(shotData.getBarPressureAlt())) {
            errors.add("bar-pressure-required");
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
    public static boolean validateShot(ShotData shot, List errors) {

        boolean valid = true;
        

        if (Validator.isNull(shot.get_temperature())) {
            errors.add("club-speed-value-required");
            valid = false;
        }

        if (Validator.isNull(shot.get_altitude())) {
            errors.add("face-angle-required");
            valid = false;
        }

        if (Validator.isNull(shot.getClubLoft())) {
            errors.add("club-loft-required");
            valid = false;
        } 
        
        if (Validator.isNull(shot.getBallAOA())) {
            errors.add("ball-spin-rate-required");
            valid = false;
        } 
        
        if (Validator.isNull(shot.getBallSpeed())) {
            errors.add("club-swing-path-required");
            valid = false;
        } 
        
        if (Validator.isNull(shot.getBallCompression())) {
            errors.add("ball-angle-of-attack-required");
            valid = false;
        } 
        
        if (Validator.isNull(shot.getWindDirection())) {
            errors.add("wind-direction-required");
            valid = false;
        } 
        
        if (Validator.isNull(shot.getWindSpeed())) {
            errors.add("wind-speed-required");
            valid = false;
        }
        
        
        return valid;
    }

}
