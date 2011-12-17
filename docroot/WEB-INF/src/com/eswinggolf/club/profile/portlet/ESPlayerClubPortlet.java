/**
 * 
 */
package com.eswinggolf.club.profile.portlet;


import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;
import com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl;
import com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerClubLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author evangelistalc
 *
 */
public class ESPlayerClubPortlet extends MVCPortlet {
	
	
	private static Log _log = LogFactory.getLog(ESPlayerClubPortlet.class);
    protected String editPlayerClubJSP = "/jsp/playerclub/edit_playerclub.jsp";

	 /**
	   * This Action adds a Player's Club to the database.
	   *
	   * @param request
	   * @param response
	   * @throws java.lang.Exception
	   */

	public void addPlayerClub(ActionRequest request, ActionResponse response)
	        throws Exception {

	        ThemeDisplay themeDisplay =
	            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	        ESPlayerClub playerclub = ActionUtil.playerclubFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	        
	     	   
	     	  if (ClubDataValidator.validatePlayerClub(playerclub, errors)) {
		        	
	     		    int clubCount = ESPlayerClubLocalServiceUtil.getESPlayerClubsCount();
	     		    if (clubCount > 0){
	     		    	long clubId = ESPlayerClubLocalServiceUtil.getESPlayerClub(playerclub.getPlayerClubId()).getClubId();
		            
	     		    	if (playerclub.getClubId() == clubId){
	     		    		SessionMessages.add(request, "club-already-exists");
	     		    	}else {
		        	
	     		    		ESPlayerClubLocalServiceUtil.addPlayerClub(
	     		    				playerclub,themeDisplay.getUserId());
	     		    		SessionMessages.add(request, "player-club-saved-successfully");
	     		    	}
	     		    }else{
	     		    	
	     		    	ESPlayerClubLocalServiceUtil.addPlayerClub(
     		    				playerclub,themeDisplay.getUserId());
     		    		SessionMessages.add(request, "player-club-saved-successfully");
	     		    	
	     		    }
		        }
		        else {
		            SessionErrors.add(request, "fields-required");
		        }
	     	   
	        
	        
	    }

	    /**
	     * This Action gets a product from the database and puts it into the
	     * request. It also sets the "jspPage" parameter to "editClub" so that
	     * processing is forwarded to edit_Club.jsp.
	     *
	     * @param request
	     * @param response
	     * @throws java.lang.Exception
	     */

	public void editPlayerClub(ActionRequest request, ActionResponse response)
	        throws Exception {

	        long playerClubKey = ParamUtil.getLong(request, "resourcePrimKey");

	        if (Validator.isNotNull(playerClubKey)) {
	            ESPlayerClub club =
	                ESPlayerClubLocalServiceUtil.getESPlayerClub(playerClubKey);
	            request.setAttribute("club", club);
	            response.setRenderParameter("jspPage", editPlayerClubJSP);
	        }
	    }

	    /**
	     * This Action updates an existing Club with values that were entered
	     * into the edit_Club.jsp.
	     *
	     * @param request
	     * @param response
	     * @throws java.lang.Exception
	     */

	 public void updatePlayerClub(ActionRequest request, ActionResponse response)
	        throws Exception {

	        long playerClubKey = ParamUtil.getLong(request, "resourcePrimKey");
	        ArrayList<String> errors = new ArrayList<String>();
	        
	        if (Validator.isNotNull(playerClubKey)) {
	            ESPlayerClub playerClub =
	                ESPlayerClubLocalServiceUtil.getESPlayerClub(playerClubKey);
	            ESPlayerClub requestPlayerClub = ActionUtil.playerclubFromRequest(request);

	            if (ClubDataValidator.validatePlayerClub(requestPlayerClub, errors)) {
	            	
	            	playerClub.setClubDesc(requestPlayerClub.getClubDesc());
	            	playerClub.setLoft(requestPlayerClub.getLoft());
	            	playerClub.setNomSr(requestPlayerClub.getNomSr());
	            	playerClub.setNomSpeed(requestPlayerClub.getNomSpeed());
	            	playerClub.setCoR(requestPlayerClub.getCoR());
	            	playerClub.setWeight(requestPlayerClub.getWeight());
	                playerClub.setModel(requestPlayerClub.getModel());
	            	playerClub.setActive(requestPlayerClub.getActive());
	                ESPlayerClubLocalServiceUtil.updateESPlayerClub(playerClub);
	                
	                SessionMessages.add(request, "clubUpdated");

	            }
	            else {
	                for (String error : errors) {
	                    SessionErrors.add(request, error);

	                }

	            }

	        }
	        else {
	            SessionErrors.add(request, "error-updating");
	        }

	    }

	    /**
	     * This Action deletes a Club from the database.
	     *
	     * @param request
	     * @param response
	     * @throws java.lang.Exception
	     */
	    public void deletePlayerClub(ActionRequest request, ActionResponse response)
	        throws Exception {

	        long playerClubKey = ParamUtil.getLong(request, "resourcePrimKey");

	        if (Validator.isNotNull(playerClubKey)) {
	            ESPlayerClubLocalServiceUtil.deleteESPlayerClub(playerClubKey);
	            SessionMessages.add(request, "player-club-deleted");
	        }
	        else {
	            SessionErrors.add(request, "error-deleting");
	        }
	    }
}
