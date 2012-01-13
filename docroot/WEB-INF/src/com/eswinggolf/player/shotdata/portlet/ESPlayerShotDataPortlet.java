/**
 * 
 */
package com.eswinggolf.player.shotdata.portlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.eswinggolf.club.profile.portlet.ActionUtil;
import com.eswinggolf.player.shotdata.trajectory.model.Point3D;
import com.eswinggolf.player.shotdata.trajectory.model.ShotData;
import com.eswinggolf.player.shotdata.trajectory.model.TrajectoryModel;
import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
import com.eswinggolf.portal.data.layer.club.model.ESTrialShotData;
import com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerClubLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;

import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author evangelistalc
 *
 */
public class ESPlayerShotDataPortlet extends MVCPortlet {
	
	
	private static Log _log = LogFactory.getLog(ESPlayerShotDataPortlet.class);
    protected String addSubscriptionJSP = "http://localhost:8080/web/test/trial-subscription-registration";
    protected String uploadShotDataJSP = "/jsp/shotdata/view.jsp";
    protected String uploadTrialShotDataJSP = "/jsp/trialshotdata/view.jsp";
    protected String simulateShotDataJSP = "/jsp/trajectory/view.jsp";
	 
    public void addSubscription(ActionRequest request, ActionResponse response) 
    throws Exception{
    	
    	 ThemeDisplay themeDisplay =
             (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	
    	if (themeDisplay.isSignedIn()){
    		ESTrialShotDataLocalServiceUtil.transferTrialDataToShotData(themeDisplay.getUserId());
		
    		ESTrialShotDataLocalServiceUtil.deleteTrialShotData(themeDisplay.getUserId());
    		SessionMessages.add(request, "player-shotdata-transfered-successfully");
    	}
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
	            //ESPlayerShotData shotData =
	           //     ESPlayerShotDataLocalServiceUtil.getESPlayerShotData(shotDataKey);
	            //ESPlayerShotData requestPlayerShotData = ActionUtil.shotDataFromRequest(request);

	           // if (ShotDataValidator.validateShotData(requestPlayerShotData, errors)) {
	            	
	            	
	            	//Club.setClubName(requestClub.getClubName());
	            	//Club.setClubDesc(requestClub.getClubDesc());
	                //Club.setClubSpecs(requestClub.getClubSpecs());
	                //ESClubLocalServiceUtil.updateESClub(Club);
	                //SessionMessages.add(request, "ClubUpdated");

	           // }
	           // else {
	           //     for (String error : errors) {
	           //         SessionErrors.add(request, error);

	           //     }

	           // }

	        }
	        else {
	            SessionErrors.add(request, "error-sharing-shot-data");
	        }

	    }
	    


		public void uploadShotData(ActionRequest request, ActionResponse response)
	    throws Exception {
	    	
	    	long shotDataId = ParamUtil.getLong(request, "resourcePrimKey");
	    	
		    boolean isRegistered = false;
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
		    		
		    		shotData.setClubWeight(club.getWeight());
		    		shotData.setClubCor(club.getCoR());
		    		shotData.setClubSpinRate(club.getNomSr());
		    		
		    	}else {
		    		
		    		shotData.setClubCor(playerClub.getCoR());
		    		shotData.setClubSpinRate(playerClub.getNomSr());
		    		shotData.setClubWeight(playerClub.getWeight());
		    		isRegistered = true;
	        		if (playerShotData.getLaunchMonitor()){
	        			
	        			shotData.setBallLaunchAngle(playerShotData.getLaunchAngle());
	        			shotData.setBallSpeed(playerShotData.getBallSpeed());
	        			shotData.setBallAOA(playerShotData.getBallAngleOfAttack());
	        			shotData.setBallBackSpin(playerShotData.getBallSpinRate());
	        		}
		    	} 
		        
