<%@page import="com.eswinggolf.player.shotdata.trajectory.model.ShotData" %>
<%@page import="com.eswinggolf.portal.data.layer.club.model.ESClub" %>
<%@page import="com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil" %>
<%@page import="com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@page import="com.eswinggolf.player.shotdata.portlet.ShotDataValidator" %>
<%@page import="com.eswinggolf.player.shotdata.trajectory.model.TrajectoryModel" %>
<%@page import="com.eswinggolf.player.shotdata.trajectory.model.Point3D" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page trimDirectiveWhitespaces="true" %>
<%
ShotData shotData = new ShotData();
ArrayList<String> errors = new ArrayList<String>();
String ballCompression = request.getParameter("compression");
String fairwayFirmness = request.getParameter("fairway");
Date now = new Date();
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
	   firmness = firmness + 0.1d;
}else {
	   firmness = firmness + 0.15d;
}
// if(Long.parseLong(request.getParameter("clubName")) == -1) SessionErrors.add(request, "fields-required");
// System.out.println(Long.parseLong(request.getParameter("clubName")));

shotData.setFirmness(firmness);
shotData.setClubId(Long.parseLong(request.getParameter("clubName")));
shotData.setLaunchMonitor(Boolean.parseBoolean(request.getParameter("launchMonitor")));
shotData.setClubSpeed(Double.parseDouble(request.getParameter("clubSpeed")));
shotData.setClubLoft(Double.parseDouble(request.getParameter("loft")));
shotData.setClubFaceAngle(Double.parseDouble(request.getParameter("faceAngle")));
shotData.setClubSpinRate(Double.parseDouble(request.getParameter("spinRate")));
shotData.setClubSwingPath(Double.parseDouble(request.getParameter("swingPath")));
shotData.setBallAOA(Double.parseDouble(request.getParameter("angleOfAttack")));
shotData.setBallCompression(compression);
shotData.setBallSpeed(Double.parseDouble(request.getParameter("initialBallVelocity")));
shotData.setWindDirection(Double.parseDouble(request.getParameter("windDirection")));
shotData.setWindSpeed(Double.parseDouble(request.getParameter("windSpeed")));
shotData.set_temperature(Double.parseDouble(request.getParameter("ambientTemp")));
shotData.set_altitude(Double.parseDouble(request.getParameter("barPressureAlt")));
ESClub club; //= new ESClubImpl();
try {
		club = ESClubLocalServiceUtil.getESClub(shotData.getClubId());
}
catch (SystemException ex) {
    club  = new ESClubImpl();   
}	
	shotData.setClubCor(club.getCoR());
	shotData.setClubWeight(club.getWeight());
	TrajectoryModel simulate;
	List<Point3D> points = new ArrayList<Point3D>(); 
if (ShotDataValidator.validateShot(shotData, errors)) {
	simulate = new TrajectoryModel(shotData,false);
	points = simulate.getPoints();
} else {
	SessionErrors.add(request, "fields-required");
}

JSONObject obj = new JSONObject();
obj.put("points", (Object) points.toString());
out.print(obj);
out.flush();
%>