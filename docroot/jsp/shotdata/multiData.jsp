<%@page import="com.eswinggolf.player.shotdata.trajectory.model.ShotData" %>
<%@page import="com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData" %>
<%@page import="com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@page import="com.eswinggolf.player.shotdata.portlet.ShotDataValidator" %>
<%@page import="com.eswinggolf.player.shotdata.trajectory.model.TrajectoryModel" %>
<%@page import="com.eswinggolf.player.shotdata.trajectory.model.Point3D" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.eswinggolf.club.profile.portlet.ActionUtil" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page trimDirectiveWhitespaces="true" %>
<%
List<List<Point3D>> arrayPoints = new ArrayList<List<Point3D>>();
ArrayList<String> errors = new ArrayList<String>();
TrajectoryModel simulate;
long playerId = Long.parseLong(request.getParameter("playerId"));

if (Validator.isNotNull(playerId)){
 List<ESPlayerShotData> shotDataList =
         ESPlayerShotDataLocalServiceUtil.getAllPlayerShotData(playerId);

	
	Iterator iter = shotDataList.iterator();
	
	while (iter.hasNext()){
		
		
		ESPlayerShotData shotData = (ESPlayerShotData) iter.next();
		if (ShotDataValidator.validateShotData(shotData, errors)) {
    
			ShotData shot = ActionUtil.shotDataConverter(shotData, true);
			simulate = new TrajectoryModel(shot,false);
			
			arrayPoints.add(simulate.getPoints());
			
			
	
		}
		else {
			SessionErrors.add(request, "fields-required");
		}
	}
}

JSONObject obj = new JSONObject();
obj.put("points", (Object) arrayPoints.toString());
out.print(obj);
out.flush();
%>