		    	//request.setAttribute("firmness", playerShotData.getFairwayFirmness());
		     	request.setAttribute("shotData", shotData);
		     	//request.setAttribute("registered", isRegistered);
		     	response.setWindowState(LiferayWindowState.NORMAL);
		     	response.setRenderParameter("jspPage", uploadShotDataJSP);
		    	//response.sendRedirect(ParamUtil.getString(request, "redirect"));
		     	//response.sendRedirect(uploadShotDataJSP);
	    	}
	    	
	    }
	    
		public void uploadTrialShotData(ActionRequest request, ActionResponse response)
	    throws Exception {
	    	
	    	long shotDataId = ParamUtil.getLong(request, "resourcePrimKey");
	    	
	    	if (Validator.isNotNull(shotDataId)){
		     ESTrialShotData trialShotData =
		             ESTrialShotDataLocalServiceUtil.getESTrialShotData(shotDataId);
		     
		     ESClub club = 
		    	 ESClubLocalServiceUtil.getESClub(trialShotData.getPlayerClubId());
		     
		     ShotData shotData = ActionUtil.trialDataConverter(trialShotData, true);
		   	
		    	
		     	shotData.setClubId(club.getClubId());
		    	shotData.setClubName(club.getClubName());
		    	
		    	shotData.setClubWeight(club.getWeight());
		    	shotData.setClubCor(club.getCoR());
		    	shotData.setClubSpinRate(club.getNomSr());

	        	if (trialShotData.getLaunchMonitor()){
	        			
	        		shotData.setBallLaunchAngle(trialShotData.getLaunchAngle());
	        		shotData.setBallSpeed(trialShotData.getBallSpeed());
	        		shotData.setBallAOA(trialShotData.getBallAngleOfAttack());
	        		shotData.setBallBackSpin(trialShotData.getBallSpinRate());
	        	}
		    	
		        
		    	//request.setAttribute("firmness", playerShotData.getFairwayFirmness());
		     	request.setAttribute("trialData", shotData);
		     	//request.setAttribute("registered", isRegistered);
		     	response.setWindowState(LiferayWindowState.NORMAL);
		     	response.setRenderParameter("jspPage", uploadTrialShotDataJSP);
		    	//response.sendRedirect(ParamUtil.getString(request, "redirect"));
		     	//response.sendRedirect(uploadShotDataJSP);
	    	}
	    	
	    }
	    public void simulateShotData(ActionRequest request, ActionResponse response)
	    throws Exception{
	    	
	      
	       	ArrayList<String> errors = new ArrayList<String>();
	       	        
	       	ShotData shot = ActionUtil.shotDataFromRequest(request);
	       	
	       	ESClub club = ActionUtil.getClub(shot.getClubId());
	       	
	       	shot.setClubCor(club.getCoR());
	       	shot.setClubWeight(club.getWeight());

	       	TrajectoryModel simulate;
	       	List<Point3D> points = new ArrayList<Point3D>(); 
	       	
	        if (ShotDataValidator.validateShot(shot, errors)) {
	            
	        	
	        	simulate = new TrajectoryModel(shot,false);
	        	
	        	points = simulate.getPoints();
	        	//response.setRenderParameter("points", points.toString());
	        	//System.out.println("Points:"+points.toString());
	        	request.setAttribute("points", points);
	            //response.setRenderParameter("jspPage", simulateShotDataJSP);
	        	//response.sendRedirect(simulateShotDataJSP);
	        
	        }
	        else {
	            SessionErrors.add(request, "fields-required");
	        }
	        
	    	
	    }
	    
	    public void simulateSelectedShotData(ActionRequest request, ActionResponse response)
	    throws Exception{
	    	
	    	
	    	//ResultRow row = (ResultRow) request.getAttribute(
	    	//	    WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	    	
	    	//long shotDataId = ParamUtil.getLong(request, "plot");
	        //ESPlayerShotData myShotData = (ESPlayerShotData) ParamUtil.get
	        
	        //String primKey = String.valueOf(myShotData.getShotDataId());
	        //System.out.println("Shot data id: "+shotDataId);
	    	long[] arrayPoints = {101,1001,1002};
	    	/*
	    	TrajectoryModel simulate;
	       	
	       List<List<Point3D>> arrayPoints = new ArrayList<List<Point3D>>();
	    	
	       	ArrayList<String> errors = new ArrayList<String>();
	    
	    	    for (int i=0; i < shotDataIds.length; i++){
	    	    	ESPlayerShotData shotData = ESPlayerShotDataLocalServiceUtil.getESPlayerShotData(shotDataIds[i]);
	    		
	    			if (ShotDataValidator.validateShotData(shotData, errors)) {
		               
	    				ShotData shot = ActionUtil.shotDataConverter(shotData, true);
	    				simulate = new TrajectoryModel(shot,false);
	       			
	    				arrayPoints.add(simulate.getPoints());
	       			
	    			}
	    			else {
	    				SessionErrors.add(request, "fields-required");
	    			}
	    	    } */
	    		//shotDataList.add(myShotData);
	    	
	    	//ESPlayerShotData myShotData = (ESPlayerShotData) row.getObject();
	    	//String primKey = String.valueOf(myShotData.getPrimaryKey());
	    	//System.out.println("Primary Key: "+primKey);
	    	
	    	//long playerId = ParamUtil.getLong(request, "playerId");
	    	//TrajectoryModel simulate;
	       	
	       	//List<List<Point3D>> arrayPoints = new ArrayList<List<Point3D>>();
	       	
	    	//ArrayList<String> errors = new ArrayList<String>();
	    	//if (Validator.isNotNull(playerId)){
	  
	       	
	       	//Iterator iter = shotDataList.iterator();
	       	
	       	//while (iter.hasNext()){
	       		
	       		
	       		//ESPlayerShotData shotData = (ESPlayerShotData) iter.next();
	       		//if (ShotDataValidator.validateShotData(shotData, errors)) {
	            
	       		//	ShotData shot = ActionUtil.shotDataConverter(shotData, true);
	       	//		simulate = new TrajectoryModel(shot,false);
	       			
	       	//		arrayPoints.add(simulate.getPoints());
	       			
	        	
	       	//	}
	       	//	else {
	       	//		SessionErrors.add(request, "fields-required");
	       	//	}
	        
	    	//}
	       	

	       	request.setAttribute("arrayPoints", arrayPoints);
	       	response.setWindowState(LiferayWindowState.NORMAL);
	       	response.setRenderParameter("jspPage", simulateShotDataJSP);
	       
	    	
	    //}
	    
	 }
	    
	 public void serveResource( ResourceRequest request, ResourceResponse response)
	    throws IOException, PortletException {

	    String jspPage = request.getParameter("fetchDataAction");
	            if (jspPage != null) {
	        include(jspPage, request, response, PortletRequest.RESOURCE_PHASE);
	    }
	    else {
	        super.serveResource(request, response);
	    }
	}
}
