/**
 * 
 */
package com.eswinggolf.player.shotdata.portlet;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.eswinggolf.club.profile.portlet.ActionUtil;
import com.eswinggolf.player.shotdata.trajectory.model.Point3D;
import com.eswinggolf.player.shotdata.trajectory.model.ShotData;
import com.eswinggolf.player.shotdata.trajectory.model.TrajectoryModel;
import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
import com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerClubLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
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
public class ESPlayerShotDataPortlet extends MVCPortlet {
	
	
	private static Log _log = LogFactory.getLog(ESPlayerShotDataPortlet.class);
    protected String addSubscriptionJSP = "http://localhost:8080/web/test/trial-subscription-registration";
    protected String uploadShotDataJSP = "/jsp/shotdatatable/view.jsp";
    protected String simulateShotDataJSP = "/jsp/trajectory/view.jsp";
	 
    public void addSubscription(ActionRequest request, ActionResponse response) 
    throws Exception{
    	
    	response.sendRedirect(addSubscriptionJSP);
    	
    }
  
	public void deactivateShotData(ActionRequest request, ActionResponse response)
	   throws Exception {

		    long shotDataKey = ParamUtil.getLong(request, "resourcePrimKey");
		     ArrayList<String> errors = new ArrayList<String>();
		    if (Validator.isNotNull(shotDataKey)) {
		        ESPlayerShotData shotData =
		             ESPlayerShotDataLocalServiceUtil.getESPlayerShotData(shotDataKey);
		            	
		            	shotData.setActive(false);
		          
		                ESPlayerShotDataLocalServiceUtil.updateESPlayerShotData(shotData);
		                SessionMessages.add(request, "ShotDataDeactivated");

		    }
	}
	
	public void updateSimulateShotData(ActionRequest request, ActionResponse response)
	   throws Exception {

		    long shotDataKey = ParamUtil.getLong(request, "resourcePrimKey");
		     ArrayList<String> errors = new ArrayList<String>();
		    if (Validator.isNotNull(shotDataKey)) {
		        ESPlayerShotData shotData =
		             ESPlayerShotDataLocalServiceUtil.getESPlayerShotData(shotDataKey);
			            	
			            	shotData.setSimulate(true);
			          
			                ESPlayerShotDataLocalServiceUtil.updateESPlayerShotData(shotData);
			                

			    
		        }

	}
	public void activateShotData(ActionRequest request, ActionResponse response)
	   throws Exception {

		    long shotDataKey = ParamUtil.getLong(request, "resourcePrimKey");
		     ArrayList<String> errors = new ArrayList<String>();
		    if (Validator.isNotNull(shotDataKey)) {
		        ESPlayerShotData shotData =
		             ESPlayerShotDataLocalServiceUtil.getESPlayerShotData(shotDataKey);
			            	
			            	shotData.setActive(true);
			          
			                ESPlayerShotDataLocalServiceUtil.updateESPlayerShotData(shotData);
			                SessionMessages.add(request, "ShotDataDeactivated");

			    
		        }

	}
	    public void shareShotData(ActionRequest request, ActionResponse response)
    	throws Exception {

	        long shotDataKey = ParamUtil.getLong(request, "resourcePrimKey");
	        ArrayList<String> errors = new ArrayList<String>();
	        if (Validator.isNotNull(shotDataKey)) {
	            ESPlayerShotData shotData =
	                ESPlayerShotDataLocalServiceUtil.getESPlayerShotData(shotDataKey);
	            ESPlayerShotData requestPlayerShotData = ActionUtil.playerShotDataFromRequest(request);

	            if (ShotDataValidator.validateShotData(requestPlayerShotData, errors)) {
	            	
	            	
	            	//Club.setClubName(requestClub.getClubName());
	            	//Club.setClubDesc(requestClub.getClubDesc());
	                //Club.setClubSpecs(requestClub.getClubSpecs());
	                //ESClubLocalServiceUtil.updateESClub(Club);
	                //SessionMessages.add(request, "ClubUpdated");

	            }
	            else {
	                for (String error : errors) {
	                    SessionErrors.add(request, error);

	                }

	            }

	        }
	        else {
	            SessionErrors.add(request, "error-sharing-shot-data");
	        }

	    }
	    


