/**
 * 
 */
package com.eswinggolf.club.profile.portlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.eswinggolf.player.shotdata.trajectory.model.ShotData;
import com.eswinggolf.portal.data.layer.club.model.ESClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerClub;
import com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData;
import com.eswinggolf.portal.data.layer.club.model.ESTrialShotData;
import com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl;
import com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerClubImpl;
import com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataImpl;
import com.eswinggolf.portal.data.layer.club.model.impl.ESTrialShotDataImpl;
import com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerClubLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil;
import com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalServiceUtil;
import com.eswinggolf.portal.data.layer.model.ESPlayer;
import com.eswinggolf.portal.data.layer.model.impl.ESPlayerImpl;
import com.eswinggolf.portal.data.layer.service.ESPlayerLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author evangelistalc
 *
 */
public class ActionUtil {
	
	/**
     * Used by the view.jsp to grab the products from the database.
     * @param request
     * @return
     */
    public static List<ESClub> getClubs(RenderRequest request) {

        List<ESClub> tempResults;

        try {
            tempResults = ESClubLocalServiceUtil.getESClubs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the active clubs from the database.
     * @param request
     * @return
     */
    
    public static List<ESClub> getActiveClubs(RenderRequest request) {

        List<ESClub> tempResults;
        
        List<ESClub> activeClubs = new ArrayList<ESClub>();

        try {
            tempResults = ESClubLocalServiceUtil.getESClubs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            
            Iterator<ESClub> iter = tempResults.iterator();
            
            while(iter.hasNext()){
            	
            	ESClub club = (ESClub) iter.next();
            	
            	if (club.isActive()){
            		activeClubs.add(club);
            	}
            	
            }
            
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();
            

        }

        return activeClubs;

    }
    
    /**
     * Used by the view.jsp to grab the clubs from the database.
     * @param clubId
     * @return
     */
    public static ESClub getClub(long clubId) throws SystemException, PortalException{

        ESClub club; //= new ESClubImpl();
        //ESPlayerClub playerClub = new ESPlayerClubImpl(); 

        try {
        	//playerClub = ESPlayerClubLocalServiceUtil.getESPlayerClub(clubId);
        	//if (Validator.isNotNull(playerClub)){
        	//	club.setClubDesc(playerClub.getClubDesc());
        	//}else{
        		club = ESClubLocalServiceUtil.getESClub(clubId);
        	//}
        }

        catch (SystemException ex) {
            club  = new ESClubImpl();
            

        }

        return club;

    }
    
    public static ESClub clubFromRequest(ActionRequest request) {
    	
       ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
       ESClub club = new ESClubImpl();
       Date now = new Date();
       
       
       club.setGroupId(themeDisplay.getScopeGroupId());
       club.setCompanyId(themeDisplay.getCompanyId());
       club.setUserId(themeDisplay.getUserId());
       club.setClubName(ParamUtil.getString(request, "clubName"));
       club.setClubDesc(ParamUtil.getString(request, "clubDesc"));
       club.setLaunchAngle(ParamUtil.getInteger(request, "launchAngle"));
       club.setLoft(ParamUtil.getInteger(request, "loft"));
       club.setNomSr(ParamUtil.getInteger(request, "nomSr"));
       club.setNomSpeed(ParamUtil.getInteger(request, "nomSpeed"));
       club.setCoR(ParamUtil.getDouble(request, "coR"));
       club.setWeight(ParamUtil.getInteger(request, "weight"));
       club.setModel(ParamUtil.getString(request, "model"));
       club.setActive(ParamUtil.getBoolean(request, "active"));
       club.setCreateDate(now);
       club.setModifiedDate(now);
       
       return club;
    }
    
  
    /**
     * Used by the view.jsp to grab the player clubs from the database.
     * @param request
     * @return
     */
    public static List<ESPlayerClub> getPlayerClubs(RenderRequest request) {

        List<ESPlayerClub> tempResults;

        try {
            tempResults = ESPlayerClubLocalServiceUtil.getESPlayerClubs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }


    
    public static ESPlayerClub playerclubFromRequest(ActionRequest request) throws SystemException{
       ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
       ESPlayerClub playerClub = new ESPlayerClubImpl();

       ESClub club;
       
       try {
    	   club = ESClubLocalServiceUtil.getESClub(ParamUtil.getLong(request, "clubName"));   
       }catch (PortalException pe){
    	   club = new ESClubImpl();
       }
       
       Date now = new Date();
       
       playerClub.setClubId(ParamUtil.getLong(request, "clubName"));
       playerClub.setGroupId(themeDisplay.getScopeGroupId());
       playerClub.setCompanyId(themeDisplay.getCompanyId());
       playerClub.setUserId(themeDisplay.getUserId());
       playerClub.setPlayerId(themeDisplay.getUserId());
       playerClub.setClubDesc(ParamUtil.getString(request, "clubDesc"));
       playerClub.setLoft(ParamUtil.getInteger(request, "loft"));
       playerClub.setWeight(ParamUtil.getInteger(request, "weight"));
       playerClub.setModel(ParamUtil.getString(request, "model"));
       playerClub.setActive(ParamUtil.getBoolean(request, "active"));
       playerClub.setClubId(club.getClubId());
	   playerClub.setNomSr(club.getNomSr());
	   playerClub.setNomSpeed(club.getNomSpeed());
	   playerClub.setCoR(club.getCoR());
       playerClub.setCreateDate(now);
       playerClub.setModifiedDate(now);
       
       return playerClub;
    }
    
    /**
     * Used by the view.jsp to grab the shot data from the database.
     * @param request
     * @return
     */
    public static List<ESPlayerShotData> getPlayerShotData(RenderRequest request) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

       long playerId = themeDisplay.getUserId();

        List<ESPlayerShotData> tempResults;

        try {
            tempResults = ESPlayerShotDataLocalServiceUtil.getAllPlayerShotData(playerId);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the Player Shot Data by Scope Date from the database.
     * @param request
     * @param begin - beginning date
     * @param end - ending date
     * @return
     */
    public static List<ESPlayerShotData> getTrialShotDataByScopeDate(RenderRequest request, Date begin, Date end) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

       long playerId = themeDisplay.getUserId();

        List<ESPlayerShotData> tempResults;

        try {
            tempResults = ESPlayerShotDataLocalServiceUtil.getClubShotDataByDate(playerId, begin);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the Player Shot Data by Scope Date from the database.
     * @param request
     * @param created - beginning date
     * @param end - ending date
     * @return
     */
    public static List<ESPlayerShotData> getTrialShotDataByDate(RenderRequest request, Date created) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

       long playerId = themeDisplay.getUserId();

        List<ESPlayerShotData> tempResults;

        try {
        	
            tempResults = ESPlayerShotDataLocalServiceUtil.getClubShotDataByDate(playerId, created);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the Player Shot Data by club from the database.
     * @param request
     * @param begin - beginning date
     * @param end - ending date
     * @return
     */
    public static List<ESPlayerShotData> getTrialShotDataByClub(RenderRequest request, long clubId) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

       long playerId = themeDisplay.getUserId();

        List<ESPlayerShotData> tempResults;

        try {
            tempResults = ESPlayerShotDataLocalServiceUtil.getAllClubShotByPlayer(playerId, clubId);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the shot data from the database.
     * @param request
     * @return
     */
    public static List<ESTrialShotData> getTrialShotData(RenderRequest request) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

       long playerId = themeDisplay.getUserId();

        List<ESTrialShotData> tempResults;

        try {
            tempResults = ESTrialShotDataLocalServiceUtil.getESTrialShotDatas(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

        }catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the Player Shot Data by Scope Date from the database.
     * @param request
     * @param begin - beginning date
     * @param end - ending date
     * @return
     */
    public static List<ESPlayerShotData> getPlayerShotDataByScopeDate(RenderRequest request, Date begin, Date end) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

       long playerId = themeDisplay.getUserId();

        List<ESPlayerShotData> tempResults;

        try {
            tempResults = ESPlayerShotDataLocalServiceUtil.getClubShotDataByDate(playerId, begin);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the Player Shot Data by Scope Date from the database.
     * @param request
     * @param created - beginning date
     * @param end - ending date
     * @return
     */
    public static List<ESPlayerShotData> getPlayerShotDataByDate(RenderRequest request, Date created) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

       long playerId = themeDisplay.getUserId();

        List<ESPlayerShotData> tempResults;

        try {
        	
            tempResults = ESPlayerShotDataLocalServiceUtil.getClubShotDataByDate(playerId, created);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the Player Shot Data by club from the database.
     * @param request
     * @param begin - beginning date
     * @param end - ending date
     * @return
     */
    public static List<ESPlayerShotData> getPlayerShotDataByClub(RenderRequest request, long clubId) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

       long playerId = themeDisplay.getUserId();

        List<ESPlayerShotData> tempResults;

        try {
            tempResults = ESPlayerShotDataLocalServiceUtil.getAllClubShotByPlayer(playerId, clubId);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    /**
     * Used by the view.jsp to grab the products from the database.
     * @param request
     * @return
     */
    public static List<ESPlayerShotData> hasSimulateShotData(RenderRequest request) {

        List<ESPlayerShotData> tempResults;

        List<ESPlayerShotData> simulateIsTrue = new ArrayList<ESPlayerShotData>();
        try {
            tempResults = ESPlayerShotDataLocalServiceUtil.getESPlayerShotDatas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        
            Iterator<ESPlayerShotData> iter = tempResults.iterator();
            
            while(iter.hasNext()){
            	
            	ESPlayerShotData shotData = (ESPlayerShotData) iter.next();
            	
            	if (shotData.isActive()&& shotData.isSimulate()){
            		simulateIsTrue.add(shotData);
            	}    	
            }
        
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();
            
        }

        return simulateIsTrue;

    }


    
    public static ESPlayerShotData playerShotDataFromRequest(ActionRequest request) {
       ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
       ESPlayerShotData playerShotData = new ESPlayerShotDataImpl();

       Date now = new Date();
       
       
       playerShotData.setPlayerClubId(ParamUtil.getLong(request, "clubId"));
       playerShotData.setPlayerId(themeDisplay.getCompanyId());
       playerShotData.setLaunchMonitor(ParamUtil.getBoolean(request, "launchMonitor"));
       playerShotData.setClubSpeed(ParamUtil.getInteger(request, "clubSpeed"));
       playerShotData.setClubLoft(ParamUtil.getInteger(request, "loft"));
       playerShotData.setFaceAngle(ParamUtil.getInteger(request,"faceAngle"));
       playerShotData.setBallSpinRate(ParamUtil.getInteger(request,"spinRate"));
       playerShotData.setSwingPath(ParamUtil.getInteger(request, "swingPath"));
       playerShotData.setBallAngleOfAttack(ParamUtil.getLong(request, "ballAOA"));
       playerShotData.setBallCompression(ParamUtil.getFloat(request, "ballCompression"));
       playerShotData.setFairwayFirmness(ParamUtil.getFloat(request, "fairwayFirmness"));
       playerShotData.setWindDirection(ParamUtil.getInteger(request, "windDirection"));
       playerShotData.setWindSpeed(ParamUtil.getInteger(request, "windSpeed"));
       playerShotData.setAmbientTemp(ParamUtil.getInteger(request, "ambientTemp"));
       playerShotData.setRelativeHumid(ParamUtil.getInteger(request, "relativeHumid"));
       playerShotData.setBarPressureAlt(ParamUtil.getInteger(request, "barPressureAlt"));
       playerShotData.setCreateDate(now);
       playerShotData.setModifiedDate(now);
       
       
       return playerShotData;
    }
    
    public static ShotData shotDataConverter(ESPlayerShotData playerData, Boolean member){
    	
    	ShotData shot = new ShotData();
    	
    	
		shot.setClubFaceAngle(playerData.getFaceAngle());
		shot.setClubSwingPath(playerData.getSwingPath());
    	shot.setLaunchMonitor(playerData.getLaunchMonitor());
    	shot.set_temperature(playerData.getAmbientTemp());
    	shot.set_altitude(playerData.getBarPressureAlt());
    	shot.setBallAOA(playerData.getBallAngleOfAttack());
    	shot.setWindSpeed(playerData.getWindSpeed());
    	shot.setWindDirection(playerData.getWindDirection());
    	shot.setBallSpinAxisAngle(playerData.getSpinAxisAngle());

    	return shot;
    }
    
    public static boolean isRegisteredMember(RenderRequest request){
    	
    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

      
        ESPlayer player;
        boolean registered = true;
        try{
        	
        	if (themeDisplay.isSignedIn()){
        		User user = themeDisplay.getUser();
        	
        		player = ESPlayerLocalServiceUtil.getESPlayer(user.getUserId());
                
              if (Validator.isNotNull(player)){
                registered = false;
               }
              
        	}
        }catch(Exception se){
        	player = new ESPlayerImpl();
        }
       
   
    	return registered;	
    }	
}
