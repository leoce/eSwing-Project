/**
 * 
 */
package com.eswinggolf.club.profile.portlet;


import java.util.ArrayList;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.eswinggolf.club.profile.portlet.ClubDataValidator;
import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.impl.ESClubLocalServiceImpl;
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
public class ESClubPortlet extends MVCPortlet {
	
	
	private static Log _log = LogFactory.getLog(ESClubPortlet.class);
    protected String editClubJSP = "/jsp/club/edit_club.jsp";

	 /**
	   * This Action adds a Club to the database.
	   *
	   * @param request
	   * @param response
	   * @throws java.lang.Exception
	   */

	public void addClub(ActionRequest request, ActionResponse response)
	        throws Exception {
	        
	       
	        ESClub club = ActionUtil.clubFromRequest(request);

	        ArrayList<String> errors = new ArrayList<String>();

	        if (ClubDataValidator.validateClub(club, errors)) {
	            ESClubLocalServiceUtil.addClub(club);
	            SessionMessages.add(request, "club-saved-successfully");
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

	public void editClub(ActionRequest request, ActionResponse response)
	        throws Exception {

	        long clubKey = ParamUtil.getLong(request, "resourcePrimKey");

	        System.out.println("Club Key --> "+clubKey);
	        if (Validator.isNotNull(clubKey)) {
	            ESClub club =
	                ESClubLocalServiceUtil.getESClub(clubKey);
	            
	            System.out.println("Club Name --> "+club.getClubName());
	            request.setAttribute("club", club);
	            response.setRenderParameter("jspPage", editClubJSP);
	        }
	    }

	    /**
	     * This Action updates an existing Club with values that were entered
	     * into the edit_club.jsp.
	     *
	     * @param request
	     * @param response
	     * @throws java.lang.Exception
	     */

	 public void updateClub(ActionRequest request, ActionResponse response)
	        throws Exception {

	        long clubKey = ParamUtil.getLong(request, "resourcePrimKey");
	        ArrayList<String> errors = new ArrayList<String>();
	        if (Validator.isNotNull(clubKey)) {
	            ESClub club =
	                ESClubLocalServiceUtil.getESClub(clubKey);
	            ESClub requestClub = ActionUtil.clubFromRequest(request);

	            if (ClubDataValidator.validateClub(requestClub, errors)) {
	            	
	            	club.setClubName(requestClub.getClubName());
	            	club.setClubDesc(requestClub.getClubDesc());
	            	club.setLoft(requestClub.getLoft());
	            	club.setNomSr(requestClub.getNomSr());
	            	club.setNomSpeed(requestClub.getNomSpeed());
	            	club.setCoR(requestClub.getCoR());
	            	club.setWeight(requestClub.getWeight());
	                club.setModel(requestClub.getModel());
	                club.setActive(requestClub.getActive());
	            	club.setModifiedDate(new Date());
	            	
	                ESClubLocalServiceUtil.updateESClub(club);
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
	    public void deleteClub(ActionRequest request, ActionResponse response)
	        throws Exception {

	        long clubKey = ParamUtil.getLong(request, "resourcePrimKey");

	        if (Validator.isNotNull(clubKey)) {
	            ESClubLocalServiceUtil.deleteClub(clubKey);
	            SessionMessages.add(request, "clubDeleted");
	        }
	        else {
	            SessionErrors.add(request, "error-deleting");
	        }
	    }
}