		public void uploadShotData(ActionRequest request, ActionResponse response)
	    throws Exception {
	    	
	    	long shotDataId = ParamUtil.getLong(request, "resourcePrimKey");
		   
	    	if (Validator.isNotNull(shotDataId)){
		     ESPlayerShotData playerShotData =
		             ESPlayerShotDataLocalServiceUtil.getESPlayerShotData(shotDataId);
		     
		     
		     ESPlayerClub playerClub = 
		    	 ESPlayerClubLocalServiceUtil.getESPlayerClub(playerShotData.getPlayerClubId());
		     
		     ESClub club = 
		    	 ESClubLocalServiceUtil.getESClub(playerShotData.getPlayerClubId());
		     
		     ShotData shotData = ActionUtil.shotDataConverter(playerShotData, true);
		   	
		    	shotData.setClubId(playerClub.getClubId());
		    	shotData.setClubName(club.getClubName());
		    		    	
		    	if (Validator.isNull(playerClub)){
		    		
		    		shotData.setClubLoft(club.getLoft());
		    		shotData.setClubWeight(club.getWeight());
		    		shotData.setClubCor(club.getCoR());
		    		shotData.setClubSpeed(club.getNomSpeed());
		    		shotData.setClubSpinRate(club.getNomSr());
		    		
		    	}else {
		    		
		    		shotData.setClubCor(playerClub.getCoR());
	        		shotData.setClubLoft(playerClub.getLoft());
	        		
	        		if (playerShotData.getLaunchMonitor()){
	        			
	        			shotData.setBallLaunchAngle(playerShotData.getLaunchAngle());
	        			shotData.setBallSpeed(playerShotData.getBallSpeed());
	        			shotData.setBallAOA(playerShotData.getBallAngleOfAttack());
	        			shotData.setBallBackSpin(playerShotData.getBallSpinRate());
	        		}
		    	} 
		        
		     	request.setAttribute("shotData", shotData);
		     	response.setWindowState(LiferayWindowState.NORMAL);
		     	response.setRenderParameter("jspPage", uploadShotDataJSP);
		    	//response.sendRedirect(ParamUtil.getString(request, "redirect"));
	    	}
	    	
	    }
	    
	    
	    public void simulateShotData(ActionRequest request, ActionResponse response)
	    throws Exception{
	    	
	    	ThemeDisplay themeDisplay =
	            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	        ESPlayerShotData shotData = ActionUtil.playerShotDataFromRequest(request);
	       	        ArrayList<String> errors = new ArrayList<String>();
	       
	       	TrajectoryModel simulate;
	       	List<Point3D> points = new ArrayList<Point3D>(); 
	       	
	        if (ShotDataValidator.validateShotData(shotData, errors)) {
	            
	        	ShotData shot = ActionUtil.shotDataConverter(shotData, true);
	        	simulate = new TrajectoryModel(shot,false);
	        	
	        	points = simulate.getPoints();
	        	
	        	request.setAttribute("points", points);
	            response.setRenderParameter("jspPage", simulateShotDataJSP);
	        
	        }
	        else {
	            SessionErrors.add(request, "fields-required");
	        }
	        
	    	
	    }
	    
	    public void simulateSelectedShotData(ActionRequest request, ActionResponse response)
	    throws Exception{
	    	
	    	long playerId = ParamUtil.getLong(request, "playerId");
	    	TrajectoryModel simulate;
	       	List<Point3D> points = new ArrayList<Point3D>(); 
	       	
	    	ArrayList<String> errors = new ArrayList<String>();
	    	if (Validator.isNotNull(playerId)){
		     List<ESPlayerShotData> shotDataList =
		             ESPlayerShotDataLocalServiceUtil.getAllPlayerShotData(playerId);
	  
	       	
	       	Iterator iter = shotDataList.iterator();
	       	
	       	while (iter.hasNext()){
	       		
	       		
	       		ESPlayerShotData shotData = (ESPlayerShotData) iter.next();
	       		if (ShotDataValidator.validateShotData(shotData, errors)) {
	            
	       			ShotData shot = ActionUtil.shotDataConverter(shotData, true);
	       			simulate = new TrajectoryModel(shot,false);
	        	
	       			points = simulate.getPoints();
	        	
	       		}
	       		else {
	       			SessionErrors.add(request, "fields-required");
	       		}
	        
	    	}
	       
	    	
	    }
	    
	 }
}
