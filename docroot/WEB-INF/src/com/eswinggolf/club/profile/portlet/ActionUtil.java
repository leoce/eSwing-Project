/**
 * 
 */
package com.eswinggolf.club.profile.portlet;

import java.text.DateFormat;
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
        	addGroupAndCompanyId(request);
            tempResults = ESPlayerShotDataLocalServiceUtil.getAllPlayerShotData(playerId);
        }

        catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    /**
     * Used by the view.jsp to grab the all active shot data from the database.
     * @param request
     * @return
     */
    public static List<ESPlayerShotData> getActivePlayerShotData(RenderRequest request) {

    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
       
       long playerId = themeDisplay.getUserId();
        List<ESPlayerShotData> tempResults;

        try {
        	addGroupAndCompanyId(request);
            tempResults = ESPlayerShotDataLocalServiceUtil.getAllActivePlayerShotData(playerId, true);
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
            tempResults = ESTrialShotDataLocalServiceUtil.getAllPlayerShotData(playerId);

        }catch (SystemException ex) {
            tempResults  = Collections.emptyList();

        }

        return tempResults;

    }
    
    public static List<ESPlayerShotData> convertShotDataList(List<ESTrialShotData> list){
    	
    	List<ESPlayerShotData> newList = new ArrayList<ESPlayerShotData>(list.size());
    	
        Iterator iter = list.iterator();
        
        while (iter.hasNext()){
        	
        	ESTrialShotData shot = (ESTrialShotData) iter.next();
        	
        	ESPlayerShotData playerShot = convertShotData(shot);
        	
        	newList.add(playerShot);
        }
    	return newList;
    	
    }
    public static ESPlayerShotData convertShotData(ESTrialShotData trialShot){
    	
    	ESPlayerShotData playerShot = new ESPlayerShotDataImpl();
    	
    	playerShot.setActive(trialShot.getActive());
    	playerShot.setAmbientTemp(trialShot.getAmbientTemp());
    	playerShot.setBallAngleOfAttack(trialShot.getBallAngleOfAttack());
    	playerShot.setBallCompression(trialShot.getBallCompression());
    	playerShot.setBallSpeed(trialShot.getBallSpeed());
    	playerShot.setBallSpinRate(trialShot.getBallSpinRate());
    	playerShot.setBarPressureAlt(trialShot.getBarPressureAlt());
    	playerShot.setClubLoft(trialShot.getClubLoft());
    	playerShot.setClubSpeed(trialShot.getClubSpeed());
    	playerShot.setCompanyId(trialShot.getCompanyId());
    	playerShot.setCreateDate(trialShot.getCreateDate());
    	playerShot.setFaceAngle(trialShot.getFaceAngle());
    	playerShot.setFairwayFirmness(trialShot.getFairwayFirmness());
    	playerShot.setGroupId(trialShot.getGroupId());
    	playerShot.setLaunchAngle(trialShot.getLaunchAngle());
    	playerShot.setLaunchMonitor(trialShot.getLaunchMonitor());
    	playerShot.setModifiedDate(trialShot.getModifiedDate());
    	playerShot.setPlayerClubId(trialShot.getPlayerClubId());
    	playerShot.setPlayerId(trialShot.getPlayerId());
    	playerShot.setProductSerialNo(trialShot.getProductSerialNo());
    	playerShot.setRelativeHumid(trialShot.getRelativeHumid());
    	playerShot.setSpinAxisAngle(trialShot.getSpinAxisAngle());
    	playerShot.setSwingPath(trialShot.getSwingPath());
    	playerShot.setWindDirection(trialShot.getWindDirection());
    	playerShot.setWindSpeed(trialShot.getWindSpeed());
    	
    	return playerShot;
    	
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


    
    public static ShotData shotDataFromRequest(ActionRequest request) {

       ShotData shotData = new ShotData();

       String ballCompression = ParamUtil.getString(request, "compression");
       String fairwayFirmness = ParamUtil.getString(request, "fairway");
       
       double compression = 0.0d;
       double firmness = 0.0d;
       
       if (ballCompression.equalsIgnoreCase("low")){
    	   compression = 0.82d;
       }else if(ballCompression.equalsIgnoreCase("normal")){
    	   compression = 1.82d;
       }else if(ballCompression.equalsIgnoreCase("high")){
    	   compression = 2.82d; 
       }else {
    	   compression = 3.82d;
       }
       
       if (fairwayFirmness.equalsIgnoreCase("carry only")){
    	   firmness = 0.0d;
       }else if (fairwayFirmness.equalsIgnoreCase("normal")){
    	   firmness = 0.5d;
       }else {
    	   firmness = 0.8d;
       }
       
   	   shotData.setClubId(ParamUtil.getLong(request, "clubName"));
       shotData.setLaunchMonitor(ParamUtil.getBoolean(request, "launchMonitor"));
       shotData.setClubSpeed(ParamUtil.getDouble(request, "clubSpeed"));
       shotData.setClubLoft(ParamUtil.getDouble(request, "loft"));
       shotData.setClubFaceAngle(ParamUtil.getDouble(request,"faceAngle"));
       shotData.setClubSpinRate(ParamUtil.getDouble(request,"spinRate"));
       shotData.setClubSwingPath(ParamUtil.getDouble(request, "swingPath"));
       shotData.setBallAOA(ParamUtil.getDouble(request, "ballAOA"));
       shotData.setBallCompression(compression);
       shotData.setBallSpeed(ParamUtil.getDouble(request, "initialBallVelocity"));
       //shotData.setFairwayFirmness(firmness);
       shotData.setWindDirection(ParamUtil.getDouble(request, "windDirection"));
       shotData.setWindSpeed(ParamUtil.getDouble(request, "windSpeed"));
       shotData.set_temperature(ParamUtil.getDouble(request, "ambientTemp"));
       shotData.set_altitude(ParamUtil.getDouble(request, "barPressureAlt"));
       
       return shotData;
    }
    
    public static ShotData shotDataConverter(ESPlayerShotData playerData, Boolean member){
    	
    	ShotData shot = new ShotData();
    	
    	
    	shot.setClubLoft(playerData.getClubLoft());
    	shot.setClubSpeed(playerData.getClubSpeed());
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
    
    public static ShotData trialDataConverter(ESTrialShotData trial, Boolean member){
    	
    	ShotData shot = new ShotData();
    	
    	
    	shot.setClubLoft(trial.getClubLoft());
    	shot.setClubSpeed(trial.getClubSpeed());
		shot.setClubFaceAngle(trial.getFaceAngle());
		shot.setClubSwingPath(trial.getSwingPath());
    	shot.setLaunchMonitor(trial.getLaunchMonitor());
    	shot.set_temperature(trial.getAmbientTemp());
    	shot.set_altitude(trial.getBarPressureAlt());
    	shot.setBallAOA(trial.getBallAngleOfAttack());
    	shot.setWindSpeed(trial.getWindSpeed());
    	shot.setWindDirection(trial.getWindDirection());
    	shot.setBallSpinAxisAngle(trial.getSpinAxisAngle());

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
        	//player = new ESPlayerImpl();
        }
       
   
    	return registered;	
    }
    
    public static void addGroupAndCompanyId(RenderRequest request) throws SystemException{
    	
    	ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

    	long playerId = themeDisplay.getUserId();
    	
    	 List<ESPlayerShotData> shotDataList =
             ESPlayerShotDataLocalServiceUtil.getAllPlayerShotData(playerId);
            	
         Iterator iter = shotDataList.iterator();
         while (iter.hasNext()){
          
        	    ESPlayerShotData playerShot = (ESPlayerShotData) iter.next();
        	    
        	    if ((playerShot.getCompanyId() != 0) || (playerShot.getCompanyId() != 0)){
        	    	playerShot.setGroupId(themeDisplay.getScopeGroupId());
        	    	playerShot.setCompanyId(themeDisplay.getCompanyId());
        	    	ESPlayerShotDataLocalServiceUtil.updateESPlayerShotData(playerShot);

        	    }
                
         }

    	
    }
    
    public static String dateFormat(Date date){
    	
    	return DateFormat.getDateInstance(DateFormat.SHORT).format(date);
    }
}
